-- phpMyAdmin SQL Dump
-- version 4.0.10.19
-- https://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 21 Avril 2017 à 04:48
-- Version du serveur: 5.1.73
-- Version de PHP: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `gm2`
--

-- --------------------------------------------------------

--
-- Structure de la table `m_entete`
--

CREATE TABLE IF NOT EXISTS `m_entete` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `n_piece` varchar(50) DEFAULT '',
  `date_piece` varchar(50) DEFAULT NULL,
  `depot` varchar(50) DEFAULT '',
  `reference` varchar(50) DEFAULT '',
  `affaire` varchar(50) DEFAULT '',
  `type` int(11) DEFAULT NULL,
  `cloture` int(11) DEFAULT '0',
  `id_tiers` int(11) DEFAULT NULL,
  `id_collaborateur` int(11) DEFAULT NULL,
  `date_livraison` varchar(50) DEFAULT '0',
  `mode_payement` int(11) DEFAULT NULL,
  `id_structure` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `n_piece` (`n_piece`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=288 ;



-- --------------------------------------------------------

--
-- Structure de la table `m_lignes`
--

CREATE TABLE IF NOT EXISTS `m_lignes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `n_piece` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `reference_aticle` varchar(50) DEFAULT NULL,
  `n_serie` varchar(50) DEFAULT NULL,
  `pu_ht` varchar(50) DEFAULT NULL,
  `qte` varchar(50) DEFAULT NULL,
  `tva` varchar(50) DEFAULT NULL,
  `pt_ht` float DEFAULT NULL,
  `pt_ttc` float DEFAULT NULL,
  `remise` float DEFAULT NULL,
  `cmup` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=376 ;


CREATE TABLE IF NOT EXISTS `m_reglement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(50) DEFAULT NULL,
  `mode_paiement` int(11) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  `montant` float DEFAULT NULL,
  `solde` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


--
-- Structure de la table `m_reglfacture`
--

CREATE TABLE IF NOT EXISTS `m_reglfacture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_facture` varchar(50) DEFAULT '0',
  `id_reglement` int(11) DEFAULT '0',
  `montant` float DEFAULT '0',
  `date_imputation` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;


--
-- Structure de la table `p_mode_paiement`
--

CREATE TABLE IF NOT EXISTS `p_mode_paiement` (
  `id_mode` int(11) NOT NULL AUTO_INCREMENT,
  `intitule_mode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_mode`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `p_mode_paiement`
--


--
-- Structure de la table `p_pays`
--

CREATE TABLE IF NOT EXISTS `p_pays` (
  `id_pays` int(11) NOT NULL AUTO_INCREMENT,
  `Intitule_Pays` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id_pays`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `p_pays`
--

INSERT INTO `p_pays` (`id_pays`, `Intitule_Pays`, `id_structure`) VALUES
(7, 'Maroc', 1);

-- --------------------------------------------------------

--
-- Structure de la table `p_tva`
--

CREATE TABLE IF NOT EXISTS `p_tva` (
  `id_Tva` int(11) NOT NULL AUTO_INCREMENT,
  `Code_Tva` varchar(50) DEFAULT NULL,
  `Intitule_Tva` varchar(50) DEFAULT NULL,
  `id_structure` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_Tva`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `p_tva`
--

INSERT INTO `p_tva` (`id_Tva`, `Code_Tva`, `Intitule_Tva`, `id_structure`) VALUES
(1, 'tva 20', '20', 1);

-- --------------------------------------------------------

--
-- Structure de la table `p_ville`
--

CREATE TABLE IF NOT EXISTS `p_ville` (
  `id_ville` int(11) NOT NULL AUTO_INCREMENT,
  `Intitule_Ville` varchar(50) NOT NULL DEFAULT '0',
  `pays` int(11) DEFAULT NULL,
  `id_structure` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ville`),
  KEY `FK_p_ville_p_paye` (`pays`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Contenu de la table `p_ville`
--

INSERT INTO `p_ville` (`id_ville`, `Intitule_Ville`, `pays`, `id_structure`) VALUES
(1, 'Agadir', 7, 1),
(2, 'Azrou', 7, 1),
(3, 'Beni Mellal', 7, 1),
(4, 'Berkane', 7, 1),
(5, 'Bou Arfa', 7, 1),
(6, 'Casablanca', 7, 1),
(7, 'El Jadida', 7, 1),
(8, 'El Menzel', 7, 1),
(9, 'Essaouira', 7, 1),
(10, 'Fès', 7, 1),
(11, 'Figuig', 7, 1),
(12, 'Al-Hoceima', 7, 1),
(13, 'Ifrane', 7, 1),
(14, 'Kénitra', 7, 1),
(15, 'Khemis Zemamra', 7, 1),
(16, 'Larache', 7, 1),
(17, 'Marrakech', 7, 1),
(18, 'Meknès', 7, 1),
(19, 'Mohammedia', 7, 1),
(20, 'Moulay Idriss', 7, 1),
(21, 'Nador', 7, 1),
(22, 'Ouarzazate', 7, 1),
(23, 'Ouezzane', 7, 1),
(24, 'Oujda', 7, 1),
(25, 'Rabat', 7, 1),
(26, 'Rachidia', 7, 1),
(27, 'Safi', 7, 1),
(28, 'Salé ', 7, 1),
(29, 'Sefrou', 7, 1),
(30, 'Settat', 7, 1),
(31, 'Sidi Kacem', 7, 1),
(32, 'Tanger', 7, 1),
(33, 'Tan-Tan', 7, 1),
(34, 'Taourirte', 7, 1),
(35, 'Tarfaya', 7, 1),
(36, 'Taroudannt', 7, 1),
(37, 'Tata', 7, 1),
(38, 'Taza', 7, 1),
(39, 'Tétouan', 7, 1),
(40, 'Tinghir', 7, 1),
(41, 'Tiznit', 7, 1),
(42, 'Volubilis', 7, 1),
(43, 'Khénifra', 7, 1),
(44, 'khouribga', 7, 1),
(45, 'Autres', NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `s_affaire`
--

CREATE TABLE IF NOT EXISTS `s_affaire` (
  `id_affaire` int(11) NOT NULL AUTO_INCREMENT,
  `intitule_affaire` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_affaire`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;


-- --------------------------------------------------------

--
-- Structure de la table `s_article`
--

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

  KEY `FK_article_tva` (`Tva`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;


--
-- Structure de la table `s_categorie`
--

CREATE TABLE IF NOT EXISTS `s_categorie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intitule_categorie` varchar(50) DEFAULT NULL,
  `coefficient` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Structure de la table `s_client`
--

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
  KEY `FK_client_ville` (`Ville`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `s_client`
--

INSERT INTO `s_client` (`id_client`, `Code`, `Identite`, `Nom`, `Prenom`, `Pays`, `Ville`, `Adresse`, `Tel`, `Portable`, `Fax`, `E_Mail`, `Site_Web`, `Date_Annivairsaire`, `remise`, `categorie`, `id_carte`, `id_structure`) VALUES
(1, 'CLT0001', 'M.', 'Rajat', 'Abdelilah', 7, 1, 'HAY AL AZEHAR', '0522856947', '066321456', '066321456', 'rajat@gmail.com', '', '20/10/1988', 5, 2, 1, 1),
(2, 'CLT0002', '0', 'Client', 'Comptoir', 7, 1, '0', '0', '0', '0', '0', NULL, NULL, NULL, NULL, 1, 1),
(3, 'Clt0001', '', 'client test', '', 7, 1, '', '', '', '', '', '', '', 0, 4, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `s_collaborateur`
--

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `s_collaborateur`
--

INSERT INTO `s_collaborateur` (`id`, `Code`, `Nom_prenom`, `Pays`, `Ville`, `Adresse`, `Tel`, `Portable`, `Fax`, `E_Mail`, `id_type`, `id_structure`) VALUES
(1, 'acheteur001', 'soumadi mahdi', 0, 0, '0', '0', '0', '0', '0', 1, 1),
(2, 'comercial001', 'rajat kamal', 0, 0, '0', '0', '0', '0', '0', 2, 1),
(3, 'Acheteur', 'Acheteur', 0, 0, '0', '0', '0', '0', '0', 1, 2),
(4, 'commercial', 'commercial', 0, 0, '0', '0', '0', '0', '0', 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `s_depot`
--

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
  KEY `FK_depot_ville` (`Ville`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `s_depot`
--

INSERT INTO `s_depot` (`id_Depot`, `Code_Depot`, `Raison_Sociale`, `Pays`, `Ville`, `Adresse`, `Tel`, `Portable`, `Fax`, `id_structure`) VALUES
(1, 'DB CASA', 'DEPOT CASA', 7, 1, 'HAY AL AZEHAR', '052285694700', '06321456', '', 1),
(2, 'DB RABAT', 'DEPOT RABAT', 7, 25, 'HAY AL MANZAH', '0522856947', '', '', 1),
(3, 'DB AGADIR', 'AGADIR', 7, 1, 'HAY AL KAMRA', '0522856947', '06321456', '', 1),
(4, 'depot casa', 'depot casa', 7, 6, 'casablanca hay alazhar', '0522669988', '0522889966', '0522889966', 2),
(5, 'depot fes', 'dpot fes', 7, 10, 'fes', '0522441177', '0522441177', '0522441177', 2),
(6, 'depot tanger', 'depot tanger', 7, 32, 'tanger', '0522447788', '0522447788', '0522447788', 2);

-- --------------------------------------------------------

--
-- Structure de la table `s_famille`
--

CREATE TABLE IF NOT EXISTS `s_famille` (
  `id_famille` int(11) NOT NULL AUTO_INCREMENT,
  `Code_Famille` varchar(50) DEFAULT '0',
  `Intitule_Famille` varchar(50) DEFAULT '0',
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_famille`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `s_famille`
--

INSERT INTO `s_famille` (`id_famille`, `Code_Famille`, `Intitule_Famille`, `remise`, `image`, `id_structure`) VALUES
(6, 'AR', 'Articles en Argent', 1, 'argent_metal.gif', 1),
(7, 'OR', 'Articles en Or', 3, 'or.jpg', 1),
(8, 'BW', 'Montres BW', 4, 'montre_BW.jpg', 1),
(9, 'test', 'test', 0, '', 1),
(10, 'AR', 'Articles en Argent & métaux divers', 0, '', 2),
(11, 'OR', 'Articles en Or', 0, '', 2),
(12, 'BW', 'Montres BW', 0, '', 2),
(13, 'test', '', 0, '', 2);

-- --------------------------------------------------------

--
-- Structure de la table `s_fournisseur`
--

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
  KEY `FK_fournisseur_ville` (`Ville`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `s_fournisseur`
--

INSERT INTO `s_fournisseur` (`id_fournisseur`, `Code`, `Identite`, `Raison_Sociale`, `Pays`, `Ville`, `Adresse`, `Tel`, `Portable`, `Fax`, `E_Mail`, `Site_Web`, `id_structure`) VALUES
(1, 'FRS0001', 'M.', 'Billot', 7, 6, 'HAY AL AZEHAR', '0522856947', '066321456', '', '', '', 1),
(2, 'frs00001', '', '', 7, 17, '', '', '', '', '', '', 2),
(3, 'said', 'said', 'said', 7, 6, '', '', '', '', '', '', 2);

-- --------------------------------------------------------

--
-- Structure de la table `s_remise_palier`
--

CREATE TABLE IF NOT EXISTS `s_remise_palier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `debut` double DEFAULT NULL,
  `fin` double DEFAULT NULL,
  `remise` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `s_remise_palier`
--

INSERT INTO `s_remise_palier` (`id`, `debut`, `fin`, `remise`, `id_structure`) VALUES
(1, 0, 10, 2, 1),
(2, 11, 20, 3, 1),
(3, 21, 100, 5, 1),
(4, 101, 1000000000, 8, 1),
(5, 0, 9999999999999, 0, 2);

-- --------------------------------------------------------

--
-- Structure de la table `s_type_collab`
--

CREATE TABLE IF NOT EXISTS `s_type_collab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intitule_type` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `s_type_collab`
--

INSERT INTO `s_type_collab` (`id`, `intitule_type`, `id_structure`) VALUES
(1, 'Acheteur', 1),
(2, 'Commercial', 1);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `s_article`
--
ALTER TABLE `s_article`
  ADD CONSTRAINT `FK_article_conditionnement` FOREIGN KEY (`Conditionnement`) REFERENCES `p_conditionnement` (`id_Conditionnement`),
  ADD CONSTRAINT `FK_article_nomenclature` FOREIGN KEY (`Nomenclature`) REFERENCES `p_nomenclature` (`id_Nomenclature`),
  ADD CONSTRAINT `FK_article_tva` FOREIGN KEY (`Tva`) REFERENCES `p_tva` (`id_Tva`),
  ADD CONSTRAINT `FK_article_type` FOREIGN KEY (`Type`) REFERENCES `p_type` (`id_type`),
  ADD CONSTRAINT `FK_article_unite` FOREIGN KEY (`Unite`) REFERENCES `p_unite` (`id_unite`);

--
-- Contraintes pour la table `s_client`
--
ALTER TABLE `s_client`
  ADD CONSTRAINT `FK_client_ville` FOREIGN KEY (`Ville`) REFERENCES `p_ville` (`id_ville`);

--
-- Contraintes pour la table `s_depot`
--
ALTER TABLE `s_depot`
  ADD CONSTRAINT `FK_depot_ville` FOREIGN KEY (`Ville`) REFERENCES `p_ville` (`id_ville`);

--
-- Contraintes pour la table `s_fournisseur`
--
ALTER TABLE `s_fournisseur`
  ADD CONSTRAINT `FK_fournisseur_ville` FOREIGN KEY (`Ville`) REFERENCES `p_ville` (`id_ville`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
