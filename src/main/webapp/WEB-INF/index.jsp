<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Online Chat</title>
    <link rel="stylesheet" href="../resources/style.css">
</head>
<script type="text/javascript" src="../resources/script.js" defer></script>
<body>
<h1>Online Chat</h1>
<div class = "start">
    <input type="text" class="username" placeholder="Enter your nickname">
    <button id="start">Connect</button>
</div>
<div class="chatbox">
    <div id="chat" class="chat"></div>
    <div class="chatboxpannel">
        <input type="text" name="msg" id="msg" placeholder="Enter message here"/>
        <button class="msgBtn">Enter</button>
        <button class="refreshBtn">Refresh</button>
    </div>
</div>
</body>
</html>