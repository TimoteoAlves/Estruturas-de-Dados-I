
import java.util.Scanner;

public class Atividade460 {
    public static int dobro(int numero) {
        return numero * 2;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o primeiro número:");
        int num1 = scanner.nextInt();
        System.out.println("O dobro de " + num1 + " é " + dobro(num1));
        
        System.out.println("Digite o segundo número:");
        int num2 = scanner.nextInt();
        System.out.println("O dobro de " + num2 + " é " + dobro(num2));
        
        System.out.println("Digite o terceiro número:");
        int num3 = scanner.nextInt();
        System.out.println("O dobro de " + num3 + " é " + dobro(num3));
        
        scanner.close();
    }
}
