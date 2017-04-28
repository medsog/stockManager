-- --------------------------------------------------------
-- Hôte :                        localhost
-- Version du serveur:           5.6.15-log - MySQL Community Server (GPL)
-- SE du serveur:                Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Export de la structure de la base pour gm
CREATE DATABASE IF NOT EXISTS `gm` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gm`;


-- Export de la structure de table gm. m_enteteventes
CREATE TABLE IF NOT EXISTS `m_enteteventes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `n_piece` varchar(50) DEFAULT '',
  `date_piece` varchar(50) DEFAULT NULL,
  `id_depot` int(11) DEFAULT NULL,
  `reference` varchar(50) DEFAULT '',
  `id_affaire` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  `id_collaborateur` int(11) DEFAULT NULL,
  `date_livraison` varchar(50) DEFAULT '0',
  `mode_payement` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `n_piece` (`n_piece`),
  KEY `FK_m_enteteventes_s_depot` (`id_depot`),
  KEY `FK_m_enteteventes_s_affaire` (`id_affaire`),
  KEY `FK_m_enteteventes_s_client` (`id_client`),
  KEY `FK_m_enteteventes_s_collaborateur` (`id_collaborateur`),
  KEY `FK_m_enteteventes_p_mode_paiement` (`mode_payement`),
  CONSTRAINT `FK_m_enteteventes_s_client` FOREIGN KEY (`id_client`) REFERENCES `s_client` (`id_client`),
  CONSTRAINT `FK_m_enteteventes_s_collaborateur` FOREIGN KEY (`id_collaborateur`) REFERENCES `s_collaborateur` (`id`),
  CONSTRAINT `FK_m_enteteventes_p_mode_paiement` FOREIGN KEY (`mode_payement`) REFERENCES `p_mode_paiement` (`id_mode`),
  CONSTRAINT `FK_m_enteteventes_s_affaire` FOREIGN KEY (`id_affaire`) REFERENCES `s_affaire` (`id_affaire`),
  CONSTRAINT `FK_m_enteteventes_s_depot` FOREIGN KEY (`id_depot`) REFERENCES `s_depot` (`id_Depot`)
) ENGINE=InnoDB AUTO_INCREMENT=288 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.m_enteteventes : ~0 rows (environ)
/*!40000 ALTER TABLE `m_enteteventes` DISABLE KEYS */;
/*!40000 ALTER TABLE `m_enteteventes` ENABLE KEYS */;


-- Export de la structure de table gm. m_lignesventes
CREATE TABLE IF NOT EXISTS `m_lignesventes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_entete` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `id_aticle_gamme` int(11) DEFAULT NULL,
  `n_serie` varchar(50) DEFAULT NULL,
  `pu_ht` varchar(50) DEFAULT NULL,
  `qte` varchar(50) DEFAULT NULL,
  `tva` varchar(50) DEFAULT NULL,
  `pt_ht` float DEFAULT NULL,
  `pt_ttc` float DEFAULT NULL,
  `remise` float DEFAULT NULL,
  `cmup` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_m_lignesventes_m_enteteventes` (`id_entete`),
  KEY `FK_m_lignesventes_s_article_gamme` (`id_aticle_gamme`),
  CONSTRAINT `FK_m_lignesventes_s_article_gamme` FOREIGN KEY (`id_aticle_gamme`) REFERENCES `s_article_gamme` (`id_article_gamme`),
  CONSTRAINT `FK_m_lignesventes_m_enteteventes` FOREIGN KEY (`id_entete`) REFERENCES `m_enteteventes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=376 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.m_lignesventes : ~0 rows (environ)
/*!40000 ALTER TABLE `m_lignesventes` DISABLE KEYS */;
/*!40000 ALTER TABLE `m_lignesventes` ENABLE KEYS */;


