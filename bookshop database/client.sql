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

-- Dumping structure for table bookshop.client
CREATE TABLE IF NOT EXISTS `client` (
  `clientId` varchar(12) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`clientId`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bookshop.client: ~5 rows (approximately)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT IGNORE INTO `client` (`clientId`, `name`, `surname`, `email`, `password`) VALUES
	('FSWV03234635', 'Wanda', 'Vision', 'wvis@gmail.com', 'wordpass'),
	('RYGR08457800', 'w', 'w', 'wvisee@gmail.com', 'tt'),
	('XGXO25725368', 'Tristan', 'Star', 'tris@gmail.com', 'pass'),
	('YNDL31883380', 'Yami', 'Maki', 'maki@gmail.com', 'giaas'),
	('YPRG66040425', 'Tim', 'Othy', 'timmy@gmail.com', 'same');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
