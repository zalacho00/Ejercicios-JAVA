package SorterObjects;


class Juego implements Comparable<Juego> { // implemento la interfaz comparable para poder comparar los objetos de la clase Juego
                                           // y poder ordenarlos en una lista de juegos
    private String titulo;
    private int calificacion;

    // Constructor
    public Juego(String titulo, int calificacion) {
        this.titulo = titulo;
        this.calificacion = calificacion;
    }

    // Getters
    public String getTitulo(){
        return titulo;
    }
    public int getCalificacion(){
        return calificacion;
    }

    @Override // uso el @Override para indicar que estoy sobreescribiendo el metodo toString() de la clase object
    public String toString(){
        return titulo + "("+calificacion+")";
    }

    // Implemento el metodo compareTo() de la interfaz Comparable para poder comparar los objetos de la clase Juego
    @Override
    public int compareTo(Juego otroJuego){ // 
        return Integer.compare(otroJuego.getCalificacion(), this.calificacion); // comparo las calificaciones de los juegos,  
                        // si el juego actual tiene una calificacion mayor que el otro juego, devuelve un valor negativo, si es menor
                        // devuelve un valor positivo, si son iguales devulve 0. Esto permite ordenar los juegos de mayor a menor
                        // calificacion. Si quisiera ordenarlos de menor a mayor, cambiaria el orden de los parametros en el metodo compareTo()
    }
    
}
