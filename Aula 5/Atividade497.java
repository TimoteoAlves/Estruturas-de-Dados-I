import javax.swing.JOptionPane;

public class Atividade497 {
    public static void main(String[] args) {
        while (true) {
            // Menu de operações
            String menu = "Escolha uma operação:\n"
                        + "1. Soma\n"
                        + "2. Subtração\n"
                        + "3. Multiplicação\n"
                        + "4. Divisão\n"
                        + "5. Média\n"
                        + "6. Potência\n"
                        + "7. Raiz Quadrada\n"
                        + "8. Módulo\n"
                        + "0. Sair";
            String escolha = JOptionPane.showInputDialog(menu);
            
            if (escolha == null || escolha.equals("0")) break; // Se o usuário cancelar ou escolher sair, encerra o programa
            
            double num1, num2, resultado;
            
            switch (escolha) {
                case "1":
                    num1 = getNumero("Digite o primeiro número:");
                    num2 = getNumero("Digite o segundo número:");
                    resultado = num1 + num2;
                    mostrarResultado("Resultado da Soma: " + resultado);
                    break;

                case "2":
                    num1 = getNumero("Digite o primeiro número:");
                    num2 = getNumero("Digite o segundo número:");
                    resultado = num1 - num2;
                    mostrarResultado("Resultado da Subtração: " + resultado);
                    break;

                case "3":
                    num1 = getNumero("Digite o primeiro número:");
                    num2 = getNumero("Digite o segundo número:");
                    resultado = num1 * num2;
                    mostrarResultado("Resultado da Multiplicação: " + resultado);
                    break;

                case "4":
                    num1 = getNumero("Digite o primeiro número:");
                    num2 = getNumero("Digite o segundo número:");
                    if (num2 != 0) {
                        resultado = num1 / num2;
                        mostrarResultado("Resultado da Divisão: " + resultado);
                    } else {
                        mostrarResultado("Erro: Divisão por zero não é permitida.");
                    }
                    break;

                case "5":
                    num1 = getNumero("Digite o primeiro número:");
                    num2 = getNumero("Digite o segundo número:");
                    resultado = (num1 + num2) / 2;
                    mostrarResultado("Resultado da Média: " + resultado);
                    break;

                case "6":
                    num1 = getNumero("Digite a base:");
                    num2 = getNumero("Digite o expoente:");
                    resultado = Math.pow(num1, num2);
                    mostrarResultado("Resultado da Potência: " + resultado);
                    break;

                case "7":
                    num1 = getNumero("Digite o número:");
                    if (num1 >= 0) {
                        resultado = Math.sqrt(num1);
                        mostrarResultado("Resultado da Raiz Quadrada: " + resultado);
                    } else {
                        mostrarResultado("Erro: Não é possível calcular a raiz quadrada de um número negativo.");
                    }
                    break;

                case "8":
                    num1 = getNumero("Digite o primeiro número:");
                    num2 = getNumero("Digite o segundo número:");
                    if (num2 != 0) {
                        resultado = num1 % num2;
                        mostrarResultado("Resultado do Módulo: " + resultado);
                    } else {
                        mostrarResultado("Erro: Divisão por zero não é permitida.");
                    }
                    break;

                default:
                    mostrarResultado("Operação não reconhecida.");
                    break;
            }
        }
    }

    private static double getNumero(String mensagem) {
        String input = JOptionPane.showInputDialog(mensagem);
        return Double.parseDouble(input);
    }

    private static void mostrarResultado(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
