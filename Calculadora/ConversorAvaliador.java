import java.util.*;

public class ConversorAvaliador {

    /**
     * Retorna a precedência de um operador matemático.
     * Maior número significa maior precedência.
     */
    private static int getPrecedencia(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return -1; // Para outros caracteres como parênteses
    }

    /**
     * Verifica se um token é um operador.
     */
    private static boolean isOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    /**
     * Converte uma expressão Infixa para Pós-fixa usando o algoritmo Shunting-yard.
     */
    public static String infixParaPostfix(String expressao) {
        StringBuilder resultado = new StringBuilder();
        // Deque (Double-Ended Queue) é a implementação moderna de Pilha em Java
        Deque<String> pilha = new ArrayDeque<>();
        String[] tokens = expressao.split("\\s+");

        for (String token : tokens) {
            // Se for um número, adiciona ao resultado
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                resultado.append(token).append(" ");
            }
            // Se for '(' empilha
            else if (token.equals("(")) {
                pilha.push(token);
            }
            // Se for ')' desempilha até encontrar '('
            else if (token.equals(")")) {
                while (!pilha.isEmpty() && !pilha.peek().equals("(")) {
                    resultado.append(pilha.pop()).append(" ");
                }
                pilha.pop(); // Remove o '(' da pilha
            }
            // Se for um operador
            else if (isOperador(token)) {
                while (!pilha.isEmpty() && getPrecedencia(token) <= getPrecedencia(pilha.peek())) {
                    resultado.append(pilha.pop()).append(" ");
                }
                pilha.push(token);
            }
        }

        // Desempilha todos os operadores restantes
        while (!pilha.isEmpty()) {
            resultado.append(pilha.pop()).append(" ");
        }

        return resultado.toString().trim();
    }

    /**
     * Converte uma expressão Infixa para Pré-fixa.
     * A lógica é: inverter a expressão, trocar '()' e converter para pós-fixa,
     * e então inverter o resultado final.
     */
    public static String infixParaPrefix(String expressao) {
        // 1. Inverter a lista de tokens
        List<String> tokens = new ArrayList<>(Arrays.asList(expressao.split("\\s+")));
        Collections.reverse(tokens);

        // 2. Trocar parênteses
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals("(")) {
                tokens.set(i, ")");
            } else if (tokens.get(i).equals(")")) {
                tokens.set(i, "(");
            }
        }

        // 3. Converter a expressão invertida para pós-fixa
        String expressaoInvertida = String.join(" ", tokens);
        String postfixInvertido = infixParaPostfix(expressaoInvertida);

        // 4. Inverter o resultado para obter o prefixo
        List<String> prefixTokens = new ArrayList<>(Arrays.asList(postfixInvertido.split("\\s+")));
        Collections.reverse(prefixTokens);

        return String.join(" ", prefixTokens);
    }
    
    /**
     * Converte uma expressão Pós-fixa para Infixa.
     */
    public static String postfixParaInfix(String expressao) {
        Deque<String> pilha = new ArrayDeque<>();
        String[] tokens = expressao.split("\\s+");

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                pilha.push(token);
            } else if (isOperador(token)) {
                String operando2 = pilha.pop();
                String operando1 = pilha.pop();
                pilha.push("( " + operando1 + " " + token + " " + operando2 + " )");
            }
        }
        return pilha.pop();
    }

    /**
     * Converte uma expressão Pré-fixa para Infixa.
     */
    public static String prefixParaInfix(String expressao) {
        Deque<String> pilha = new ArrayDeque<>();
        List<String> tokens = new ArrayList<>(Arrays.asList(expressao.split("\\s+")));
        Collections.reverse(tokens);

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                pilha.push(token);
            } else if (isOperador(token)) {
                String operando1 = pilha.pop();
                String operando2 = pilha.pop();
                pilha.push("( " + operando1 + " " + token + " " + operando2 + " )");
            }
        }
        return pilha.pop();
    }


    /**
     * Avalia (calcula) uma expressão Pós-fixa e retorna o resultado.
     */
    public static double avaliarPostfix(String expressao) {
        Deque<Double> pilha = new ArrayDeque<>();
        String[] tokens = expressao.split("\\s+");

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                pilha.push(Double.parseDouble(token));
            } else if (isOperador(token)) {
                double operando2 = pilha.pop();
                double operando1 = pilha.pop();
                switch (token) {
                    case "+":
                        pilha.push(operando1 + operando2);
                        break;
                    case "-":
                        pilha.push(operando1 - operando2);
                        break;
                    case "*":
                        pilha.push(operando1 * operando2);
                        break;
                    case "/":
                        if (operando2 == 0) throw new ArithmeticException("Erro: Divisão por zero!");
                        pilha.push(operando1 / operando2);
                        break;
                }
            }
        }
        return pilha.pop();
    }
}