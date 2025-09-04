import javax.swing.*;

public class Algoritmo356 {
    public static void executar() {
        String[] nomes = new String[15];
        double[][] notas = new double[15][2];
        int[] medias = new int[15];
        String[] situacao = new String[15];

        for (int i = 0; i < 15; i++) {
            nomes[i] = JOptionPane.showInputDialog(null, "Nome do aluno " + (i + 1) + ":");
            if (nomes[i] == null) return;
            String n1s = JOptionPane.showInputDialog(null, "Nota PR1 de " + nomes[i] + ":");
            if (n1s == null) return;
            String n2s = JOptionPane.showInputDialog(null, "Nota PR2 de " + nomes[i] + ":");
            if (n2s == null) return;
            double n1 = Double.parseDouble(n1s.replace(',', '.'));
            double n2 = Double.parseDouble(n2s.replace(',', '.'));
            notas[i][0] = n1;
            notas[i][1] = n2;
            medias[i] = (int)Math.round((n1 + n2) / 2.0);
            situacao[i] = (medias[i] >= 6) ? "AP" : "RP";
        }

        StringBuilder sb = new StringBuilder("NOME\tPR1\tPR2\tMÉDIA\tSITUAÇÃO\n");
        for (int i = 0; i < 15; i++) {
            sb.append(String.format("%s\t%.2f\t%.2f\t%d\t%s\n",
                nomes[i], notas[i][0], notas[i][1], medias[i], situacao[i]));
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
