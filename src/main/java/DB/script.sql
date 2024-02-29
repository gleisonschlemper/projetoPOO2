CREATE TABLE alunos ( 
    mat_codigo INT AUTO_INCREMENT PRIMARY KEY,
    mat_cpf VARCHAR(11) NOT NULL,
    mat_nome VARCHAR(255) NOT NULL,
    mat_sobrenome VARCHAR(255) NOT NULL,
    mat_email VARCHAR(255) NOT NULL,
    mat_senha VARCHAR(255) NOT NULL
);

CREATE TABLE funcionarios (
    func_codigo INT AUTO_INCREMENT PRIMARY KEY,
    func_nome VARCHAR(100) NOT NULL,
    func_sobrenome VARCHAR(100) NOT NULL,
    func_cpf VARCHAR(11) NOT NULL,
    func_email VARCHAR(100) NOT NULL,
    func_senha VARCHAR(255) NOT NULL,
    func_cargo VARCHAR(100) NOT NULL
);

CREATE TABLE mensagem (
    mens_codigo SERIAL PRIMARY KEY,
    func_codigo INT NOT NULL, 
    mens_assunto VARCHAR(100) NOT NULL,
    mens_conteudo VARCHAR(1000) NOT NULL,
    mat_codigo INT NOT NULL,
    FOREIGN KEY (func_codigo) REFERENCES funcionarios (func_codigo),
    FOREIGN KEY (mat_codigo) REFERENCES alunos (mat_codigo)
);