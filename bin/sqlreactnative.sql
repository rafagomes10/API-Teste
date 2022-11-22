--Passo 1: crie a database
create database reactnative;

--Passo 2: abra um script para a database criada
--Passo 3: selecione todo o código abaixo e execute
CREATE TABLE "usuario" (
  "usu_cd_id" serial not null,
  "usu_tx_nome" varchar(50) not null,
  "usu_tx_cpf" varchar(14) not null,
  "usu_dt_dtnasc" date not null,
  "usu_tx_login" varchar(10) not null,
  "usu_bl_ativo" boolean not null,
  "usu_tx_senha" varchar(5) not null,
  "usu_tx_foto" text,
  PRIMARY KEY ("usu_cd_id")
);

CREATE TABLE "categoria" (
  "cat_cd_id" serial not null,
  "cat_tx_nome" varchar(20) not null,
  "cat_tx_foto" text,
  PRIMARY KEY ("cat_cd_id")
);

CREATE TABLE "produto" (
  "pro_cd_id" serial not null,
  "pro_tx_nome" varchar(20) not null,
  "pro_tx_descricao" varchar(100) not null,
  "pro_int_qtdestoque" int not null,
  "pro_nu_preco" numeric(10,2) not null,
  "pro_tx_foto" text,
  "fk_cat_cd_id" int not null,
  PRIMARY KEY ("pro_cd_id"),
  CONSTRAINT "FK_produto.fk_cat_cd_id"
    FOREIGN KEY ("fk_cat_cd_id")
      REFERENCES "categoria"("cat_cd_id")
);

CREATE TABLE "pedido" (
  "ped_cd_id" serial not null,
  "ped_int_numpedido" int not null,
  "ped_nu_preco_total" numeric(10,2) not null,
  "ped_dt_hr_compra" timestamp not null,
  "fk_usu_cd_id" int not null,
  PRIMARY KEY ("ped_cd_id"),
  CONSTRAINT "FK_pedido.fk_usu_cd_id"
    FOREIGN KEY ("fk_usu_cd_id")
      REFERENCES "usuario"("usu_cd_id")
);

CREATE TABLE "item" (
  "ite_cd_id" serial not null,
  "fk_ped_cd_id" int not null,
  "fk_pro_cd_id" int not null,
  "ite_int_qtd" int not null,
  PRIMARY KEY ("ite_cd_id"),
  CONSTRAINT "FK_item.fk_ped_cd_id"
    FOREIGN KEY ("fk_ped_cd_id")
      REFERENCES "pedido"("ped_cd_id"),
  CONSTRAINT "FK_item.fk_pro_cd_id"
    FOREIGN KEY ("fk_pro_cd_id")
      REFERENCES "produto"("pro_cd_id")
);

insert into categoria (cat_tx_nome, cat_tx_foto) values
(
	'Categoria 1',
	'https://www.seekpng.com/ipng/u2q8a9t4e6i1a9t4_like-imagem-de-fundo-png-like/'
),
(
	'Categoria 2',
	'https://www.seekpng.com/ipng/u2q8a9t4e6i1a9t4_like-imagem-de-fundo-png-like/'
),
(
	'Categoria 3',
	'https://www.seekpng.com/ipng/u2q8a9t4e6i1a9t4_like-imagem-de-fundo-png-like/'
);

insert into usuario (usu_tx_nome, usu_tx_cpf, usu_dt_dtnasc, usu_tx_login, usu_bl_ativo, usu_tx_senha, usu_tx_foto) values
(
	'Alex',
	'00100100100',
	'01/01/1990',
	'alex01',
	true,
	'12345',
	'https://www.seekpng.com/ipng/u2q8a9t4e6i1a9t4_like-imagem-de-fundo-png-like/'
),
(
	'Bárbara',
	'00100100101',
	'15/06/2002',
	'barbara15',
	true,
	'12345',
	'https://www.seekpng.com/ipng/u2q8a9t4e6i1a9t4_like-imagem-de-fundo-png-like/'
),
(
	'Richard',
	'00100100102',
	'30/12/1985',
	'rich30',
	true,
	'12345',
	'https://www.seekpng.com/ipng/u2q8a9t4e6i1a9t4_like-imagem-de-fundo-png-like/'
);

insert into produto (pro_tx_nome, pro_tx_descricao, pro_int_qtdestoque, pro_nu_preco, pro_tx_foto, fk_cat_cd_id) values
(
	'Produto 1',
	'descrição do produto 1',
	10,
	44.50,
	'https://www.seekpng.com/ipng/u2q8a9t4e6i1a9t4_like-imagem-de-fundo-png-like/',
	1
),
(
	'Produto 2',
	'escrição do produto 2',
	5,
	70.00,
	'https://www.seekpng.com/ipng/u2q8a9t4e6i1a9t4_like-imagem-de-fundo-png-like/',
	2
),
(
	'Produto 3',
	'escrição do produto 3',
	20,
	100.99,
	'https://www.seekpng.com/ipng/u2q8a9t4e6i1a9t4_like-imagem-de-fundo-png-like/',
	3
);

insert into pedido (ped_int_numpedido, ped_nu_preco_total, ped_dt_hr_compra, fk_usu_cd_id) values
(
	1001,
	170.99,
	'02/07/2022',
	1
),
(
	1002,
	100.99,
	'02/07/2022',
	2
),
(
	1003,
	44.50,
	'02/07/2022',
	3
);

insert into item (fk_ped_cd_id, fk_pro_cd_id, ite_int_qtd) values
(
	1,
	2,
	1
),
(
	1,
	3,
	1
),
(
	2,
	3,
	1
),
(
	3,
	1,
	1
);





