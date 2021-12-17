package com.letscode.cookBook.controller;

import com.letscode.cookBook.domain.Receita;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Catalogo {
    private List<Receita> receitas;

    public Catalogo() {
        receitas = new ArrayList<>();
    }

    public int add(Receita nova) {
        if (nova != null && !nova.getNome().isBlank()) {
            if (!receitas.contains(nova)) {
                receitas.add(nova);
                return receitas.size() - 1;
            }
        }
        return receitas.size() - 1;
    }

    public void del(String nome) {
        Receita item = getReceita(nome);
        if (item != null) {
            receitas.remove(item);
        }
    }

    public Receita getReceita(String nome) {
        if (nome != null && !nome.isBlank()) {
            for (Receita item : receitas) {
                if (item.getNome().equalsIgnoreCase(nome)) {
                    return item;
                }
            }
        }
        return null;
    }

    public Receita getReceita(int index) {
        if (index >= 0 && index < receitas.size()) {
            return receitas.get(index);
        }
        return null;
    }

    public Receita getRandom() {
        if (receitas.isEmpty()) return null;

        int index = new Random().nextInt(receitas.size());
        return getReceita(index);
    }

    public int getSizeCatalogo() {
        return this.receitas.size();
    }
}
