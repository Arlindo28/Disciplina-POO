import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos termos da série de Fibonacci? ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Informe um valor maior que zero.");
        } else if (n > 93) {
            // A partir do 94º termo o valor não cabe em um long
            System.out.println("Use n até 93 (limite do tipo long).");
        } else {
            long[] fib = new long[n];
            fib[0] = 0;
            if (n > 1) {
                fib[1] = 1;
            }
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            System.out.println(Arrays.toString(fib));
        }
        sc.close();
    }
}
