Create table fornecedor (
	id SERIAL NOT NULL,
	nome VARCHAR(150) NULL,
	email VARCHAR(45) NULL,
	telefone VARCHAR(45) NULL,
	cnpj VARCHAR(45) NULL,
	PRIMARY KEY(id)
);
Create table compra(
	id SERIAL NOT NULL,
	data VARCHAR(45) NULL,
	fornecedor_id INT NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_compra_fornecedor
	FOREIGN KEY (fornecedor_id)
	REFERENCES fornecedor (id)
	);
CREATE TABLE endereco (
	id SERIAL NOT NULL,
	descricao VARCHAR(45) NULL,
	cep VARCHAR(10) NULL,
	PRIMARY KEY (id)

);
CREATE TABLE cliente(
	id SERIAL NOT NULL,
	nome VARCHAR(150) NULL,
	email VARCHAR(45) NULL,
	cpf VARCHAR(45) NULL,
	telefone VARCHAR(45) NULL,
	PRIMARY KEY(id)
);
CREATE TABLE cliente_endereco(
	id SERIAL NOT NULL,
	cliente_id INT NOT NULL,
	endereco_id INT NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT fk_cliente_endereco
	FOREIGN KEY (cliente_id)
	REFERENCES cliente (id),
	CONSTRAINT fk_endereco_cliente
	FOREIGN KEY (endereco_id)
	REFERENCES endereco (id)
);
CREATE TABLE pedido(
	id SERIAL NOT NULL,
	data DATE NULL,
	endereco_entrega VARCHAR(45) NULL,
	observacao VARCHAR(500) NULL,
	cliente_id INT NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT fk_cliente_pedido
	FOREIGN KEY (cliente_id)
	REFERENCES cliente (id)
);
CREATE TABLE produto(
	id SERIAL NOT NULL,
	descricao VARCHAR(150) NULL,
	valor_unitario DECIMAL(10,2) NULL,
	qtde_estoque VARCHAR(45) NULL,
	PRIMARY KEY(id)
);
CREATE TABLE item_pedido(
	id SERIAL NOT NULL,
	produto_id INT NOT NULL,
	pedido_id INT NOT NULL,
	qtde INT NULL,
	valor_item DECIMAL(10,2),
	PRIMARY KEY(id),
	CONSTRAINT fk_produto_item
	FOREIGN KEY (produto_id)
	REFERENCES produto (id),
	CONSTRAINT fk_pedido_item
	FOREIGN KEY (pedido_id)
	REFERENCES pedido (id)
);
CREATE TABLE item_compra(
	id SERIAL NOT NULL,
	compra_id INT NOT NULL,
	produto_id INT NOT NULL,
	qtde INT NULL,
	valor DECIMAL(10,2),
	PRIMARY KEY(id),
	CONSTRAINT fk_produto_item
	FOREIGN KEY (produto_id)
	REFERENCES produto (id),
	CONSTRAINT fk_compra_item
	FOREIGN KEY (compra_id)
	REFERENCES compra (id)
);

