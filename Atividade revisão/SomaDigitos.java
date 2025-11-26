public class SomaDigitos {

    public static int somar(int n) {
        // Caso base: se n < 10, retorna o próprio n (último dígito restante)
        if (n < 10) {
            return n;
        }
        // Caso recursivo: pega o último dígito (n % 10) + soma do resto (n / 10)
        return (n % 10) + somar(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("=== 3. SOMA RECURSIVA ===");
        System.out.println("Soma de 1234: " + somar(1234)); // 1+2+3+4 = 10
        System.out.println("Soma de 907: " + somar(907));   // 9+0+7 = 16
    }
}