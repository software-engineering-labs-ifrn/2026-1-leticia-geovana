package br.com.flowtasks.enums;

public enum Status {
    SEM_STATUS(1, "Sem status"),
    EM_ANDAMENTO(2, "Em andamento"),
    CONCLUIDO(3, "Concluido");

    private int codigo;
    private String descricao;

    Status(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }
}
