-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: aia.cedoxb9y9mdk.ap-northeast-2.rds.amazonaws.com    Database: project
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `iidx` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `price` int(7) NOT NULL,
  `count_m` int(2) NOT NULL,
  `count_w` int(2) NOT NULL,
  `regdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `receive` datetime NOT NULL,
  `addr` varchar(50) NOT NULL,
  `location` varchar(200) NOT NULL,
  `content` varchar(400) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `state` int(1) NOT NULL,
  `view_count` int(5) NOT NULL DEFAULT '0',
  `group` int(1) NOT NULL,
  `midx` int(5) NOT NULL,
  PRIMARY KEY (`iidx`),
  KEY `midx_idx` (`midx`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'수박 가치사요 선착순 3명 8282 모이세',5000,3,0,'2020-08-13 10:01:38','2020-08-21 13:00:00','서울시 종로구 종로1가 53','로케이션','8282 오세요','default.jpg',0,0,0,1),(2,'수박 가치사요 선착순 3명 8282 모이세',5000,3,0,'2020-08-13 10:02:03','2020-08-21 13:00:00','서울시 종로구 종로1가 53','로케이션','8282 오세요','default.jpg',0,0,0,1),(3,'수박 가치사요 선착순 3명 8282 모이세',5000,3,0,'2020-08-13 10:03:05','2020-08-21 13:00:00','서울시 종로구 종로1가 53','로케이션','8282 오세요','default.jpg',0,0,0,1),(4,'수박 가치사요 선착순 3명 8282 모이세',5000,3,0,'2020-08-13 10:07:48','2020-08-21 13:00:00','서울시 종로구 종로1가 53','로케이션','8282 오세요','default.jpg',0,0,0,1),(5,'복숭아 가치사요 선착순 3명 8282 모이세',5000,3,0,'2020-08-13 10:29:41','2020-08-21 13:00:00','서울시 종로구 종로1가 53','로케이션','8282 오세요','default.jpg',0,0,0,1),(6,'복숭아 가치사요 선착순 3명 8282 모이세',5000,3,6,'2020-08-13 10:29:51','2020-08-21 13:00:00','서울시 종로구 종로1가 53','로케이션','8282 오세요','default.jpg',0,0,0,1),(7,'포도 가치사요 선착순 6명 8282 모이세여',3000,6,12,'2020-08-13 10:54:08','2020-08-31 17:30:00','서울시 종로구 종로1가 53','좌아표','8282 오세요','default.jpg',0,0,0,1),(8,'메론 가치사요 선착순 10명 8282 모이세여',10000,5,10,'2020-08-13 10:55:06','2020-08-19 18:30:00','서울시 종로구 종로1가 53','좌아표','냉무','default.jpg',1,0,0,1),(9,'메론 가치사요 선착순 10명 8282 모이세여',10000,10,20,'2020-08-13 11:25:15','2020-08-19 18:30:00','서울시 종로구 종로1가 53','좌아표','냉무','default.jpg',0,0,0,1);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-14 10:12:45
