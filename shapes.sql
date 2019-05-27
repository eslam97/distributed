-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2019 at 03:07 PM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shapes`
--

-- --------------------------------------------------------

--
-- Table structure for table `circle`
--

CREATE TABLE `circle` (
  `name` varchar(50) NOT NULL,
  `radius` float NOT NULL,
  `area` float NOT NULL,
  `perimeter` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `circle`
--

INSERT INTO `circle` (`name`, `radius`, `area`, `perimeter`) VALUES
('circle', 1, 3.14, 6.28),
('circle3', 7, 153.86, 43.96),
('shape1', 5, 78.5, 31.4);

-- --------------------------------------------------------

--
-- Table structure for table `rectangle`
--

CREATE TABLE `rectangle` (
  `name` varchar(50) NOT NULL,
  `base` float NOT NULL,
  `sidelength` float NOT NULL,
  `area` float NOT NULL,
  `perimeter` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rectangle`
--

INSERT INTO `rectangle` (`name`, `base`, `sidelength`, `area`, `perimeter`) VALUES
('g', 6, 3, 18, 12),
('rectangle', 1, 4, 4, 16),
('rectangle2', 4, 7, 28, 28);

-- --------------------------------------------------------

--
-- Table structure for table `square`
--

CREATE TABLE `square` (
  `name` varchar(50) NOT NULL,
  `sidelength` float NOT NULL,
  `area` float NOT NULL,
  `perimeter` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `square`
--

INSERT INTO `square` (`name`, `sidelength`, `area`, `perimeter`) VALUES
('square1', 6, 36, 24);

-- --------------------------------------------------------

--
-- Table structure for table `trapezium`
--

CREATE TABLE `trapezium` (
  `name` varchar(50) NOT NULL,
  `side1` float NOT NULL,
  `side2` float NOT NULL,
  `side3` float NOT NULL,
  `side4` float NOT NULL,
  `height` float NOT NULL,
  `area` float NOT NULL,
  `perimeter` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trapezium`
--

INSERT INTO `trapezium` (`name`, `side1`, `side2`, `side3`, `side4`, `height`, `area`, `perimeter`) VALUES
('trapizem1', 4, 5, 8, 6, 10, 45, 23);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `circle`
--
ALTER TABLE `circle`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `rectangle`
--
ALTER TABLE `rectangle`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `square`
--
ALTER TABLE `square`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `trapezium`
--
ALTER TABLE `trapezium`
  ADD PRIMARY KEY (`name`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
