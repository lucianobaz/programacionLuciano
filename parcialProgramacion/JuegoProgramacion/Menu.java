import java.util.Scanner;

//Clase Menu
/* Este es el Main. No hereda ni es heredada por nadie: es la clase "controladora" que crea y conecta a todas las demás (Personaje, Guerrero,
Mago, Mascota, Inventario, ObjetoMagico) a través de arrays estáticos de tamaño fijo. Todo Menu es "static" porque no tiene sentido 
crear más de un Menu: es el programa en sí. */

public class Menu {

    private static Scanner sc = new Scanner(System.in);

    //Guardamos las entidades en arrays de tamaño fijo
    //Los guerreros, los magos, las mascotas, los objetos magicos, etc pueden tener hasta 50 elementos
    private static final int MAX = 50;

//para que no se pueda llamar desde el main
//private encapsula la variable para que no se altere afuera de su clase

    private static Guerrero[] guerreros = new Guerrero[MAX];
    private static int cantidadGuerreros = 0;

    private static Mago[] magos = new Mago[MAX];
    private static int cantidadMagos = 0;

    private static Mascota[] mascotas = new Mascota[MAX];
    private static int cantidadMascotas = 0;

    
    private static ObjetoMagico[] objetosMagicos = new ObjetoMagico[MAX];
    private static int cantidadObjetos = 0;

//HECHIZOS PRECARGADOS: el usuario no los escribe, solo los selecciona de la lista
//Usamos final por que los mismos no pueden cambiar
    private static final String[] hechizosDisponibles = {
            "Bola de Fuego", "Rayo Helado", "Escudo Arcano", "Lluvia de Meteoros",
            "Curación Menor", "Descarga Eléctrica", "Niebla Envenenada"
    };
//ELEMENTOS PRECARGADOS
    private static final String[] elementosDisponibles = {
            "Fuego", "Agua", "Tierra", "Aire", "Rayo", "Hielo", "Sombra"
    };

    public static void main(String[] args) {
        int opcion;
        do {
            //Llamamos al menu
            mostrarMenu();
            //Abajo del menu se va a mostrar este texto que pide seleccionar una opcion
            System.out.print("Seleccione una opción: ");
            //Segun la opcion que el usuario elija se guarda
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearGuerrero();
                    break;
                case 2:
                    crearMago();
                    break;
                case 3:
                    crearMascota();
                    break;
                case 4:
                    crearObjetoMagico();
                    break;
                case 5:
                    gestionarInventario();
                    break;
                case 6:
                    accionesGuerrero();
                    break;
                case 7:
                    accionesMago();
                    break;
                case 8:
                    repararObjetoMagico();
                    break;
                case 9:
                    mascotaAcompana();
                    break;
                case 10:
                    listarEntidades();
                    break;
                case 11:
                    modificarNombre();
                    break;
                case 0:
                    System.out.println("Saliendo del Juego.");
                    break;
                default:
                    System.out.println("Opción inválida. Seleccione una de las opciones disponibles.");
            }
            System.out.println();
        } while (opcion != 0);

        sc.close();
    }

    //Funcion para mostrar menu
    private static void mostrarMenu() {
        System.out.println("========================================");
        System.out.println("    JUEGO DE ROL - MENU DE OPCIONES");
        System.out.println("========================================");
        System.out.println("1. Crear Guerrero");
        System.out.println("2. Crear Mago");
        System.out.println("3. Crear Mascota (Guerrero requerido)");
        System.out.println("4. Crear Objeto Mágico");
        System.out.println("5. Gestionar Inventario (Mago requerido)");
        System.out.println("6. Acciones de Guerrero (espada, desafío, grito de guerra, ataque básico)");
        System.out.println("7. Acciones de Mago (maná, hechizos, invocar, usar objeto mágico, ataque básico)");
        System.out.println("8. Reparar Objeto Mágico");
        System.out.println("9. Hacer que la mascota acompañe a su Guerrero (Mascota requerida)");
        System.out.println("10. Mostrar todas las entidades creadas");
        System.out.println("11. Modificar el nombre de un Guerrero o un Mago");
        System.out.println("0. Salir del Juego");
    }



//---------------------- OPCION 1 - CREAR GUERERO----------------------

