-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: ecobike
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `bike`
--

DROP TABLE IF EXISTS `bike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bike` (
  `bikeID` int NOT NULL,
  `type` varchar(50) NOT NULL,
  `numSaddle` int NOT NULL,
  `numPedal` int NOT NULL,
  `numSeat` int NOT NULL,
  `remainBattery` float DEFAULT NULL,
  `maxTime` float DEFAULT NULL,
  `inUse` int NOT NULL,
  `value` int NOT NULL,
  `licensePlate` varchar(50) NOT NULL,
  `DockID` char(15) DEFAULT NULL,
  PRIMARY KEY (`bikeID`),
  KEY `DockID` (`DockID`),
  CONSTRAINT `DockID` FOREIGN KEY (`DockID`) REFERENCES `dock` (`dockID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike`
--

LOCK TABLES `bike` WRITE;
/*!40000 ALTER TABLE `bike` DISABLE KEYS */;
INSERT INTO `bike` VALUES (2001,'Xe đạp đơn',1,2,1,NULL,NULL,0,1000000,'DCV-001','DCV'),(2002,'Xe đạp đôi',2,4,1,NULL,NULL,0,1375000,'DCV-002','DCV'),(2003,'Xe đạp điện',1,0,1,92.1,60,0,1750000,'DCV-003','DCV'),(2004,'Xe đạp đơn',1,2,1,NULL,NULL,0,1000000,'LTN-001','LTN'),(2005,'Xe đạp đôi',2,4,1,NULL,NULL,0,1375000,'LTN-002','LTN'),(2006,'Xe đạp điện',1,0,1,92.1,60,0,1750000,'LTN-003','LTN'),(2007,'Xe đạp đơn',1,2,1,NULL,NULL,0,1000000,'TDN-001','TDN'),(2008,'Xe đạp đôi',2,4,1,NULL,NULL,0,1375000,'TDN-002','TDN'),(2009,'Xe đạp điện',1,0,1,92.1,60,0,1750000,'TDN-003','TDN'),(6187,'Xe đạp đôi',2,4,1,NULL,NULL,0,2000000,'TDN-061','TDN');
/*!40000 ALTER TABLE `bike` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creditcard` (
  `cardcode` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `owner` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `cvv` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `expireddate` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `remain` int NOT NULL,
  PRIMARY KEY (`cardcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
INSERT INTO `creditcard` VALUES ('kstn','Group 7','6187','1234',100000000);
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dock`
--

DROP TABLE IF EXISTS `dock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dock` (
  `dockID` char(15) NOT NULL,
  `name` varchar(50) NOT NULL,
  `area` varchar(50) NOT NULL,
  `address` varchar(60) NOT NULL,
  `remainCapacity` int NOT NULL,
  `maximumCapacity` int NOT NULL,
  PRIMARY KEY (`dockID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dock`
--

LOCK TABLES `dock` WRITE;
/*!40000 ALTER TABLE `dock` DISABLE KEYS */;
INSERT INTO `dock` VALUES ('DCV','Đại Cồ Việt','Hà Nội','Số 1 Đại Cồ Việt',37,30),('LTN','Lê Thanh Nghị','Hà Nội','88 Lê Thanh Nghị',35,30),('TDN','Trần Đại Nghĩa','Hà Nội','61 Trần Đại Nghĩa',27,30);
/*!40000 ALTER TABLE `dock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymenttransaction`
--

DROP TABLE IF EXISTS `paymenttransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paymenttransaction` (
  `ID` int NOT NULL,
  `owner` varchar(50) NOT NULL,
  `transactionContent` varchar(50) NOT NULL,
  `rentalCode` varchar(50) NOT NULL,
  `cardCode` varchar(50) NOT NULL,
  `amount` int NOT NULL,
  `time` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `rentalCode` (`rentalCode`),
  CONSTRAINT `rentalCode` FOREIGN KEY (`rentalCode`) REFERENCES `rentbikeinvoice` (`rentalCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymenttransaction`
--

LOCK TABLES `paymenttransaction` WRITE;
/*!40000 ALTER TABLE `paymenttransaction` DISABLE KEYS */;
INSERT INTO `paymenttransaction` VALUES (200100,'Group 7','Rent bike','20010','kstn',-400000,'2023-02-11 13:58:36'),(200101,'Group 7','Return bike','20010','kstn',390000,'2023-02-11 13:58:55'),(200200,'Group 7','Rent bike','20020','kstn',-550000,'2023-02-12 16:17:19'),(200300,'Group 7','Rent bike','20030','kstn',-700000,'2023-02-12 16:25:15'),(200301,'Group 7','Return bike','20030','kstn',685000,'2023-02-12 16:36:23'),(200400,'Group7','Rent bike','20040','kstn',-400000,'2023-02-12 16:26:11'),(200401,'Group 7','Return bike','20040','kstn',381000,'2023-02-12 17:39:05'),(200500,'Group 7','Rent bike','20050','kstn',-550000,'2023-02-12 16:27:28'),(200501,'Group 7','Return bike','20050','kstn',449500,'2023-02-12 21:30:32'),(200600,'Group 7','Rent bike','20060','kstn',-700000,'2023-02-12 16:59:16'),(200700,'Group 7','Rent bike','20070','kstn',-400000,'2023-02-12 17:49:43'),(200800,'Group 7','Rent bike','20080','kstn',-550000,'2023-02-12 17:51:58'),(200801,'Group 7','Return bike','20080','kstn',535000,'2023-02-12 17:52:55');
/*!40000 ALTER TABLE `paymenttransaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentbikeinvoice`
--

DROP TABLE IF EXISTS `rentbikeinvoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rentbikeinvoice` (
  `rentalCode` varchar(50) NOT NULL,
  `bikeID` int NOT NULL,
  `type` varchar(50) NOT NULL,
  `rentBikeCost` int NOT NULL,
  `owner` varchar(50) NOT NULL,
  `rentTime` varchar(50) NOT NULL,
  `returnTime` varchar(50) DEFAULT NULL,
  `deposit` int DEFAULT NULL,
  PRIMARY KEY (`rentalCode`),
  KEY `bikeID` (`bikeID`),
  CONSTRAINT `bikeID` FOREIGN KEY (`bikeID`) REFERENCES `bike` (`bikeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentbikeinvoice`
--

LOCK TABLES `rentbikeinvoice` WRITE;
/*!40000 ALTER TABLE `rentbikeinvoice` DISABLE KEYS */;
INSERT INTO `rentbikeinvoice` VALUES ('20010',2001,'Xe đạp đơn',343000,'Group 7','2023-02-11 13:58:36','2023-02-12 18:07:39',400000),('20020',2002,'Xe đạp đôi',0,'Group 7','2023-02-12 16:17:19','null',550000),('20030',2003,'Xe đạp điện',15000,'Group 7','2023-02-12 16:25:15','2023-02-12 16:36:23',700000),('20040',2004,'Xe đạp đơn',22000,'Group7','2023-02-12 16:26:11','2023-02-12 17:44:40',400000),('20050',2005,'Xe đạp đôi',100500,'Group 7','2023-02-12 16:27:28','2023-02-12 21:30:32',550000),('20060',2006,'Xe đạp điện',0,'Group 7','2023-02-12 16:59:16','null',700000),('20070',2007,'Xe đạp đơn',0,'Group 7','2023-02-12 17:49:43','null',400000),('20080',2008,'Xe đạp đôi',15000,'Group 7','2023-02-12 17:51:58','2023-02-12 17:52:55',550000);
/*!40000 ALTER TABLE `rentbikeinvoice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-13  8:45:05
