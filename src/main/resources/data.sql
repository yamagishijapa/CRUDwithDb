USE biblioteca;

-- Inserir alguns livros
INSERT INTO livro (titulo, autor, ano_publicacao) VALUES ('Dom Quixote', 'Miguel de Cervantes', 1605);
INSERT INTO livro (titulo, autor, ano_publicacao) VALUES ('O Senhor dos Anéis', 'J.R.R. Tolkien', 1954);
INSERT INTO livro (titulo, autor, ano_publicacao) VALUES ('Cem Anos de Solidão', 'Gabriel García Márquez', 1967);

-- Inserir alguns membros
INSERT INTO membro (nome, endereco, telefone) VALUES ('João', 'Rua A, 123', '(11) 1234-5678');
INSERT INTO membro (nome, endereco, telefone) VALUES ('Maria', 'Rua B, 456', '(11) 9876-5432');

-- Inserir alguns empréstimos
INSERT INTO emprestimo (livro_id, membro_id, data_emprestimo, data_devolucao) VALUES (1, 1, '2024-03-15', '2024-03-30');
INSERT INTO emprestimo (livro_id, membro_id, data_emprestimo, data_devolucao) VALUES (2, 2, '2024-03-20', '2024-04-05');

-- Inserir alguns visitantes
INSERT INTO visitante (nome, email, telefone) VALUES ('Julio', 'julio@example.com', '(11) 1234-5678');
INSERT INTO visitante (nome, email, telefone) VALUES ('Pedro', 'pedro@example.com', '(11) 9876-5432');

-- Inserir alguns bibliotecários
INSERT INTO bibliotecario (nome, email, senha) VALUES ('Mario', 'mario@example.com', 'senha123');
INSERT INTO bibliotecario (nome, email, senha) VALUES ('Sergio', 'sergio@example.com', 'senha456');