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

-- Volcando estructura para procedimiento proyecto_movil.actualizar_estado
DELIMITER //
CREATE PROCEDURE `actualizar_estado`()
BEGIN
    UPDATE convocatoria
    SET estado = CASE
        WHEN CURRENT_DATE < fecha_inicio_reclutamiento THEN 'Por comenzar'
        WHEN CURRENT_DATE BETWEEN fecha_inicio_reclutamiento AND fecha_fin_reclutamiento THEN 'En curso'
        WHEN CURRENT_DATE BETWEEN fecha_inicio_seleccion AND fecha_fin_seleccion THEN 'En selección'
        ELSE 'Finalizado'
    END;
END//
DELIMITER ;

-- Volcando estructura para evento proyecto_movil.actualizar_estado_event
DELIMITER //
CREATE EVENT `actualizar_estado_event` ON SCHEDULE EVERY 1 DAY STARTS '2024-12-08 00:01:00' ON COMPLETION PRESERVE ENABLE DO CALL actualizar_estado()//
DELIMITER ;

-- Volcando estructura para tabla proyecto_movil.convocatoria
CREATE TABLE IF NOT EXISTS `convocatoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `empresa_id` int(11) DEFAULT NULL,
  `cantidad_max_post` int(11) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `estado` varchar(255) DEFAULT 'Por comenzar',
  `fecha_inicio_reclutamiento` datetime(6) DEFAULT NULL,
  `fecha_fin_reclutamiento` datetime(6) DEFAULT NULL,
  `fecha_inicio_seleccion` datetime(6) DEFAULT NULL,
  `fecha_fin_seleccion` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_convocatoria_empresa` (`empresa_id`) USING BTREE,
  CONSTRAINT `FK_convocatoria_empresa` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.convocatoria: ~6 rows (aproximadamente)
INSERT INTO `convocatoria` (`id`, `titulo`, `descripcion`, `imagen`, `empresa_id`, `cantidad_max_post`, `created_at`, `updated_at`, `estado`, `fecha_inicio_reclutamiento`, `fecha_fin_reclutamiento`, `fecha_inicio_seleccion`, `fecha_fin_seleccion`) VALUES
	(1, 'pasantia desarollo fullstack', 'descripcion', 'convocatoria2.png', 2, 15, '2024-12-08 18:36:34.000000', '2024-12-08 18:36:35.000000', 'Por comenzar', '2024-12-09 18:36:40.000000', '2024-12-10 10:36:50.000000', '2024-12-11 18:37:19.000000', '2024-12-12 22:37:33.000000'),
	(2, 'pasantia de contaduria', 'descripcion', 'convocatoria3.png', 7, 25, '2024-12-08 18:38:48.000000', '2024-12-08 18:38:49.000000', 'Por comenzar', '2024-12-10 18:38:55.000000', '2024-12-11 18:39:12.000000', '2024-12-12 18:39:18.000000', '2024-12-13 18:39:21.000000'),
	(3, 'pasantia diseño grafico', 'nueva descripcion', 'convocatoria3.png', 1, 50, '2024-12-08 19:13:42.000000', '2024-12-08 19:13:43.000000', 'Por comenzar', '2024-12-09 19:13:49.000000', '2024-12-10 19:13:58.000000', '2024-12-11 19:14:03.000000', '2024-12-12 19:14:07.000000'),
	(4, 'pasantia calidad de software', 'nueva descripcion', 'convocatoria2.png', 1, 10, '2024-12-08 19:15:08.000000', '2024-12-08 19:15:09.000000', 'En selección', '2024-12-01 19:15:14.000000', '2024-12-07 19:15:20.000000', '2024-12-08 19:15:24.000000', '2024-12-15 19:15:27.000000'),
	(5, 'practica empresarial en ventas', 'nueva descripcion', 'convocatoria1.png', 1, 14, '2024-12-08 19:16:10.000000', '2024-12-08 19:16:11.000000', 'Finalizado', '2024-12-01 19:16:14.000000', '2024-12-05 19:16:15.000000', '2024-12-06 19:16:28.000000', '2024-12-07 19:16:32.000000'),
	(13, 'pasantia marketing', 'nueva descripcion', 'convocatoria1.png', 1, 20, '2024-12-08 11:21:22.000000', '2024-12-08 11:21:22.000000', 'En curso', '2024-12-07 20:00:00.000000', '2024-12-12 20:00:00.000000', '2024-12-13 20:00:00.000000', '2024-12-14 20:00:00.000000');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.empresa: ~3 rows (aproximadamente)
