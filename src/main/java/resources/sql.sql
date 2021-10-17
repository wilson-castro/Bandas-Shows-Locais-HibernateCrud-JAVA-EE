-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: projeto
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.3

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
-- Table structure for table `bandas`
--

DROP TABLE IF EXISTS `bandas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bandas` (
  `id_banda` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `genero` varchar(255) NOT NULL,
  PRIMARY KEY (`id_banda`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bandas`
--

LOCK TABLES `bandas` WRITE;
/*!40000 ALTER TABLE `bandas` DISABLE KEYS */;
INSERT INTO `bandas` VALUES (3,'Iron Maiden','ROCK'),(4,'Queen','ROCK'),(16,'Skrillex','AXE'),(17,'Iron Maiden','FORRO'),(22,'Queen','ROCK'),(23,'Paramore','AXE');
/*!40000 ALTER TABLE `bandas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locais`
--

DROP TABLE IF EXISTS `locais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locais` (
  `id_local` int NOT NULL AUTO_INCREMENT,
  `nome_local` varchar(255) NOT NULL,
  `capacidade` int NOT NULL,
  PRIMARY KEY (`id_local`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locais`
--

LOCK TABLES `locais` WRITE;
/*!40000 ALTER TABLE `locais` DISABLE KEYS */;
INSERT INTO `locais` VALUES (1,'RJ',900),(3,'SP',500),(4,'MG',300),(5,'MG',300),(6,'MG',300),(7,'MG',300);
/*!40000 ALTER TABLE `locais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shows`
--

DROP TABLE IF EXISTS `shows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shows` (
  `id_show` int NOT NULL AUTO_INCREMENT,
  `local_id` int NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`id_show`),
  KEY `id_local` (`local_id`),
  CONSTRAINT `shows_ibfk_1` FOREIGN KEY (`local_id`) REFERENCES `locais` (`id_local`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shows`
--

LOCK TABLES `shows` WRITE;
/*!40000 ALTER TABLE `shows` DISABLE KEYS */;
INSERT INTO `shows` VALUES (2,1,'2002-12-20'),(6,1,'2022-08-02'),(7,1,'2052-08-02');
/*!40000 ALTER TABLE `shows` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showsPorBanda`
--

DROP TABLE IF EXISTS `showsPorBanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showsPorBanda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `banda_id` int NOT NULL,
  `show_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_banda` (`banda_id`),
  KEY `id_show` (`show_id`),
  CONSTRAINT `showsporbanda_ibfk_1` FOREIGN KEY (`banda_id`) REFERENCES `bandas` (`id_banda`),
  CONSTRAINT `showsporbanda_ibfk_2` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id_show`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showsPorBanda`
--

LOCK TABLES `showsPorBanda` WRITE;
/*!40000 ALTER TABLE `showsPorBanda` DISABLE KEYS */;
INSERT INTO `showsPorBanda` VALUES (2,4,2),(35,22,2),(36,22,6),(37,22,7),(38,23,2),(39,23,6),(42,3,2);
/*!40000 ALTER TABLE `showsPorBanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showsPorLocal`
--

DROP TABLE IF EXISTS `showsPorLocal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showsPorLocal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `show_id` int NOT NULL,
  `local_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_show` (`show_id`),
  KEY `id_local` (`local_id`),
  CONSTRAINT `showsporlocal_ibfk_1` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id_show`),
  CONSTRAINT `showsporlocal_ibfk_2` FOREIGN KEY (`local_id`) REFERENCES `locais` (`id_local`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showsPorLocal`
--

LOCK TABLES `showsPorLocal` WRITE;
/*!40000 ALTER TABLE `showsPorLocal` DISABLE KEYS */;
INSERT INTO `showsPorLocal` VALUES (2,2,7);
/*!40000 ALTER TABLE `showsPorLocal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-15 16:17:17
