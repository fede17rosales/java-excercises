package repaso.videoclub.peliculas;

import java.util.ArrayList;
import java.util.List;

public class Peliculas {

    private static final List<Pelicula> peliculas;

    static {
        peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("El rey Leon", 1994));
        peliculas.add(new Pelicula("Matrix", 2000));
        peliculas.add(new Pelicula("Napoleon", 2023));
        peliculas.add(new Pelicula("La Naranja Mecanica", 1973));
    }
    
    public void agregarPelicula(Pelicula pelicula){
        peliculas.add(pelicula);
    }
    
    public void mostrarPelicula(){
        String peliculasDisponibles = "";
        System.out.println("----- Peliculas Disponibles -----");
        for (Pelicula pelicula :  peliculas) {
            peliculasDisponibles += pelicula.toString() + "\n";
        }
        System.out.println(peliculasDisponibles);
    }
    
    public List<Pelicula> getPeliculas(){
        return peliculas;
    }
}
