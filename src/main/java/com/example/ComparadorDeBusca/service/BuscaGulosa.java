package com.example.ComparadorDeBusca.service;

import com.example.ComparadorDeBusca.model.Node;
import com.example.ComparadorDeBusca.model.ResultadoBusca;

import java.util.*;

public class BuscaGulosa {

    public static ResultadoBusca encontrar(Map<String, Map<String, Integer>> grafo, String origem, String destino, Map<String, Integer> heuristica) {
        PriorityQueue<Node> fila = new PriorityQueue<>(Comparator.comparingInt(n -> heuristica.getOrDefault(n.nome, 0)));
        fila.add(new Node(origem, List.of(origem), 0));
        Set<String> visitados = new HashSet<>();

        int nosExpandidos = 0; // <<<<<< Adicionado

        while (!fila.isEmpty()) {
            Node atual = fila.poll();
            nosExpandidos++; // <<<<<< Incrementa a cada expansão

            if (atual.nome.equals(destino)) {
                ResultadoBusca resultado = new ResultadoBusca(atual.caminho, atual.custo);
                resultado.setNosExpandidos(nosExpandidos); // <<<<<< Salva no resultado
                return resultado;
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

        ResultadoBusca resultado = new ResultadoBusca(List.of(), 0);
        resultado.setNosExpandidos(nosExpandidos); // <<<<<< Também salva se não encontrar caminho
        return resultado;
    }
}
