/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.6.21 : Database - kkp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kkp` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `kkp`;

/*Table structure for table `m01pega` */

DROP TABLE IF EXISTS `m01pega`;

CREATE TABLE `m01pega` (
  `m01_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nik` varchar(10) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `telepon` varchar(12) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `agama` varchar(10) DEFAULT NULL,
  `tgllahir` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tglmasuk` date DEFAULT NULL,
  `m02_id` bigint(20) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`m01_id`,`nik`),
  KEY `m02_id` (`m02_id`),
  CONSTRAINT `m02_id` FOREIGN KEY (`m02_id`) REFERENCES `m02jaba` (`m02_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m01pega` */

/*Table structure for table `m02jaba` */

DROP TABLE IF EXISTS `m02jaba`;

CREATE TABLE `m02jaba` (
  `m02_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kdjab` varchar(6) CHARACTER SET latin1 NOT NULL,
  `nmjab` varchar(20) CHARACTER SET latin1 NOT NULL,
  `keterangan` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`m02_id`,`kdjab`)
) ENGINE=InnoDB DEFAULT CHARSET=latin2;

/*Data for the table `m02jaba` */

/*Table structure for table `m03tabu` */

DROP TABLE IF EXISTS `m03tabu`;

CREATE TABLE `m03tabu` (
  `m03_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kd_tabung` varchar(5) NOT NULL,
  `jenis_tabung` varchar(20) NOT NULL,
  `harga` decimal(17,0) DEFAULT NULL,
  `keterangan` varchar(200) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`m03_id`,`kd_tabung`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m03tabu` */

/*Table structure for table `m04supl` */

DROP TABLE IF EXISTS `m04supl`;

CREATE TABLE `m04supl` (
  `m04_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kdsup` varchar(10) NOT NULL,
  `nmsup` varchar(30) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kota` varchar(100) DEFAULT NULL,
  `telp` decimal(12,0) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`m04_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m04supl` */

/*Table structure for table `m05cust` */

DROP TABLE IF EXISTS `m05cust`;

CREATE TABLE `m05cust` (
  `m05_id` bigint(20) NOT NULL,
  `kdcust` varchar(10) NOT NULL,
  `nmcust` varchar(30) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kota` varchar(100) DEFAULT NULL,
  `telp` varchar(12) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`m05_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m05cust` */

/*Table structure for table `p01peru` */

DROP TABLE IF EXISTS `p01peru`;

CREATE TABLE `p01peru` (
  `kdperu` varchar(10) NOT NULL,
  `nmperu` varchar(50) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kota` varchar(100) DEFAULT NULL,
  `telp1` decimal(12,0) DEFAULT NULL,
  `telp2` decimal(12,0) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `npwp` decimal(32,0) DEFAULT NULL,
  `kdsiup` varchar(100) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`kdperu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `p01peru` */

/*Table structure for table `t01dist` */

DROP TABLE IF EXISTS `t01dist`;

CREATE TABLE `t01dist` (
  `t01_id` bigint(20) NOT NULL,
  `tanggal` date NOT NULL,
  `tipe` int(2) NOT NULL,
  `m03_id` bigint(20) NOT NULL,
  `m04_id` bigint(20) NOT NULL,
  `m05_id` bigint(20) NOT NULL,
  `jumlah` decimal(8,0) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`t01_id`),
  KEY `m03_id` (`m03_id`),
  KEY `m04_id` (`m04_id`),
  KEY `m05_id` (`m05_id`),
  CONSTRAINT `m03_id` FOREIGN KEY (`m03_id`) REFERENCES `m03tabu` (`m03_id`),
  CONSTRAINT `m04_id` FOREIGN KEY (`m04_id`) REFERENCES `m04supl` (`m04_id`),
  CONSTRAINT `m05_id` FOREIGN KEY (`m05_id`) REFERENCES `m05cust` (`m05_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t01dist` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
