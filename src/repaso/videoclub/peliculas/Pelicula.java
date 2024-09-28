package repaso.videoclub.peliculas;

import java.io.Serializable;
import java.util.Objects;

public class Pelicula implements Serializable {
    private static int contadorDePelicula = 0;
    private int idPelicula;
    private String nombre;
    private int anio;

    public Pelicula() {
        this.idPelicula = ++contadorDePelicula;
    }

    public Pelicula(String nombre, int anio) {
        this();
        this.nombre = nombre;
        this.anio = anio;
    }

    public static int getContadorDePelicula() {
        return contadorDePelicula;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return  idPelicula + ")" +
                "- '" + nombre + '\'' +
                ", " + anio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return idPelicula == pelicula.idPelicula && anio == pelicula.anio && Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, nombre, anio);
    }
}
