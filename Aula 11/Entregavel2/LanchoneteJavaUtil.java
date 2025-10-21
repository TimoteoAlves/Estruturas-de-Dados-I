package Entregavel2;

// Importações necessárias para esta implementação
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Gerencia a lanchonete usando coleções nativas do Java.
 * - LinkedList: Para a fila (addFirst/Last O(1), add(index) O(N)).
 * - HashMap: Para busca por ID e checagem de duplicados (O(1)).
 */
public class LanchoneteJavaUtil {
    
    private LinkedList<PedidoDTO> filaPedidos;
    private Map<Integer, PedidoDTO> indicePedidos;
    private int proximoId = 1;

    public LanchoneteJavaUtil() {
        this.filaPedidos = new LinkedList<>();
        this.indicePedidos = new HashMap<>();
    }

    // --- 1. Inserção (Lógica de Negócio) ---
    public void fazerPedido(String nomeCliente, String item, int qtd, double valorBase, TipoPedido tipo) {
        int id = proximoId++;
        
        // Tratar duplicados (O(1) com HashMap)
        if (indicePedidos.containsKey(id)) {
            System.out.println("ERRO: ID " + id + " já existe. Pedido rejeitado.");
            proximoId--;
            return;
        }

        double valorFinal = valorBase;
        switch (tipo) {
            case URGENTE: valorFinal = valorBase * 1.20; break;
            case PRIORITARIO: valorFinal = valorBase * 1.10; break;
            case NORMAL: break;
        }
        
        PedidoDTO novoPedido = new PedidoDTO(id, nomeCliente, item, qtd, valorFinal, tipo);
        
        indicePedidos.put(id, novoPedido); // Adiciona ao índice O(1)

        // Insere na fila (LinkedList)
        switch (tipo) {
            case URGENTE:
                filaPedidos.addFirst(novoPedido); // Inserir início (O(1))
                System.out.println("Pedido URGENTE #" + id + " inserido no INÍCIO.");
                break;
            case PRIORITARIO:
                int m = filaPedidos.size() / 2; // Posição mediana
                filaPedidos.add(m, novoPedido); // Inserir na posição m (O(N))
                System.out.println("Pedido PRIORITÁRIO #" + id + " inserido na Posição " + m + ".");
                break;
            case NORMAL:
                filaPedidos.addLast(novoPedido); // Inserir fim (O(1))
                System.out.println("Pedido NORMAL #" + id + " inserido no FIM.");
                break;
        }
    }

    // --- 2. Remoção ---

    /** Remove pedido do início (pedido atendido) */
    public PedidoDTO atenderProximoPedido() { 
        try {
            PedidoDTO atendido = filaPedidos.removeFirst(); // O(1)
            indicePedidos.remove(atendido.getId_pedido()); // O(1)
            System.out.println("ATENDIDO: " + atendido.toString());
            return atendido;
        } catch (NoSuchElementException e) {
            System.out.println("Nenhum pedido para atender.");
            return null;
        }
    }

    /** Remove pedido do fim (cancelamento) */
    public PedidoDTO cancelarUltimoPedido() { 
        try {
            PedidoDTO cancelado = filaPedidos.removeLast(); // O(1)
            indicePedidos.remove(cancelado.getId_pedido()); // O(1)
            System.out.println("ÚLTIMO CANCELADO: " + cancelado.toString());
            return cancelado;
        } catch (NoSuchElementException e) {
            System.out.println("Nenhum pedido para cancelar no fim.");
            return null;
        }
    }

    /** Remove pedido da posição k (cancelamento específico) */
    public PedidoDTO cancelarPedidoPorPosicao(int k) { 
        try {
            PedidoDTO cancelado = filaPedidos.remove(k); // O(N)
            indicePedidos.remove(cancelado.getId_pedido()); // O(1)
            System.out.println("CANCELADO (Pos " + k + "): " + cancelado.toString());
            return cancelado;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Posição " + k + " inválida para cancelamento.");
            return null;
        }
    }
    
    /** Remove por ID (caso real de cancelamento) */
    public PedidoDTO cancelarPedidoPorId(int id) {
        PedidoDTO pedido = indicePedidos.remove(id); // O(1)
        
        if (pedido != null) {
            filaPedidos.remove(pedido); // O(N) para remover o objeto
            System.out.println("CANCELADO (ID " + id + "): " + pedido.toString());
            return pedido;
        } else {
            System.out.println("Pedido com ID #" + id + " não encontrado.");
            return null;
        }
    }

    // --- 3. Busca ---

    /** Busca por ID (O(1) graças ao HashMap) */
    public PedidoDTO buscarPorId(int id) { 
        return indicePedidos.get(id);
    }
    
    /** Busca por Posição (O(N) em LinkedList) */
    public PedidoDTO buscarPorPosicao(int k) { 
        try {
            return filaPedidos.get(k); // O(N)
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    // --- 4. Impressão ---

    public void imprimirLista() {
        if (filaPedidos.isEmpty()) {
            System.out.println("A fila de pedidos está vazia.");
            return;
        }
        
        System.out.println("--- FILA DE PEDIDOS (" + filaPedidos.size() + " no total) ---");
        int pos = 0;
        for (PedidoDTO p : filaPedidos) {
            System.out.println((pos++) + ": " + p.toString());
        }
        System.out.println("----------------------------------------");
    }

    // --- 5. Funções Utilitárias ---
    
    public int tamanho() {
        return filaPedidos.size();
    }

    public boolean estaVazia() {
        return filaPedidos.isEmpty();
    }

    public PedidoDTO obterCabeça() {
        return filaPedidos.peekFirst(); // Retorna nulo se vazio
    }

    public PedidoDTO obterCauda() {
        return filaPedidos.peekLast(); // Retorna nulo se vazio
    }
}