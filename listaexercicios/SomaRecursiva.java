/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaexercicios;

/**
 *
 * @author 1jean
 */
import java.util.Arrays;
import java.util.List;

public class SomaRecursiva {
    
    public static int somar(List<Integer> lista) {
        // Caso base: Se a lista estiver vazia, a soma é 0.
        if (lista.isEmpty()) {
            return 0;
        }
        
        // Passo recursivo: Soma o primeiro elemento com o resultado da soma do resto da lista.
        int primeiroElemento = lista.get(0);
        List<Integer> restoDaLista = lista.subList(1, lista.size());
        
        return primeiroElemento + somar(restoDaLista);
    }

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
        int resultado = somar(numeros);
        System.out.println("A soma da lista " + numeros + " é: " + resultado); // Deve retornar 10
    }
}
