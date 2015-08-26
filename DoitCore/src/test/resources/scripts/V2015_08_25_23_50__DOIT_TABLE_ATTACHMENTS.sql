
CREATE TABLE IF NOT EXISTS ATTACHMENTS (
  ATTACHMENT_ID   INT PRIMARY KEY AUTO_INCREMENT,
  ATTACHMENT_TYPE VARCHAR(5) NOT NULL,
  FILE_LINK       VARCHAR(1000),
  TASK_ID         INT        NOT NULL,
  DESCRIPTION     VARCHAR(1000));


ALTER TABLE ATTACHMENTS ADD FOREIGN KEY (TASK_ID) REFERENCES TASKS (TASK_ID);