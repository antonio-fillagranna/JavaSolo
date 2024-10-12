-- APAGAR O DATABASE
DROP SCHEMA garagem;

-- CRIAR O DATABASE
CREATE SCHEMA garagem;

-- FORÇAR USAR O DATABASE
USE GARAGEM;

-- CRIAR TABELA DE USER
CREATE TABLE `garagem`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `level_id` INT NOT NULL,
  `senha` VARCHAR(16) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `status` INT NULL,
  PRIMARY KEY (`id`))
COMMENT = 'Tabela de Usuario';

-- CRIAR A TABELA LEVEL
CREATE TABLE `garagem`.`level` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `id_level_items` INT NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
COMMENT = 'Tabela de Level';

-- CRIAR A TABELA CAR
CREATE TABLE `garagem`.`car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fabricante` INT NOT NULL,
  `cor` INT NOT NULL,
  `ano` INT NOT NULL,
  `opcionais` INT NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
COMMENT = 'Tabela de Carros';

-- CRIAR TABELA MANUFACTORY
CREATE TABLE `garagem`.`manufactory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fabricante` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));
  
  -- CRIAR TABELA COR
  CREATE TABLE `garagem`.`cor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cor` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
COMMENT = 'Tabela de Cores';

-- CRIAR A TABELA ANO
CREATE TABLE `garagem`.`ano` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ano` INT NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
COMMENT = 'Tabela de Ano';

-- CRIAR TABELA DE ITENS DO LEVEL
CREATE TABLE `garagem`.`level_items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
COMMENT = 'Tabela de Detalhes de Niveis';

-- ADICIONAR FK DE LEVEL INDEXADA ITENS
ALTER TABLE `garagem`.`level` 
ADD INDEX `id_level_items_fk_idx` (`id_level_items` ASC) VISIBLE;
;

ALTER TABLE `garagem`.`level` 
ADD CONSTRAINT `id_level_items_fk`
  FOREIGN KEY (`id_level_items`)
  REFERENCES `garagem`.`level_items` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `garagem`.`user` 
ADD INDEX `level_id_fk_idx` (`level_id` ASC) VISIBLE;
;
ALTER TABLE `garagem`.`user` 
ADD CONSTRAINT `level_id_fk`
  FOREIGN KEY (`level_id`)
  REFERENCES `garagem`.`level` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  ALTER TABLE `garagem`.`car` 
ADD INDEX `ano_fk_idx` (`ano` ASC) VISIBLE,
ADD INDEX `cor_fk_idx` (`cor` ASC) VISIBLE;
;
ALTER TABLE `garagem`.`car` 
ADD CONSTRAINT `ano_fk`
  FOREIGN KEY (`ano`)
  REFERENCES `garagem`.`ano` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `cor_fk`
  FOREIGN KEY (`cor`)
  REFERENCES `garagem`.`cor` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `garagem`.`opcionais` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `itens` INT NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
COMMENT = 'Tabela de Opcionais';


CREATE TABLE `garagem`.`opcionais_itens` (
  `id` INT NOT NULL,
  `codigo` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`, `codigo`))
COMMENT = 'Tabela de Itens dos Opcionais';


ALTER TABLE `garagem`.`opcionais` 
ADD INDEX `opcionais_itens_fk_idx` (`itens` ASC) VISIBLE;
;
ALTER TABLE `garagem`.`opcionais` 
ADD CONSTRAINT `opcionais_itens_fk`
  FOREIGN KEY (`itens`)
  REFERENCES `garagem`.`opcionais_itens` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `garagem`.`car` 
ADD INDEX `opcionais_fk_idx` (`opcionais` ASC) VISIBLE;
;
ALTER TABLE `garagem`.`car` 
ADD CONSTRAINT `opcionais_fk`
  FOREIGN KEY (`opcionais`)
  REFERENCES `garagem`.`opcionais` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `garagem`.`level_items` 
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`, `codigo`);
;

INSERT INTO `garagem`.`ano` (`ano`) VALUES ('2020');
INSERT INTO `garagem`.`ano` (`ano`) VALUES ('2021');
INSERT INTO `garagem`.`ano` (`ano`) VALUES ('2022');
INSERT INTO `garagem`.`ano` (`ano`) VALUES ('2023');
INSERT INTO `garagem`.`ano` (`ano`) VALUES ('2024');
INSERT INTO `garagem`.`ano` (`ano`) VALUES ('2025');
INSERT INTO `garagem`.`cor` (`cor`) VALUES ('Branca');
INSERT INTO `garagem`.`cor` (`cor`) VALUES ('Preta');
INSERT INTO `garagem`.`cor` (`cor`) VALUES ('Azul');
INSERT INTO `garagem`.`cor` (`cor`) VALUES ('Verde');
INSERT INTO `garagem`.`cor` (`cor`) VALUES ('Cinza');
INSERT INTO `garagem`.`level_items` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '1', 'Cadastrar Veículo', '1');
INSERT INTO `garagem`.`level_items` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '2', 'Alterar Veículos', '1');
INSERT INTO `garagem`.`level_items` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '3', 'Excluir Veículos', '1');
INSERT INTO `garagem`.`level_items` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '4', 'Listar Veículos', '1');
INSERT INTO `garagem`.`level_items` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '5', 'Imprimir Veículos', '1');
INSERT INTO `garagem`.`level` (`descricao`, `id_level_items`, `status`) VALUES ('Administrador', '1', '1');
INSERT INTO `garagem`.`user` (`nome`, `level_id`, `senha`, `email`, `status`) VALUES ('Administrador', '1', '123456', 'admin@localhost', '1');


CREATE TABLE `garagem`.`modelo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `id_manufactory` INT NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
COMMENT = 'Tabela de Modelo de Carro';

ALTER TABLE `garagem`.`manufactory` 
DROP COLUMN `id_modelo`;

INSERT INTO `garagem`.`manufactory` (`fabricante`, `status`) VALUES ('Volkswagem', '1');
INSERT INTO `garagem`.`manufactory` (`fabricante`, `status`) VALUES ('Renault', '1');

ALTER TABLE `garagem`.`modelo` 
ADD INDEX `manufactory_fk_idx` (`id_manufactory` ASC) VISIBLE;
;
ALTER TABLE `garagem`.`modelo` 
ADD CONSTRAINT `manufactory_fk`
  FOREIGN KEY (`id_manufactory`)
  REFERENCES `garagem`.`manufactory` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

INSERT INTO `garagem`.`modelo` (`descricao`, `id_manufactory`, `status`) VALUES ('Tiguan', '1', '1');
INSERT INTO `garagem`.`modelo` (`descricao`, `id_manufactory`, `status`) VALUES ('Gol', '1', '1');
INSERT INTO `garagem`.`modelo` (`descricao`, `id_manufactory`, `status`) VALUES ('Clio', '2', '1');


INSERT INTO `garagem`.`opcionais_itens` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '1', 'Ar-Condicionado', '1');
INSERT INTO `garagem`.`opcionais_itens` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '2', 'Trava-Eletrica', '1');
INSERT INTO `garagem`.`opcionais_itens` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '3', 'Direção Hidraulica', '1');

INSERT INTO `garagem`.`opcionais` (`descricao`, `itens`, `status`) VALUES ('Completo', '1', '1');

