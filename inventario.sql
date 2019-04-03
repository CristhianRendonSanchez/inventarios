-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-03-2019 a las 15:12:41
-- Versión del servidor: 5.7.21
-- Versión de PHP: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `idProducto` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(100) DEFAULT NULL,
  `valorUnitario` float DEFAULT NULL,
  `cantidadAlmacenada` int(10) UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `valorUnitario`, `cantidadAlmacenada`) VALUES
(1, 'Yuca', 4.56, 23),
(2, 'Papa', 3, 43),
(3, 'Arracacha', 56, 4),
(4, 'as', 2, 221),
(5, 'Banano', 500, 200),
(6, 'Pera', 33, 300);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_has_transaccion`
--

DROP TABLE IF EXISTS `producto_has_transaccion`;
CREATE TABLE IF NOT EXISTS `producto_has_transaccion` (
  `idProducto` int(10) UNSIGNED NOT NULL,
  `idTransaccion` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`idProducto`,`idTransaccion`),
  KEY `Producto_has_Transaccion_FKIndex1` (`idProducto`),
  KEY `Producto_has_Transaccion_FKIndex2` (`idTransaccion`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

DROP TABLE IF EXISTS `transaccion`;
CREATE TABLE IF NOT EXISTS `transaccion` (
  `idTransaccion` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `fechaT` date NOT NULL,
  `nombreProducto` varchar(50) NOT NULL,
  `cantidad` int(10) UNSIGNED DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `devolucion` tinyint(1) NOT NULL,
  PRIMARY KEY (`idTransaccion`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `transaccion`
--

INSERT INTO `transaccion` (`idTransaccion`, `fechaT`, `nombreProducto`, `cantidad`, `precio`, `tipo`, `devolucion`) VALUES
(1, '2018-09-21', 'Yuca', 23, 5, 'entrada', 0),
(2, '2018-09-08', 'Papa', 45, 3, 'entrada', 0),
(3, '2018-09-08', 'Arracacha', 4, 56, 'entrada', 0),
(4, '2018-09-21', 'Papa', 2, 3, 'salida', 0),
(5, '2018-09-08', 'Yuca', 4, 2, 'salida', 1),
(6, '2018-09-08', 'Yuca', 5, 4, 'entrada', 1),
(7, '2018-09-08', 'Yuca', 4, 2, 'dev Salida', 0),
(8, '2018-09-08', 'Yuca', 5, 4, 'dev Entrada', 0),
(9, '2018-09-01', 'as', 221, 2, 'entrada', 0),
(10, '2019-02-22', 'Banano', 200, 500, 'entrada', 0),
(11, '2019-03-21', 'Pera', 300, 33, 'entrada', 0),
(12, '2019-03-21', 'Pera', 200, 56, 'salida', 1),
(13, '2019-03-21', 'Pera', 200, 56, 'dev Salida', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
