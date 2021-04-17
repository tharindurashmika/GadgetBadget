-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2021 at 01:21 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `gadgetbadget`
--

-- --------------------------------------------------------

--
-- Table structure for table `order_tab`
--

CREATE TABLE `order_tab` (
  `orderID` int(20) NOT NULL,
  `orderCode` varchar(10) NOT NULL,
  `customerID` varchar(20) NOT NULL,
  `customerEmail` varchar(40) NOT NULL,
  `customerName` varchar(40) NOT NULL,
  `totalAmount` decimal(10,3) NOT NULL,
  `cardNo` varchar(20) NOT NULL,
  `cvvNo` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_tab`
--

INSERT INTO `order_tab` (`orderID`, `orderCode`, `customerID`, `customerEmail`, `customerName`, `totalAmount`, `cardNo`, `cvvNo`) VALUES
(3, '001', 'IT001', 'ashen@gmail.com', 'Ashen', '120.200', '123456788', '888'),
(4, '002', 'IT002', 'kamal@gmail.com', 'Kamal', '50.000', '345678901', '890'),
(5, '003', 'IT003', 'chamath@gmail.com', 'Chamath', '80.000', '344567100', '554'),
(6, '004', 'IT004', 'sajani.r@gmail.com', 'Sajani', '90.500', '56733304', '789'),
(7, '005', 'IT005', 'dumindu@gmail.com', 'Dumindu', '49.990', '122098873', '321'),
(13, '007', 'IT007', 'viru@gmail.com', 'Viru', '120.200', '111111111', '111');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `order_tab`
--
ALTER TABLE `order_tab`
  ADD PRIMARY KEY (`orderID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `order_tab`
--
ALTER TABLE `order_tab`
  MODIFY `orderID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;
