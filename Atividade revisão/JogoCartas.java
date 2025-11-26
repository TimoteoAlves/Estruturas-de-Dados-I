public class JogoCartas {

    private class NoCarta {
        String carta;
        NoCarta anterior;
        NoCarta proximo;

        public NoCarta(String carta) {
            this.carta = carta;
        }
    }

    private NoCarta inicio;
    private NoCarta fim;

    public void inserirInicio(String carta) {
        NoCarta novo = new NoCarta(carta);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
    }

    public void inserirFim(String carta) {
        NoCarta novo = new NoCarta(carta);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void removerInicio() {
        if (inicio != null) {
            System.out.println("Saiu (início): " + inicio.carta);
            if (inicio == fim) {
                inicio = fim = null;
            } else {
                inicio = inicio.proximo;
                inicio.anterior = null;
            }
        }
    }

    public void removerFim() {
        if (fim != null) {
            System.out.println("Saiu (fim): " + fim.carta);
            if (inicio == fim) {
                inicio = fim = null;
            } else {
                fim = fim.anterior;
                fim.proximo = null;
            }
        }
    }
    
    public void embaralhar() {
        if (inicio == null) return;
        NoCarta atual = inicio;
        NoCarta temp = null;
        while (atual != null) {
            temp = atual.anterior;
            atual.anterior = atual.proximo;
            atual.proximo = temp;
            atual = atual.anterior; // Avança (agora é anterior)
        }
        if (temp != null) {
            NoCarta antigoInicio = inicio;
            inicio = fim;
            fim = antigoInicio;
        }
        System.out.println("Baralho embaralhado (invertido)!");
    }
    
    public void frente() { if(inicio!=null) System.out.println("Frente: " + inicio.carta); }
    public void tras() { if(fim!=null) System.out.println("Fundo: " + fim.carta); }
    public boolean estaVazio() { return inicio == null; }

    public void exibir() {
        NoCarta atual = inicio;
        System.out.print("Baralho: ");
        while(atual != null) { System.out.print("[" + atual.carta + "] "); atual = atual.proximo; }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== 7. JOGO CARTAS ===");
        JogoCartas jogo = new JogoCartas();
        jogo.inserirInicio("Ás");
        jogo.inserirFim("Rei");
        jogo.inserirInicio("2");
        jogo.exibir();
        jogo.embaralhar();
        jogo.exibir();
    }
}