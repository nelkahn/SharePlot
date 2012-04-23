
USE BSJA_04


/****** Object:  Copy data to Table [ShareValue]    Generated by JetToolsFramework  ******/
DELETE FROM [ShareValue]

INSERT INTO [ShareValue] (
 [idShareValue] , [isShare] , [valueDate] , [value] )
SELECT
 [idShareValue] , [isShare] , [valueDate] , [value] FROM BSJA_03..[ShareValue]


/****** Object:  Copy data to Table [Share]    Generated by JetToolsFramework  ******/
DELETE FROM [Share]

INSERT INTO [Share] (
 [idShare] , [name] , [description] , [code] , [datePurchase] , [purchasePrice] , [entryFee] )
SELECT
 [idShare] , [name] , [description] , [code] , [datePurchase] , [purchasePrice] , [entryFee] FROM BSJA_03..[Share]


/****** Object:  Copy data to Table [ShareQuantity]    Generated by JetToolsFramework  ******/
DELETE FROM [ShareQuantity]

INSERT INTO [ShareQuantity] (
 [idShareQuantity] , [idShare] , [valueDate] , [changeType] )
SELECT
 [idShareQuantity] , [idShare] , [valueDate] , [changeType] FROM BSJA_03..[ShareQuantity]

