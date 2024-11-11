-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.32-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para proyecto_movil
CREATE DATABASE IF NOT EXISTS `proyecto_movil` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `proyecto_movil`;

-- Volcando estructura para tabla proyecto_movil.convocatoria
CREATE TABLE IF NOT EXISTS `convocatoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `fecha_inicio` datetime(6) DEFAULT NULL,
  `fecha_fin` datetime(6) DEFAULT NULL,
  `empresa_id` int(11) DEFAULT NULL,
  `cantidad_max_post` int(11) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_convocatoria_empresa` (`empresa_id`) USING BTREE,
  CONSTRAINT `FK_convocatoria_empresa` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.convocatoria: ~4 rows (aproximadamente)
INSERT INTO `convocatoria` (`id`, `titulo`, `descripcion`, `imagen`, `fecha_inicio`, `fecha_fin`, `empresa_id`, `cantidad_max_post`, `created_at`, `updated_at`) VALUES
	(5, 'Pasantia fullstack', 'nueva descripcion', '/ruta/imagen.png', '2024-10-11 20:00:00.000000', '2024-10-11 20:00:00.000000', 2, 20, '2024-10-30 22:41:33.000000', '2024-10-30 22:41:33.000000'),
	(6, 'Pasantia marketing', 'nueva descripcion', '/ruta/imagen.png', '2024-10-11 20:00:00.000000', '2024-10-11 20:00:00.000000', 9, 20, '2024-10-30 22:42:03.000000', '2024-10-30 22:42:03.000000'),
	(7, 'Pasantia contaduria publica', 'Esta es una nueva descripcion', '/ruta/imagen.png', '2024-11-04 21:29:55.000000', '2024-11-04 21:29:56.000000', 2, 10, '2024-11-04 21:30:13.000000', '2024-11-04 21:30:14.000000'),
	(8, 'Practica preprofesional ingenieria en sistemas', 'Bienvenido a esta nueva oportunidad de formarte como ingeniero en sistemas', '/ruta/imagen.png', '2024-11-04 21:31:19.000000', '2024-11-04 21:31:20.000000', 2, 5, '2024-11-04 21:31:28.000000', '2024-11-04 21:31:31.000000');

-- Volcando estructura para tabla proyecto_movil.empresa
CREATE TABLE IF NOT EXISTS `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `ubicacion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nit` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.empresa: ~2 rows (aproximadamente)
INSERT INTO `empresa` (`id`, `nombre`, `ubicacion`, `imagen`, `nit`, `usuario`, `contrasenia`, `rol`, `created_at`, `updated_at`) VALUES
	(2, 'mi nueva empresa', 'mi ubicacion #4877', '/imagen/nuevo.png', '25877777', 'Juan pinto', 'SGDFERY4364GERG43545', 'empresa', '2024-10-28 22:51:21.000000', '2024-10-28 22:51:21.000000'),
	(9, 'JalaRest', 'av simon lopez y beijing', '/imagen/nuevo.png', '4587441', 'alan caceres', '12345678', 'empresa', '2024-11-01 20:16:49.000000', '2024-11-01 20:16:49.000000');

-- Volcando estructura para tabla proyecto_movil.postulante
CREATE TABLE IF NOT EXISTS `postulante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `carrera` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.postulante: ~5 rows (aproximadamente)
INSERT INTO `postulante` (`id`, `nombre`, `apellido`, `carrera`, `descripcion`, `celular`, `correo`, `usuario`, `contrasenia`, `rol`, `created_at`, `updated_at`) VALUES
	(1, 'alan jesus ', 'caceres medrano', 'ingenieria de sistemas', 'soy un estudiante en busca de pasantias', '75971758', 'user@email.com', 'alanJ', '12345678', 'postulante', '2024-11-04 00:00:00.000000', '2024-11-10 21:52:10.000000'),
	(2, 'maria ', 'galindo', 'Lic en contaduria', 'soy una estudiante en busca de pasantias', '75978621', 'user1@email.com', 'mariaG', '12345678', 'postulante', '2024-11-04 00:00:00.000000', '2024-11-10 21:52:09.000000'),
	(3, 'mario Evo', 'Mamani Perez', 'Ingeniera en informatica', 'soy un estudiante entusiaste en busca de practica empresarial', '7598471', 'mario@gmail.com', 'marioMP', '12345678', 'postulante', '2024-11-04 00:00:00.000000', '2024-11-10 21:52:09.000000'),
	(4, 'Rosanelda', 'Perez Cruz', 'Lic en psicologia', 'soy un estudiante entusiaste que busca practicas o pasantias en el area de RRHH', '75978514', 'RosaneldaZ', 'rosanelda12', '12345678', 'postulante', '2024-11-04 00:00:00.000000', '2024-11-10 21:52:08.000000'),
	(5, 'Estefany', 'Ibañez Rodriguez', 'Lic en medicina', 'Soy un estudiante muy proactivo con ganas de aprender', '75971852', 'estefanyIR@gmail.com', 'estefy123', 'password', 'postulante', '2024-11-10 21:52:06.000000', '2024-11-10 21:52:07.000000');

