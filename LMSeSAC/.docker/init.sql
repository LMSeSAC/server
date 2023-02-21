create table campus (
	id integer not null auto_increment, 
	campus varchar(20) not null, 
	location varchar(100) not null, 
	primary key (id)
) engine=InnoDB

create table course (
	id integer not null auto_increment, 
	category varchar(20) not null, 
	code varchar(20) not null, 
	end_date date not null, 
	name varchar(20) not null, 
	start_date date not null, 
	campus_id integer, 
	institution_id integer, 
	primary key (id)
) engine=InnoDB

create table institution (
	id integer not null auto_increment, 
	code varchar(20) not null, 
	location varchar(50) not null, 
	name varchar(50) not null, 
	primary key (id)
) engine=InnoDB

create table user (
	id integer not null auto_increment, 
	create_at datetime(6), 
	email varchar(100) not null, 
	name varchar(20) not null, 
	password varchar(255) not null, 
	phone varchar(13) not null, 
	role varchar(255) not null, 
	type varchar(255) not null, 
	userid varchar(50) not null,
	is_admin varchar(1) default 'F'
	primary key (id)
) engine=InnoDB

create table courseuser (
	id integer not null auto_increment, 
	create_at datetime(6), 
	course_id integer, 
	user_id integer, 
	primary key (id)
) engine=InnoDB

alter table course add constraint FKibyj3lqcivw0tn3a8y29s3rs6 foreign key (campus_id) references campus (id)
alter table course add constraint FKeia6xjuespxibcj584q9k69b1 foreign key (institution_id) references institution (id)
alter table courseuser add constraint FKhbnt9181wb21t8wuejac4b028 foreign key (course_id) references course (id)
alter table courseuser add constraint FKbn8sdip58n8oa3svjs42dtx42 foreign key (user_id) references user (id)
