package br.com.analise.compras.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "TB_PRODUTO")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_produto")
    @Column(name = "PR_ID")
    private Integer id;

    @Column(name = "PR_NOME")
    private String nome;

    @Column(name = "PR_PRECO")
    private Double preco;


    /**
     * CONSTRUTORES
     *
     */
    public Produto() {
    }

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }



    /**
     * ASSOCIAÇOES
     *
     */

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "TB_PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "PR_ID"), inverseJoinColumns = @JoinColumn(name = "CA_ID"))
    private List<Categoria> categorias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();


    /**
     *
     * GETERS E SETERS
     *
     */

    @JsonIgnore
    public List<Pedido> getPedidos(){
        List<Pedido> lista = new ArrayList<>();

        for (ItemPedido x : itens){
            lista.add(x.getPedido());
        }
        return lista;
    }


    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
