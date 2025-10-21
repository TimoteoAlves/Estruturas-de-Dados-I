package Entregavel1;
public class Main {
    public static void main(String[] args) {
        Lanchonete lanchonete = new Lanchonete();

        System.out.println("--- Iniciando Lanchonete (Custom) ---");
        lanchonete.mostrarFilaAtual();

        // 1. Pedidos normais
        System.out.println("\n*** 3 Pedidos NORMAIS ***");
        lanchonete.fazerPedido("Ana", "X-Burger", 1, 20.00, TipoPedido.NORMAL);     // ID 1
        lanchonete.fazerPedido("Bruno", "Suco", 2, 8.00, TipoPedido.NORMAL);      // ID 2
        lanchonete.fazerPedido("Carla", "Açaí", 1, 15.00, TipoPedido.NORMAL);     // ID 3
        
        lanchonete.mostrarFilaAtual();
        // Fila: Ana (0), Bruno (1), Carla (2)

        // 2. Pedido Urgente
        System.out.println("\n*** Pedido URGENTE entrando ***");
        lanchonete.fazerPedido("David", "X-Tudo", 2, 30.00, TipoPedido.URGENTE);    // ID 4
        
        lanchonete.mostrarFilaAtual();
        // Fila: David (0), Ana (1), Bruno (2), Carla (3)

        // 3. Pedido Prioritário
        System.out.println("\n*** Pedido PRIORITÁRIO entrando ***");
        // Lista tem 4 itens. m = 4 / 2 = 2. Insere na posição 2.
        lanchonete.fazerPedido("Elisa", "Batata Frita", 1, 12.00, TipoPedido.PRIORITARIO); // ID 5
        
        lanchonete.mostrarFilaAtual();
        // Fila: David (0), Ana (1), Elisa (2), Bruno (3), Carla (4)
        
        // 4. Atendendo pedidos (Remover do início)
        System.out.println("\n*** Atendendo 2 pedidos ***");
        lanchonete.atenderProximoPedido(); // Atende David (ID 4)
        lanchonete.atenderProximoPedido(); // Atende Ana (ID 1)
        
        lanchonete.mostrarFilaAtual();
        // Fila: Elisa (0), Bruno (1), Carla (2)

        // 5. Cancelamento por ID (Remover k aleatório)
        System.out.println("\n*** Cancelando pedido do Bruno (ID 2) ***");
        lanchonete.cancelarPedidoPorId(2); // ID do Bruno
        
        lanchonete.mostrarFilaAtual();
        // Fila: Elisa (0), Carla (1)
        
        // 6. Exibindo próximos N
        System.out.println("\n*** Exibindo próximos 5 pedidos ***");
        lanchonete.exibirProximosPedidos(5);
    }
}