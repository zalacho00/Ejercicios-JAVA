package SorterObjects;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class ListaJuegos {
    List<Juego> juegos = new ArrayList<>();

    public ListaJuegos(){
        juegos.add(new Juego("Stardew Valley", 9));
        juegos.add(new Juego("Skyrim", 10));
        juegos.add(new Juego("Minecraft", 8));
        juegos.add(new Juego("Terraria", 9));
    }
    
    public void ordenarPorCalificacion(){
        Collections.sort(juegos); // uso el metodo sort de la clase Collections para ordenar la lista de juegos que fue
        // implementada con la interfaz Comparable en la clase Juego
        for(Juego juego : juegos){
            System.out.println(juego);
        }
    }

    public void ordenarPorTitulo(){
        Collections.sort(juegos, new Comparator<Juego>() { // uso el metodo sort de la clase Collections para ordenar la lista de
            // juegos, pero esta vez uso un Comparator para ordenar por titulo, en este caso hize un new Comparator<Juego>()
            // para crear un objeto anonimo de la interfaz comparator y sobreescribir el metodo compare() para comparar los titulos de los juegos, ya que no implemente la interfaz Comparable en la clase Juego para ordenar por titulo
            @Override
            public int compare(Juego j1, Juego j2) {
                return j1.getTitulo().compareTo(j2.getTitulo());// obtengo el titulo j1 y luego lo comparo con el titulo j2 usando el metodo compareTo()
            }
        });
        for(Juego juego : juegos){
            System.out.println(juego);
        }
    }

    public static void main(String[] args) {
        ListaJuegos lista = new ListaJuegos();
        lista.ordenarPorCalificacion();
        System.out.println("-----");
        lista.ordenarPorTitulo();
    }

}
