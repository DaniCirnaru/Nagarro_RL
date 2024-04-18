drop database if exists `week11_1`;
create database `week11_1`;

use `week11_1`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
       `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       `name` VARCHAR(50) NOT NULL,
       `username` VARCHAR(50) NOT NULL UNIQUE,
       `balance` DECIMAL(10,2) NOT NULL
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 ;

DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
       `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       `amount` DECIMAL(10,2) NOT NULL,
       `description` VARCHAR(255) NOT NULL,
       `requested_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       `user_id` BIGINT NOT NULL,
       FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

INSERT INTO `user` (`id`, `name`, `username`, `balance`) VALUES (1, "Ion Popescu", "ipopescu", 2500);

INSERT INTO `operation` (`amount`, `description`, `user_id`) VALUES (3000, "Salary payment for April", 1);
INSERT INTO `operation` (`amount`, `description`, `user_id`) VALUES (-500, "expensive-shopping.com purchase", 1);