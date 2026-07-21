package br.com.flowtasks.dto;

import br.com.flowtasks.enums.Prioridade;
import br.com.flowtasks.enums.Status;

import java.util.Date;

public class SubTarefaEdicaoDto implements EdicaoCamposInterface {
    private String nome;
    private String descricao;
    private Date dataConclusao;
    private Status statusTarefa;
    private Prioridade prioridadeTarefa;

    public SubTarefaEdicaoDto() {}

    public SubTarefaEdicaoDto(String nome, String descricao, Date dataConclusao, Status statusTarefa, Prioridade prioridadeTarefa) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataConclusao = dataConclusao;
        this.statusTarefa = statusTarefa;
        this.prioridadeTarefa = prioridadeTarefa;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
}
