package com.pierre.api_pedidos_comunicacao.model;

public class ProdutoResposta {
    private Long id;
    private String nome;
    private int qtdDisponivel;

    public ProdutoResposta() {}

    public ProdutoResposta(Long id, String nome, int qtdDisponivel) {
        this.id = id;
        this.nome = nome;
        this.qtdDisponivel = qtdDisponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }
}
