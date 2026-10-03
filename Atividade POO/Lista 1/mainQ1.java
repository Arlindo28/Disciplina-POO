import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String nome = sc.nextLine();

        System.out.print("Digite a primeira nota: ");
        double nota1 = sc.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = sc.nextDouble();

        System.out.print("Digite a terceira nota (peso 2): ");
        double nota3 = sc.nextDouble();

        double media = (nota1 + nota2 + nota3 * 2) / 4;

        System.out.printf("%nAluno: %s%n", nome);
        System.out.printf("Média ponderada: %.2f%n", media);

        if (media >= 7) {
            System.out.println("Situação: Aprovado");
        } else {
            System.out.println("Situação: Reprovado");
        }

        sc.close();
    }
}