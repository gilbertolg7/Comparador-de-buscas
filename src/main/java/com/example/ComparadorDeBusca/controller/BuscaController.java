package com.example.ComparadorDeBusca.controller;

import com.example.ComparadorDeBusca.model.GrafoDados;
import com.example.ComparadorDeBusca.model.Heuristica;
import com.example.ComparadorDeBusca.model.ResultadoBusca;
import com.example.ComparadorDeBusca.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/api/busca")
@CrossOrigin(origins = "*") // Ainda permite requisições de qualquer origem (caso use JSON também em outras rotas)
public class BuscaController {

    @GetMapping("/duplo")
    public String buscarAmbosHtml(
            @RequestParam String origem,
            @RequestParam String destino,
            @RequestParam String algoritmo,
            Model model
    ) {
        Map<String, Integer> heuristica = null;
        ResultadoBusca terrestre, aereo;

        switch (algoritmo.toLowerCase()) {
            case "largura" -> {
                terrestre = BuscaLargura.encontrar(GrafoDados.getGrafoRodoviario(), origem, destino);
                aereo = BuscaLargura.encontrar(GrafoDados.getGrafoAereo(), origem, destino);
            }
            case "profundidade" -> {
                terrestre = BuscaProfundidade.encontrar(GrafoDados.getGrafoRodoviario(), origem, destino);
                aereo = BuscaProfundidade.encontrar(GrafoDados.getGrafoAereo(), origem, destino);
            }
            case "uniforme" -> {
                terrestre = BuscaCustoUniforme.encontrar(GrafoDados.getGrafoRodoviario(), origem, destino);
                aereo = BuscaCustoUniforme.encontrar(GrafoDados.getGrafoAereo(), origem, destino);
            }
            case "gulosa" -> {
                heuristica = Heuristica.gerar(destino);
                terrestre = BuscaGulosa.encontrar(GrafoDados.getGrafoRodoviario(), origem, destino, heuristica);
                aereo = BuscaGulosa.encontrar(GrafoDados.getGrafoAereo(), origem, destino, heuristica);
            }
            case "a" -> {
                heuristica = Heuristica.gerar(destino);
                terrestre = BuscaAEstrela.encontrar(GrafoDados.getGrafoRodoviario(), origem, destino, heuristica);
                aereo = BuscaAEstrela.encontrar(GrafoDados.getGrafoAereo(), origem, destino, heuristica);
            }
            default -> throw new IllegalArgumentException("Algoritmo inválido: " + algoritmo);
        }


        model.addAttribute("algoritmo", algoritmo);
        model.addAttribute("origem", origem);
        model.addAttribute("destino", destino);
        model.addAttribute("rodoviario", terrestre);
        model.addAttribute("aereo", aereo);


        return "resultado";
    }
}