INSERT INTO countries (id, country_name) VALUES (1, 'GERMANY');
INSERT INTO countries (id, country_name) VALUES (2, 'POLAND');
INSERT INTO countries (id, country_name) VALUES (3, 'UKRAINE');
INSERT INTO countries (id, country_name) VALUES (4, 'SPAIN');

INSERT INTO hotels (hotel_name, country_id) VALUES ('Grand Hotel Tremezzo', 1);
INSERT INTO hotels (hotel_name, country_id) VALUES ('Mandarin Oriental', 2);
INSERT INTO hotels (hotel_name, country_id) VALUES ('InterContinental', 3);

insert into users (user_id, fullName, role, status, password) values (7, 'admin','MANAGER','ACTIVE',  '$2y$12$6wWu.bjCJegev7tg3l0R9.ZUxKbMyIA2HsMkOwmrT4CnQ75ldJhN6');
INSERT INTO users (user_id, fullName, role, status, password) VALUES (5, 'Nick', 'USER', 'ACTIVE', '$2y$12$6wWu.bjCJegev7tg3l0R9.ZUxKbMyIA2HsMkOwmrT4CnQ75ldJhN6');
INSERT INTO users (user_id, fullName, role, status, password) VALUES (6, 'Nora', 'MANAGER', 'ACTIVE', '$2a$10$yYQaJrHzjOgD5wWCyelp0e1Yv1KEKeqUlYfLZQ1OQvyUrnEcX/rOy');
INSERT INTO users (user_id, fullName, role, status, password) VALUES (4, 'Mike', 'USER', 'ACTIVE', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO');

INSERT INTO rooms (room_number, price, hotel_id) VALUES (123, 550, 1);
INSERT INTO rooms (room_number, price, hotel_id) VALUES (43, 100,  3);
INSERT INTO rooms (room_number, price, hotel_id) VALUES (234, 250, 1);
INSERT INTO rooms (room_number, price, hotel_id) VALUES (4, 150, 1);
INSERT INTO rooms (room_number, price, hotel_id) VALUES (6456, 450, 3);
INSERT INTO rooms (room_number, price, hotel_id) VALUES (1234, 510, 1);

INSERT INTO bookings (id, check_in, check_out, room_number, user_id) VALUES (123, '2021-05-11', '2021-05-13', 123, 4);
INSERT INTO bookings (id, check_in, check_out, room_number, user_id) VALUES (456, '2021-05-07', '2021-05-08', 43, 5);
INSERT INTO bookings (id, check_in, check_out, room_number, user_id) VALUES (789, '2021-05-13', '2021-05-17', 234, 6);