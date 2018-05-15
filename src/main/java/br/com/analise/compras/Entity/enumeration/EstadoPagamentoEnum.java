package br.com.analise.compras.Entity.enumeration;

import br.com.analise.compras.Entity.Estado;

public enum EstadoPagamentoEnum {

    PENDENTE("Pendente"),
    QUITADO("Quitado"),
    CANCELADO("Cancelado");

    String descricao;

    EstadoPagamentoEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
