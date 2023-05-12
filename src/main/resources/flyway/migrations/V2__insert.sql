INSERT INTO credential (id, login, password)
VALUES (1, 'doc1', '111'),
       (2, 'doc2', '222'),
       (3, 'nur', '333'),
       (4, 'receptionist', '000');

INSERT INTO staff (id, surname, name, patronymic, role, email, phone, credential_id)
VALUES (1, 'Комаров', 'Никита', 'Андреевич', 'DOCTOR', 'komarov@gmail.com', '80292365578', 1),
       (2, 'Коваль', 'Олег', 'Викторович', 'DOCTOR', 'okoval@mail.ru', '80293698542', 2),
       (3, 'Дроздова', 'Светлана', 'Валерьевна', 'NURSE', 'drozdsv@mail.ru', '80335567845', 3),
       (4, 'Фролова', 'Ольга', 'Васильевна', 'RECEPTIONIST', 'frolov@mail.ru', '80291985522', 4);

INSERT INTO patient (id, surname, name, patronymic, gender, passport, date_of_birth, phone)
VALUES (1, 'Коваленко', 'Марина', 'Алексеевна', 'FEMALE', 'HB3155546', '1990-01-25', '80297775535'),
       (2, 'Рогов', 'Павел', 'Алексеевич', 'MALE', 'MP2103346', '1980-03-10', '80298886655'),
       (3, 'Алексеева', 'Татьяна', 'Викторовна', 'FEMALE', 'HB1006156', '2000-06-11', '80293335568'),
       (4, 'Петорва', 'Алла', 'Дмитриевна', 'FEMALE', 'MO2171720', '1995-04-01', '80293795764');


INSERT INTO card (id, patient_id, staff_id, date_of_admission, date_of_discharge, description_start_diagnosis,
                  description_final_diagnosis)
VALUES (1, 1, 1, '2023-03-23', '2023-03-29', 'в стадии обострения, с повышенной сектреторной активностью',
        'в стадии ремиссии'),
       (2, 2, 2, '2023-03-24', null, 'гастрит в стадии ремиссии', null),
       (3, 3, 1, '2023-03-26', null, null, null),
       (4, 4, 1, '2023-03-28', null, 'в верхней кривизне желудка', null);


INSERT INTO diagnosis (id, ICD10, name)
VALUES (1, 'K29.3', 'хронический поверхностный гастрит'),
       (2, 'K29.5', 'хронический гастрит неуточненный'),
       (3, 'K37', 'острый аппендицит неуточненный'),
       (4, 'K25.7', 'Хроническая язва желудка без кровотечения или прободения');

INSERT INTO card_diagnosis (id, card_id, diagnosis_id)
VALUES (1, 1, 1),
       (2, 2, 1),
       (3, 2, 3),
       (4, 3, 4),
       (5, 4, 1);


INSERT INTO treatment (id, card_id, staff_id, treatment_type, drug, operation, procedures, status)
VALUES (1, 1, 1, 'DRUG', 'Alamagel', 'null', 'null', 'COMPLETED'),
       (2, 1, 3, 'PROCEDURE', 'null', 'null', 'Фиброгастроскопия', 'COMPLETED'),
       (3, 1, 3, 'DRUG', 'Omez 40mg', 'null', 'null', 'COMPLETED'),
       (4, 2, null, 'PROCEDURE', 'null', 'null', 'Узи брюшной-полости', 'NOT_COMPLETED'),
       (5, 2, null, 'OPERATION', 'null', 'Аппендэктомия', 'null', 'NOT_COMPLETED'),
       (6, 2, null, 'DRUG', 'Ceftriaxone', 'null', 'null', 'NOT_COMPLETED'),
       (7, 2, null, 'DRUG', 'Nolpasa 40mg', 'null', 'null', 'NOT_COMPLETED'),
       (8, 3, null, 'DRUG', 'De-nol', 'null', 'null', 'NOT_COMPLETED'),
       (9, 3, null, 'DRUG', 'Peptipak', 'null', 'null', 'NOT_COMPLETED'),
       (10, 4, null, 'DRUG', 'Alamagel', 'null', 'null', 'NOT_COMPLETED'),
       (11, 4, null, 'PROCEDURE', 'null', 'null', 'Фиброгастроскопия', 'NOT_COMPLETED');