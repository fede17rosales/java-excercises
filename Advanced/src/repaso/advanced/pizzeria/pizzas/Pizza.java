package repaso.advanced.pizzeria.pizzas;

import java.io.Serializable;
import java.util.Objects;

public class Pizza implements Serializable {
    private static int countPizza = 0;
    private int idPizza;
    private String name;
    private double price;

    public Pizza() {
        this.idPizza = ++countPizza;
    }

    public Pizza(String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }

    public int getContadorPizza() {
        return countPizza;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                idPizza +
                "- , '" + name + '\'' +
                ", $" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return countPizza == pizza.countPizza && idPizza == pizza.idPizza && Double.compare(price, pizza.price) == 0 && Objects.equals(name, pizza.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countPizza, idPizza, name, price);
    }
}
