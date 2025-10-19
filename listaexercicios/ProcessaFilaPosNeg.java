/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaexercicios;

/**
 *
 * @author 1jean
 */
import java.util.*;

public class ProcessaFilaPosNeg {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();
        Stack<Integer> pilha = new Stack<>();
        Random random = new Random();
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            numeros.add(random.nextInt(1000) + 1); // 1000 positivos
            numeros.add((random.nextInt(1000) + 1) * -1); // 1000 negativos
        }
        Collections.shuffle(numeros);
        fila.addAll(numeros);
        
        System.out.println("Iniciando processamento...");
        while(!fila.isEmpty()){
            int primeiro = fila.peek(); // Olha o primeiro da fila
            
            if (primeiro > 0) {
                pilha.push(fila.poll()); // Remove da fila e empilha
            } else { // é negativo
                fila.poll(); // Remove o negativo da fila
                if (!pilha.isEmpty()) {
                    System.out.println("Negativo processado. Removido da pilha: " + pilha.pop());
                } else {
                    System.out.println("Negativo processado, mas a pilha estava vazia.");
                }
            }
        }
        System.out.println("\nProcessamento finalizado.");
        System.out.println("Itens restantes na pilha: " + pilha.size());
    }
}