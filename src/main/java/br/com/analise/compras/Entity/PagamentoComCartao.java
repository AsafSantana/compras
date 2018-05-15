package br.com.analise.compras.Entity;

import br.com.analise.compras.Entity.enumeration.EstadoPagamentoEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pagamento_com_cartao")
public class PagamentoComCartao extends Pagamento {

    @Column(name = "pc_numero_de_parcelas")
    private Integer numeroDeParcelas;

    public PagamentoComCartao() {

    }

    public PagamentoComCartao(Integer id, EstadoPagamentoEnum estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
