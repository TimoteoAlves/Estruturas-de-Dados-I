

import java.util.Scanner;

public class Atividade480 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();
        if (ehCapicua(numero)) {
            System.out.println(numero + " é um número capicua.");
        } else {
            System.out.println(numero + " não é um número capicua.");
        }
        scanner.close();
    }

    public static boolean ehCapicua(int numero) {
        String original = Integer.toString(numero);
        String reverso = new StringBuilder(original).reverse().toString();
        return original.equals(reverso);
    }
}
