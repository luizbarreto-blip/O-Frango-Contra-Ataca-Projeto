package mercado.personagens;

public abstract class Personagem {

    private final String nome;
    private int vida;
    private final int vidaMaxima;

    public Personagem(String nome, int vidaMaxima) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                "O nome não pode ser vazio."
            );
        }

        if (vidaMaxima <= 0) {
            throw new IllegalArgumentException(
                "A vida máxima deve ser positiva."
            );
        }

        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void receberDano(int dano) {

        if (dano < 0) {
            throw new IllegalArgumentException(
                "O dano não pode ser negativo."
            );
        }

        vida = Math.max(0, vida - dano);

        System.out.println(
            nome + " recebeu " + dano + " de dano."
        );

        System.out.println(
            "Vida: " + vida + "/" + vidaMaxima
        );
    }

    public void curar(int quantidade) {

        if (quantidade < 0) {
            throw new IllegalArgumentException(
                "A cura não pode ser negativa."
            );
        }

        vida = Math.min(
            vidaMaxima,
            vida + quantidade
        );
    }

    public abstract void atacar(Personagem alvo);
}
