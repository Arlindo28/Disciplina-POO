import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o número " + (i + 1) + " (entre 1 e 30): ");
            numeros[i] = sc.nextInt();
        }

        System.out.println("\nGráfico de barras:");
        for (int i = 0; i < 5; i++) {
            StringBuilder barra = new StringBuilder();
            for (int j = 0; j < numeros[i]; j++) {
                barra.append("*");
            }
            System.out.println(barra.toString());
        }

        sc.close();
    }
}