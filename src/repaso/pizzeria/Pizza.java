package repaso.pizzeria;

import java.io.Serializable;
import java.util.Objects;

public class Pizza implements Serializable {
    private static int contadorPizza = 0;
    private int idPizza;
    private String nombre;
    private double precio;

    public Pizza() {
        this.idPizza = ++contadorPizza;
    }

    public Pizza(String nombre, double precio) {
        this();
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getContadorPizza() {
        return contadorPizza;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                " id =" + idPizza +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return contadorPizza == pizza.contadorPizza && idPizza == pizza.idPizza && Double.compare(precio, pizza.precio) == 0 && Objects.equals(nombre, pizza.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contadorPizza, idPizza, nombre, precio);
    }
}
