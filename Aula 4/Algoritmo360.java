import javax.swing.*;

public class Algoritmo360 {
    public static void executar() {
        String[] signos = {"Capricórnio", "Aquário", "Peixes", "Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem", "Libra", "Escorpião", "Sagitário"};
        int[] ultimosDias = {20, 19, 20, 20, 20, 20, 21, 22, 22, 22, 21, 21};
        while (true) {
            String dataStr = JOptionPane.showInputDialog(null, "Digite a data de nascimento (ddmm) ou 9999 para sair:");
            if (dataStr == null) return;
            if (dataStr.trim().equals("9999")) break;
            if (dataStr.length() != 4) {
                JOptionPane.showMessageDialog(null, "Data inválida!");
                continue;
            }
            int dia = Integer.parseInt(dataStr.substring(0, 2));
            int mes = Integer.parseInt(dataStr.substring(2, 4));
            if (mes < 1 || mes > 12) {
                JOptionPane.showMessageDialog(null, "Mês inválido!");
                continue;
            }
            String signo;
            if (dia <= ultimosDias[mes - 1]) signo = signos[mes - 1];
            else signo = signos[mes % 12];
            JOptionPane.showMessageDialog(null, "Signo: " + signo);
        }
    }
}
