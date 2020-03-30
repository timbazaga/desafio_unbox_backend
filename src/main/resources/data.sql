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

INSERT INTO PUBLIC.FILME (ID, TITULO, TITULO_ORIGINAL) VALUES (1, 'Bloodshot', 'Bloodshot');
INSERT INTO PUBLIC.FILME (ID, TITULO, TITULO_ORIGINAL) VALUES (2, 'Ad Astra - Rumo às Estrelas', 'Ad Astra');
INSERT INTO PUBLIC.FILME (ID, TITULO, TITULO_ORIGINAL) VALUES (3, 'Homem-Formiga e a Vespa', 'Ant-Man and the Wasp');
INSERT INTO PUBLIC.FILME (ID, TITULO, TITULO_ORIGINAL) VALUES (4, 'Missão: Impossível - Efeito Fallout', 'Mission: Impossible - Fallout');
INSERT INTO PUBLIC.FILME (ID, TITULO, TITULO_ORIGINAL) VALUES (5, 'Aves de Rapina: Arlequina e sua Emancipação Fantabulosa', 'Birds of Prey (and the Fantabulous Emancipation of One Harley Quinn)');

INSERT INTO PUBLIC.FILME_GENERO (FILME_ID, GENERO_ID) VALUES (1, 1);
INSERT INTO PUBLIC.FILME_GENERO (FILME_ID, GENERO_ID) VALUES (2, 7);
INSERT INTO PUBLIC.FILME_GENERO (FILME_ID, GENERO_ID) VALUES (3, 1);
INSERT INTO PUBLIC.FILME_GENERO (FILME_ID, GENERO_ID) VALUES (4, 1);
INSERT INTO PUBLIC.FILME_GENERO (FILME_ID, GENERO_ID) VALUES (4, 1);