INSERT INTO `empresa` (`id`, `nombre`, `ubicacion`, `imagen`, `nit`, `usuario`, `contrasenia`, `rol`, `created_at`, `updated_at`) VALUES
	(1, 'SoftBlock S.R.L', 'av simon lopez', 'empresa1.png', '123345678', 'empresa1', '12345678', 'empresa', '2024-12-08 11:13:17.000000', '2024-12-08 12:03:57.000000'),
	(2, 'empresa 3', 'av beijing', 'empresa3.png', '11356565', 'empresa3', '12345678', 'empresa', '2024-12-08 18:35:20.000000', '2024-12-08 18:35:21.000000'),
	(7, 'mi nueva empresa1', 'mi ubicacion #4877', 'empresa2.png', '25877777', 'empresa2', '12345678', 'empresa', '2024-12-08 12:00:48.000000', '2024-12-08 12:00:48.000000');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.postulante: ~3 rows (aproximadamente)
INSERT INTO `postulante` (`id`, `nombre`, `apellido`, `carrera`, `descripcion`, `celular`, `correo`, `usuario`, `contrasenia`, `rol`, `created_at`, `updated_at`) VALUES
	(1, 'usuario prueba 2', 'apellido', 'Ing en sistemas', 'descripcion personal', '7597865', 'user2@email.com', 'user2', '12345678', 'postulante', '2024-12-08 18:40:40.000000', '2024-12-08 18:40:42.000000'),
	(2, 'usuario prueba 3', 'apellido', 'Ing en sistemas', 'descripcion personal', '75978402', '202009972@est.umss.edu', 'alan', '12345678', 'postulante', '2024-12-08 18:41:28.000000', '2024-12-08 18:41:31.000000'),
	(3, 'usuario prubea 1', 'apellido', 'Ing en sistemas', 'soy un estudiante en busca de pasantias', '75975555', 'user@email.com', 'user1', '12345678', 'postulante', '2024-12-08 12:24:19.000000', '2024-12-08 12:29:13.000000');

-- Volcando estructura para tabla proyecto_movil.postulante_convocatoria
CREATE TABLE IF NOT EXISTS `postulante_convocatoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `curriculum` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT 'Pendiente',
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `convocatoria_id` int(11) DEFAULT NULL,
  `postulante_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhskr8h34hjwhuptg63i0v6vf3` (`convocatoria_id`),
  KEY `FK24ng59ik7nsr17nxaja11nyg3` (`postulante_id`),
  CONSTRAINT `FK24ng59ik7nsr17nxaja11nyg3` FOREIGN KEY (`postulante_id`) REFERENCES `postulante` (`id`),
  CONSTRAINT `FKhskr8h34hjwhuptg63i0v6vf3` FOREIGN KEY (`convocatoria_id`) REFERENCES `convocatoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.postulante_convocatoria: ~9 rows (aproximadamente)
INSERT INTO `postulante_convocatoria` (`id`, `curriculum`, `estado`, `created_at`, `updated_at`, `convocatoria_id`, `postulante_id`) VALUES
	(1, 'miCv.pdf', 'Pendiente', '2024-12-08 18:42:52.000000', '2024-12-08 18:42:53.000000', 13, 1),
	(2, 'miCv.pdf', 'Pendiente', '2024-12-08 18:42:28.000000', '2024-12-08 18:42:29.000000', 2, 1),
	(3, 'miCv.pdf', 'Pendiente', '2024-12-08 12:32:55.000000', '2024-12-08 18:05:35.000000', 13, 3),
	(4, 'miCv.pdf', 'Pendiente', '2024-12-08 18:42:11.000000', '2024-12-08 18:42:12.000000', 1, 2),
	(5, 'miCv.pdf', 'Pendiente', '2024-12-08 18:43:15.000000', '2024-12-08 18:43:16.000000', 13, 2),
	(6, 'miCv.pdf', 'Pendiente', '2024-12-08 18:43:33.000000', '2024-12-08 18:43:33.000000', 1, 1),
	(7, 'miCv.pdf', 'Pendiente', '2024-12-08 18:43:54.000000', '2024-12-08 18:43:54.000000', 1, 3),
	(8, 'miCv.pdf', 'Pendiente', '2024-12-08 18:44:11.000000', '2024-12-08 18:44:12.000000', 2, 2),
	(9, 'miCv.pdf', 'Pendiente', '2024-12-08 18:44:30.000000', '2024-12-08 18:44:31.000000', 2, 3);

-- Volcando estructura para disparador proyecto_movil.actualizar_estado_convocatoria
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER actualizar_estado_convocatoria
BEFORE INSERT ON convocatoria
FOR EACH ROW
BEGIN
    DECLARE hoy DATE;
    SET hoy = CURRENT_DATE();

    -- Determinar el estado según las fechas
    IF hoy < NEW.fecha_inicio_reclutamiento THEN
        SET NEW.estado = 'Por comenzar';
    ELSEIF hoy BETWEEN NEW.fecha_inicio_reclutamiento AND NEW.fecha_fin_reclutamiento THEN
        SET NEW.estado = 'En curso';
    ELSEIF hoy BETWEEN NEW.fecha_inicio_seleccion AND NEW.fecha_fin_seleccion THEN
        SET NEW.estado = 'En selección';
    ELSEIF hoy > NEW.fecha_fin_seleccion THEN
        SET NEW.estado = 'Finalizado';
    END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
