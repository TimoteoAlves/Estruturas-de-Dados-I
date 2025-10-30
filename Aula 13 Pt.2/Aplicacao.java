// Aplicacao.java
public class Aplicacao {

    public static void main(String[] args) {
        final int TAMANHO = 1000;
        final int MIN = -9999;
        final int MAX = 9999;

        // 1. Criar e preencher o vetor com 1000 números aleatórios
        int[] vetor = new int[TAMANHO];
        System.out.println("--- Vetor Original (Ordem de Geração) ---");
        for (int i = 0; i < TAMANHO; i++) {
            // Gera um número no intervalo [MIN, MAX]
            // Math.random() retorna [0.0, 1.0)
            // (MAX - MIN + 1) é o tamanho do intervalo
            int range = (MAX - MIN) + 1;
            vetor[i] = (int) (Math.random() * range) + MIN;
        }

        // 2. Imprimir o vetor na ordem de geração
        printArray(vetor);

        // 3. Criar lista duplamente encadeada e inserir os números ordenadamente
        DoublyLinkedList lista = new DoublyLinkedList();
        for (int i = 0; i < TAMANHO; i++) {
            lista.insertSorted(vetor[i]);
        }

        // 4. Imprimir lista em ordem crescente
        System.out.println("\n--- Lista em Ordem Crescente ---");
        lista.printAscending();

        // 5. Imprimir lista em ordem decrescente
        System.out.println("\n--- Lista em Ordem Decrescente ---");
        lista.printDescending();

        // 6. Remover todos os números primos da lista
        lista.removePrimes();

        // 7. Imprimir a lista novamente
        System.out.println("\n--- Lista Após Remoção de Primos (Ordem Crescente) ---");
        lista.printAscending();
    }

    /**
     * Função auxiliar para imprimir o conteúdo de um vetor.
     * @param arr O vetor a ser impresso.
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            // Adiciona uma quebra de linha a cada 20 números para legibilidade
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println(); // Nova linha no final
    }
}