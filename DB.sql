-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Warehouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Warehouse` DEFAULT CHARACTER SET latin1 ;
USE `Warehouse` ;

-- -----------------------------------------------------
-- Table `Warehouse`.`Inventory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse`.`Inventory` (
  `ItemID` INT(11) NOT NULL,
  `ItemName` VARCHAR(45) NULL DEFAULT NULL,
  `ItemDescription` VARCHAR(255) NULL DEFAULT NULL,
  `AvailableCount` INT(11) NULL DEFAULT NULL,
  `PickedCount` INT(11) NULL DEFAULT NULL,
  `Location` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ItemID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO Inventory (ItemID, ItemName, ItemDescription, AvailableCount, PickedCount, Location)
VALUES (1, 'Red Chair', 'A red chair.', 4, 2, 'A');
INSERT INTO Inventory (ItemID, ItemName, ItemDescription, AvailableCount, PickedCount, Location)
VALUES (2, 'Blue Table', 'A blue table.', 2, 1, 'B');
INSERT INTO Inventory (ItemID, ItemName, ItemDescription, AvailableCount, PickedCount, Location)
VALUES (3, 'Lamp', 'A lamp.', 6, 1, 'C');
INSERT INTO Inventory (ItemID, ItemName, ItemDescription, AvailableCount, PickedCount, Location)
VALUES (4, 'TV Stand', 'A stand for a TV.', 1, 1, 'D');
INSERT INTO Inventory (ItemID, ItemName, ItemDescription, AvailableCount, PickedCount, Location)
VALUES (5, 'Couch', 'A couch.', 2, 0, 'E');


-- -----------------------------------------------------
-- Table `Warehouse`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse`.`Orders` (
  `OrderID` INT(11) NOT NULL,
  `StoreID` VARCHAR(20) NOT NULL,
  `Comment` VARCHAR(2000) NOT NULL,
  `Status` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`OrderID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

INSERT INTO Orders (OrderID, StoreID, Comment, Status) VALUES (1, 'A1', 'Comment here A.', 'Picked');
INSERT INTO Orders (OrderID, StoreID, Comment, Status) VALUES (2, 'B1', 'Comment here B.', 'Picking');
INSERT INTO Orders (OrderID, StoreID, Comment, Status) VALUES (3, 'C1', 'Comment here C.', 'To Be Picked');


-- -----------------------------------------------------
-- Table `Warehouse`.`OrderLines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse`.`OrderLines` (
  `idOrderLines` INT(11) NOT NULL,
  `OrderID` INT(11) NOT NULL,
  `LineItem` INT(11) NULL DEFAULT NULL,
  `Quantity` INT(11) NULL DEFAULT NULL,
  `Status` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idOrderLines`),
  INDEX `oID_idx` (`OrderID` ASC),
  CONSTRAINT `oID`
    FOREIGN KEY (`OrderID`)
    REFERENCES `Warehouse`.`Orders` (`OrderID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


INSERT INTO `Warehouse`.`OrderLines` 
(`idOrderLines`,
`OrderID`,
`LineItem`,
`Quantity`,
`Status`)
VALUES
(1,
1,
2,
4,
'To Be Picked');


-- -----------------------------------------------------
-- Table `Warehouse`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Warehouse`.`Users` (
  `idUsers` INT(11) NOT NULL,
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsers`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


INSERT INTO `Warehouse`.`Users`
(`idUsers`,
`Username`,
`Password`)
VALUES
(1,
"me",
"hi");


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
