import java.util.Arrays;
import java.util.Scanner;

public class Exercicio4_HashingFechadoNumeros {

    private Integer[] tabela; 
    private final int TAMANHO = 10;
    private final int MAX_TENTATIVAS = 5;

    public Exercicio4_HashingFechadoNumeros() {
        tabela = new Integer[TAMANHO];
        
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
        int indiceOriginal = funcaoHash(numero);
        System.out.println("Número " + numero + " (dígitos: " + contarDigitos(numero) + ") -> Índice inicial: " + indiceOriginal);

        for (int i = 0; i <= MAX_TENTATIVAS; i++) {
            int indiceAtual = (indiceOriginal + i) % TAMANHO; 

            System.out.println("  Tentativa " + (i + 1) + ": Verificando índice " + indiceAtual);

            
            if (tabela[indiceAtual] == null) {
                tabela[indiceAtual] = numero;
                System.out.println("  >> Número " + numero + " inserido com sucesso no índice " + indiceAtual);
                return; 
            }
        }

        System.out.println("  !! ESTOURO! Não foi possível inserir o número " + numero + " após " + (MAX_TENTATIVAS + 1) + " tentativas.");
    }

    public void exibirTabela() {
        System.out.println("\n--- Tabela Hash (Hashing Fechado) ---");
        System.out.println(Arrays.toString(tabela));
        System.out.println("-------------------------------------\n");
    }

    public static void main(String[] args) {
        Exercicio4_HashingFechadoNumeros hashing = new Exercicio4_HashingFechadoNumeros();
        Scanner scanner = new Scanner(System.in);
        String entrada;

        System.out.println("### Exercício 4: Hashing Fechado com Sondagem Linear ###");
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