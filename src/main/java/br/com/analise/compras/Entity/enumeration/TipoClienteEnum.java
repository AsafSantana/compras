package br.com.analise.compras.Entity.enumeration;

public enum TipoClienteEnum {

    PESSOAFISICA("Pessoa Fisica"),
    PESSOAJURIDICA("Pessoa Juridica");

    String descricao;

    TipoClienteEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
