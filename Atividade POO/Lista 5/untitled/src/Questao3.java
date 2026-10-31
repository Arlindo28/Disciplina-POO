interface AparelhoTelefonico {
    void ligar(String numero);
    void atender();
}

interface NavegadorInternet {
    void exibirPagina(String url);
    void adicionarNovaAba();
}

interface ReprodutorMusical {
    void tocar(String musica);
    void pausar();
}

class Smartphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {
    private final String modelo;
    private int abasAbertas = 1;
    private String musicaAtual;

    public Smartphone(String modelo) {
        this.modelo = modelo;
    }


    @Override
    public void ligar(String numero) {
        System.out.println("[" + modelo + "] Ligando para " + numero + "...");
    }

    @Override
    public void atender() {
        System.out.println("[" + modelo + "] Chamada atendida.");
    }


    @Override
    public void exibirPagina(String url) {
        System.out.println("[" + modelo + "] Exibindo a página: " + url);
    }

    @Override
    public void adicionarNovaAba() {
        abasAbertas++;
        System.out.println("[" + modelo + "] Nova aba aberta. Total de abas: " + abasAbertas);
    }


    @Override
    public void tocar(String musica) {
        musicaAtual = musica;
        System.out.println("[" + modelo + "] Tocando: " + musica);
    }

    @Override
    public void pausar() {
        if (musicaAtual == null) {
            System.out.println("[" + modelo + "] Nenhuma música tocando.");
        } else {
            System.out.println("[" + modelo + "] Música pausada: " + musicaAtual);
        }
    }
}

public class Questao3 {
    public static void main(String[] args) {
        Smartphone celular = new Smartphone("Galaxy S30");

        celular.ligar("(83) 99999-0000");
        celular.atender();

        celular.exibirPagina("https://www.ifpb.edu.br");
        celular.adicionarNovaAba();

        celular.tocar("Asa Branca - Luiz Gonzaga");
        celular.pausar();

        // O mesmo objeto pode ser visto por "papéis" diferentes:
        ReprodutorMusical player = celular;
        player.tocar("Qui Nem Jiló");
    }
}