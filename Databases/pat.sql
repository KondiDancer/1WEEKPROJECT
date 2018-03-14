-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 13, 2018 at 10:23 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pat`
--

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE `groups` (
  `group_name` varchar(256) NOT NULL,
  `yos` enum('1','2','3','4','5') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`group_name`, `yos`) VALUES
('Second test', '1'),
('Test group', '1');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `student_uob` int(8) NOT NULL,
  `student_name` varchar(256) NOT NULL,
  `yos` enum('1','2','3','4','5') NOT NULL,
  `group_name` varchar(256) DEFAULT NULL,
  `tutor_uob` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`student_uob`, `student_name`, `yos`, `group_name`, `tutor_uob`) VALUES
(17010101, 'Test student', '1', 'Test group', 12010101),
(17010102, 'Second teststudent', '1', 'Test group', 12010101);

-- --------------------------------------------------------

--
-- Table structure for table `tutors`
--

CREATE TABLE `tutors` (
  `tutor_uob` int(8) NOT NULL,
  `tutor_name` varchar(256) NOT NULL,
  `group_name` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tutors`
--

INSERT INTO `tutors` (`tutor_uob`, `tutor_name`, `group_name`) VALUES
(12010101, 'Test tutor', 'Test group'),
(12010102, 'Second testtutor', 'Second test');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`group_name`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_uob`),
  ADD KEY `group_name` (`group_name`),
  ADD KEY `tutor_uob` (`tutor_uob`);

--
-- Indexes for table `tutors`
--
ALTER TABLE `tutors`
  ADD PRIMARY KEY (`tutor_uob`),
  ADD UNIQUE KEY `group_name_unique` (`group_name`),
  ADD UNIQUE KEY `group_name` (`group_name`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`group_name`) REFERENCES `groups` (`group_name`),
  ADD CONSTRAINT `students_ibfk_2` FOREIGN KEY (`tutor_uob`) REFERENCES `tutors` (`tutor_uob`);

--
-- Constraints for table `tutors`
--
ALTER TABLE `tutors`
  ADD CONSTRAINT `tutors_ibfk_1` FOREIGN KEY (`group_name`) REFERENCES `groups` (`group_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
