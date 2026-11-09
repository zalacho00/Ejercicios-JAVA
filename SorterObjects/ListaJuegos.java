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
        Collections.sort(juegos);
        for(Juego juego : juegos){
            System.out.println(juego);
        }
    }

    public void ordenarPorTitulo(){
        Collections.sort(juegos, new Comparator<Juego>() {
            @Override
            public int compare(Juego j1, Juego j2) {
                return j1.getTitulo().compareTo(j2.getTitulo());
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
