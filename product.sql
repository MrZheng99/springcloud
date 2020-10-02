DROP DATABASE IF EXISTS flowershop_product;

-- 创建库
create database flowershop_product default character set utf8 collate utf8_bin;

-- 切换库
use flowershop_product;

# 种类
create table if not exists tb_type(
	tid int(11) primary key auto_increment,
	tname varchar(100) not null,
	description varchar(255) null,
	typeImg  varchar(200) not null,
	status char(1) not null
)auto_increment=101 engine=InnoDB default charset=utf8;
# 花系
create table if not exists tb_series(
	sid int(11) primary key auto_increment,
	sname varchar(100) not null,
	status char(1) not null
)auto_increment=101 engine=InnoDB default charset=utf8;

create table if not exists tb_flower(
	fid int(11) primary key auto_increment,
	fname varchar(100) not null,
	description text not null,
	flowerLan varchar(500) not null,#花语
	deliveryDesc varchar(100) not null, #配送说明
	price decimal(6,2) not null,
	flowerImg varchar(200) not null,
	intro varchar(255) null, # 简述
	pack varchar(255) null, # 包装
	sale varchar(3) not null, # 折扣
	store varchar(5) not null,
	tid int(11) not null,
	sid int(11) null, 
	status char(1) not null,
	constraint `fk_flower_tid` foreign key(`tid`) references `tb_type`(`tid`),
	constraint `fk_flower_sid` foreign key(`sid`) references `tb_series`(`sid`)
)auto_increment=101 engine=InnoDB default charset=utf8;




