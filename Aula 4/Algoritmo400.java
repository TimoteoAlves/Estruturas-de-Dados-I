import javax.swing.*;

public class Algoritmo400 {
    enum Status { ALUGADO, LIVRE, RESERVADO }
    static class Quarto {
        int numero;
        int leitos;
        double precoDiaria;
        Status status = Status.LIVRE;
        String entrada = "-";
        String saida = "-";
        int diarias = 0;
        double despesasExtras = 0.0;
        boolean cadastrado = false;
    }
    public static void executar() {
        Quarto[] quartos = new Quarto[5];
        for (int i = 0; i < 5; i++) { quartos[i] = new Quarto(); quartos[i].numero = i + 1; }
        while (true) {
            String menu = """
                    Hotel-Fazenda Sucesso
                    1. Cadastra quartos
                    2. Lista todos os quartos
                    3. Lista quartos ocupados (alugados/reservados)
                    4. Aluguel/reserva de quarto
                    5. Entrar despesas extras
                    6. Calcula despesa do quarto
                    7. Sair
                    """;
            String opStr = JOptionPane.showInputDialog(null, menu);
            if (opStr == null) return;
            int op;
            try { op = Integer.parseInt(opStr.trim()); } catch (Exception e) { op = -1; }
            switch (op) {
                case 1 -> {
                    for (int i = 0; i < 5; i++) {
                        String ok = JOptionPane.showInputDialog(null, "Cadastrar/editar quarto " + (i + 1) + "? (S/N)");
                        if (ok == null) return;
                        if (!ok.trim().equalsIgnoreCase("S")) continue;
                        String leitosStr = JOptionPane.showInputDialog(null, "Nº de leitos do quarto " + (i + 1) + ":");
                        if (leitosStr == null) return;
                        int leitos = Integer.parseInt(leitosStr.trim());
                        String precoStr = JOptionPane.showInputDialog(null, "Preço da diária do quarto " + (i + 1) + ":");
                        if (precoStr == null) return;
                        double preco = Double.parseDouble(precoStr.replace(',', '.'));
                        quartos[i].leitos = Math.max(0, leitos);
                        quartos[i].precoDiaria = Math.max(0, preco);
                        quartos[i].cadastrado = true;
                    }
                }
                case 2 -> {
                    StringBuilder sb = new StringBuilder("QUARTOS:\n");
                    for (Quarto q : quartos) {
                        sb.append(String.format(
                                "#%02d | Cad:%s | Leitos:%d | Diária:%.2f | Status:%s | Ent:%s | Sai:%s | Diárias:%d | Extras:%.2f\n",
                                q.numero, q.cadastrado ? "Sim" : "Não", q.leitos, q.precoDiaria, q.status,
                                q.entrada, q.saida, q.diarias, q.despesasExtras));
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 3 -> {
                    StringBuilder sb = new StringBuilder("OCUPADOS (Alugado/Reservado):\n");
                    for (Quarto q : quartos) {
                        if (q.status != Status.LIVRE) {
                            sb.append(String.format(
                                    "#%02d | %s | Diária:%.2f | Ent:%s | Sai:%s | Diárias:%d | Extras:%.2f\n",
                                    q.numero, q.status, q.precoDiaria, q.entrada, q.saida, q.diarias, q.despesasExtras));
                        }
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
                case 4 -> {
                    String numStr = JOptionPane.showInputDialog(null, "Número do quarto (1-5):");
                    if (numStr == null) return;
                    int num = Integer.parseInt(numStr.trim());
                    if (num < 1 || num > 5) { JOptionPane.showMessageDialog(null, "Número inválido!"); break; }
                    Quarto q = quartos[num - 1];
                    if (!q.cadastrado) { JOptionPane.showMessageDialog(null, "Quarto não cadastrado."); break; }
                    if (q.status == Status.LIVRE) {
                        String tipo = JOptionPane.showInputDialog(null, "Digite 'A' para Alugar ou 'R' para Reservar:");
                        if (tipo == null) return;
                        if (!(tipo.equalsIgnoreCase("A") || tipo.equalsIgnoreCase("R"))) { JOptionPane.showMessageDialog(null, "Opção inválida."); break; }
                        String ent = JOptionPane.showInputDialog(null, "Data de entrada (livre):");
                        if (ent == null) return;
                        String sai = JOptionPane.showInputDialog(null, "Data de saída (livre):");
                        if (sai == null) return;
                        String diStr = JOptionPane.showInputDialog(null, "Número de diárias:");
                        if (diStr == null) return;
                        int di = Integer.parseInt(diStr.trim());
                        q.entrada = ent; q.saida = sai; q.diarias = Math.max(0, di);
                        q.status = tipo.equalsIgnoreCase("A") ? Status.ALUGADO : Status.RESERVADO;
                        JOptionPane.showMessageDialog(null, "Quarto " + q.numero + " marcado como " + q.status);
                    } else if (q.status == Status.RESERVADO) {
                        String conf = JOptionPane.showInputDialog(null, "Quarto reservado. Converter em ALUGADO? (S/N)");
                        if (conf == null) return;
                        if (conf.equalsIgnoreCase("S")) {
                            q.status = Status.ALUGADO;
                            JOptionPane.showMessageDialog(null, "Reserva convertida em aluguel.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Mantido como reservado.");
                        }
                    } else {
                        String sair = JOptionPane.showInputDialog(null, "Quarto ALUGADO. Deseja finalizar e liberar? (S/N)");
                        if (sair == null) return;
                        if (sair.equalsIgnoreCase("S")) {
                            q.status = Status.LIVRE;
                            q.entrada = "-"; q.saida = "-"; q.diarias = 0; q.despesasExtras = 0.0;
                            JOptionPane.showMessageDialog(null, "Quarto liberado.");
                        }
                    }
                }
                case 5 -> {
                    String numStr = JOptionPane.showInputDialog(null, "Número do quarto (1-5):");
                    if (numStr == null) return;
                    int num = Integer.parseInt(numStr.trim());
                    if (num < 1 || num > 5) { JOptionPane.showMessageDialog(null, "Número inválido!"); break; }
                    Quarto q = quartos[num - 1];
                    if (!q.cadastrado) { JOptionPane.showMessageDialog(null, "Quarto não cadastrado."); break; }
                    String vStr = JOptionPane.showInputDialog(null, "Valor da despesa extra a adicionar:");
                    if (vStr == null) return;
                    double v = Double.parseDouble(vStr.replace(',', '.'));
                    q.despesasExtras += Math.max(0, v);
                    JOptionPane.showMessageDialog(null, "Extras atualizados. Total extras: " + String.format(java.util.Locale.US,"%.2f", q.despesasExtras));
                }
                case 6 -> {
                    String numStr = JOptionPane.showInputDialog(null, "Número do quarto (1-5):");
                    if (numStr == null) return;
                    int num = Integer.parseInt(numStr.trim());
                    if (num < 1 || num > 5) { JOptionPane.showMessageDialog(null, "Número inválido!"); break; }
                    Quarto q = quartos[num - 1];
                    if (!q.cadastrado) { JOptionPane.showMessageDialog(null, "Quarto não cadastrado."); break; }
                    double valor = q.diarias * q.precoDiaria + q.despesasExtras;
                    JOptionPane.showMessageDialog(null, String.format(java.util.Locale.US,
                            "Quarto #%02d\nStatus: %s\nDiárias: %d x %.2f = %.2f\nExtras: %.2f\nTOTAL: %.2f",
                            q.numero, q.status, q.diarias, q.precoDiaria, q.diarias * q.precoDiaria,
                            q.despesasExtras, valor));
                }
                case 7 -> { return; }
                default -> {}
            }
        }
    }
}
