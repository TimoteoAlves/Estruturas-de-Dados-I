import javax.swing.*;

public class Algoritmo358 {
    public static void executar() {
        int lucro = 0, empate = 0, prejuizo = 0;
        for (int i = 0; i < 10; i++) {
            String pcStr = JOptionPane.showInputDialog(null, "Preço de compra da mercadoria " + (i + 1) + ":");
            if (pcStr == null) return;
            String pvStr = JOptionPane.showInputDialog(null, "Preço de venda da mercadoria " + (i + 1) + ":");
            if (pvStr == null) return;
            double pc = Double.parseDouble(pcStr.replace(',', '.'));
            double pv = Double.parseDouble(pvStr.replace(',', '.'));
            if (pv > pc) lucro++;
            else if (pv == pc) empate++;
            else prejuizo++;
        }
        String msg = String.format("Mercadorias com lucro: %d\nEmpate: %d\nPrejuízo: %d", lucro, empate, prejuizo);
        JOptionPane.showMessageDialog(null, msg);
    }
}
