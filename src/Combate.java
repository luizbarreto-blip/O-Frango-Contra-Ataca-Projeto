package mercado.combate;

import java.util.Scanner;

import mercado.inimigos.Inimigo;
import mercado.personagens.Frango;

public class Combate {

    private final Scanner scanner;

    public Combate(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean iniciarCombate(
        Frango frango,
        Inimigo inimigo
    ) {

        System.out.println("\n========================");
        System.out.println("COMBATE: " + inimigo.getNome());
        System.out.println("========================");

        while (
            frango.estaVivo() &&
            inimigo.estaVivo()
        ) {

            System.out.println("\n" + frango.getNome());
            System.out.println("Vida: " + frango.getVida());
            System.out.println("Energia: " + frango.getEnergia());

            System.out.println("\n" + inimigo.getNome());
            System.out.println("Vida: " + inimigo.getVida());

            System.out.println("\n1 - Ataque normal");
            System.out.println("2 - Tempero Especial");

            System.out.print("Escolha sua ação: ");

            int escolha = lerEscolha();

            if (escolha == 1) {

                frango.atacar(inimigo);

            } else if (escolha == 2) {

                frango.usarTemperoEspecial(inimigo);

            } else {

                System.out.println(
                    "Opção inválida. Você perdeu o turno!"
                );
            }

            if (inimigo.estaVivo()) {
                inimigo.atacar(frango);
            }
        }

        if (frango.estaVivo()) {

            System.out.println(
                "\nVocê derrotou " + inimigo.getNome() + "!"
            );

            frango.ganharEnergia(10);

            return true;
        }

        System.out.println("\nO frango foi derrotado!");

        return false;
    }

    private int lerEscolha() {

        while (!scanner.hasNextInt()) {

            System.out.print(
                "Digite uma opção numérica: "
            );

            scanner.next();
        }

        return scanner.nextInt();
    }
}
