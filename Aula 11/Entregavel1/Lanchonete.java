package Entregavel1;
/**
 * Classe que gerencia a lógica de negócio da lanchonete,
 * utilizando a ListaPedidos customizada.
 */
public class Lanchonete {
    private ListaPedidos filaPedidos;
    private int proximoId = 1; // Auto-incremento de ID

    public Lanchonete() {
        this.filaPedidos = new ListaPedidos();
    }

    /**
     * Método principal para criar e inserir um novo pedido.
     */
    public void fazerPedido(String nomeCliente, String item, int qtd, double valorBase, TipoPedido tipo) {
        int id = proximoId++;
        
        // Tratamento de IDs duplicados (rejeitar) - (O(N) nesta implementação)
        if (filaPedidos.buscarPorId(id) != null) {
            System.out.println("ERRO: ID " + id + " já existe. Pedido rejeitado.");
            proximoId--; // Reutiliza o ID
            return;
        }

        double valorFinal = valorBase;
        String logMsg = "";

        switch (tipo) {
            case URGENTE:
                valorFinal = valorBase * 1.20; // Acréscimo de 20%
                logMsg = "Pedido URGENTE inserido no INÍCIO.";
                break;
            case PRIORITARIO:
                valorFinal = valorBase * 1.10; // Acréscimo de 10%
                logMsg = "Pedido PRIORITÁRIO inserido no MEIO (Pos " + (filaPedidos.tamanho() / 2) + ").";
                break;
            case NORMAL:
                logMsg = "Pedido NORMAL inserido no FIM.";
                break;
        }
        
        Pedido novoPedido = new Pedido(id, nomeCliente, item, qtd, valorFinal, tipo);

        // Insere na lista conforme o tipo
        switch (tipo) {
            case URGENTE:
                filaPedidos.inserirInicio(novoPedido);
                break;
            case PRIORITARIO:
                filaPedidos.inserirMeio(novoPedido);
                break;
            case NORMAL:
                filaPedidos.inserirFim(novoPedido);
                break;
        }
        
        System.out.println(logMsg + " (ID: " + id + ")");
    }

    /**
     * Atende o próximo pedido da fila (remove do início).
     */
    public void atenderProximoPedido() {
        Pedido atendido = filaPedidos.removerInicio();
        if (atendido != null) {
            System.out.println("ATENDIDO: " + atendido.toString());
        } else {
            System.out.println("Nenhum pedido para atender.");
        }
    }
    
    /**
     * Cancela um pedido específico pelo ID (caso real).
     */
    public void cancelarPedidoPorId(int id) {
        Pedido cancelado = filaPedidos.removerPorId(id);
        if (cancelado != null) {
            System.out.println("CANCELADO: " + cancelado.toString());
        } else {
            System.out.println("Pedido com ID #" + id + " não encontrado para cancelamento.");
        }
    }

    /**
     * Exibe os próximos N pedidos (busca por posição).
     */
    public void exibirProximosPedidos(int n) {
        System.out.println("--- Próximos " + n + " pedidos ---");
        int count = 0;
        for (int i = 0; i < n && i < filaPedidos.tamanho(); i++) {
            Pedido p = filaPedidos.buscarPorPosicao(i);
            if (p != null) {
                System.out.println(p.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Nenhum pedido na fila.");
        }
        System.out.println("---------------------------");
    }

    public void mostrarFilaAtual() {
        filaPedidos.imprimirLista();
    }
}