import java.util.LinkedList;

// O nome da classe foi alterado para 'atividadeHomer'
public class AtividadeHomer {

    public static void main(String[] args) {
        // Criamos a lista encadeada (duplamente encadeada, por padrão no Java)
        LinkedList<String> lista = new LinkedList<>();

        System.out.println("--- Executando Atividade da Lista Encadeada ---");

        // 1) Adicione Homer e Marge na lista e depois imprima o resultado.
        System.out.println("\n1) Adicionando Homer e Marge");
        lista.add("Homer"); // Adiciona no final
        lista.add("Marge"); // Adiciona no final
        imprimirLista(lista); // Impressão: Homer Marge

        // 2) Esvazie a lista e imprima.
        System.out.println("\n2) Esvaziando a lista");
        lista.clear();
        imprimirLista(lista); // Impressão: (lista vazia)

        // 3) Adicione Homer na lista. Depois adicione Bart na posição 0 e Moll na posição 1 e imprima a lista.
        System.out.println("\n3) Adicionando Homer, Bart (pos 0) e Moll (pos 1)");
        lista.add("Homer"); // Lista: [Homer]
        lista.add(0, "Bart"); // Adiciona na posição 0. Lista: [Bart, Homer]
        lista.add(1, "Moll"); // Adiciona na posição 1. Lista: [Bart, Moll, Homer]
        imprimirLista(lista); // Impressão: Bart Moll Homer

        // 4) Esvazie a lista.
        System.out.println("\n4) Esvaziando a lista");
        lista.clear();

        // 5) Adicione Homer e Bart na lista e depois Adicione Lisa no início da lista. Imprima o resultado e o tamanho da lista.
        System.out.println("\n5) Adicionando Homer, Bart, e Lisa (no início)");
        lista.add("Homer");
        lista.add("Bart");
        lista.addFirst("Lisa"); // Adiciona no início
        imprimirLista(lista); // Impressão: Lisa Homer Bart
        System.out.println("Tamanho: " + lista.size());

        // 6) Esvazie a lista e imprima.
        System.out.println("\n6) Esvaziando a lista");
        lista.clear();
        imprimirLista(lista); // Impressão: (lista vazia)

        // 7) Adicione Homer e Maggie na lista. Depois adicione Bart na posição 0 e Marge na posição 1 e imprima a lista. Verifique se Lisa está na lista.
        System.out.println("\n7) Adicionando Homer, Maggie, Bart (pos 0), Marge (pos 1)");
        lista.add("Homer");
        lista.add("Maggie");
        lista.add(0, "Bart");
        lista.add(1, "Marge");
        imprimirLista(lista); // Impressão: Bart Marge Homer Maggie
        System.out.println("Verificar se Lisa está na lista: " + lista.contains("Lisa")); // contains()

        // 8) Esvazie a lista.
        System.out.println("\n8) Esvaziando a lista");
        lista.clear();

        // 9) Adicione Homer e Bart na lista e depois imprima o resultado e o tamanho da lista.
        System.out.println("\n9) Adicionando Homer e Bart");
        lista.add("Homer");
        lista.add("Bart");
        imprimirLista(lista);
        System.out.println("Tamanho: " + lista.size());

        // 10) Verifique se Marge, Homer, Bart e Maggie estão na lista e depois imprima o resultado e o tamanho da lista.
        System.out.println("\n10) Verificando elementos");
        System.out.println("Contém Marge? " + lista.contains("Marge"));
        System.out.println("Contém Homer? " + lista.contains("Homer"));
        System.out.println("Contém Bart? " + lista.contains("Bart"));
        System.out.println("Contém Maggie? " + lista.contains("Maggie"));
        imprimirLista(lista);
        System.out.println("Tamanho: " + lista.size());

        // 11) Esvazie a lista.
        System.out.println("\n11) Esvaziando a lista");
        lista.clear();

        // 12) Adicione Homer e Bart no começo da lista. Depois adicione Marge, e depois Maggie na posição 1 e depois Ned Flanders no Começo da lista e Sr. Burns no Final da lista imprima a lista
        System.out.println("\n12) Adicionando Homer (início), Bart (início), Marge (fim), Maggie (pos 1), Ned (início), Burns (fim)");
        lista.addFirst("Homer"); // Lista: [Homer]
        lista.addFirst("Bart"); // Lista: [Bart, Homer]
        lista.add("Marge"); // Adiciona no fim. Lista: [Bart, Homer, Marge]
        lista.add(1, "Maggie"); // Lista: [Bart, Maggie, Homer, Marge]
        lista.addFirst("Ned Flanders"); // Lista: [Ned Flanders, Bart, Maggie, Homer, Marge]
        lista.addLast("Sr. Burns"); // Adiciona no fim. Lista: [Ned Flanders, Bart, Maggie, Homer, Marge, Sr. Burns]
        imprimirLista(lista);

        // 13) Remova do fim da lista e imprima a lista.
        System.out.println("\n13) Removendo do fim");
        lista.removeLast(); // Remove "Sr. Burns"
        imprimirLista(lista);

        // 14) Remova a posição 1, depois imprima a lista e o tamanho da lista.
        System.out.println("\n14) Removendo da posição 1");
        lista.remove(1); // Remove "Bart"
        imprimirLista(lista);
        System.out.println("Tamanho: " + lista.size());

        // 15) Verifique se Marge, Homer, Bart e Maggie estão na lista e depois imprima o resultado e o tamanho da lista.
        System.out.println("\n15) Verificando elementos");
        System.out.println("Contém Marge? " + lista.contains("Marge"));
        System.out.println("Contém Homer? " + lista.contains("Homer"));
        System.out.println("Contém Bart? " + lista.contains("Bart"));
        System.out.println("Contém Maggie? " + lista.contains("Maggie"));
        imprimirLista(lista);
        System.out.println("Tamanho: " + lista.size());

        // 16) Remova do começo da lista, depois imprima a lista e o tamanho da lista.
        System.out.println("\n16) Removendo do começo");
        lista.removeFirst(); // Remove "Ned Flanders"
        imprimirLista(lista);
        System.out.println("Tamanho: " + lista.size());

        // 17) Verifique se Marge, Homer, Bart e Maggie na lista e depois imprima o resultado e o tamanho da lista.
        System.out.println("\n17) Verificando elementos");
        System.out.println("Contém Marge? " + lista.contains("Marge"));
        System.out.println("Contém Homer? " + lista.contains("Homer"));
        System.out.println("Contém Bart? " + lista.contains("Bart"));
        System.out.println("Contém Maggie? " + lista.contains("Maggie"));
        imprimirLista(lista);
        System.out.println("Tamanho: " + lista.size());

        // 18) Esvazie a lista e imprima.
        System.out.println("\n18) Esvaziando a lista");
        lista.clear();
        imprimirLista(lista);
    }

    /**
     * Método auxiliar para imprimir a lista formatada
     */
    public static void imprimirLista(LinkedList<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("Impressão: (lista vazia)");
        } else {
            // String.join() une os elementos da lista com um espaço
            System.out.println("Impressão: " + String.join(" ", lista));
        }
    }
}