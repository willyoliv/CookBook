package com.letscode.cookBook.domain;

import com.letscode.cookBook.enums.Categoria;

public class Receita {
    private String nome;
    private Categoria categoria;
    private int tempoPreparo;
    private Rendimento rendimento;
    private Ingrediente[] ingredientes;
    private String[] modoPreparo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public Rendimento getRendimento() {
        return rendimento;
    }

    public void setRendimento(Rendimento rendimento) {
        this.rendimento = rendimento;
    }

    public Ingrediente[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String[] getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String[] modoPreparo) {
        this.modoPreparo = modoPreparo;
    }
}
