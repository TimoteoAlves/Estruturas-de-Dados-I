package Entregavel1;
/**
 * Implementação da Lista Simplesmente Encadeada para gerenciar os Pedidos.
 */
public class ListaPedidos {
    private Pedido cabeça; // Ponteiro para o início da lista
    private Pedido cauda;  // Ponteiro para o fim (para O(1) na inserção final)
    private int tamanho;

    public ListaPedidos() {
        this.cabeça = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    // --- 5. Funções Utilitárias ---

    public int tamanho() {
        return this.tamanho;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public Pedido obterCabeça() {
        return this.cabeça;
    }

    public Pedido obterCauda() {
        return this.cauda;
    }

    // --- 1. Funções de Inserção ---

    /**
     * Insere um pedido no início da lista (para pedidos URGENTES).
     */
    public void inserirInicio(Pedido novoPedido) {
        if (estaVazia()) {
            this.cabeça = novoPedido;
            this.cauda = novoPedido;
        } else {
            novoPedido.proximo = this.cabeça;
            this.cabeça = novoPedido;
        }
        this.tamanho++;
    }

    /**
     * Insere um pedido no fim da lista (para pedidos NORMAIS).
     */
    public void inserirFim(Pedido novoPedido) {
        novoPedido.proximo = null; // Garante que é o último
        
        if (estaVazia()) {
            this.cabeça = novoPedido;
            this.cauda = novoPedido;
        } else {
            this.cauda.proximo = novoPedido;
            this.cauda = novoPedido; // Atualiza o ponteiro da cauda
        }
        this.tamanho++;
    }

    /**
     * Insere um pedido na posição mediana (para pedidos PRIORITÁRIOS).
     * Posição m = tamanho / 2
     */
    public void inserirMeio(Pedido novoPedido) {
        if (tamanho <= 1) {
            // Se a lista tem 0 ou 1 item, a "mediana" é no início.
            inserirInicio(novoPedido);
            return;
        }

        // Posição mediana (base 0)
        int m = this.tamanho / 2;

        // Precisamos parar no nó ANTERIOR à posição m (m-1)
        Pedido anterior = this.cabeça;
        for (int i = 0; i < m - 1; i++) {
            anterior = anterior.proximo;
        }

        novoPedido.proximo = anterior.proximo;
        anterior.proximo = novoPedido;
        
        this.tamanho++;
    }

    // --- 2. Funções de Remoção ---

    /**
     * Remove o pedido do início (pedido atendido).
     */
    public Pedido removerInicio() {
        if (estaVazia()) {
            return null;
        }

        Pedido removido = this.cabeça;
        this.cabeça = this.cabeça.proximo;
        this.tamanho--;

        if (estaVazia()) {
            this.cauda = null; // Se ficou vazia, ajusta a cauda
        }

        removido.proximo = null; // Limpa a referência
        return removido;
    }

    /**
     * Remove o pedido do fim (cancelamento de última hora).
     */
    public Pedido removerFim() {
        if (estaVazia()) {
            return null;
        }
        
        if (this.cabeça == this.cauda) { // Se há apenas um item
            return removerInicio();
        }

        // Encontra o PENÚLTIMO nó (O(N))
        Pedido penultimo = this.cabeça;
        while (penultimo.proximo != this.cauda) {
            penultimo = penultimo.proximo;
        }

        Pedido removido = this.cauda;
        this.cauda = penultimo;
        this.cauda.proximo = null;
        this.tamanho--;

        return removido;
    }

    /**
     * Remove um pedido da posição k (cancelamento específico).
     * k=0 é o início, k=tamanho-1 é o fim.
     */
    public Pedido removerPorPosicao(int k) {
        if (k < 0 || k >= this.tamanho) {
            return null; // Posição inválida
        }
        if (k == 0) {
            return removerInicio();
        }
        if (k == this.tamanho - 1) {
            return removerFim();
        }

        // Encontra o nó ANTERIOR (k-1)
        Pedido anterior = this.cabeça;
        for (int i = 0; i < k - 1; i++) {
            anterior = anterior.proximo;
        }

        Pedido removido = anterior.proximo;
        anterior.proximo = removido.proximo;
        
        this.tamanho--;
        removido.proximo = null;
        return removido;
    }
    
    /**
     * Remove por ID (Necessário para cancelamentos de casos reais).
     */
    public Pedido removerPorId(int id) {
        if (estaVazia()) return null;

        // Caso 1: O nó a ser removido é a cabeça
        if (cabeça.id_pedido == id) {
            return removerInicio();
        }

        Pedido anterior = cabeça;
        Pedido atual = cabeça.proximo;

        // Caso 2: O nó está no meio ou fim
        while (atual != null && atual.id_pedido != id) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual == null) { // Não encontrou
            return null;
        }
        
        anterior.proximo = atual.proximo; // Remove 'atual'

        if (atual == cauda) { // Caso 3: Era a cauda
            cauda = anterior;
        }

        tamanho--;
        atual.proximo = null;
        return atual;
    }


    // --- 3. Funções de Busca ---

    /**
     * Busca um pedido pelo seu ID (O(N)).
     */
    public Pedido buscarPorId(int id) {
        Pedido atual = this.cabeça;
        while (atual != null) {
            if (atual.id_pedido == id) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null; // Não encontrado
    }

    /**
     * Busca um pedido pela sua posição na fila (O(N)).
     */
    public Pedido buscarPorPosicao(int k) {
        if (k < 0 || k >= this.tamanho) {
            return null; // Posição inválida
        }

        Pedido atual = this.cabeça;
        for (int i = 0; i < k; i++) {
            atual = atual.proximo;
        }
        return atual;
    }

    // --- 4. Impressão ---

    public void imprimirLista() {
        if (estaVazia()) {
            System.out.println("A fila de pedidos está vazia.");
            return;
        }
        
        System.out.println("--- FILA DE PEDIDOS (" + tamanho + " no total) ---");
        Pedido atual = this.cabeça;
        int pos = 0;
        while (atual != null) {
            System.out.println((pos++) + ": " + atual.toString());
            atual = atual.proximo;
        }
        System.out.println("----------------------------------------");
    }
}