INSERT INTO user (id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username)
VALUES (1, 1, 1, 1, 1, '$2a$12$/YQcWSqenCEEVi/bJhIlpu2IpfU8VtSYfgZIo9x9peJ8oljnp3PFK', 'doc1'),
       (2, 1, 1, 1, 1, '$2a$12$Jwsf7wnobInmJ3Kz5W2LZ.3mwrD6AuODj7ppXNN4umxkcvCAAH5CC', 'doc2'),
       (3, 1, 1, 1, 1, '$2a$12$RY6amAM262s6sBeWe4z0yufJmNRG8prQU2w1DjXuKbG9eTIdQGDdK', 'nur'),
       (4, 1, 1, 1, 1, '$2a$12$uEJVEio2ie3Hy.Xc.QHb/ua7D397NHcsPlVRdKJqdTk0yfnuIVZKq', 'receptionist');

INSERT INTO user_roles (user_id, roles)
VALUES (1, 'ROLE_DOCTOR'),
       (2, 'ROLE_DOCTOR'),
       (3, 'ROLE_NURSE'),
       (4, 'ROLE_RECEPTIONIST');

INSERT INTO staff (id, surname, name, patronymic, email, phone, user_id)
VALUES (1, 'Комаров', 'Никита', 'Андреевич', 'komarov@gmail.com', '80292365578', 1),
       (2, 'Коваль', 'Олег', 'Викторович', 'okoval@mail.ru', '80293698542', 2),
       (3, 'Дроздова', 'Светлана', 'Валерьевна', 'drozdsv@mail.ru', '80335567845', 3),
       (4, 'Фролова', 'Ольга', 'Васильевна', 'frolov@mail.ru', '80291985522', 4);

INSERT INTO patient (id, surname, name, patronymic, gender, passport, date_of_birth, phone)
VALUES (1, 'Коваленко', 'Марина', 'Алексеевна', 'FEMALE', 'HB3155546', '1990-01-25', '80297775535'),
       (2, 'Рогов', 'Павел', 'Алексеевич', 'MALE', 'MP2103346', '1980-03-10', '80298886655'),
       (3, 'Алексеева', 'Татьяна', 'Викторовна', 'FEMALE', 'HB1006156', '2000-06-11', '80293335568'),
       (4, 'Петорва', 'Алла', 'Дмитриевна', 'FEMALE', 'MO2171720', '1995-04-01', '80293795764'),
       (5, 'Рогов', 'Иван', 'Алексеевич', 'MALE', 'MP2187455', '1999-08-01', '80293799964'),
       (6, 'Рогов', 'Василий', 'Игоревич', 'MALE', 'НP7887455', '1969-12-05', '80298896562');

INSERT INTO card (id, patient_id, staff_id, date_of_admission, date_of_discharge,
                  description_diagnosis)
VALUES (1, 6, 1, '2023-03-23', '2023-03-29', 'в стадии обострения, с повышенной сектреторной активностью');


INSERT INTO diagnosis (id, ICD10, name)
VALUES (1, 'K21', 'гастроэзофагеальный рефлюкс'),
       (2, 'K25.1', 'язва желудка остарая с прободением'),
       (3, 'K25.7', 'Хроническая язва желудка без кровотечения или прободения'),
       (4, 'K29.3', 'хронический поверхностный гастрит'),
       (5, 'K29.5', 'хронический гастрит неуточненный'),
       (7, 'K37', 'острый аппендицит неуточненный'),
       (6, 'K30', 'функциональная диспепсия');


INSERT INTO card_diagnosis (id, card_id, diagnosis_id)
VALUES (1, 1, 3),
       (2, 1, 4);

INSERT INTO treatment (id, card_id, staff_id, treatment_type, prescription, date_of_prescription, date_of_completion)
VALUES (1, 1, 1, 'DRUG', 'Alamagel', '2023-03-24', '2023-03-24'),
       (2, 1, 1, 'PROCEDURE', 'Фиброгастроскопия', '2023-03-25', '2023-03-25');