//Usamos una funcion para crear el guerrero.
    private static void crearGuerrero() {
        System.out.println("Creación de Guerrero en Proceso...");
        if (cantidadGuerreros >= MAX) { //Si la cantidad de guerreros es mayor o igual al maximo, no se puede crear mas.
            System.out.println("No se pueden crear más Guerreros, maximo alcanzado.");
            return;
}

//A continuacion continuamos con las preguntas
        System.out.print("Ingrese el nombre del Guerrero a crear: ");
        String nombre = sc.nextLine();
        System.out.print("¿Cuanta salud tiene tu guerrero? (Max 100.): ");
        int salud = sc.nextInt();
        while(salud > 100) {
            System.out.println("El numero excede la cantidad maxima de salud");
            System.out.print("¿Cuanta salud tiene tu guerrero? (Max 100.): ");
            salud = sc.nextInt();
        }
        System.out.print("¿Cuanta fuerza tiene tu guerrero? (Max 100.)");
        int fuerza = sc.nextInt();
        System.out.print("¿Cuanta defensa tiene tu guerrero? (Max 100.)");
        int defensa = sc.nextInt();
        System.out.print("Que nivel tiene tu guerrero? (Max 10.)");
        int nivel = sc.nextInt();
        sc.nextLine();

        //Creamos al guerrero 
        Guerrero guer = new Guerrero(nombre, salud, fuerza, defensa, nivel);
        guerreros[cantidadGuerreros] = guer; //Guardamos el guerrero en el array de guerreros (Lineas 17 y 18)
        cantidadGuerreros++; //Suma uno a la cantidad de guerreros
        System.out.println("El Guerrero \"" + nombre + "\" fue creado con éxito."); //Mensaje de confirmación
    }



//---------------------- OPCION 2 - CREAR MAGO ----------------------

//Funcion para crear el mago
    private static void crearMago() {
        System.out.println("Creación de Mago en Proceso...");
        if (cantidadMagos >= MAX) { //Si la cantidad de magos es mayor o igual al maximo, no se puede crear mas.
            System.out.println("No se pueden crear más Magos, maximo alcanzado."); //Mensaje de error
            return;
        }
        System.out.print("Ingrese el nombre del Mago a Crear: ");
        String nombre = sc.nextLine();
        System.out.print("¿Cuanta salud tiene tu mago? (Max 100.): ");
        int salud = sc.nextInt();
        System.out.print("¿Cuanto maná tiene tu mago? (Max 100.):");
        int mana = sc.nextInt();
        System.out.print("¿Cuanta inteligencia tiene tu mago? (Max 100.): ");
        int inteligencia = sc.nextInt();
        System.out.print("¿Que nivel tiene tu mago? (Max 10.): ");
        int nivel = sc.nextInt();
        sc.nextLine();

        //Creacion de el mago
        Mago mag = new Mago(nombre, salud, mana, inteligencia, nivel);
        magos[cantidadMagos] = mag; //Guardamos el mago en el array de magos (Linea 20 y 21)
        cantidadMagos++; //Suma uno a la cantidad de magos
        System.out.println("El Mago \"" + nombre + "\" fue creado con éxito con su Inventario."); //Mensaje de confirmación
    }



//---------------------- OPCION 3 - CREAR MASCOTA ----------------------

//Funcion para crear la mascota
    private static void crearMascota() {
        System.out.println("Creacion de Mascota en Proceso...");
        if (cantidadGuerreros == 0) { //Si no hay guerreros, no se puede crear una mascota, ya que necesita un dueño. DEPENDENCIA DE EXISTENCIA
            System.out.println("No es posible crear una Mascota, primero debe existir al menos un Guerrero.");
            return;
        }
        if (cantidadMascotas >= MAX) { //Si la cantidad de mascotas es mayor o igual al maximo, no se puede crear mas
            System.out.println("No se pueden crear más Mascotas."); 
            return;
        }
        Guerrero dueño = seleccionarGuerrero(); //Seleccionamos un guerrero como dueño de la mascota
        if (dueño == null) { //Si no se selecciona un guerrero, no se puede crear la mascota
            return;
        }
        if (dueño.getMascota() != null) { //Si el guerrero ya tiene una mascota, no se puede crear otra
            System.out.println(dueño.getNombre() + " ya tiene una Mascota asignada (máximo 1 mascota por Guerrero)."); //Mensaje de error
            return;
        }

        System.out.print("Nombre de la mascota: ");
        String nombre = sc.nextLine();
        System.out.print("Lealtad inicial: (max 100): ");
        int lealtad = sc.nextInt();
        sc.nextLine();

        Mascota nueva = new Mascota(nombre, lealtad, dueño);
        mascotas[cantidadMascotas] = nueva; //Guardamos la mascota en el array de mascotas
        cantidadMascotas++; //Suma uno a la cantidad de mascotas
        System.out.println("Mascota \"" + nombre + "\" creada y asociada a " + dueño.getNombre() + "."); //Mensaje de confirmación
    }

