-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-04-2025 a las 13:04:46
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `repegames`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avisos`
--

CREATE TABLE `avisos` (
  `idProducto` int(11) DEFAULT NULL,
  `nombreProducto` varchar(255) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cabecerapedido`
--

CREATE TABLE `cabecerapedido` (
  `numPedido` int(11) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `precioTotal` double DEFAULT NULL,
  `fechaPedido` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `nickname` varchar(50) NOT NULL,
  `contrasenya` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombre`, `direccion`, `telefono`, `nickname`, `contrasenya`) VALUES
(1, 'Pepe', 'Madrid', 666000666, 'Pbotella', 'botella');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `copia`
--

CREATE TABLE `copia` (
  `idCopia` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ubicacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lineapedido`
--

CREATE TABLE `lineapedido` (
  `numPedido` int(11) DEFAULT NULL,
  `numLinea` int(11) DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `cantidadProducto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` varchar(11) NOT NULL,
  `nombreProducto` varchar(11) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `precio`, `stock`) VALUES
('N1', 'Nintendo Sw', 300, 20),
('N2', 'Nintendo Sw', 600, 4),
('P1', 'PS3', 100, 50),
('P2', 'PS4', 300, 30),
('P3', 'PS5', 470, 20),
('X1', 'Xbox One X', 170, 40),
('X2', 'Xbox series', 440, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nickname` varchar(255) DEFAULT NULL,
  `contrasenya` varchar(255) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`nickname`, `contrasenya`, `idCliente`, `idEmpleado`) VALUES
('PGarcia', '12345', NULL, 1),
('ISalazar', '5678', NULL, 2),
('Gperez', '2468', NULL, 3),
('Jbasterrechea', '1357', NULL, 4),
('Pbotella', 'botella', 1, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cabecerapedido`
--
ALTER TABLE `cabecerapedido`
  ADD PRIMARY KEY (`numPedido`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD UNIQUE KEY `idCliente` (`idCliente`,`idEmpleado`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `usuarios` (`idCliente`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
