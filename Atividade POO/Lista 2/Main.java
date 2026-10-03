import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número da conta: ");
        int numero = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Nome do titular: ");
        String titular = sc.nextLine();

        ContaCorrente conta = new ContaCorrente(numero, titular);

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Consultar saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor do saque: ");
                    float valorSaque = sc.nextFloat();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso.");
                    }
                    break;
                case 2:
                    System.out.print("Valor do depósito: ");
                    float valorDeposito = sc.nextFloat();
                    if (conta.depositar(valorDeposito)) {
                        System.out.println("Depósito realizado com sucesso.");
                    }
                    break;
                case 3:
                    System.out.printf("Saldo atual: R$ %.2f%n", conta.consultarSaldo());
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
