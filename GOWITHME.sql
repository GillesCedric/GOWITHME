-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  ven. 26 mars 2021 à 10:56
-- Version du serveur :  8.0.18
-- Version de PHP :  7.4.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gowithme`
--
DROP DATABASE IF EXISTS `gowithme`;
CREATE DATABASE IF NOT EXISTS `gowithme` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gowithme`;

-- --------------------------------------------------------

--
-- Structure de la table `cars`
--

DROP TABLE IF EXISTS `cars`;
CREATE TABLE IF NOT EXISTS `cars` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `brand` varchar(15) NOT NULL,
  `model` varchar(20) NOT NULL,
  `color` varchar(15) NOT NULL,
  `registration` varchar(15) NOT NULL,
  `description` varchar(500) NOT NULL,
  `picture` varchar(50) NOT NULL DEFAULT 'default_car.png',
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userId` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_car_userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
CREATE TABLE IF NOT EXISTS `favorites` (
  `userIdFavoriter` int(10) UNSIGNED NOT NULL,
  `userIdFavoritee` int(10) UNSIGNED NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userIdFavoriter`,`userIdFavoritee`),
  KEY `fk_favoritee_userId` (`userIdFavoritee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `identifiers`
--

DROP TABLE IF EXISTS `identifiers`;
CREATE TABLE IF NOT EXISTS `identifiers` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` enum('email','cni','phone','passport') NOT NULL,
  `identifier` varchar(60) NOT NULL,
  `isVerified` tinyint(1) NOT NULL DEFAULT '0',
  `verifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userId` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_identifier_userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `marks`
--

DROP TABLE IF EXISTS `marks`;
CREATE TABLE IF NOT EXISTS `marks` (
  `userIdMarker` int(10) UNSIGNED NOT NULL,
  `userIdMarkee` int(10) UNSIGNED NOT NULL,
  `mark` int(10) UNSIGNED NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userIdMarker`,`userIdMarkee`),
  KEY `fk_markee_userId` (`userIdMarkee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `messages`
--

DROP TABLE IF EXISTS `messages`;
CREATE TABLE IF NOT EXISTS `messages` (
  `userIdMessager` int(10) UNSIGNED NOT NULL,
  `userIdMessagee` int(10) UNSIGNED NOT NULL,
  `message` varchar(500) NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userIdMessager`,`userIdMessagee`),
  KEY `fk_messager_userId` (`userIdMessagee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE IF NOT EXISTS `payments` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `state` varchar(15) NOT NULL,
  `reference` varchar(60) NOT NULL,
  `customerId` varchar(60) NOT NULL,
  `seat` int(10) UNSIGNED NOT NULL,
  `amount` int(10) UNSIGNED NOT NULL,
  `isReceive` tinyint(1) NOT NULL DEFAULT '0',
  `receiveDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isRefund` tinyint(1) NOT NULL DEFAULT '0',
  `refundDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userId` int(10) UNSIGNED NOT NULL,
  `travelId` int(10) UNSIGNED NOT NULL,
  `PaymentMethodId` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_payments_userId` (`userId`),
  KEY `fk_payments_travelId` (`travelId`),
  KEY `fk_payments_paymentMethodIdStripe` (`PaymentMethodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `paypals`
--

DROP TABLE IF EXISTS `paypals`;
CREATE TABLE IF NOT EXISTS `paypals` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userId` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_paypals_userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `preferences`
--

DROP TABLE IF EXISTS `preferences`;
CREATE TABLE IF NOT EXISTS `preferences` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` enum('smoke','animal','music','talk') NOT NULL,
  `value` tinyint(1) NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userId` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_preferences_userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `requests`
--

DROP TABLE IF EXISTS `requests`;
CREATE TABLE IF NOT EXISTS `requests` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `object` varchar(15) DEFAULT NULL,
  `message` text,
  `logFile` varchar(20) NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userId` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_requests_userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `stripes`
--

DROP TABLE IF EXISTS `stripes`;
CREATE TABLE IF NOT EXISTS `stripes` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` int(30) UNSIGNED NOT NULL,
  `expirationMonth` int(2) UNSIGNED NOT NULL,
  `expirationYear` int(2) UNSIGNED NOT NULL,
  `cvv` int(3) UNSIGNED NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userId` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stripes_userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `travels`
--

DROP TABLE IF EXISTS `travels`;
CREATE TABLE IF NOT EXISTS `travels` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `departure` varchar(60) NOT NULL,
  `arrival` varchar(60) NOT NULL,
  `departureDate` date NOT NULL,
  `departureTime` time NOT NULL,
  `description` varchar(500) NOT NULL,
  `seat` int(10) UNSIGNED NOT NULL,
  `amount` int(10) UNSIGNED NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userId` int(10) UNSIGNED NOT NULL,
  `carId` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_travels_userId` (`userId`),
  KEY `fk_travels_carId` (`carId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `lastName` varchar(15) NOT NULL,
  `password` varchar(80) NOT NULL,
  `picture` varchar(30) NOT NULL DEFAULT 'default.png',
  `isAdmin` tinyint(1) NOT NULL DEFAULT '0',
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cars`
--
ALTER TABLE `cars`
  ADD CONSTRAINT `fk_car_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `favorites`
--
ALTER TABLE `favorites`
  ADD CONSTRAINT `fk_favoritee_userId` FOREIGN KEY (`userIdFavoritee`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_favoriter_userId` FOREIGN KEY (`userIdFavoriter`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `identifiers`
--
ALTER TABLE `identifiers`
  ADD CONSTRAINT `fk_identifier_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `fk_markee_userId` FOREIGN KEY (`userIdMarkee`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_marker_userId` FOREIGN KEY (`userIdMarker`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `fk_messagee_userId` FOREIGN KEY (`userIdMessager`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_messager_userId` FOREIGN KEY (`userIdMessagee`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `fk_payments_paymentMethodIdPaypal` FOREIGN KEY (`PaymentMethodId`) REFERENCES `paypals` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_payments_paymentMethodIdStripe` FOREIGN KEY (`PaymentMethodId`) REFERENCES `stripes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_payments_travelId` FOREIGN KEY (`travelId`) REFERENCES `travels` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_payments_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `paypals`
--
ALTER TABLE `paypals`
  ADD CONSTRAINT `fk_paypals_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `preferences`
--
ALTER TABLE `preferences`
  ADD CONSTRAINT `fk_preferences_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `requests`
--
ALTER TABLE `requests`
  ADD CONSTRAINT `fk_requests_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `stripes`
--
ALTER TABLE `stripes`
  ADD CONSTRAINT `fk_stripes_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `travels`
--
ALTER TABLE `travels`
  ADD CONSTRAINT `fk_travels_carId` FOREIGN KEY (`carId`) REFERENCES `cars` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_travels_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
