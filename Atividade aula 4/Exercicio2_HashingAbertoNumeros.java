import java.util.LinkedList;
import java.util.Scanner;

public class Exercicio2_HashingAbertoNumeros {

    private LinkedList<Integer>[] tabela;
    private final int TAMANHO = 5;

    @SuppressWarnings("unchecked")
    public Exercicio2_HashingAbertoNumeros() {
        tabela = new LinkedList[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    
    private int contarDigitos(int numero) {
    
        if (numero == 0) return 1;
        return String.valueOf(Math.abs(numero)).length();
    }

   
    private int funcaoHash(int numero) {
        int chave = contarDigitos(numero);
        return chave % TAMANHO;
    }

    
    public void adicionar(int numero) {
        int indice = funcaoHash(numero);
        tabela[indice].add(numero);
        System.out.println("Número " + numero + " (dígitos: " + contarDigitos(numero) + ") adicionado no índice " + indice);
    }

   
    public void exibirTabela() {
        System.out.println("\n--- Tabela Hash (Tamanho 5) ---");
        for (int i = 0; i < TAMANHO; i++) {
            System.out.println("Índice " + i + ": " + tabela[i]);
        }
        System.out.println("--------------------------------\n");
    }

    public static void main(String[] args) {
        Exercicio2_HashingAbertoNumeros hashing = new Exercicio2_HashingAbertoNumeros();
        Scanner scanner = new Scanner(System.in);
        String entrada;

        System.out.println("### Exercício 2: Hashing Aberto para Números ###");
        System.out.println("Digite números para adicionar. Digite 'sair' para finalizar.");

        while (true) {
            System.out.print("Digite um número: ");
            entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                int numero = Integer.parseInt(entrada);
                hashing.adicionar(numero);
                hashing.exibirTabela();
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            }
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}