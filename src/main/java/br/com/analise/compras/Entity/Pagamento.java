package br.com.analise.compras.Entity;

import br.com.analise.compras.Entity.enumeration.EstadoPagamentoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "TB_PAGAMENTO")
@SequenceGenerator(name = "seq_pagamento", sequenceName = "seq_pagamento")
public class Pagamento implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pagamento")
    @Column(name = "PA_ID")
    private Integer id;

    @Column(name = "PA_ESTADO")
    private EstadoPagamentoEnum estado;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "PE_ID")
    @MapsId
    private Pedido pedido;


    public Pagamento(){

    }

    public Pagamento(Integer id, EstadoPagamentoEnum estado, Pedido pedido) {
        this.id = id;
        this.estado = estado;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamentoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagamentoEnum estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
