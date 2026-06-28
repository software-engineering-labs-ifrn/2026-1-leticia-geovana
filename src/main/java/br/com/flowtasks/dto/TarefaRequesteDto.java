package br.com.flowtasks.dto;

public class TarefaRequesteDto {

	private String nome;

	public TarefaRequesteDto(String nome) {
		this.nome = nome;
	}

	public TarefaRequesteDto() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
