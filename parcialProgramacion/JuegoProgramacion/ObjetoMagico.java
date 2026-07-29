//---------------------------- CLASE OBJETO MAGICO ----------------------------
//No hereda nada

public class ObjetoMagico {

//Atributos propios
    private String nombre;
    private String tipo;
    private int potencia;
    private int durabilidad;


//---------------------------- CONSTRUCTOR ----------------------------
    public ObjetoMagico(String nombre, String tipo, int potencia, int durabilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.potencia = potencia;
        this.durabilidad = durabilidad;
    }

//---------------------------- USAR OBJETO MAGICO ----------------------------
    //Gasta durabilidad al usarse. Si llega a 0, hay que repararlo.

    public void usar() { //Método para usar el objeto mágico
        if (durabilidad <= 0) { //El objeto mágico está inutilizable
            System.out.println(nombre + " está inutilizable. Debe repararse antes de usarse."); 
            return;
        }//Verifica si la durabilidad es 0 o menor
        durabilidad--; //Decrementa la durabilidad en 1
        System.out.println(nombre + " libera su efecto mágico (potencia " + potencia
                + "). Durabilidad restante: " + durabilidad); //Muestra el efecto mágico y la durabilidad restante
    }


//---------------------------- REPARA OBJETO MAGICO ----------------------------
    //Restaura la durabilidad a su valor máximo

    public void reparar() {
        this.durabilidad = 10; //valor máximo
        System.out.println(nombre + " ha sido reparado. Durabilidad restaurada a " + durabilidad + ".");
    }


//---------------------------- GETTERS Y SETTERS ----------------------------

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDurabilidad() {
        return durabilidad;
    }

    public void setDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
    }
}
