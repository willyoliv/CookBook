package com.letscode.cookBook.domain;

import com.letscode.cookBook.enums.TipoMedida;

public class Ingrediente {
    private final String nome;
    private final double quantidade;
    private final TipoMedida tipoQuantidade;

    public Ingrediente(String nome, double quantidade, TipoMedida tipoQuantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipoQuantidade = tipoQuantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public TipoMedida getTipoQuantidade() {
        return tipoQuantidade;
    }
}
