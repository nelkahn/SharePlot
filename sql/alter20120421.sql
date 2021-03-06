SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `shareplot` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `shareplot` ;

-- -----------------------------------------------------
-- Table `shareplot`.`Share`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `shareplot`.`Share` (
  `idShare` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(255) NOT NULL ,
  `description` VARCHAR(4000) NULL ,
  `code` VARCHAR(45) NULL ,
  `datePurchase` DATE NOT NULL ,
  `purchasePrice` DECIMAL(12,2) NOT NULL ,
  `entryFee` DECIMAL(12,2) NULL ,
  PRIMARY KEY (`idShare`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shareplot`.`ShareQuantity`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `shareplot`.`ShareQuantity` (
  `idShareQuantity` INT NOT NULL AUTO_INCREMENT ,
  `idShare` INT NOT NULL ,
  `valueDate` DATE NOT NULL ,
  `changeType` CHAR(1) NOT NULL ,
  PRIMARY KEY (`idShareQuantity`) ,
  INDEX `fk_ShareQuantity_Share` (`idShare` ASC) ,
  CONSTRAINT `fk_ShareQuantity_Share`
    FOREIGN KEY (`idShare` )
    REFERENCES `shareplot`.`Share` (`idShare` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shareplot`.`ShareValue`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `shareplot`.`ShareValue` (
  `idShareValue` INT NOT NULL AUTO_INCREMENT ,
  `isShare` INT NOT NULL ,
  `valueDate` DATE NOT NULL ,
  `value` DECIMAL(10,2) NOT NULL ,
  PRIMARY KEY (`idShareValue`) ,
  INDEX `fk_ShareValue_Share` (`isShare` ASC) ,
  CONSTRAINT `fk_ShareValue_Share`
    FOREIGN KEY (`isShare` )
    REFERENCES `shareplot`.`Share` (`idShare` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
