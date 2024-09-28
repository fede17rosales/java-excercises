package repaso.pizzeria.utils;

import repaso.pizzeria.Pizza;
import repaso.pizzeria.Pizzas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public void pizzeria() {
        var salir = false;
        var consola = new Scanner(System.in);
        // Creamos la lista de producto de tipo Snack
        List<Pizza> productos = new ArrayList<>();
        System.out.println("*** Maquina de Snacks ***");
        // mostrar inventario de snacks disponible
        while (!salir) {
            try {
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e);
            } finally {
                System.out.println(); // imprime un salto de linea con cada iteracion
            }
        }
    }

    private int mostrarMenu(Scanner consola) {
        System.out.print("""
                Menu:
                1. Comprar Pizza
                2. Mostrar Ticket
                3. Agregar nueva Pizza
                4. Salir
                Elige una opcion:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private boolean ejecutarOpciones(int opcion, Scanner consola, List<Pizza> pizzas) {
        var salir = false;
        switch (opcion) {
             case 1 -> comprarPizza(consola, pizzas);
             case 2 -> mostrarTicket(pizzas);
             case 3 -> agregarPizza(consola);
            case 4 -> {
                System.out.println("Regresa Pronto!");
                salir = true;
            }
            default -> System.out.println("Opcion invalida: " + opcion);
        }

        return salir;
    }

    private static void comprarPizza(Scanner consola,List<Pizza> productos){
        System.out.print("Que pizza quieres comprar?(Selecciona del 1 al 10):");
        var idPizza = Integer.parseInt(consola.nextLine());
        // validamos que exista la pizza
        var pizzaEncontrada = false;
        for (var pizza : Pizzas.getPizzas()){
            if(idPizza == pizza.getIdPizza()){
                productos.add(pizza);
                System.out.println("Ok, Pizza agregada: " + productos);
                pizzaEncontrada = true;
                break;
            }
        }
    if(!pizzaEncontrada){
        System.out.println("id de pizza no encontrado: " + idPizza);
    }
    }

    public static void mostrarTicket(List<Pizza> pizzas){
        String ticket = "*** Ticket de venta ***";
        double total = 0.0;
        for (Pizza p: pizzas) {
            ticket += "\n\t Pizza: " + p.getNombre() + ", Precio: $" + p.getPrecio() + "\n";
            System.out.println(ticket);
            total += p.getPrecio();
        }
        System.out.println("--------------El detalle de la compra es-----------------");
        System.out.println("\n\t El total es: " + total);
    }

    private static void agregarPizza(Scanner consola){
        System.out.println("Ingrese el nombre: ");
        var nombre = consola.nextLine();
        System.out.println("Ingrese el precio: ");
        var precio = Double.parseDouble(consola.nextLine());
        Pizzas.agregarPizza(new Pizza(nombre,precio));
        System.out.println("La pizza se agrego correctamente");
        Pizzas.mostrarPizzeria();
    }
}
