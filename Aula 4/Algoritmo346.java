import javax.swing.*;

public class Algoritmo346 {
    public static void executar() {
        String frase = JOptionPane.showInputDialog(null, "Digite uma frase:");
        if (frase == null) return;

        while (true) {
            String menu = """
                MENU 346
                1 - Imprime o comprimento da frase
                2 - Imprime os dois primeiros e os dois últimos caracteres da frase
                3 - Imprime a frase espelhada
                4 - Termina o algoritmo
                """;
            String opStr = JOptionPane.showInputDialog(null, menu + "\nOPCAO:");
            if (opStr == null) return;
            int op;
            try { op = Integer.parseInt(opStr.trim()); } catch (Exception e) { op = -1; }

            switch (op) {
                case 1 -> JOptionPane.showMessageDialog(null, "Comprimento: " + frase.length());
                case 2 -> {
                    if (frase.length() >= 2) {
                        String msg = "Dois primeiros: " + frase.substring(0, 2) +
                                "\nDois últimos: " + frase.substring(frase.length() - 2);
                        JOptionPane.showMessageDialog(null, msg);
                    } else {
                        JOptionPane.showMessageDialog(null, "Frase muito curta!");
                    }
                }
                case 3 -> JOptionPane.showMessageDialog(null, "Espelhada: " + new StringBuilder(frase).reverse());
                case 4 -> { return; }
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}
