package br.com.analise.compras.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TB_ESTADO")
@SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado")
public class Estado implements Serializable {

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_estado")
    @Column(name = "ES_ID")
    private Integer id;
    
    @Column(name = "CI_NOME")
    private String nome;


    public Estado() {

    }

    public Estado(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    /**
     * 
     */

  /**
     * ASSOCIAÇOES
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "estado") //nome da variavel da cidade
    private List<Cidade> cidade = new ArrayList<>();

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

    public List<Cidade> getCidade() {
        return cidade;
    }

    public void setCidade(List<Cidade> cidade) {
        this.cidade = cidade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
