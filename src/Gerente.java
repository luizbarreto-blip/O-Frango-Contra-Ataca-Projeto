package mercado.inimigos;

import mercado.personagens.Personagem;

public class Gerente extends Inimigo {

    public Gerente() {
        super("Gerente do Mercado", 100, 15);
    }

    @Override
    public void atacar(Personagem alvo) {

        System.out.println(
            "O Gerente lança uma promoção imperdível!"
        );

        alvo.receberDano(getDanoAtaque());
    }
}
