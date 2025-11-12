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
        double tarifaNoche = 0, totalSinIva = 0, subtotal = 0, valorIVA = 0, totalConIVA = 0, pago = 0;

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
        String user, pass;

        int reservasFinalizadas = 0;

        boolean salir = true, volver = true;
        String op, opAdmin, tipoHabitacion;

        // Estado de las habitaciones: false = libre, true = ocupada (La habitación 9 y 10 son las individuales y las demás dobles)
        // Nota: Esto sería más fácil de manejar con un array de booleanos.
        boolean hab1 = false, hab2 = false, hab3 = false, hab4 = false, hab5 = false, hab6 = false, hab7 = false, hab8 = false, hab9 = false, hab10 = false;
        String nombreHab1 = "", nombreHab2 = "", nombreHab3 = "", nombreHab4 = "", nombreHab5 = "", nombreHab6 = "",
                nombreHab7 = "", nombreHab8 = "", nombreHab9 = "", nombreHab10 = "";
        String numHab, nombreCliente = "", telefono;
        boolean factura = false;

        int numReserva = 20251100;
        long numNoches = 0;
        int huespedes = 0;

        // Variables de fechas
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter ouputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaHab1 = null, fechaHab2 = null, fechaHab3 = null, fechaHab4 = null, fechaHab5 = null,
                fechaHab6 = null, fechaHab7 = null, fechaHab8 = null, fechaHab9 = null, fechaHab10 = null,
                fechaSalida = null, fechaEntrada = null;
        String fecha;


        // Bucle principal del programa
        do {
            for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
            // Nos muestra el menú
            System.out.print("""
                    ╭────────────────────────────────────────────╮
                    │           HOTEL CIUDAD DE MARTOS           │
                    ├────────────────────────────────────────────┤
                    │ [a] Ver estado de ocupación                │
                    │ [b] Reservar una habitación                │
                    │ [c] Realizar checkout                      │
                    │ [d] Menú de administrador                  │
                    ╰────────────────────────────────────────────╯
                    
                    Elige una opcion:\s""");
            // Escribe la opción que quieres
            op = s.nextLine().toLowerCase();

            // Switch principal que gestiona las opciones del menú
            switch (op) {
                case "a": //Ver estado de ocupación
                    try { //Tiempo de espera
                        System.out.print("\nRedirigiéndose a la opción a");
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
                    // Usa operadores ternarios (hab1 ? "Ocupada" : "Libre") para determinar qué string mostrar.
                    System.out.printf("""
                            ╭────────────────────────────────────────────╮
                            │           HOTEL CIUDAD DE MARTOS           │
                            ├────────────────────────────────────────────┤
                            │         ESTADO DE LAS HABITACIONES         │
                            ├────────────┬────────────┬──────────────────┤
                            │ Habitación │    Tipo    │      Estado      │
                            ├────────────┼────────────┼──────────────────┤
                            │ 1          │ Doble      │ %-16s │
                            │ 2          │ Doble      │ %-16s │
                            │ 3          │ Doble      │ %-16s │
                            │ 4          │ Doble      │ %-16s │
                            │ 5          │ Doble      │ %-16s │
                            │ 6          │ Doble      │ %-16s │
                            │ 7          │ Doble      │ %-16s │
                            │ 8          │ Doble      │ %-16s │
                            │ 9          │ Individual │ %-16s │
                            │ 10         │ Individual │ %-16s │
                            ╰────────────┴────────────┴──────────────────╯
                            """, (hab1 ? "Ocupada" : "Libre"), (hab2 ? "Ocupada" : "Libre"), (hab3 ? "Ocupada" : "Libre"), (hab4 ? "Ocupada" : "Libre"), (hab5 ? "Ocupada" : "Libre"), (hab6 ? "Ocupada" : "Libre"), (hab7 ? "Ocupada" : "Libre"), (hab8 ? "Ocupada" : "Libre"), (hab9 ? "Ocupada" : "Libre"), (hab10 ? "Ocupada" : "Libre"));
                    System.out.print("Pulse una tecla para volver al menú");
                    s.nextLine();
                    try {//Tiempo de espera
                        System.out.print("\nVolviendo al menú");

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
                        System.out.print("\nRedirigiéndose a la opción b");
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        System.out.println();
                    } catch (InterruptedException e) {
                        System.out.println("Se interrumpió la entrada");
                    }
                    // Inicia el submenú para reservar una habitación.
                    do {
                        for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                        System.out.print("""
                                
                                ╭────────────────────────────────────╮
                                │          SELECCIONAR TIPO          │
                                ├────────────────────────────────────┤
                                │ [i] Habitación Doble               │
                                │ [ii] Habitación Individual         │
                                │                                    │
                                ├────────────────────────────────────┤
                                │ [iii] Volver al menú anterior      │
                                ╰────────────────────────────────────╯
                                
                                Introduzca una opción (i - iii):\s""");
                        tipoHabitacion = s.nextLine();
                        if (!tipoHabitacion.equalsIgnoreCase("iii")) {
                            for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                            System.out.print("Introduzca un nombre para la reserva: ");
                            nombreCliente = s.nextLine().toLowerCase();
                        }

                        // Switch para gestionar el tipo de habitación a reservar
                        switch (tipoHabitacion) {
                            case "i": // Lógica para reservar habitación DOBLE
                                if (!hab1) {
                                    fechaHab1 = LocalDate.now();
                                    hab1 = true;
                                    nombreHab1 = nombreCliente;
                                    System.out.println("Habitación asignada número 1 con fecha asignada " + fechaHab1.format(inputFormatter));

                                } else if (!hab2) {
                                    fechaHab2 = LocalDate.now();
                                    hab2 = true;
                                    nombreHab2 = nombreCliente;
                                    System.out.println("Habitación asignada número 2 con fecha asignada " + fechaHab2.format(inputFormatter));

                                } else if (!hab3) {
                                    fechaHab3 = LocalDate.now();
                                    hab3 = true;
                                    nombreHab3 = nombreCliente;
                                    System.out.println("Habitación asignada número 3 con fecha asignada " + fechaHab3.format(inputFormatter));

                                } else if (!hab4) {
                                    fechaHab4 = LocalDate.now();
                                    hab4 = true;
                                    nombreHab4 = nombreCliente;
                                    System.out.println("Habitación asignada número 4 con fecha asignada " + fechaHab4.format(inputFormatter));

                                } else if (!hab5) {
                                    fechaHab5 = LocalDate.now();
                                    hab5 = true;
                                    nombreHab5 = nombreCliente;
                                    System.out.println("Habitación asignada número 5 con fecha asignada " + fechaHab5.format(inputFormatter));

                                } else if (!hab6) {
                                    fechaHab6 = LocalDate.now();
                                    hab6 = true;
                                    nombreHab6 = nombreCliente;
                                    System.out.println("Habitación asignada número 6 con fecha asignada " + fechaHab6.format(inputFormatter));

                                } else if (!hab7) {
                                    fechaHab7 = LocalDate.now();
                                    hab7 = true;
                                    nombreHab7 = nombreCliente;
                                    System.out.println("Habitación asignada número 7 con fecha asignada " + fechaHab7.format(inputFormatter));

                                } else if (!hab8) {
                                    fechaHab8 = LocalDate.now();
                                    hab8 = true;
                                    nombreHab8 = nombreCliente;
                                    System.out.println("Habitación asignada número 8 con fecha asignada " + fechaHab8.format(inputFormatter));

                                } else System.out.println("Todas las habitaciones dobles están ocupadas");
                                System.out.print("Pulse una tecla para volver al submenú");
                                s.nextLine();

                                try { //Tiempo de espera
                                    System.out.print("\nVolviendo al submenú");

                                    for (int i = 0; i < 3; i++) {
                                        Thread.sleep(450);
                                        System.out.print(".");
                                    }
                                    System.out.println();

                                } catch (InterruptedException e) {
                                    System.out.println("Se interrumpió la salida");
                                }
                                break;

                            case "ii": // Lógica para reservar habitación INDIVIDUAL
                                // Busca la primera habitación individual (9-10) que esté libre
                                // y la asigna al cliente.
                                if (!hab9) {
                                    fechaHab9 = LocalDate.now();
                                    hab9 = true;
                                    nombreHab9 = nombreCliente;
                                    System.out.println("Habitación asignada número 9 con fecha asignada " + fechaHab9.format(inputFormatter));

                                } else if (!hab10) {
                                    fechaHab10 = LocalDate.now();
                                    hab10 = true;
                                    nombreHab10 = nombreCliente;
                                    System.out.println("Habitación asignada número 10 con fecha asignada " + fechaHab10.format(inputFormatter));

                                } else System.out.println("Las habitaciones individuales están ocupadas");
                                System.out.print("Pulse una tecla para volver al submenú");
                                s.nextLine();
                                try { //Tiempo de espera
                                    System.out.print("\nVolviendo al submenú");

                                    for (int i = 0; i < 3; i++) {
                                        Thread.sleep(450);
                                        System.out.print(".");
                                    }
                                    System.out.println();

                                } catch (InterruptedException e) {
                                    System.out.println("Se interrumpió la salida");
                                }
                                break;
                            case "iii": // Salir del submenú de reservas
                            try { //Tiempo de espera
                                System.out.print("\nVolviendo al menú principal");

                                for (int i = 0; i < 3; i++) {
                                    Thread.sleep(500);
                                    System.out.print(".");
                                }
                                System.out.println();

                            } catch (InterruptedException e) {
                                System.out.println("Se interrumpió la salida");
                            }
                            break;
                            default:
                                System.out.println("Opción introducida no válida");
                        }

                    } while (!tipoHabitacion.equalsIgnoreCase("iii"));

                    break;
                case "c": //Realizar checkouts
                    try { //Tiempo de espera
                        System.out.print("\nRedirigiéndose a la opción c");
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        System.out.println();
                    } catch (InterruptedException e) {
                        System.out.println("Se interrumpió la entrada");
                    }
                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                    // Inicia el proceso de CHECK-OUT del cliente.
                    factura = false; // Resetea la bandera de factura
                    System.out.print("Introduzca el nombre del cliente: ");
                    nombreCliente = s.nextLine().toLowerCase();
                    do { // Validación simple de la longitud del teléfono
                        System.out.print("Introduzca el número de teléfono: ");
                        telefono = s.nextLine();
                        if (telefono.length() != 9) {
                            System.out.println("El número debe ser de longitud 9");
                            s.nextLine();
                        }
                    } while (telefono.length() != 9);
                    System.out.print("Introduzca el número de la habitación (1 al 10): ");
                    numHab = s.nextLine();

                    // Switch para identificar la habitación y verificar el nombre del cliente
                    switch (numHab) {
                        case "1", "2", "3", "4", "5", "6", "7", "8":// Habitaciones DOBLES
                            // Comprueba si el número de habitación Y el nombre del cliente coinciden.
                            // Si coinciden, guarda la fecha de entrada y marca 'factura' como true
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
                            break;
                        case "9", "10": // Habitaciones INDIVIDUALES
                            // Misma lógica que las dobles, pero para habitaciones 9 y 10.
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
                            break;
                        default:
                            System.out.println("Habitación introducida no existente compruebe de nuevo");
                    }

                    if (!factura) { // Si 'factura' fue false (cliente/habitación no coinciden),

                        System.out.println("No se han podido verificar los datos de la reserva.");
                        System.out.println("El nombre del cliente no coincide con la habitación indicada.");

                    } else {// Si la bandera 'factura' es true (cliente y habitación correctos)

                        do {// validación de que las noches no sean negativas
                            //Solicitamos la factura como un String para después pasarla a un LocalDate
                            System.out.print("Introduzca la fecha de salida (dd/MM/yyyy): ");
                            fecha = s.nextLine();
                            fechaSalida = LocalDate.parse(fecha, inputFormatter);

                            //Calculamos los días que hay entre la entrada y salida del cliente
                            numNoches = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
                            if (numNoches <= 0) System.out.println("La fecha de salida debe ser posterior a la fecha de entrada");

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
                            System.out.print("\nCalculando y generando factura, por favor espere");

                            for (int i = 0; i < 3; i++) {
                                Thread.sleep(450);
                                System.out.print(".");
                            }
                            // Añadimos un salto de línea final antes de mostrar la factura
                            System.out.println();

                        } catch (InterruptedException e) {
                            System.out.println("Se interrumpió el cálculo de la factura.");
                        }

                        for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                        //Aquí se pinta la factura
                        System.out.printf("""
                                        *******************************************************
                                        *               FACTURA DE ALOJAMIENTO                *
                                        *******************************************************
                                        
                                        Descripción: %s
                                        Confirmación:      %d
                                        
                                        Entrada:  %s
                                        Salida:   %s
                                        Pax:      %d Huésped(es)
                                        Noches:   %d
                                        
                                        Tarifa (por noche): \t%.2f €
                                        -------------------------------------------------------
                                        
                                        Monto o Total (SIN IVA):\t%.2f €
                                        IVA (21%%):\t\t%.2f €
                                        -------------------------------------------------------
                                        TOTAL A PAGAR (CON IVA):\t%.2f €
                                        *******************************************************
                                        """, nombreCliente, numReserva, fechaEntrada.format(ouputFormatter),
                                fechaSalida.format(ouputFormatter), huespedes, numNoches, tarifaNoche,
                                totalSinIva, valorIVA, totalConIVA
                        );
                        System.out.print("Pulse una tecla para ir al pago");
                        s.nextLine();

                        // --- INICIO DEL PROCESO DE PAGO Y CAMBIO ---

                        do {
                            for (int i = 0; i < 3; i++) System.out.println(); //Limpiar la pantalla
                            System.out.printf("""
                                    Precio sin IVA: %4.2f
                                    IVA 21: %4.2f
                                    Precio con IVA: %4.2f
                                    """, totalSinIva, valorIVA, totalConIVA);
                            System.out.printf("¿Cuanto es el importe que va a abonar? (no puede ser inferior a %.2f): ", totalConIVA);
                            pago = Double.parseDouble(s.nextLine());

                            if (pago < totalConIVA)
                                System.out.printf("Le recuerdo que le importe a pagar debe ser superior a %.2f", totalConIVA);
                        } while (pago < totalConIVA);

                        double cambio = Math.abs(pago - totalConIVA);

                        // Redondeo inicial seguro para evitar problemas de precisión de 'double'
                        cambio = (Math.round(cambio * 100.0) / 100.0);

                        for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                        System.out.println("Cambio a devolver: " + cambio);

                        if (cambio == 0) System.out.println("\tEl cambio es exacto");

                        // Bucle para calcular el desglose del cambio
                        // Va desde la denominación más alta (500€) a la más baja (0.01€)
                        while (cambio > 0) {

                            // Redondeo en cada iteración para mitigar errores de coma flotante
                            cambio = (Math.round(cambio * 100.0) / 100.0);

                            if (cambio >= 500 && totalBilletes500 != 0) { //Comprueba si el cambio es mayor a 500
                                billetes500 = (int) (cambio / 500); // Se usa int casting para la división
                                System.out.printf("\tBilletes de 500 euros: %d\n", billetes500); //Informa la cantidad de la divisa
                                cambio -= billetes500 * 500; // Restar, ya que el operador % no funciona bien con doubles
                                totalBilletes500 -= billetes500; //Le resta los billetes al total de billetes
                            } else if (cambio >= 200 && totalBilletes200 != 0) {
                                billetes200 = (int) (cambio / 200);
                                System.out.printf("\tBilletes de 200 euros: %d\n", billetes200);
                                cambio -= billetes200 * 200;
                                totalBilletes200 -= billetes200;
                            } else if (cambio >= 100 && totalBilletes100 != 0) {
                                billetes100 = (int) (cambio / 100);
                                System.out.printf("\tBilletes de 100 euros: %d\n", billetes100);
                                cambio -= billetes100 * 100;
                                totalBilletes100 -= billetes100;
                            } else if (cambio >= 50 && totalBilletes50 != 0) {
                                billetes50 = (int) (cambio / 50);
                                System.out.printf("\tBilletes de  50 euros: %d\n", billetes50);
                                cambio -= billetes50 * 50;
                                totalBilletes50 -= billetes50;
                            } else if (cambio >= 20 && totalBilletes20 != 0) {
                                billetes20 = (int) (cambio / 20);
                                System.out.printf("\tBilletes de  20 euros: %d\n", billetes20);
                                cambio -= billetes20 * 20;
                                totalBilletes20 -= billetes20;
                            } else if (cambio >= 10 && totalBilletes10 != 0) {
                                billetes10 = (int) (cambio / 10);
                                System.out.printf("\tBilletes de  10 euros: %d\n", billetes10);
                                cambio -= billetes10 * 10;
                                totalBilletes10 -= billetes10;
                            } else if (cambio >= 5 && totalBilletes5 != 0) {
                                billetes5 = (int) (cambio / 5);
                                System.out.printf("\tBilletes de   5 euros: %d\n", billetes5);
                                cambio -= billetes5 * 5;
                                totalBilletes5 -= billetes5;
                            } else if (cambio >= 2 && totalMonedas2e != 0) {
                                monedas2e = (int) (cambio / 2);
                                System.out.printf("\tModena de 2 euros: %d\n", monedas2e);
                                cambio -= monedas2e * 2;
                                totalMonedas2e -= monedas2e;
                            } else if (cambio >= 1 && totalMonedas1e != 0) {
                                monedas1e = (int) (cambio / 1);
                                System.out.printf("\tModena de 1 euros: %d\n", monedas1e);
                                cambio -= monedas1e * 1;
                                totalMonedas1e -= monedas1e;
                            } else if (cambio >= 0.50 && totalMonedas50cent != 0) {
                                monedas50cent = (int) (cambio / 0.50);
                                System.out.printf("\tModena de 0.50 euros: %d\n", monedas50cent);
                                cambio -= monedas50cent * 0.50; // Restar la cantidad dada
                                totalMonedas50cent -= monedas50cent;
                            } else if (cambio >= 0.20 && totalMonedas20cent != 0) {
                                monedas20cent = (int) (cambio / 0.20);
                                System.out.printf("\tModena de 0.20 euros: %d\n", monedas20cent);
                                cambio -= monedas20cent * 0.20;
                                totalMonedas20cent -= monedas20cent;
                            } else if (cambio >= 0.10 && totalMonedas10cent != 0) {
                                monedas10cent = (int) (cambio / 0.10);
                                System.out.printf("\tModena de 0.10 euros: %d\n", monedas10cent);
                                cambio -= monedas10cent * 0.10;
                                totalMonedas10cent -= monedas10cent;
                            } else if (cambio >= 0.05 && totalMonedas5cent != 0) {
                                monedas5cent = (int) (cambio / 0.05);
                                System.out.printf("\tModena de 0.05 euros: %d\n", monedas5cent);
                                cambio -= monedas5cent * 0.05;
                                totalMonedas5cent -= monedas5cent;
                            } else if (cambio >= 0.02 && totalMonedas2cent != 0) {
                                monedas2cent = (int) (cambio / 0.02);
                                System.out.printf("\tModena de 0.02 euros: %d\n", monedas2cent);
                                cambio -= monedas2cent * 0.02;
                                totalMonedas2cent -= monedas2cent;
                            } else if (cambio >= 0.01 && totalMonedas1cent != 0) {
                                monedas1cent = (int) (cambio / 0.01);
                                System.out.printf("\tModena de 0.01 euros: %d\n", monedas1cent);
                                cambio -= monedas1cent * 0.01; // Restar la cantidad dada (soluciona el problema)
                                totalMonedas1cent -= monedas1cent;
                            } else if (cambio == 0) {

                            } else { // Si no se puede dar cambio con ninguna denominación
                                if (cambio > 0.01) {
                                    System.out.printf("No hay suficientes monedas/billetes para dar %.2f € de cambio restante.\n", cambio);
                                }
                                cambio = 0; // Forzamos la salida del bucle
                            }
                        }// fin del while que válida que el cambio sea mayor de 0
                    }
                    System.out.print("Pulse una tecla para volver al menú");
                    s.nextLine();
                    try { //Tiempo de espera
                        System.out.print("\nVolviendo al menú");

                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(400);
                            System.out.print(".");
                        }
                        System.out.println();

                    } catch (InterruptedException e) {
                        System.out.println("Se interrumpió la salida");
                    }
                    break;
                case "d": //Mostrar el menú de administrador
                    try { //Tiempo de espera
                        System.out.print("\nRedirigiéndose a la opción d");
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(500);
                            System.out.print(".");
                        }
                        System.out.println();
                    } catch (InterruptedException e) {
                        System.out.println("Se interrumpió la entrada");
                    }
                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                    // Inicia el proceso de LOGIN para el menú de administrador.
                    System.out.print("Introduzca el usuario: ");
                    user = s.nextLine();
                    System.out.print("Introduzca la clave: ");
                    pass = s.nextLine();

                    // 💡 ¡BUG CORREGIDO!
                    // La lógica original era: if (!user.equals(NOMBRE_ADMIN) && !pass.equals(ClAVE_ADMIN))
                    // Eso es incorrecto. La lógica correcta es:
                    // Si el usuario NO es admin O la clave NO es admin, entonces da error.
                    if (!user.equals(NOMBRE_ADMIN) || !pass.equals(ClAVE_ADMIN)) {
                        System.out.print("Nombre o usuario incorrecto");
                        try { //Tiempo de espera
                            System.out.print("\nVolviendo al menú principal");
                            for (int i = 0; i < 3; i++) {
                                Thread.sleep(425);
                                System.out.print(".");
                            }
                            System.out.println();
                        } catch (InterruptedException e) {
                            System.out.println("Se interrumpió la entrada");
                        }
                    } else {
                        // Si el login es correcto, entra en el bucle del menú de admin
                        try { //Tiempo de espera
                            System.out.print("\nMostrando menú");
                            for (int i = 0; i < 3; i++) {
                                Thread.sleep(500);
                                System.out.print(".");
                            }
                            System.out.println();
                        } catch (InterruptedException e) {
                            System.out.println("Se interrumpió la entrada");
                        }
                        do {
                            for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                            System.out.print("""
                                    
                                    ╭────────────────────────────────────────────────────────────────────────────────────╮
                                    │                                 MENÚ ADMINISTRADOR                                 │
                                    ├────────────────────────────────────────────────────────────────────────────────────┤
                                    │ [i]   Consultar los ingresos totales y el número de reservas finalizadas.          │
                                    │ [ii]  Consultar las monedas restantes para el cambio.                              │
                                    │ [iii] Volver al menú principal.                                                    │
                                    │ [iv] Apagar el software                                                            │
                                    ╰────────────────────────────────────────────────────────────────────────────────────╯
                                    
                                    Elige una opción (i-iii):\s""");
                            opAdmin = s.nextLine().toLowerCase();

                            // Switch para las opciones de administrador
                            switch (opAdmin) {
                                case "i": //Consulta el ingreso y el número de reservas
                                    // Muestra las variables 'ingresosTotales' y 'reservasFinalizadas'
                                    // que se actualizan durante el 'case "c"' (checkout).
                                    try { //Tiempo de espera
                                        System.out.print("\nRedirigiéndose a la opción i");
                                        for (int i = 0; i < 3; i++) {
                                            Thread.sleep(400);
                                            System.out.print(".");
                                        }
                                        System.out.println();
                                    } catch (InterruptedException e) {
                                        System.out.println("Se interrumpió la entrada");
                                    }
                                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                                    System.out.printf("""
                                                    
                                                    ╭─────────────────────────────────────────────────╮
                                                    │       ESTADÍSTICAS HOTEL CIUDAD DE MARTOS       │
                                                    ├─────────────────────────────┬───────────────────┤
                                                    │ Ingresos Totales (EUR)      │ %17.2f │
                                                    │ Reservas Finalizadas (Uds.) │ %17d │
                                                    ╰─────────────────────────────┴───────────────────╯
                                                    """,
                                            ingresosTotales,
                                            reservasFinalizadas
                                    );
                                    System.out.print("Pulse una tecla para volver al menú");
                                    s.nextLine();
                                    try { //Tiempo de espera
                                        System.out.print("\nVolviendo al menú");

                                        for (int i = 0; i < 3; i++) {
                                            Thread.sleep(500);
                                            System.out.print(".");
                                        }
                                        System.out.println();

                                    } catch (InterruptedException e) {
                                        System.out.println("Se interrumpió la salida");
                                    }
                                    break;
                                case "ii": // Nos da información de la cantidad de monedas/billetes que nos quedan
                                    // Muestra el estado actual de todas las variables 'totalBilletes...' y 'totalMonedas...'
                                    // que se van decrementando durante el cálculo del cambio en el 'case "c"'.
                                    try { //Tiempo de espera
                                        System.out.print("\nRedirigiéndose a la opción ii");
                                        for (int i = 0; i < 3; i++) {
                                            Thread.sleep(400);
                                            System.out.print(".");
                                        }
                                        System.out.println();
                                    } catch (InterruptedException e) {
                                        System.out.println("Se interrumpió la entrada");
                                    }
                                    for (int i = 0; i < 50; i++) System.out.println(); //Limpiar la pantalla
                                    System.out.printf("""
                                                    
                                                    ╭───────────────────────────────────────╮
                                                    │       DESGLOSE DE CAMBIO (CAJA)       │
                                                    ├───────────────────┬───────────────────┤
                                                    │      BILLETES     │      MONEDAS      │
                                                    ├───────────────────┼───────────────────┤
                                                    │ %-8s : %6d │ %-8s : %6d │
                                                    │ %-8s : %6d │ %-8s : %6d │
                                                    │ %-8s : %6d │ %-8s : %6d │
                                                    │ %-8s : %6d │ %-8s : %6d │
                                                    │ %-8s : %6d │ %-8s : %6d │
                                                    │ %-8s : %6d │ %-8s : %6d │
                                                    │ %-8s : %6d │ %-8s : %6d │
                                                    │ %-17s │ %-8s : %6d │
                                                    ╰───────────────────┴───────────────────╯
                                                    """, "500 €", totalBilletes500, "2 €", totalMonedas2e,
                                            "200 €", totalBilletes200, "1 €", totalMonedas1e,
                                            "100 €", totalBilletes100, "50 cent", totalMonedas50cent,
                                            "50 €", totalBilletes50, "20 cent", totalMonedas20cent,
                                            "20 €", totalBilletes20, "10 cent", totalMonedas10cent,
                                            "10 €", totalBilletes10, "5C cent", totalMonedas5cent,
                                            "5 €", totalBilletes5, "2 cent", totalMonedas2cent,
                                            "", "1 cent", totalMonedas1cent
                                    );
                                    System.out.print("Pulse una tecla para volver al menú");
                                    s.nextLine();
                                    try { //Tiempo de espera
                                        System.out.print("\nVolviendo al menú");

                                        for (int i = 0; i < 3; i++) {
                                            Thread.sleep(250);
                                            System.out.print(".");
                                        }
                                        System.out.println();

                                    } catch (InterruptedException e) {
                                        System.out.println("Se interrumpió la salida");
                                    }
                                    break;
                                case "iii": //apaga el programa
                                    volver = false;
                                    try { //Tiempo de espera
                                        System.out.print("\nVolviendo al menú principal");

                                        for (int i = 0; i < 3; i++) {
                                            Thread.sleep(500);
                                            System.out.print(".");
                                        }
                                        System.out.println();

                                    } catch (InterruptedException e) {
                                        System.out.println("Se interrumpió el proceso");
                                    }
                                    break;
                                case "iv": //apaga el programa
                                    salir = false;
                                    try { //Tiempo de espera
                                        System.out.print("\nApagando programa");

                                        for (int i = 0; i < 3; i++) {
                                            Thread.sleep(500);
                                            System.out.print(".");
                                        }
                                        System.out.println();

                                    } catch (InterruptedException e) {
                                        System.out.println("Se interrumpió el proceso");
                                    }
                                    break;
                                default:
                                    System.out.println("Opción introducida no valida");
                            }
                            // El bucle de admin continúa mientras 'salir' sea true
                        } while (salir && volver);
                    }
                    break;
                default:
                    // Se ejecuta si 'op' no es "a", "b", "c", o "d".
                    System.out.print("Opción no válida. Inténtelo de nuevo.");

            }
            // El bucle principal continúa mientras 'salir' sea true
        } while (salir);
    }
}