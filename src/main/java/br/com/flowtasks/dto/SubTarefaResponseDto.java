package br.com.flowtasks.dto;

import br.com.flowtasks.entities.SubTarefaEntity;
import br.com.flowtasks.enums.Status;
import java.util.Date;

public class SubTarefaResponseDto {
    private Long id;
    private String nome;
    private String descricao;
    private Date dataConclusao;
    private Status statusTarefa;

    public SubTarefaResponseDto() {}

    public SubTarefaResponseDto(SubTarefaEntity subTarefa) {
        this.id = subTarefa.getId();
        this.nome = subTarefa.getNome();
        this.descricao = subTarefa.getDescricao();
        this.dataConclusao = subTarefa.getDataConclusao();
        this.statusTarefa = subTarefa.getStatusTarefa();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
