//---------------------------- CLASE INVENTARIO ----------------------------
//No hereda nada, es clase independiente.


public class Inventario {

    private int capacidad;
    private String[] items;
    private int cantidadActual;


//Constructor de inventario: recibe la capacidad máxima dada por el usuario y reserva el array de ese tamaño
    public Inventario(int capacidad) {
        this.capacidad = capacidad;
        this.items = new String[capacidad];
        this.cantidadActual = 0;
    }

//Si hay espacio, agrega el ítem. Si no, avisa que está lleno.
    public void agregarItem(String item) {
        if (cantidadActual < capacidad) {
            items[cantidadActual] = item;
            cantidadActual++;
            System.out.println("Ítem " + item + " agregado al inventario (" + cantidadActual + "/" + capacidad + ").");
        } else {
            System.out.println("Inventario lleno. No se pudo agregar " + item + ".");
        }
    }

//Devuelve un array solamente con los ítems que ya fueron cargados
    public String[] consultarInventario() {
        String[] itemsActuales = new String[cantidadActual];
        for (int i = 0; i < cantidadActual; i++) {
            itemsActuales[i] = items[i];
        }
        return itemsActuales;
    }


//---------------------------- GETTERS Y SETTERS ----------------------------

    public int getCapacidad() {
        return capacidad;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }
    public String[] getItems() {
        return items;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setItems(String[] items) {
        this.items = items;
    }
    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
}
