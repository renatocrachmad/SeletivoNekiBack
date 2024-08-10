CREATE SEQUENCE usuarios_id_seq start 1;
CREATE SEQUENCE skills_id_seq START 1;
CREATE SEQUENCE usuario_skills_id_seq START 1;

CREATE TABLE usuarios (
    id BIGINT PRIMARY KEY DEFAULT nextval('usuarios_id_seq'),
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE skills (
    id BIGINT PRIMARY KEY DEFAULT nextval('skills_id_seq'),
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE usuario_skills (
    id BIGINT PRIMARY KEY DEFAULT nextval('usuario_skills_id_seq'),
    usuario_id BIGINT NOT NULL,
    skill_id BIGINT NOT NULL,
    level INT NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    CONSTRAINT fk_skill FOREIGN KEY (skill_id) REFERENCES skills(id) ON DELETE CASCADE,
    UNIQUE (usuario_id, skill_id)
);

INSERT INTO skills (name) VALUES ('Java');
INSERT INTO skills (name) VALUES ('Spring Boot');

