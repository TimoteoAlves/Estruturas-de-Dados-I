import javax.swing.*;

public class Algoritmo370 {
    public static void executar() {
        String nVoosStr = JOptionPane.showInputDialog(null, "Digite o número de voos:");
        if (nVoosStr == null) return;
        int nVoos = Integer.parseInt(nVoosStr.trim());
        int[] lugares = new int[nVoos];
        int[] voos = new int[nVoos];
        for (int i = 0; i < nVoos; i++) {
            String numVooStr = JOptionPane.showInputDialog(null, "Número do voo " + (i + 1) + ":");
            if (numVooStr == null) return;
            voos[i] = Integer.parseInt(numVooStr.trim());
            String lugaresStr = JOptionPane.showInputDialog(null, "Quantidade de lugares disponíveis no voo " + voos[i] + ":");
            if (lugaresStr == null) return;
            lugares[i] = Integer.parseInt(lugaresStr.trim());
        }
        while (true) {
            String idStr = JOptionPane.showInputDialog(null, "Digite o número da identidade do cliente (ou vazio para sair):");
            if (idStr == null || idStr.trim().isEmpty()) break;
            String vooStr = JOptionPane.showInputDialog(null, "Digite o número do voo desejado:");
            if (vooStr == null) break;
            int vooDesejado = Integer.parseInt(vooStr.trim());
            int idx = -1;
            for (int i = 0; i < nVoos; i++) if (voos[i] == vooDesejado) { idx = i; break; }
            if (idx == -1) {
                JOptionPane.showMessageDialog(null, "Voo não encontrado!");
                continue;
            }
            if (lugares[idx] > 0) {
                lugares[idx]--;
                JOptionPane.showMessageDialog(null, "Reserva confirmada! Cliente: " + idStr + ", Voo: " + vooDesejado);
            } else {
                JOptionPane.showMessageDialog(null, "Não há lugares disponíveis neste voo.");
            }
        }
    }
}
