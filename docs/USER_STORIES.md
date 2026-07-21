# User Stories — FlowTasks

## US01 - Criar Tarefa

- **Como** Usuário
- **Eu quero** criar uma nova tarefa informando o título da atividade
- **Para que eu possa** registrar atividades que precisam ser gerenciadas

#### Critérios de aceitação

- **Dado que** informo um nome válido para a tarefa
- **Quando** envio a requisição para criar a tarefa
- **Então** o sistema deve armazenar a tarefa e retornar `status 200 OK`

---

## US02 - Listar Tarefas

- **Como** Usuário
- **Eu quero** listar todas as tarefas cadastradas
- **Para que eu possa** visualizar o panorama geral das atividades

#### Critérios de aceitação

- **Dado que** existem tarefas cadastradas no sistema
- **Quando** solicito a listagem de tarefas
- **Então** o sistema deve retornar todas as tarefas com seus respectivos dados e subtarefas

---

## US03 - Buscar Tarefa por ID

- **Como** Usuário
- **Eu quero** buscar uma tarefa específica pelo seu identificador
- **Para que eu possa** visualizar os detalhes completos de uma tarefa

#### Critérios de aceitação

- **Dado que** existe uma tarefa com o ID informado
- **Quando** realizo a busca pelo ID
- **Então** o sistema deve retornar os dados da tarefa e suas subtarefas

---

## US04 - Atualizar Tarefa

- **Como** Usuário
- **Eu quero** atualizar os dados de uma tarefa existente
- **Para que eu possa** corrigir ou modificar informações como nome, descrição, status, prioridade e data de conclusão

#### Critérios de aceitação

- **Dado que** existe uma tarefa cadastrada com o ID informado
- **Quando** envio os novos dados para atualização
- **Então** o sistema deve modificar os campos informados e persistir as alterações

---

## US05 - Remover Tarefa

- **Como** Usuário
- **Eu quero** remover uma tarefa pelo seu identificador
- **Para que eu possa** excluir atividades que não são mais relevantes

#### Critérios de aceitação

- **Dado que** existe uma tarefa com o ID informado
- **Quando** solicito a remoção da tarefa
- **Então** o sistema deve excluir a tarefa e todas as suas subtarefas em cascata

---

## US06 - Marcar Tarefa como Concluída

- **Como** Usuário
- **Eu quero** marcar uma tarefa como concluída
- **Para que eu possa** registrar que aquela atividade foi finalizada

#### Critérios de aceitação

- **Dado que** existe uma tarefa com o ID informado
- **Quando** solicito a conclusão da tarefa
- **Então** o sistema deve alterar o status da tarefa para `CONCLUÍDO`

---

## US07 - Criar Subtarefa

- **Como** Usuário
- **Eu quero** criar uma nova subtarefa vinculada a uma tarefa pai
- **Para que eu possa** detalhar atividades menores que compõem uma tarefa maior

#### Critérios de aceitação

- **Dado que** informo um nome válido e o ID de uma tarefa pai existente
- **Quando** envio a requisição para criar a subtarefa
- **Então** o sistema deve armazenar a subtarefa associada à tarefa pai e retornar `status 200 OK`

---

## US08 - Listar Subtarefas

- **Como** Usuário
- **Eu quero** listar todas as subtarefas cadastradas
- **Para que eu possa** visualizar todas as atividades secundárias do sistema

#### Critérios de aceitação

- **Dado que** existem subtarefas cadastradas no sistema
- **Quando** solicito a listagem de subtarefas
- **Então** o sistema deve retornar todas as subtarefas com seus respectivos dados

---

## US09 - Buscar Subtarefa por ID

- **Como** Usuário
- **Eu quero** buscar uma subtarefa específica pelo seu identificador
- **Para que eu possa** visualizar os detalhes completos de uma subtarefa

#### Critérios de aceitação

- **Dado que** existe uma subtarefa com o ID informado
- **Quando** realizo a busca pelo ID
- **Então** o sistema deve retornar os dados da subtarefa

---

## US10 - Atualizar Subtarefa

- **Como** Usuário
- **Eu quero** atualizar os dados de uma subtarefa existente
- **Para que eu possa** corrigir ou modificar informações como nome, descrição, status, prioridade e data de conclusão

#### Critérios de aceitação

- **Dado que** existe uma subtarefa cadastrada com o ID informado
- **Quando** envio os novos dados para atualização
- **Então** o sistema deve modificar os campos informados e persistir as alterações

---

## US11 - Remover Subtarefa

- **Como** Usuário
- **Eu quero** remover uma subtarefa pelo seu identificador
- **Para que eu possa** excluir atividades secundárias que não são mais necessárias

#### Critérios de aceitação

- **Dado que** existe uma subtarefa com o ID informado
- **Quando** solicito a remoção da subtarefa
- **Então** o sistema deve excluir a subtarefa do banco de dados

---

## US12 - Listar Subtarefas por Tarefa Pai

- **Como** Usuário
- **Eu quero** listar as subtarefas filtradas por uma tarefa pai específica
- **Para que eu possa** visualizar apenas as subtarefas relacionadas a uma determinada tarefa

#### Critérios de aceitação

- **Dado que** existem subtarefas vinculadas à tarefa pai com o ID informado
- **Quando** solicito a listagem filtrada pelo ID da tarefa pai
- **Então** o sistema deve retornar apenas as subtarefas associadas àquela tarefa

---

## US13 - Concluir Próxima Subtarefa

- **Como** Usuário
- **Eu quero** concluir a próxima subtarefa pendente de uma tarefa seguindo a ordem de fila (FIFO)
- **Para que eu possa** processar as atividades secundárias sequencialmente na ordem em que foram criadas

#### Critérios de aceitação

- **Dado que** existem subtarefas em andamento vinculadas à tarefa pai
- **Quando** solicito a conclusão da próxima subtarefa
- **Então** o sistema deve marcar a subtarefa mais antiga como `CONCLUÍDO` e registrar a data de conclusão
- **Dado que** não há subtarefas pendentes na fila
- **Quando** solicito a conclusão da próxima subtarefa
- **Então** o sistema deve lançar uma exceção informando que não há subtarefas pendentes

---

## US14 - Visualizar Próxima Subtarefa Pendente

- **Como** Usuário
- **Eu quero** visualizar a próxima subtarefa pendente de uma tarefa sem concluí-la
- **Para que eu possa** inspecionar qual será a próxima atividade a ser processada

#### Critérios de aceitação

- **Dado que** existem subtarefas em andamento vinculadas à tarefa pai
- **Quando** solicito a visualização da próxima subtarefa
- **Então** o sistema deve retornar os dados da subtarefa mais antiga sem alterar seu status
- **Dado que** não há subtarefas pendentes na fila
- **Quando** solicito a visualização da próxima subtarefa
- **Então** o sistema deve lançar uma exceção informando que não há subtarefas pendentes
