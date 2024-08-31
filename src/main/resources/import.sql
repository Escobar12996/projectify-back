/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  escobar
 * Created: 31 ago 2024
 */
/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (user_username, user_password, user_enabled, user_name, user_lastname, user_email) VALUES ('admin','$2a$10$7PlwH5KtXy7h1dbUgIs0mOu7b0EfPL/J8V1tZC9D8qz2SPOXj3Pae',1, 'Admin', 'Admin','pimba@f.foryou');
INSERT INTO `users` (user_username, user_password, user_enabled, user_name, user_lastname, user_email) VALUES ('antonio','$2a$10$7PlwH5KtXy7h1dbUgIs0mOu7b0EfPL/J8V1tZC9D8qz2SPOXj3Pae',1, 'Antonio', 'Escobar Rueda','thumadree@wii.com');

INSERT INTO `roles` (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO `roles` (role_name) VALUES ('ROLE_USER');

INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);
