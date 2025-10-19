import java.util.concurrent.TimeUnit;

public class TorresDeHanoi {

    /**
     * Ponto de entrada principal para executar os experimentos.
     */
    public static void main(String[] args) {
        
        // --- Instâncias VIÁVEIS para gravar (rápido) ---
        runHanoiExperiment(1);
        runHanoiExperiment(10);
        runHanoiExperiment(20);
        
        // --- Instância DEMORADA (pode levar minutos) ---
        System.out.println("\nAVISO: A Instância N=30 pode levar vários minutos para executar!");
        runHanoiExperiment(30);
        
        // --- Instâncias INVIÁVEIS para executar (apenas cálculo) ---
        System.out.println("\n--- Resultados Calculados para Instâncias Inviáveis (N=40, N=41) ---");
        calculateAndPrint(40);
        calculateAndPrint(41);
    }

    /**
     * Roda um experimento completo para 'n' discos, cronometrando o tempo
     * e contando os movimentos reais da execução.
     */
    public static void runHanoiExperiment(int n) {
        System.out.println("--- Iniciando Instância: " + n + " discos ---");
        
        // 1. Calcular o número teórico de movimentos
        long moveCountCalculated = calculateMoves(n);
        
        // 2. Iniciar cronômetro
        long startTime = System.nanoTime();
        
        // 3. Executar e obter a contagem de movimentos da própria função
        long moveCounterActual = hanoiRecursiveRun(n, 'A', 'C', 'B');
        
        // 4. Parar cronômetro
        long endTime = System.nanoTime();
        
        // 5. Calcular tempo e formatar
        long elapsedNanos = endTime - startTime;
        
        System.out.println("Execução concluída.");
        System.out.println("Tempo Gasto: " + formatTime(elapsedNanos));
        
        // 6. Imprimir resultados com formatação de números
        System.out.println(String.format("Movimentos Realizados: %,d", moveCounterActual));
        System.out.println(String.format("Movimentos (Fórmula): %,d", moveCountCalculated));
        
        if (moveCounterActual == moveCountCalculated) {
            System.out.println("Verificação: SUCESSO");
        } else {
            System.out.println("Verificação: FALHA");
        }
        
        System.out.println("----------------------------------------------\n");
    }
    
    /**
     * A implementação recursiva do algoritmo de Hanói.
     * Esta versão RETORNA o número total de movimentos realizados.
     *
     * @param n           O número de discos para mover.
     * @param source      A estaca de origem.
     * @param destination A estaca de destino.
     * @param auxiliary   A estaca auxiliar.
     * @return O número total de movimentos (long).
     */
    private static long hanoiRecursiveRun(int n, char source, char destination, char auxiliary) {
        // Caso Base: Se não há discos (n=0), não fazemos movimentos.
        if (n == 0) {
            return 0;
        }

        long moves = 0;
        
        // 1. Move n-1 discos da origem (A) para o auxiliar (B)
        moves += hanoiRecursiveRun(n - 1, source, auxiliary, destination);
        
        // 2. Move o disco n (maior) da origem (A) para o destino (C)
        moves += 1; // Conta este movimento
        
        // 3. Move n-1 discos do auxiliar (B) para o destino (C)
        moves += hanoiRecursiveRun(n - 1, auxiliary, destination, source);
        
        // Retorna o total de movimentos da chamada
        return moves;
    }

    /**
     * Calcula o número de movimentos usando a fórmula 2^n - 1.
     * (1L << n) é uma forma rápida (bitwise) de calcular 2^n.
     */
    private static long calculateMoves(int n) {
        return (1L << n) - 1;
    }

    /**
     * Helper para imprimir os resultados APENAS CALCULADOS (para N=40, N=41).
     */
    private static void calculateAndPrint(int n) {
        System.out.println("--- Instância: " + n + " discos ---");
        long moves = calculateMoves(n);
        System.out.println("Tempo Gasto: N/A (Execução real inviável)");
        System.out.println(String.format("Movimentos (Calculado): %,d", moves));
        System.out.println("----------------------------------------------");
    }

    /**
     * Converte um tempo em nanossegundos para o formato HH:MM:SS:cs
     * (onde 'cs' são centésimos de segundo, para bater com o 'mm'
     * da solicitação original).
     */
    private static String formatTime(long nanos) {
        if (nanos < 0) nanos = 0;
        
        // Converte nanos para centésimos de segundo
        long totalCentiseconds = nanos / 10_000_000;
        long cs = totalCentiseconds % 100; // Centésimos de segundo (0-99)
        
        long totalSeconds = totalCentiseconds / 100;
        long ss = totalSeconds % 60; // Segundos
        
        long totalMinutes = totalSeconds / 60;
        long mm = totalMinutes % 60; // Minutos
        
        long hh = totalMinutes / 60; // Horas
        
        // Formata como HH:MM:SS:CS (o CS tem 2 dígitos)
        return String.format("%02d:%02d:%02d:%02d", hh, mm, ss, cs);
    }
}