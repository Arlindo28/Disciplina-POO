public class Aluno {
    private static final int MAX_NOTAS = 4;

    private String nome;
    private String matricula;
    private double[] notas;
    private int quantidadeNotas;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = new double[MAX_NOTAS];
        this.quantidadeNotas = 0;
    }

    public boolean cadastrarNota(double nota) {
        if (quantidadeNotas >= MAX_NOTAS) {
            System.out.println("Erro: " + nome + " já possui " + MAX_NOTAS + " notas cadastradas.");
            return false;
        }
        if (nota < 0 || nota > 10) {
            System.out.println("Erro: nota inválida (" + nota + "). Use valores entre 0 e 10.");
            return false;
        }
        notas[quantidadeNotas] = nota;
        quantidadeNotas++;
        return true;
    }

    public double calcularMedia() {
        if (quantidadeNotas == 0) {
            return 0.0;
        }
        double soma = 0;
        for (int i = 0; i < quantidadeNotas; i++) {
            soma += notas[i];
        }
        return soma / quantidadeNotas;
    }

    public boolean estaAprovado() {
        return calcularMedia() >= 7.0;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return String.format("%s (matrícula %s) - média %.2f", nome, matricula, calcularMedia());
    }
}