package com.example.ComparadorDeBusca.model;

import java.util.List;

public class Node {
    public String nome;
    public List<String> caminho;
    public int custo;

    public Node(String nome, List<String> caminho, int custo) {
        this.nome = nome;
        this.caminho = caminho;
        this.custo = custo;
    }
}