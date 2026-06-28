package br.com.flowtasks.dto;

import br.com.flowtasks.entities.TarefaEntity;
import br.com.flowtasks.enums.Status;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaResponseDto {
	private Long id;
	private String nome;
	private String descricao;
	private Date dataConclusao;
	private Status statusTarefa;
	private List<SubTarefaResponseDto> subTarefas;


	public TarefaResponseDto(TarefaEntity tarefa) {
		this.id = tarefa.getId();
		this.nome = tarefa.getNome();
		this.descricao = tarefa.getDescricao();
		this.dataConclusao = tarefa.getDataConclusao();
		this.statusTarefa = tarefa.getStatusTarefa();

		if (tarefa.getSubTarefas() != null) {
			this.subTarefas= tarefa.getSubTarefas().stream()
					.map(SubTarefaResponseDto::new)
					.collect(Collectors.toList());
		}
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

	public List<SubTarefaResponseDto> getSubtarefas() {
		return subTarefas;
	}

	public void setSubtarefas(List<SubTarefaResponseDto> subTarefas) {
		this.subTarefas = subTarefas;
	}
}
