package mercado.inimigos;

import mercado.personagens.Personagem;

public class CenouraMutante extends Inimigo {

    public CenouraMutante() {
        super("Cenoura Mutante", 30, 8);
    }

    @Override
    public void atacar(Personagem alvo) {

        System.out.println(
            "A Cenoura Mutante dispara uma folha afiada!"
        );

        alvo.receberDano(getDanoAtaque());
    }
}
