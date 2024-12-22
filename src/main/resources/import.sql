
INSERT INTO `users` (user_username, user_password, user_enabled, user_name, user_lastname, user_email, user_expired, user_locked, user_credentials_expired) VALUES ('admin','$2a$12$MfuZWqEXHIlDR/hz/74yvOMr1LXuRdfNZSLvALRxq5JoLf8sa7bQa',1, 'Admin', 'Admin','pimba@f.foryou', 0, 0,0);
INSERT INTO `users` (user_username, user_password, user_enabled, user_name, user_lastname, user_email, user_expired, user_locked, user_credentials_expired) VALUES ('antonio','$2a$12$MfuZWqEXHIlDR/hz/74yvOMr1LXuRdfNZSLvALRxq5JoLf8sa7bQa',1, 'Antonio', 'Escobar Rueda','thumadree@wii.com',0,0,0);

INSERT INTO `roles` (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO `roles` (role_name) VALUES ('ROLE_USER');

INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);