-- phpMyAdmin SQL Dump
-- version 4.4.1.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Mar 19 Mai 2015 à 11:44
-- Version du serveur :  5.5.42
-- Version de PHP :  5.6.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `Projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `Clients`
--

CREATE TABLE `Clients` (
  `Nom` varchar(30) CHARACTER SET utf8 NOT NULL,
  `Prenom` varchar(30) CHARACTER SET utf8 NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Clients`
--

INSERT INTO `Clients` (`Nom`, `Prenom`, `ID`) VALUES
('Montana', 'Tony', 35);

-- --------------------------------------------------------

--
-- Structure de la table `Concert`
--

CREATE TABLE `Concert` (
  `Titre` varchar(30) NOT NULL,
  `Interprete` varchar(30) NOT NULL,
  `Descriptif` varchar(140) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Concert`
--

INSERT INTO `Concert` (`Titre`, `Interprete`, `Descriptif`) VALUES
('coucou', 'coucou2', 'caca'),
('live1', 'artiste1', 'description de merde'),
('live2', 'Jonnhy', 'Le retour de johnny'),
('live3', 'Britney', 'concert de britney spears'),
('Magic live', 'Madeon', '3h live set');

-- --------------------------------------------------------

--
-- Structure de la table `Resa`
--

CREATE TABLE `Resa` (
  `NbPT` int(11) NOT NULL,
  `NbDT` int(11) NOT NULL,
  `NbVIP` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `Client` int(11) NOT NULL,
  `Spectacle` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Resa`
--

INSERT INTO `Resa` (`NbPT`, `NbDT`, `NbVIP`, `ID`, `Client`, `Spectacle`) VALUES
(1, 5, 0, 33, 456, 'Nouveau live2fou22');

-- --------------------------------------------------------

--
-- Structure de la table `Spectacle`
--

CREATE TABLE `Spectacle` (
  `Date` date NOT NULL,
  `Titre` varchar(30) CHARACTER SET utf8 NOT NULL,
  `Salle` int(11) NOT NULL,
  `NbPT` int(11) NOT NULL,
  `NbDT` int(11) NOT NULL,
  `NbVIP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Spectacle`
--

INSERT INTO `Spectacle` (`Date`, `Titre`, `Salle`, `NbPT`, `NbDT`, `NbVIP`) VALUES
('2015-05-13', 'Concert de folie', 1, 43, 3, 0),
('0000-00-00', 'live de foufifou', 0, 33, 21, 0),
('0000-00-00', 'Magic live', 0, 30, 20, 10),
('2015-04-20', 'Nouveau live', 1, 30, 20, 10),
('2015-04-20', 'Nouveau live2fou', 1, 30, 20, 10),
('2015-04-20', 'Nouveau live2fou22', 1, 30, 20, 10),
('2015-05-12', 'test', 0, 30, 20, 10);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Clients`
--
ALTER TABLE `Clients`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Concert`
--
ALTER TABLE `Concert`
  ADD PRIMARY KEY (`Titre`);

--
-- Index pour la table `Resa`
--
ALTER TABLE `Resa`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `Spectacle`
--
ALTER TABLE `Spectacle`
  ADD PRIMARY KEY (`Titre`);
