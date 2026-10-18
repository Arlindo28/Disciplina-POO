import java.util.List;

abstract class Pagamento {
    private final String descricao;

    protected Pagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract double processar(double valor);

    protected void imprimirResumo(double valorOriginal, double valorFinal, String regra) {
        System.out.printf("[%s] Original: R$ %.2f | %s | Final: R$ %.2f%n",
                descricao, valorOriginal, regra, valorFinal);
    }
}

class CartaoCredito extends Pagamento {
    private static final double TAXA = 0.035;
    private final int parcelas;

    public CartaoCredito(int parcelas) {
        super("Cartão de Crédito");
        if (parcelas < 1) throw new IllegalArgumentException("Parcelas deve ser >= 1");
        this.parcelas = parcelas;
    }

    @Override
    public double processar(double valor) {
        double juros = (parcelas > 1) ? 0.01 * (parcelas - 1) : 0.0;
        double total = valor * (1 + TAXA + juros);
        imprimirResumo(valor, total,
                String.format("Taxa %.1f%% + juros %.1f%% em %dx de R$ %.2f",
                        TAXA * 100, juros * 100, parcelas, total / parcelas));
        return total;
    }
}

class Boleto extends Pagamento {
    private static final double DESCONTO = 0.05;
    private static final double TARIFA = 2.50;

    public Boleto() {
        super("Boleto");
    }

    @Override
    public double processar(double valor) {
        double total = valor * (1 - DESCONTO) + TARIFA;
        imprimirResumo(valor, total,
                String.format("Desconto %.0f%% + tarifa R$ %.2f", DESCONTO * 100, TARIFA));
        return total;
    }
}

class Pix extends Pagamento {
    private static final double DESCONTO = 0.10;

    public Pix() {
        super("Pix");
    }

    @Override
    public double processar(double valor) {
        double total = valor * (1 - DESCONTO);
        imprimirResumo(valor, total,
                String.format("Desconto %.0f%%, sem tarifa", DESCONTO * 100));
        return total;
    }
}

public class Pagamentos {
    public static void main(String[] args) {
        double valorCompra = 500.00;

        List<Pagamento> formas = List.of(
                new CartaoCredito(1),
                new CartaoCredito(6),
                new Boleto(),
                new Pix()
        );

        System.out.println("=== Processando compra de R$ " + String.format("%.2f", valorCompra) + " ===");
        for (Pagamento p : formas) {
            p.processar(valorCompra);
        }
    }
}