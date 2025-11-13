import java.util.Scanner;
import java.util.Deque; // Interface
import java.util.ArrayDeque; // Implementação

public class VerificadorPalindromo {

    /**
     * Verifica se uma string (palavra, número, data ou frase) é um palíndromo
     * usando um Deque.
     *
     * A função normaliza a entrada para ignorar maiúsculas/minúsculas,
     * espaços e pontuação.
     * * @param entrada A string bruta inserida pelo usuário.
     * @return true se for um palíndromo, false caso contrário.
     */
    public static boolean ehPalindromo(String entrada) {
        
        // 1. Normalização da Entrada
        // Converte para minúsculas e remove tudo que não for letra ou número (a-z, 0-9)
        // Isso trata espaços, pontuação, barras (/), hífens (-), etc.
        String normalizada = entrada.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Se após a filtragem não sobrar nada (ex: "!!") 
        // ou tiver apenas 1 char, consideramos um palíndromo.
        if (normalizada.length() <= 1) {
            return true;
        }

        // 2. Popular o Deque
        // Usamos ArrayDeque, uma implementação eficiente da interface Deque
        Deque<Character> dequeVerificador = new ArrayDeque<>();
        
        // Adiciona todos os caracteres da string normalizada no final do deque
        for (char c : normalizada.toCharArray()) {
            dequeVerificador.addLast(c);
        }

        // 3. Verificar as Extremidades
        // Continuamos enquanto houver pelo menos 2 caracteres no deque para comparar
        while (dequeVerificador.size() > 1) {
            
            // Remove o primeiro item (da frente)
            char primeiro = dequeVerificador.removeFirst();
            
            // Remove o último item (de trás)
            char ultimo = dequeVerificador.removeLast();

            // 4. Comparação
            if (primeiro != ultimo) {
                return false; // Encontrou uma diferença, não é palíndromo
            }
        }

        // 5. Resultado
        // Se o loop terminar (deque ficou vazio ou com 1 item), é um palíndromo
        return true;
    }

    /**
     * Método principal (main) para executar a aplicação de console.
     */
    public static void main(String[] args) {
        // Usamos try-with-resources para fechar o scanner automaticamente
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("--- Verificador de Palíndromos (com DEQUE) ---");
            System.out.println("Verifica palavras, números, datas e frases.");
            System.out.println("Digite 'sair' a qualquer momento para terminar.");
            System.out.println("----------------------------------------------");

            while (true) {
                System.out.print("\nDigite a sua entrada: ");
                String entradaUsuario = scanner.nextLine();

                if (entradaUsuario.equalsIgnoreCase("sair")) {
                    System.out.println("Até logo!");
                    break;
                }
                
                if (entradaUsuario.isEmpty()) {
                    System.out.println("Por favor, digite algo.");
                    continue;
                }

                // Chama a função principal de verificação
                if (ehPalindromo(entradaUsuario)) {
                    System.out.println("✅ É UM PALÍNDROMO!");
                    System.out.println("(Leitura normal: '" + entradaUsuario + "')");
                } else {
                    System.out.println("❌ NÃO é um palíndromo.");
                }
            }
            
        } // O scanner é fechado aqui
    }
}