public class Teste {
    public static void main(String[] args) {
        Aluno gugu = new Aluno("Gugu", "2026001");
        gugu.cadastrarNota(8.0);
        gugu.cadastrarNota(7.5);
        gugu.cadastrarNota(9.0);
        gugu.cadastrarNota(6.5);
        gugu.cadastrarNota(10.0);

        Aluno ray = new Aluno("Ray", "2026002");
        ray.cadastrarNota(5.0);
        ray.cadastrarNota(6.0);
        ray.cadastrarNota(7.0);

        Aluno pedin = new Aluno("Pedin", "2026003");
        pedin.cadastrarNota(7.0);
        pedin.cadastrarNota(7.0);

        Turma turma = new Turma(30);
        turma.adicionarAluno(gugu);
        turma.adicionarAluno(ray);
        turma.adicionarAluno(pedin);

        System.out.println();
        turma.listarAprovados();
        System.out.println();
        turma.listarReprovados();
    }
}