DROP TABLE IF EXISTS messages;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE messages
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    text      TEXT                              NOT NULL,
    user_name VARCHAR(255)                      NOT NULL,
    date_time TIMESTAMP           DEFAULT now() NOT NULL
);