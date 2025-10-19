/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listaexercicios;

/**
 *
 * @author 1jean
 */
import java.util.Scanner;
import java.util.Stack;

public class AnalisadorDeTexto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma sequência de caracteres: ");
        String textoOriginal = scanner.nextLine();

        // a) Imprimir o texto na ordem inversa
        Stack<Character> pilha = new Stack<>();
        for (char c : textoOriginal.toCharArray()) {
            pilha.push(c);
        }

        StringBuilder textoInverso = new StringBuilder();
        while (!pilha.isEmpty()) {
            textoInverso.append(pilha.pop());
        }
        System.out.println("\na) Texto na ordem inversa: " + textoInverso);

        // b) Verificar se é um palíndromo
        // Remove espaços e pontuação e converte para minúsculas
        String textoLimpo = textoOriginal.replaceAll("[\\s\\p{Punct}]", "").toLowerCase();

        Stack<Character> pilhaPalindromo = new Stack<>();
        for (char c : textoLimpo.toCharArray()) {
            pilhaPalindromo.push(c);
        }

        StringBuilder textoInvertidoLimpo = new StringBuilder();
        while (!pilhaPalindromo.isEmpty()) {
            textoInvertidoLimpo.append(pilhaPalindromo.pop());
        }
        
        System.out.println("\nb) Verificação de Palíndromo:");
        if (textoLimpo.equals(textoInvertidoLimpo.toString())) {
            System.out.println("   - O texto É um palíndromo.");
        } else {
            System.out.println("   - O texto NÃO é um palíndromo.");
        }
        
        scanner.close();
    }
}