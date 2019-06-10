CREATE DATABASE appdemudancas;

USE appdemudancas;

CREATE TABLE endereco(

	codigo_endereco int AUTO_INCREMENT PRIMARY KEY,
	nome varchar(30),
	cep char(8),
	numero int

);

CREATE TABLE cnh(

        numero_cnh varchar(11) PRIMARY KEY,
	foto_cnh BLOB

);

CREATE TABLE motorista(

	cpf varchar(11) PRIMARY KEY,
	nome varchar(20),
	telefone varchar(12),
	data_nascimento date,
	email varchar(30),
	senha varchar(20),
	data_cadastro date,
	quantidade_ajudantes int,
	cnhNumero_cnh varchar(11),
	pontuacao decimal(2,1),
	enderecoCodigo_endereco int,
	FOREIGN KEY(cnhNumero_cnh) REFERENCES cnh(numero_cnh),
	FOREIGN KEY(enderecoCodigo_endereco) REFERENCES endereco(codigo_endereco)
);

CREATE TABLE carro(

        placa char(8) PRIMARY KEY,
        ano_fabricacao int,
        marca varchar(20),
        modelo varchar(20),
        cor varchar(10),
        MotoristaCpf varchar(11),
        FOREIGN KEY(MotoristaCpf) REFERENCES motorista(cpf)
);

CREATE TABLE cliente(

        cpf varchar(11) PRIMARY KEY,
        nome varchar(20),
        telefone varchar(12),
        data_nascimento date,
        email varchar(30),
        senha varchar(20),
        data_cadastro date,
        enderecoCodigo_endereco int,
        FOREIGN KEY(enderecoCodigo_endereco) REFERENCES endereco(codigo_endereco)

);

CREATE TABLE mudanca(

	codigo_mudanca int AUTO_INCREMENT PRIMARY KEY,
	data_criacao date,
	data_mudanca date,
	status varchar(11),
	MotoristaCpf varchar(11),
	ClienteCpf varchar(11),
	EnderecoInicialCodigo int,
	EnderecoFinalCodigo int,
	FOREIGN KEY(MotoristaCpf) REFERENCES motorista(cpf),
	FOREIGN KEY(ClienteCpf) REFERENCES cliente(cpf),
	FOREIGN KEY(EnderecoInicialCodigo) REFERENCES endereco(codigo_endereco),
	FOREIGN KEY(EnderecoFinalCodigo) REFERENCES endereco(codigo_endereco)
);

CREATE TABLE item_da_mudanca(

	codigo_item int AUTO_INCREMENT PRIMARY KEY,
	nome varchar(20),
	altura decimal(5,2),
	largura decimal(5,2),
	comprimento decimal(5,2),
	peso decimal(4,2),
	e_fragil char(1),
	MudancaCodigo_mudanca int,
	FOREIGN KEY(MudancaCodigo_mudanca) REFERENCES mudanca(codigo_mudanca)

);
