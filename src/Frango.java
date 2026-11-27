package mercado.personagens;

public class Frango extends Personagem {

    private static final int DANO_NORMAL = 15;
    private static final int DANO_ESPECIAL = 30;

    private static final int ENERGIA_NECESSARIA = 30;

    private int energia;

    public Frango() {
        this("Frango Congelado");
    }

    public Frango(String nome) {
        super(nome, 100);

        this.energia = 0;
    }

    public int getEnergia() {
        return energia;
    }

    @Override
    public void atacar(Personagem alvo) {

        System.out.println(
            "O frango dá uma bicada!"
        );

        alvo.receberDano(DANO_NORMAL);
    }

    public boolean usarTemperoEspecial(Personagem alvo) {

        if (energia < ENERGIA_NECESSARIA) {

            System.out.println(
                "Energia insuficiente!"
            );

            return false;
        }

        energia -= ENERGIA_NECESSARIA;

        System.out.println(
            "TEMPEROOOO ESPECIAL!"
        );

        alvo.receberDano(DANO_ESPECIAL);

        return true;
    }

    public void ganharEnergia(int quantidade) {

        if (quantidade < 0) {
            throw new IllegalArgumentException(
                "A energia não pode ser negativa."
            );
        }

        energia += quantidade;

        System.out.println(
            "Energia atual: " + energia
        );
    }
}
