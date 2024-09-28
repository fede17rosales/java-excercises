package repaso.videoclub.cartelera;


import repaso.videoclub.peliculas.Pelicula;
import repaso.videoclub.peliculas.Peliculas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cartelera {

    public void verCartelera(){
        boolean salir = false;
        Scanner consola = new Scanner(System.in);
        List<Pelicula> peliculas = new ArrayList<>();
        while(!salir){
            try{
                int opcion = verOpciones(consola);
                salir = verMenu(opcion, consola, peliculas);
            }catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            } finally {
                System.out.println();
            }

        }

    }


    private int verOpciones(Scanner consola){
        System.out.print("""
                        BIENVENIDO AL VIDEOCLUB
                        1 - Alquilar una Pelicula
                        2 - Mostrar Orden
                        3 - Agregar una Pelicula
                        4 - Salir 
                        Elige una Opcion:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean verMenu(int opcion, Scanner consola, List<Pelicula> peliculas){
        boolean salir = false;
        switch (opcion){
             case 1 -> alquilarPelicula(consola, peliculas);
             case 2 -> mostrarOrden(peliculas);
             case 3 -> agregarPelicula(consola);
            case 4 -> {
                System.out.println("Gracias Vuelva Pronto !!!");
                salir = true;
            }
            default -> System.out.println("La opcion ingresada no es correcta: " + opcion);
        }
        return salir;
    }

    private static void alquilarPelicula(Scanner consola, List<Pelicula> productos){
        System.out.println("Por favor ingresa un id para la pelicula: ");
        int idPelicula = Integer.parseInt(consola.nextLine());
        Peliculas peliculas = new Peliculas();
        boolean idEncontrado = false;
        for(Pelicula p : peliculas.getPeliculas()){
            if(idPelicula == p.getIdPelicula()){
                productos.add(p);
                idEncontrado = true;
                System.out.println("La pelicula se ha agregado correctamente al carrito!: " + productos);
                break;
            }
        }
        if(!idEncontrado){
            System.out.println("La pelicula no podido agregarse, el id no corresponde: " + idPelicula);
        }
    }

    private static void mostrarOrden(List<Pelicula> peliculas){
        System.out.println("------ Orden de Peliculas alquiladas ------");
        String orden = "";
        for (Pelicula p: peliculas) {
            orden += "Pelicula: " + p.getNombre() + ", Año: " + p.getAnio() + "\n";
        }
        System.out.println(orden);
    }

    private static void agregarPelicula(Scanner consola){
        System.out.println("Ingresar nombre de la pelicula: ");
        String nombre = consola.nextLine();
        System.out.println("Ingresar año de la pelicula: ");
        int anio = Integer.parseInt(consola.nextLine());
        Peliculas peliculas = new Peliculas();
        peliculas.agregarPelicula(new Pelicula(nombre,anio));
        System.out.println("Pelicula Agregada correctamente !");
        peliculas.mostrarPelicula();
    }
}


