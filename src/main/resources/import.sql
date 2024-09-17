
INSERT INTO `users` (user_username, user_password, user_enabled, user_name, user_lastname, user_email, user_expired, user_locked, user_credentials_expired) VALUES ('admin','$2a$12$uRW7Q4g55kzfGfAtMffCxeldIlz.bDzJjong0HVPBCGTQjNRqpYXa',1, 'Admin', 'Admin','pimba@f.foryou', 1, 0,0);
INSERT INTO `users` (user_username, user_password, user_enabled, user_name, user_lastname, user_email, user_expired, user_locked, user_credentials_expired) VALUES ('antonio','$2a$12$uRW7Q4g55kzfGfAtMffCxeldIlz.bDzJjong0HVPBCGTQjNRqpYXa',1, 'Antonio', 'Escobar Rueda','thumadree@wii.com',0,0,0);

INSERT INTO `roles` (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO `roles` (role_name) VALUES ('ROLE_USER');ﬁ

INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);