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

public class FilaPilhaDistintos {
    public static void main(String[] args) {
        Queue<Integer> F = new LinkedList<>();
        Stack<Integer> P = new Stack<>();
        Set<Integer> numerosNaFila = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int numeroSorteado = random.nextInt(500); // Sorteia em um range menor para forçar duplicatas

            if (numerosNaFila.contains(numeroSorteado)) {
                P.push(numeroSorteado); // Se já existe, vai para a Pilha P
            } else {
                F.add(numeroSorteado); // Se não existe, vai para a Fila F
                numerosNaFila.add(numeroSorteado); // E para o controle
            }
        }

        System.out.println("--- RESULTADO FINAL ---");
        System.out.println("Total de elementos únicos na Fila F: " + F.size());
        System.out.println("Fila F: " + F);
        System.out.println("\nTotal de elementos duplicados na Pilha P: " + P.size());
        System.out.println("Pilha P: " + P);
    }
}
