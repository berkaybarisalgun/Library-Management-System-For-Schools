-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: slms
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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `name` varchar(50) DEFAULT NULL,
  `writer` varchar(45) DEFAULT NULL,
  `number_of_pages` int DEFAULT NULL,
  `which_year` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES ('To Kill a Mockingbird','Harper Lee',324,'1960'),('Pride and Prejudice','Jane Austen',279,'1813'),('The Great Gatsby','F. Scott Fitzgerald',180,'1925'),('1984','George Orwell',328,'1949'),('The Catcher in the Rye','J.D. Salinger',277,'1951'),('One Hundred Years of Solitude','Gabriel García Márquez',417,'1967'),('The Diary of a Young Girl','Anne Frank',267,'1947'),('The Lord of the Rings','J.R.R. Tolkien',1178,'1954'),('The Hobbit','J.R.R. Tolkien',310,'1937'),('The Little Prince','Antoine de Saint-Exupéry',111,'1943'),('The Hitchhiker\'s Guide to the Galaxy','Douglas Adams',198,'1979'),('The Great Gatsby','F. Scott Fitzgerald',180,'1925'),('1984','George Orwell',328,'1949'),('Pride and Prejudice','Jane Austen',279,'1813'),('The Catcher in the Rye','J.D. Salinger',214,'1951'),('The Diary of a Young Girl','Anne Frank',267,'1947'),('The Great Gatsby','F. Scott Fitzgerald',180,'1925'),('1984','George Orwell',328,'1949'),('Pride and Prejudice','Jane Austen',279,'1813'),('The Catcher in the Rye','J.D. Salinger',214,'1951'),('The Diary of a Young Girl','Anne Frank',267,'1947'),('To Kill a Mockingbird','Harper Lee',324,'1960'),('The Lord of the Rings','J.R.R. Tolkien',1178,'1954'),('One Hundred Years of Solitude','Gabriel García Márquez',417,'1967'),('Moby-Dick','Herman Melville',378,'1851'),('The Hobbit','J.R.R. Tolkien',305,'1937'),('The Adventures of Huckleberry Finn','Mark Twain',216,'1884'),('The Grapes of Wrath','John Steinbeck',464,'1939'),('The Picture of Dorian Gray','Oscar Wilde',259,'1890'),('The Old Man and the Sea','Ernest Hemingway',128,'1952'),('The Sun Also Rises','Ernest Hemingway',214,'1926'),('The Divine Comedy','Dante Alighieri',330,'1320'),('The Iliad','Homer',700,'-800'),('The Odyssey','Homer',725,'-800'),('War and Peace','Leo Tolstoy',1225,'1869'),('Anna Karenina','Leo Tolstoy',864,'1877'),('Madame Bovary','Gustave Flaubert',528,'1856'),('The Count of Monte Cristo','Alexandre Dumas',1344,'1844'),('Les Misérables','Victor Hugo',1488,'1862'),('The Three Musketeers','Alexandre Dumas',448,'1844'),('The Trial','Franz Kafka',160,'1925'),('The Metamorphosis','Franz Kafka',72,'1915'),('Dracula','Bram Stoker',432,'1897'),('Frankenstein','Mary Shelley',288,'1818'),('The Hunchback of Notre-Dame','Victor Hugo',384,'1831'),('Wuthering Heights','Emily Brontë',342,'1847'),('allahın kanunları','allah',999,'636'),('Name','Writer',12,'2023'),('adg','rwer',31,'2000');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-14 23:43:23
