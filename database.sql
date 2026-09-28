CREATE DATABASE Chapter14Mail;
GO


USE Chapter14Mail;
GO


CREATE TABLE EmailList
(
    UserID INT IDENTITY(1,1) PRIMARY KEY,

    Email VARCHAR(100) NOT NULL,

    FirstName VARCHAR(50) NOT NULL,

    LastName VARCHAR(50) NOT NULL
);
GO


SELECT * FROM EmailList;
GO