package repaso.advanced.pizzeria.menu;

import repaso.advanced.pizzeria.pizzas.Pizza;
import repaso.advanced.pizzeria.pizzas.Pizzas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public void pizzeria() {
        var exit = false;
        var console = new Scanner(System.in);
        // Creamos la lista de producto de tipo Snack
        List<Pizza> products = new ArrayList<>();
        System.out.println("*** Maquina de Snacks ***");
        // mostrar inventario de snacks disponible
        while (!exit) {
            try {
                var option = viewMenu(console);
                exit = executeOptions(option, console, products);
            } catch (Exception e) {
                System.out.println("An error occurred: " + e);
            } finally {
                System.out.println(); // imprime un salto de linea con cada iteracion
            }
        }
    }

    private int viewMenu(Scanner consola) {
        System.out.print("""
                Menu:
                1. Pay Pizza
                2. View Ticket
                3. Add new Pizza
                4. Exit
                Choice an Option:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private boolean executeOptions(int option, Scanner console, List<Pizza> pizzas) {
        var exit = false;
        switch (option) {
             case 1 -> payPizza(console, pizzas);
             case 2 -> viewTicket(pizzas);
             case 3 -> addNewPizza(console);
            case 4 -> {
                System.out.println("Thanks for lunch with us!");
                exit = true;
            }
            default -> System.out.println("Ivalidate Option: " + option);
        }

        return exit;
    }

    private static void payPizza(Scanner console, List<Pizza> products){
        System.out.print("What's Pizza desire?(Choice of 1 at 10):");
        var idPizza = Integer.parseInt(console.nextLine());
        // validamos que exista la pizza
        var idPizzaFound = false;
        for (var pizza : Pizzas.getPizzas()){
            if(idPizza == pizza.getIdPizza()){
                products.add(pizza);
                System.out.println("Ok, Pizza added: " + products);
                idPizzaFound = true;
                break;
            }
        }
    if(!idPizzaFound){
        System.out.println("Pizza not found: " + idPizza);
    }
    }

    public static void viewTicket(List<Pizza> pizzas){
        String ticket = "*** Ticket ***";
        double total = 0.0;
        for (Pizza pizza: pizzas) {
            ticket += "\n\t Pizza: " + pizza.getName() + ", Price: $" + pizza.getPrice() + "\n";
            System.out.println(ticket);
            total += pizza.getPrice();
        }
        System.out.println("-------------- Details of Order-----------------");
        System.out.println("\n\t The total of order is: " + total);
    }

    private static void addNewPizza(Scanner consola){
        System.out.println("Input the name: ");
        var name = consola.nextLine();
        System.out.println("Input the price: ");
        var price = Double.parseDouble(consola.nextLine());
        Pizzas.addPizza(new Pizza(name,price));
        System.out.println("The pizza was added correctly.");
        Pizzas.viewCatalog();
    }
}
