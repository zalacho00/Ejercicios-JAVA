package SorterObjects;

import java.util.*;

public class RankingJuegos {
    public static void main(String[] args) {
        // Creamos un Map con juegos y sus calificaciones
        Map<String, Integer> biblioteca = new HashMap<>();
        biblioteca.put("Stardew Valley", 9);
        biblioteca.put("Skyrim", 10);
        biblioteca.put("Minecraft", 8);
        biblioteca.put("Terraria", 9);
        biblioteca.put("Cyberpunk 2077", 7);

        System.out.println("--- RANKING ORDENADO POR CALIFICACIÓN (DE MAYOR A MENOR) ---");
        mostrarRankingOrdenado(biblioteca);
    }

    public static void mostrarRankingOrdenado(Map<String, Integer> mapaJuegos) {
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(mapaJuegos.entrySet());
        lista.sort(Comparator.comparingInt(
            (Map.Entry<String, Integer> e) -> e.getValue()
        ).reversed());

        lista.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));








        
        // TODO 1: Convierte las entradas del mapa (entrySet) en una ArrayList.
        // Pista: List> lista = new ArrayList<>(mapaJuegos.entrySet());

        // TODO 2: Ordena la lista usando .sort() y un Comparator que compare los valores (getValue())
        // de forma descendente (de mayor a menor).
        // Pista: Puedes usar .comparing(Map.Entry::getValue).reversed()

        // TODO 3: Recorre la lista con un bucle for-each y muestra el título y su nota en consola.
    }
}
