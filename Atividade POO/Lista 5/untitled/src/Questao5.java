import java.util.List;

interface Imprimivel {
    void imprimir();
}

interface EnviavelPorEmail {
    void enviar(String email);
}

interface Documento {
    void processar();
}

class RelatorioFinanceiro implements Imprimivel, EnviavelPorEmail, Documento {
    private final String titulo;
    private final String destinatario;

    public RelatorioFinanceiro(String titulo, String destinatario) {
        this.titulo = titulo;
        this.destinatario = destinatario;
    }

    public String getDestinatario() {
        return destinatario;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimindo relatório financeiro: " + titulo);
    }

    @Override
    public void enviar(String email) {
        System.out.println("Enviando relatório '" + titulo + "' para " + email);
    }

    @Override
    public void processar() {
        imprimir();
        enviar(destinatario);
    }
}

class Contrato implements Imprimivel, Documento {
    private final String partes;

    public Contrato(String partes) {
        this.partes = partes;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimindo contrato entre " + partes);
    }

    @Override
    public void processar() {
        imprimir();
    }
}

public class Questao5 {
    public static void main(String[] args) {

        System.out.println("=== Abordagem 1: instanceof ===");
        List<Imprimivel> documentos = List.of(
                new RelatorioFinanceiro("Balanço 3º trimestre", "financeiro@empresa.com"),
                new Contrato("Empresa X e Fornecedor Y"),
                new RelatorioFinanceiro("Fluxo de caixa outubro", "diretoria@empresa.com")
        );

        for (Imprimivel doc : documentos) {
            doc.imprimir();
            if (doc instanceof RelatorioFinanceiro rel) {
                rel.enviar(rel.getDestinatario());
            }
        }


        System.out.println();
        System.out.println("=== Abordagem 2: polimorfismo (sem instanceof) ===");
        List<Documento> fila = List.of(
                new RelatorioFinanceiro("Balanço 3º trimestre", "financeiro@empresa.com"),
                new Contrato("Empresa X e Fornecedor Y"),
                new RelatorioFinanceiro("Fluxo de caixa outubro", "diretoria@empresa.com")
        );

        for (Documento doc : fila) {
            doc.processar();
        }
    }
}
