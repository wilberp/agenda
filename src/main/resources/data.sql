INSERT INTO contato (nome, sobrenome, data_nascimento, apelido) VALUES ('José', 'Fernandes', '1987-05-25','Zé');

INSERT INTO telefone(residencial, celular, recado, contato_id) VALUES ('16-33365411', '16-997121241', '16-996064371', 1);

INSERT INTO endereco (rua, numero, cidade, tipo,  contato_id) VALUES ('Rua 9' , 234, 'Araraquara', 'residencial',  1);
INSERT INTO endereco (rua, numero, cidade, tipo,  contato_id) VALUES ('Rua 9' , 235, 'Araraquara', 'comercial',  1);

INSERT INTO email (email,  contato_id) VALUES ('joelho@gmail.com',  1);

INSERT INTO usuario  VALUES (null,'wilber.peres@hotmail.com','$2a$12$pdlJY7IGuULz44gDcwzOKeW0YhIGRwPG3aHUw5TxMxgUV60KEwp6y');

INSERT INTO perfil VALUES(null,'USUARIO');
INSERT INTO perfil VALUES(null,'ADM');

INSERT INTO usuario_perfis VALUES (1,1);