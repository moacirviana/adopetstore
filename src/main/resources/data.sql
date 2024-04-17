INSERT INTO perfis VALUES(1, 'ROLE_ADMIN');
INSERT INTO perfis VALUES(2, 'ROLE_COMPRADOR');
INSERT INTO usuarios (id,nome,email,senha) VALUES(1, 'Administrador', 'admin@email.com.br', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');
INSERT INTO usuarios (id,nome,email,senha) VALUES(2, 'Comprador', 'comprador@email.com.br', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');
INSERT INTO usuarios_perfis values(1, 1);
INSERT INTO usuarios_perfis values(2, 2);

INSERT INTO produtos (id,nome,descricao, categoria, preco, ativo) VALUES (1,'PAPEL TOALHA','CX COM 100 rolos','HIGIENE',80.00,1);
INSERT INTO produtos (id,nome,descricao, categoria, preco, ativo) VALUES (2,'BOLACHA RECHEADA','PACOTE COM 3','ALIMENTOS',30.00,1);
INSERT INTO produtos (id,nome,descricao, categoria, preco, ativo) VALUES (3,'CARREGADOR CELULAR','110volts','ACESSORIOS',15.00,1);
