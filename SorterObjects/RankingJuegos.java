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
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(mapaJuegos.entrySet()); // Convertimos el Map en una lista de 
        // entradas (pares clave-valor) para poder ordenarla
        
        lista.sort(Comparator.comparingInt(// uso el metodo comparingInt para comparar los valores de las entradas del mapa, en este caso las calificaciones de los juegos
            (Map.Entry<String, Integer> e) -> e.getValue()  // obtengo el valor de la entrada(calificacion del juego) y lo comparo con el valor de la otra entrada
        ).reversed());

        lista.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        // recorremos la lista de entradas y mostramos el nombre del juego (clave) y su calificacion (valor)

    }
}
