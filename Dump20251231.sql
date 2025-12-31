CREATE DATABASE  IF NOT EXISTS `gearrent_pro` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gearrent_pro`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: gearrent_pro
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `branches`
--

DROP TABLE IF EXISTS `branches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branches` (
  `branch_id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `address` text,
  `contact_no` varchar(20) DEFAULT NULL,
  `status` enum('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
  PRIMARY KEY (`branch_id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branches`
--

LOCK TABLES `branches` WRITE;
/*!40000 ALTER TABLE `branches` DISABLE KEYS */;
INSERT INTO `branches` VALUES (1,'PAN','Panadura Branch','Panadura, Sri Lanka','038-2233445','ACTIVE'),(2,'GAL','Galle Branch','Galle, Sri Lanka','091-2233445','ACTIVE'),(3,'COL','Colombo Branch','Colombo 03, Sri Lanka','011-2233445','ACTIVE');
/*!40000 ALTER TABLE `branches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` text,
  `base_price_factor` decimal(5,2) DEFAULT NULL,
  `weekend_multiplier` decimal(5,2) DEFAULT NULL,
  `late_fee_per_day` decimal(10,2) DEFAULT NULL,
  `active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Camera','Professional Cameras',1.00,1.20,1500.00,1),(2,'Lens','Camera Lenses',0.80,1.10,1000.00,1),(3,'Drone','Aerial Drones',1.50,1.30,3000.00,1),(4,'Lighting','Lighting Equipment',0.90,1.10,1200.00,1),(5,'Audio','Audio Recording Equipment',0.70,1.00,800.00,1);
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `nic_passport` varchar(50) DEFAULT NULL,
  `contact_no` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` text,
  `membership_id` int DEFAULT NULL,
  `deposit_limit` decimal(12,2) DEFAULT '500000.00',
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `nic_passport` (`nic_passport`),
  KEY `membership_id` (`membership_id`),
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`membership_id`) REFERENCES `membership` (`membership_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Nimal Perera','901234567V','0771112233','nimal@gmail.com','Panadura',1,500000.00),(2,'Kamal Silva','881234567V','0772223344','kamal@gmail.com','Galle',2,500000.00),(3,'Sunil Fernando','791234567V','0773334455','sunil@gmail.com','Colombo',3,500000.00),(4,'Amali Perera','925678901V','0774445566','amali@gmail.com','Kalutara',2,500000.00),(5,'Ruwan Jayasinghe','851234789V','0775556677','ruwan@gmail.com','Matara',1,500000.00),(6,'Shehani Silva','936789012V','0776667788','shehani@gmail.com','Negombo',3,500000.00),(7,'Ishara Perera','947890123V','0777778899','ishara@gmail.com','Panadura',1,500000.00),(8,'Chathura Gunasekara','897654321V','0778889900','chathura@gmail.com','Galle',2,500000.00),(9,'Sanduni Wickramasinghe','917654321V','0779990011','sanduni@gmail.com','Colombo',3,500000.00),(10,'Naveen Adeesha','956789012V','0729141500','naveenadeesha2005@gmail.com','Bentota',1,500000.00);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `damages`
--

DROP TABLE IF EXISTS `damages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `damages` (
  `damage_id` int NOT NULL AUTO_INCREMENT,
  `rental_id` int DEFAULT NULL,
  `description` text,
  `charge` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`damage_id`),
  KEY `rental_id` (`rental_id`),
  CONSTRAINT `damages_ibfk_1` FOREIGN KEY (`rental_id`) REFERENCES `rentals` (`rental_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `damages`
--

LOCK TABLES `damages` WRITE;
/*!40000 ALTER TABLE `damages` DISABLE KEYS */;
INSERT INTO `damages` VALUES (1,1,'Minor scratch on camera body',5000.00);
/*!40000 ALTER TABLE `damages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipment` (
  `equipment_id` int NOT NULL AUTO_INCREMENT,
  `category_id` int DEFAULT NULL,
  `branch_id` int DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `purchase_year` int DEFAULT NULL,
  `base_daily_price` decimal(10,2) DEFAULT NULL,
  `deposit_amount` decimal(10,2) DEFAULT NULL,
  `status` enum('AVAILABLE','RESERVED','RENTED','MAINTENANCE') DEFAULT NULL,
  PRIMARY KEY (`equipment_id`),
  KEY `category_id` (`category_id`),
  KEY `branch_id` (`branch_id`),
  CONSTRAINT `equipment_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`),
  CONSTRAINT `equipment_ibfk_2` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES (1,1,1,'Canon','EOS R5',2022,8000.00,50000.00,'AVAILABLE'),(2,1,1,'Sony','A7 IV',2023,7500.00,50000.00,'RENTED'),(3,2,1,'Canon','RF 24-70',2021,4000.00,30000.00,'AVAILABLE'),(4,3,1,'DJI','Mavic Air 2',2022,12000.00,80000.00,'RENTED'),(5,4,1,'Godox','SL60W',2020,3000.00,20000.00,'AVAILABLE'),(6,5,1,'Rode','NTG4+',2021,2500.00,15000.00,'AVAILABLE'),(7,1,2,'Nikon','Z6 II',2022,7000.00,45000.00,'AVAILABLE'),(8,2,2,'Sony','FE 70-200',2021,4500.00,30000.00,'AVAILABLE'),(9,3,2,'DJI','Mini 3 Pro',2023,10000.00,70000.00,'RENTED'),(10,4,2,'Aputure','Light Dome',2020,3500.00,25000.00,'AVAILABLE'),(11,5,2,'Zoom','H6',2021,3000.00,20000.00,'AVAILABLE'),(12,1,3,'Panasonic','GH6',2022,6500.00,40000.00,'AVAILABLE'),(13,2,3,'Sigma','18-35mm',2021,3800.00,28000.00,'AVAILABLE'),(14,3,3,'DJI','Air 3',2023,14000.00,90000.00,'AVAILABLE'),(15,4,3,'Nanlite','Forza 60',2022,4200.00,30000.00,'AVAILABLE'),(16,5,3,'Sennheiser','MKH416',2021,3500.00,25000.00,'AVAILABLE'),(17,1,3,'Canon','EOS R6',2022,7800.00,48000.00,'AVAILABLE'),(18,2,3,'Tamron','28-75mm',2022,3600.00,26000.00,'AVAILABLE'),(19,4,3,'Godox','VL150',2021,5000.00,35000.00,'AVAILABLE');
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membership`
--

DROP TABLE IF EXISTS `membership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `membership` (
  `membership_id` int NOT NULL AUTO_INCREMENT,
  `level` enum('REGULAR','SILVER','GOLD') DEFAULT NULL,
  `discount_percentage` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`membership_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membership`
--

LOCK TABLES `membership` WRITE;
/*!40000 ALTER TABLE `membership` DISABLE KEYS */;
INSERT INTO `membership` VALUES (1,'REGULAR',0.00),(2,'SILVER',5.00),(3,'GOLD',10.00);
/*!40000 ALTER TABLE `membership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rental_payments`
--

DROP TABLE IF EXISTS `rental_payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rental_payments` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `rental_id` int DEFAULT NULL,
  `amount` decimal(12,2) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `type` enum('RENT','LATE','DAMAGE') DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `rental_id` (`rental_id`),
  CONSTRAINT `rental_payments_ibfk_1` FOREIGN KEY (`rental_id`) REFERENCES `rentals` (`rental_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rental_payments`
--

LOCK TABLES `rental_payments` WRITE;
/*!40000 ALTER TABLE `rental_payments` DISABLE KEYS */;
INSERT INTO `rental_payments` VALUES (1,1,38000.00,'2024-12-01','RENT'),(2,2,30000.00,'2024-12-15','RENT');
/*!40000 ALTER TABLE `rental_payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentals`
--

DROP TABLE IF EXISTS `rentals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rentals` (
  `rental_id` int NOT NULL AUTO_INCREMENT,
  `equipment_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `branch_id` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `actual_return_date` date DEFAULT NULL,
  `rental_amount` decimal(12,2) DEFAULT NULL,
  `membership_discount` decimal(12,2) DEFAULT NULL,
  `long_rental_discount` decimal(12,2) DEFAULT NULL,
  `final_amount` decimal(12,2) DEFAULT NULL,
  `deposit_amount` decimal(12,2) DEFAULT NULL,
  `payment_status` enum('PAID','PARTIALLY_PAID','UNPAID') DEFAULT NULL,
  `rental_status` enum('ACTIVE','RETURNED','OVERDUE','CANCELLED') DEFAULT NULL,
  PRIMARY KEY (`rental_id`),
  KEY `equipment_id` (`equipment_id`),
  KEY `customer_id` (`customer_id`),
  KEY `branch_id` (`branch_id`),
  CONSTRAINT `rentals_ibfk_1` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`equipment_id`),
  CONSTRAINT `rentals_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `rentals_ibfk_3` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentals`
--

LOCK TABLES `rentals` WRITE;
/*!40000 ALTER TABLE `rentals` DISABLE KEYS */;
INSERT INTO `rentals` VALUES (1,2,2,1,'2024-12-01','2024-12-05',NULL,40000.00,2000.00,0.00,38000.00,50000.00,'PAID','RETURNED'),(2,4,3,1,'2024-12-15','2024-12-20',NULL,72000.00,7200.00,5000.00,59800.00,80000.00,'UNPAID','OVERDUE'),(3,9,5,2,'2025-01-03','2025-01-15',NULL,120000.00,6000.00,8000.00,106000.00,70000.00,'PARTIALLY_PAID','ACTIVE');
/*!40000 ALTER TABLE `rentals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `reservation_id` int NOT NULL AUTO_INCREMENT,
  `equipment_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `branch_id` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` enum('ACTIVE','CANCELLED') DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `equipment_id` (`equipment_id`),
  KEY `customer_id` (`customer_id`),
  KEY `branch_id` (`branch_id`),
  CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`equipment_id`),
  CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `reservations_ibfk_3` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,2,1,1,'2025-01-05','2025-01-10','ACTIVE'),(2,9,2,2,'2025-01-08','2025-01-12','ACTIVE'),(3,4,3,1,'2025-01-01','2025-01-07','CANCELLED');
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','MANAGER','STAFF') DEFAULT NULL,
  `branch_id` int DEFAULT NULL,
  `active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`),
  KEY `branch_id` (`branch_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin123','ADMIN',NULL,1),(2,'pan_manager','manager123','MANAGER',1,1),(3,'gal_manager','manager123','MANAGER',2,1),(4,'pan_staff1','staff123','STAFF',1,1),(5,'gal_staff1','staff123','STAFF',2,1),(6,'col_staff1','staff123','STAFF',3,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-31 22:29:16
