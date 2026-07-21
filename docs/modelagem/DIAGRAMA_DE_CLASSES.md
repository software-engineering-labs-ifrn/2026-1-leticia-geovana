# Diagrama de Classes — FlowTasks

## Diagrama

```mermaid
classDiagram
    class FlowTasksApplication {
        +main(String[] args) void
    }

    class TarefaController {
        -tarefaService: TarefaServiceInterface
        +listarTodasAsTarefas() List~TarefaResponseDto~
        +salvarTarefa(TarefaRequesteDto tarefa) ResponseEntity~Void~
        +listarTarefaPorId(Long id) TarefaResponseDto
        +atualizarTarefa(TarefaEdicaoDto tarefa, Long id) ResponseEntity~Void~
        +marcarTarefaComoConcluida(Long id) ResponseEntity~Void~
        +deletarTarefa(Long id) ResponseEntity~Void~
    }

    class SubtarefaController {
        -subTarefaService: SubTarefaServiceInterface
        +listarTodasSubTarefas() List~SubTarefaResponseDto~
        +salvarSubTarefa(SubTarefaRequestDto subTarefa) ResponseEntity~Void~
        +listarSubTarefaPorId(Long id) SubTarefaResponseDto
        +atualizarSubTarefa(SubTarefaEdicaoDto subTarefa, Long id) ResponseEntity~Void~
        +deletarSubTarefa(Long id) ResponseEntity~Void~
        +listarSubTarefasPorTarefaPai(Long tarefaPaiId) List~SubTarefaResponseDto~
        +concluirProxima(Long id) ResponseEntity~SubTarefaResponseDto~
        +peekProxima(Long tarefaPaiId) ResponseEntity~SubTarefaResponseDto~
    }

    class TarefaServiceInterface {
        <<interface>>
        +listarTodasAsTarefas() List~TarefaResponseDto~
        +salvarTarefa(TarefaRequesteDto tarefa) void
        +listarTarefaPorId(Long id) TarefaResponseDto
        +atualizarTarefa(Long id, TarefaEdicaoDto tarefa) void
        +marcarTarefaComoConcluida(Long id) void
        +deletarTarefa(Long id) void
    }

    class TarefaService {
        -tarefaRepository: TarefaRepository
    }

    class SubTarefaServiceInterface {
        <<interface>>
        +listarTodasAsSubTarefas() List~SubTarefaResponseDto~
        +salvarSubTarefa(SubTarefaRequestDto subTarefa) void
        +listarSubTarefaPorId(Long id) SubTarefaResponseDto
        +atualizarSubTarefa(Long id, SubTarefaEdicaoDto subTarefa) void
        +deletarSubTarefa(Long id) void
        +listarSubTarefasPorTarefaPai(Long tarefaPaiId) List~SubTarefaResponseDto~
        +concluirProximaSubTarefa(Long tarefaPaiId) SubTarefaResponseDto
        +peekProximaSubTarefa(Long tarefaPaiId) SubTarefaResponseDto
    }

    class SubTarefaService {
        -subTarefaRepository: SubTarefaRepository
        -tarefaRepository: TarefaRepository
    }

    class TarefaRepository {
        <<interface>>
    }

    class SubTarefaRepository {
        <<interface>>
        +findByTarefaPaiIdAndStatusTarefaOrderByDataCriacaoAsc(Long, Status) List~SubTarefaEntity~
        +findByTarefaPaiId(Long) List~SubTarefaEntity~
        +findTopByTarefaPaiIdAndStatusTarefaOrderByDataCriacaoAsc(Long, Status) SubTarefaEntity
    }

    class TarefaEntity {
        -id: Long
        -nome: String
        -descricao: String
        -dataCriacao: LocalDate
        -dataConclusao: Date
        -statusTarefa: Status
        -prioridadeTarefa: Prioridade
        -subTarefas: List~SubTarefaEntity~
    }

    class SubTarefaEntity {
        -id: Long
        -nome: String
        -descricao: String
        -dataCriacao: LocalDate
        -dataConclusao: Date
        -statusTarefa: Status
        -prioridadeTarefa: Prioridade
        -tarefaPai: TarefaEntity
    }

    class Status {
        <<enumeration>>
        SEM_STATUS
        EM_ANDAMENTO
        CONCLUIDO
        +getCodigo() int
        +getDescricao() String
    }

    class Prioridade {
        <<enumeration>>
        PRIORIDADE_UM
        PRIORIDADE_DOIS
        PRIORIDADE_TRES
        +getCodigoPrioridade() int
    }

    class TarefaRequesteDto {
        -nome: String
    }

    class TarefaResponseDto {
        -id: Long
        -nome: String
        -descricao: String
        -dataConclusao: Date
        -statusTarefa: Status
        -subTarefas: List~SubTarefaResponseDto~
    }

    class EdicaoCamposInterface {
        <<interface>>
        +getNome() String
        +setNome(String) void
        +getDescricao() String
        +setDescricao(String) void
        +getDataConclusao() Date
        +setDataConclusao(Date) void
        +getStatusTarefa() Status
        +setStatusTarefa(Status) void
        +getPrioridadeTarefa() Prioridade
        +setPrioridadeTarefa(Prioridade) void
    }

    class TarefaEdicaoDto {
        -nome: String
        -descricao: String
        -dataConclusao: Date
        -statusTarefa: Status
        -prioridadeTarefa: Prioridade
    }

    class SubTarefaRequestDto {
        -nome: String
        -tarefaPaiId: Long
    }

    class SubTarefaResponseDto {
        -id: Long
        -nome: String
        -descricao: String
        -dataCriacao: LocalDate
        -dataConclusao: Date
        -statusTarefa: Status
        -prioridadeTarefa: Prioridade
    }

    class SubTarefaEdicaoDto {
        -nome: String
        -descricao: String
        -dataConclusao: Date
        -statusTarefa: Status
        -prioridadeTarefa: Prioridade
    }

    TarefaController --> TarefaServiceInterface : depende
    SubtarefaController --> SubTarefaServiceInterface : depende
    TarefaServiceInterface <|.. TarefaService : implementa
    SubTarefaServiceInterface <|.. SubTarefaService : implementa
    EdicaoCamposInterface <|.. TarefaEdicaoDto : implementa
    EdicaoCamposInterface <|.. SubTarefaEdicaoDto : implementa
    TarefaService --> TarefaRepository : usa
    TarefaService ..> TarefaResponseDto : retorna
    TarefaService ..> TarefaRequesteDto : recebe
    TarefaService ..> TarefaEdicaoDto : recebe
    SubTarefaService --> SubTarefaRepository : usa
    SubTarefaService --> TarefaRepository : usa
    SubTarefaService ..> SubTarefaResponseDto : retorna
    SubTarefaService ..> SubTarefaRequestDto : recebe
    SubTarefaService ..> SubTarefaEdicaoDto : recebe

    TarefaRepository --> TarefaEntity : gerencia
    SubTarefaRepository --> SubTarefaEntity : gerencia

    TarefaEntity --> Status : usa
    TarefaEntity --> Prioridade : usa
    SubTarefaEntity --> Status : usa
    SubTarefaEntity --> Prioridade : usa

    TarefaEntity "1" --> "*" SubTarefaEntity : contém
    SubTarefaEntity "*" --> "1" TarefaEntity : pertence a

    TarefaResponseDto --> SubTarefaResponseDto : contém
    TarefaResponseDto ..> TarefaEntity : constrói a partir de
    TarefaRequesteDto ..> TarefaEntity : constrói
    SubTarefaResponseDto ..> SubTarefaEntity : constrói a partir de
    SubTarefaRequestDto ..> SubTarefaEntity : constrói
```

