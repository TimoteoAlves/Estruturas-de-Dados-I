import javax.swing.*;

public class Algoritmo348 {
    public static void executar() {
        String[] nomes = new String[5];
        double[][] notas = new double[5][2];
        double[] medias = new double[5];

        for (int i = 0; i < 5; i++) {
            nomes[i] = JOptionPane.showInputDialog(null, "Nome do aluno " + (i + 1) + ":");
            if (nomes[i] == null) return;
            String n1s = JOptionPane.showInputDialog(null, "Nota 1 de " + nomes[i] + ":");
            if (n1s == null) return;
            String n2s = JOptionPane.showInputDialog(null, "Nota 2 de " + nomes[i] + ":");
            if (n2s == null) return;
            double n1 = Double.parseDouble(n1s.replace(',', '.'));
            double n2 = Double.parseDouble(n2s.replace(',', '.'));
            notas[i][0] = n1;
            notas[i][1] = n2;
            medias[i] = (n1 + n2) / 2.0;
        }

        StringBuilder sb = new StringBuilder("LISTAGEM DE ALUNOS:\n");
        for (int i = 0; i < 5; i++) {
            sb.append(String.format("%s - Nota1: %.2f | Nota2: %.2f | Média: %.2f\n",
                    nomes[i], notas[i][0], notas[i][1], medias[i]));
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
