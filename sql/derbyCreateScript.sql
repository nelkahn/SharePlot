    
CREATE TABLE SharePlot.SHARE_VALUE (
    ID_SHARE_VALUE INTEGER GENERATED BY DEFAULT AS IDENTITY  ,
    IS_SHARE INTEGER   NOT NULL  ,
    VALUE DECIMAL (10)  NOT NULL  ,
    VALUE_DATE TIMESTAMP   NOT NULL  ,
  CONSTRAINT PK_SHARE_VALUE PRIMARY KEY ( ID_SHARE_VALUE  )
);
    
CREATE TABLE SharePlot.SHARE (
    ID_SHARE INTEGER GENERATED BY DEFAULT AS IDENTITY  ,
    CODE VARCHAR (45) DEFAULT NULL  ,
    DATE_PURCHASE TIMESTAMP   NOT NULL  ,
    DESCRIPTION VARCHAR (4000) DEFAULT NULL  ,
    ENTRY_FEE DECIMAL (12) DEFAULT NULL  ,
    ID_PORTFOLIO INTEGER   NOT NULL  ,
    NAME VARCHAR (255)  NOT NULL  ,
    PURCHASE_PRICE DECIMAL (12)  NOT NULL  ,
  CONSTRAINT PK_SHARE PRIMARY KEY ( ID_SHARE  )
);
    
CREATE TABLE SharePlot.SHARE_QUANTITY (
    ID_SHARE_QUANTITY INTEGER GENERATED BY DEFAULT AS IDENTITY  ,
    CHANGE_FEE DECIMAL (12)  NOT NULL  ,
    CHANGE_TYPE CHAR (1)  NOT NULL  ,
    ID_SHARE INTEGER   NOT NULL  ,
    SHARE_QUANTITY DECIMAL (12)  NOT NULL  ,
    SHARE_VALUE DECIMAL (12)  NOT NULL  ,
    VALUE_DATE TIMESTAMP   NOT NULL  ,
  CONSTRAINT PK_SHARE_QUANTITY PRIMARY KEY ( ID_SHARE_QUANTITY  )
);
    
CREATE TABLE SharePlot.PORTFOLIO (
    ID_PORTFOLIO INTEGER GENERATED BY DEFAULT AS IDENTITY  ,
    IS_FAKE CHAR (1)  NOT NULL  ,
    NAME VARCHAR (45)  NOT NULL  ,
  CONSTRAINT PK_PORTFOLIO PRIMARY KEY ( ID_PORTFOLIO  )
);

