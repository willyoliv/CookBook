package com.letscode.cookBook.view;

import com.letscode.cookBook.domain.Receita;
import com.letscode.cookBook.domain.Rendimento;
import com.letscode.cookBook.enums.Categoria;
import com.letscode.cookBook.enums.TipoRendimento;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NovaReceitaView {
    Scanner scanner;
    Receita receita;
    NovaReceitaView novaReceitaView;
    String nome;

    public NovaReceitaView() {
        this.scanner = new Scanner(System.in);
    }

    private String askNome() {
        System.out.println("Qual o nome da receita?");
        nome = new Scanner(System.in).nextLine();
        if (nome.isBlank()) {
            System.out.println("Nome inválido!");
            askNome();
        }
        return nome;
    }

    private Categoria askCategoria() {
        int categoria = 0;
        boolean isNumeroInvalido = true;
        while (isNumeroInvalido) {
            try {
                System.out.println("Qual a categoria da receita?");
                for (Categoria cat : Categoria.values()) {
                    System.out.printf("%d - %s | ", cat.ordinal(), cat.name());
                }
                System.out.println("");
                categoria = new Scanner(System.in).nextInt();
                isNumeroInvalido = false;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Caracter informado não corresponde a um número, tente novamente!");
            }
        }
        if (categoria < 0 || categoria >= Categoria.values().length) {
            System.out.println("Categoria inválida!");
            return askCategoria();
        } else {
            return Categoria.values()[categoria];
        }
    }

    private int askTempoPreparo() {
        int tempo = getNumeroInteiroMaiorQueZero("Qual o tempo de preparo em minutos?");
        return tempo;
    }

    private Rendimento askRendimento() {
        int quantidadeRendimento = getNumeroInteiroMaiorQueZero("Informe a quantidade de rendimento?");

        int tipo = 0;
        boolean isNumeroInvalido = true;
        while (isNumeroInvalido) {
            try {
                System.out.println("Qual a categoria da receita?");
                for (TipoRendimento tipoRendimento : TipoRendimento.values()) {
                    System.out.printf("%d - %s | ", tipoRendimento.ordinal(), tipoRendimento.name());
                }
                System.out.println("");
                tipo = new Scanner(System.in).nextInt();
                if (tipo >= 0 && tipo < TipoRendimento.values().length) {
                    isNumeroInvalido = false;
                } else {
                    System.out.println("TipoRendimento inválido!");
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Caracter informado não corresponde a um número, tente novamente!");
            }
        }
        TipoRendimento tipoRendimento = TipoRendimento.values()[tipo];
        Rendimento rendimento = new Rendimento(quantidadeRendimento, tipoRendimento);
        return rendimento;
    }


    private int getNumeroInteiroMaiorQueZero(String pergunta) {
        boolean isNumeroInvalido = true;
        int numero = 0;
        while (isNumeroInvalido) {
            try {
                System.out.println(pergunta);
                numero = new Scanner(System.in).nextInt();
                if (numero > 0) {
                    isNumeroInvalido = false;
                } else {
                    System.out.println("Tente um valor maior que Zero!");
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Caracter informado não corresponde a um número, tente novamente!");
            }
        }
        return numero;
    }

    public void showCadastroNovaReceita() {
        String nomeReceita = askNome();
        Categoria categoria = askCategoria();
        int tempoPreparo = askTempoPreparo();
        Rendimento redimento = askRendimento();
        System.out.println(nomeReceita);
        System.out.println(categoria);
        System.out.println(tempoPreparo);
        System.out.println(redimento.getQuantidade());
        System.out.println(redimento.getTipoRendimento());

    }
}
