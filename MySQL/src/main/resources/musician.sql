CREATE DATABASE `bands`;
CREATE TABLE `bands`.`musician` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total_members` int NOT NULL,
  `vocalist` varchar(45) DEFAULT NULL,
  `guitarist` varchar(45) DEFAULT NULL,
  `drummer` varchar(45) DEFAULT NULL,
  `bassist` varchar(45) DEFAULT NULL,
  `concerts` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;