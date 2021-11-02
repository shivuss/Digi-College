-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 09, 2020 at 04:26 AM
-- Server version: 5.5.20
-- PHP Version: 5.3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `staffstudent`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment_reply`
--

CREATE TABLE IF NOT EXISTS `comment_reply` (
  `reply_id` varchar(30) NOT NULL,
  `comment_details` varchar(30) NOT NULL,
  `comment_by` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `dept_id` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dept_id`, `name`) VALUES
('1234', 'bca'),
('123456', '654321'),
('123456', '654321');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE IF NOT EXISTS `feedback` (
  `from` varchar(30) NOT NULL,
  `to` varchar(30) NOT NULL,
  `subject` varchar(30) NOT NULL,
  `details` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`from`, `to`, `subject`, `details`, `date`, `status`) VALUES
('VK', 'Shivu', 'oop', 'excellent', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`, `type`) VALUES
('VK', '123456', 'hod'),
('Pradeep ', '123456', 'staff'),
('Shivu', '654321', 'student'),
('MSY', '123456', 'principal'),
('xyz@gmail.com', '000000', 'staff');

-- --------------------------------------------------------

--
-- Table structure for table `notice`
--

CREATE TABLE IF NOT EXISTS `notice` (
  `nfrom` varchar(30) NOT NULL,
  `to` varchar(30) NOT NULL,
  `message` varchar(30) NOT NULL,
  `details` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notice`
--

INSERT INTO `notice` (`nfrom`, `to`, `message`, `details`, `date`) VALUES
('hod', 'students', 'exams are cancelled', 'due to covid19', '2020-07-08');

-- --------------------------------------------------------

--
-- Table structure for table `query_details`
--

CREATE TABLE IF NOT EXISTS `query_details` (
  `query_id` varchar(30) NOT NULL,
  `student_id` varchar(30) NOT NULL,
  `details` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `query_details`
--

INSERT INTO `query_details` (`query_id`, `student_id`, `details`, `date`, `time`, `status`) VALUES
('123', '17u11968', 'what is phython', '2020-07-08', '10:26:53', 'new');

-- --------------------------------------------------------

--
-- Table structure for table `remarks`
--

CREATE TABLE IF NOT EXISTS `remarks` (
  `reply_id` varchar(30) NOT NULL,
  `remarks` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL,
  `given_by` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reply_details`
--

CREATE TABLE IF NOT EXISTS `reply_details` (
  `query_id` varchar(30) NOT NULL,
  `reply_id` varchar(30) NOT NULL,
  `details` varchar(30) NOT NULL,
  `reply_by` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reply_details`
--

INSERT INTO `reply_details` (`query_id`, `reply_id`, `details`, `reply_by`, `date`, `time`) VALUES
('123', '123', 'python is a programming langua', '17u11968', '2020-07-08', '10:28:29');

-- --------------------------------------------------------

--
-- Table structure for table `staff_details`
--

CREATE TABLE IF NOT EXISTS `staff_details` (
  `staff_id` varchar(30) NOT NULL,
  `staff_name` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `dept_id` varchar(30) NOT NULL,
  `subject` varchar(30) NOT NULL,
  `email_id` varchar(30) NOT NULL,
  `contact_no` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff_details`
--

INSERT INTO `staff_details` (`staff_id`, `staff_name`, `address`, `dept_id`, `subject`, `email_id`, `contact_no`) VALUES
('1234', 'Pradeep', 'masur', '1234', 'oosd', 'pradeep@gmail.com', '0000000000'),
('1234', 'Pramod ', 'haveri', '1234', 'lab', 'pramod@gmail.com', '0000000000'),
('123456', 'xyz', 'Haveri', '3209', 'maths', 'xyz@gmail.com', '000000');

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE IF NOT EXISTS `student_details` (
  `student_id` varchar(30) NOT NULL,
  `student_name` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email_id` varchar(30) NOT NULL,
  `dept_id` varchar(30) NOT NULL,
  `mobile_no` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`student_id`, `student_name`, `address`, `email_id`, `dept_id`, `mobile_no`) VALUES
('1234', 'Shashvita', 'guttal', 'shash@gmail.com', '1234', '0000000000'),
('1234', 'Shivu', 'haveri', 'shivu@gmail.com', '1234', '0000000000');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
