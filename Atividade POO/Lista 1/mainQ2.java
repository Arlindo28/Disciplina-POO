import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = sc.nextInt();

        boolean multiploDe3 = numero % 3 == 0;
        boolean multiploDe5 = numero % 5 == 0;

        if (multiploDe3 && multiploDe5) {
            System.out.println("Múltiplo de ambos");
        } else if (multiploDe3) {
            System.out.println("Múltiplo de 3");
        } else if (multiploDe5) {
            System.out.println("Múltiplo de 5");
        } else {
            System.out.println("Não é múltiplo de 3 nem de 5");
        }

        sc.close();
    }
}