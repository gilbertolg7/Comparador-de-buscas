package com.example.ComparadorDeBusca.model;

import java.util.List;

public class ResultadoBusca {
    private final List<String> caminho;
    private final int custoTotal;

    public ResultadoBusca(List<String> caminho, int custoTotal) {
        this.caminho = caminho;
        this.custoTotal = custoTotal;
    }

    public List<String> getCaminho() {
        return caminho;
    }

    public int getCustoTotal() {
        return custoTotal;
    }

    @Override
    public String toString() {
        return "Caminho: " + caminho + ", Custo Total: " + custoTotal;
    }
}