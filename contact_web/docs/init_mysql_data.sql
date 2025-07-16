-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: mjc813_db
-- ------------------------------------------------------
-- Server version	8.4.5

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contact_tbl`
--

DROP TABLE IF EXISTS `contact_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_tbl` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '자동증가 PK',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '연락처이름',
  `phoneNumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '전화번호',
  `zipNumber` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '우편번호',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '이메일주소',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='연락처 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_tbl`
--

LOCK TABLES `contact_tbl` WRITE;
/*!40000 ALTER TABLE `contact_tbl` DISABLE KEYS */;
INSERT INTO `contact_tbl` VALUES (5,'이순신','010-1111-1111','12345','leess@gmail.com');
INSERT INTO `contact_tbl` VALUES (6,'홍길동','010-2222-2222','34534','hong@gmail.com');
INSERT INTO `contact_tbl` VALUES (7,'김유신','010-3333-3333','34543','kim@gmail.com');
INSERT INTO `contact_tbl` VALUES (8,'이말자','010-1111-1113','74544','leem@gmail.com');
INSERT INTO `contact_tbl` VALUES (9,'신사임당','010-1111-1115','22222','shin@gmail.com');
INSERT INTO `contact_tbl` VALUES (10,'이성계','010-1111-1116','33333','leesk@gmail.com');
INSERT INTO `contact_tbl` VALUES (11,'을지문덕','010-1111-1118','44444','uj@gmail.com');
INSERT INTO `contact_tbl` VALUES (12,'강감찬','010-1111-1119','55555','kangkc@gmail.com');
INSERT INTO `contact_tbl` VALUES (13,'정약용','010-1111-6666','66666','jung@gmail.com');
INSERT INTO `contact_tbl` VALUES (14,'허준','010-1111-7777','77777','hu@gmail.com');
/*!40000 ALTER TABLE `contact_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `learn_tbl`
--

DROP TABLE IF EXISTS `learn_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `learn_tbl` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '자동증가 PK',
  `lecture_id` int unsigned NOT NULL COMMENT '강의정보 FK',
  `score` decimal(5,1) NOT NULL DEFAULT '0.0' COMMENT '점수',
  `contact_id` int unsigned NOT NULL COMMENT '학생정보 FK',
  PRIMARY KEY (`id`),
  KEY `learn_fk_lecture` (`lecture_id`),
  KEY `learn_fk_contact` (`contact_id`),
  CONSTRAINT `learn_fk_contact` FOREIGN KEY (`contact_id`) REFERENCES `contact_tbl` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT `learn_fk_lecture` FOREIGN KEY (`lecture_id`) REFERENCES `lecture_tbl` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='수강 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `learn_tbl`
--

LOCK TABLES `learn_tbl` WRITE;
/*!40000 ALTER TABLE `learn_tbl` DISABLE KEYS */;
INSERT INTO `learn_tbl` VALUES (1,2,0.0,5);
INSERT INTO `learn_tbl` VALUES (2,3,0.0,6);
INSERT INTO `learn_tbl` VALUES (3,3,0.0,7);
INSERT INTO `learn_tbl` VALUES (4,3,0.0,8);
INSERT INTO `learn_tbl` VALUES (5,2,0.0,9);
INSERT INTO `learn_tbl` VALUES (6,4,0.0,11);
INSERT INTO `learn_tbl` VALUES (7,5,0.0,12);
/*!40000 ALTER TABLE `learn_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecture_tbl`
--

DROP TABLE IF EXISTS `lecture_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecture_tbl` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '자동증가 PK',
  `subject` varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '수강과목',
  `teacher` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '수강교수',
  `room_num` varchar(10) COLLATE utf8mb4_general_ci NOT NULL COMMENT '강의실번호',
  `start_dt` date NOT NULL COMMENT '강의 시작일',
  `end_dt` date NOT NULL COMMENT '강의 종료일',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='강의 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture_tbl`
--

LOCK TABLES `lecture_tbl` WRITE;
/*!40000 ALTER TABLE `lecture_tbl` DISABLE KEYS */;
INSERT INTO `lecture_tbl` VALUES (1,'데이터통신','김교수','813','2025-07-04','2025-07-30');
INSERT INTO `lecture_tbl` VALUES (2,'데이터보안','이교수','633','2025-07-10','2025-07-25');
INSERT INTO `lecture_tbl` VALUES (3,'이산수학','최교수','B04','2025-08-01','2025-09-30');
INSERT INTO `lecture_tbl` VALUES (4,'웹기본','장교수','921','2025-08-25','2025-09-30');
INSERT INTO `lecture_tbl` VALUES (5,'웹프론트엔드','김말자','451','2025-07-15','2025-08-25');
INSERT INTO `lecture_tbl` VALUES (6,'백엔드','홍교수','371','2025-08-20','2025-10-10');
/*!40000 ALTER TABLE `lecture_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_tbl`
--

DROP TABLE IF EXISTS `location_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location_tbl` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '자동증가 PK',
  `location` varchar(500) COLLATE utf8mb4_general_ci NOT NULL COMMENT '배송지 주소',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='배송지 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_tbl`
--

LOCK TABLES `location_tbl` WRITE;
/*!40000 ALTER TABLE `location_tbl` DISABLE KEYS */;
INSERT INTO `location_tbl` VALUES (1,'서울시 관악구');
INSERT INTO `location_tbl` VALUES (2,'서울시 강남구');
INSERT INTO `location_tbl` VALUES (3,'서울시 송파구');
INSERT INTO `location_tbl` VALUES (4,'서울시 마포구');
INSERT INTO `location_tbl` VALUES (5,'서울시 은평구');
/*!40000 ALTER TABLE `location_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saled_tbl`
--

DROP TABLE IF EXISTS `saled_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saled_tbl` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '자동증가 PK',
  `sale_dt` datetime NOT NULL DEFAULT (curdate()) COMMENT '판매날짜시분',
  `price` int unsigned NOT NULL DEFAULT '0' COMMENT '판매단가',
  `qty` int unsigned NOT NULL DEFAULT '0' COMMENT '판매수량',
  `product` varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '판매물품',
  `discount` int unsigned NOT NULL DEFAULT '0' COMMENT '할인금액',
  `location_id` int unsigned DEFAULT NULL COMMENT '배송지정보 FK',
  `contact_id` int unsigned NOT NULL COMMENT '구매고객 FK',
  PRIMARY KEY (`id`),
  KEY `saled_fk_location` (`location_id`),
  KEY `saled_fk_contact` (`contact_id`),
  CONSTRAINT `saled_fk_contact` FOREIGN KEY (`contact_id`) REFERENCES `contact_tbl` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT `saled_fk_location` FOREIGN KEY (`location_id`) REFERENCES `location_tbl` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='판매 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saled_tbl`
--

LOCK TABLES `saled_tbl` WRITE;
/*!40000 ALTER TABLE `saled_tbl` DISABLE KEYS */;
INSERT INTO `saled_tbl` VALUES (1,'2025-07-04',2000,2,'우유',0,NULL,6);
INSERT INTO `saled_tbl` VALUES (2,'2025-07-04',3000,1,'식빵',0,NULL,6);
INSERT INTO `saled_tbl` VALUES (3,'2025-07-04',30000,1,'쌀10K',1000,2,7);
INSERT INTO `saled_tbl` VALUES (4,'2025-07-04',22000,2,'밀가루20K',2000,2,7);
INSERT INTO `saled_tbl` VALUES (5,'2025-07-04',4000,2,'잼100g',0,2,7);
INSERT INTO `saled_tbl` VALUES (6,'2025-07-04',9000,1,'오예스',0,NULL,5);
INSERT INTO `saled_tbl` VALUES (7,'2025-07-05',4000,1,'초코파이',0,NULL,6);
/*!40000 ALTER TABLE `saled_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mjc813_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-04 10:33:09
