package br.com.analise.compras.Entity;

import br.com.analise.compras.Entity.enumeration.TipoClienteEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente")
public class Cliente implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_cliente")
    @Column(name = "CL_ID")
    private Integer id;

    @Column(name = "CL_NOME")
    private String nome;

    @Column(name = "CL_EMAIL")
    private String email;

    @Column(name = "CL_CPF_CNPJ")
    private String cpfOuCnpj;

    @Column(name = "CL_TIPO_CLIENTE")
    private TipoClienteEnum tipoCLiente;

    @ElementCollection
    @CollectionTable(name = "TB_TELEFONE", joinColumns = @JoinColumn(name = "CL_ID"))
    private Set<String>  telefone = new HashSet<>();


    @OneToMany (mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();


    @JsonIgnore
    @OneToMany (mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();


    public Cliente(){


    }

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoClienteEnum tipoCLiente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCLiente = tipoCLiente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoClienteEnum getTipoCLiente() {
        return tipoCLiente;
    }

    public void setTipoCLiente(TipoClienteEnum tipoCLiente) {
        this.tipoCLiente = tipoCLiente;
    }

    public Set<String> getTelefone() {
        return telefone;
    }

    public void setTelefone(Set<String> telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
