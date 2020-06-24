/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.45-log : Database - car_user
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`car_user` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `car_user`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `account` varchar(30) NOT NULL COMMENT '账号',
  `user_name` varchar(30) NOT NULL COMMENT '名称',
  `password` varchar(30) NOT NULL COMMENT '密码',
  `user_picture` varchar(30) DEFAULT NULL COMMENT '头像地址',
  `sex` int(11) DEFAULT NULL COMMENT '性别（0代表女，1代表男）',
  `signature` varchar(30) DEFAULT NULL COMMENT '个性签名',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `phone` int(11) DEFAULT NULL COMMENT '手机号',
  `gmt_creat` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modifle` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`account`,`user_name`,`password`,`user_picture`,`sex`,`signature`,`email`,`phone`,`gmt_creat`,`gmt_modifle`) values (1,'1','1','1','1',NULL,NULL,NULL,NULL,'2020-06-17 16:35:10','2020-06-17 16:35:10');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
