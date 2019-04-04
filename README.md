##	INFORMACOES DE BANCO

### CRIACAO DA TABELA TAREFA 
CREATE TABLE PUBLIC.tarefa (
	id INT NOT NULL IDENTITY,
	bolconcluido  SMALLINT DEFAULT 0,
	datalimitetarefa DATE,
	valoratividade DECIMAL,
	recorrencia SMALLINT,-- DEFAULT = (3) COMMENT 'recorrência  mensal default',
	bolmesmovalorrecorrente SMALLINT,-- DEFAULT 0 COMMENT 'não é recorrente mensal como DEFAULT',
	--PRIMARY KEY (id)
);

### CRIACAO DA TABELA RECORRENCIA
CREATE TABLE PUBLIC.recorrencia (
	codigorecorrencia INT,
	descricao VARCHAR(50)
)

### CARREGAR DADOS DOMINIO RECORRENCIA
INSERT INTO  PUBLIC.recorrencia (codigorecorrencia, descricao) VALUES
(1,'recorrência diária'),
(2,'recorrência semanal'),
(3,'recorrência mensal'),
(4,'recorrência bimestral'),
(5,'recorrência trimestral'),
(6,'recorrência semestral'),
(7,'recorrência anual');