-- Volcando estructura para tabla proyecto_movil.postulante_convocatoria
CREATE TABLE IF NOT EXISTS `postulante_convocatoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aceptado` bit(1) NOT NULL,
  `curriculum` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `convocatoria_id` int(11) DEFAULT NULL,
  `postulante_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhskr8h34hjwhuptg63i0v6vf3` (`convocatoria_id`),
  KEY `FK24ng59ik7nsr17nxaja11nyg3` (`postulante_id`),
  CONSTRAINT `FK24ng59ik7nsr17nxaja11nyg3` FOREIGN KEY (`postulante_id`) REFERENCES `postulante` (`id`),
  CONSTRAINT `FKhskr8h34hjwhuptg63i0v6vf3` FOREIGN KEY (`convocatoria_id`) REFERENCES `convocatoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.postulante_convocatoria: ~10 rows (aproximadamente)
INSERT INTO `postulante_convocatoria` (`id`, `aceptado`, `curriculum`, `created_at`, `updated_at`, `convocatoria_id`, `postulante_id`) VALUES
	(1, b'0', '/documents/curriculum.pdf', '2024-11-04 23:10:02.000000', '2024-11-04 23:10:03.000000', 5, 1),
	(2, b'0', '/documents/curriculum.pdf', '2024-11-04 23:10:04.000000', '2024-11-04 23:10:05.000000', 5, 2),
	(3, b'0', '/documents/cv.pdf', '2024-11-04 23:10:05.000000', '2024-11-04 23:10:06.000000', 8, 3),
	(4, b'0', '/documents/cvUser.pdf', '2024-11-04 23:10:10.000000', '2024-11-04 23:10:06.000000', 8, 4),
	(5, b'0', '/documents/cvUser123.pdf', '2024-11-04 23:10:10.000000', '2024-11-04 23:10:07.000000', 6, 1),
	(6, b'0', '/documents/miCv2.pdf', '2024-11-04 23:10:11.000000', '2024-11-04 23:10:08.000000', 6, 2),
	(7, b'0', '/documents/miCurriculum.pdf', '2024-11-04 23:10:12.000000', '2024-11-04 23:10:09.000000', 6, 3),
	(8, b'0', '/documents/cv(1).pdf', '2024-11-04 23:10:13.000000', '2024-11-04 23:10:09.000000', 6, 4),
	(9, b'0', '/documents/cvEstefy.pdf', '2024-11-10 21:52:41.000000', '2024-11-10 21:52:42.000000', 5, 5),
	(10, b'1', '/documents/cvEstefany2.pdf', '2024-11-10 22:35:42.000000', '2024-11-10 22:35:43.000000', 8, 5);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
