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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.convocatoria: ~0 rows (aproximadamente)
INSERT INTO `convocatoria` (`id`, `titulo`, `descripcion`, `imagen`, `fecha_inicio`, `fecha_fin`, `empresa_id`, `cantidad_max_post`, `created_at`, `updated_at`) VALUES
	(1, 'Pasantía en Marketing Digital', ' Apoya al equipo de marketing en la creación de campañas en redes sociales, análisis de métricas y desarrollo de estrategias publicitarias. Ideal para estudiantes de comunicación, marketing o afines.', 'image_1733186846023.jpg', '2024-12-02 20:00:00.000000', '2024-12-27 20:00:00.000000', 1, 20, '2024-12-02 20:47:26.000000', '2024-12-02 20:47:26.000000'),
	(2, 'Pasantia en desarrollo de software', 'Participa en proyectos ágiles de desarrollo de aplicaciones web y móviles. Aprenderás a trabajar con tecnologías como React, Node.js y bases de datos SQL. Requiere conocimientos básicos de programación.', 'image_1733186949938.jpg', '2024-12-05 20:00:00.000000', '2024-12-27 20:00:00.000000', 2, 40, '2024-12-02 20:49:09.000000', '2024-12-02 20:49:09.000000'),
	(3, 'trabajo remoto en Desarrollo de software', 'Participa en proyectos ágiles de desarrollo de aplicaciones web y móviles. Aprenderás a trabajar con tecnologías como React, Node.js y bases de datos SQL. Requiere conocimientos básicos de programación.', 'image_1733187015669.jpg', '2024-12-06 20:00:00.000000', '2024-12-27 20:00:00.000000', 2, 50, '2024-12-02 20:50:15.000000', '2024-12-02 20:50:15.000000'),
	(4, 'Pasantia en desarrollo de qa automatico', 'Participa en proyectos ágiles de desarrollo de aplicaciones web y móviles. Aprenderás a trabajar con tecnologías como React, Node.js y bases de datos SQL. Requiere conocimientos básicos de programación.', 'image_1733187131167.jpg', '2024-12-02 20:00:00.000000', '2024-12-27 20:00:00.000000', 3, 50, '2024-12-02 20:52:11.000000', '2024-12-02 20:52:11.000000'),
	(5, 'practica preprofesional en desarrollo frontend ', 'Participa en proyectos ágiles de desarrollo de aplicaciones web y móviles. Aprenderás a trabajar con tecnologías como React, Node.js y bases de datos SQL. Requiere conocimientos básicos de programación.', 'image_1733187241146.jpg', '2024-12-02 20:00:00.000000', '2024-12-27 20:00:00.000000', 3, 10, '2024-12-02 20:54:01.000000', '2024-12-02 20:54:01.000000'),
	(6, 'Pasantia en desarollo fullstack', 'Participa en proyectos ágiles de desarrollo de aplicaciones web y móviles. Aprenderás a trabajar con tecnologías como React, Node.js y bases de datos SQL. Requiere conocimientos básicos de programación.', 'image_1733187292205.jpg', '2024-12-02 20:00:00.000000', '2024-12-27 20:00:00.000000', 3, 20, '2024-12-02 20:54:52.000000', '2024-12-02 20:54:52.000000'),
	(7, 'Pasantía en Marketing Digital', 'Apoya al equipo de marketing en la creación de campañas en redes sociales, análisis de métricas y desarrollo de estrategias publicitarias. Ideal para estudiantes de comunicación, marketing o afines.', 'image_1733187354134.jpg', '2024-12-02 20:00:00.000000', '2024-12-27 20:00:00.000000', 4, 25, '2024-12-02 20:55:54.000000', '2024-12-02 20:55:54.000000'),
	(8, 'Pasantía en Diseño Gráfico', 'Contribuye en la creación de piezas gráficas, branding y diseño web para campañas internas y externas. Se valoran habilidades en herramientas como Photoshop, Illustrator o Canva.', 'image_1733187403160.jpg', '2024-12-02 20:00:00.000000', '2024-12-27 20:00:00.000000', 5, 20, '2024-12-02 20:56:43.000000', '2024-12-02 20:56:43.000000'),
	(9, 'Prácticas Preprofesionales en Recursos Humanos', 'Apoya en procesos de reclutamiento, selección y capacitación. Aprende a gestionar bases de datos de candidatos y coordinar actividades de bienestar laboral.', 'image_1733187530319.jpg', '2024-12-02 20:00:00.000000', '2024-12-27 20:00:00.000000', 6, 20, '2024-12-02 20:58:50.000000', '2024-12-02 20:58:50.000000');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.empresa: ~6 rows (aproximadamente)
INSERT INTO `empresa` (`id`, `nombre`, `ubicacion`, `imagen`, `nit`, `usuario`, `contrasenia`, `rol`, `created_at`, `updated_at`) VALUES
	(1, 'JalaSoft', 'Av. Melchor Pérez de Olguín #2643, Cochabamba, Cochabamba · 04 km', 'image_1733185314413.jpg', '1258745154', 'jalaSoft', '12345678', 'empresa', '2024-12-02 20:21:54.000000', '2024-12-02 20:21:54.000000'),
	(2, 'Digital Harbor', 'Av simon lopez y beijing', 'image_1733185570083.jpg', '1458745584', 'digitHar', '12345678', 'empresa', '2024-12-02 20:26:10.000000', '2024-12-02 20:26:10.000000'),
	(3, 'AssureSoft', 'Avenida América 1108, Cochabamba, Cochabamba ', 'image_1733185690879.jpg', '1457895541', 'assure', '12345678', 'empresa', '2024-12-02 20:28:10.000000', '2024-12-02 20:28:10.000000'),
	(4, 'EMBOL', 'Av blanco galindo km 10', 'image_1733185838453.jpg', '125457877', 'embol', '12345678', 'empresa', '2024-12-02 20:30:38.000000', '2024-12-02 20:30:38.000000'),
	(5, 'Coca Cola', 'Calle Tarapacá 754 Ciudad de La Paz (ubicados cerca de la calle Los Andes y Plaza, Bolivia', 'image_1733185934962.jpg', '1258745558', 'cocaCola', '12345678', 'empresa', '2024-12-02 20:32:14.000000', '2024-12-02 20:32:14.000000'),
	(6, 'Grupo editorial Kipus', 'Calle Hamiraya # 122 casi Av. Heroínas, Cochabamba', 'image_1733186022405.jpg', '4127578455', 'kipus', '12345678', 'empresa', '2024-12-02 20:33:42.000000', '2024-12-02 20:33:42.000000');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.postulante: ~0 rows (aproximadamente)
INSERT INTO `postulante` (`id`, `nombre`, `apellido`, `carrera`, `descripcion`, `celular`, `correo`, `usuario`, `contrasenia`, `rol`, `created_at`, `updated_at`) VALUES
	(1, 'Alan Jesús', 'Cáceres Medrano', 'Ing en sistemas', 'Soy desarrollador de software con experiencia en Spring Boot y Angular, con enfoque en implementació', '75971702', 'caceresalan2474@gmail.com', 'alan', '12345678', 'postulante', '2024-12-02 21:00:08.000000', '2024-12-02 21:00:08.000000'),
	(2, 'user', 'user', 'ing en sistemas', 'Soy desarrollador de software con experiencia en Spring Boot y Angular, con enfoque en implementació', '12345678', 'user@email.com', 'user', '12345678', 'postulante', '2024-12-02 21:02:07.000000', '2024-12-02 21:02:07.000000');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla proyecto_movil.postulante_convocatoria: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
