CREATE DATABASE biblioteca;

\c biblioteca;

CREATE TABLE IF NOT EXISTS livro (
                                     id BIGSERIAL PRIMARY KEY,
                                     titulo VARCHAR(255) NOT NULL,
                                     autor VARCHAR(255) NOT NULL,
                                     ano_publicacao INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS membro (
                                      id BIGSERIAL PRIMARY KEY,
                                      nome VARCHAR(255) NOT NULL,
                                      endereco VARCHAR(255) NOT NULL,
                                      telefone VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS emprestimo (
                                          id BIGSERIAL PRIMARY KEY,
                                          livro_id BIGINT NOT NULL,
                                          membro_id BIGINT NOT NULL,
                                          data_emprestimo DATE NOT NULL,
                                          data_devolucao DATE NOT NULL,
                                          FOREIGN KEY (livro_id) REFERENCES livro(id),
                                          FOREIGN KEY (membro_id) REFERENCES membro(id)
);

CREATE TABLE IF NOT EXISTS visitante (
                                         id BIGSERIAL PRIMARY KEY,
                                         nome VARCHAR(255) NOT NULL,
                                         email VARCHAR(255) NOT NULL,
                                         telefone VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS bibliotecario (
                                             id BIGSERIAL PRIMARY KEY,
                                             nome VARCHAR(255) NOT NULL,
                                             email VARCHAR(255) NOT NULL,
                                             senha VARCHAR(255) NOT NULL
);