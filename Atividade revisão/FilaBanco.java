import java.util.LinkedList;
import java.util.Queue;

public class FilaBanco {
    
    private Queue<Integer> fila;

    public FilaBanco() {
        this.fila = new LinkedList<>();
    }

    public void enfileirar(int senha) {
        fila.add(senha);
        System.out.println("Cliente com senha " + senha + " entrou na fila.");
    }

    public void desenfileirar() {
        if (estaVazia()) {
            System.out.println("Fila vazia. Ninguém para atender.");
        } else {
            int senha = fila.poll();
            System.out.println("Chamando cliente senha: " + senha);
        }
    }

    public void frente() {
        if (estaVazia()) {
            System.out.println("Fila vazia.");
        } else {
            System.out.println("Próximo cliente a ser atendido: " + fila.peek());
        }
    }

    public int tamanho() {
        return fila.size();
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("=== 1. SISTEMA DE BANCO ===");
        FilaBanco banco = new FilaBanco();
        
        banco.enfileirar(101);
        banco.enfileirar(102);
        banco.enfileirar(103);
        
        banco.frente();
        System.out.println("Clientes aguardando: " + banco.tamanho());
        
        banco.desenfileirar(); // Atende 101
        banco.frente();        // Agora é o 102
    }
}