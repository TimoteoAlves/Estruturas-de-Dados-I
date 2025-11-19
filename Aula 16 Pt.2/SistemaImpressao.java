import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

public class SistemaImpressao {
    
    // O LinkedList implementa a interface Deque, sendo ideal para esta funcionalidade.
    private final Deque<Documento> fila;
    private final Set<Integer> idsEmUso;
    private final List<String> tiposPermitidos;
    private final Random random;

    public SistemaImpressao() {
        this.fila = new LinkedList<>();
        this.idsEmUso = new HashSet<>();
        this.tiposPermitidos = Arrays.asList("PDF", "TXT", "JPG", "PNG", "DOCX", "XLSX");
        this.random = new Random();
    }

    /**
     * Fabrica um documento com ID único, tipo e número de páginas aleatórios (1 a 100).
     * @return Um novo objeto Documento.
     */
    public Documento gerarDocumentoAleatorio() {
        int novoId;
        // Garante que o ID seja único (entre 1 e 1000)
        do {
            novoId = random.nextInt(1000) + 1;
        } while (idsEmUso.contains(novoId));
        
        idsEmUso.add(novoId);
        
        String tipo = tiposPermitidos.get(random.nextInt(tiposPermitidos.size()));
        int paginas = random.nextInt(100) + 1;
        
        return new Documento(novoId, tipo, paginas);
    }

    // --- Funcionalidades Obrigatórias ---

    /**
     * adicionar_documento_normal(documento) - Adiciona documento no final do DEQUE.
     */
    public void adicionarDocumentoNormal(Documento documento) {
        fila.addLast(documento); // Equivalente a 'append'
        System.out.println("➕ Normal: " + documento + " adicionado ao final.");
    }

    /**
     * adicionar_documento_urgente(documento) - Adiciona documento no início do DEQUE.
     */
    public void adicionarDocumentoUrgente(Documento documento) {
        fila.addFirst(documento); // Equivalente a 'appendleft'
        System.out.println("🚨 Urgente: " + documento + " adicionado ao início.");
    }

    /**
     * processar_proximo() - Remove e retorna documento do início do DEQUE.
     */
    public Documento processarProximo() {
        if (filaVazia()) {
            System.out.println("⚠️  Fila vazia. Nada para processar.");
            return null;
        }
        
        Documento doc = fila.pollFirst(); // Remove e retorna o primeiro (cabeça)
        idsEmUso.remove(doc.getId());
        System.out.println("🖨️  Imprimindo (Início): " + doc);
        return doc;
    }

    /**
     * processar_ultimo() - Remove e retorna documento do final do DEQUE.
     */
    public Documento processarUltimo() {
        if (filaVazia()) {
            System.out.println("⚠️  Fila vazia. Nada para processar.");
            return null;
        }
        
        Documento doc = fila.pollLast(); // Remove e retorna o último (cauda)
        idsEmUso.remove(doc.getId());
        System.out.println("🖨️  Imprimindo (Final):  " + doc);
        return doc;
    }

    /**
     * visualizar_fila() - Mostra todos os documentos na DEQUE.
     */
    public void visualizarFila() {
        if (filaVazia()) {
            System.out.println("\n--- Fila de Impressão Vazia ---");
            return;
        }

        System.out.println("\n" + "=".repeat(40));
        System.out.println(String.format("%-40s", "FILA DE IMPRESSÃO ATUAL"));
        System.out.println("=".repeat(40));
        System.out.println(String.format(" INÍCIO %-29s FINAL ", ""));
        System.out.println(String.format("   ⬇️  %-29s  ⬇️  ", ""));
        
        int i = 1;
        for (Documento doc : fila) {
            String marcador = "";
            if (i == 1) marcador = "(Próximo)";
            if (i == fila.size()) marcador = "(Último)";
            System.out.println(String.format(" %d. %s %s", i++, doc, marcador));
        }
        
        System.out.println("=".repeat(40));
        System.out.println(String.format("Total Docs: %d | Total Páginas: %d\n", 
            totalDocumentos(), totalPaginas()));
    }

    /**
     * fila_vazia() - Verifica se a fila está vazia.
     */
    public boolean filaVazia() {
        return fila.isEmpty();
    }

    /**
     * total_documentos() - Calcula total de documentos na DEQUE.
     */
    public int totalDocumentos() {
        return fila.size();
    }

    /**
     * total_paginas() - Calcula total de páginas na DEQUE para serem impressas.
     */
    public int totalPaginas() {
        int soma = 0;
        for (Documento doc : fila) {
            soma += doc.getPaginas();
        }
        return soma;
    }

    // --- Método Principal (Demonstração) ---

    public static void main(String[] args) {
        SistemaImpressao sistema = new SistemaImpressao();

        System.out.println("--- 1. Povoando a Fila Inicialmente (Normais) ---");
        // Adicionando 3 documentos normais (vão para o final)
        for (int i = 0; i < 3; i++) {
            sistema.adicionarDocumentoNormal(sistema.gerarDocumentoAleatorio());
        }

        sistema.visualizarFila();

        System.out.println("--- 2. Chegou um Documento Urgente ---");
        // Adicionando documento urgente (vai para o início/prioridade)
        Documento docUrgente = sistema.gerarDocumentoAleatorio();
        sistema.adicionarDocumentoUrgente(docUrgente);
        
        sistema.visualizarFila();

        System.out.println("--- 3. Processando de Ambas as Extremidades (Simulação Paralela) ---");
        // Processando o urgente (Início - prioridade máxima)
        sistema.processarProximo();
        
        // A impressora auxiliar/segundo canal processa do final
        sistema.processarUltimo();

        sistema.visualizarFila();

        System.out.println("--- 4. Esvaziando o Restante da Fila ---");
        while (!sistema.filaVazia()) {
            sistema.processarProximo();
        }
        
        sistema.visualizarFila();
    }
}