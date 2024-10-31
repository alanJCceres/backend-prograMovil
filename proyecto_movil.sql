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
    ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.convocatoria: ~2 rows (aproximadamente)
INSERT INTO `convocatoria` (`id`, `titulo`, `descripcion`, `imagen`, `fecha_inicio`, `fecha_fin`, `empresa_id`, `cantidad_max_post`, `created_at`, `updated_at`) VALUES
                                                                                                                                                                     (5, 'nuevo titulo3', 'nueva descripcion', '/ruta/imagen.png', '2024-10-11 20:00:00.000000', '2024-10-11 20:00:00.000000', 2, 20, '2024-10-30 22:41:33.000000', '2024-10-30 22:41:33.000000'),
                                                                                                                                                                     (6, 'nuevo titulo4', 'nueva descripcion', '/ruta/imagen.png', '2024-10-11 20:00:00.000000', '2024-10-11 20:00:00.000000', 2, 20, '2024-10-30 22:42:03.000000', '2024-10-30 22:42:03.000000');

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
    ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.empresa: ~7 rows (aproximadamente)
INSERT INTO `empresa` (`id`, `nombre`, `ubicacion`, `imagen`, `nit`, `usuario`, `contrasenia`, `rol`, `created_at`, `updated_at`) VALUES
                                                                                                                                      (2, 'mi nueva empresa', 'mi ubicacion #4877', '/imagen/nuevo.png', '25877777', 'Juan pinto', 'SGDFERY4364GERG43545', 'empresa', '2024-10-28 22:51:21.000000', '2024-10-28 22:51:21.000000'),
                                                                                                                                      (3, 'mi nueva empresa2', 'mi ubicacion #4877', '/imagen/nuevo.png', '25877777', 'Juan pinto', 'SGDFERY4364GERG43545', 'empresa', '2024-10-28 22:59:00.000000', '2024-10-28 22:59:00.000000'),
                                                                                                                                      (4, 'mi nueva empresa3', 'mi ubicacion #4877', '/imagen/nuevo.png', '25877777', 'Juan pinto', 'SGDFERY4364GERG43545', 'empresa', '2024-10-28 23:01:24.000000', '2024-10-28 23:01:24.000000'),
                                                                                                                                      (5, 'mi nueva empresa4', 'mi ubicacion #4877', '/imagen/nuevo.png', '25877777', 'Juan pinto', 'SGDFERY4364GERG43545', 'empresa', '2024-10-29 22:15:47.000000', '2024-10-29 22:15:47.000000'),
                                                                                                                                      (6, 'Prueba', 'Prueba', 'Prueba', 'Prueba', 'Prueba', 'Prueba', 'Prueba', '2024-10-29 22:21:51.000000', '2024-10-29 22:21:51.000000'),
                                                                                                                                      (7, 'Prueba', 'Prueba', 'Prueba', 'Prueba', 'Prueba', 'Prueba', 'Prueba', '2024-10-29 22:22:44.000000', '2024-10-29 22:22:44.000000'),
                                                                                                                                      (8, 'Prueba', 'Prueba', 'Prueba', 'Prueba', 'Prueba', 'Prueba', 'Prueba', '2024-10-29 23:24:22.000000', '2024-10-29 23:24:22.000000');

-- Volcando estructura para tabla proyecto_movil.postulante
CREATE TABLE IF NOT EXISTS `postulante` (
                                            `id` int(11) NOT NULL AUTO_INCREMENT,
    `nombre` varchar(255) NOT NULL,
    `apellido` varchar(255) DEFAULT NULL,
    `carrera` varchar(255) DEFAULT NULL,
    `descripcion` text DEFAULT NULL,
    `aceptado` tinyint(1) DEFAULT 0,
    `curriculum` varchar(255) DEFAULT NULL,
    `celular` varchar(20) DEFAULT NULL,
    `correo` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.postulante: ~0 rows (aproximadamente)

-- Volcando estructura para tabla proyecto_movil.postulantes
CREATE TABLE IF NOT EXISTS `postulantes` (
                                             `id` int(11) NOT NULL AUTO_INCREMENT,
    `id_convocatoria` int(11) DEFAULT NULL,
    `id_postulante` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `id_convocatoria` (`id_convocatoria`),
    KEY `id_postulante` (`id_postulante`),
    CONSTRAINT `postulantes_ibfk_1` FOREIGN KEY (`id_convocatoria`) REFERENCES `convocatoria` (`id`),
    CONSTRAINT `postulantes_ibfk_2` FOREIGN KEY (`id_postulante`) REFERENCES `postulante` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.postulantes: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;