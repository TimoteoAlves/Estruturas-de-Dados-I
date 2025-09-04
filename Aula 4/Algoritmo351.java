import javax.swing.*;

public class Algoritmo351 {
    public static void executar() {
        String[] nomes = new String[5];
        for (int i = 0; i < 5; i++) {
            nomes[i] = JOptionPane.showInputDialog(null, "Digite o nome " + (i + 1) + ":");
            if (nomes[i] == null) return;
        }
        String posStr = JOptionPane.showInputDialog(null, "Digite um número de 1 a 5:");
        if (posStr == null) return;
        int pos;
        try { pos = Integer.parseInt(posStr.trim()); } catch (Exception e) { pos = -1; }
        if (pos < 1 || pos > 5) {
            JOptionPane.showMessageDialog(null, "Número inválido!");
            return;
        }
        JOptionPane.showMessageDialog(null, "Nome: " + nomes[pos - 1]);
    }
}
