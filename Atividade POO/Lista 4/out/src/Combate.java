import java.util.List;
import java.util.Random;

abstract class Personagem {

    protected static final Random RNG = new Random(42);

    private final String nome;
    private int vida;

    protected Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

    public String getNome() { return nome; }
    public int getVida()    { return vida; }
    public boolean estaVivo() { return vida > 0; }

    public void receberDano(int dano) {
        vida = Math.max(0, vida - dano);
    }

    public abstract int atacar();
}

class Guerreiro extends Personagem {
    private final int forca;

    public Guerreiro(String nome) {
        super(nome, 150);
        this.forca = 18;
    }

    @Override
    public int atacar() {

        boolean critico = RNG.nextDouble() < 0.25;
        int dano = forca + RNG.nextInt(6);
        if (critico) {
            dano *= 2;
            System.out.printf("%s desfere um GOLPE CRÍTICO com a espada! (%d de dano)%n", getNome(), dano);
        } else {
            System.out.printf("%s golpeia com a espada. (%d de dano)%n", getNome(), dano);
        }
        return dano;
    }
}

class Mago extends Personagem {
    private static final int CUSTO_FEITICO = 30;
    private int mana;

    public Mago(String nome) {
        super(nome, 90);
        this.mana = 70;
    }

    @Override
    public int atacar() {
        if (mana >= CUSTO_FEITICO) {
            mana -= CUSTO_FEITICO;
            int dano = 30 + RNG.nextInt(11);
            System.out.printf("%s lança Bola de Fogo! (%d de dano, mana restante: %d)%n", getNome(), dano, mana);
            return dano;
        }

        mana += 10;
        int dano = 5;
        System.out.printf("%s está sem mana e bate com o cajado. (%d de dano, mana: %d)%n", getNome(), dano, mana);
        return dano;
    }
}

class Arqueiro extends Personagem {
    private int flechas;

    public Arqueiro(String nome) {
        super(nome, 110);
        this.flechas = 5;
    }

    @Override
    public int atacar() {
        if (flechas == 0) {
            System.out.printf("%s está sem flechas e ataca com a adaga. (6 de dano)%n", getNome());
            return 6;
        }

        int disparos = Math.min(2, flechas);
        flechas -= disparos;
        int dano = 0;
        for (int i = 0; i < disparos; i++) {
            if (RNG.nextDouble() >= 0.20) dano += 12;
        }
        System.out.printf("%s dispara %d flecha(s). (%d de dano, flechas restantes: %d)%n",
                getNome(), disparos, dano, flechas);
        return dano;
    }
}

public class Combate {
    public static void main(String[] args) {
        List<Personagem> grupo = List.of(
                new Guerreiro("Aragorn"),
                new Mago("Gandalf"),
                new Arqueiro("Legolas")
        );

        int vidaChefe = 250;
        int turno = 1;

        System.out.println("=== Um Dragão aparece! Vida: " + vidaChefe + " ===");
        while (vidaChefe > 0 && turno <= 5) {
            System.out.println("\n--- Turno " + turno + " ---");
            for (Personagem p : grupo) {
                if (!p.estaVivo() || vidaChefe <= 0) continue;
                int dano = p.atacar();
                vidaChefe = Math.max(0, vidaChefe - dano);
            }
            System.out.println("Vida do Dragão: " + vidaChefe);
            turno++;
        }

        System.out.println(vidaChefe == 0
                ? "\nO Dragão foi derrotado!"
                : "\nO Dragão sobreviveu... o grupo recua.");
    }
}