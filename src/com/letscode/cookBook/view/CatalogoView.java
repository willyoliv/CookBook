package com.letscode.cookBook.view;

import com.letscode.cookBook.controller.Catalogo;
import com.letscode.cookBook.domain.Receita;
import com.letscode.cookBook.enums.Categoria;

import java.util.Scanner;

public class CatalogoView {
    private Receita receita;
    Catalogo controller;
    private int curIndex;
    private NovaReceitaView novaReceitaView;

    public CatalogoView() {
        this.novaReceitaView = new NovaReceitaView();
        this.controller = new Catalogo();
        this.curIndex = controller.getSizeCatalogo() - 1;
    }

    private void showHeader() {
        ScreenUtil.printTextLine("", 80, true, '=');
        ScreenUtil.printTextLine("#### #### #### #  #  ###  #### #### #  #", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # # #   #  # #  # #  # # # ", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # ##    ###  #  # #  # ##  ", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # # #   #  # #  # #  # # # ", 80, true, ' ');
        ScreenUtil.printTextLine("#### #### #### #  #  ###  #### #### #  #", 80, true, ' ');
        ScreenUtil.printTextLine("", 80, true, '=');
    }

    private void showReceita(Receita receita) {
        System.out.println(receita.toString());
    }

    private void showAnterior() {
        if (curIndex > 0 && controller.getSizeCatalogo() - 1 > 0) {
            this.receita = controller.getReceita(curIndex - 1);
            curIndex--;
        }
    }

    private void showSeguinte() {
        if(curIndex + 1 <= controller.getSizeCatalogo() - 1) {
            this.receita = controller.getReceita(curIndex + 1);
            curIndex++;
        }
    }

    private void add() {
        this.receita = this.novaReceitaView.showCadastroNovaReceita();
        this.curIndex =  this.controller.add(this.receita);
        System.out.println("Cadastro realizado");

    }

    private void del() {
        if (curIndex >= 0) {
            controller.del(receita.getNome());
            if (controller.getSizeCatalogo() == 0) {
                this.receita = null;
                this.curIndex = controller.getSizeCatalogo() - 1;
            } {
                this.receita = controller.getReceita(0);
                this.curIndex = 0;
            }
        }
    }

    private void searchReceita() {
        String nome = getTextoValido("Qual o nome da receita?");
        this.receita = controller.getReceita(nome);
    }
    public void show() {
        showHeader();
        String option;
        do {
            showMenu();
            option = new Scanner(System.in).next();
            switch (option.toUpperCase()) {
                case "P":
                    showAnterior();
                    break;
                case "N":
                    showSeguinte();
                    break;
                case "+":
                    add();
                    break;
                case "-":
                    del();
                    break;
                case "S":
                    searchReceita();
                    break;
                default:
                    ScreenUtil.printTextLine("Opção inválida", 80);
                    ScreenUtil.printTextLine("#: ", 80);
            }
        } while (true);
    }

    private void showMenu() {
        if (receita != null) {
            ScreenUtil.printTextLine("", 80, true, '=');
            ScreenUtil.printTextLine("Receita", 80, true);
            showReceita(this.receita);
        }
        ScreenUtil.printTextLine("", 80, true, '=');
        ScreenUtil.printTextLine("P: Receita anterior", 80, true);
        ScreenUtil.printTextLine("N: Receita seguinte", 80, true);
        ScreenUtil.printTextLine("+: Adicionar nova receita", 80, true);
        ScreenUtil.printTextLine("-: Remover receita", 80, true);
        ScreenUtil.printTextLine("S: Pesquisar receita", 80, true);
        ScreenUtil.printTextLine("", 80, true, '=');
        ScreenUtil.printTextLine("#: ", 80);
    }

    private String getTextoValido(String pergunta) {
        System.out.println(pergunta);
        String nome = new Scanner(System.in).nextLine();
        if (nome.isBlank()) {
            System.out.println("Texto inválido!");
            return getTextoValido(pergunta);
        }
        return nome;
    }

}
