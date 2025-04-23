package com.example.ComparadorDeBusca.service;
import com.example.ComparadorDeBusca.model.ResultadoBusca;

import java.util.*;

public class BuscaLargura {

    public static ResultadoBusca encontrar(Map<String, Map<String, Integer>> grafo, String origem, String destino) {
        Queue<NoBusca> fila = new LinkedList<>();
        Set<String> visitados = new HashSet<>();
        fila.add(new NoBusca(List.of(origem), 0));

        while (!fila.isEmpty()) {
            NoBusca noAtual = fila.poll();
            List<String> caminho = noAtual.caminho;
            int custo = noAtual.custo;
            String atual = caminho.get(caminho.size() - 1);

            if (atual.equals(destino)) {
                return new ResultadoBusca(caminho, custo);
            }

            if (!visitados.contains(atual)) {
                visitados.add(atual);
                Map<String, Integer> vizinhos = grafo.getOrDefault(atual, new HashMap<>());
                for (Map.Entry<String, Integer> vizinho : vizinhos.entrySet()) {
                    List<String> novoCaminho = new ArrayList<>(caminho);
                    novoCaminho.add(vizinho.getKey());
                    int novoCusto = custo + vizinho.getValue();
                    fila.add(new NoBusca(novoCaminho, novoCusto));
                }
            }
        }

        return new ResultadoBusca(List.of(), 0); 
    }

    private static class NoBusca {
        List<String> caminho;
        int custo;

        NoBusca(List<String> caminho, int custo) {
            this.caminho = caminho;
            this.custo = custo;
        }
    }
}
