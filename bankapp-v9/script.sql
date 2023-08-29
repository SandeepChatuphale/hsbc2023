




	CREATE SCHEMA `bankapp_db` ;

	USE `bankapp_db`;

	 CREATE TABLE `bankapp_db`.`bankaccount_tbl` 
              (
 		 `accountNumber` INT NOT NULL,
		  `holderName` VARCHAR(45) NOT NULL,
		  `balance` DOUBLE NOT NULL,
		   PRIMARY KEY (`accountNumber`)
              );

	ALTER TABLE `bankapp_db`.`bankaccount_tbl` 
	ADD COLUMN `openingDate` DATE NOT NULL AFTER `balance`;


	CREATE TABLE `cms_db`.`student_tbl` (
  `rollNumber` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`rollNumber`));


	CREATE TABLE `cms_db`.`subject_tbl` (
  `name` VARCHAR(20) NOT NULL,
  `marksScored` INT NOT NULL,
  `rNo_FK` INT NULL,
  INDEX `rNo_FK_idx` (`rNo_FK` ASC),
  CONSTRAINT `rNo_FK`
    FOREIGN KEY (`rNo_FK`)
    REFERENCES `cms_db`.`student_tbl` (`rollNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


	
	CREATE TABLE `cms_db`.`subject_tbl` (
  `name` VARCHAR(20) NOT NULL,
  `marksScored` INT NOT NULL,
  `rNo_FK` INT NULL,
    FOREIGN KEY (`rNo_FK`)
    REFERENCES `cms_db`.`student_tbl` (`rollNumber`));
		
















