package repaso.pizzeria;

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

    public static void agregarPizza(Pizza pizza){
            pizzas.add(pizza);
    }
    public static void mostrarPizzeria(){
        var inventario = "";
        for (Pizza p: pizzas) {
            inventario += p.toString() + "\n";
        }
        System.out.println("-------- Pizzas Inventario --------");
        System.out.println(inventario);

    }

    public static List<Pizza> getPizzas(){
        return pizzas;
    }

}