-- Export de la structure de table gm. m_reglement
CREATE TABLE IF NOT EXISTS `m_reglement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(50) DEFAULT NULL,
  `mode_paiement` int(11) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  `montant` float DEFAULT NULL,
  `solde` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_m_reglement_p_mode_paiement` (`mode_paiement`),
  KEY `FK_m_reglement_s_client` (`id_client`),
  CONSTRAINT `FK_m_reglement_p_mode_paiement` FOREIGN KEY (`mode_paiement`) REFERENCES `p_mode_paiement` (`id_mode`),
  CONSTRAINT `FK_m_reglement_s_client` FOREIGN KEY (`id_client`) REFERENCES `s_client` (`id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.m_reglement : ~0 rows (environ)
/*!40000 ALTER TABLE `m_reglement` DISABLE KEYS */;
/*!40000 ALTER TABLE `m_reglement` ENABLE KEYS */;


-- Export de la structure de table gm. m_reglfacture
CREATE TABLE IF NOT EXISTS `m_reglfacture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_facture` varchar(50) DEFAULT '0',
  `id_reglement` int(11) DEFAULT '0',
  `montant` float DEFAULT '0',
  `date_imputation` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_m_reglfacture_m_reglement` (`id_reglement`),
  CONSTRAINT `FK_m_reglfacture_m_reglement` FOREIGN KEY (`id_reglement`) REFERENCES `m_reglement` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.m_reglfacture : ~0 rows (environ)
/*!40000 ALTER TABLE `m_reglfacture` DISABLE KEYS */;
/*!40000 ALTER TABLE `m_reglfacture` ENABLE KEYS */;


-- Export de la structure de table gm. p_mode_paiement
CREATE TABLE IF NOT EXISTS `p_mode_paiement` (
  `id_mode` int(11) NOT NULL AUTO_INCREMENT,
  `intitule_mode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_mode`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.p_mode_paiement : ~0 rows (environ)
/*!40000 ALTER TABLE `p_mode_paiement` DISABLE KEYS */;
/*!40000 ALTER TABLE `p_mode_paiement` ENABLE KEYS */;


-- Export de la structure de table gm. p_pays
CREATE TABLE IF NOT EXISTS `p_pays` (
  `id_pays` int(11) NOT NULL AUTO_INCREMENT,
  `Intitule_Pays` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id_pays`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.p_pays : ~0 rows (environ)
/*!40000 ALTER TABLE `p_pays` DISABLE KEYS */;
/*!40000 ALTER TABLE `p_pays` ENABLE KEYS */;


-- Export de la structure de table gm. p_tva
CREATE TABLE IF NOT EXISTS `p_tva` (
  `id_Tva` int(11) NOT NULL AUTO_INCREMENT,
  `Code_Tva` varchar(50) DEFAULT NULL,
  `Intitule_Tva` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_Tva`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.p_tva : ~0 rows (environ)
/*!40000 ALTER TABLE `p_tva` DISABLE KEYS */;
/*!40000 ALTER TABLE `p_tva` ENABLE KEYS */;


-- Export de la structure de table gm. p_ville
CREATE TABLE IF NOT EXISTS `p_ville` (
  `id_ville` int(11) NOT NULL AUTO_INCREMENT,
  `Intitule_Ville` varchar(50) NOT NULL DEFAULT '0',
  `pays` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ville`),
  KEY `FK_p_ville_p_paye` (`pays`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.p_ville : ~0 rows (environ)
/*!40000 ALTER TABLE `p_ville` DISABLE KEYS */;
/*!40000 ALTER TABLE `p_ville` ENABLE KEYS */;


-- Export de la structure de table gm. s_affaire
CREATE TABLE IF NOT EXISTS `s_affaire` (
  `id_affaire` int(11) NOT NULL AUTO_INCREMENT,
  `intitule_affaire` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_affaire`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.s_affaire : ~1 rows (environ)
/*!40000 ALTER TABLE `s_affaire` DISABLE KEYS */;
INSERT INTO `s_affaire` (`id_affaire`, `intitule_affaire`) VALUES
	(3, 'test');
/*!40000 ALTER TABLE `s_affaire` ENABLE KEYS */;


-- Export de la structure de table gm. s_article
CREATE TABLE IF NOT EXISTS `s_article` (
  `id_article` int(11) NOT NULL AUTO_INCREMENT,
  `Code_Article` varchar(50) DEFAULT '0',
  `Intitule_Article` varchar(50) DEFAULT '0',
  `Description` varchar(500) DEFAULT '0',
  `Famille` int(11) DEFAULT '0',
  `Prix_Achat` varchar(50) DEFAULT '0',
  `Prix_Vente` varchar(50) DEFAULT '0',
  `Unite` int(11) DEFAULT NULL,
  `Code_Barre` varchar(50) DEFAULT '0',
  `Tva` int(11) DEFAULT NULL,
  `remise` float DEFAULT '0',
  `Qte` float DEFAULT '0',
  `Cmup` float DEFAULT '0',
  `file` varchar(500) DEFAULT '0',
  PRIMARY KEY (`id_article`),
  KEY `FK_article_famille` (`Famille`),
  KEY `FK_article_tva` (`Tva`),
  CONSTRAINT `FK_s_article_s_famille` FOREIGN KEY (`Famille`) REFERENCES `s_famille` (`id_famille`),
  CONSTRAINT `FK_s_article_p_tva` FOREIGN KEY (`Tva`) REFERENCES `p_tva` (`id_Tva`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.s_article : ~0 rows (environ)
/*!40000 ALTER TABLE `s_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_article` ENABLE KEYS */;


-- Export de la structure de table gm. s_article_gamme
CREATE TABLE IF NOT EXISTS `s_article_gamme` (
  `id_article_gamme` int(11) NOT NULL AUTO_INCREMENT,
  `article` int(11) DEFAULT '0',
  `gamme` int(11) DEFAULT '0',
  `prix_achat` int(11) DEFAULT '0',
  `prix_vente` int(11) DEFAULT '0',
  `image` varchar(50) DEFAULT '0',
  `cmup` int(11) DEFAULT '0',
  PRIMARY KEY (`id_article_gamme`),
  KEY `FK_article_gamme_article` (`article`),
  KEY `FK_article_gamme_gamme` (`gamme`),
  CONSTRAINT `FK_s_article_gamme_s_article` FOREIGN KEY (`article`) REFERENCES `s_article` (`id_article`),
  CONSTRAINT `FK_s_article_gamme_s_gamme` FOREIGN KEY (`gamme`) REFERENCES `s_gamme` (`id_gamme`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.s_article_gamme : ~0 rows (environ)
/*!40000 ALTER TABLE `s_article_gamme` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_article_gamme` ENABLE KEYS */;


-- Export de la structure de table gm. s_categorie
CREATE TABLE IF NOT EXISTS `s_categorie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intitule_categorie` varchar(50) DEFAULT NULL,
  `coefficient` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.s_categorie : ~0 rows (environ)
/*!40000 ALTER TABLE `s_categorie` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_categorie` ENABLE KEYS */;


-- Export de la structure de table gm. s_client
CREATE TABLE IF NOT EXISTS `s_client` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(50) DEFAULT '0',
  `Identite` varchar(50) DEFAULT '0',
  `Nom` varchar(50) DEFAULT '0',
  `Prenom` varchar(50) DEFAULT '0',
  `Pays` int(11) DEFAULT '0',
  `Ville` int(11) DEFAULT '0',
  `Adresse` varchar(50) DEFAULT '0',
  `Tel` varchar(50) DEFAULT '0',
  `Portable` varchar(50) DEFAULT '0',
  `Fax` varchar(50) DEFAULT '0',
  `E_Mail` varchar(50) DEFAULT '0',
  `Site_Web` varchar(50) DEFAULT NULL,
  `Date_Annivairsaire` varchar(50) DEFAULT NULL,
  `remise` float DEFAULT NULL,
  `categorie` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_client`),
  KEY `FK_client_paye` (`Pays`),
  KEY `FK_client_ville` (`Ville`),
  KEY `FK_s_client_s_categorie` (`categorie`),
  CONSTRAINT `FK_s_client_s_categorie` FOREIGN KEY (`categorie`) REFERENCES `s_categorie` (`id`),
  CONSTRAINT `FK_client_ville` FOREIGN KEY (`Ville`) REFERENCES `p_ville` (`id_ville`),
  CONSTRAINT `FK_s_client_p_pays` FOREIGN KEY (`Pays`) REFERENCES `p_pays` (`id_pays`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.s_client : ~0 rows (environ)
/*!40000 ALTER TABLE `s_client` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_client` ENABLE KEYS */;


-- Export de la structure de table gm. s_collaborateur
CREATE TABLE IF NOT EXISTS `s_collaborateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(50) DEFAULT '0',
  `Nom_prenom` varchar(50) DEFAULT '0',
  `Pays` int(11) DEFAULT '0',
  `Ville` int(11) DEFAULT '0',
  `Adresse` varchar(50) DEFAULT '0',
  `Tel` varchar(50) DEFAULT '0',
  `Portable` varchar(50) DEFAULT '0',
  `Fax` varchar(50) DEFAULT '0',
  `E_Mail` varchar(50) DEFAULT '0',
  `id_type` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_s_collaborateur_p_ville` (`Ville`),
  KEY `FK_s_collaborateur_p_pays` (`Pays`),
  CONSTRAINT `FK_s_collaborateur_p_ville` FOREIGN KEY (`Ville`) REFERENCES `p_ville` (`id_ville`),
  CONSTRAINT `FK_s_collaborateur_p_pays` FOREIGN KEY (`Pays`) REFERENCES `p_pays` (`id_pays`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.s_collaborateur : ~0 rows (environ)
/*!40000 ALTER TABLE `s_collaborateur` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_collaborateur` ENABLE KEYS */;


-- Export de la structure de table gm. s_depot
CREATE TABLE IF NOT EXISTS `s_depot` (
  `id_Depot` int(11) NOT NULL AUTO_INCREMENT,
  `Code_Depot` varchar(50) NOT NULL DEFAULT '0',
  `Raison_Sociale` varchar(50) DEFAULT '0',
  `Pays` int(11) DEFAULT '0',
  `Ville` int(11) DEFAULT '0',
  `Adresse` varchar(50) DEFAULT '0',
  `Tel` varchar(50) DEFAULT '0',
  `Portable` varchar(50) DEFAULT '0',
  `Fax` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id_Depot`),
  KEY `FK_depot_paye` (`Pays`),
  KEY `FK_depot_ville` (`Ville`),
  CONSTRAINT `FK_s_depot_p_pays` FOREIGN KEY (`Pays`) REFERENCES `p_pays` (`id_pays`),
  CONSTRAINT `FK_depot_ville` FOREIGN KEY (`Ville`) REFERENCES `p_ville` (`id_ville`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.s_depot : ~0 rows (environ)
/*!40000 ALTER TABLE `s_depot` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_depot` ENABLE KEYS */;


-- Export de la structure de table gm. s_famille
CREATE TABLE IF NOT EXISTS `s_famille` (
  `id_famille` int(11) NOT NULL AUTO_INCREMENT,
  `Code_Famille` varchar(50) DEFAULT '0',
  `Intitule_Famille` varchar(50) DEFAULT '0',
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_famille`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.s_famille : ~0 rows (environ)
/*!40000 ALTER TABLE `s_famille` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_famille` ENABLE KEYS */;


-- Export de la structure de table gm. s_fournisseur
CREATE TABLE IF NOT EXISTS `s_fournisseur` (
  `id_fournisseur` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(50) DEFAULT '0',
  `Identite` varchar(50) DEFAULT '0',
  `Raison_Sociale` varchar(50) DEFAULT '0',
  `Pays` int(11) DEFAULT '0',
  `Ville` int(11) DEFAULT '0',
  `Adresse` varchar(50) DEFAULT '0',
  `Tel` varchar(50) DEFAULT '0',
  `Portable` varchar(50) DEFAULT '0',
  `Fax` varchar(50) DEFAULT '0',
  `E_Mail` varchar(50) DEFAULT '0',
  `Site_Web` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id_fournisseur`),
  KEY `FK_fournisseur_paye` (`Pays`),
  KEY `FK_fournisseur_ville` (`Ville`),
  CONSTRAINT `FK_s_fournisseur_p_pays` FOREIGN KEY (`Pays`) REFERENCES `p_pays` (`id_pays`),
  CONSTRAINT `FK_fournisseur_ville` FOREIGN KEY (`Ville`) REFERENCES `p_ville` (`id_ville`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.s_fournisseur : ~0 rows (environ)
/*!40000 ALTER TABLE `s_fournisseur` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_fournisseur` ENABLE KEYS */;


-- Export de la structure de table gm. s_gamme
CREATE TABLE IF NOT EXISTS `s_gamme` (
  `id_gamme` int(11) NOT NULL AUTO_INCREMENT,
  `taille` varchar(50) DEFAULT '0',
  `couleur` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id_gamme`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.s_gamme : ~0 rows (environ)
/*!40000 ALTER TABLE `s_gamme` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_gamme` ENABLE KEYS */;


-- Export de la structure de table gm. s_remise_palier
CREATE TABLE IF NOT EXISTS `s_remise_palier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `debut` double DEFAULT NULL,
  `fin` double DEFAULT NULL,
  `remise` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.s_remise_palier : ~0 rows (environ)
/*!40000 ALTER TABLE `s_remise_palier` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_remise_palier` ENABLE KEYS */;


-- Export de la structure de table gm. s_type_collab
CREATE TABLE IF NOT EXISTS `s_type_collab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intitule_type` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Export de données de la table gm.s_type_collab : ~0 rows (environ)
/*!40000 ALTER TABLE `s_type_collab` DISABLE KEYS */;
/*!40000 ALTER TABLE `s_type_collab` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
