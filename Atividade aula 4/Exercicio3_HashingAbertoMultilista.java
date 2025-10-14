import java.util.LinkedList;
import java.util.Scanner;

public class Exercicio3_HashingAbertoMultilista {

    private LinkedList<Integer>[] tabela;
    private final int TAMANHO; // Tamanho definido pelo usuário

    @SuppressWarnings("unchecked")
    public Exercicio3_HashingAbertoMultilista(int tamanho) {
        if (tamanho <= 0) {
            throw new IllegalArgumentException("Tamanho da tabela deve ser positivo.");
        }
        this.TAMANHO = tamanho;
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
        System.out.println("\n--- Tabela Hash (Tamanho " + TAMANHO + ") ---");
        for (int i = 0; i < TAMANHO; i++) {
            System.out.println("Índice " + i + ": " + tabela[i]);
        }
        System.out.println("-------------------------------------\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("### Exercício 3: Hashing Aberto com Tamanho Dinâmico ###");
        System.out.print("Primeiro, defina o tamanho da tabela hash: ");
        int tamanhoTabela = scanner.nextInt();
        scanner.nextLine(); // nova linha

        Exercicio3_HashingAbertoMultilista hashing = new Exercicio3_HashingAbertoMultilista(tamanhoTabela);
        String entrada;

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
                System.out.println("Entrada inválida.");
            }
        }
        System.out.println("Programa finalizado.");
        scanner.close();
    }
}