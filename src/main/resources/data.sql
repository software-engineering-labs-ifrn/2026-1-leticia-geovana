-- ==========================================================
-- TAREFA PAI (ID gerado automaticamente pelo banco: 1)
-- ==========================================================
INSERT INTO tb_tarefas (nome, descricao, data_criacao, data_conclusao, status_tarefa, prioridade_tarefa)
VALUES ('Configurar Infraestrutura Cloud', 'Configurar os serviços AWS e pipelines de CI/CD.', NOW(), NULL, 1, 0);

-- Subtarefas associadas à tarefa de ID 1
INSERT INTO tb_sub_tarefas (nome, descricao, data_criacao, data_conclusao, status_tarefa, prioridade_tarefa, tarefa_pai_id)
VALUES
('Criar conta na AWS', 'Configurar o usuário Root.', NOW(), NOW(), 2, 0, 1),
('Escrever Dockerfile', NULL, NOW(), NULL, 0, 1, 1),
('Configurar Deploy no ECS', 'Mapear a tarefa do container.', NOW(), NULL, 0, 0, 1);


-- ==========================================================
-- TAREFA PAI (ID gerado automaticamente pelo banco: 2)
-- ==========================================================
INSERT INTO tb_tarefas (nome, descricao, data_criacao, data_conclusao, status_tarefa, prioridade_tarefa)
VALUES ('Alinhamento com o Cliente', NULL, NOW(), NULL, 0, 1);


-- ==========================================================
-- TAREFA PAI (ID gerado automaticamente pelo banco: 3)
-- ==========================================================
INSERT INTO tb_tarefas (nome, descricao, data_criacao, data_conclusao, status_tarefa, prioridade_tarefa)
VALUES ('Desenvolver Módulo de Autenticação', 'Implementar segurança com Spring Security e JWT.', NOW(), NULL, 1, 0);

-- Subtarefas associadas à tarefa de ID 3
INSERT INTO tb_sub_tarefas (nome, descricao, data_criacao, data_conclusao, status_tarefa, prioridade_tarefa, tarefa_pai_id)
VALUES
('Estruturar Tabelas de Usuário', NULL, NOW(), NULL, 0, 0, 3),
('Gerar Tokens JWT', 'Criar a classe utilitária.', NOW(), NULL, 1, 0, 3),
('Validar Roles e Permissões', 'Proteger os endpoints.', NOW(), NULL, 0, 1, 3);


-- ==========================================================
-- TAREFA PAI (ID gerado automaticamente pelo banco: 4)
-- ==========================================================
INSERT INTO tb_tarefas (nome, descricao, data_criacao, data_conclusao, status_tarefa, prioridade_tarefa)
VALUES ('Refatorar Modelos de Dados', 'Melhorar a estrutura das tabelas legadas.', NOW(), NOW(), 2, 2);