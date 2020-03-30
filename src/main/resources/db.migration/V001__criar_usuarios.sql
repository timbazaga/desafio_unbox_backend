CREATE TABLE usuario (
                         codigo BIGINT(20) PRIMARY KEY,
                         nome VARCHAR(50) NOT NULL,
                         email VARCHAR(50) NOT NULL,
                         senha VARCHAR(150) NOT NULL
);

INSERT INTO usuario (codigo, nome, email, senha) values (1, 'Administrador', 'admin@unbox.com', '$2a$10$We4ez.KqBNEqyuOC1k0HJO0C2f9kMKxk1Mw02noI5/wtOWf4myB32');

insert into genero values (1, 28, 'Ação');
insert into genero values (2, 12, 'Aventura');
insert into genero values (3, 16, 'Animação');
insert into genero values (4, 35, 'Comédia');
insert into genero values (5, 80, 'Crime');
insert into genero values (6, 99, 'Documentario');
insert into genero values (7, 18, 'Drama');
insert into genero values (8, 10751, 'Família');
insert into genero values (9, 14, 'Fantasia');
insert into genero values (10, 35, 'História');
