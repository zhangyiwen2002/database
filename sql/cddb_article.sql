-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: cddb
-- ------------------------------------------------------
-- Server version	8.0.13

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

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `content` varchar(45) DEFAULT NULL,
  `picturePath` varchar(2000) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `isprivate` int(11) NOT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId_idx` (`userId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (30,'test','test','b6bb025d-628f-4e59-8b61-42209bc2eb68.jpg;',1,0,'2022-08-09 10:19:41.675'),(31,'test','test','dca1da62-ced2-4410-b11b-c1cc36ba8f65.jpg;',1,0,'2022-08-09 10:30:38.105'),(44,'test','test','',1,0,'2022-08-09 13:35:59.146'),(45,'test','test','',1,0,'2022-08-09 13:35:59.908'),(46,'test','test','',1,0,'2022-08-09 13:36:00.532'),(47,'test','test','',1,0,'2022-08-09 13:36:01.106'),(48,'test','test','',1,0,'2022-08-09 13:36:01.465'),(49,'test','test','',1,0,'2022-08-09 13:36:01.849'),(50,'test','test','',1,0,'2022-08-09 13:36:02.273'),(51,'test','test','',1,0,'2022-08-09 13:36:02.598'),(52,'test','test','',1,0,'2022-08-09 13:36:02.983'),(53,'test','test','',1,0,'2022-08-09 13:36:03.372'),(54,'test','test','',1,0,'2022-08-09 13:36:03.731'),(55,'t','test','',1,0,'2022-08-09 14:11:55.01'),(56,'testtest','test','',1,0,'2022-08-09 14:13:07.782');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-10 20:17:26
