package repaso.advanced.videoclub.billboard;


import repaso.advanced.videoclub.movies.Movie;
import repaso.advanced.videoclub.movies.Movies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Billboard {

    public void viewBillboard(){
        boolean exit = false;
        Scanner console = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();
        while(!exit){
            try{
                int option = viewOptions(console);
                exit = viewMenu(option, console, movies);
            }catch (Exception e) {
                System.out.println("An error has occurred: " + e.getMessage());
            } finally {
                System.out.println();
            }

        }

    }


    private int viewOptions(Scanner consola){
        System.out.print("""
                        WELCOME !!!!
                        1 - Rent a Movie
                        2 - View my Order
                        3 - Add a Movie
                        4 - Exit
                        Choice a number:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean viewMenu(int opcion, Scanner consola, List<Movie> products){
        boolean exit = false;
        switch (opcion){
             case 1 -> rentMovie(consola, products);
             case 2 -> viewOrder(products);
             case 3 -> addMovieToBillboard(consola);
            case 4 -> {
                System.out.println("Thanks for comming!!!");
                exit = true;
            }
            default -> System.out.println("The option input is not correct: " + opcion);
        }
        return exit;
    }

    private static void rentMovie(Scanner console, List<Movie> products){
        System.out.println("Please input the idMovie: ");
        int idMovie = Integer.parseInt(console.nextLine());
        Movies movies = new Movies();
        boolean idFind = false;
        for(Movie movie : movies.getMovie()){
            if(idMovie == movie.getIdMovie()){
                products.add(movie);
                idFind = true;
                System.out.println("The movie added successfully! : " + products);
                break;
            }
        }
        if(!idFind){
            System.out.println("The movie could not be added, the id does not correspond: " + idMovie);
        }
    }

    private static void viewOrder(List<Movie> products){
        System.out.println("------ Movie's Order ------");
        String order = "";
        for (Movie movie: products) {
            order += "Movie: " + movie.getName() + ", year: " + movie.getYear() + "\n";
        }
        System.out.println(order);
    }

    private static void addMovieToBillboard(Scanner consola){
        System.out.println("Input the name of movie: ");
        String name = consola.nextLine();
        System.out.println("Input the year of movie: ");
        int year = Integer.parseInt(consola.nextLine());
        Movies movies = new Movies();
        movies.addMovie(new Movie(name,year));
        System.out.println("Movie added successfully !");
        movies.viewMovies();
    }
}


