package br.com.flowtasks.enums;

public enum Prioridade {

    PRIORIDADE_UM(1),
    PRIORIDADE_DOIS(2),
    PRIORIDADE_TRES(3);

    private int codigoPrioridade;

    Prioridade(int codigoPrioridade) {
        this.codigoPrioridade = codigoPrioridade;
    }

    public int getCodigoPrioridade() {
        return codigoPrioridade;
    }
}
