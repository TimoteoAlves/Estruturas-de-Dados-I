import javax.swing.*;

public class Algoritmo394 {
    public static void executar() {
        String[] nomes = new String[50];
        double[] n1 = new double[50];
        double[] n2 = new double[50];
        double[] medias = new double[50];
        boolean[] nomePreenchido = new boolean[50];
        boolean[] n1Preenchido = new boolean[50];
        boolean[] n2Preenchido = new boolean[50];
        boolean mediasCalculadas = false;
        while (true) {
            String menu = """
ESCOLA VIVA
1 - Entrar nomes
2 - Entrar 1a nota
3 - Entrar 2a nota
4 - Calcular média
5 - Listar no display
6 - Sair
opcao""";
            String opStr = JOptionPane.showInputDialog(null, menu);
            if (opStr == null) return;
            int op;
            try { op = Integer.parseInt(opStr.trim()); } catch (Exception e) { op = -1; }
            switch (op) {
                case 1 -> {
                    for (int i = 0; i < 10; i++) {
                        String nome = JOptionPane.showInputDialog(null, "Nome do aluno " + (i + 1) + ":");
                        if (nome == null) return;
                        nomes[i] = nome;
                        nomePreenchido[i] = true;
                    }
                }
                case 2 -> {
                    for (int i = 0; i < 10; i++) {
                        if (!nomePreenchido[i]) continue;
                        String n1s = JOptionPane.showInputDialog(null, "Nota 1 de " + nomes[i] + ":");
                        if (n1s == null) return;
                        n1[i] = Double.parseDouble(n1s.replace(',', '.'));
                        n1Preenchido[i] = true;
                    }
                }
                case 3 -> {
                    for (int i = 0; i < 10; i++) {
                        if (!nomePreenchido[i]) continue;
                        String n2s = JOptionPane.showInputDialog(null, "Nota 2 de " + nomes[i] + ":");
                        if (n2s == null) return;
                        n2[i] = Double.parseDouble(n2s.replace(',', '.'));
                        n2Preenchido[i] = true;
                    }
                }
                case 4 -> {
                    for (int i = 0; i < 10; i++) {
                        if (nomePreenchido[i] && n1Preenchido[i] && n2Preenchido[i]) {
                            medias[i] = (n1[i] * 3 + n2[i] * 7) / 10.0;
                        }
                    }
                    mediasCalculadas = true;
                    JOptionPane.showMessageDialog(null, "Médias calculadas!");
                }
                case 5 -> {
                    StringBuilder sb = new StringBuilder("NOME\tN1\tN2\tMÉDIA\n");
                    for (int i = 0; i < 10; i++) {
                        if (nomePreenchido[i] && n1Preenchido[i] && n2Preenchido[i] && mediasCalculadas) {
                            sb.append(String.format("%s\t%.2f\t%.2f\t%.2f\n", nomes[i], n1[i], n2[i], medias[i]));
                        }
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 6 -> { return; }
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}
