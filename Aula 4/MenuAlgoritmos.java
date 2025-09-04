import javax.swing.*;

public class MenuAlgoritmos {
    public static void main(String[] args) {
        while (true) {
            String menu = """
===== MENU PRINCIPAL =====
346 - Frase (menu de opções)
348 - Alunos com 2 notas
351 - Vetor de nomes
354 - Números pares/ímpares
356 - Alunos com médias e situação
358 - Mercadorias (lucro/empate/prejuízo)
360 - Horóscopo (ddmm, 9999 sai)
362 - Elementos comuns (10 e 20)
370 - Reservas de passagens aéreas
394 - Escola Viva (menu)
398 - Fábrica de Queijos (estoque/vendas)
400 - Hotel Fazenda (menu)
413 - Matriz 5x5 + raiz(soma dos ímpares abaixo DS)
419 - Diferença de matrizes 5x5
0   - Sair
""";
            String in = JOptionPane.showInputDialog(null, menu, "Escolha", JOptionPane.QUESTION_MESSAGE);
            if (in == null) break;
            int op;
            try { op = Integer.parseInt(in.trim()); } catch (Exception e) { op = -1; }

            switch (op) {
                case 346 -> Algoritmo346.executar();
                case 348 -> Algoritmo348.executar();
                case 351 -> Algoritmo351.executar();
                case 354 -> Algoritmo354.executar();
                case 356 -> Algoritmo356.executar();
                case 358 -> Algoritmo358.executar();
                case 360 -> Algoritmo360.executar();
                case 362 -> Algoritmo362.executar();
                case 370 -> Algoritmo370.executar();
                case 394 -> Algoritmo394.executar();
                case 398 -> Algoritmo398.executar();
                case 400 -> Algoritmo400.executar();
                case 413 -> Algoritmo413.executar();
                case 419 -> Algoritmo419.executar();
                case 0 -> { JOptionPane.showMessageDialog(null, "Encerrando..."); return; }
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}
