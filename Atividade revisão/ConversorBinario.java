import java.util.Stack;
import java.util.Scanner;

public class ConversorBinario {

    static class PilhaBinaria {
        private Stack<Integer> pilha;

        public PilhaBinaria() {
            this.pilha = new Stack<>();
        }

        public void empilhar(int elemento) {
            pilha.push(elemento);
        }

        public int desempilhar() {
            return pilha.pop();
        }

        public int topo() {
            if (estaVazia()) throw new RuntimeException("Pilha Vazia");
            return pilha.peek();
        }

        public boolean estaVazia() {
            return pilha.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 2. CONVERSOR DECIMAL -> BINÁRIO ===");
        
        System.out.print("Digite um número inteiro positivo: ");
        int n = scanner.nextInt();
        
        if (n < 0) {
            System.out.println("Por favor, digite um número positivo.");
            return;
        }

        PilhaBinaria p = new PilhaBinaria();
        int tempN = n;

        // 1. Empilhar restos
        while (tempN > 0) {
            int resto = tempN % 2;
            p.empilhar(resto);
            tempN = tempN / 2;
        }

        // 2. Desempilhar e imprimir
        System.out.print("Binário: ");
        if (n == 0) {
            System.out.print("0");
        } else {
            while (!p.estaVazia()) {
                System.out.print(p.desempilhar());
            }
        }
        System.out.println();
        scanner.close();
    }
}