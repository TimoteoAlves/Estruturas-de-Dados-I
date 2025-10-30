// DoublyLinkedList.java
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Construtor: Inicializa uma lista vazia.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Insere um número na lista em sua posição correta (ordem crescente).
     * @param data O número a ser inserido.
     */
    public void insertSorted(int data) {
        Node newNode = new Node(data);
        size++;

        // Caso 1: A lista está vazia
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // Caso 2: Inserir no início (novo valor é o menor)
        if (data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        // Caso 3: Inserir no meio ou no fim
        Node current = head;
        // Procura a posição correta para inserir
        // Para quando current.next é nulo (fim da lista)
        // ou quando o dado do próximo é maior que o novo dado
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }

        // Se current.next é null, estamos inserindo no fim
        if (current.next == null) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode; // Atualiza o rabo
        } else {
            // Inserindo no meio
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    /**
     * Imprime a lista do início ao fim (ordem crescente).
     */
    public void printAscending() {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); // Nova linha no final
    }

    /**
     * Imprime a lista do fim ao início (ordem decrescente).
     */
    public void printDescending() {
        if (tail == null) {
            System.out.println("Lista vazia.");
            return;
        }

        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println(); // Nova linha no final
    }

    /**
     * Remove todos os números primos da lista.
     */
    public void removePrimes() {
        Node current = head;
        while (current != null) {
            Node nextNode = current.next; // Guarda o próximo nó
            if (isPrime(current.data)) {
                removeNode(current); // Remove o nó se for primo
            }
            current = nextNode; // Avança para o próximo nó
        }
    }

    /**
     * Função auxiliar para remover um nó específico da lista.
     * @param node O nó a ser removido.
     */
    private void removeNode(Node node) {
        // Caso 1: Nó é o head
        if (node == head) {
            head = node.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // A lista ficou vazia
            }
        }
        // Caso 2: Nó é o tail
        else if (node == tail) {
            tail = node.prev;
            tail.next = null;
        }
        // Caso 3: Nó está no meio
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Limpa referências do nó removido
        node.prev = null;
        node.next = null;
        size--;
    }

    /**
     * Verifica se um número é primo.
     * Números 0, 1 e negativos não são considerados primos.
     * @param n O número a ser verificado.
     * @return true se o número for primo, false caso contrário.
     */
    private boolean isPrime(int n) {
        // Trata números negativos, 0 e 1 como não-primos
        if (n <= 1) {
            return false;
        }
        
        // 2 é o único primo par
        if (n == 2) {
            return true;
        }

        // Otimização: Se for par e maior que 2, não é primo
        if (n % 2 == 0) {
            return false;
        }

        // Verifica divisores ímpares a partir de 3
        // Só precisamos ir até a raiz quadrada de n
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false; // Encontrou um divisor
            }
        }
        
        return true; // Não encontrou divisores
    }
}