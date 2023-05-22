CREATE TABLE user
(
    id                      bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    account_non_expired     bit(1) NOT NULL,
    account_non_locked      bit(1) NOT NULL,
    credentials_non_expired bit(1) NOT NULL,
    enabled                 bit(1) NOT NULL,
    password                varchar(255) DEFAULT NULL,
    username                varchar(255) DEFAULT NULL
);

CREATE TABLE user_roles
(
    user_id bigint NOT NULL PRIMARY KEY,
    roles   varchar(255) DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE staff
(
    id         int         NOT NULL AUTO_INCREMENT,
    surname    varchar(45) NOT NULL,
    name       varchar(45) NOT NULL,
    patronymic varchar(45) DEFAULT NULL,
    email      varchar(45) DEFAULT NULL,
    phone      varchar(45) DEFAULT NULL,
    user_id    bigint      NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id)

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
    id                    int  NOT NULL AUTO_INCREMENT,
    patient_id            int  NOT NULL,
    staff_id              int          DEFAULT NULL,
    date_of_admission     date NOT NULL,
    date_of_discharge     date         DEFAULT NULL,
    description_diagnosis varchar(300) DEFAULT NULL,
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