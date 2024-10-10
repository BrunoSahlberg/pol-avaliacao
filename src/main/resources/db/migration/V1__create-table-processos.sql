--CREATE DATABASE pol_bruno;

CREATE TABLE IF NOT EXISTS processos (
    numero_processo SERIAL PRIMARY KEY NOT NULL,
    autor VARCHAR(255),
    reu VARCHAR(255),
    status VARCHAR(20),
    data_criacao DATE NOT NULL DEFAULT CURRENT_DATE
);