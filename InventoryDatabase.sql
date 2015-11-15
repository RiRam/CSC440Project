create database Warehouse;
USE Warehouse;
CREATE TABLE `Inventory` (
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

UPDATE Inventory
SET PickedCount=1
WHERE ItemID = 4;

SELECT * FROM Inventory;