
INSERT INTO `users` (user_username, user_password, user_enabled, user_name, user_lastname, user_email) VALUES ('admin','$2a$12$uRW7Q4g55kzfGfAtMffCxeldIlz.bDzJjong0HVPBCGTQjNRqpYXa',1, 'Admin', 'Admin','pimba@f.foryou');
INSERT INTO `users` (user_username, user_password, user_enabled, user_name, user_lastname, user_email) VALUES ('antonio','$2a$12$uRW7Q4g55kzfGfAtMffCxeldIlz.bDzJjong0HVPBCGTQjNRqpYXa',1, 'Antonio', 'Escobar Rueda','thumadree@wii.com');

INSERT INTO `roles` (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO `roles` (role_name) VALUES ('ROLE_USER');

INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);