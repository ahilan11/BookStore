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

-- Dumping structure for table bookshop.sale
CREATE TABLE IF NOT EXISTS `sale` (
  `saleId` varchar(12) NOT NULL,
  `saleDate` date DEFAULT NULL,
  `employeeId` varchar(6) DEFAULT NULL,
  `clientId` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`saleId`),
  KEY `employeeId` (`employeeId`),
  KEY `clientId` (`clientId`),
  CONSTRAINT `sale_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`),
  CONSTRAINT `sale_ibfk_2` FOREIGN KEY (`clientId`) REFERENCES `client` (`clientId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bookshop.sale: ~12 rows (approximately)
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT IGNORE INTO `sale` (`saleId`, `saleDate`, `employeeId`, `clientId`) VALUES
	('ARBT72751701', '2022-07-21', 'bd4390', 'YNDL31883380'),
	('CEIR40360788', '2022-07-21', 'DV4525', 'FSWV03234635'),
	('GLYV28002577', '2022-07-22', 'XI3604', 'YPRG66040425'),
	('KKXU21830180', '2022-07-22', 'XI3604', 'YPRG66040425'),
	('NBEA43213208', '2022-07-22', 'DV4525', 'YPRG66040425'),
	('NRKR25148106', '2022-07-21', 'bd4390', 'YNDL31883380'),
	('OGGA12681232', '2022-07-21', 'DV4525', 'YNDL31883380'),
	('PAKV31536530', '2022-07-21', 'bd4390', 'FSWV03234635'),
	('POAD80588271', '2022-07-21', 'bd4390', 'FSWV03234635'),
	('QJVR10847684', '2022-07-22', 'bd4390', 'RYGR08457800'),
	('TGVP43445122', '2022-07-21', 'bd4390', 'FSWV03234635'),
	('VFNK36748306', '2022-07-21', 'bd4390', 'YNDL31883380');
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
