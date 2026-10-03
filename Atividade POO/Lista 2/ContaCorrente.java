public class ContaCorrente {
    private static final float LIMITE_OPERACAO = 10000f;

    private int numero;
    private String titular;
    private float saldo;

    public ContaCorrente(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0f;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public boolean sacar(float valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return false;
        }
        if (valor > LIMITE_OPERACAO) {
            System.out.println("Saque não permitido: limite de R$ 10000,00 por operação.");
            return false;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return false;
        }
        saldo -= valor;
        return true;
    }

    public boolean depositar(float valor) {
        if (valor <= 0) {
            System.out.println("Depósito não permitido: o valor deve ser positivo.");
            return false;
        }
        if (valor > LIMITE_OPERACAO) {
            System.out.println("Depósito não permitido: limite de R$ 10000,00 por operação.");
            return false;
        }
        saldo += valor;
        return true;
    }

    public float consultarSaldo() {
        return saldo;
    }
}
