import java.util.*;

public class personaje {
    

//Atributos personaje
    private String nombre;
    private int salud;

  
    public personaje(String nombre, int salud) {
        this.nombre = nombre;
        this.salud = salud;
    }
}

//Getters
    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void mostrardatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Salud: " + salud);
    }

    public void atacar() {
        System.out.println(nombre + " está atacando!");
    }

    public static voir main(String[] args) {

    }