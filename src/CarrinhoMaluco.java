package mercado.inimigos;

import mercado.personagens.Personagem;

public class CarrinhoMaluco extends Inimigo {

    public CarrinhoMaluco() {
        super("Carrinho Maluco", 60, 12);
    }

    @Override
    public void atacar(Personagem alvo) {

        System.out.println(
            "O Carrinho Maluco avança fazendo BIP BIP!"
        );

        alvo.receberDano(getDanoAtaque());
    }
}
