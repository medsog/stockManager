-- Dumping database structure for concretepage
CREATE DATABASE IF NOT EXISTS `concretepage`;
USE `concretepage`;
-- Dumping structure for table concretepage.articles
CREATE TABLE IF NOT EXISTS `articles` (
  `article_id` int(5) NOT NULL AUTO_INCREMENT,
  `article_code` int(5) NOT NULL,
  `marque` varchar(200) NOT NULL,
  `description` varchar(100),
  `taille` varchar(10) NOT NULL,
  `couleur` varchar(50) NOT NULL,
  `prix_achat` double NOT NULL,
  `prix_vente` double,
  `frais_transport` double ,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
