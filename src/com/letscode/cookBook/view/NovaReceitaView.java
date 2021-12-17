package com.letscode.cookBook.view;

import com.letscode.cookBook.domain.Ingrediente;
import com.letscode.cookBook.domain.Receita;
import com.letscode.cookBook.domain.Rendimento;
import com.letscode.cookBook.enums.Categoria;
import com.letscode.cookBook.enums.TipoMedida;
import com.letscode.cookBook.enums.TipoRendimento;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        String nome = getTextoValido("Qual o nome da receita?");
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

    private List<Ingrediente> askListaDeIngredientes() {
        int quantidadeIngredientes = getNumeroInteiroMaiorQueZero("Quantos ingredientes a receita possui?");
        List<Ingrediente> ingredientes = new ArrayList<>();
        for (int i = 0; i < quantidadeIngredientes; i++) {
            String nome = getTextoValido("Qual o nome do ingrediente?");
            double quantidade = getNumeroDoubleMaiorQueZero("Informe a quantidade necessária para o ingrediente");

            int tipoMedida = 0;
            boolean isNumeroInvalido = true;
            while (isNumeroInvalido) {
                try {
                    System.out.println("Qual o tipo de medida do ingrediente?");
                    for (TipoMedida tipoMedidaItem : TipoMedida.values()) {
                        System.out.printf("%d - %s | ", tipoMedidaItem.ordinal(), tipoMedidaItem.name());
                    }
                    System.out.println("");
                    tipoMedida = new Scanner(System.in).nextInt();
                    if (tipoMedida >= 0 && tipoMedida < TipoMedida.values().length) {
                        isNumeroInvalido = false;
                    } else {
                        System.out.println("TipoMedida inválido!");
                    }
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Caracter informado não corresponde a um número, tente novamente!");
                }
            }
            TipoMedida tipoMedidaIngrediente = TipoMedida.values()[tipoMedida];
            Ingrediente ingrediente = new Ingrediente(nome, quantidade, tipoMedidaIngrediente);
            ingredientes.add(ingrediente);
        }
        return ingredientes;
    }

    private String[] askModoPreparo() {
        int quantidadeDePassos = getNumeroInteiroMaiorQueZero("Quantos passos são necessário para preparo?");
        String[] passosParaPreparo = new String[quantidadeDePassos];
        for (int i = 0; i < quantidadeDePassos; i++) {
            String passo = getTextoValido("Qual o modo de preparo?");
            passosParaPreparo[i] = passo;
        }
        return passosParaPreparo;
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

    private double getNumeroDoubleMaiorQueZero(String mensagem) {
        boolean isNumeroInvalido = true;
        double numero = 0;
        while (isNumeroInvalido) {
            try {
                System.out.println(mensagem);
                numero = new Scanner(System.in).nextDouble();
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

    public Receita showCadastroNovaReceita() {
        String nomeReceita = askNome();
        Categoria categoria = askCategoria();
        int tempoPreparo = askTempoPreparo();
        Rendimento redimento = askRendimento();
        List<Ingrediente> ingredientes = askListaDeIngredientes();
        String[] modoPreparo = askModoPreparo();
        Receita receita = new Receita(nomeReceita, categoria, tempoPreparo, redimento, ingredientes, modoPreparo);
        return receita;
    }
}
