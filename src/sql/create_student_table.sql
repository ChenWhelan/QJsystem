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
insert into `student` (`id`, `name`, `password`, `college`, `subject`, `phone`, `number`) values('20001','С��','20001','��������������ѧԺ','�������ѧ�뼼��1��','123456789','2');
insert into `student` (`id`, `name`, `password`, `college`, `subject`, `phone`, `number`) values('20002','С��','20002','��������������ѧԺ','�������3��','987654321','1');
