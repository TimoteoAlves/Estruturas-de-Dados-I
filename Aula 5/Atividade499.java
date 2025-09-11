import java.util.Arrays;
import javax.swing.JOptionPane;

public class Atividade499 {
    public static void main(String[] args) {
        int[] vetor = new int[5];
        boolean flag = false;

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = 0;
        }

        while (true) {
            String menu = "\n\n\nMENU VETOR - FUNCAO\n1. Dados do VETOR\n2. Ordena VETOR\n3. Imprime VETOR\n4. Sai do programa\nOPCAO:";
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    entrada(vetor);
                    flag = true;
                    break;
                case 2:
                    if (flag) {
                        ordena(vetor);
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro opcao 1");
                    }
                    break;
                case 3:
                    if (flag) {
                        imprime(vetor);
                    } else {
                        JOptionPane.showMessageDialog(null, "Escolha primeiro opcao 1");
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo do Algoritmo");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    public static void entrada(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número " + (i + 1) + ":"));
        }
    }

    public static void ordena(int[] vetor) {
        Arrays.sort(vetor);
        JOptionPane.showMessageDialog(null, "Vetor ordenado com sucesso!");
    }

    public static void imprime(int[] vetor) {
        JOptionPane.showMessageDialog(null, "Vetor: " + Arrays.toString(vetor));
    }
}