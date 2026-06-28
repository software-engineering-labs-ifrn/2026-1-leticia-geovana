package br.com.flowtasks.entities;

import br.com.flowtasks.enums.Prioridade;
import br.com.flowtasks.enums.Status;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_subTarefas")
public class SubTarefaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String descricao;
    private Timestamp dataCriacao;
    private Date dataConclusao;
    @Enumerated(EnumType.ORDINAL)
    private Status statusTarefa;
    @Enumerated(EnumType.ORDINAL)
    private Prioridade prioridadeTarefa;
    @ManyToOne
    @JoinColumn(name = "tarefaPai_id")
    private TarefaEntity tarefaPai;


    public SubTarefaEntity() {}

    public SubTarefaEntity(Long id, String nome, String descricao, Timestamp dataCriacao, Date dataConclusao, Status statusTarefa, Prioridade prioridadeTarefa, TarefaEntity tarefaPai) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataConclusao = dataConclusao;
        this.statusTarefa = statusTarefa;
        this.prioridadeTarefa = prioridadeTarefa;
        this.tarefaPai = tarefaPai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Timestamp dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Status getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(Status statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public Prioridade getPrioridadeTarefa() {
        return prioridadeTarefa;
    }

    public void setPrioridadeTarefa(Prioridade prioridadeTarefa) {
        this.prioridadeTarefa = prioridadeTarefa;
    }

    public TarefaEntity getTarefaPai() {
        return tarefaPai;
    }

    public void setTarefaPai(TarefaEntity tarefaPai) {
        this.tarefaPai = tarefaPai;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SubTarefaEntity that = (SubTarefaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(dataCriacao, that.dataCriacao) && Objects.equals(dataConclusao, that.dataConclusao) && statusTarefa == that.statusTarefa && prioridadeTarefa == that.prioridadeTarefa && Objects.equals(tarefaPai, that.tarefaPai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, dataCriacao, dataConclusao, statusTarefa, prioridadeTarefa, tarefaPai);
    }
}
