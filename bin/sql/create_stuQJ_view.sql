/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.26 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;
use QJXT;
create view stuQJ
as select id,sname,phone,day,start,end,reason
from qingjia;