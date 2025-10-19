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

public class InverterFila20 {
    public static void inverter(Queue<Integer> fila) {
        Stack<Integer> pilhaAux = new Stack<>();
        while (!fila.isEmpty()) {
            pilhaAux.push(fila.poll());
        }
        while (!pilhaAux.isEmpty()) {
            fila.add(pilhaAux.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> minhaFila = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            minhaFila.add(r.nextInt(100));
        }
        
        System.out.println("Fila Original: " + minhaFila);
        inverter(minhaFila);
        System.out.println("Fila Invertida: " + minhaFila);
    }
}
