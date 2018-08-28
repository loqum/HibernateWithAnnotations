CREATE DATABASE IF NOT EXISTS `netmind` DEFAULT CHARACTER set latin1 COLLATE latin1_swedish_ci;
USE `netmind`;


DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente`(
	`IdCliente` int(11) NOT NULL AUTO_INCREMENT,
	`Nombre`varchar(50) NOT NULL,
	`Apellidos`varchar(100) NOT NULL,
	`Dni`varchar(14) NOT NULL,
PRIMARY KEY (`IdCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=28;