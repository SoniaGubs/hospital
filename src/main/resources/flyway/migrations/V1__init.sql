CREATE TABLE credential
(
    id       INT         NOT NULL AUTO_INCREMENT,
    login    VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE staff
(
    id            int         NOT NULL AUTO_INCREMENT,
    surname       varchar(45) NOT NULL,
    name          varchar(45) NOT NULL,
    patronymic    varchar(45) DEFAULT NULL,
    role          varchar(45) NOT NULL,
    email         varchar(45) DEFAULT NULL,
    phone         varchar(45) DEFAULT NULL,
    credential_id int         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (credential_id) REFERENCES credential (id)

);

CREATE TABLE patient
(
    id            int         NOT NULL AUTO_INCREMENT,
    surname       varchar(45) NOT NULL,
    name          varchar(45) NOT NULL,
    patronymic    varchar(45) DEFAULT NULL,
    gender        varchar(45) NOT NULL,
    date_of_birth date        DEFAULT NULL,
    passport      varchar(45) DEFAULT NULL,
    phone         varchar(45) DEFAULT NULL,
    PRIMARY KEY (id)

);

CREATE TABLE card
(
    id                          int  NOT NULL AUTO_INCREMENT,
    patient_id                  int  NOT NULL,
    staff_id                    int          DEFAULT NULL,
    date_of_admission           date NOT NULL,
    date_of_discharge           date         DEFAULT NULL,
    description_start_diagnosis varchar(300) DEFAULT NULL,
    description_final_diagnosis varchar(300) DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (staff_id) REFERENCES staff (id),
    FOREIGN KEY (patient_id) REFERENCES patient (id)

);

CREATE TABLE diagnosis
(
    id    INT          NOT NULL AUTO_INCREMENT,
    ICD10 VARCHAR(40)  NOT NULL,
    name  VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE card_diagnosis
(
    id           INT NOT NULL AUTO_INCREMENT,
    card_id      int NOT NULL,
    diagnosis_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (diagnosis_id) REFERENCES diagnosis (id),
    FOREIGN KEY (card_id) REFERENCES card (id)
);



CREATE TABLE treatment
(
    id                   int         NOT NULL AUTO_INCREMENT,
    card_id              int         NOT NULL,
    date_of_prescription date        NOT NULL,
    treatment_type       varchar(45) NOT NULL,
    prescription         varchar(300) DEFAULT NULL,
    date_of_completion   date         DEFAULT NULL,
    staff_id             int          DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (card_id) REFERENCES card (id),
    FOREIGN KEY (staff_id) REFERENCES staff (id)
);