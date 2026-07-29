//---------------------------- CLASE PERSONAJE ----------------------------
//Guerrero y Mago heredan nombre, salud y el metodo atacar() de esta clase.

public class Personaje {

//Atributos propios
    private String nombre;
    private int salud;

    //Daño que usa el ataque básico (mismo valor para guerrero y mago)
    private static final int danioBase = 10;


//---------------------------- CONSTRUCTOR ----------------------------
//Guerrero y Mago lo ejecutan con super

    public Personaje(String nombre, int salud) {
        this.nombre = nombre;
        this.salud = salud;
    }


//---------------------------- METODO ATACAR ----------------------------
    public void atacar(Personaje objetivo) {
        if (objetivo == null) {
            System.out.println("No hay objetivo para atacar.");
            return;
        }
        int saludRestante = objetivo.getSalud() - danioBase;
        objetivo.setSalud(saludRestante);
        System.out.println(this.nombre + " ataca a " + objetivo.getNombre() + " infligiendo " + danioBase +
        " de daño base. Salud restante de " + objetivo.getNombre() + ": " + objetivo.getSalud());
    }


//---------------------------- GETTERS Y SETTERS ----------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        // La salud nunca puede quedar en negativo
        if (salud < 0) {
            salud = 0;
        }
        this.salud = salud;
    }
}