//---------------------- OPCION 4 - CREAR OBJETO MAGICO ----------------------


    private static void crearObjetoMagico() {
        System.out.println("Creacion de Objeto Magico en Proceso...");
        if (cantidadObjetos >= MAX) { //Si la cantidad de objetos magicos es mayor o igual al maximo, no se puede crear mas.
            System.out.println("No se pueden crear más Objetos Mágicos, maximo alcanzado"); //Mensaje de error
            return;
        }  
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("¿Que tipo de objeto magico es?: ");
        String tipo = sc.nextLine();
        System.out.print("¿Cuanta potencia va a tener?: ");
        int potencia = sc.nextInt();
        System.out.print("¿Cuanta durabilidad va a tener?: ");
        int durabilidad = sc.nextInt();
        sc.nextLine();

        ObjetoMagico obj = new ObjetoMagico(nombre, tipo, potencia, durabilidad); //Guardamos el objeto magico en el array de objetos magicos
        objetosMagicos[cantidadObjetos] = obj; //Guardamos el objeto magico en el array de objetos magicos
        cantidadObjetos++; //Suma uno a la cantidad de objetos magicos
        System.out.println("El Objeto mágico llamado \"" + nombre + "\" creado con éxito."); //Mensaje de confirmación
    }




//---------------------- OPCION 5 - GESTIÓN DE INVENTARIO (SOLO MAGOS) ----------------------

    //Funcion para gestionar el inventario
    private static void gestionarInventario() {
        System.out.println("=== Gestión de Inventario ===");
        if (cantidadMagos == 0) { //Si no hay magos, no se puede gestionar el inventario, ya que cada mago tiene su propio inventario. DEPENDENCIA DE EXISTENCIA
            System.out.println("No hay Magos registrados."); //Mensaje de error
            return;
        }
        Mago m = seleccionarMago(); //Funcion para seleccionar un mago y gestionar su inventario
        if (m == null) { //Si no se selecciona un mago, no se puede gestionar el inventario
            return;
        }
        Inventario inv = m.getInventario(); //Obtenemos el inventario del mago seleccionado

        //Pequeño menu de opciones sin switch ya que son muy pocas.
        System.out.println("1. Agregar ítem al inventario");
        System.out.println("2. Consultar inventario");
        System.out.print("Opción: ");
        int op = sc.nextInt();
        sc.nextLine();


//Si el usuario elige la opcion 1 , ejecutamos este par de opciones.
        if (op == 1) {
            System.out.print("Ingrese el nombre del item que quiere agregar: ");
            String item = sc.nextLine();
            inv.agregarItem(item); //Agregamos el ítem que el usuario escribio mas arriba al inventario del mago seleccionado
        } 
        
//Si el usuario elige la opcion 2:
        else if (op == 2) {
            //Consultamos el inventario del mago seleccionado con una funcion declarada en el archivo Inventario.java
            String[] items = inv.consultarInventario(); 
            if (items.length == 0) { //Si el inventario está vacío, mostramos un mensaje indicando que no hay ítems
                System.out.println("El inventario de " + m.getNombre() + " está vacio."); 
            } 
            
            //Si el inventario tiene items,
            else {
                System.out.println("Inventario de " + m.getNombre() + " (capacidad "
                        + inv.getCapacidad() + "):"); //Mostramos el inventario del mago seleccionado, indicando la capacidad máxima del inventario
                
                        for (int i = 0; i < items.length; i++) { //Mostramos los ítems del inventario del mago seleccionado
                    System.out.println(" - " + items[i]); //Mostramos cada ítem del inventario como una lista
                }
            }
        } 
        
        else {
            System.out.println("La opcion seleccionada es invlida, intente denuevo");
        }
    }



