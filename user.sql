DROP DATABASE IF EXISTS flowershop_user;

-- 创建库
create database flowershop_user default character set utf8 collate utf8_bin;

-- 切换库
use flowershop_user;

create table if not exists tb_user(
	uid int(11) primary key auto_increment,
	uname varchar(100)  null,
	account varchar(200) not null unique,
	pwd varchar(200) not null,
	sex char(1)  null,
	tel varchar(20) null unique,
	email varchar(100) null unique,
	headImg varchar(200) null,
	status char(1) not null
)auto_increment=101 engine=InnoDB default charset=utf8;


create table if not exists tb_adm(
	aid int(11) primary key auto_increment,
	account varchar(200) not null unique,
	aname varchar(100) not null,
	pwd varchar(200) not null,
	tel varchar(20) not null unique,
	headImg varchar(200) not null,
	# role=1为超级管理员否则为普通管理员
	role char(1) not null, 
	status char(1) not null
)auto_increment=101 engine=InnoDB default charset=utf8;


create table if not exists tb_address(
	aid int(11) primary key auto_increment,
	city varchar(100) not null,
	details varchar(200) not null,
	flag char(1) not null,#默认地址
	tel varchar(50) not null,
	label varchar(50) null,#标签
	nickName varchar(100) not null,#昵称
	uid int(11),
	status char(1) not null,
	constraint `tb_address_uid` foreign key(`uid`) references `tb_user`(`uid`)
)auto_increment=101 engine=InnoDB default charset=utf8;
