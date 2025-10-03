import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraNotacoes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Calculadora de Notações ---");
            System.out.println("1. Inserir expressão Infixa");
            System.out.println("2. Inserir expressão Pós-fixa");
            System.out.println("3. Inserir expressão Pré-fixa");
            System.out.println("4. Sair");
            System.out.print("Escolha o tipo de notação de entrada: ");

            String escolha = scanner.nextLine();

            if (escolha.equals("4")) {
                System.out.println("Encerrando a calculadora.");
                break;
            }

            if (!escolha.matches("[1-3]")) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            System.out.println("\nDigite a expressão (separe números, operadores e parênteses com espaço):");
            System.out.print("> ");
            String expressao = scanner.nextLine();

            try {
                String infixa = "";
                String posfixa = "";
                String prefixa = "";

                switch (escolha) {
                    case "1": // Entrada Infixa
                        infixa = expressao;
                        posfixa = ConversorAvaliador.infixParaPostfix(infixa);
                        prefixa = ConversorAvaliador.infixParaPrefix(infixa);
                        break;
                    case "2": // Entrada Pós-fixa
                        posfixa = expressao;
                        infixa = ConversorAvaliador.postfixParaInfix(posfixa);
                        prefixa = ConversorAvaliador.infixParaPrefix(infixa);
                        break;
                    case "3": // Entrada Pré-fixa
                        prefixa = expressao;
                        infixa = ConversorAvaliador.prefixParaInfix(prefixa);
                        posfixa = ConversorAvaliador.infixParaPostfix(infixa);
                        break;
                }

                double resultado = ConversorAvaliador.avaliarPostfix(posfixa);

                System.out.println("\n--- Resultados ---");
                // Formata o resultado para exibir como inteiro se não tiver casas decimais
                if (resultado == (long) resultado) {
                    System.out.printf("Resultado do Cálculo: %d\n", (long) resultado);
                } else {
                    System.out.printf("Resultado do Cálculo: %s\n", resultado);
                }
                System.out.println("------------------");
                System.out.println("Notação Infixa:   " + infixa);
                System.out.println("Notação Pós-fixa:  " + posfixa);
                System.out.println("Notação Pré-fixa:  " + prefixa);
                System.out.println("------------------");

            } catch (Exception e) {
                System.out.println("\nErro! A expressão '" + expressao + "' parece ser inválida.");
                System.out.println("Verifique os espaços, a sintaxe e o número de operandos/operadores.");
                // e.printStackTrace(); // Descomente para depurar
            }
        }
        scanner.close();
    }
}