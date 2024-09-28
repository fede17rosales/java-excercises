package repaso.advanced.videoclub.movies;

import java.io.Serializable;
import java.util.Objects;

public class Movie implements Serializable {
    private static int countMovie = 0;
    private int idMovie;
    private String name;
    private int year;

    public Movie() {
        this.idMovie = ++countMovie;
    }

    public Movie(String name, int year) {
        this();
        this.name = name;
        this.year = year;
    }

    public static int getCountMovie() {
        return countMovie;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  idMovie + "" +
                "- '" + name + '\'' +
                ", " + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return idMovie == movie.idMovie && year == movie.year && Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMovie, name, year);
    }
}
