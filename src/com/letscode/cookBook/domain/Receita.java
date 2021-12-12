package com.letscode.cookBook.domain;

import com.letscode.cookBook.enums.Categoria;

public class Receita {
    private String nome;
    private Categoria categoria;
    private int tempoPreparo;
    private Rendimento rendimento;
    private Ingrediente[] ingredientes;
    private String[] modoPreparo;
}
