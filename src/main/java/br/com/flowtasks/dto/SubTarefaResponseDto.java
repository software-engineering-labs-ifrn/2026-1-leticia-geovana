package br.com.flowtasks.dto;

import br.com.flowtasks.entities.SubTarefaEntity;
import br.com.flowtasks.enums.Prioridade;
import br.com.flowtasks.enums.Status;
import java.time.LocalDate;
import java.util.Date;

public class SubTarefaResponseDto {
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    private Date dataConclusao;
    private Status statusTarefa;
    private Prioridade prioridadeTarefa;

    public SubTarefaResponseDto() {}

    public SubTarefaResponseDto(SubTarefaEntity subTarefa) {
        this.id = subTarefa.getId();
        this.nome = subTarefa.getNome();
        this.descricao = subTarefa.getDescricao();
        this.dataCriacao = subTarefa.getDataCriacao();
        this.dataConclusao = subTarefa.getDataConclusao();
        this.statusTarefa = subTarefa.getStatusTarefa();
        this.prioridadeTarefa = subTarefa.getPrioridadeTarefa();
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
