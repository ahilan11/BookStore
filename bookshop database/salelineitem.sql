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

-- Dumping structure for table bookshop.salelineitem
CREATE TABLE IF NOT EXISTS `salelineitem` (
  `id` varchar(12) NOT NULL,
  `saleId` varchar(12) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `bookId` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `saleId` (`saleId`),
  KEY `bookId` (`bookId`),
  CONSTRAINT `salelineitem_ibfk_1` FOREIGN KEY (`saleId`) REFERENCES `sale` (`saleId`),
  CONSTRAINT `salelineitem_ibfk_2` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bookshop.salelineitem: ~11 rows (approximately)
/*!40000 ALTER TABLE `salelineitem` DISABLE KEYS */;
INSERT IGNORE INTO `salelineitem` (`id`, `saleId`, `quantity`, `bookId`) VALUES
	('BDUU11106187', 'QJVR10847684', 0, 'XIIG56108460'),
	('BTEC18106625', 'NBEA43213208', 1, 'bk9783ty4357'),
	('CNTP85384661', 'TGVP43445122', 0, 'XIIG56108460'),
	('DDTX23136464', 'OGGA12681232', 0, 'bk9783ty4357'),
	('DLNT08532876', 'KKXU21830180', 0, 'SPJK16222620'),
	('FBGG55155031', 'GLYV28002577', 0, 'JNGU16153766'),
	('LROM11067065', 'QJVR10847684', 0, 'bk9783ty4357'),
	('MCAJ25787557', 'CEIR40360788', 0, 'LTMO26632278'),
	('MWKC46016575', 'CEIR40360788', 0, 'bk9783ty4357'),
	('NAAW05444681', 'VFNK36748306', 0, 'LTMO26632278'),
	('YAPJ55301054', 'POAD80588271', 0, 'bk9783ty4357');
/*!40000 ALTER TABLE `salelineitem` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
