import java.util.Arrays;
import java.util.Scanner;

public class MegaSena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[6];
        int quantidade = 0;

        while (quantidade < numeros.length) {
            System.out.print("Digite o " + (quantidade + 1) + "º número (1 a 60): ");

            if (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                sc.next(); // descarta a entrada inválida
                continue;
            }
            int numero = sc.nextInt();

            if (numero < 1 || numero > 60) {
                System.out.println("Número fora do intervalo. Use valores de 1 a 60.");
                continue;
            }

            boolean duplicado = false;
            for (int i = 0; i < quantidade; i++) {
                if (numeros[i] == numero) {
                    duplicado = true;
                    break;
                }
            }
            if (duplicado) {
                System.out.println("Número " + numero + " já foi informado. Escolha outro.");
                continue;
            }

            numeros[quantidade] = numero;
            quantidade++;
        }

        Arrays.sort(numeros);
        System.out.println("Seu jogo: " + Arrays.toString(numeros));
        sc.close();
    }
}
