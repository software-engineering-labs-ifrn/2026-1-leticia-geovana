package br.com.flowtasks.dto;


public class SubTarefaRequestDto {
    private String nome;
    private Long tarefaPaiId;


    public SubTarefaRequestDto(String nome) {this.nome = nome;}

    public SubTarefaRequestDto() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTarefaPaiId() {
        return tarefaPaiId;
    }

    public void setTarefaPaiId(Long tarefaPaiId) {
        this.tarefaPaiId = tarefaPaiId;
    }
}
