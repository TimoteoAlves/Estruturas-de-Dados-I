package Entregavel1;
/**
 * Representa o "Nó" (Node) da lista encadeada.
 * Contém os dados do pedido e o ponteiro para o próximo.
 */
public class Pedido {
    int id_pedido;
    String nome_cliente;
    String item;
    int quantidade;
    double valor;
    TipoPedido tipo;
    
    Pedido proximo; // Ponteiro para o próximo nó da lista

    public Pedido(int id_pedido, String nome_cliente, String item, int quantidade, double valor, TipoPedido tipo) {
        this.id_pedido = id_pedido;
        this.nome_cliente = nome_cliente;
        this.item = item;
        this.quantidade = quantidade;
        this.valor = valor;
        this.tipo = tipo;
        this.proximo = null; // O próximo é nulo por padrão
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