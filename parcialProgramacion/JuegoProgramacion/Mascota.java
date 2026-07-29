//---------------------------- CLASE MASCOTA ----------------------------

//Va unida a un Guerrero (mascota acompaña a guerrero)
//Un Guerrero puede tener 0 o 1 Mascota, y la Mascota siempre pertenece a un Guerrero.

public class Mascota {

//Atributos propios
    private String nombre;
    private int lealtad;
    private Guerrero guerrero; // dueño de la mascota

//---------------------------- CONSTRUCTOR ----------------------------
//El Menu verifica antes de llamar aca que exista un Guerrero y que ese Guerrero no tenga otra Mascota asignada.
    public Mascota(String nombre, int lealtad, Guerrero guerrero) {
        this.nombre = nombre;
        this.lealtad = lealtad;
        this.guerrero = guerrero;
        if (guerrero != null) {
            this.guerrero.asignarMascota(this); //Asigna la mascota al guerrero 
        }
    }


//---------------------------- ACOMPAÑAR GUERRERO ----------------------------
    //Mientras acompaña al Guerrero, le da un bonus de defensa según su lealtad
    public void acompanar() {
        int bonus = lealtad / 10;
        guerrero.setDefensa(guerrero.getDefensa() + bonus);
        System.out.println(nombre + " acompaña a " + guerrero.getNombre() + " y le otorga +" + bonus + " de defensa según su lealtad ("
                + lealtad + "). Defensa actual de " + guerrero.getNombre() + ": " + guerrero.getDefensa());
    }


//---------------------------- GETTERS Y SETTERS ----------------------------

    public int getLealtad() {
        return lealtad;
    }

    public void setLealtad(int valor) {
        this.lealtad = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Guerrero getGuerrero() {
        return guerrero;
    }

    public void setGuerrero(Guerrero guerrero) {
        this.guerrero = guerrero;
    }
}
