package com.example.ComparadorDeBusca.service;



import java.util.*;

import com.example.ComparadorDeBusca.model.Node;
import com.example.ComparadorDeBusca.model.ResultadoBusca;




public class BuscaAEstrela {
    public static ResultadoBusca encontrar(Map<String, Map<String, Integer>> grafo, String origem, String destino, Map<String, Integer> heuristica) {
        PriorityQueue<Node> fila = new PriorityQueue<>(Comparator.comparingInt(n -> n.custo + heuristica.getOrDefault(n.nome, 0)));
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
                for (String vizinho : vizinhos.keySet()) {
                    int novoCusto = atual.custo + vizinhos.get(vizinho);
                    List<String> novoCaminho = new ArrayList<>(atual.caminho);
                    novoCaminho.add(vizinho);
                    fila.add(new Node(vizinho, novoCaminho, novoCusto));
                }
            }
        }

        return new ResultadoBusca(List.of(), 0);
}
}