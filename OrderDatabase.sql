CREATE TABLE `Warehouse`.`Orders` (
  `OrderID` INT NOT NULL,
  `StoreID` VARCHAR(20) NULL,
  `Comment` VARCHAR(2000) NULL,
  PRIMARY KEY (`OrderID`));

INSERT INTO Orders (OrderID, StoreID, Comment) VALUES (1, 'A1', 'Comment here A.');
INSERT INTO Orders (OrderID, StoreID, Comment) VALUES (2, 'B1', 'Comment here B.');
INSERT INTO Orders (OrderID, StoreID, Comment) VALUES (3, 'C1', 'Comment here C.');

SELECT * FROM Orders;
