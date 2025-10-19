/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaexercicios;

/**
 *
 * @author 1jean
 */
public class PotenciaRecursiva {

    public static long calcularPotencia(int a, int b) {
        // Validação para expoente negativo (não coberto pela definição clássica)
        if (b < 0) {
            throw new IllegalArgumentException("Expoente não pode ser negativo.");
        }
        
        // Caso base: Qualquer número elevado a 0 é 1.
        if (b == 0) {
            return 1;
        }
        
        // Passo recursivo: a^b = a * a^(b-1)
        return a * calcularPotencia(a, b - 1);
    }

    public static void main(String[] args) {
        int base = 3;
        int expoente = 4;
        long resultado = calcularPotencia(base, expoente);
        System.out.println(base + " elevado a " + expoente + " é: " + resultado); // Deve retornar 81
    }
}