//---------------------- OPCION 6 - ACCIONES DE GUERRERO ----------------------

//Funcion para las acciones del guerrero
    private static void accionesGuerrero() {
        System.out.println("=== Acciones de Guerrero ===");
        if (cantidadGuerreros == 0) { //Si no hay guerreros, no se puede realizar ninguna acción de guerrero. DEPENDENCIA DE EXISTENCIA
            System.out.println("No hay Guerreros registrados."); 
            return;
        }
        Guerrero g = seleccionarGuerrero(); //Seleccionamos un guerrero para realizar acciones
        if (g == null) { 
            return;
        }

//Creamos un pequeño menu de opciones con switch para que el usuario elija que acciones de guerrero quiere ejecutar
        System.out.println("1. Usar espada");
        System.out.println("2. Gritar desafío");
        System.out.println("3. Gritar guerra");
        System.out.println("4. Ataque básico");
        System.out.print("Opción: ");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                Personaje objetivo1 = seleccionarObjetivo(); //Seleccionamos un objetivo para atacar con la espada
                if (objetivo1 != null) {   //Si se selecciona un objetivo, el guerrero usa la espada para atacar al objetivo
                    g.usarEspada(objetivo1); //Llamamos a la funcion usar espada declara en Guerrero.java
                }
                break;
                
            case 2:
                g.gritarDesafio(); //Llama a la funcion gritarDesafio declarada en Guerrero.java
                break;

            case 3:
                g.gritarGuerra(); //Llama a la funcion gritarGuerra declarada en Guerrero.java
                break;

            case 4: //Ataque a un mago
                if (cantidadMagos == 0) {
                    System.out.println("No hay Magos registrados para atacar.");
                    break;
                }
                Mago objetivoMago = seleccionarMago(); //Seleccionamos un mago
                if (objetivoMago != null) {
                    g.atacar(objetivoMago); //atacar() es heredado de Personaje, por eso Guerrero puede usarlo sobre un Mago
                }
                break;
            default:
                System.out.println("Opción inválida, intente denuevo."); 
        }
    }



// ---------------------- OPCION 7 - ACCIONES DE MAGO ----------------------

    private static void accionesMago() {
        System.out.println("=== Acciones de Mago ===");
        if (cantidadMagos == 0) {
            System.out.println("No hay Magos registrados.");
            return;
        }
        //Seleccionamos que mago queremos hacerle ejecutar las accciones.
        Mago m = seleccionarMago();
        if (m == null) {
            return;
        }

//Usamos un menu de opciones para mostrarle al usuario que acciones puede ejecutar
        System.out.println("1. Recuperar maná");
        System.out.println("2. Aprender hechizo");
        System.out.println("3. Lanzar hechizo");
        System.out.println("4. Invocar elemento");
        System.out.println("5. Usar objeto mágico");
        System.out.println("6. Ataque básico");
        System.out.print("Opción: ");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                m.recuperarMana(); //Funcion declarada en Mago.java
                break;
            case 2:
                //Hacemos que el usuario pueda elegir que hechizo de los que ya tenemos cargados pueda aprender para luego usar
                String nuevoHechizo = seleccionarHechizoDisponible();
                if (nuevoHechizo != null) {
                    m.aprenderHechizo(nuevoHechizo);
                }
                break;

            case 3:
                //El mago elige que hechizo lanzar de los que ya sabe
                String hechizo = seleccionarHechizoConocido(m); 
                if (hechizo != null) {
                    m.lanzarHechizo(hechizo);
                }
                break;

            case 4:
                //El mago elige de la lista que ya le damos nosotros el elemento que quiere invocar
                String elemento = seleccionarElementoDisponible(); 
                if (elemento != null) {
                    m.invocarElemento(elemento);
                }
                break;

            case 5:
                //Usar objeto magico
                if (cantidadObjetos == 0) {
                    System.out.println("No hay Objetos Mágicos registrados.");
                    break;
                }
                //El mago usa el objeto mágico
                ObjetoMagico obj = seleccionarObjetoMagico(); 
                if (obj != null) {
                    m.usarObjetoMagico(obj);
                }
                break;
            case 6:
                //atacar() se hereda de Personaje, así que Mago lo hereda igual que Guerrero.
                if (cantidadGuerreros == 0) {
                    System.out.println("No hay Guerreros para atacar.");
                    break;
                }
                Guerrero objetivoGuerrero = seleccionarGuerrero();
                if (objetivoGuerrero != null) {
                    m.atacar(objetivoGuerrero); //ataque básico heredado de Personaje
                }
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }


