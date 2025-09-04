import javax.swing.*;
import java.util.Locale;

public class Algoritmo398 {
    public static void executar() {
        int[] cod = new int[10];
        int[] qtd = new int[10];
        double[] preco = new double[10];
        int n = 0;
        // Cadastro
        while (n < 10) {
            String codStr = JOptionPane.showInputDialog(null, "Código do produto (-1 encerra):");
            if (codStr == null) return;
            int c = Integer.parseInt(codStr.trim());
            if (c == -1) break;
            cod[n] = c;
            String qtdStr = JOptionPane.showInputDialog(null, "Quantidade em estoque:");
            if (qtdStr == null) return;
            qtd[n] = Integer.parseInt(qtdStr.trim());
            String precoStr = JOptionPane.showInputDialog(null, "Preço de venda:");
            if (precoStr == null) return;
            preco[n] = Double.parseDouble(precoStr.replace(',', '.'));
            n++;
        }
        double total = 0.0;
        // Vendas
        while (true) {
            String cStr = JOptionPane.showInputDialog(null, "Código do produto (0 encerra):");
            if (cStr == null) return;
            int c = Integer.parseInt(cStr.trim());
            if (c == 0) break;
            String reqStr = JOptionPane.showInputDialog(null, "Quantidade requerida:");
            if (reqStr == null) return;
            int req = Integer.parseInt(reqStr.trim());
            int idx = -1;
            for (int i = 0; i < n; i++) if (cod[i] == c) { idx = i; break; }
            if (idx == -1) {
                JOptionPane.showMessageDialog(null, "Produto Não-Cadastrado");
            } else if (qtd[idx] < req) {
                JOptionPane.showMessageDialog(null, "Estoque Insuficiente");
            } else {
                qtd[idx] -= req;
                total += req * preco[idx];
                JOptionPane.showMessageDialog(null, "Venda realizada! Subtotal do dia: " + String.format(Locale.US,"%.2f", total));
            }
        }
        // Listagem final
        Integer[] idxs = new Integer[n];
        for (int i = 0; i < n; i++) idxs[i] = i;
        java.util.Arrays.sort(idxs, (a, b) -> Integer.compare(qtd[b], qtd[a]));
        StringBuilder sb = new StringBuilder();
        sb.append("Total vendido no dia: ").append(String.format(Locale.US,"%.2f", total)).append("\n");
        sb.append("Estoque (ordem desc de quantidade):\n");
        for (int id : idxs) {
            sb.append("Cod: ").append(cod[id])
            .append(" | Qtd: ").append(qtd[id])
            .append(" | Preço: ").append(String.format(Locale.US,"%.2f", preco[id]))
            .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
