-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: sistemanetu
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat` (
  `codigo_Empleado_1` int NOT NULL,
  `codigo_Empleado_2` int NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `mensaje` tinytext COLLATE utf8mb4_general_ci NOT NULL,
  KEY `codigo_Empleado_1` (`codigo_Empleado_1`),
  KEY `codigo_Empleado_2` (`codigo_Empleado_2`),
  CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`codigo_Empleado_1`) REFERENCES `empleado` (`codigo_Empleado`),
  CONSTRAINT `chat_ibfk_2` FOREIGN KEY (`codigo_Empleado_2`) REFERENCES `empleado` (`codigo_Empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependencia`
--

DROP TABLE IF EXISTS `dependencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dependencia` (
  `id_Dependencia` int NOT NULL,
  `nombre_Dependencia` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_Dependencia`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre_Dependencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependencia`
--

LOCK TABLES `dependencia` WRITE;
/*!40000 ALTER TABLE `dependencia` DISABLE KEYS */;
INSERT INTO `dependencia` VALUES (5,'DEPARTAMENTOS'),(4,'ESCUELAS'),(2,'FACULTADES'),(3,'INSTITUTOS'),(1,'VICERRECTORÍA');
/*!40000 ALTER TABLE `dependencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependenciasubdependencia`
--

DROP TABLE IF EXISTS `dependenciasubdependencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dependenciasubdependencia` (
  `id_Dependencia` int NOT NULL,
  `id_Subdependencia` int NOT NULL,
  KEY `id_Dependencia` (`id_Dependencia`),
  KEY `id_Subdependencia` (`id_Subdependencia`),
  CONSTRAINT `dependenciasubdependencia_ibfk_1` FOREIGN KEY (`id_Dependencia`) REFERENCES `dependencia` (`id_Dependencia`),
  CONSTRAINT `dependenciasubdependencia_ibfk_2` FOREIGN KEY (`id_Subdependencia`) REFERENCES `subdependencia` (`id_Subdependencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependenciasubdependencia`
--

LOCK TABLES `dependenciasubdependencia` WRITE;
/*!40000 ALTER TABLE `dependenciasubdependencia` DISABLE KEYS */;
INSERT INTO `dependenciasubdependencia` VALUES (1,1),(1,2),(1,3),(1,4),(2,5),(2,6),(2,7),(2,8),(2,9),(2,10),(2,11),(3,12),(3,13),(4,14),(4,14),(4,14),(4,15),(4,16),(4,17),(4,18),(4,19),(4,20),(4,21),(4,22),(4,23),(4,24),(4,25),(4,26),(4,27),(4,28),(4,29),(4,30),(4,31),(4,32),(4,33),(4,34),(5,36),(5,36),(5,36),(5,37),(5,38),(5,39),(5,40),(5,41),(5,42),(5,43),(5,44),(5,45),(5,46),(5,47),(5,48),(5,49),(5,50);
/*!40000 ALTER TABLE `dependenciasubdependencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `codigo_Empleado` int NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `correo` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `sexo` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `dependencia` int NOT NULL,
  `subdependencia` int NOT NULL,
  `descripcion` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`codigo_Empleado`),
  KEY `dependencia` (`dependencia`),
  KEY `subdependencia` (`subdependencia`),
  CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`dependencia`) REFERENCES `dependencia` (`id_Dependencia`),
  CONSTRAINT `empleado_ibfk_2` FOREIGN KEY (`subdependencia`) REFERENCES `subdependencia` (`id_Subdependencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `codigo_Empleado` int NOT NULL,
  `contraseña` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '0',
  KEY `codigo_Empleado` (`codigo_Empleado`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`codigo_Empleado`) REFERENCES `empleado` (`codigo_Empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensaje`
--

DROP TABLE IF EXISTS `mensaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensaje` (
  `codigo_Empleado_1` int NOT NULL,
  `codigo_Empleado_2` int NOT NULL,
  `abierto` tinyint(1) DEFAULT '0',
  KEY `codigo_Empleado_1` (`codigo_Empleado_1`),
  KEY `codigo_Empleado_2` (`codigo_Empleado_2`),
  CONSTRAINT `mensaje_ibfk_1` FOREIGN KEY (`codigo_Empleado_1`) REFERENCES `empleado` (`codigo_Empleado`),
  CONSTRAINT `mensaje_ibfk_2` FOREIGN KEY (`codigo_Empleado_2`) REFERENCES `empleado` (`codigo_Empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensaje`
--

LOCK TABLES `mensaje` WRITE;
/*!40000 ALTER TABLE `mensaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificaciones`
--

DROP TABLE IF EXISTS `notificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificaciones` (
  `codigo_Empleado_1` int NOT NULL,
  `codigo_Empleado_2` int NOT NULL,
  KEY `codigo_Empleado_1` (`codigo_Empleado_1`),
  KEY `codigo_Empleado_2` (`codigo_Empleado_2`),
  CONSTRAINT `notificaciones_ibfk_1` FOREIGN KEY (`codigo_Empleado_1`) REFERENCES `empleado` (`codigo_Empleado`),
  CONSTRAINT `notificaciones_ibfk_2` FOREIGN KEY (`codigo_Empleado_2`) REFERENCES `empleado` (`codigo_Empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificaciones`
--

LOCK TABLES `notificaciones` WRITE;
/*!40000 ALTER TABLE `notificaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publicacion`
--

DROP TABLE IF EXISTS `publicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publicacion` (
  `id_Publicacion` int NOT NULL AUTO_INCREMENT,
  `codigo_Empleado` int NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `contenido` text COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_Publicacion`),
  KEY `codigo_Empleado` (`codigo_Empleado`),
  CONSTRAINT `publicacion_ibfk_1` FOREIGN KEY (`codigo_Empleado`) REFERENCES `empleado` (`codigo_Empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicacion`
--

LOCK TABLES `publicacion` WRITE;
/*!40000 ALTER TABLE `publicacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `publicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subdependencia`
--

DROP TABLE IF EXISTS `subdependencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subdependencia` (
  `id_Subdependencia` int NOT NULL,
  `nombre_Subdependencia` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_Subdependencia`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre_Subdependencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subdependencia`
--

LOCK TABLES `subdependencia` WRITE;
/*!40000 ALTER TABLE `subdependencia` DISABLE KEYS */;
INSERT INTO `subdependencia` VALUES (1,'ACADÉMICA'),(2,'ADMINISTRATIVA'),(14,'ARQUITECTURA'),(36,'ARTES ESCÉNICAS'),(5,'ARTES INTEGRADAS'),(37,'ARTES VISUALES Y ESTÉTICA'),(15,'BACTEROLIOGÍA Y LABORATORIO CLÍNICO'),(3,'BIENESTAR UNIVERSITARIO'),(38,'BIOLOGÍA'),(16,'CIENCIAS BÁSICAS'),(7,'CIENCIAS DE LA ADMINISTRACIÓN'),(17,'CIENCIAS DEL LENGUAJE'),(6,'CIENCIAS NATURALES Y EXACTAS'),(39,'CIENCIAS SOCIALES'),(9,'CIENCIAS SOCIALES Y ECONÓMICAS'),(18,'COMUNICACIÓN SOCIAL'),(41,'DIRECCIÓN Y GESTIÓN ADMINISTRATIVA'),(40,'DISEÑO'),(42,'ECONOMÍA'),(12,'EDUCACIÓN Y PEDAGOGÍA'),(19,'ENFERMERÍA'),(20,'ESTADÍSTICA'),(21,'ESTUDIOS LITERARIOS'),(43,'FILOSOFÍA'),(44,'FÍSICA'),(45,'GEOGRAFÍA'),(46,'HISTORIA'),(10,'HUMANIDADES'),(11,'INGENIERÍA'),(22,'INGENIERÍA CIVIL Y GEOMÁTICA'),(23,'INGENIERÍA DE ALIMENTOS'),(24,'INGENIERÍA DE MATERIALES'),(25,'INGENIERÍA DE RECURSOS NATURALES Y DEL AMBIENTE'),(26,'INGENIERÍA DE SISTEMAS Y COMPUTACIÓN'),(27,'INGENIERÍA ELÉCTRICA Y ELECTRÓNICA'),(28,'INGENIERÍA INDUSTRIAL'),(29,'INGENIERÍA MECÁNICA'),(30,'INGENIERÍA QUÍMICA'),(4,'INVESTIGACIONES'),(47,'MATEMÁTICAS'),(31,'MEDICINA'),(48,'MEDICINA INTERNA'),(32,'MÚSICA'),(33,'ODONTOLOGÍA'),(49,'PROCESOS, INFORMACIÓN, CONTABILIDAD Y FINANZAS'),(13,'PSICOLOGÍA'),(50,'QUÍMICA'),(34,'REHABILITACIÓN HUMANA'),(8,'SALUD'),(35,'SALUD PÚBLICA');
/*!40000 ALTER TABLE `subdependencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sistemanetu'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-02 19:58:56