//---------------------- OPCION 8 - REPARAR OBJETO MÁGICO ----------------------

//Funcion para reparar el objeto magico
private static void repararObjetoMagico() {
    System.out.println("=== Reparar Objeto Mágico ===");
    if (cantidadObjetos == 0) { //Si no hay objetos mágicos, no se puede reparar ninguno.
        System.out.println("No hay Objetos Mágicos para reparar.");
        return;
    }
        ObjetoMagico obj = seleccionarObjetoMagico();
        if (obj != null) {
            obj.reparar(); //Llamamos a la funcion reparar de ObjetoMagico.java, haciendo que el mismo se repare
        }
}



//---------------------- OPCION 9 - ACCION DE MASCOTA ----------------------

private static void mascotaAcompana() { //Permite que la mascota acompañe a su guerrero dueño
    System.out.println("=== Mascota acompaña a su Guerrero ===");
    if (cantidadMascotas == 0) {
        System.out.println("No hay Mascotas registradas."); //Si no hay mascotas, no se puede realizar la acción
        return;
    }
        
        for (int i = 0; i < cantidadMascotas; i++) {
            Mascota mas = mascotas[i];
            //Muestra la lista de mascotas con su respectivo guerrero dueño
            System.out.println((i + 1) + ". " + mas.getNombre() + " (dueño: " + mas.getGuerrero().getNombre() + ")"); 
            
    }

        System.out.print("Seleccione una mascota: ");
        int indiceArray = sc.nextInt() - 1; //Se resta 1 para convertir la selección a índice de array
        sc.nextLine();

        if (indiceArray < 0 || indiceArray >= cantidadMascotas) {
            System.out.println("Selección inválida.");
            return; //Si la selección es inválida, se muestra un mensaje de error y se termina la acción
        }
        mascotas[indiceArray].acompanar(); //Se llama a la funcion acompanar de Mascota.java
}


//---------------------- OPCION 10 - LISTA DE ENTIDADES ----------------------

