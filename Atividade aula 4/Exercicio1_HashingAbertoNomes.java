import java.util.LinkedList;
import java.util.Scanner;

public class Exercicio1_HashingAbertoNomes {

    
    private LinkedList<String>[] tabela;
    private final int TAMANHO = 10;

    // Construtor
    @SuppressWarnings("unchecked")
    public Exercicio1_HashingAbertoNomes() {
        tabela = new LinkedList[TAMANHO];
        
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new LinkedList<>();
        }
    }


    private int funcaoHash(String nome) {
        return nome.length() % TAMANHO;
    }


    public void adicionar(String nome) {
        int indice = funcaoHash(nome);
        tabela[indice].add(nome); // Adiciona o nome na lista daquele índice
        System.out.println("'" + nome + "' adicionado no índice " + indice);
    }

    public void exibirTabela() {
        System.out.println("\n--- Tabela Hash ---");
        for (int i = 0; i < TAMANHO; i++) {
            System.out.print("Índice " + i + ": ");
            if (tabela[i].isEmpty()) {
                System.out.println("[]");
            } else {
                System.out.println(tabela[i]);
            }
        }
        System.out.println("-------------------\n");
    }

    public static void main(String[] args) {
        Exercicio1_HashingAbertoNomes hashing = new Exercicio1_HashingAbertoNomes();
        Scanner scanner = new Scanner(System.in);
        String entrada;

        System.out.println("### Exercício 1: Hashing Aberto para Nomes ###");
        System.out.println("Digite nomes para adicionar à tabela. Digite 'sair' para finalizar.");

        while (true) {
            System.out.print("Digite um nome: ");
            entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            hashing.adicionar(entrada);
            hashing.exibirTabela();
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}