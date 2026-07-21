package br.com.flowtasks.dto;

import br.com.flowtasks.enums.Prioridade;
import br.com.flowtasks.enums.Status;

import java.util.Date;

public interface EdicaoCamposInterface {
    String getNome();
    void setNome(String nome);
    String getDescricao();
    void setDescricao(String descricao);
    Date getDataConclusao();
    void setDataConclusao(Date dataConclusao);
    Status getStatusTarefa();
    void setStatusTarefa(Status statusTarefa);
    Prioridade getPrioridadeTarefa();
    void setPrioridadeTarefa(Prioridade prioridadeTarefa);
}
