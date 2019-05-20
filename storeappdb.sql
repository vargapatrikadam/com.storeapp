-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2019 at 12:50 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `storeappdb`
--
CREATE DATABASE IF NOT EXISTS `storeappdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `storeappdb`;

-- --------------------------------------------------------

--
-- Table structure for table `manufacturer`
--

CREATE TABLE `manufacturer` (
  `id` int(11) NOT NULL,
  `manufacturer_name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manufacturer`
--

INSERT INTO `manufacturer` (`id`, `manufacturer_name`) VALUES
(1, 'Blizzard'),
(2, 'Ubisoft'),
(3, 'Microsoft'),
(4, 'Huawei'),
(5, 'From Software');

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

CREATE TABLE `payment_method` (
  `id` int(11) NOT NULL,
  `method` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_method`
--

INSERT INTO `payment_method` (`id`, `method`) VALUES
(1, 'BANK_CARD'),
(2, 'C_O_D');

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `id` int(11) NOT NULL,
  `payment_method_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receipt`
--

INSERT INTO `receipt` (`id`, `payment_method_id`, `user_id`) VALUES
(9, 2, 13),
(10, 2, 13),
(11, 1, 13),
(12, 2, 13),
(13, 2, 13),
(14, 2, 13),
(15, 2, 13),
(16, 2, 13),
(17, 2, 13),
(18, 2, 13),
(19, 2, 13),
(20, 2, 13),
(21, 2, 13),
(22, 2, 13),
(23, 2, 13),
(24, 1, 13),
(25, 2, 13),
(26, 1, 13),
(27, 2, 13),
(28, 1, 13),
(29, 2, 13),
(30, 2, 13),
(31, 1, 13),
(32, 2, 13),
(33, 2, 13),
(34, 2, 13),
(35, 2, 13),
(36, 2, 13),
(37, 2, 13),
(38, 2, 13),
(39, 2, 13);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `postal_code` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  `street_number` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `email`, `first_name`, `last_name`, `postal_code`, `city`, `street`, `street_number`) VALUES
(13, 'test', 'test', 'test', 'test', 'test', 'test', 'test', 'test', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `ware`
--

CREATE TABLE `ware` (
  `id` int(11) NOT NULL,
  `ware_name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `manufacturer_id` int(11) NOT NULL,
  `ware_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ware`
--

INSERT INTO `ware` (`id`, `ware_name`, `price`, `manufacturer_id`, `ware_type_id`) VALUES
(1, 'World of Warcraft', 10000, 1, 1),
(2, 'Ghost Recon Wildlands', 7000, 2, 2),
(3, 'Windows 10', 60000, 3, 4),
(4, 'P30 Pro', 220000, 4, 3),
(5, 'Diablo 3', 8000, 1, 1),
(6, 'P30', 160000, 4, 3),
(7, 'Starcraft 2 Collection', 12000, 1, 1),
(8, 'Watch Dogs 2', 6000, 2, 1),
(11, 'Dark Souls 3 Fire Fades Edition', 12000, 5, 1),
(12, 'Sekiro Shadows Die Twice', 15000, 5, 1),
(13, 'Bloodborne', 10000, 5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `ware_receipt`
--

CREATE TABLE `ware_receipt` (
  `id` int(11) NOT NULL,
  `ware_id` int(11) NOT NULL,
  `receipt_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ware_receipt`
--

INSERT INTO `ware_receipt` (`id`, `ware_id`, `receipt_id`) VALUES
(10, 2, 9),
(11, 2, 10),
(12, 1, 10),
(13, 1, 10),
(14, 2, 11),
(15, 1, 11),
(16, 1, 11),
(17, 1, 12),
(18, 1, 13),
(19, 1, 14),
(20, 1, 15),
(21, 1, 16),
(22, 2, 17),
(23, 2, 18),
(24, 1, 19),
(25, 1, 20),
(26, 1, 21),
(27, 1, 22),
(28, 1, 23),
(29, 2, 24),
(30, 2, 25),
(31, 1, 26),
(32, 1, 27),
(33, 2, 28),
(34, 2, 29),
(35, 1, 30),
(36, 5, 31),
(37, 6, 31),
(38, 5, 32),
(39, 4, 32),
(40, 5, 33),
(41, 3, 33),
(42, 3, 33),
(43, 3, 33),
(44, 2, 34),
(45, 3, 35),
(46, 6, 36),
(47, 6, 37),
(48, 4, 37),
(49, 3, 38),
(50, 3, 39);

-- --------------------------------------------------------

--
-- Table structure for table `ware_type`
--

CREATE TABLE `ware_type` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ware_type`
--

INSERT INTO `ware_type` (`id`, `name`) VALUES
(1, 'PC Game'),
(2, 'Console Game'),
(3, 'Mobile phone'),
(4, 'Software');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `manufacturer`
--
ALTER TABLE `manufacturer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_receipt_payment_method1` (`payment_method_id`),
  ADD KEY `fk_receipt_user1` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ware`
--
ALTER TABLE `ware`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_ware_manufacturer1` (`manufacturer_id`),
  ADD KEY `fk_ware_ware_type1` (`ware_type_id`);

--
-- Indexes for table `ware_receipt`
--
ALTER TABLE `ware_receipt`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_ware_receipt_ware1` (`ware_id`),
  ADD KEY `receipt_id` (`receipt_id`);

--
-- Indexes for table `ware_type`
--
ALTER TABLE `ware_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `manufacturer`
--
ALTER TABLE `manufacturer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `receipt`
--
ALTER TABLE `receipt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `ware`
--
ALTER TABLE `ware`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `ware_receipt`
--
ALTER TABLE `ware_receipt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `ware_type`
--
ALTER TABLE `ware_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `fk_receipt_payment_method1` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_receipt_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `ware`
--
ALTER TABLE `ware`
  ADD CONSTRAINT `fk_ware_manufacturer1` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ware_ware_type1` FOREIGN KEY (`ware_type_id`) REFERENCES `ware_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `ware_receipt`
--
ALTER TABLE `ware_receipt`
  ADD CONSTRAINT `fk_ware_receipt_ware1` FOREIGN KEY (`ware_id`) REFERENCES `ware` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ware_receipt_ibfk_1` FOREIGN KEY (`receipt_id`) REFERENCES `receipt` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
