package repaso.advanced.videoclub.movies;

import java.util.ArrayList;
import java.util.List;

public class Movies {

    private static final List<Movie> movies;

    static {
        movies = new ArrayList<>();
        movies.add(new Movie("The Lion King", 1994));
        movies.add(new Movie("Matrix", 2000));
        movies.add(new Movie("Napoleon", 2023));
        movies.add(new Movie("2001 Odisey of Space", 1973));
    }
    
    public void addMovie(Movie movie){
        movies.add(movie);
    }
    
    public void viewMovies(){
        String availableMovies = "";
        System.out.println("----- Movies available -----");
        for (Movie movie :  movies) {
            availableMovies += movie.toString() + "\n";
        }
        System.out.println(availableMovies);
    }
    
    public List<Movie> getMovie(){
        return movies;
    }
}
