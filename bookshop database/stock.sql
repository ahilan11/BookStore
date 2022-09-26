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

-- Dumping structure for table bookshop.stock
CREATE TABLE IF NOT EXISTS `stock` (
  `stockId` varchar(12) DEFAULT NULL,
  `bookId` varchar(12) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  KEY `bookId` (`bookId`),
  CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bookshop.stock: ~5 rows (approximately)
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT IGNORE INTO `stock` (`stockId`, `bookId`, `quantity`) VALUES
	('gg32434589hh', 'bk9783ty4357', 13),
	('GTEO45520754', 'LTMO26632278', 2),
	('UCGD28318348', 'XIIG56108460', 1),
	('NXMX81151864', 'SPJK16222620', 4),
	('DHRD53684730', 'JNGU16153766', 8);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
