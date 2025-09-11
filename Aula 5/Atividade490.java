
import java.util.Scanner;

public class Atividade490 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine();
        System.out.print("Digite o caractere a ser substituído: ");
        char caractere = scanner.next().charAt(0);

        ProcessadorTexto processador = new ProcessadorTexto(palavra, caractere);

        System.out.println("Palavra modificada: " + processador.getPalavraModificada());
        System.out.println("Total de caracteres substituídos: " + processador.getTotalSubstituidos());

        scanner.close();
    }
}

class ProcessadorTexto {
    private final String palavraOriginal;
    private final char caractereSubstituir;
    private final String palavraModificada;
    private final int totalSubstituidos;

    public ProcessadorTexto(String palavraOriginal, char caractereSubstituir) {
        this.palavraOriginal = palavraOriginal;
        this.caractereSubstituir = caractereSubstituir;
        this.palavraModificada = processarTexto();
        this.totalSubstituidos = contarSubstituicoes();
    }

    private String processarTexto() {
        StringBuilder modificada = new StringBuilder();
        for (char c : palavraOriginal.toCharArray()) {
            modificada.append(c == caractereSubstituir ? '*' : c);
        }
        return modificada.toString();
    }

    private int contarSubstituicoes() {
        return (int) palavraOriginal.chars().filter(c -> c == caractereSubstituir).count();
    }

    public String getPalavraModificada() {
        return palavraModificada;
    }

    public int getTotalSubstituidos() {
        return totalSubstituidos;
    }
}