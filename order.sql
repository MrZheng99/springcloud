DROP DATABASE IF EXISTS flowershop_order;

-- 创建库
create database flowershop_order default character set utf8 collate utf8_bin;

-- 切换库
use flowershop_order;

-- ----------------------------
-- Table structure for `orderinfo`
-- ----------------------------
create table if not exists tb_order(
	oid bigint primary key,
	createDate date not null,#创建时间
	receiveDate date null,#收货时间
	payDate date null,#付款时间
	sendDate date null,#发货时间
	amount decimal(7,2) not null,
	address varchar(255) null,
	receivePerson varchar(255) null,#收货人
	flag char(1) not null,
	tel varchar(255) null,
	uid int(11) not null,#会员编号
	status char(1) not null
)engine=InnoDB default charset=utf8;

-- ----------------------------
-- Table structure for `tb_order_details`
-- ----------------------------
create table if not exists tb_order_details(
	odid int(11) primary key auto_increment,
	num varchar(10) not null,
	fname varchar(255) not null,
	price decimal(7,2) not null,
	sale varchar(3),
	intro varchar(255),
	flowerFirstImg varchar(255),
	oid bigint not null,
	fid int(11) not null,
	constraint `fk_order_details_oid` foreign key(`oid`) references `tb_order`(`oid`),
	status char(1) not null
)auto_increment=101 engine=InnoDB default charset=utf8;