## Legenda dos Relacionamentos

| Símbolo | Significado |
|---------|------------|
| `-->` | Associação (usa) |
| `..>` | Dependência (cria/retorna/recebe) |
| `<\|..` | Realização/Implementação de interface |
| `"1" --> "*"` | Um para muitos (OneToMany) |
| `"*" --> "1"` | Muitos para um (ManyToOne) |
| `<<interface>>` | Interface |
| `<<enumeration>>` | Tipo enumerado |

## Descrição das Camadas

### Camada de Apresentação (Controller)
- **TarefaController**: Expõe endpoints REST para operações em tarefas
- **SubtarefaController**: Expõe endpoints REST para operações em subtarefas

### Camada de Negócio (Service)
- **TarefaService**: Regras de negócio para tarefas
- **SubTarefaService**: Regras de negócio para subtarefas + lógica de fila FIFO

### Camada de Persistência (Repository)
- **TarefaRepository**: Acesso a dados da entidade `TarefaEntity` via Spring Data JPA
- **SubTarefaRepository**: Acesso a dados da entidade `SubTarefaEntity` + queries customizadas para fila FIFO

### Camada de Domínio (Entity)
- **TarefaEntity**: Representa a tabela `tb_tarefas`
- **SubTarefaEntity**: Representa a tabela `tb_sub_tarefas`

### DTOs
- **Request**: Payloads de entrada para criação/edição
- **Response**: Payloads de saída, desacoplando a API das entidades internas
- **EdicaoCamposInterface**: Interface comum para DTOs de edição, garantindo contrato unificado (ISP) |

### Enums
- **Status**: Estados possíveis (SEM_STATUS, EM_ANDAMENTO, CONCLUIDO)
- **Prioridade**: Níveis de prioridade (1, 2, 3)

## Critérios de aceitação

- [x] O diagrama de classes permite implementar as funcionalidades detalhadas no diagrama de casos de uso.
- [x] O diagrama de classes permite implementar todas as user stories.
- [x] A semântica da UML foi aplicada corretamente.
