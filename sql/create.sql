SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `shareplot` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `shareplot` ;

-- -----------------------------------------------------
-- Table `shareplot`.`Share`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shareplot`.`Share` (
  `idShare` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(4000) NULL,
  `codeISIN` VARCHAR(45) NULL,
  `codeYahoo` VARCHAR(45) NULL,
  PRIMARY KEY (`idShare`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shareplot`.`Portfolio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shareplot`.`Portfolio` (
  `idPortfolio` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `isFake` CHAR(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idPortfolio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shareplot`.`ShareQuantity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shareplot`.`ShareQuantity` (
  `idShareQuantity` INT NOT NULL AUTO_INCREMENT,
  `idShare` INT NOT NULL,
  `idPortfolio` INT NOT NULL,
  `valueDate` DATE NOT NULL,
  `description` VARCHAR(1000) NULL,
  `changeType` CHAR(1) NOT NULL,
  `changeValue` DECIMAL(12,2) NOT NULL,
  `changeFee` DECIMAL(12,2) NOT NULL,
  `changeQuantity` DECIMAL(12,2) NOT NULL,
  `totalQuantity` DECIMAL(12,2) NULL,
  PRIMARY KEY (`idShareQuantity`),
  INDEX `fk_ShareQuantity_Share_idx` (`idShare` ASC),
  INDEX `fk_ShareQuantity_Portfolio_idx` (`idPortfolio` ASC),
  CONSTRAINT `fk_ShareQuantity_Share`
    FOREIGN KEY (`idShare`)
    REFERENCES `shareplot`.`Share` (`idShare`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ShareQuantity_Portfolio`
    FOREIGN KEY (`idPortfolio`)
    REFERENCES `shareplot`.`Portfolio` (`idPortfolio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shareplot`.`ShareValue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shareplot`.`ShareValue` (
  `idShareValue` INT NOT NULL AUTO_INCREMENT,
  `idShare` INT NOT NULL,
  `valueDate` DATE NOT NULL,
  `value` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idShareValue`),
  INDEX `fk_ShareValue_Share_idx` (`idShare` ASC),
  CONSTRAINT `fk_ShareValue_Share`
    FOREIGN KEY (`idShare`)
    REFERENCES `shareplot`.`Share` (`idShare`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
