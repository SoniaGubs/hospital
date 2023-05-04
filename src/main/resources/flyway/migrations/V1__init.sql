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
    name          varchar(45) NOT NULL,
    surname       varchar(45) NOT NULL,
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
    name          varchar(45) NOT NULL,
    surname       varchar(45) NOT NULL,
    gender        varchar(45) NOT NULL,
    date_of_birth date        NOT NULL,
    passport      varchar(45) NOT NULL,
    phone         varchar(45) DEFAULT NULL,
    PRIMARY KEY (id)

);

CREATE TABLE diagnosis
(
    id             INT          NOT NULL AUTO_INCREMENT,
    diagnosis_name VARCHAR(300) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE reception
(
    id                 int  NOT NULL AUTO_INCREMENT,
    patient_id         int  NOT NULL,
    staff_id           int  NOT NULL,
    date_of_admission  date NOT NULL,
    date_of_discharge  date DEFAULT NULL,
    start_diagnosis_id int  DEFAULT NULL,
    final_diagnosis_id int  DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (staff_id) REFERENCES staff (id),
    FOREIGN KEY (patient_id) REFERENCES patient (id),
    FOREIGN KEY (start_diagnosis_id) REFERENCES diagnosis (id),
    FOREIGN KEY (final_diagnosis_id) REFERENCES diagnosis (id)
);



CREATE TABLE treatment
(
    id             int         NOT NULL AUTO_INCREMENT,
    reception_id   int         NOT NULL,
    staff_id       int          DEFAULT NULL,
    treatment_type varchar(45) NOT NULL,
    drug           varchar(200) DEFAULT NULL,
    operation      varchar(200) DEFAULT NULL,
    procedures     varchar(200) DEFAULT NULL,
    status         varchar(45)  DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (reception_id) REFERENCES reception (id),
    FOREIGN KEY (staff_id) REFERENCES staff (id)
);