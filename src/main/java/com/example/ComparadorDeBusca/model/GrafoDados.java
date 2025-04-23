package com.example.ComparadorDeBusca.model;
import java.util.HashMap;
import java.util.Map;

public class GrafoDados {

    public static Map<String, Map<String, Integer>> grafoRd = new HashMap<>();
    public static Map<String, Map<String, Integer>> grafoAe = new HashMap<>();

    static {

        grafoRd.put("Porto Alegre", Map.of("Florianapolis", 711));
        grafoRd.put("Florianapolis", Map.of("Porto Alegre", 711, "Curitiba", 300));
        grafoRd.put("Curitiba", Map.of("Campo Grande", 991, "São Paulo", 408, "Florianapolis", 300));
        grafoRd.put("Campo Grande", Map.of("Cuiaba", 694, "Curitiba", 991));
        grafoRd.put("São Paulo", Map.of("Rio de Janeiro", 429, "Curitiba", 991,"Belo Horizonte", 586, "Brasília", 1015, "Cuiaba", 1614));
        grafoRd.put("Rio de Janeiro", Map.of("Belo Horizonte", 432, "Espirito Santo", 521, "Sâo Paulo", 429));
        grafoRd.put("Brasília", Map.of("Goiânia", 209,"Belo Horizonte", 716,"Fortaleza", 2207,"São Paulo", 1015,"Palmas", 973,"Manaus", 3491));
        grafoRd.put("Belo Horizonte", Map.of("Rio de Janeiro", 432,"São Paulo", 586,"Brasília", 716));
        grafoRd.put("Cuiabá", Map.of("Porto Velho", 1450,"Brasília", 1133,"Campo Grande", 694,"São Paulo", 1614));
        grafoRd.put("Goiânia", Map.of("Brasília", 209));
        grafoRd.put("Salvador", Map.of("Aracaju", 356,"Rio de Janeiro", 1644,"Fortaleza", 1383));
        grafoRd.put("Palmas", Map.of("Brasília", 973));
        grafoRd.put("Porto Velho", Map.of("Cuiabá", 1450,"Manaus", 901,"Rio Branco", 544));
        grafoRd.put("Rio Branco", Map.of("Porto Velho", 544,"Manaus", 1446));
        grafoRd.put("Macapá", Map.of());
        grafoRd.put("Manaus", Map.of("Porto Velho", 901,"Rio Branco", 1446,"Boa Vista", 785,"Belém", 5191));
        grafoRd.put("Boa Vista", Map.of("Manaus", 785));
        grafoRd.put("Belém", Map.of("Manaus", 5191));
        grafoRd.put("São Luís", Map.of("Fortaleza", 1076));
        grafoRd.put("Teresina", Map.of("Fortaleza", 634));
        grafoRd.put("Fortaleza", Map.of( "São Luís", 1076,"Teresina", 634,"Brasília", 2207,"Salvador", 1383,"Recife", 800,"Natal", 537));
        grafoRd.put("Natal", Map.of("Fortaleza", 537,"João Pessoa", 185,"Salvador", 1146));
        grafoRd.put("João Pessoa", Map.of("Recife", 120,"Natal", 185));
        grafoRd.put("Recife", Map.of("João Pessoa", 120,"Fortaleza", 800,"Maceió", 285));
        grafoRd.put("Maceió", Map.of("Aracaju", 294,"Recife", 285));
        grafoRd.put("Aracaju", Map.of("Maceió", 294,"Salvador", 356));


        grafoAe.put("Porto Alegre", Map.of("Florianapolis", 328));
        grafoAe.put("Florianapolis", Map.of("Porto Alegre", 328, "Curitiba", 251));
        grafoAe.put("Curitiba", Map.of("Campo Grande", 570, "São Paulo", 339, "Florianapolis", 251));
        grafoAe.put("Campo Grande", Map.of("Cuiaba", 549, "Curitiba", 570));
        grafoAe.put("São Paulo", Map.of("Rio de Janeiro", 361, "Curitiba", 339, "Belo Horizonte", 490, "Brasília", 874, "Cuiaba", 1211));
        grafoAe.put("Rio de Janeiro", Map.of("Belo Horizonte", 362, "Espirito Santo", 418, "São Paulo", 361));
        grafoAe.put("Brasília", Map.of("Goiânia", 153, "Belo Horizonte", 624, "Fortaleza", 1687, "São Paulo", 874, "Palmas", 603, "Manaus", 1932));
        grafoAe.put("Belo Horizonte", Map.of("Rio de Janeiro", 362, "São Paulo", 490, "Brasília", 624));
        grafoAe.put("Cuiabá", Map.of("Porto Velho", 1180, "Brasília", 873, "Campo Grande", 549, "São Paulo", 1211));
        grafoAe.put("Goiânia", Map.of("Brasília", 153));
        grafoAe.put("Salvador", Map.of("Aracaju", 320, "Rio de Janeiro", 1213, "Fortaleza", 1025));
        grafoAe.put("Palmas", Map.of("Brasília", 603));
        grafoAe.put("Porto Velho", Map.of("Cuiabá", 1180, "Manaus", 761, "Rio Branco", 435));
        grafoAe.put("Rio Branco", Map.of("Porto Velho", 435, "Manaus", 1143));
        grafoAe.put("Macapá", Map.of("Belem", 327));
        grafoAe.put("Manaus", Map.of("Porto Velho", 761, "Rio Branco", 1143, "Boa Vista", 653, "Belém", 1301));
        grafoAe.put("Boa Vista", Map.of("Manaus", 653));
        grafoAe.put("Belém", Map.of("Manaus", 1301,  "Macapá", 327));
        grafoAe.put("São Luís", Map.of("Fortaleza", 818));
        grafoAe.put("Teresina", Map.of("Fortaleza", 605));
        grafoAe.put("Fortaleza", Map.of("São Luís", 818, "Teresina", 605, "Brasília", 1687, "Salvador", 1025, "Recife", 628, "Natal", 435));
        grafoAe.put("Natal", Map.of("Fortaleza", 435, "João Pessoa", 150, "Salvador", 1020));
        grafoAe.put("João Pessoa", Map.of("Recife", 112, "Natal", 150));
        grafoAe.put("Recife", Map.of("João Pessoa", 112, "Fortaleza", 628, "Maceió", 234));
        grafoAe.put("Maceió", Map.of("Aracaju", 200, "Recife", 234));
        grafoAe.put("Aracaju", Map.of("Maceió", 200, "Salvador", 320));
    }

    public static Map<String, Map<String, Integer>> getGrafoRodoviario() {
        return grafoRd;
    }

    public static Map<String, Map<String, Integer>> getGrafoAereo() {
        return grafoAe;
    }
}