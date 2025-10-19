/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaexercicios;

/**
 *
 * @author 1jean
 */
import java.util.Random;
import java.util.Stack;

public class TestaPilha {
    private Stack<Integer> P; // Pilha para positivos
    private Stack<Integer> N; // Pilha para negativos

    public TestaPilha() {
        this.P = new Stack<>();
        this.N = new Stack<>();
    }

    public void processarNumero(int numero) {
        if (numero > 0) {
            P.push(numero);
        } else if (numero < 0) {
            N.push(numero);
        } else { // numero == 0
            if (!P.isEmpty() && !N.isEmpty()) {
                int numP = P.pop();
                int numN = N.pop();
                System.out.println("Zero encontrado! Removido de P: " + numP + ", Removido de N: " + numN);
            } else {
                System.out.println("Zero encontrado, mas uma ou ambas as pilhas estão vazias.");
            }
        }
    }

    public void executarSimulacao(int quantidade) {
        Random random = new Random();
        for (int i = 0; i < quantidade; i++) {
            int numSorteado = random.nextInt(201) - 100; // Gera de -100 a 100
            processarNumero(numSorteado);
        }
        
        System.out.println("\n--- Simulação Finalizada ---");
        System.out.println("Pilha P (Positivos) tem " + P.size() + " elementos. Topo: " + (P.isEmpty() ? "Vazia" : P.peek()));
        System.out.println("Pilha N (Negativos) tem " + N.size() + " elementos. Topo: " + (N.isEmpty() ? "Vazia" : N.peek()));
    }

    public static void main(String[] args) {
        TestaPilha simulador = new TestaPilha();
        simulador.executarSimulacao(1000);
    }
}
