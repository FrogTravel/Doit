CREATE TABLE IF NOT EXISTS USERS (
  USER_ID           INT PRIMARY KEY AUTO_INCREMENT,
  Login             VARCHAR(50)  NOT NULL,
  Password          VARCHAR(100) NOT NULL,
  Email             VARCHAR(50)  NOT NULL,
  First_name        VARCHAR(50),
  Last_name         VARCHAR(50),
  BIRTH_DAY         DATE,
  REGISTRATION_DATE DATE         NOT NULL);
