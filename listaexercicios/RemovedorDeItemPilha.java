/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaexercicios;

/**
 *
 * @author 1jean
 */
import java.util.Stack;

public class RemovedorDeItemPilha {

    public static void removerItem(Stack<Integer> pilha, int chave) {
        Stack<Integer> pilhaAuxiliar = new Stack<>();
        boolean encontrado = false;

        // 1. Move os itens para a pilha auxiliar até encontrar a chave
        while (!pilha.isEmpty()) {
            int item = pilha.pop();
            if (item == chave) {
                encontrado = true;
                break; // Item encontrado e descartado, interrompe o loop
            } else {
                pilhaAuxiliar.push(item);
            }
        }

        // 2. Retorna os itens da pilha auxiliar para a pilha original
        while (!pilhaAuxiliar.isEmpty()) {
            pilha.push(pilhaAuxiliar.pop());
        }
        
        if (!encontrado) {
            System.out.println("Atenção: A chave " + chave + " não foi encontrada na pilha.");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> minhaPilha = new Stack<>();
        minhaPilha.push(10);
        minhaPilha.push(20);
        minhaPilha.push(30);
        minhaPilha.push(40);
        minhaPilha.push(50);

        System.out.println("Pilha Original: " + minhaPilha);
        
        int chaveParaRemover = 30;
        removerItem(minhaPilha, chaveParaRemover);
        
        System.out.println("Pilha após remover o item " + chaveParaRemover + ": " + minhaPilha);
    }
}