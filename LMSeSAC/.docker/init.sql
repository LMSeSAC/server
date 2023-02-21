CREATE DATABASE lmsesac DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use lmsesac;

CREATE TABLE user (
	id int auto_increment primary key,
    userid varchar(50) not null unique key,
    password varchar(255) not null,
    name varchar(255) not null,
    email varchar(255) not null,
    phone varchar(13) not null,
    role enum('student', 'teacher') not null,
    type enum('general', 'google', 'kakao', 'naver') not null
);

CREATE TABLE course (
	id int primary key auto_increment,
    campus enum('ydp', 'ys', 'gd', 'gc', 'dj') not null,
    category enum('app', 'web', 'iot', 'ai', 'bigdata', 'cloud', 'dt', 'fintech', 'ar') not null,
    name varchar(255) not null,
    institution varchar(255) not null,
    period varchar(255) not null,
    code varchar(255) not null
);

CREATE TABLE question (
	id int primary key auto_increment,
    user_id varchar(255) not null,
    FOREIGN KEY ( user_id ) REFERENCES user(id) ON DELETE CASCADE,
    title varchar(255) not null,
    hashtag varchar(255),
    content mediumtext not null,
    is_solved enum('0', '1') DEFAULT '0' not null,
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP
);

INSERT INTO user VALUES ('seryeong', '1234', '김세령', 'sarahkim09@naver.com', '010-1234-5678', 'student', 'general');
INSERT INTO user VALUES ('kyuri', '1234', '김규리', 'lmsesac@gmail.com', '010-1234-5678', 'teacher', 'general');