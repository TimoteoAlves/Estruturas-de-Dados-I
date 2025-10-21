package Entregavel2;

/**
 * Representa o objeto de dados (DTO/POJO) do Pedido.
 * Não contém ponteiros de implementação (como "proximo").
 */
public class PedidoDTO {
    int id_pedido;
    String nome_cliente;
    String item;
    int quantidade;
    double valor;
    TipoPedido tipo;

    public PedidoDTO(int id_pedido, String nome_cliente, String item, int quantidade, double valor, TipoPedido tipo) {
        this.id_pedido = id_pedido;
        this.nome_cliente = nome_cliente;
        this.item = item;
        this.quantidade = quantidade;
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    @Override
    public String toString() {
        return "Pedido #" + id_pedido + 
               " [" + tipo + "]" +
               " - " + nome_cliente + 
               " (" + quantidade + "x " + item + ")" +
               " - R$" + String.format("%.2f", valor);
    }
}