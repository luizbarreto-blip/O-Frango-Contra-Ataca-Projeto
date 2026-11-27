package mercado.inimigos;

import mercado.personagens.Personagem;

public abstract class Inimigo extends Personagem {

    private final int danoAtaque;

    public Inimigo(
        String nome,
        int vida,
        int danoAtaque
    ) {

        super(nome, vida);

        if (danoAtaque < 0) {
            throw new IllegalArgumentException(
                "O dano não pode ser negativo."
            );
        }

        this.danoAtaque = danoAtaque;
    }

    protected int getDanoAtaque() {
        return danoAtaque;
    }
}
