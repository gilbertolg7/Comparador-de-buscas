package com.example.ComparadorDeBusca.service;

import com.example.ComparadorDeBusca.model.Node;
import com.example.ComparadorDeBusca.model.ResultadoBusca;


import java.util.*;

public class BuscaGulosa {

    public static ResultadoBusca encontrar(Map<String, Map<String, Integer>> grafo, String origem, String destino, Map<String, Integer> heuristica) {
        PriorityQueue<Node> fila = new PriorityQueue<>(Comparator.comparingInt(n -> heuristica.getOrDefault(n.nome, 0)));
        fila.add(new Node(origem, List.of(origem), 0));
        Set<String> visitados = new HashSet<>();

        while (!fila.isEmpty()) {
            Node atual = fila.poll();

            if (atual.nome.equals(destino)) {
                return new ResultadoBusca(atual.caminho, atual.custo);
            }

            if (!visitados.contains(atual.nome)) {
                visitados.add(atual.nome);
                Map<String, Integer> vizinhos = grafo.getOrDefault(atual.nome, new HashMap<>());
                for (Map.Entry<String, Integer> vizinho : vizinhos.entrySet()) {
                    String nomeVizinho = vizinho.getKey();
                    int custoAteVizinho = atual.custo + vizinho.getValue();
                    List<String> novoCaminho = new ArrayList<>(atual.caminho);
                    novoCaminho.add(nomeVizinho);
                    fila.add(new Node(nomeVizinho, novoCaminho, custoAteVizinho));
                }
            }
        }

        return new ResultadoBusca(List.of(), 0); 
    }
}