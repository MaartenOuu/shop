/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.45-log : Database - usedcarshop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`usedcarshop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `usedcarshop`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `car_id` int(11) NOT NULL COMMENT '对应汽车id',
  `title` varchar(30) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `gmt_creat` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `view_count` int(11) DEFAULT NULL COMMENT '查看次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `article` */

insert  into `article`(`id`,`car_id`,`title`,`content`,`gmt_creat`,`view_count`) values (1,1,'大师点','爱上大叔大所大所','2020-06-24 14:45:38',NULL),(2,1,'唉都是大所大','爱上大叔大所大所大所大所','2020-06-24 15:06:21',NULL);

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `b_m_id` int(11) NOT NULL COMMENT '菜单id',
  `brand_name` varchar(30) NOT NULL COMMENT '品牌名称',
  `brand_picture` varchar(30) NOT NULL COMMENT '品牌名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `brand` */

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `car_name` varchar(30) NOT NULL COMMENT '汽车名称',
  `car_picture` varchar(30) NOT NULL COMMENT '汽车图片地址',
  `price` int(11) DEFAULT NULL COMMENT '售价',
  `age` datetime NOT NULL COMMENT '年限',
  `brand` int(11) NOT NULL COMMENT '品牌',
  `type` int(11) NOT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `car` */

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `menu` varchar(30) NOT NULL COMMENT '菜单名称',
  `gid` int(11) DEFAULT NULL COMMENT '父级菜单',
  `sid` int(11) DEFAULT NULL COMMENT '子级菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`id`,`menu`,`gid`,`sid`) values (1,'测试',NULL,NULL);

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `t_m_id` int(11) NOT NULL COMMENT '菜单id',
  `type_name` varchar(30) NOT NULL COMMENT '类型名称',
  `type_picture` varchar(30) NOT NULL COMMENT '类型图片地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `type` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
