//---------------------------- CLASE MAGO ----------------------------
//Hereda nombre, salud y el método atacar(), igual que Guerrero

//Herencia
public class Mago extends Personaje {

//Atributos propios
    private int mana;
    private int inteligencia;
    private int nivel;


    private String[] hechizosConocidos;
    private int cantidadHechizos;

    private Inventario inventario;

//---------------------------- CONSTRUCTOR ----------------------------
    //Constructor de Mago: escribimos super(nombre, salud) para iniciar sus atributos 
    //propios y herdedados y además, crea su propio Inventario
    public Mago(String nombre, int salud, int mana, int inteligencia, int nivel) {
        this.salud = salud;
        this.nombre = nombre;
        this.mana = mana;
        this.inteligencia = inteligencia;
        this.nivel = nivel;
        this.hechizosConocidos = new String[10]; //Hasta 10 hechizos
        this.cantidadHechizos = 0;
        this.inventario = new Inventario(10);
    }



//---------------------------- APRENDER HECHIZO ----------------------------
    //Metodo para agregar un hechizo nuevo al array de hechizos conocidos
    public void aprenderHechizo(String hechizo) {
        if (cantidadHechizos < hechizosConocidos.length) {
            hechizosConocidos[cantidadHechizos] = hechizo;
            cantidadHechizos++;
            System.out.println(getNombre() + " ha aprendido el hechizo: " + hechizo);
        } else {
            System.out.println(getNombre() + " ya no puede aprender más hechizos (límite alcanzado).");
        }
    }


//---------------------------- RECUPERAR MANÁ ----------------------------
    //Recupera una cantidad fija de maná
    public void recuperarMana() {
        int recuperacion = 15;
        this.mana += recuperacion;
        System.out.println(getNombre() + " recupera maná mediante meditación. Maná actual: " + this.mana);
    }


//---------------------------- LANZAR HECHIZO ----------------------------
    //Busca el hechizo en el array y, si lo conoce y tiene maná, lo lanza
    public void lanzarHechizo(String hechizo) {
        int costoMana = 10; //Costo fijo de maná
        boolean conoceHechizo = false;

        for (int i = 0; i < cantidadHechizos; i++) {
            if (hechizosConocidos[i].equals(hechizo)) {
                conoceHechizo = true;
            }
        }

        if (!conoceHechizo) {
            System.out.println(getNombre() + " no conoce el hechizo: " + hechizo);
            return;
        }
        if (mana < costoMana) {
            System.out.println(getNombre() + " no tiene maná suficiente para lanzar " + hechizo);
            return;
        }
        mana -= costoMana;
        System.out.println(getNombre() + " lanza el hechizo " + hechizo
                + ". Maná restante: " + mana);
    }

//---------------------------- INVOCAR ELEMENTO ----------------------------
    //Invoca un elemento gastando maná
    public void invocarElemento(String elemento) {
        int costoMana = 20; //Costo fijo de maná
        if (mana < costoMana) {
            System.out.println(getNombre() + " no tiene maná suficiente para invocar a " + elemento);
            return;
        }
        mana -= costoMana;
        System.out.println(getNombre() + " invoca al elemento " + elemento
                + ". Maná restante: " + mana);
    }


//---------------------------- USAR OBJETO MAGICO ----------------------------
    //Usa un objeto mágico y suma su potencia a la inteligencia
    public void usarObjetoMagico(ObjetoMagico objeto) {
        if (objeto == null) {
            System.out.println("Objeto no valido.");
            return;
        }
        objeto.usar();
        this.inteligencia += objeto.getPotencia();
        System.out.println(getNombre() + " canaliza el poder de " + objeto.getNombre() + " (potencia " + objeto.getPotencia() +
        "). Inteligencia actual: " + this.inteligencia);
    }


//---------------------------- GETTERS Y SETTERS ----------------------------

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

//---------------------------- HECHIZOS CONOCIDOS ----------------------------
    //Devuelve solamente los hechizos que ya fueron aprendidos
    public String[] getHechizosConocidos() {
        String[] resultado = new String[cantidadHechizos];
        for (int i = 0; i < cantidadHechizos; i++) {
            resultado[i] = hechizosConocidos[i];
        }
        return resultado;
    }

//---------------------------- GETTERS Y SETTERS ----------------------------

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public void setHechizosConocidos(String[] hechizosConocidos) {
        this.hechizosConocidos = hechizosConocidos;
    }

    public void setCantidadHechizos(int cantidadHechizos) {
        this.cantidadHechizos = cantidadHechizos;
    }

    public int getCantidadHechizos() {
        return cantidadHechizos;
    }

    public String[] getHechizosConocidosArray() {
        return hechizosConocidos;
    }

    public void setHechizosConocidosArray(String[] hechizosConocidos) {
        this.hechizosConocidos = hechizosConocidos;
    }
}