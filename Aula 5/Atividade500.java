import java.util.Arrays;
import javax.swing.JOptionPane;

public class Atividade500 {
    public static void main(String[] args) {
        int[] vetorA = new int[5];
        int[] vetorB = new int[5];

        while (true) {
            String menu = "MENU:\n" +
                        "1. Inserir dados no vetor A\n" +
                        "2. Inserir dados no vetor B\n" +
                        "3. Imprimir vetores\n" +
                        "4. Somar vetores\n" +
                        "5. Subtrair vetores\n" +
                        "6. Sair\n" +
                        "Escolha uma opção:";
            String opcaoStr = JOptionPane.showInputDialog(menu);
            int opcao = Integer.parseInt(opcaoStr);

            switch (opcao) {
                case 1:
                    preencherVetor(vetorA, "A");
                    break;
                case 2:
                    preencherVetor(vetorB, "B");
                    break;
                case 3:
                    imprimirVetores(vetorA, vetorB);
                    break;
                case 4:
                    somarVetores(vetorA, vetorB);
                    break;
                case 5:
                    subtrairVetores(vetorA, vetorB);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    public static void preencherVetor(int[] vetor, String nome) {
        for (int i = 0; i < vetor.length; i++) {
            String input = JOptionPane.showInputDialog("Digite o número " + (i + 1) + " para o vetor " + nome + ": ");
            vetor[i] = Integer.parseInt(input);
        }
    }

    public static void imprimirVetores(int[] vetorA, int[] vetorB) {
        JOptionPane.showMessageDialog(null, "Vetor A: " + Arrays.toString(vetorA) + "\nVetor B: " + Arrays.toString(vetorB));
    }

    public static void somarVetores(int[] vetorA, int[] vetorB) {
        StringBuilder resultado = new StringBuilder("Soma dos vetores: ");
        for (int i = 0; i < vetorA.length; i++) {
            resultado.append(vetorA[i] + vetorB[i]).append(" ");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public static void subtrairVetores(int[] vetorA, int[] vetorB) {
        StringBuilder resultado = new StringBuilder("Subtração dos vetores: ");
        for (int i = 0; i < vetorA.length; i++) {
            resultado.append(vetorA[i] - vetorB[i]).append(" ");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}