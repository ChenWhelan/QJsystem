/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.26 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;
use QJXT;
create table `qingjia` (
	`id` varchar (60) PRIMARY KEY,
	`sname` varchar (30),
	`phone` varchar (60),
	`day` varchar (60),
	`start` varchar (60),
	`end` varchar (60),
	`reason` varchar (300),
	`tname` varchar (30),
	`result` varchar (30)
); 
insert into `qingjia` (`id`, `sname`, `phone`, `day`, `start`, `end`, `reason`, `tname`, `result`) values('20001','小明','123456789','1','2021-12-13','2021-12-14','回家看病','张三','未审核');
insert into `qingjia` (`id`, `sname`, `phone`, `day`, `start`, `end`, `reason`, `tname`, `result`) values('20002','小红','987654321','2','2021-12-01','2021-12-02','外出考试','张三','未审核');
