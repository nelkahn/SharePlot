
USE BSJA_04


/****** Object:  Copy data to Table [ShareValue]    Generated by JetToolsFramework  ******/
DELETE FROM [ShareValue]

INSERT INTO [ShareValue] (
 [idShareValue] , [isShare] , [value] , [valueDate] )
SELECT
 [idShareValue] , [isShare] , [value] , [valueDate] FROM BSJA_03..[ShareValue]


/****** Object:  Copy data to Table [Share]    Generated by JetToolsFramework  ******/
DELETE FROM [Share]

INSERT INTO [Share] (
 [idShare] , [code] , [datePurchase] , [description] , [entryFee] , [idPortfolio] , [name] , [purchasePrice] )
SELECT
 [idShare] , [code] , [datePurchase] , [description] , [entryFee] , [idPortfolio] , [name] , [purchasePrice] FROM BSJA_03..[Share]


/****** Object:  Copy data to Table [ShareQuantity]    Generated by JetToolsFramework  ******/
DELETE FROM [ShareQuantity]

INSERT INTO [ShareQuantity] (
 [idShareQuantity] , [changeFee] , [changeType] , [idShare] , [shareQuantity] , [shareValue] , [valueDate] )
SELECT
 [idShareQuantity] , [changeFee] , [changeType] , [idShare] , [shareQuantity] , [shareValue] , [valueDate] FROM BSJA_03..[ShareQuantity]


/****** Object:  Copy data to Table [Portfolio]    Generated by JetToolsFramework  ******/
DELETE FROM [Portfolio]

INSERT INTO [Portfolio] (
 [idPortfolio] , [isFake] , [name] )
SELECT
 [idPortfolio] , [isFake] , [name] FROM BSJA_03..[Portfolio]

