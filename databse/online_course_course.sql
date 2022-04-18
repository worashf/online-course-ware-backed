-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: localhost    Database: online_course
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` bigint NOT NULL,
  `course_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` longtext COLLATE utf8_unicode_ci,
  `objective` longtext COLLATE utf8_unicode_ci,
  `price` double DEFAULT NULL,
  `requirements` longtext COLLATE utf8_unicode_ci,
  `star` int DEFAULT NULL,
  `thumbnail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FKkyes7515s3ypoovxrput029bh` (`category_id`),
  KEY `FK2nmcqx8d89xeticql10qxxvdl` (`user_id`),
  CONSTRAINT `FK2nmcqx8d89xeticql10qxxvdl` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKkyes7515s3ypoovxrput029bh` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (11,'Java from Zero to First Job - Practical Guide, 800+ examples','Welcome to the fundamental and the most complete course \'Java from Zero to First Job\'.  As it\'s declared in the course name, it\'s created for people who want to learn programming from scratch. You need to know how to turn on your computer, no other knowledge is required for this course :) The rest will be covered in lessons.\n\nBefore starting the creation of this course, our team attentively investigated feedbacks for existing courses on the Udemy platform and tried to focus on the feedbacks for the top-rated courses to understand what can be improved in this course and make it, even more, better from the quality standpoint. After analysis, we understand what will help students to learn Java in a more efficient way. In this course:','Java :)\nLearn the Java basics, including syntax and primitive data types\nGet necessary knowledge to demonstrate your skills of Java to future employers\nStudents will learn programming basics which will help them to understand any other programming language\nInterview practice tests\nIn this course you will get knowledge which is needed to proceed with understanding of Android, Spring Framework and other enterprise frameworks\nObject-oriented programming\nUnderstand difference between Java 8, 9, 11, 13\nLearn best practices from true programmer\nLearn how to write scalable, readable and maintainable clean code\n30+ coding exercises',NULL,'You want to learn Java while having fun :)\nNo programming experience needed. You will learn everything you need to know.',0,'about-right.jpeg',9,5),(12,'Learn Python: The Complete Python Programming Course','Do you want to become a programmer? Do you want to learn how to create games, automate your browser, visualize data, and much more?\n\nIf you’re looking to learn Python for the very first time or need a quick brush-up, this is the course for you!\n\nPython has rapidly become one of the most popular programming languages around the world. Compared to other languages such as Java or C++, Python consistently outranks and outperforms these languages in demand from businesses and job availability. The average Python developer makes over $100,000 - this number is only going to grow in the coming years.','Create their own Python Programs\nBecome an experienced Python Programmer\nParse the Web and Create their own Games',NULL,'Macintosh (OSX)/ Windows(Vista and higher) Machine\nInternet Connection',0,NULL,9,NULL),(13,'Python for Beginners - Learn Programming from scratch','This python for beginners course is geared to students who want to know how python works and also to those totally new to programming.\n\nThe python language has very simple syntax(way to write it) to learn and it is one of the most powerful languages to learn since it can used for a variety of things.','To learn the python language\nTo learn the CORE skills to understand any programming language',NULL,'NO programming knowledge required',0,NULL,9,NULL),(14,'Applied Sport Psychology and Leadership in Sport','With over 12 hours of highly engaging content, consisting of 57 video lectures, and including numerous resources and examples from contemporary sport, this course is presented as a comprehensive applied sport psychology course for coaches, athletes and leaders or anybody considering some learning in this area. The course is pitched at a very attainable level to cater for all learners - ie NVQ Level 4 in UK. This would equate to equivalent of QQI or FETAC Level 6 standard course in Ireland. or pre-university course in other countries.','Unit 1 - Introduction to Sport Psychology - What is Sport Psychology, How Sport Psychology Helps a Team, History of Sport Psychology, The Role of & How to Become a Sport Psychologist, Career Opportunities in the Field\nUnit 2 - Sport Psychology Social Perspectives - Children in Youth Sport, Drop-out From Youth Sport, Gender Differentiation and Disability in Sport, Parenting in Sport,',NULL,'No pre-requisite knowledge but a basic understanding and or experience of involvement in sport as a coach or athlete or any type of team management would be helpful.',0,NULL,8,NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-18  9:33:18
