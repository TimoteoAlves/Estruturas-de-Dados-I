import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class Algoritmo362 {
    public static void executar() {
        int[] a = new int[10];
        int[] b = new int[20];
        for (int i = 0; i < 10; i++) {
            String s = JOptionPane.showInputDialog(null, "Digite o elemento " + (i + 1) + " do conjunto A:");
            if (s == null) return;
            a[i] = Integer.parseInt(s.trim());
        }
        for (int i = 0; i < 20; i++) {
            String s = JOptionPane.showInputDialog(null, "Digite o elemento " + (i + 1) + " do conjunto B:");
            if (s == null) return;
            b[i] = Integer.parseInt(s.trim());
        }
        Set<Integer> comuns = new HashSet<>();
        for (int x : a) {
            for (int y : b) {
                if (x == y) comuns.add(x);
            }
        }
        StringBuilder sb = new StringBuilder("Elementos comuns (sem repetição):\n");
        for (int x : comuns) sb.append(x).append(" ");
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
