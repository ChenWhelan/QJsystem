/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.26 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;
use QJXT;
create table `teacher` (
	`id` varchar (30)PRIMARY KEY,
	`name` varchar (30),
	`passw` varchar (60)
); 
insert into `teacher` (`id`, `name`, `passw`) values('10001','张三','10001');
insert into `teacher` (`id`, `name`, `passw`) values('10002','李四','10002');
