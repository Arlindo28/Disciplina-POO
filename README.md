# Disciplina-POO
Repositório para visualização de atividades

LISTA 1:

Questão 5  

O Scanner é a forma mais comum de ler dados que o usuário digita no console. A lógica é sempre a mesma: você importa a classe (import java.util.Scanner;), cria um objeto associado à entrada padrão (Scanner sc = new Scanner(System.in);) e depois usa métodos específicos dependendo do tipo de dado que quer ler: nextInt() para inteiro, nextDouble() para double, nextLine() para uma linha de texto, e assim por diante. 

Já o System.out.printf serve para formatar a saída, algo que o System.out.println sozinho não faz muito bem. Com o printf, você usa um texto com "marcadores" (%d para inteiro, %s para string, %f para float/double, %n para quebra de linha) e depois passa os valores na ordem em que eles devem substituir os marcadores.  

 Exemplo lendo um double e exibindo com 2 casas decimais: 

 import java.util.Scanner;

public class ExemploScannerPrintf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um valor: ");
        double valor = sc.nextDouble();

        System.out.printf("O valor digitado foi: %.2f%n", valor);

        sc.close();
    }
}

O %.2f garante que o número apareça sempre com duas casas depois da vírgula, mesmo que o usuário digite algo como 10 ou 10.5.



Questão 6

O código tem três problemas, sendo um de sintaxe e dois de lógica:

public static void main(String args) — isso não compila, o main precisa receber um array de Strings, ou seja, tem que ser String[] args. Sem os colchetes, o Java nem reconhece esse método como o ponto de entrada do programa.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------

LISTA 2:

Questão 1

Usar getters e setters é a forma prática de aplicar o encapsulamento: a classe esconde seu estado interno e só permite acesso por métodos que ela controla. Se o atributo for público, qualquer parte do programa pode colocar nele qualquer valor, inclusive valores que deixam o objeto num estado inválido, e a classe não tem como reagir. Com um setter, a classe pode validar o dado antes de aceitá-lo, registrar a alteração, disparar outras ações ou até não oferecer setter algum. Além disso, a implementação interna pode mudar no futuro sem quebrar o código que usa a classe, porque a interface pública continua a mesma.

Exemplo: numa classe Pessoa, se idade fosse público, alguém poderia fazer p.idade = -5;. Com um setter, isso é impedido:

public void setIdade(int idade) {
    if (idade < 0 || idade > 150) {
        System.out.println("Idade inválida.");
        return;
    }
    this.idade = idade;
}

Assim, o objeto nunca fica com uma idade impossível, porque toda alteração passa pela validação.



Questão 2 

Informações relevantes para um livro: título, autor, ISBN, editora, ano de publicação, edição, gênero ou área, número de exemplares totais e disponíveis, e a situação (disponível, emprestado, reservado). Dependendo do sistema, também a localização na estante.
A classe Livro é uma abstração porque representa apenas as características e comportamentos do livro real que importam para o sistema da biblioteca. Detalhes como a cor da capa, o tipo de papel ou o peso são ignorados, pois não fazem diferença para emprestar, devolver ou buscar livros. Abstrair é justamente isso: selecionar o essencial de uma entidade do mundo real para o contexto do problema.
Métodos que fazem sentido: emprestar(), que marca o livro como emprestado se estiver disponível; devolver(), que o torna disponível novamente; estaDisponivel(), que retorna se há exemplar para empréstimo; e exibirInfo(), que mostra os dados do livro. Também poderia existir reservar().






























Falta de ponto e vírgula — a linha System.out.println("Contador: " + contador) está sem ; no final. Toda instrução em Java precisa terminar com ponto e vírgula, então isso gera erro de compilação.

O código esta com um loop infinito — dentro do while, a variável contador nunca é incrementada. Como a condição é contador <= 5 e contador começa em 0 e nunca muda, o laço nunca termina — ele vai ficar imprimindo Contador: 0 para sempre.
