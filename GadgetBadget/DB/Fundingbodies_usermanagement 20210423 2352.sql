-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.13-MariaDB


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema test
--

CREATE DATABASE IF NOT EXISTS test;
USE test;

--
-- Definition of table `funding_bodies`
--

DROP TABLE IF EXISTS `funding_bodies`;
CREATE TABLE `funding_bodies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `field` varchar(45) DEFAULT NULL,
  `ranges` varchar(45) DEFAULT NULL,
  `published_date` varchar(45) NOT NULL,
  `published_time` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `funding_bodies`
--

/*!40000 ALTER TABLE `funding_bodies` DISABLE KEYS */;
INSERT INTO `funding_bodies` (`id`,`name`,`field`,`ranges`,`published_date`,`published_time`) VALUES 
 (1,'name1','ftes12','Range12','2021-04-23','23:01:32.821'),
 (2,'12name1','f21tes12','Ran21ge12','2021-04-23','23:01:46.846'),
 (3,'name','ftest','Range','2021-04-23','23:01:03.318');
/*!40000 ALTER TABLE `funding_bodies` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `published_date` varchar(45) DEFAULT NULL,
  `published_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduser`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`iduser`,`username`,`password`,`published_date`,`published_time`) VALUES 
 (2,'Tharindu','T1234','2021-04-23','22:58:55.418'),
 (3,'Dinesh','T1234Dinesh','2021-04-23','22:59:19.642'),
 (4,'Lasandu','LsRar','2021-04-23','22:59:48.347');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
