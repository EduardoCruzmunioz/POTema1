import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class Main {

    static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Constantes y variables de valores económicos
        final int PRECIO_HABITACION_INDIVIDUAL = 45;
        final int PRECIO_HABITACION_DOBLE = 60;
        double ingresosTotales = 0.00;

        // Variables para guardar el precio del producto el dinero con el que paga y el cambio a realizar
        final int IVA = 21;
        double tarifaNoche = 0, totalSinIva, valorIVA, totalConIVA, pago;

        // Inicio de variables del dinero que tenemos en la caja
        int totalBilletes500 = 11, totalBilletes200 = 8, totalBilletes100 = 17, totalBilletes50 = 14,
                totalBilletes20 = 19, totalBilletes10 = 12, totalBilletes5 = 23, totalMonedas2e = 31,
                totalMonedas1e = 33, totalMonedas50cent = 35, totalMonedas20cent = 37, totalMonedas10cent = 39,
                totalMonedas5cent = 41, totalMonedas2cent = 43, totalMonedas1cent = 45;

        // Variables que contabilizán las cantidades de billetes o monedas a dar
        int billetes500, billetes200, billetes100, billetes50, billetes20, billetes10, billetes5,
                monedas2e, monedas1e, monedas50cent, monedas20cent, monedas10cent, monedas5cent, monedas2cent, monedas1cent;

        //Constantes y variables para el login
        final String NOMBRE_ADMIN = "hola";
        final String ClAVE_ADMIN = "hola";
        String user = "hola", pass = "hola";

        int reservasFinalizadas = 0;

        boolean salir = true, volver = true, habInvalida, fechaValida, telefonoValido;
        String op, opAdmin, tipoHabitacion;

        // Estado de las habitaciones: false = libre, true = ocupada (La habitación 9 y 10 son las individuales y las demás dobles)
        // Nota: Esto sería más fácil de manejar con un array de booleanos.
        boolean hab1 = false, hab2 = false, hab3 = false, hab4 = false, hab5 = false, hab6 = false, hab7 = false, hab8 = false, hab9 = false, hab10 = false;
        String nombreHab1 = "", nombreHab2 = "", nombreHab3 = "", nombreHab4 = "", nombreHab5 = "", nombreHab6 = "",
                nombreHab7 = "", nombreHab8 = "", nombreHab9 = "", nombreHab10 = "";

        String nombreCliente = "", numHab, telefono;
        boolean factura;

        int numReserva = 20251100;
        long numNoches;
        int huespedes = 0;

        // Variables de fechas
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaHab1 = LocalDate.now() /*null*/, fechaHab2 = null, fechaHab3 = null, fechaHab4 = null, fechaHab5 = null,
                fechaHab6 = null, fechaHab7 = null, fechaHab8 = null, fechaHab9 = null, fechaHab10 = null,
                fechaSalida, fechaEntrada = null;
        String fecha;

        System.out.println("""
                \t┓┏┏┓┏┳┓┏┓┓   ┏┓┳┳┳┳┓┏┓┳┓  ┳┓┏┓  ┳┳┓┏┓┳┓┏┳┓┏┓┏┓
                \t┣┫┃┃ ┃ ┣ ┃   ┃ ┃┃┃┃┃┣┫┃┃  ┃┃┣   ┃┃┃┣┫┣┫ ┃ ┃┃┗┓
                \t┛┗┗┛ ┻ ┗┛┗┛  ┗┛┻┗┛┻┛┛┗┻┛  ┻┛┗┛  ┛ ┗┛┗┛┗ ┻ ┗┛┗┛""");

        try { //Tiempo de espera
            System.out.print("\n\n\tCargando");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(750);
                System.out.print(".");
            }
            System.out.println();

        } catch (InterruptedException e) {
            System.out.println("Se interrumpió la salida");
        }


        // Bucle principal del programa
        do {
            for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
            // Nos muestra el menú
            System.out.print("""
                    \t╭──────────────────────────────────────────────╮
                    \t│            HOTEL CIUDAD DE MARTOS            │
                    \t├──────────────────────────────────────────────┤
                    \t│ [ a ] Ver estado de ocupación                │
                    \t│ [ b ] Reservar una habitación                │
                    \t│ [ c ] Realizar checkout                      │
                    \t│                                              │
                    \t├──────────────────────────────────────────────┤
                    \t│ [ d ] Menú de administrador                  │
                    \t╰──────────────────────────────────────────────╯
                    
                    \tElige una opción:\s""");
            // Escribe la opción que quieres
            op = s.nextLine().toLowerCase();
            for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
            // Switch principal que gestiona las opciones del menú
            switch (op) {
                case "a": //Ver estado de ocupación
                    try { //Tiempo de espera
                        System.out.print("\tRedirigiéndose a la opción a ");
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        System.out.println();

                    } catch (InterruptedException e) {
                        System.out.println("Se interrumpió la entrada");
                    }
                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                    // Muestra una tabla formateada con el estado (Libre/Ocupada) de las 10 habitaciones.
                    // Usa operadores ternarios (hab1) ¿? "Ocupada": "Libre" para determinar qué string mostrar.
                    System.out.printf("""
                            \t╭────────────────────────────────────────────╮
                            \t│           HOTEL CIUDAD DE MARTOS           │
                            \t├────────────────────────────────────────────┤
                            \t│         ESTADO DE LAS HABITACIONES         │
                            \t├────────────┬────────────┬──────────────────┤
                            \t│ Habitación │    Tipo    │      Estado      │
                            \t├────────────┼────────────┼──────────────────┤
                            \t│ 1          │ Doble      │ %-16s │
                            \t│ 2          │ Doble      │ %-16s │
                            \t│ 3          │ Doble      │ %-16s │
                            \t│ 4          │ Doble      │ %-16s │
                            \t│ 5          │ Doble      │ %-16s │
                            \t│ 6          │ Doble      │ %-16s │
                            \t│ 7          │ Doble      │ %-16s │
                            \t│ 8          │ Doble      │ %-16s │
                            \t│ 9          │ Individual │ %-16s │
                            \t│ 10         │ Individual │ %-16s │
                            \t╰────────────┴────────────┴──────────────────╯
                            \n""", (hab1 ? "Ocupada" : "Libre"), (hab2 ? "Ocupada" : "Libre"), (hab3 ? "Ocupada" : "Libre"), (hab4 ? "Ocupada" : "Libre"), (hab5 ? "Ocupada" : "Libre"), (hab6 ? "Ocupada" : "Libre"), (hab7 ? "Ocupada" : "Libre"), (hab8 ? "Ocupada" : "Libre"), (hab9 ? "Ocupada" : "Libre"), (hab10 ? "Ocupada" : "Libre"));
                    System.out.print("\tPulse una tecla para volver al menú");
                    s.nextLine();
                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                    try {//Tiempo de espera
                        System.out.print("\n\tVolviendo al menú principal");

                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        System.out.println();
                    } catch (InterruptedException e) {
                        System.out.println("Se interrumpió la salida");
                    }
                    break;
                case "b": //Reservar las habitaciones
                    try { //Tiempo de espera
                        System.out.print("\tRedirigiéndose a la opción b ");
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        System.out.println();
                    } catch (InterruptedException e) {
                        System.out.println("Se interrumpió la entrada");
                    }
                    // Inicia el submenú para reservar una habitación.
                    if (hab1 && hab2 && hab3 && hab4 && hab5 && hab6 && hab7 && hab8 && hab9 && hab10) {
                        System.out.println("\tTodas las habitaciónes están ocupadas");
                        s.nextLine();
                    } else {
                        do {
                            for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                            System.out.print("""
                                    \t╭────────────────────────────────────────╮
                                    \t│            SELECCIONAR TIPO            │
                                    \t├────────────────────────────────────────┤
                                    \t│ [   i ] Habitación Doble               │
                                    \t│ [  ii ] Habitación Individual          │
                                    \t│                                        │
                                    \t├────────────────────────────────────────┤
                                    \t│ [ iii ] Volver al menú anterior        │
                                    \t╰────────────────────────────────────────╯
                                    
                                    \tIntroduzca una opción (i - iii):\s""");
                            tipoHabitacion = s.nextLine();
                            if (tipoHabitacion.equalsIgnoreCase("i") || tipoHabitacion.equalsIgnoreCase("ii")) {
                                if (tipoHabitacion.equalsIgnoreCase("ii") && (hab9 && hab10)) {
                                    System.out.println("\tTodas las habitaciones individuales están ocupadas");

                                } else if (tipoHabitacion.equalsIgnoreCase("i") &&
                                        (hab1 && hab2 && hab3 && hab4 && hab5 && hab6 && hab7 && hab8)) {
                                    System.out.println("\tTodas las habitaciones dobles están ocupadas");

                                } else {

                                    do {
                                        for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla

                                        System.out.println("""
                                                \t┳┓┏┓┏┓┳┏┓┏┳┓┳┓┏┓  ┳┓┏┓  ┳┓┏┓┏┳┓┏┓┏┓
                                                \t┣┫┣ ┃┓┃┗┓ ┃ ┣┫┃┃  ┃┃┣   ┃┃┣┫ ┃ ┃┃┗┓
                                                \t┛┗┗┛┗┛┻┗┛ ┻ ┛┗┗┛  ┻┛┗┛  ┻┛┛┗ ┻ ┗┛┗┛\n""");

                                        System.out.print("\tIntroduzca un nombre para la reserva: ");
                                        nombreCliente = s.nextLine().toLowerCase();

                                        if (nombreCliente.isEmpty()) {
                                            System.out.print("\tDebe introducir un nombre por favor.");
                                            s.nextLine();
                                        }

                                    } while (nombreCliente.isEmpty());
                                }
                            }

                            // Switch para gestionar el tipo de habitación a reservar
                            switch (tipoHabitacion) {
                                case "i": // Lógica para reservar habitación DOBLE
                                    if (!hab1) {
                                        fechaHab1 = LocalDate.now();
                                        hab1 = true;
                                        nombreHab1 = nombreCliente;
                                        System.out.println("\tHabitación asignada número 1 con fecha asignada " + fechaHab1.format(inputFormatter));

                                    } else if (!hab2) {
                                        fechaHab2 = LocalDate.now();
                                        hab2 = true;
                                        nombreHab2 = nombreCliente;
                                        System.out.println("\tHabitación asignada número 2 con fecha asignada " + fechaHab2.format(inputFormatter));

                                    } else if (!hab3) {
                                        fechaHab3 = LocalDate.now();
                                        hab3 = true;
                                        nombreHab3 = nombreCliente;
                                        System.out.println("\tHabitación asignada número 3 con fecha asignada " + fechaHab3.format(inputFormatter));

                                    } else if (!hab4) {
                                        fechaHab4 = LocalDate.now();
                                        hab4 = true;
                                        nombreHab4 = nombreCliente;
                                        System.out.println("\tHabitación asignada número 4 con fecha asignada " + fechaHab4.format(inputFormatter));

                                    } else if (!hab5) {
                                        fechaHab5 = LocalDate.now();
                                        hab5 = true;
                                        nombreHab5 = nombreCliente;
                                        System.out.println("\tHabitación asignada número 5 con fecha asignada " + fechaHab5.format(inputFormatter));

                                    } else if (!hab6) {
                                        fechaHab6 = LocalDate.now();
                                        hab6 = true;
                                        nombreHab6 = nombreCliente;
                                        System.out.println("\tHabitación asignada número 6 con fecha asignada " + fechaHab6.format(inputFormatter));

                                    } else if (!hab7) {
                                        fechaHab7 = LocalDate.now();
                                        hab7 = true;
                                        nombreHab7 = nombreCliente;
                                        System.out.println("\tHabitación asignada número 7 con fecha asignada " + fechaHab7.format(inputFormatter));

                                    } else if (!hab8) {
                                        fechaHab8 = LocalDate.now();
                                        hab8 = true;
                                        nombreHab8 = nombreCliente;
                                        System.out.println("\tHabitación asignada número 8 con fecha asignada " + fechaHab8.format(inputFormatter));

                                    }

                                    System.out.print("""
                                            \n\t ___________ @ @
                                            \t/         (@\\   @
                                            \t\\___________/  _@
                                            \t          @  _/@ \\_____
                                            \t           @/ \\__/-="="`
                                            \t            \\_ /
                                            \t             <|
                                            \t             <|
                                            \t             <|
                                            \t             `
                                            """);


                                    System.out.print("\n\tPulse una tecla para volver al submenú");
                                    s.nextLine();
                                    break;

                                case "ii": // Lógica para reservar habitación INDIVIDUAL
                                    // Busca la primera habitación individual (9-10) que esté libre
                                    // y la asigna al cliente.
                                    if (!hab9) {
                                        fechaHab9 = LocalDate.now();
                                        hab9 = true;
                                        nombreHab9 = nombreCliente;
                                        System.out.println("\tHabitación asignada número 9 con fecha asignada " + fechaHab9.format(inputFormatter));

                                    } else if (!hab10) {
                                        fechaHab10 = LocalDate.now();
                                        hab10 = true;
                                        nombreHab10 = nombreCliente;
                                        System.out.println("\tHabitación asignada número 10 con fecha asignada " + fechaHab10.format(inputFormatter));
                                    }

                                    System.out.println("""
                                            \t ___________ @ @
                                            \t/         (@\\   @
                                            \t\\___________/  _@
                                            \t          @  _/@ \\_____
                                            \t           @/ \\__/-="="`
                                            \t            \\_ /
                                            \t             <|
                                            \t             <|
                                            \t             <|
                                            \t             `
                                            """);

                                    System.out.print("\tPulse una tecla para volver al submenú");
                                    s.nextLine();
                                    break;
                                case "iii": // Salir del submenú de reservas
                                    break;
                                default:
                                    System.out.print("\tOpción introducida no válida.\n");
                                    System.out.print("\tPulse cualquier tecla para continuar");
                                    s.nextLine();

                            }
                            try { //Tiempo de espera

                                for (int i = 0; i < 3; i++) {
                                    Thread.sleep(200);
                                    System.out.print("");
                                }
                                System.out.println();

                            } catch (InterruptedException e) {
                                System.out.println("\tAlgo paso ciervo");
                            }

                            for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla

                            try { //Tiempo de espera
                                System.out.print((tipoHabitacion.equalsIgnoreCase("iii")) ?
                                        "\tVolviendo al menú principal" : "\tVolviendo al submenú");

                                for (int i = 0; i < 3; i++) {
                                    Thread.sleep(500);
                                    System.out.print(".");
                                }
                                System.out.println();

                            } catch (InterruptedException e) {
                                System.out.println("Se interrumpió la salida");
                            }
                        } while (!tipoHabitacion.equalsIgnoreCase("iii"));
                    }

                    break;
                case "c": //Realizar checkouts
                    try { //Tiempo de espera
                        System.out.print("\tRedirigiéndose a la opción c ");
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        System.out.println();
                    } catch (InterruptedException e) {
                        System.out.println("\tSe interrumpió la entrada");
                    }
                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                    // Inicia el proceso de CHECK-OUT del cliente.
                    factura = false; // Resetea la bandera de factura

                    if (!hab1 && !hab2 && !hab3 && !hab4 && !hab5 && !hab6 && !hab7 && !hab8 && !hab9 && !hab10) {
                        System.out.println("""
                                \tNo se puede realizar ningún CHECKOUT de salida.
                                \tPuesto que todas las habitaciones están libres
                                """);
                    } else {


                        System.out.println("""
                                \t┏┓┏┓┳┓┳┳┓┳┳┓ ┏┓┳┓┳┏┓  ┏┓┓┏┏┓┏┓┓┏┓┏┓┳┳┏┳┓
                                \t┣ ┃┃┣┫┃┃┃┃┃┃ ┣┫┣┫┃┃┃  ┃ ┣┫┣ ┃ ┃┫ ┃┃┃┃ ┃
                                \t┻ ┗┛┛┗┛ ┗┗┛┗┛┛┗┛┗┻┗┛  ┗┛┛┗┗┛┗┛┛┗┛┗┛┗┛ ┻\n""");

                        do {

                            System.out.print("\tIntroduzca el nombre del cliente: ");
                            nombreCliente = s.nextLine().toLowerCase();
                            if (nombreCliente.isEmpty()) {
                                System.out.print("\tDebe introducir un nombre");
                                s.nextLine();
                                for (int i = 0; i < 50; i++) System.out.println();
                            }

                        } while (nombreCliente.isEmpty());
                        do { // Validación simple de la longitud del teléfono
                            telefonoValido = true;
                            String mensaje = "";
                            System.out.print("\tIntroduzca el número de teléfono: ");
                            telefono = s.nextLine();
                            if (telefono.length() != 9) {
                                mensaje = "\tEl número de teléfono debe ser de longitud 9";
                                telefonoValido = false;
                            } else {
                                for (int i = 0; i < telefono.length(); i++) {
                                    char c = telefono.charAt(i);
                                    if (!Character.isDigit(c)) telefonoValido = false;
                                    if (!telefonoValido) i = telefono.length() + 1;
                                }
                                mensaje = "\tEl número de teléfono solo permite números entre (0-9)";
                            }
                            if (!telefonoValido) {
                                System.out.println(mensaje);
                                s.nextLine();
                                for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                            }

                        } while (!telefonoValido);

                        do {
                            habInvalida = false;
                            System.out.print("\tIntroduzca el número de la habitación (1 al 10): ");
                            numHab = s.nextLine();
                            if (!numHab.equals("1") && !numHab.equals("2") && !numHab.equals("3") && !numHab.equals("4")
                                    && !numHab.equals("5") && !numHab.equals("6") && !numHab.equals("7") && !numHab.equals("8")
                                    && !numHab.equals("9") && !numHab.equals("10") || numHab.isEmpty()) {
                                habInvalida = true;
                                System.out.println("\tSolo se permite las habitaciones del 1 al 10");
                                System.out.print("\tAnda pulsa para continuar que estas tontico");
                                s.nextLine();
                                for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                            }
                        } while (habInvalida);

                        // Switch para identificar la habitación y verificar el nombre del cliente
                        switch (numHab) {
                            case "1", "2", "3", "4", "5", "6", "7", "8":// Habitaciones DOBLES
                                // Comprueba si el número de habitación Y el nombre del cliente coinciden.

                                // Si coinciden, guarda la fecha de entrada y marca 'factura' como true
                                if (nombreCliente.isEmpty()) //Solo entra si el nombreCliente no está vacío
                                    System.out.println("\tNo se ha rellenado correctamente el formulario");
                                else {
                                    if (numHab.equals("1") && nombreHab1.equals(nombreCliente)) {
                                        fechaEntrada = fechaHab1;
                                        factura = true;
                                        hab1 = false;
                                    }
                                    if (numHab.equals("2") && nombreHab2.equals(nombreCliente)) {
                                        fechaEntrada = fechaHab2;
                                        factura = true;
                                        hab2 = false;
                                    }
                                    if (numHab.equals("3") && nombreHab3.equals(nombreCliente)) {
                                        fechaEntrada = fechaHab3;
                                        factura = true;
                                        hab3 = false;
                                    }
                                    if (numHab.equals("4") && nombreHab4.equals(nombreCliente)) {
                                        fechaEntrada = fechaHab4;
                                        factura = true;
                                        hab4 = false;
                                    }
                                    if (numHab.equals("5") && nombreHab5.equals(nombreCliente)) {
                                        fechaEntrada = fechaHab5;
                                        factura = true;
                                        hab5 = false;
                                    }
                                    if (numHab.equals("6") && nombreHab6.equals(nombreCliente)) {
                                        fechaEntrada = fechaHab6;
                                        factura = true;
                                        hab6 = false;
                                    }
                                    if (numHab.equals("7") && nombreHab7.equals(nombreCliente)) {
                                        fechaEntrada = fechaHab7;
                                        factura = true;
                                        hab7 = false;
                                    }
                                    if (numHab.equals("8") && nombreHab8.equals(nombreCliente)) {
                                        fechaEntrada = fechaHab8;
                                        factura = true;
                                        hab8 = false;
                                    }

                                    // Asigna los valores para la factura de habitación doble
                                    huespedes = 2;
                                    tarifaNoche = PRECIO_HABITACION_DOBLE;
                                }
                                break;
                            case "9", "10": // Habitaciones INDIVIDUALES
                                // Misma lógica que las dobles, pero para habitaciones 9 y 10.
                                if (nombreCliente.isEmpty()) //Solo entra si el nombreCliente no está vacío
                                    System.out.println("\tNo se ha rellenado correctamente el formulario");
                                else {
                                    if (numHab.equals("9") && nombreHab9.equals(nombreCliente)) {
                                        fechaEntrada = fechaHab9;
                                        factura = true;
                                        hab9 = false;
                                    }
                                    if (numHab.equals("10") && nombreHab10.equals(nombreCliente)) {
                                        fechaEntrada = fechaHab10;
                                        factura = true;
                                        hab10 = false;
                                    }
                                    // Asigna los valores para la factura de habitación individual
                                    huespedes = 1;
                                    tarifaNoche = PRECIO_HABITACION_INDIVIDUAL;

                                }
                                break;
                            default:
                                System.out.println("\tHabitación introducida no existente compruebe de nuevo");
                        }


                        if (!factura && !habInvalida) { // Si 'factura' fue false (cliente/habitación no coinciden), y está dentro del rango de las habitaciones

                            System.out.println("\tNo se han podido verificar los datos de la reserva.");
                            System.out.println("\tEl nombre del cliente no coincide con la habitación indicada.");

                        } else {// Si la bandera 'factura' es true (cliente y habitación correctos)

                            do {
                                // validación de que las noches no sean negativas
                                //Solicitamos la factura como un String para después pasarla a un LocalDate
                                do {
                                    fechaValida = true;
                                    System.out.print("\tIntroduzca la fecha de salida (dd/MM/yyyy): ");
                                    fecha = s.nextLine();
                                    if (fecha.length() != 10) fechaValida = false;
                                    else {
                                        for (int i = 0; i < fecha.length(); i++) {
                                            char c = fecha.charAt(i);
                                            if (i == 2 || i == 5) {
                                                if (c != '/') fechaValida = false;
                                            } else if (!Character.isDigit(c)) fechaValida = false;
                                            if (!fechaValida) i = fecha.length() + 1;
                                        }
                                    }
                                    if (!fechaValida) {
                                        System.out.print("\tDebe introducir una fecha o el formato no es el correcto");
                                        s.nextLine();
                                        for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                                    }
                                } while (!fechaValida);

                                fechaSalida = LocalDate.parse(fecha, inputFormatter);

                                //Calculamos los días que hay entre la entrada y salida del cliente
                                numNoches = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
                                if (numNoches <= 0) {
                                    System.out.printf("\tLa fecha de salida debe ser posterior a la fecha %s\n", fechaEntrada.format(inputFormatter));
                                    s.nextLine();
                                    for (int i = 0; i < 50; i++) System.out.println();

                                }

                            } while (numNoches <= 0);

                            //Calculamos el importe de la factura
                            totalSinIva = tarifaNoche * numNoches;
                            valorIVA = (totalSinIva * IVA) / 100;
                            totalConIVA = totalSinIva + valorIVA;

                            // Incrementamos los contadores globales
                            ingresosTotales += totalConIVA; // Suma al total de ingresos
                            reservasFinalizadas++; // Incrementa el contador de checkouts
                            numReserva++; // Incrementa el número de confirmación para la próxima reserva

                            try {
                                System.out.print("\n\tCalculando y generando factura");

                                for (int i = 0; i < 3; i++) {
                                    Thread.sleep(450);
                                    System.out.print(".");
                                }
                                // Añadimos un salto de línea final antes de mostrar la factura
                                System.out.println();

                            } catch (InterruptedException e) {
                                System.out.println("\tSe interrumpió el cálculo de la factura.");
                            }

                            for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                            //Aquí se pinta la factura
                            System.out.printf("""
                                            \t*******************************************************
                                            \t*               FACTURA DE ALOJAMIENTO                *
                                            \t*******************************************************
                                            \t
                                            \tDescripción: %s
                                            \tConfirmación: %d
                                            \t
                                            \tEntrada:  %s
                                            \tSalida:   %s
                                            \tPax:      %d Huésped(es)
                                            \tNoches:   %d
                                            \t
                                            \tTarifa (por noche):%16.2f €
                                            \t-------------------------------------------------------
                                            \t
                                            \tMonto o Total (SIN IVA):%11.2f €
                                            \tIVA (21%%):%25.2f €
                                            \t-------------------------------------------------------
                                            \tTOTAL A PAGAR (CON IVA):%11.2f €
                                            \t*******************************************************
                                            """, nombreCliente.substring(0, 1).toUpperCase() + nombreCliente.substring(1),
                                    numReserva, fechaEntrada.format(outputFormatter),
                                    fechaSalida.format(outputFormatter), huespedes, numNoches, tarifaNoche,
                                    totalSinIva, valorIVA, totalConIVA
                            );
                            System.out.print("\tPulse una tecla para realizar el pago");
                            s.nextLine();

                            // --- INICIO DEL PROCESO DE PAGO Y CAMBIO ---

                            do {
                                for (int i = 0; i < 3; i++) System.out.println(); //Limpiar la pantalla
                                System.out.printf("""
                                        \tPrecio sin IVA: %4.2f
                                        \tIVA 21: %4.2f
                                        \tPrecio con IVA: %4.2f
                                        """, totalSinIva, valorIVA, totalConIVA);
                                System.out.printf("\t¿Cuanto es el importe que va a abonar? (no puede ser inferior a %.2f): ", totalConIVA);
                                pago = Double.parseDouble(s.nextLine());

                                try {
                                    System.out.print("\n\tCalculando cambio");

                                    for (int i = 0; i < 3; i++) {
                                        Thread.sleep(450);
                                        System.out.print(".");
                                    }
                                    // Añadimos un salto de línea final antes de mostrar la factura
                                    System.out.println();

                                } catch (InterruptedException e) {
                                    System.out.println("\tSe interrumpió el cálculo del cambio.");
                                }

                                if (pago < totalConIVA)
                                    System.out.printf("\tLe recuerdo que le importe a pagar debe ser superior a %.2f", totalConIVA);
                            } while (pago < totalConIVA);

                            double cambio = Math.abs(pago - totalConIVA);

                            // Redondeo inicial seguro para evitar problemas de precisión de 'double'
                            cambio = (Math.round(cambio * 100.0) / 100.0);

                            for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                            System.out.println("\tCambio a devolver: " + cambio);

                            if (cambio == 0) System.out.println("\tEl cambio es exacto");

                            // Bucle para calcular el desglose del cambio
                            // Va desde la denominación más alta (500 €) a la más baja (0.01 €)
                            while (cambio > 0) {
                                // Redondeo en cada iteración para mitigar errores de coma flotante
                                cambio = (Math.round(cambio * 100.0) / 100.0);

                                if (cambio >= 500 && totalBilletes500 != 0) { //Comprueba si el cambio es mayor a 500
                                    billetes500 = (int) (cambio / 500); // Se usa int casting para la división
                                    System.out.printf("\t\tBilletes de 500 euros: %d\n", billetes500); //Informa la cantidad de la divisa
                                    cambio -= billetes500 * 500; // Restar, ya que el operador % no funciona bien con doubles
                                    totalBilletes500 -= billetes500; //Le resta los billetes al total de billetes
                                } else if (cambio >= 200 && totalBilletes200 != 0) {
                                    billetes200 = (int) (cambio / 200);
                                    System.out.printf("\t\tBilletes de 200 euros: %d\n", billetes200);
                                    cambio -= billetes200 * 200;
                                    totalBilletes200 -= billetes200;
                                } else if (cambio >= 100 && totalBilletes100 != 0) {
                                    billetes100 = (int) (cambio / 100);
                                    System.out.printf("\t\tBilletes de 100 euros: %d\n", billetes100);
                                    cambio -= billetes100 * 100;
                                    totalBilletes100 -= billetes100;
                                } else if (cambio >= 50 && totalBilletes50 != 0) {
                                    billetes50 = (int) (cambio / 50);
                                    System.out.printf("\t\tBilletes de  50 euros: %d\n", billetes50);
                                    cambio -= billetes50 * 50;
                                    totalBilletes50 -= billetes50;
                                } else if (cambio >= 20 && totalBilletes20 != 0) {
                                    billetes20 = (int) (cambio / 20);
                                    System.out.printf("\t\tBilletes de  20 euros: %d\n", billetes20);
                                    cambio -= billetes20 * 20;
                                    totalBilletes20 -= billetes20;
                                } else if (cambio >= 10 && totalBilletes10 != 0) {
                                    billetes10 = (int) (cambio / 10);
                                    System.out.printf("\t\tBilletes de  10 euros: %d\n", billetes10);
                                    cambio -= billetes10 * 10;
                                    totalBilletes10 -= billetes10;
                                } else if (cambio >= 5 && totalBilletes5 != 0) {
                                    billetes5 = (int) (cambio / 5);
                                    System.out.printf("\t\tBilletes de   5 euros: %d\n", billetes5);
                                    cambio -= billetes5 * 5;
                                    totalBilletes5 -= billetes5;
                                } else if (cambio >= 2 && totalMonedas2e != 0) {
                                    monedas2e = (int) (cambio / 2);
                                    System.out.printf("\t\tModena de 2 euros: %d\n", monedas2e);
                                    cambio -= monedas2e * 2;
                                    totalMonedas2e -= monedas2e;
                                } else if (cambio >= 1 && totalMonedas1e != 0) {
                                    monedas1e = (int) (cambio / 1);
                                    System.out.printf("\t\tModena de 1 euros: %d\n", monedas1e);
                                    cambio -= monedas1e * 1;
                                    totalMonedas1e -= monedas1e;
                                } else if (cambio >= 0.50 && totalMonedas50cent != 0) {
                                    monedas50cent = (int) (cambio / 0.50);
                                    System.out.printf("\t\tModena de 0.50 euros: %d\n", monedas50cent);
                                    cambio -= monedas50cent * 0.50; // Restar la cantidad dada
                                    totalMonedas50cent -= monedas50cent;
                                } else if (cambio >= 0.20 && totalMonedas20cent != 0) {
                                    monedas20cent = (int) (cambio / 0.20);
                                    System.out.printf("\t\tModena de 0.20 euros: %d\n", monedas20cent);
                                    cambio -= monedas20cent * 0.20;
                                    totalMonedas20cent -= monedas20cent;
                                } else if (cambio >= 0.10 && totalMonedas10cent != 0) {
                                    monedas10cent = (int) (cambio / 0.10);
                                    System.out.printf("\t\tModena de 0.10 euros: %d\n", monedas10cent);
                                    cambio -= monedas10cent * 0.10;
                                    totalMonedas10cent -= monedas10cent;
                                } else if (cambio >= 0.05 && totalMonedas5cent != 0) {
                                    monedas5cent = (int) (cambio / 0.05);
                                    System.out.printf("\t\tModena de 0.05 euros: %d\n", monedas5cent);
                                    cambio -= monedas5cent * 0.05;
                                    totalMonedas5cent -= monedas5cent;
                                } else if (cambio >= 0.02 && totalMonedas2cent != 0) {
                                    monedas2cent = (int) (cambio / 0.02);
                                    System.out.printf("\t\tModena de 0.02 euros: %d\n", monedas2cent);
                                    cambio -= monedas2cent * 0.02;
                                    totalMonedas2cent -= monedas2cent;
                                } else if (cambio >= 0.01 && totalMonedas1cent != 0) {
                                    monedas1cent = (int) (cambio / 0.01);
                                    System.out.printf("\t\tModena de 0.01 euros: %d\n", monedas1cent);
                                    cambio -= monedas1cent * 0.01; // Restar la cantidad dada (soluciona el problema)
                                    totalMonedas1cent -= monedas1cent;
                                } else if (cambio == 0) {

                                } else { // Si no se puede dar cambio con ninguna denominación
                                    if (cambio > 0.01) {
                                        System.out.printf("\tNo hay suficientes monedas/billetes para dar %.2f € de cambio restante.\n", cambio);
                                    }
                                    cambio = 0; // Forzamos la salida del bucle
                                }
                            }// fin del while que válida que el cambio sea mayor de 0
                        }
                    }
                    System.out.print("\tPulse una tecla para volver al menú");
                    s.nextLine();
                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                    try { //Tiempo de espera
                        System.out.print("\n\tVolviendo al menú principal");

                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(400);
                            System.out.print(".");
                        }
                        System.out.println();

                    } catch (InterruptedException e) {
                        System.out.println("\tSe interrumpió la salida");
                    }
                    break;
                case "d": //Mostrar el menú de administrador
                    try { //Tiempo de espera
                        System.out.print("\n\tRedirigiéndose a la opción d ");
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        System.out.println();
                    } catch (InterruptedException e) {
                        System.out.println("\tSe interrumpió la entrada");
                    }
                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                    // Inicia el proceso de LOGIN para el menú de administrador.

                    System.out.print("""
                            \t┓ ┏┓┏┓┳┳┓  ┏┓┳┓┳┳┓┳┳┓
                            \t┃ ┃┃┃┓┃┃┃  ┣┫┃┃┃┃┃┃┃┃
                            \t┗┛┗┛┗┛┻┛┗  ┛┗┻┛┛ ┗┻┛┗
                            \n""");

                    System.out.print("\tIntroduzca el usuario: ");
                    user = s.nextLine();
                    System.out.print("\tIntroduzca la clave: ");
                    pass = s.nextLine();

                    if (!user.equals(NOMBRE_ADMIN) || !pass.equals(ClAVE_ADMIN)) {
                        System.out.print("\tNombre o usuario incorrecto");
                        try { //Tiempo de espera
                            System.out.print("\n\tVolviendo al menú principal");
                            for (int i = 0; i < 3; i++) {
                                Thread.sleep(425);
                                System.out.print(".");
                            }
                            System.out.println();
                        } catch (InterruptedException e) {
                            System.out.println("\tSe interrumpió la entrada");
                        }
                    } else {
                        // Si el login es correcto, entra en el bucle del menú de admin
                        for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                        try { //Tiempo de espera
                            System.out.print("\n\tCargando menú de admin");
                            for (int i = 0; i < 3; i++) {
                                Thread.sleep(500);
                                System.out.print(".");
                            }
                            System.out.println();
                        } catch (InterruptedException e) {
                            System.out.println("\tSe interrumpió la entrada");
                        }
                        do {
                            for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                            System.out.print("""
                                    \t┳┓┳┏┓┳┓┓┏┏┓┳┓┳┳┓┏┓  ┏┓┳┓┳┳┓┳┳┓
                                    \t┣┫┃┣ ┃┃┃┃┣ ┃┃┃┃┃┃┃  ┣┫┃┃┃┃┃┃┃┃
                                    \t┻┛┻┗┛┛┗┗┛┗┛┛┗┻┻┛┗┛  ┛┗┻┛┛ ┗┻┛┗\n""");
                            System.out.print("""
                                    \t╭────────────────────────────────────────────────────────────────────────────────────╮
                                    \t│                                 MENÚ ADMINISTRADOR                                 │
                                    \t├────────────────────────────────────────────────────────────────────────────────────┤
                                    \t│ [   i ] Consultar los ingresos totales y el número de reservas finalizadas.        │
                                    \t│ [  ii ] Consultar las monedas restantes para el cambio.                            │
                                    \t│ [ iii ] Volver al menú principal.                                                  │
                                    \t│                                                                                    │
                                    \t├────────────────────────────────────────────────────────────────────────────────────┤
                                    \t│ [  iv ] Apagar el software.                                                        │
                                    \t╰────────────────────────────────────────────────────────────────────────────────────╯
                                    
                                    \tElige una opción (i-iv):\s""");
                            opAdmin = s.nextLine().toLowerCase();

                            for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                            // Switch para las opciones de administrador
                            switch (opAdmin) {
                                case "i": //Consulta el ingreso y el número de reservas
                                    // Muestra las variables 'ingresosTotales' y 'reservasFinalizadas'
                                    // que se actualizan durante el 'case "c"' (checkout).
                                    try { //Tiempo de espera
                                        System.out.print("\n\tRedirigiéndose a la opción i ");
                                        for (int i = 0; i < 3; i++) {
                                            Thread.sleep(400);
                                            System.out.print(".");
                                        }
                                        System.out.println();
                                    } catch (InterruptedException e) {
                                        System.out.println("\tSe interrumpió la entrada");
                                    }

                                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla

                                    System.out.printf("""
                                                    \t╭─────────────────────────────────────────────────╮
                                                    \t│       ESTADÍSTICAS HOTEL CIUDAD DE MARTOS       │
                                                    \t├─────────────────────────────┬───────────────────┤
                                                    \t│ Ingresos Totales (EUR)      │ %17.2f │
                                                    \t│ Reservas Finalizadas (Uds.) │ %17d │
                                                    \t╰─────────────────────────────┴───────────────────╯
                                                    """,
                                            ingresosTotales,
                                            reservasFinalizadas
                                    );
                                    System.out.print("\tPulse una tecla para volver al menú");
                                    s.nextLine();

                                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla

                                    try { //Tiempo de espera
                                        System.out.print("\n\tVolviendo al menú");

                                        for (int i = 0; i < 3; i++) {
                                            Thread.sleep(500);
                                            System.out.print(".");
                                        }
                                        System.out.println();

                                    } catch (InterruptedException e) {
                                        System.out.println("\tSe interrumpió la salida");
                                    }

                                    break;
                                case "ii": // Nos da información de la cantidad de monedas/billetes que nos quedan
                                    // Muestra el estado actual de todas las variables 'totalBilletes...' y 'totalMonedas...'
                                    // que se van decrementando durante el cálculo del cambio en el 'case "c"'.
                                    try { //Tiempo de espera
                                        System.out.print("\n\tRedirigiéndose a la opción ii ");
                                        for (int i = 0; i < 3; i++) {
                                            Thread.sleep(400);
                                            System.out.print(".");
                                        }
                                        System.out.println();
                                    } catch (InterruptedException e) {
                                        System.out.println("\tSe interrumpió la entrada");
                                    }

                                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla

                                    System.out.printf("""
                                                    \t╭───────────────────────────────────────╮
                                                    \t│       DESGLOSE DE CAMBIO (CAJA)       │
                                                    \t├───────────────────┬───────────────────┤
                                                    \t│      BILLETES     │      MONEDAS      │
                                                    \t├───────────────────┼───────────────────┤
                                                    \t│ %-8s : %6d │ %-8s : %6d │
                                                    \t│ %-8s : %6d │ %-8s : %6d │
                                                    \t│ %-8s : %6d │ %-8s : %6d │
                                                    \t│ %-8s : %6d │ %-8s : %6d │
                                                    \t│ %-8s : %6d │ %-8s : %6d │
                                                    \t│ %-8s : %6d │ %-8s : %6d │
                                                    \t│ %-8s : %6d │ %-8s : %6d │
                                                    \t│ %-17s │ %-8s : %6d │
                                                    \t╰───────────────────┴───────────────────╯
                                                    """, "500 €", totalBilletes500, "2 €", totalMonedas2e,
                                            "200 €", totalBilletes200, "1 €", totalMonedas1e,
                                            "100 €", totalBilletes100, "50 cent", totalMonedas50cent,
                                            "50 €", totalBilletes50, "20 cent", totalMonedas20cent,
                                            "20 €", totalBilletes20, "10 cent", totalMonedas10cent,
                                            "10 €", totalBilletes10, "5C cent", totalMonedas5cent,
                                            "5 €", totalBilletes5, "2 cent", totalMonedas2cent,
                                            "", "1 cent", totalMonedas1cent
                                    );
                                    System.out.print("\tPulse una tecla para volver al menú");
                                    s.nextLine();

                                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla

                                    try { //Tiempo de espera
                                        System.out.print("\n\tVolviendo al menú");

                                        for (int i = 0; i < 3; i++) {
                                            Thread.sleep(250);
                                            System.out.print(".");
                                        }
                                        System.out.println();

                                    } catch (InterruptedException e) {
                                        System.out.println("\tSe interrumpió la salida");
                                    }
                                    break;
                                case "iii": //apaga el programa
                                    volver = false;
                                    try { //Tiempo de espera
                                        System.out.print("\n\tVolviendo al menú principal");

                                        for (int i = 0; i < 3; i++) {
                                            Thread.sleep(500);
                                            System.out.print(".");
                                        }
                                        System.out.println();

                                    } catch (InterruptedException e) {
                                        System.out.println("\tSe interrumpió el proceso");
                                    }
                                    break;
                                case "iv": //apaga el programa
                                    salir = false;
                                    try { //Tiempo de espera
                                        System.out.print("\n\tApagando programa");

                                        for (int i = 0; i < 3; i++) {
                                            Thread.sleep(500);
                                            System.out.print(".");
                                        }
                                        System.out.println();

                                    } catch (InterruptedException e) {
                                        System.out.println("\tSe interrumpió el proceso");
                                    }
                                    break;
                                default:
                                    System.out.print("""
                                            \tOpción introducida no válida.
                                            \tPulse cualquier tecla para continuar
                                            """);
                                    s.nextLine();
                            }
                            // El bucle de admin continúa mientras 'salir' sea true
                        } while (salir && volver);
                    }
                    break;
                default:
                    // Se ejecuta si 'op' no es "a", "b", "c", o "d".
                    System.out.print("""
                            \tOpción introducida no válida.
                            \tPulse cualquier tecla para continuar
                            """);
                    s.nextLine();

            }
            // El bucle principal continúa mientras 'salir' sea true
        }
        while (salir);
    }
}