-- Criação do banco de dados

create database AtividadeAdriana;

-- Configurando user e password padrão do banco de dados para conectar ao JDbC

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin123';

GRANT SELECT, INSERT, UPDATE ON AtividadeAdriana.* TO 'admin'@'localhost';

FLUSH PRIVILEGES;

-- Define o banco de dados 2rp como o padrão

use AtividadeAdriana;

-- Criação de tabelas

CREATE TABLE pessoa (
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(15) NOT NULL,
    idade BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(cpf)
);

CREATE TABLE lugar (
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(nome)
);

CREATE TABLE veiculo (
    modelo VARCHAR(100) NOT NULL,
    placa VARCHAR(20) NOT NULL,
    ano INT NOT NULL,
    cor VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(placa)
);

CREATE TABLE viagem (
    nome_pessoa VARCHAR(100) NOT NULL,
    cpf_pessoa VARCHAR(15) NOT NULL,
    origem VARCHAR(200) NOT NULL,
    destino VARCHAR(200) NOT NULL,
    modelo_veiculo VARCHAR(100) NOT NULL,
    placa_veiculo VARCHAR(20) NOT NULL,
    data_partida VARCHAR(15) NOT NULL,
    data_chegada VARCHAR(15) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(cpf_pessoa, data_partida)
);

