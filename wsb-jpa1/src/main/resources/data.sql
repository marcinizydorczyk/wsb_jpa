INSERT INTO Address (city, address_Line1, address_Line2, postal_Code) VALUES
('Kraków', 'ul. Długa 12', 'lok. 5', '31-147'),
('Gdańsk', 'ul. Szeroka 8', NULL, '80-835');
INSERT INTO Doctor (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES
('Tomasz', 'Wiśniewski', '602300300', 't.wisniewski@clinic.pl', 'D200', 'DERMATOLOG', 1),
('Ewa', 'Zielińska', '603400400', 'e.zielinska@clinic.pl', 'D201', 'ORTOPEDA', 2);
INSERT INTO Patient (first_Name, last_Name, telephone_Number, email, patient_Number, date_Of_Birth, address_id) VALUES
('Marek', 'Lewandowski', '500123456', 'marek.lewandowski@pacjent.pl', 'P200', '1978-11-05', 1),
('Katarzyna', 'Kaczmarek', '511654789', 'katarzyna.kaczmarek@pacjent.pl', 'P201', '1989-03-22', 2);
INSERT INTO Visit (description, time, doctor_id, patient_id) VALUES
('Wizyta dermatologiczna', '2025-04-05 10:00:00', 1, 1),
('Konsultacja ortopedyczna', '2025-04-06 11:15:00', 2, 2);
INSERT INTO Medical_Treatment (description, type, visit_id) VALUES
('Badanie skóry', 'DERMATOLOGIA', 1),
('USG kolana', 'ORTOPEDIA', 2);