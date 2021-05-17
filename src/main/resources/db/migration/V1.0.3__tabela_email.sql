CREATE TABLE EMAIL
(
    ID         NUMBER(11) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    EMAIL      VARCHAR(100),
    CLIENTE_ID NUMBER(11),
    CONSTRAINT EMAIL_PK PRIMARY KEY (ID),
    CONSTRAINT EMAIL_CLIENTE_FK FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE (ID)
);