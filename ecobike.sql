﻿SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ecobike
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ecobike`;

-- -----------------------------------------------------
-- Schema ecobike
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ecobike` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ecobike` ;


-- -----------------------------------------------------
-- Table `ecobike`.`Dock`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecobike`.`Dock` ;
CREATE TABLE IF NOT EXISTS `ecobike`.`Dock` (
  `dockID` CHAR(15) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `area` VARCHAR(50) NOT NULL,
  `address` VARCHAR(60) NOT NULL,
  `remainCapacity` INT(15) NOT NULL,
  `maximumCapacity` INT(15) NOT NULL,
  PRIMARY KEY (`DockID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `ecobike`.`Bike`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecobike`.`Bike` ;
CREATE TABLE IF NOT EXISTS `ecobike`.`Bike` (
  `bikeID` INT(15) NOT NULL,
  `type` VARCHAR(50) NOT NULL,
  `numSaddle` INT(15) NOT NULL,
  `numPedal` INT(15) NOT NULL,
  `numSeat` INT(15) NOT NULL,
  `remainBattery` float(15) NULL,
  `maxTime` FLOAT(15) NULL,
  `inUse` INT(15) NOT NULL,
  `value` INT(15) NOT NULL,
  `licensePlate` VARCHAR(50) NOT NULL,
  `DockID` CHAR(15),
  PRIMARY KEY (`bikeID`),
  CONSTRAINT `DockID`
    FOREIGN KEY (`DockID`)
    REFERENCES `ecobike`.`Dock` (`DockID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecobike`.`RentBikeInvoice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecobike`.`RentBikeInvoice` ;

CREATE TABLE IF NOT EXISTS `ecobike`.`RentBikeInvoice` (
  `rentalCode` VARCHAR(50) NOT NULL,
  `bikeID` INT(15) NOT NULL,
  `type` VARCHAR(50) NOT NULL,
  `rentBikeCost` INT(15) NOT NULL,
  `owner` VARCHAR(50) NOT NULL,
  `rentTime` VARCHAR(50) NOT NULL,
  `returnTime` VARCHAR(50) NULL DEFAULT NULL,
  `deposit` INT(15) NULL DEFAULT NULL,
  PRIMARY KEY (`rentalCode`),
  CONSTRAINT `bikeID`
    FOREIGN KEY (`bikeID`)
    REFERENCES `ecobike`.`Bike` (`bikeID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `ecobike`.`PaymentTransaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecobike`.`PaymentTransaction` ;

CREATE TABLE IF NOT EXISTS `ecobike`.`PaymentTransaction` (
  `ID` INT NOT NULL,
  `owner` VARCHAR(50) NOT NULL,
  `transactionContent` VARCHAR(50) NOT NULL,
  `rentalCode` VARCHAR(50) NOT NULL,
  `cardCode` VARCHAR(50) NOT NULL,
  `amount` INT(15) NOT NULL,
  `time` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `rentalCode`
    FOREIGN KEY (`rentalCode`)
    REFERENCES `ecobike`.`RentBikeInvoice` (`rentalCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `dock` VALUES
('HBT', 'Hai Bà Trưng', 'Hà Nội', '295 Đường Bạch Mai, Phường Bạch Mai, Quận Hai Bà Trưng', 27, 30),
('HK', 'Hoàn Kiếm', 'Hà Nội', '20 Lê Thánh Tông, Phường Phan Chu Trinh, Quận Hoàn Kiếm', 27, 30),
('HM', 'Hoàng Mai', 'Hai Bà Trưng', '21 Lê Trọng Tấn, Phường Định Công, Quận Hoàng Mai', 27, 30);

INSERT INTO `bike` VALUES
(20210000, 'singleNormal', 1, 2, 1, NULL, NULL, 0, 1000000, 'HK-001', 'HK'),
(20210001, 'doubleNormal', 2, 4, 1, NULL, NULL, 0, 1375000, 'HK-002', 'HK'),
(20210002, 'singleElectric', 1, 0, 1, 92.1, 60, 0, 1750000, 'HK-003', 'HK'),
(20210003, 'singleNormal', 1, 2, 1, NULL, NULL, 0, 1000000, 'HM-001', 'HM'),
(20210004, 'doubleNormal', 2, 4, 1, NULL, NULL, 0, 1375000, 'HM-002', 'HM'),
(20210005, 'singleElectric', 1, 0, 1, 92.1, 60, 0, 1750000, 'HM-003', 'HM'),
(20210006, 'singleNormal', 1, 2, 1, NULL, NULL, 0, 1000000, 'HBT-001', 'HBT'),
(20210007, 'doubleNormal', 2, 4, 1, NULL, NULL, 0, 1375000, 'HBT-002', 'HBT'),
(20210008, 'singleElectric', 1, 0, 1, 92.1, 60, 0, 1750000, 'HBT-003', 'HBT');



