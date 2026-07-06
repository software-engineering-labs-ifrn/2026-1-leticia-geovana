<div align="center">
    <h1>FlowTasks</h1>
    <h3><i>O seu Gerenciador de Tarefas Pomodoro</i></h3>
</div>

<div align="center"> 

![Last commit](https://img.shields.io/github/last-commit/leticia2025IFRN/flowTasks?&style=for-the-badge&color=286983&logo=git&logoColor=908caa&labelColor=#191919)

</div>

## Descrição
Uma aplicação de gerenciador/lista de tarefas em Java. 

## Tecnologias 

### Front-End
![React na versão ?.?.?](https://img.shields.io/badge/React-61DAFB?logo=react&logoColor=000&style=for-the-badge)

### Back-End
![Spring na versão ?.?.?](https://img.shields.io/badge/spring-236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

### Banco de Dados
![PostgreSQL na versão ?.?.?](https://img.shields.io/badge/PostgreSQL-336791?logo=postgresql&logoColor=fff&style=for-the-badge)

## Composição dos Diretórios do Projeto

```
./flowTasks
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── br
    │   │       └── com
    │   │           └── flowtasks
    │   │               ├── controller
    │   │               │   ├── SubtarefaController.java
    │   │               │   └── TarefaController.java
    │   │               ├── dto
    │   │               │   ├── SubTarefaEdicaoDto.java
    │   │               │   ├── SubTarefaRequestDto.java
    │   │               │   ├── SubTarefaResponseDto.java
    │   │               │   ├── TarefaEdicaoDto.java
    │   │               │   ├── TarefaRequesteDto.java
    │   │               │   └── TarefaResponseDto.java
    │   │               ├── entities
    │   │               │   ├── SubTarefaEntity.java
    │   │               │   └── TarefaEntity.java
    │   │               ├── enums
    │   │               │   ├── Prioridade.java
    │   │               │   └── Status.java
    │   │               ├── FlowTasksApplication.java
    │   │               ├── repository
    │   │               │   ├── SubTarefaRepository.java
    │   │               │   └── TarefaRepository.java
    │   │               └── service
    │   │                   ├── SubTarefaService.java
    │   │                   └── TarefaService.java
    │   └── resources
    │       ├── application-dev.properties
    │       ├── application.properties
    │       ├── application-test.properties
    │       └── data.sql
    └── test
        └── java
            └── br
                └── com
                    └── flowtasks
                        └── FlowTasksApplicationTests.java
```
