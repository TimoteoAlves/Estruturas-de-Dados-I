import java.util.Scanner;
import java.util.Stack; // Importa a classe de Pilha do Java

/**
 * Esta classe verifica se uma expressão matemática tem parênteses,
 * colchetes e chaves balanceados usando uma pilha dinâmica.
 */
public class VerificadorExpressoes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Verificador de Parametrização ---");
        System.out.println("Digite expressões matemáticas. Use 'sair' para terminar.");
        System.out.println("Exemplos: ((7*5)*4-(8/3)) ou { [ ( - ) ] }");
        System.out.println("----------------------------------------");

        while (true) {
            System.out.print("\nDigite a expressão: ");
            String expressao = scanner.nextLine();

            // Condição de saída
            if (expressao.equalsIgnoreCase("sair")) {
                break;
            }

            // Chama a função de verificação
            if (verificarBalanceamento(expressao)) {
                System.out.println("Resultado: CORRETO - A expressão está balanceada.");
            } else {
                System.out.println("Resultado: INCORRETO - A expressão NÃO está balanceada.");
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }

    /**
     * Função que utiliza uma Pilha para verificar se os delimitadores
     * (parênteses, colchetes, chaves) estão corretos.
     *
     * @param expressao A string da expressão a ser verificada.
     * @return true se estiver balanceada, false caso contrário.
     */
    public static boolean verificarBalanceamento(String expressao) {
        // Stack<Character> é a nossa "pilha dinâmica" de caracteres.
        // A classe Stack do java.util é dinâmica, crescendo conforme necessário.
        Stack<Character> pilha = new Stack<>();

        // Itera por cada caractere da string de expressão
        for (char c : expressao.toCharArray()) {

            // Se for um caractere de ABERTURA, empilha
            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            }
            // Se for um caractere de FECHAMENTO, verifica
            else if (c == ')' || c == ']' || c == '}') {
                
                // Caso 1: Encontrou um fechamento, mas a pilha está vazia.
                // Ex: ")(" ou "())" (no segundo ')' )
                if (pilha.isEmpty()) {
                    return false; // Incorreto, fechamento sem abertura
                }

                // Remove o topo da pilha para comparar
                char topo = pilha.pop();

                // Caso 2: O fechamento não corresponde à última abertura
                // Ex: "{ [ ( - ] } )"
                if (c == ')' && topo != '(') {
                    return false; // Fechou ')' mas esperava outro
                }
                if (c == ']' && topo != '[') {
                    return false; // Fechou ']' mas esperava outro
                }
                if (c == '}' && topo != '{') {
                    return false; // Fechou '}' mas esperava outro
                }
            }
            // Outros caracteres (números, operadores, espaços) são ignorados
        }

        // Ao final da expressão, a pilha deve estar vazia.
        // Se não estiver, é porque sobraram aberturas.
        // Ex: "((7*5)"
        return pilha.isEmpty();
    }
}