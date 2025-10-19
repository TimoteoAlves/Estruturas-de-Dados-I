/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaexercicios;

/**
 *
 * @author 1jean
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class InversorDeFila {

    public static Queue<Integer> inverterFila(Queue<Integer> f1) {
        Stack<Integer> pilhaAuxiliar = new Stack<>();
        Queue<Integer> f2 = new LinkedList<>();

        // 1. Esvazia a fila F1, empilhando seus elementos
        while (!f1.isEmpty()) {
            pilhaAuxiliar.push(f1.poll());
        }

        // 2. Esvazia a pilha, enfileirando os elementos em F2
        while (!pilhaAuxiliar.isEmpty()) {
            f2.add(pilhaAuxiliar.pop());
        }

        return f2;
    }

    public static void main(String[] args) {
        Queue<Integer> f1 = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            f1.add(random.nextInt(1000));
        }

        System.out.println("Fila Original (F1) - 10 primeiros: " + f1.toString().substring(0, 40) + "...");
        
        Queue<Integer> f2 = inverterFila(f1);
        
        System.out.println("Fila Invertida (F2) - 10 primeiros: " + f2.toString().substring(0, 40) + "...");
    }
}
