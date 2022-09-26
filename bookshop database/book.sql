-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table bookshop.book
CREATE TABLE IF NOT EXISTS `book` (
  `bookId` varchar(12) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `author` varchar(60) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `location` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bookshop.book: ~5 rows (approximately)
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT IGNORE INTO `book` (`bookId`, `title`, `description`, `author`, `price`, `location`) VALUES
	('bk9783ty4357', 'Gone', 'People Over the age of 15 are disappearing', 'Michael Grant', 99.99, 'C:/Users/Ahilan/Downloads/Documents/Gone (series) - Michael Grant - Copy.pdf'),
	('JNGU16153766', 'Riddle Me This', 'Ultimate Collection of brain teasers and riddles          ', 'Will R. Rain', 175.59, 'C:\\Users\\Ahilan\\Downloads\\Documents\\Riddle Me This - The Ultimate Collection Of Riddles & Brain Teasers ( PDFDrive ).pdf'),
	('LTMO26632278', 'Learning Web Design A BEGINNER\'S GUIDE TO HTML, CSS, JAVASCRIPT, AND WEB GRAPHICS', 'Learn web design using html, css and javascript', 'Jennifer Niederst Robbins', 359.79, 'C:\\Users\\Ahilan\\Downloads\\Documents\\Learning Web Design A Beginners Guide to HTML, CSS, JavaScript, and Web Graphics ( PDFDrive ).pdf'),
	('SPJK16222620', 'Javascript and JQuery', 'This book teaches basic to advances javascript and jquery                    ', 'Jon Duckett', 0, 'C:\\Users\\Ahilan\\Downloads\\Documents\\JavaScript _ jQuery  Interactive Front-End Development ( PDFDrive ).pdf'),
	('XIIG56108460', 'Design Patterns', 'Programming design patterns', 'ERRJ', 0, 'C:\\Users\\Ahilan\\Desktop\\Downloads;\\Design Patterns_ Elements of Reusable Object-Oriented Software ( PDFDrive ).pdf');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