//Funcion para listar las entidades
    private static void listarEntidades() {
        System.out.println("=== Entidades registradas ===");
        System.out.println(""); //espacio extra

        //Categoria Guerreros
        System.out.println("\n Guerreros:");
        for (int i = 0; i < cantidadGuerreros; i++) { //muestra la lista de guerreros con sus atributos y la mascota asociada (si tiene)
            Guerrero g = guerreros[i];
            String nombreMascota = "No tiene";
            if (g.getMascota() != null) {
                nombreMascota = g.getMascota().getNombre();
            }
            //Mostramos
            System.out.println("\n" + g.getNombre() + "\n Salud = " + g.getSalud() + "\n Fuerza = " + g.getFuerza() + "\n Defensa = " 
            + g.getDefensa() + "\n Nivel = " + g.getNivel() + "\n Mascota = " + nombreMascota);
        }

        //Categoria Magos
        System.out.println("\n Magos:");
        for (int i = 0; i < cantidadMagos; i++) { //muestra la lista de magos con sus atributos y los hechizos conocidos
            Mago m = magos[i];

            System.out.print("\n" + m.getNombre() + "\n Salud = " + m.getSalud() + "\n Mana = " + m.getMana() + "\n Inteligencia = " 
            + m.getInteligencia() + "\n Nivel = " + m.getNivel() + "\n Hechizos = ");

            //Mostramos los hechizos conocidos
            String[] hechizos = m.getHechizosConocidos();
            for (int j = 0; j < hechizos.length; j++) {
                //Los mostramos desde el array
                System.out.print(hechizos[j]);

                if (j < hechizos.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        //Categoria Mascotas
        System.out.println("\n Mascotas:");
        for (int i = 0; i < cantidadMascotas; i++) { //muestra la lista de mascotas con su lealtad y el nombre del guerrero dueño
            Mascota mas = mascotas[i];

            System.out.println("\n" + mas.getNombre() + "\n Lealtad = " + mas.getLealtad() + "\n Dueño = " + mas.getGuerrero().getNombre());
        }

        //Categoria Objetos Magicos
        System.out.println("\n Objetos Mágicos:");
        for (int i = 0; i < cantidadObjetos; i++) { //muestra la lista de objetos mágicos con su tipo, potencia y durabilidad
            ObjetoMagico o = objetosMagicos[i];

            System.out.println("\n" + o.getNombre() + "\n Tipo = " + o.getTipo() + "\n Potencia = " + o.getPotencia() +
            "\n Durabilidad = " + o.getDurabilidad());
        }
    }


//---------------------- SELECCIÓN DE ENTIDADES ----------------------
/* Estos métodos muestran una lista de elementos (guerreros, magos u objetos), le piden al usuario que elija uno ingresando un 
número y devuelven el seleccionado. Si la opción es incorrecta o no hay elementos, devuelven null. */

//---------------------------- SELECCIONAR GUERRERO ----------------------------
//Metodo para seleccionar al guerrero, usada en los casos que nos pregunta a quien queremos seleccionar
    private static Guerrero seleccionarGuerrero() {
        if (cantidadGuerreros == 0) { //Si no hay guerreros
            System.out.println("No hay Guerreros registrados.");
            return null;
        }
        for (int i = 0; i < cantidadGuerreros; i++) { //Muestra la lista de guerreros con su índice para seleccionar
            System.out.println((i + 1) + ". " + guerreros[i].getNombre());
        }
        System.out.print("Seleccione un Guerrero: ");
        int indiceArrayGuer = sc.nextInt() - 1;
        sc.nextLine();

        if (indiceArrayGuer < 0 || indiceArrayGuer >= cantidadGuerreros) {
            System.out.println("Selección inválida.");
            return null;
        }
        return guerreros[indiceArrayGuer];
    }

//---------------------------- SELECCIONAR MAGO ----------------------------
//Lo mismo que el metodo de guerrero, pero para mago
    private static Mago seleccionarMago() {
        if (cantidadMagos == 0) { //Si no hay magos
            System.out.println("No hay Magos registrados.");
            return null;
        }
        for (int i = 0; i < cantidadMagos; i++) { //Muestra la lista de magos con su índice para seleccionar
            System.out.println((i + 1) + ". " + magos[i].getNombre());
        }
        System.out.print("Seleccione un Mago: ");
        int indiceArrayMag = sc.nextInt() - 1;
        sc.nextLine();

        if (indiceArrayMag < 0 || indiceArrayMag >= cantidadMagos) {
            System.out.println("Selección inválida.");
            return null;
        }
        return magos[indiceArrayMag];
    }

//---------------------------- SELECCIONAR OBJETO MAGICO ----------------------------
    private static ObjetoMagico seleccionarObjetoMagico() {
        for (int i = 0; i < cantidadObjetos; i++) { //Muestra la lista de objetos mágicos con su índice para seleccionar
            System.out.println((i + 1) + ". " + objetosMagicos[i].getNombre());
        }
        System.out.print("Seleccione un Objeto Mágico: ");
        int indiceArrayOJ = sc.nextInt() - 1;
        sc.nextLine();

        if (indiceArrayOJ < 0 || indiceArrayOJ >= cantidadObjetos) {
            System.out.println("Selección inválida.");
            return null;
        }
        return objetosMagicos[indiceArrayOJ];
    }


//---------------------- SELECCIÓN DE HECHIZOS Y ELEMENTOS PRECARGADOS ----------------------

//Muestra la lista de hechizos precargados para que el mago aprenda uno
    private static String seleccionarHechizoDisponible() {
        System.out.println("Hechizos disponibles para aprender:");
        for (int i = 0; i <hechizosDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + hechizosDisponibles[i]);
        }
        System.out.print("Seleccione un hechizo: ");
        int indiceArrayHech = sc.nextInt() - 1;
        sc.nextLine();

        if (indiceArrayHech < 0 || indiceArrayHech >= hechizosDisponibles.length) {
            System.out.println("Selección inválida.");
            return null;
        }
        return hechizosDisponibles[indiceArrayHech];
    }

//Cuando los aprende, muestra los hechizos que el mago ya conoce para elegir cuál lanzar
    private static String seleccionarHechizoConocido(Mago m) {
        String[] hechizos = m.getHechizosConocidos();
        if (hechizos.length == 0) {
            System.out.println(m.getNombre() + " todavía no conoce ningún hechizo.");
            return null;
        }
        System.out.println("Hechizos conocidos por " + m.getNombre() + ":");
        for (int i = 0; i < hechizos.length; i++) {
            System.out.println((i + 1) + ". " + hechizos[i]);
        }
        System.out.print("Seleccione un hechizo para lanzar: ");
        int indiceArrayHech2 = sc.nextInt() - 1;
        sc.nextLine();

        if (indiceArrayHech2 < 0 || indiceArrayHech2 >= hechizos.length) {
            System.out.println("Selección inválida.");
            return null;
        }
        return hechizos[indiceArrayHech2];
    }

// Muestra la lista de elementos precargados para que el mago invoque uno
    private static String seleccionarElementoDisponible() {
        System.out.println("Elementos disponibles para invocar:");
        for (int i = 0; i < elementosDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + elementosDisponibles[i]);
        }
        System.out.print("Seleccione un elemento: ");
        int indiceArrayEL = sc.nextInt() - 1;
        sc.nextLine();

        if (indiceArrayEL < 0 || indiceArrayEL >= elementosDisponibles.length) {
            System.out.println("Selección inválida.");
            return null;
        }
        return elementosDisponibles[indiceArrayEL];
    }

//---------------------- OPCION 11 - MODIFICAR NOMBRE - GET Y SET ----------------------

//Funcion para modificar el nombre
    private static void modificarNombre() {
        System.out.println("=== Modificar nombre ===");
        System.out.println("1. Modificar nombre de Guerrero");
        System.out.println("2. Modificar nombre de Mago");
        System.out.print("Opción: ");
        int opcionGS = sc.nextInt();
        sc.nextLine();

        if (opcionGS == 1) {
            if (cantidadGuerreros == 0) {
                System.out.println("No hay Guerreros registrados.");
                return;
            }
            Guerrero g = seleccionarGuerrero();
            if (g == null) {
                return;
            }
            System.out.println("Nombre actual: " + g.getNombre()); //Se usa el get para mostrar el nombre actual
            System.out.print("Escriba el nuevo nombre: ");
            String nuevoNombre = sc.nextLine();
            g.setNombre(nuevoNombre); //Se usa el set para actualizar el nombre
            System.out.println("El nombre del Guerrero fue actualizado a: " + g.getNombre() + ".");


        } else if (opcionGS == 2) {
            if (cantidadMagos == 0) {
                System.out.println("No hay Magos registrados.");
                return;
            }
            Mago m = seleccionarMago();
            if (m == null) {
                return;
            }
            System.out.println("Nombre actual: " + m.getNombre()); //Se usa el get para mostrar el nombre actual
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = sc.nextLine();
            m.setNombre(nuevoNombre); //Se usa el set para actualizar el nombre
            System.out.println("El nombre del Mago fue actualizado a " + m.getNombre() + ".");
        } else {
            System.out.println("Opción inválida.");
        }
    }


//---------------------------- SELECCIONAR OBJETIVO ----------------------------
//Pregunta primero el tipo (Guerrero o Mago) y después selecciona la entidad. 
//Sirve para elegir el objetivo de un ataque, sin importar de qué tipo sea.

    private static Personaje seleccionarObjetivo() {
        System.out.println("¿El objetivo es un Guerrero o un Mago?");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.print("Opción: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo == 1) { //Si el tipo seleccionado es 1, se llama al método seleccionarGuerrero() para elegir un guerrero como objetivo
            return seleccionarGuerrero();
        } else if (tipo == 2) {
            return seleccionarMago();
        } else {
            System.out.println("Opción inválida.");
            return null;
        }
    }
}