package repaso.advanced.pizzeria.pizzas;

import java.util.ArrayList;
import java.util.List;

public class Pizzas {
    private static final List<Pizza> pizzas;
    
    static {
        pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Comun", 100.00));
        pizzas.add(new Pizza("Napolitana", 120.00));
        pizzas.add(new Pizza("Calabresa", 130.00));

    }

    public static void addPizza(Pizza pizza){
            pizzas.add(pizza);
    }
    public static void viewCatalog(){
        var listPizzas = "";
        for (Pizza pizza: pizzas) {
            listPizzas += pizza.toString() + "\n";
        }
        System.out.println("-------- Pizzas available --------");
        System.out.println(listPizzas);

    }

    public static List<Pizza> getPizzas(){
        return pizzas;
    }

}

