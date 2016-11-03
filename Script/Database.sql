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
  `kdjab` varchar(6) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`m01_id`,`nik`),
  UNIQUE KEY `nik` (`nik`),
  KEY `kdjab` (`kdjab`),
  CONSTRAINT `m01pega_ibfk_1` FOREIGN KEY (`kdjab`) REFERENCES `m02jaba` (`kdjab`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `m01pega` */

insert  into `m01pega`(`m01_id`,`nik`,`nama`,`username`,`password`,`gender`,`status`,`telepon`,`alamat`,`agama`,`tgllahir`,`email`,`tglmasuk`,`kdjab`,`version`,`created_by`,`created_on`,`updated_by`,`updated_on`) values (1,'A001','Admin','a','a','L','a','0873465837','admin','admin',NULL,NULL,NULL,'admin',NULL,NULL,NULL,NULL,NULL);

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
  PRIMARY KEY (`m02_id`,`kdjab`),
  UNIQUE KEY `kdjab` (`kdjab`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin2;

/*Data for the table `m02jaba` */

insert  into `m02jaba`(`m02_id`,`kdjab`,`nmjab`,`keterangan`,`version`,`created_by`,`created_on`,`updated_by`,`updated_on`) values (1,'admin','admin','admin',NULL,NULL,NULL,NULL,NULL);

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
  PRIMARY KEY (`m03_id`,`kd_tabung`),
  UNIQUE KEY `kd_tabung` (`kd_tabung`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `m03tabu` */

insert  into `m03tabu`(`m03_id`,`kd_tabung`,`jenis_tabung`,`harga`,`keterangan`,`version`,`created_by`,`created_on`,`updated_by`,`updated_on`) values (1,'T001','3 Kilogram','15000',NULL,NULL,NULL,NULL,NULL,NULL);

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
  PRIMARY KEY (`m04_id`,`kdsup`),
  UNIQUE KEY `kdsup` (`kdsup`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `m04supl` */

insert  into `m04supl`(`m04_id`,`kdsup`,`nmsup`,`alamat`,`kota`,`telp`,`keterangan`,`version`,`created_by`,`created_on`,`updated_by`,`updated_on`) values (1,'S01','PT PERTAMINA Tbk.',NULL,'Jakarta',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `m05cust` */

DROP TABLE IF EXISTS `m05cust`;

CREATE TABLE `m05cust` (
  `m05_id` bigint(20) NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`m05_id`,`kdcust`),
  UNIQUE KEY `kdcust` (`kdcust`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `m05cust` */

insert  into `m05cust`(`m05_id`,`kdcust`,`nmcust`,`alamat`,`kota`,`telp`,`keterangan`,`version`,`created_by`,`created_on`,`updated_by`,`updated_on`) values (1,'C001','PT AKSI','Jakarta','Jakarta','0852880000','Tidak ada keterangan',NULL,NULL,NULL,NULL,NULL),(3,'C002','PT ABU','Buaran','Jakarta','09375029384','tanpa keterangan',NULL,NULL,NULL,NULL,NULL),(4,'C003','PT SRIHADI','Bogor','Bogor','0813587463','Bogor punya',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `p01peru` */

DROP TABLE IF EXISTS `p01peru`;

CREATE TABLE `p01peru` (
  `kdperu` varchar(10) NOT NULL,
  `nmperu` varchar(50) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kota` varchar(100) DEFAULT NULL,
  `telp1` varchar(12) DEFAULT NULL,
  `telp2` varchar(12) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `npwp` decimal(32,0) DEFAULT NULL,
  `kdsiup` varchar(100) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`kdperu`),
  UNIQUE KEY `kdperu` (`kdperu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `p01peru` */

insert  into `p01peru`(`kdperu`,`nmperu`,`alamat`,`kota`,`telp1`,`telp2`,`email`,`npwp`,`kdsiup`,`version`,`created_by`,`created_on`,`updated_by`,`updated_on`) values ('01','PT SARANA EKA PAKSI','Bogor','Bogor','86543476','8736574','saranaekapaksi@gmail.com','7624576354765700000','76354763',1,NULL,NULL,NULL,NULL);

/*Table structure for table `t01jual` */

DROP TABLE IF EXISTS `t01jual`;

CREATE TABLE `t01jual` (
  `t01_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tanggal` date NOT NULL,
  `kd_tabung` varchar(5) NOT NULL,
  `kdcust` varchar(10) NOT NULL,
  `jumlah` int(17) NOT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`t01_id`),
  KEY `kd_tabung` (`kd_tabung`),
  KEY `kdcust` (`kdcust`),
  CONSTRAINT `t01jual_ibfk_1` FOREIGN KEY (`kd_tabung`) REFERENCES `m03tabu` (`kd_tabung`),
  CONSTRAINT `t01jual_ibfk_2` FOREIGN KEY (`kdcust`) REFERENCES `m05cust` (`kdcust`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t01jual` */

/*Table structure for table `t02beli` */

DROP TABLE IF EXISTS `t02beli`;

CREATE TABLE `t02beli` (
  `t02_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tanggal` date NOT NULL,
  `kd_tabung` varchar(5) NOT NULL,
  `kdsupl` varchar(10) NOT NULL,
  `jumlah` int(17) NOT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`t02_id`),
  KEY `kd_tabung` (`kd_tabung`),
  KEY `kdsupl` (`kdsupl`),
  CONSTRAINT `t02beli_ibfk_1` FOREIGN KEY (`kd_tabung`) REFERENCES `m03tabu` (`kd_tabung`),
  CONSTRAINT `t02beli_ibfk_2` FOREIGN KEY (`kdsupl`) REFERENCES `m04supl` (`kdsup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t02beli` */

/*Table structure for table `t03stok` */

DROP TABLE IF EXISTS `t03stok`;

CREATE TABLE `t03stok` (
  `t03_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tanggal` date NOT NULL,
  `kd_tabung` varchar(5) NOT NULL,
  `jumlah` int(17) NOT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`t03_id`),
  KEY `kd_tabung` (`kd_tabung`),
  CONSTRAINT `t03stok_ibfk_1` FOREIGN KEY (`kd_tabung`) REFERENCES `m03tabu` (`kd_tabung`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t03stok` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
