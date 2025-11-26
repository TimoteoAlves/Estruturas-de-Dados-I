public class EditorTexto {

    private class NoTexto {
        String linha;
        NoTexto anterior;
        NoTexto proximo;

        public NoTexto(String linha) {
            this.linha = linha;
        }
    }

    private NoTexto inicio;
    private NoTexto fim;
    private int tamanho;

    public void inserirFim(String texto) {
        NoTexto novo = new NoTexto(texto);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
        tamanho++;
    }

    public void inserirInicio(String texto) {
        NoTexto novo = new NoTexto(texto);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
        tamanho++;
    }

    public void inserirPosicao(int posicao, String texto) {
        if (posicao <= 0) {
            inserirInicio(texto);
            return;
        }
        if (posicao >= tamanho) {
            inserirFim(texto);
            return;
        }

        NoTexto atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }

        NoTexto novo = new NoTexto(texto);
        NoTexto anterior = atual.anterior;

        novo.proximo = atual;
        novo.anterior = anterior;
        if (anterior != null) anterior.proximo = novo;
        atual.anterior = novo;
        
        tamanho++;
        System.out.println(">> Inserido na pos " + posicao + ": " + texto);
    }
    
    // Remove pela primeira ocorrência do texto
    public void remover(String texto) {
        NoTexto atual = inicio;
        while (atual != null) {
            if (atual.linha.equals(texto)) {
                removerNo(atual);
                System.out.println(">> Removido: '" + texto + "'");
                return;
            }
            atual = atual.proximo;
        }
        System.out.println(">> Erro: Linha não encontrada.");
    }
    
    // Remove pelo índice (extra para simetria com inserirPosicao)
    public void removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Posição inválida.");
            return;
        }
        NoTexto atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        removerNo(atual);
        System.out.println(">> Removida linha da posição " + posicao);
    }

    // Auxiliar para remover um nó específico
    private void removerNo(NoTexto no) {
        if (no == inicio && no == fim) {
            inicio = fim = null;
        } else if (no == inicio) {
            inicio = no.proximo;
            inicio.anterior = null;
        } else if (no == fim) {
            fim = no.anterior;
            fim.proximo = null;
        } else {
            no.anterior.proximo = no.proximo;
            no.proximo.anterior = no.anterior;
        }
        tamanho--;
    }

    public void exibirFrente() {
        System.out.println("\n--- Texto (Início -> Fim) ---");
        NoTexto atual = inicio;
        int i = 0;
        while (atual != null) {
            System.out.println(i + ": " + atual.linha);
            atual = atual.proximo;
            i++;
        }
    }

    public void exibirTras() {
        System.out.println("\n--- Texto (Fim -> Início) ---");
        NoTexto atual = fim;
        while (atual != null) {
            System.out.println(atual.linha);
            atual = atual.anterior;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 4. EDITOR DE TEXTO ===");
        EditorTexto editor = new EditorTexto();
        editor.inserirFim("Linha A");
        editor.inserirFim("Linha C");
        editor.inserirPosicao(1, "Linha B (Inserida)");
        editor.exibirFrente();
        
        editor.remover("Linha A");
        editor.exibirFrente();
    }
}