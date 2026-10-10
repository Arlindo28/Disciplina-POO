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

------------------------------------------------------------------------------------------------------------------------------------------------------------------

Lista 3

Questão 4

a) Alocação de memória

Em Java, o array é sempre um objeto e fica no heap. A variável local (int[] v) guarda apenas uma referência para ele. A diferença está no que cada posição armazena.

Array de primitivos (int[] v = new int[5]): as posições guardam os próprios valores, um ao lado do outro, num único bloco. A JVM inicializa tudo com o valor padrão do tipo: 0 para int, 0.0 para double e false para boolean. Ao terminar o new, o array já está pronto para uso.
Array de objetos (Aluno[] a = new Aluno[5]): as posições guardam referências e começam todas como null. O new Aluno[5] não cria nenhum Aluno, apenas cinco espaços vazios. Cada objeto precisa ser criado depois (a[0] = new Aluno(...)) e fica em outro lugar do heap. Por isso a memória total é a do array de referências mais a de cada objeto apontado.

Isso também muda o efeito da cópia. Em int x = v[0], o valor é copiado. Em Aluno x = a[0], quem é copiada é a referência, então x e a[0] passam a apontar para o mesmo objeto, e qualquer alteração feita por x aparece em a[0].


b) Cuidados ao acessar elementos de um array de objetos

NullPointerException: uma posição que nunca recebeu um objeto vale null. Chamar um método nela (a[3].calcularMedia()) derruba o programa. É preciso verificar if (a[i] != null) ou controlar quantas posições estão ocupadas. A classe Turma faz isso com o contador quantidadeAlunos e só percorre até ele, não até alunos.length.

Limites do índice: acessar a[a.length] ou um índice negativo lança ArrayIndexOutOfBoundsException. Isso vale para os dois tipos de array.

Referências compartilhadas: como o array guarda referências, colocar o mesmo objeto em duas posições, ou devolver o array diretamente num getter, permite que outro código altere os objetos por fora. Quando for preciso proteger os dados, devolva uma cópia.

Comparação: use equals() para comparar o conteúdo de dois objetos. O operador == só diz se duas referências apontam para o mesmo objeto.
Tamanho fixo: o array não cresce sozinho. Se a quantidade de elementos puder variar, um ArrayList<Aluno> costuma ser mais adequado.






























Falta de ponto e vírgula — a linha System.out.println("Contador: " + contador) está sem ; no final. Toda instrução em Java precisa terminar com ponto e vírgula, então isso gera erro de compilação.

O código esta com um loop infinito — dentro do while, a variável contador nunca é incrementada. Como a condição é contador <= 5 e contador começa em 0 e nunca muda, o laço nunca termina — ele vai ficar imprimindo Contador: 0 para sempre.
