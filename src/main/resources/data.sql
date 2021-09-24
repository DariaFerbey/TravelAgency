INSERT INTO countries (id, country_name) VALUES (1, 'GERMANY');
INSERT INTO countries (id, country_name) VALUES (2, 'POLAND');
INSERT INTO countries (id, country_name) VALUES (3, 'UKRAINE');
INSERT INTO countries (id, country_name) VALUES (4, 'SPAIN');

INSERT INTO hotels (id, hotel_name, country_id) VALUES (1, 'Grand Hotel Tremezzo', 1);
INSERT INTO hotels (id, hotel_name, country_id) VALUES (2, 'Mandarin Oriental', 2);
INSERT INTO hotels (id, hotel_name, country_id) VALUES (3, 'InterContinental', 3);

INSERT INTO users (id, fullName, role, password) VALUES (5, 'Nick', 'USER', '$2a$10$CJgEoobU2gm0euD4ygru4ukBf9g8fYnPrMvYk.q0GMfOcIDtUhEwC');
INSERT INTO users (id, fullName, role, password) VALUES (6, 'Nora', 'MANAGER', '$2a$10$yYQaJrHzjOgD5wWCyelp0e1Yv1KEKeqUlYfLZQ1OQvyUrnEcX/rOy');
INSERT INTO users (id, fullName, role, password) VALUES (4, 'Mike', 'USER', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO');

INSERT INTO rooms (id, room_number, price, is_available, hotel_id) VALUES (1,123, 550, false, 1);
INSERT INTO rooms (id, room_number, price, is_available, hotel_id) VALUES (2, 43, 100, false, 3);
INSERT INTO rooms (id, room_number, price, is_available, hotel_id) VALUES (3, 234, 250, false, 1);
INSERT INTO rooms (id, room_number, price, is_available, hotel_id) VALUES (4, 4, 150, true, 1);
INSERT INTO rooms (id, room_number, price, is_available, hotel_id) VALUES (5, 6456, 450, true, 3);
INSERT INTO rooms (id, room_number, price, is_available, hotel_id) VALUES (6, 1234, 510,true, 1);

INSERT INTO bookings (id, check_in, check_out, room_id, user_id) VALUES (123, '2021-05-11', '2021-05-13', 1, 4);
INSERT INTO bookings (id, check_in, check_out, room_id, user_id) VALUES (456, '2021-05-07', '2021-05-08', 2, 5);
INSERT INTO bookings (id, check_in, check_out, room_id, user_id) VALUES (789, '2021-05-13', '2021-05-17', 3, 6);