//---------------------------- CLASE GUERRERO ----------------------------

//Hereda nombre, salud y el método atacar().
//Solo agrega lo propio del Guerrero: fuerza, defensa, nivel y sus habilidades de espada.

//Herencia
public class Guerrero extends Personaje {

    //Atributos propios
    private int fuerza;
    private int defensa;
    private int nivel;

    //Mascota
    private Mascota mascota;

/*Constructor de Guerrero: primero ponemos super(nombre, salud) para inicia lo que viene de Personaje
y después inicia los atributos propios. */

    public Guerrero(String nombre, int salud, int fuerza, int defensa, int nivel) {
        super(nombre, salud);
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.nivel = nivel;
        this.mascota = null; //Al principio no tiene mascota por lo que debe ser null
    }

//---------------------------- ATAQUE DE ESPADA ----------------------------
//El daño depende de la fuerza y el nivel

    public void usarEspada(Personaje objetivo) {
        if (objetivo == null) {
            System.out.println("No hay objetivo para atacar con la espada.");
            return;
        }
        //El daño que le va a hacer es igual a fuerza sumado al nivel
        int danio = fuerza + nivel;
        int saludRestante = objetivo.getSalud() - danio;
        objetivo.setSalud(saludRestante); //Actualiza la salud del objetivo después del ataque

        System.out.println(getNombre() + " usa su espada contra " + objetivo.getNombre() + " infligiendo " + danio + 
        " de daño. Salud restante de " + objetivo.getNombre() + ": " + objetivo.getSalud());
        //Actualiza la salud del objetivo después del ataque
    }

    
//---------------------------- GRITAR DESAFIO ----------------------------
    //Aumenta la defensa temporalmente y llama la atención de los enemigos
    public void gritarDesafio() {
        int incremento = 5;
        this.defensa += incremento;
        System.out.println(getNombre() + " grita desafío. Su defensa aumenta temporalmente en "
                + incremento + " puntos (defensa actual: " + this.defensa
                + "). Los enemigos centran sus ataques en él.");
    }


//---------------------------- GRITAR GUERRA ----------------------------
//Aumenta la fuerza temporalmente
    public void gritarGuerra() {
        int incremento = 5;
        this.fuerza += incremento;
        System.out.println(getNombre() + " emite un grito de guerra. Su fuerza aumenta temporalmente en "
                + incremento + " puntos (fuerza actual: " + this.fuerza + ").");
    }

//---------------------------- ASIGNAR MASCOTA ----------------------------
//Une una mascota a este Guerrero

    public void asignarMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Mascota getMascota() {
        return mascota;
    }

//---------------------------- GETTERS Y SETTERS ----------------------------

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
