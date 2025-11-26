public class HistoricoNavegador {

    private class NoUrl {
        String url;
        NoUrl proximo;

        public NoUrl(String url) {
            this.url = url;
        }
    }

    private NoUrl topo;

    public void adicionarUrl(String url) {
        NoUrl novo = new NoUrl(url);
        novo.proximo = topo;
        topo = novo;
        System.out.println("Visitou: " + url);
    }

    public void voltar() {
        if (topo == null) {
            System.out.println("Histórico vazio.");
        } else {
            System.out.println("<< Voltando de: " + topo.url);
            topo = topo.proximo;
        }
    }

    public void limparHistorico() {
        topo = null;
        System.out.println("Histórico limpo.");
    }

    public void exibirHistorico() {
        System.out.println("--- Histórico ---");
        NoUrl atual = topo;
        while (atual != null) {
            System.out.println(atual.url);
            atual = atual.proximo;
        }
    }
    
    public void mostrarAtual() {
        if(topo != null) System.out.println("Página Atual: " + topo.url);
    }

    public static void main(String[] args) {
        System.out.println("=== 6. HISTÓRICO ===");
        HistoricoNavegador hist = new HistoricoNavegador();
        hist.adicionarUrl("google.com");
        hist.adicionarUrl("youtube.com");
        hist.voltar();
        hist.limparHistorico();
        hist.exibirHistorico();
    }
}