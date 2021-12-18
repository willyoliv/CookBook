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
            System.out.println("Qual a categoria da receita?");
            for (Categoria cat : Categoria.values()) {
                System.out.printf("%d - %s%n", cat.ordinal(), cat.name());
            }
            try {
                this.scanner = new Scanner(System.in);
                categoria = this.scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Caracter informado não corresponde a um número, tente novamente!");
            }
            if (categoria >= 0 && categoria < Categoria.values().length) {
                isNumeroInvalido = false;
            } else {
                System.out.println("Tipo de rendimento inválido!");
                System.out.println("");
            }
        }
        return Categoria.values()[categoria];
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
            System.out.println("Qual a categoria da receita?");
            for (TipoRendimento tipoRendimento : TipoRendimento.values()) {
                System.out.printf("%d - %s %n", tipoRendimento.ordinal(), tipoRendimento.name());
            }
            try {
                this.scanner = new Scanner(System.in);
                tipo = this.scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Caracter informado não corresponde a um número, tente novamente!");
            }
            if (tipo >= 0 && tipo < TipoRendimento.values().length) {
                isNumeroInvalido = false;
            } else {
                System.out.println("Tipo de rendimento inválido!");
                System.out.println("");
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
                System.out.println("Qual o tipo de medida do ingrediente?");
                for (TipoMedida tipoMedidaItem : TipoMedida.values()) {
                    System.out.printf("%d - %s%n", tipoMedidaItem.ordinal(), tipoMedidaItem.name());
                }
                try {
                    this.scanner = new Scanner(System.in);
                    tipoMedida = this.scanner.nextInt();
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Caracter informado não corresponde a um número, tente novamente!");
                }
                if (tipoMedida >= 0 && tipoMedida < TipoMedida.values().length) {
                    isNumeroInvalido = false;
                } else {
                    System.out.println("Tipo de medida inválido!");
                    System.out.println("");
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
        this.scanner = new Scanner(System.in);
        String nome = this.scanner.nextLine();
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
            System.out.println(pergunta);
            try {
                this.scanner = new Scanner(System.in);
                numero = this.scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Caracter informado não corresponde a um número, tente novamente!");
            }
            if (numero > 0) {
                isNumeroInvalido = false;
            } else {
                System.out.println("Tente um valor maior que Zero!");
            }
        }
        return numero;
    }

    private double getNumeroDoubleMaiorQueZero(String mensagem) {
        boolean isNumeroInvalido = true;
        double numero = 0;
        while (isNumeroInvalido) {
            System.out.println(mensagem);
            try {
                this.scanner = new Scanner(System.in);
                numero = this.scanner.nextDouble();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Caracter informado não corresponde a um número, tente novamente!");
            }
            if (numero > 0) {
                isNumeroInvalido = false;
            } else {
                System.out.println("Tente um valor maior que Zero!");
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
