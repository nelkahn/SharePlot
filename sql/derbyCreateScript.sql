    
CREATE TABLE SharePlot.PORTFOLIO (
    ID_PORTFOLIO INTEGER GENERATED BY DEFAULT AS IDENTITY  ,
    IS_FAKE CHAR (1)  NOT NULL  ,
    NAME VARCHAR (45)  NOT NULL  ,
  CONSTRAINT PK_PORTFOLIO PRIMARY KEY ( ID_PORTFOLIO  )
);
    
CREATE TABLE SharePlot.SHARE (
    ID_SHARE INTEGER GENERATED BY DEFAULT AS IDENTITY  ,
    CODE_I_S_I_N VARCHAR (45) DEFAULT NULL  ,
    CODE_YAHOO VARCHAR (45) DEFAULT NULL  ,
    DESCRIPTION VARCHAR (4000) DEFAULT NULL  ,
    NAME VARCHAR (255)  NOT NULL  ,
  CONSTRAINT PK_SHARE PRIMARY KEY ( ID_SHARE  )
);
    
CREATE TABLE SharePlot.SHARE_QUANTITY (
    ID_SHARE_QUANTITY INTEGER GENERATED BY DEFAULT AS IDENTITY  ,
    CHANGE_FEE DECIMAL (12)  NOT NULL  ,
    CHANGE_QUANTITY DECIMAL (12)  NOT NULL  ,
    CHANGE_TYPE CHAR (1)  NOT NULL  ,
    CHANGE_VALUE DECIMAL (12)  NOT NULL  ,
    DESCRIPTION VARCHAR (1000) DEFAULT NULL  ,
    ID_PORTFOLIO INTEGER   NOT NULL  ,
    ID_SHARE INTEGER   NOT NULL  ,
    TOTAL_QUANTITY DECIMAL (12) DEFAULT NULL  ,
    VALUE_DATE TIMESTAMP   NOT NULL  ,
  CONSTRAINT PK_SHARE_QUANTITY PRIMARY KEY ( ID_SHARE_QUANTITY  )
);
    
CREATE TABLE SharePlot.SHARE_VALUE (
    ID_SHARE_VALUE INTEGER GENERATED BY DEFAULT AS IDENTITY  ,
    ID_SHARE INTEGER   NOT NULL  ,
    VALUE DECIMAL (10)  NOT NULL  ,
    VALUE_DATE TIMESTAMP   NOT NULL  ,
  CONSTRAINT PK_SHARE_VALUE PRIMARY KEY ( ID_SHARE_VALUE  )
);

