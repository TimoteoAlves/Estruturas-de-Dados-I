import javax.swing.*;

public class Algoritmo419 {
    public static void executar() {
        int[][] A = new int[5][5];
        int[][] B = new int[5][5];
        int[][] D = new int[5][5];
        JOptionPane.showMessageDialog(null, "Digite os valores da matriz A (5x5)");
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                String s = JOptionPane.showInputDialog(null, "A[" + i + "][" + j + "]:");
                if (s == null) return;
                A[i][j] = Integer.parseInt(s.trim());
            }
        JOptionPane.showMessageDialog(null, "Digite os valores da matriz B (5x5)");
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                String s = JOptionPane.showInputDialog(null, "B[" + i + "][" + j + "]:");
                if (s == null) return;
                B[i][j] = Integer.parseInt(s.trim());
            }
        StringBuilder sb = new StringBuilder("Matriz Diferença (A - B):\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                D[i][j] = A[i][j] - B[i][j];
                sb.append(String.format("%4d", D[i][j]));
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
