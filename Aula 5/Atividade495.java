
import java.util.Arrays;
import java.util.Scanner;

public class Atividade495 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vetor = new int[10];

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            vetor[i] = scanner.nextInt();
        }

        Arrays.sort(vetor);
        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));

        System.out.print("Digite o número a ser buscado: ");
        int chave = scanner.nextInt();
        int posicao = buscaBinaria(vetor, chave);

        if (posicao >= 0) {
            System.out.println("Posição no vetor: " + posicao);
        } else {
            System.out.println("Número não encontrado no vetor.");
        }
        scanner.close();
    }

    public static int buscaBinaria(int[] vetor, int chave) {
        int inicio = 0, fim = vetor.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == chave) {
                return meio;
            } else if (vetor[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
}