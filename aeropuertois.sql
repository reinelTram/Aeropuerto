-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-08-2021 a las 18:23:24
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aeropuertois`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aviones`
--

CREATE TABLE `aviones` (
  `matricula_avion` varchar(7) NOT NULL,
  `modelo_avion` varchar(30) NOT NULL,
  `cedula_propietario` varchar(12) NOT NULL,
  `codigo_contrato` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aviones`
--

INSERT INTO `aviones` (`matricula_avion`, `modelo_avion`, `cedula_propietario`, `codigo_contrato`) VALUES
('mt001', 'Airbus001', '111111', 'ct2021001'),
('mt200', 'Airbus200', '121212', 'ct2021002');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contratos`
--

CREATE TABLE `contratos` (
  `codigo_contrato` varchar(15) NOT NULL,
  `valor_contrato` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `contratos`
--

INSERT INTO `contratos` (`codigo_contrato`, `valor_contrato`) VALUES
('ct2021001', 16000000),
('ct2021002', 64000000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hangares`
--

CREATE TABLE `hangares` (
  `codigo_hangar` varchar(6) NOT NULL,
  `cupos_totales_hangar` int(4) NOT NULL,
  `cupos_disponibles_hangar` int(4) NOT NULL,
  `cupos_reservados_hangar` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hangares`
--

INSERT INTO `hangares` (`codigo_hangar`, `cupos_totales_hangar`, `cupos_disponibles_hangar`, `cupos_reservados_hangar`) VALUES
('160', 16, 14, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hangares_aviones`
--

CREATE TABLE `hangares_aviones` (
  `codigo_hangar` varchar(6) NOT NULL,
  `matricula_avion` varchar(7) NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  `numero_celda` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hangares_aviones`
--

INSERT INTO `hangares_aviones` (`codigo_hangar`, `matricula_avion`, `fecha_ingreso`, `numero_celda`) VALUES
('160', 'mt001', '2021-08-17 09:15:58', 1),
('160', 'mt200', '2021-08-17 11:01:12', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodos_pago`
--

CREATE TABLE `metodos_pago` (
  `codigo_metodo_pago` int(3) NOT NULL,
  `nombre_metodo_pago` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `metodos_pago`
--

INSERT INTO `metodos_pago` (`codigo_metodo_pago`, `nombre_metodo_pago`) VALUES
(1, 'credito'),
(2, 'contado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietarios`
--

CREATE TABLE `propietarios` (
  `cedula_propietario` varchar(12) NOT NULL,
  `nombre_propietario` varchar(45) NOT NULL,
  `apellido_propietario` varchar(30) NOT NULL,
  `codigo_metodo_pago` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `propietarios`
--

INSERT INTO `propietarios` (`cedula_propietario`, `nombre_propietario`, `apellido_propietario`, `codigo_metodo_pago`) VALUES
('111111', 'Maluma', 'nose', 1),
('121212', 'Jake', 'Balvin', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aviones`
--
ALTER TABLE `aviones`
  ADD PRIMARY KEY (`matricula_avion`),
  ADD KEY `fk_cedula_propietario` (`cedula_propietario`) USING BTREE,
  ADD KEY `fk_codigo_contrato` (`codigo_contrato`) USING BTREE;

--
-- Indices de la tabla `contratos`
--
ALTER TABLE `contratos`
  ADD PRIMARY KEY (`codigo_contrato`);

--
-- Indices de la tabla `hangares`
--
ALTER TABLE `hangares`
  ADD PRIMARY KEY (`codigo_hangar`);

--
-- Indices de la tabla `hangares_aviones`
--
ALTER TABLE `hangares_aviones`
  ADD KEY `fk_matricula_avion` (`matricula_avion`),
  ADD KEY `fk_codigo_hangar` (`codigo_hangar`);

--
-- Indices de la tabla `metodos_pago`
--
ALTER TABLE `metodos_pago`
  ADD PRIMARY KEY (`codigo_metodo_pago`);

--
-- Indices de la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD PRIMARY KEY (`cedula_propietario`),
  ADD KEY `fk_codigo_metodo_pago` (`codigo_metodo_pago`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `metodos_pago`
--
ALTER TABLE `metodos_pago`
  MODIFY `codigo_metodo_pago` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aviones`
--
ALTER TABLE `aviones`
  ADD CONSTRAINT `fk_cedula_propietario` FOREIGN KEY (`cedula_propietario`) REFERENCES `propietarios` (`cedula_propietario`),
  ADD CONSTRAINT `fk_codigo_contrato` FOREIGN KEY (`codigo_contrato`) REFERENCES `contratos` (`codigo_contrato`);

--
-- Filtros para la tabla `hangares_aviones`
--
ALTER TABLE `hangares_aviones`
  ADD CONSTRAINT `fk_codigo_hangar` FOREIGN KEY (`codigo_hangar`) REFERENCES `hangares` (`codigo_hangar`),
  ADD CONSTRAINT `fk_matricula_avion` FOREIGN KEY (`matricula_avion`) REFERENCES `aviones` (`matricula_avion`);

--
-- Filtros para la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD CONSTRAINT `fk_codigo_metodo_pago` FOREIGN KEY (`codigo_metodo_pago`) REFERENCES `metodos_pago` (`codigo_metodo_pago`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
