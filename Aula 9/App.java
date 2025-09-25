import java.util.Stack;

public class App {

    // Método para inverter as letras de uma palavra usando uma pilha
    private static String inverterPalavra(String palavra) {
        Stack<Character> pilha = new Stack<>();
        for (char letra : palavra.toCharArray()) {
            pilha.push(letra);
        }

        StringBuilder palavraInvertida = new StringBuilder();
        while (!pilha.isEmpty()) {
            palavraInvertida.append(pilha.pop());
        }

        return palavraInvertida.toString();
    }

    // Método principal para inverter as palavras de uma frase
    public static String inverterPalavrasNaFrase(String frase) {
        String[] palavras = frase.split(" "); // Divide a frase em palavras
        StringBuilder fraseInvertida = new StringBuilder();

        for (String palavra : palavras) {
            fraseInvertida.append(inverterPalavra(palavra)).append(" ");
        }

        return fraseInvertida.toString().trim(); // Remove o espaço extra no final
    }

    public static void main(String[] args) {
        // Exemplo 1
        String exemplo1 = "UM CIENTISTA DA COMPUTAÇAO E UM TECNÓLOGO EM SISTEMAS PARA INTERNET DEVEM RESOLVER OS PROBLEMAS LOGICAMENTE";
        System.out.println("Frase Original Exemplo 1:");
        System.out.println(exemplo1);
        String resultado1 = inverterPalavrasNaFrase(exemplo1);
        System.out.println("Resultado Exemplo 1:");
        System.out.println(resultado1);

        // Exemplo 2
        String exemplo2 = "ESARF :ATERCES ODALERAHCAB ME AICNEIC AD OAÇATUPMOC E O OGOLÓNCET ME SAMETSIS ARAP TENRETNI OD FI ONAIOG SUPMAC SOHNIRROM OÃS SO SEROHLEM SOSRUC ED OAÇATUPMOC OD ODATSE ED .SAIOG";
        System.out.println("\nFrase Original Exemplo 2:");
        System.out.println(exemplo2);
        String resultado2 = inverterPalavrasNaFrase(exemplo2);
        System.out.println("Resultado Exemplo 2:");
        System.out.println(resultado2);
    }
}