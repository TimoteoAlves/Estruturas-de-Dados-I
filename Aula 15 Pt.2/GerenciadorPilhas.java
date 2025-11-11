import java.util.Stack;
import java.util.Random;

public class GerenciadorPilhas {

    public static void main(String[] args) {
        Random rand = new Random();
        Stack<Integer> pilha1 = new Stack<>();
        Stack<Integer> pilha2 = new Stack<>();
        Stack<Integer> pilha3 = new Stack<>();

        // --- FASE 1: Preenchendo as Pilhas ---
        System.out.println("--- Fase 1: Preenchendo Pilhas ---");
        for (int i = 0; i < 100; i++) {
            int numSorteado = rand.nextInt(9) + 1; // Gera números de 1 a 9

            if (numSorteado <= 3) {
                pilha1.push(numSorteado);
            } else if (numSorteado <= 6) {
                pilha2.push(numSorteado);
            } else {
                pilha3.push(numSorteado);
            }
        }

        System.out.println("Pilhas Iniciais (Formato Padrão [Base -> Topo]):");
        System.out.println("Pilha 1: " + pilha1);
        System.out.println("Pilha 2: " + pilha2);
        System.out.println("Pilha 3: " + pilha3);
        System.out.println("------------------------------------");

        // --- FASE 2: Movendo Elementos ---
        System.out.println("\n--- Fase 2: Movendo Elementos ---");
        String razaoEncerramento = "100 sorteios atingidos."; // Mensagem padrão

        for (int i = 0; i < 100; i++) {
            int pilhaAlvo = rand.nextInt(3) + 1; // Gera números de 1 a 3
            int num1, num2; // Para guardar os números removidos

            System.out.printf("\nSorteio %d: Pilha Alvo = %d\n", (i + 1), pilhaAlvo);

            if (pilhaAlvo == 1) {
                // Alvo: Pilha 1 (Pega da 2 e 3)
                if (pilha2.isEmpty() || pilha3.isEmpty()) {
                    razaoEncerramento = pilha2.isEmpty() ? "Pilha 2 está vazia" : "Pilha 3 está vazia";
                    break; // Encerra o loop FOR
                }
                num1 = pilha2.pop();
                num2 = pilha3.pop();
                pilha1.push(num1);
                pilha1.push(num2);
                System.out.printf("Empilhando os números %d e %d na pilha 1\n", num1, num2);

            } else if (pilhaAlvo == 2) {
                // Alvo: Pilha 2 (Pega da 1 e 3)
                if (pilha1.isEmpty() || pilha3.isEmpty()) {
                    razaoEncerramento = pilha1.isEmpty() ? "Pilha 1 está vazia" : "Pilha 3 está vazia";
                    break; // Encerra o loop FOR
                }
                num1 = pilha1.pop();
                num2 = pilha3.pop();
                pilha2.push(num1);
                pilha2.push(num2);
                System.out.printf("Empilhando os números %d e %d na pilha 2\n", num1, num2);

            } else { // pilhaAlvo == 3
                // Alvo: Pilha 3 (Pega da 1 e 2)
                if (pilha1.isEmpty() || pilha2.isEmpty()) {
                    razaoEncerramento = pilha1.isEmpty() ? "Pilha 1 está vazia" : "Pilha 2 está vazia";
                    break; // Encerra o loop FOR
                }
                num1 = pilha1.pop();
                num2 = pilha2.pop();
                pilha3.push(num1);
                pilha3.push(num2);
                System.out.printf("Empilhando os números %d e %d na pilha 3\n", num1, num2);
            }
        }

        // --- Resultado Final ---
        System.out.println("\n------------------------------------");
        System.out.println("--- Fim do Processo ---");
        System.out.println("O programa foi encerrado porque: " + razaoEncerramento);

        System.out.println("\n--- Impressão Final (Estilo Exemplo: Topo -> Base) ---");
        imprimirPilhasVertical(pilha1, pilha2, pilha3);
    }

    /**
     * Método auxiliar para imprimir as pilhas verticalmente (Topo para Base),
     * conforme o formato visual do exemplo.
     */
    public static void imprimirPilhasVertical(Stack<Integer> p1, Stack<Integer> p2, Stack<Integer> p3) {
        // O método toArray() da Stack retorna um array [Base, ..., Topo]
        Object[] arr1 = p1.toArray();
        Object[] arr2 = p2.toArray();
        Object[] arr3 = p3.toArray();

        int maxAltura = Math.max(arr1.length, Math.max(arr2.length, arr3.length));

        System.out.println("Pilha 1:\t\tPilha 2:\t\tPilha 3:");
        System.out.println(String.format("%-16s\t%-16s\t%s", "(Topo)", "(Topo)", "(Topo)"));

        // Iteramos do fim (Topo) para o início (Base) do array
        for (int i = maxAltura - 1; i >= 0; i--) {
            String val1 = (i < arr1.length) ? arr1[i].toString() : "";
            String val2 = (i < arr2.length) ? arr2[i].toString() : "";
            String val3 = (i < arr3.length) ? arr3[i].toString() : "";

            // %-16s alinha à esquerda com 16 espaços de padding
            System.out.printf("%-16s\t%-16s\t%s\n", val1, val2, val3);
        }
    }
}