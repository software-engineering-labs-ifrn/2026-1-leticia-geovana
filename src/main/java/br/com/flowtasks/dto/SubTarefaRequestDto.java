package br.com.flowtasks.dto;


public class SubTarefaRequestDto {
    private String nome;


    public SubTarefaRequestDto(String nome) {this.nome = nome;}

    public SubTarefaRequestDto() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
