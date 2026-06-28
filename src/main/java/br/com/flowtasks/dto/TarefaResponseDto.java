package br.com.flowtasks.dto;

import br.com.flowtasks.entities.TarefaEntity;
import br.com.flowtasks.enums.Status;
import java.util.Date;

public class TarefaResponseDto {
	private String nome;
	private String descricao;
	private Date dataConclusao;
	private Status statusTarefa;


	public TarefaResponseDto(TarefaEntity tarefa) {
		this.nome = tarefa.getNome();
		this.descricao = tarefa.getDescricao();
		this.dataConclusao = tarefa.getDataConclusao();
		this.statusTarefa = tarefa.getStatusTarefa();
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
}
