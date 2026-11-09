package SorterObjects;


class Juego implements Comparable<Juego> {
    private String titulo;
    private int calificacion;

    public Juego(String titulo, int calificacion) {
        this.titulo = titulo;
        this.calificacion = calificacion;
    }

    public String getTitulo(){
        return titulo;
    }
    public int getCalificacion(){
        return calificacion;
    }

    @Override
    public String toString(){
        return titulo + "("+calificacion+")";
    }

    @Override
    public int compareTo(Juego otroJuego){
        return Integer.compare(otroJuego.getCalificacion(), this.calificacion);
    }
    
}
