INSERT INTO credential (id, login, password)
VALUES (1, 'doc1', '111'),
       (2, 'doc2', '222'),
       (3, 'nur', '333'),
       (4, 'receptionist', '000');

INSERT INTO staff (id, name, surname, role, email, phone, credential_id)
VALUES (1, 'Nikita', 'Komarov', 'DOCTOR', 'komarov@gmail.com', '80292365578', 1),
       (2, 'Oleg', 'Koval', 'DOCTOR', 'okoval@mail.ru', '80293698542', 2),
       (3, 'Svetlana', 'Drozd', 'NURSE', 'drozdsv@mail.ru', '80335567845', 3),
       (4, 'Olga', 'Frolova', 'RECEPTIONIST', 'frolov@mail.ru', '80291985522', 4);

INSERT INTO patient (id, name, surname, gender, passport, date_of_birth, phone)
VALUES (1, 'Maria', 'Kovaleva', 'FEMALE', 'HB3155546', '1990-01-25', '80297775535'),
       (2, 'Pavel', 'Rogov', 'MALE', 'MP2103346', '1980-03-10', '80298886655'),
       (3, 'Tatiana', 'Alexeeva', 'FEMALE', 'HB1006156', '2000-06-11', '80293335568'),
       (4, 'Alena', 'Petrova', 'FEMALE', 'MO2171720', '1995-04-01', '80293795764');


INSERT INTO diagnosis (id, diagnosis_name)
VALUES (1, 'хронический гастрит с пониженной сектреторной активностью '),
       (2, 'хронический гастрит с пониженной сектреторной активностью в стадии ремиссии'),
       (3, 'острый аппендицит неуточненный'),
       (4, 'язваенная болезнь желудка в стадии обострения с локализацией на малой кривизне тела желудка');



INSERT INTO reception (id, patient_id, staff_id, date_of_admission, date_of_discharge, start_diagnosis_id,
                       final_diagnosis_id)
VALUES (1, 1, 1, '2023-03-23', '2023-03-29', 1, 1),
       (2, 2, 2, '2023-03-24', null, 3, null),
       (3, 3, 1, '2023-03-26', null, 4, null),
       (4, 4, 1, '2023-03-28', null, 4, null);



INSERT INTO treatment (id, reception_id, staff_id, treatment_type, drug, operation, procedures, status)
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