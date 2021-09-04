let wsUrl;
if (window.location.protocol == 'http:') {
    wsUrl = 'ws://';
} else {
    wsUrl = 'wss://';
}

    window.addEventListener("load", e=>chatUnit.init());


let chatUnit = {
    init() {
        this.startbox = document.querySelector(".start");
        this.chatbox = document.querySelector(".chatbox");
        this.startBtn = this.startbox.querySelector("button");
        this.nameInput = this.startbox.querySelector(".username");
        this.chatboxpannel = this.chatbox.querySelector(".chatboxpannel");
        this.msgBtn = this.chatboxpannel.querySelector(".msgBtn");
        this.refreshBtn = this.chatboxpannel.querySelector(".refreshBtn");

        this.bindEvents();
    },
    bindEvents() {
        this.startBtn.addEventListener("click", e =>this.openWindowSock())
        this.msgBtn.addEventListener("click", e =>this.send())
        this.refreshBtn.addEventListener("click", e=>this.refresh())
    },

    send() {
        this.sendMessage({
            userName:this.name,
            text:document.getElementById("msg").value
        },
        document.getElementById("msg").value = "")
    },

    refresh(){
        let mySpan = document.getElementById("chat");
        mySpan.innerHTML = "";
    },
    openWindowSock() {

        this.ws = new WebSocket(wsUrl + window.location.host + "/onlinechat");
        this.ws.onopen = (e)=>this.onOpenSock(JSON.parse(e.data));
        this.ws.onmessage = (e)=>this.onMessage(JSON.parse(e.data));
        this.ws.onclose = (e)=>this.onClose();
        this.startbox.style.display = "none";
        this.chatbox.style.display = "block";
        this.name = this.nameInput.value;
    },
    onOpenSock(msg) {
        let mySpan = document.getElementById("chat");
        mySpan.innerHTML+=msg.userName+": " + msg.text+"<br/>";
    },

    onMessage(msg) {
        let mySpan = document.getElementById("chat");
        mySpan.innerHTML+=msg.userName+": " + msg.text+"<br/>";
    },

    onClose() {
    },
    sendMessage(msg) {
        this.ws.send(JSON.stringify(msg));
    }
}