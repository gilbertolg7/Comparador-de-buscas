package com.example.ComparadorDeBusca.service;

import java.util.*;

import com.example.ComparadorDeBusca.model.Node;
import com.example.ComparadorDeBusca.model.ResultadoBusca;

public class BuscaCustoUniforme {
    public static ResultadoBusca encontrar(Map<String, Map<String, Integer>> grafo, String origem, String destino) {
        PriorityQueue<Node> fila = new PriorityQueue<>(Comparator.comparingInt(n -> n.custo));
        fila.add(new Node(origem, List.of(origem), 0));
        Set<String> visitados = new HashSet<>();

        int nosExpandidos = 0; // <<<<<< Adicionado

        while (!fila.isEmpty()) {
            Node atual = fila.poll();
            nosExpandidos++; // <<<<<< Incrementa ao expandir um nó

            if (atual.nome.equals(destino)) {
                ResultadoBusca resultado = new ResultadoBusca(atual.caminho, atual.custo);
                resultado.setNosExpandidos(nosExpandidos); // <<<<<< Salva a quantidade de nós expandidos
                return resultado;
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

        ResultadoBusca resultado = new ResultadoBusca(List.of(), 0);
        resultado.setNosExpandidos(nosExpandidos); // <<<<<< Também para quando não encontra caminho
        return resultado;
    }
}
