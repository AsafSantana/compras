package br.com.analise.compras.Entity.enumeration;

public enum EstadoPagamentoEnum {

    PEDENTE("Pendente"),
    QUITADO("Quitado"),
    CANCELADO("Cancelado");


    String descricao;

    EstadoPagamentoEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
