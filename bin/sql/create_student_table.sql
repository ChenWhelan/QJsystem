/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.26 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;
use QJXT;
create table `student` (
	`id` varchar (30) PRIMARY KEY,
	`name` varchar (30),
	`password` varchar (60),
	`college` varchar (150),
	`subject` varchar (150),
	`phone` varchar (60),
	`number` varchar (30)
); 
insert into `student` (`id`, `name`, `password`, `college`, `subject`, `phone`, `number`) values('20001','小明','20001','电气与计算机工程学院','计算机科学与技术1班','123456789','2');
insert into `student` (`id`, `name`, `password`, `college`, `subject`, `phone`, `number`) values('20002','小红','20002','电气与计算机工程学院','软件工程3班','987654321','1');
