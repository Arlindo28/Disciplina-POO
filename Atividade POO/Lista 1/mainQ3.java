import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo N: ");
        int n = sc.nextInt();

        System.out.println("Números primos entre 2 e " + n + ":");

        for (int numero = 2; numero <= n; numero++) {
            if (ehPrimo(numero)) {
                System.out.print(numero + " ");
            }
        }
        System.out.println();

        sc.close();
    }

    public static boolean ehPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}