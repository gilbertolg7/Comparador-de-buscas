package com.example.ComparadorDeBusca.service;

import com.example.ComparadorDeBusca.model.ResultadoBusca;

import java.util.*;

public class BuscaProfundidade {

    public static ResultadoBusca encontrar(Map<String, Map<String, Integer>> grafo, String origem, String destino) {
        Stack<NoBusca> pilha = new Stack<>();
        Set<String> visitados = new HashSet<>();
        pilha.push(new NoBusca(List.of(origem), 0));

        int nosExpandidos = 0; // <<<<<< Adicionado

        while (!pilha.isEmpty()) {
            NoBusca noAtual = pilha.pop();
            nosExpandidos++; // <<<<<< Incrementa a cada expansão

            List<String> caminho = noAtual.caminho;
            int custo = noAtual.custo;
            String atual = caminho.get(caminho.size() - 1);

            if (atual.equals(destino)) {
                ResultadoBusca resultado = new ResultadoBusca(caminho, custo);
                resultado.setNosExpandidos(nosExpandidos); // <<<<<< Salva no ResultadoBusca
                return resultado;
            }

            if (!visitados.contains(atual)) {
                visitados.add(atual);
                Map<String, Integer> vizinhos = grafo.getOrDefault(atual, new HashMap<>());
                for (Map.Entry<String, Integer> vizinho : vizinhos.entrySet()) {
                    List<String> novoCaminho = new ArrayList<>(caminho);
                    novoCaminho.add(vizinho.getKey());
                    int novoCusto = custo + vizinho.getValue();
                    pilha.push(new NoBusca(novoCaminho, novoCusto));
                }
            }
        }

        ResultadoBusca resultado = new ResultadoBusca(List.of(), 0);
        resultado.setNosExpandidos(nosExpandidos); // <<<<<< Também no caminho sem sucesso
        return resultado;
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
