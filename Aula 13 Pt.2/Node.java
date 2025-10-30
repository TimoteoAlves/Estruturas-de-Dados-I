// Node.java
public class Node {
    int data;
    Node prev;
    Node next;

    /**
     * Construtor para criar um novo nó.
     * @param data O valor a ser armazenado no nó.
     */
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}