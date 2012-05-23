
USE [SharePlot]

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


/****** Object:  Table [dbo].[ShareValue]    Generated by JetToolsFramework  ******/
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ShareValue](
  [idShareValue] [INTEGER]  NOT NULL IDENTITY(1,1) ,
  [isShare] [INTEGER]  NOT NULL  ,
  [value] [DECIMAL](10)  NOT NULL  ,
  [valueDate] [datetime]  NOT NULL  ,
 CONSTRAINT [PK_ShareValue] PRIMARY KEY NONCLUSTERED 
(
     [idShareValue] ASC )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE CLUSTERED 
(
     [idShareValue] ASC )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] 
GO
SET ANSI_PADDING OFF
GO

/****** Object:  Table [dbo].[Share]    Generated by JetToolsFramework  ******/
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Share](
  [idShare] [INTEGER]  NOT NULL IDENTITY(1,1) ,
  [code] [VARCHAR](45) NULL DEFAULT NULL  ,
  [datePurchase] [datetime]  NOT NULL  ,
  [description] [VARCHAR](4000) NULL DEFAULT NULL  ,
  [entryFee] [DECIMAL](12) NULL DEFAULT NULL  ,
  [idPortfolio] [INTEGER]  NOT NULL  ,
  [name] [VARCHAR](255)  NOT NULL  ,
  [purchasePrice] [DECIMAL](12)  NOT NULL  ,
 CONSTRAINT [PK_Share] PRIMARY KEY NONCLUSTERED 
(
     [idShare] ASC )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE CLUSTERED 
(
     [idShare] ASC )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] 
GO
SET ANSI_PADDING OFF
GO

/****** Object:  Table [dbo].[ShareQuantity]    Generated by JetToolsFramework  ******/
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ShareQuantity](
  [idShareQuantity] [INTEGER]  NOT NULL IDENTITY(1,1) ,
  [changeFee] [DECIMAL](12)  NOT NULL  ,
  [changeType] [CHAR](1)  NOT NULL  ,
  [idShare] [INTEGER]  NOT NULL  ,
  [shareQuantity] [DECIMAL](12)  NOT NULL  ,
  [shareValue] [DECIMAL](12)  NOT NULL  ,
  [valueDate] [datetime]  NOT NULL  ,
 CONSTRAINT [PK_ShareQuantity] PRIMARY KEY NONCLUSTERED 
(
     [idShareQuantity] ASC )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE CLUSTERED 
(
     [idShareQuantity] ASC )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] 
GO
SET ANSI_PADDING OFF
GO

/****** Object:  Table [dbo].[Portfolio]    Generated by JetToolsFramework  ******/
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Portfolio](
  [idPortfolio] [INTEGER]  NOT NULL IDENTITY(1,1) ,
  [isFake] [CHAR](1)  NOT NULL  ,
  [name] [VARCHAR](45)  NOT NULL  ,
 CONSTRAINT [PK_Portfolio] PRIMARY KEY NONCLUSTERED 
(
     [idPortfolio] ASC )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE CLUSTERED 
(
     [idPortfolio] ASC )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] 
GO
SET ANSI_PADDING OFF
GO



/****** Object:  Add constraints to table [dbo].[ShareValue]    Generated by JetToolsFramework  ******/

ALTER TABLE [dbo].[ShareValue]  WITH CHECK ADD  CONSTRAINT [fk_ShareValue_Share] FOREIGN KEY([isShare] )
REFERENCES [dbo].[Share] ([idShare])
GO
ALTER TABLE [dbo].[ShareValue] CHECK CONSTRAINT [fk_ShareValue_Share]
GO

/****** Object:  Add constraints to table [dbo].[Share]    Generated by JetToolsFramework  ******/

ALTER TABLE [dbo].[Share]  WITH CHECK ADD  CONSTRAINT [fk_Share_Portfolio] FOREIGN KEY([idPortfolio] )
REFERENCES [dbo].[Portfolio] ([idPortfolio])
GO
ALTER TABLE [dbo].[Share] CHECK CONSTRAINT [fk_Share_Portfolio]
GO

/****** Object:  Add constraints to table [dbo].[ShareQuantity]    Generated by JetToolsFramework  ******/

ALTER TABLE [dbo].[ShareQuantity]  WITH CHECK ADD  CONSTRAINT [fk_ShareQuantity_Share] FOREIGN KEY([idShare] )
REFERENCES [dbo].[Share] ([idShare])
GO
ALTER TABLE [dbo].[ShareQuantity] CHECK CONSTRAINT [fk_ShareQuantity_Share]
GO

/****** Object:  Add constraints to table [dbo].[Portfolio]    Generated by JetToolsFramework  ******/



