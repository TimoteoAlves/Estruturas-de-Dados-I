import javax.swing.*;

public class Algoritmo413 {
    public static void executar() {
        int[][] M = new int[5][5];
        JOptionPane.showMessageDialog(null, "Digite os 25 valores da matriz 5x5.");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String vStr = JOptionPane.showInputDialog(null, "M[" + i + "][" + j + "]:");
                if (vStr == null) return;
                M[i][j] = Integer.parseInt(vStr.trim());
            }
        }
        StringBuilder sb = new StringBuilder("Matriz 5x5:\n");
        for (int[] row : M) {
            for (int v : row) sb.append(String.format("%4d", v));
            sb.append("\n");
        }
        double soma = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (i > j && (M[i][j] % 2 != 0)) soma += M[i][j] * M[i][j];
        double raiz = Math.sqrt(soma);
        sb.append(String.format("Raiz quadrada da soma dos quadrados dos ímpares abaixo da DS: %.2f", raiz));
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
