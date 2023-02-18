USE lmsesac;
ALTER DATABASE lmsesac default charset=utf8 collate utf8_general_ci; 

CREATE TABLE user (
	id int auto_increment primary key,
	userid varchar(50) not null,
    password varchar(255) not null,
    name varchar(20) not null,
    email varchar(100) not null,
    phone varchar(13) not null,
    role enum('student', 'teacher') not null,
    type enum('general', 'google', 'kakao', 'naver') not null,
    createdAt datetime CURRENT_TIMESTAMP
);

CREATE TABLE course (
	id int primary key auto_increment,
    category enum('app', 'web', 'iot', 'ai', 'bigdata', 'cloud', 'dt', 'fintech', 'ar') not null,
    name varchar(255) not null,
    startDate date not null,
    endDate date not null,
    code varchar(255) not null
);

INSERT INTO user VALUES ('seryeong', '1234', '김세령', 'sarahkim09@naver.com', '010-1234-5678', 'student', 'general');
INSERT INTO user VALUES ('kyuri', '1234', '김규리', 'lmsesac@gmail.com', '010-1234-5678', 'teacher', 'general');