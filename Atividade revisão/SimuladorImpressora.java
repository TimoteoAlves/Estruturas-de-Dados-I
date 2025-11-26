public class SimuladorImpressora {

    private class Documento {
        String nome;
        int paginas;
        Documento proximo;

        public Documento(String nome, int paginas) {
            this.nome = nome;
            this.paginas = paginas;
            this.proximo = null;
        }
    }

    private Documento inicio;
    private Documento fim;

    // Adiciona ao final da fila
    public void adicionarDocumento(String nome, int paginas) {
        Documento novo = new Documento(nome, paginas);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
        System.out.println("Adicionado: " + nome);
    }

    // Remove um documento específico (mesmo que esteja no meio da fila)
    public void cancelarDocumento(String nome) {
        if (inicio == null) {
            System.out.println("Fila vazia.");
            return;
        }

        // Caso especial: remover o primeiro
        if (inicio.nome.equals(nome)) {
            inicio = inicio.proximo;
            if (inicio == null) fim = null;
            System.out.println("Cancelado: " + nome);
            return;
        }

        // Procura no restante da fila
        Documento anterior = inicio;
        Documento atual = inicio.proximo;
        while (atual != null) {
            if (atual.nome.equals(nome)) {
                anterior.proximo = atual.proximo;
                // Se removeu o último, atualiza o ponteiro fim
                if (atual == fim) {
                    fim = anterior;
                }
                System.out.println("Cancelado: " + nome);
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        System.out.println("Documento não encontrado: " + nome);
    }

    // Processa (imprime) o primeiro da fila
    public void processarImpressao() {
        if (inicio == null) {
            System.out.println("Nenhum documento na fila.");
        } else {
            System.out.println(">>> Imprimindo: " + inicio.nome + " (" + inicio.paginas + " pgs)...");
            inicio = inicio.proximo;
            if (inicio == null) fim = null;
        }
    }

    public void mostrarFila() {
        Documento atual = inicio;
        System.out.print("Fila de Impressão: ");
        if (atual == null) System.out.print("Vazia");
        
        while (atual != null) {
            System.out.print("[" + atual.nome + "] ");
            atual = atual.proximo;
        }
        System.out.println();
    }
    
    public int totalPaginas() {
        int total = 0;
        Documento atual = inicio;
        while(atual != null) {
            total += atual.paginas;
            atual = atual.proximo;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("=== 5. SIMULADOR DE IMPRESSORA ===");
        SimuladorImpressora imp = new SimuladorImpressora();
        
        imp.adicionarDocumento("TCC_Final.pdf", 50);
        imp.adicionarDocumento("Foto_Familia.jpg", 1);
        imp.adicionarDocumento("Relatorio.docx", 10);
        
        imp.mostrarFila();
        
        imp.cancelarDocumento("Foto_Familia.jpg"); // Teste do cancelamento (meio da fila)
        
        imp.mostrarFila();
        System.out.println("Total de páginas: " + imp.totalPaginas());
        
        imp.processarImpressao(); // Deve imprimir TCC_Final
        imp.processarImpressao(); // Deve imprimir Relatorio
    }
}