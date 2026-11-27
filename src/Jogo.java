package mercado.jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mercado.combate.Combate;

import mercado.inimigos.CarrinhoMaluco;
import mercado.inimigos.CenouraMutante;
import mercado.inimigos.Gerente;
import mercado.inimigos.Inimigo;

import mercado.personagens.Frango;

public class Jogo {

    private final Scanner scanner;

    public Jogo() {
        scanner = new Scanner(System.in);
    }

    public void iniciar() {

        System.out.println("==============================");
        System.out.println("      O FRANGO CONTRA-ATACA");
        System.out.println("==============================");

        System.out.println(
            "Um frango congelado decidiu escapar!"
        );

        System.out.print(
            "\nDigite o nome do seu frango: "
        );

        String nome = scanner.nextLine().trim();

        if (nome.isBlank()) {
            nome = "Frango Congelado";
        }

        Frango frango = new Frango(nome);

        List<Inimigo> inimigos = criarInimigos();

        Combate combate = new Combate(scanner);

        System.out.println(
            "\nSua missão é derrotar todos os inimigos!"
        );

        while (
            frango.estaVivo() &&
            !inimigos.isEmpty()
        ) {

            Inimigo inimigoAtual = inimigos.get(0);

            boolean venceu = combate.iniciarCombate(
                frango,
                inimigoAtual
            );

            if (!venceu) {
                break;
            }

            inimigos.remove(inimigoAtual);

            System.out.println(
                "\nInimigos restantes: " + inimigos.size()
            );
        }

        if (
            frango.estaVivo() &&
            inimigos.isEmpty()
        ) {

            System.out.println(
                "\nO FRANGO VENCEU!"
            );

            System.out.println(
                "O supermercado está livre!"
            );

        } else {

            System.out.println(
                "\nFIM DE JOGO!"
            );
        }

        System.out.println(
            "\nObrigado por jogar O Frango Contra-Ataca!"
        );
    }

    private List<Inimigo> criarInimigos() {

        List<Inimigo> inimigos = new ArrayList<>();

        inimigos.add(new CenouraMutante());
        inimigos.add(new CarrinhoMaluco());
        inimigos.add(new Gerente());

        return inimigos;
    }
}
