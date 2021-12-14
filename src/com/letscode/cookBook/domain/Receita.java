package com.letscode.cookBook.domain;

import com.letscode.cookBook.enums.Categoria;

import java.util.ArrayList;
import java.util.List;

public class Receita {
    private String nome;
    private Categoria categoria;
    private int tempoPreparo;
    private Rendimento rendimento;
    private List<Ingrediente> ingredientes;
    private String[] modoPreparo;

    public Receita(String nome, Categoria categoria) {
        this.ingredientes = new ArrayList<>();
        this.nome = nome;
        this.categoria = categoria;
    }

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

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        for (Ingrediente item : ingredientes) {
            this.ingredientes.add(item);
        }
    }

    public String[] getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String[] modoPreparo) {
        this.modoPreparo = modoPreparo;
    }
}
