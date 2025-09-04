import javax.swing.*;

public class Algoritmo354 {
    public static void executar() {
        int[] num = new int[15];
        for (int i = 0; i < 15; i++) {
            String vStr = JOptionPane.showInputDialog(null, "Digite o número " + (i + 1) + ":");
            if (vStr == null) return;
            try { num[i] = Integer.parseInt(vStr.trim()); } catch (Exception e) { num[i] = 0; }
        }
        StringBuilder sb = new StringBuilder("LISTAGEM:\n");
        for (int i = 0; i < 15; i++) {
            String tipo = (num[i] % 2 == 0) ? "Par" : "Ímpar";
            sb.append((i + 1)).append(" - ").append(num[i]).append(" (").append(tipo).append(")\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
