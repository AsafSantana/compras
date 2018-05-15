package br.com.analise.compras.Entity.enumeration;

public enum TipoClienteEnum {

    PESSOAFISICA("Pessoa Física"),
    PESSOAJURIDICA("Pessoa Jurídica");

    String descricao;

    TipoClienteEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
