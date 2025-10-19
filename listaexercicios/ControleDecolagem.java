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
import java.util.Scanner;

class Aviao {
    private int id;
    private String nome;

    public Aviao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aviao [ID=" + id + ", Nome=" + nome + "]";
    }
}

public class ControleDecolagem {
    public static void main(String[] args) {
        Queue<Aviao> filaDeDecolagem = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int proximoId = 1;

        while (true) {
            System.out.println("\n--- Controle de Pista de Decolagem ---");
            System.out.println("1. Listar número de aviões na fila");
            System.out.println("2. Autorizar decolagem do primeiro avião");
            System.out.println("3. Adicionar avião à fila");
            System.out.println("4. Listar todos os aviões na fila");
            System.out.println("5. Listar características do primeiro avião");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1: // a) Listar número de aviões
                    System.out.println("Número de aviões aguardando: " + filaDeDecolagem.size());
                    break;
                case 2: // b) Autorizar decolagem
                    if (!filaDeDecolagem.isEmpty()) {
                        Aviao aviaoDecolando = filaDeDecolagem.poll();
                        System.out.println("O avião " + aviaoDecolando + " decolou.");
                    } else {
                        System.out.println("Não há aviões na fila de decolagem.");
                    }
                    break;
                case 3: // c) Adicionar avião
                    System.out.print("Digite o nome do avião: ");
                    String nome = scanner.nextLine();
                    Aviao novoAviao = new Aviao(proximoId++, nome);
                    filaDeDecolagem.add(novoAviao);
                    System.out.println(novoAviao + " adicionado à fila.");
                    break;
                case 4: // d) Listar todos os aviões
                    if (!filaDeDecolagem.isEmpty()) {
                        System.out.println("Aviões na fila: " + filaDeDecolagem);
                    } else {
                        System.out.println("A fila de decolagem está vazia.");
                    }
                    break;
                case 5: // e) Características do primeiro
                     if (!filaDeDecolagem.isEmpty()) {
                        Aviao primeiroAviao = filaDeDecolagem.peek();
                        System.out.println("Primeiro avião da fila: " + primeiroAviao);
                    } else {
                        System.out.println("A fila de decolagem está vazia.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}