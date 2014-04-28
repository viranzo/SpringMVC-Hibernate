-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-04-2014 a las 00:48:17
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `clientesdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `DNI` int(10) unsigned NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Ape1` varchar(50) NOT NULL,
  `Ape2` varchar(50) DEFAULT NULL,
  `Nick` varchar(10) NOT NULL,
  `Passwd` varchar(10) NOT NULL,
  `Saldo` float DEFAULT NULL,
  `Moroso` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  UNIQUE KEY `Nick_index1064` (`Nick`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`DNI`, `Nombre`, `Ape1`, `Ape2`, `Nick`, `Passwd`, `Saldo`, `Moroso`) VALUES
(14, 'Francisco', 'Lopez', 'Sanchis1', 'franlo', 'fran1', 1000, 0),
(15, 'Pedro', 'Martinez', '', 'peter', 'pet1', 1000, 0),
(25, 'Manolo', 'Perez', 'Aspar', 'manu', 'man1', 815.55, 0),
(33, 'Marcos', 'Heredia', 'Buendia', 'marcs', 'mar1', 1000, 0),
(234, 'Pedro', 'GarcÃ­a', '', 'pega', 'pega1', NULL, NULL),
(367809, 'Guillermo', 'Toro', 'Fuentes', 'guille1', 'gui1', 1000, 0),
(456781, 'Julia', 'Sanchez', 'Guarner', 'juli', 'jul1', 1000, 0),
(31678901, 'Ana', 'Bermejo', 'Beltan', 'anaber', 'ana1', 1000, 0),
(73549228, 'Vicente', 'Iranzo', 'GÃ³mez', 'vte', '1234', NULL, NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
