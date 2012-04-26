
-- -----------------------------------------------------
-- Table `SharePlot`.`ShareValue`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `SharePlot`.`ShareValue` (
  `idShareValue` INTEGER(10)  NOT NULL AUTO_INCREMENT ,
  `isShare` INTEGER(10)  NOT NULL  ,
  `valueDate` DATE  NOT NULL  ,
  `value` DECIMAL(10)  NOT NULL  ,
  PRIMARY KEY ( `idShareValue`),
  INDEX `fk_ShareValue_Share` (`isShare` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SharePlot`.`Share`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `SharePlot`.`Share` (
  `idShare` INTEGER(10)  NOT NULL AUTO_INCREMENT ,
  `idPortfolio` INTEGER(10)  NOT NULL  ,
  `name` VARCHAR(255)  NOT NULL  ,
  `description` VARCHAR(4000) NULL DEFAULT NULL  ,
  `code` VARCHAR(45) NULL DEFAULT NULL  ,
  `datePurchase` DATE  NOT NULL  ,
  `purchasePrice` DECIMAL(12)  NOT NULL  ,
  `entryFee` DECIMAL(12) NULL DEFAULT NULL  ,
  PRIMARY KEY ( `idShare`),
  INDEX `fk_Share_Portfolio` (`idPortfolio` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SharePlot`.`ShareQuantity`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `SharePlot`.`ShareQuantity` (
  `idShareQuantity` INTEGER(10)  NOT NULL AUTO_INCREMENT ,
  `idShare` INTEGER(10)  NOT NULL  ,
  `valueDate` DATE  NOT NULL  ,
  `changeType` CHAR(1)  NOT NULL  ,
  `shareValue` DECIMAL(12)  NOT NULL  ,
  `changeFee` DECIMAL(12)  NOT NULL  ,
  `shareQuantity` DECIMAL(12)  NOT NULL  ,
  PRIMARY KEY ( `idShareQuantity`),
  INDEX `fk_ShareQuantity_Share` (`idShare` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SharePlot`.`Portfolio`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `SharePlot`.`Portfolio` (
  `idPortfolio` INTEGER(10)  NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45)  NOT NULL  ,
  `isFake` CHAR(1)  NOT NULL  ,
  PRIMARY KEY ( `idPortfolio`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Add constraints to table `SharePlot`.`ShareValue`
-- -----------------------------------------------------

ALTER TABLE `SharePlot`.`ShareValue` 
  ADD CONSTRAINT `fk_ShareValue_Share`
    FOREIGN KEY (`isShare` )
    REFERENCES `SharePlot`.`Share` (`idShare` ) 
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;


-- -----------------------------------------------------
-- Add constraints to table `SharePlot`.`Share`
-- -----------------------------------------------------

ALTER TABLE `SharePlot`.`Share` 
  ADD CONSTRAINT `fk_Share_Portfolio`
    FOREIGN KEY (`idPortfolio` )
    REFERENCES `SharePlot`.`Portfolio` (`idPortfolio` ) 
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;


-- -----------------------------------------------------
-- Add constraints to table `SharePlot`.`ShareQuantity`
-- -----------------------------------------------------

ALTER TABLE `SharePlot`.`ShareQuantity` 
  ADD CONSTRAINT `fk_ShareQuantity_Share`
    FOREIGN KEY (`idShare` )
    REFERENCES `SharePlot`.`Share` (`idShare` ) 
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;


-- -----------------------------------------------------
-- Add constraints to table `SharePlot`.`Portfolio`
-- -----------------------------------------------------

ALTER TABLE `SharePlot`.`Portfolio` 
;


