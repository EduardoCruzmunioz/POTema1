import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Constantes y variables de valores económicos
        final int PRECIO_HABITACION_INDIVIDUAL = 45;
        final int PRECIO_HABITACION_DOBLE = 60;
        double ingresosTotales = 0.00;

        // Variables para guardar el precio del producto el dinero con el que paga y el cambio a realizar
        final int IVA = 21;
        double tarifaNoche = 0, totalSinIva = 0, subtotal = 0, valorIVA = 0, totalConIVA = 0;

        // Inicio de variables del dinero que tenemos en la caja
        int totalBilletes500 = 10, totalBilletes200 = 10, totalBilletes100 = 10, totalBilletes50 = 10,
                totalBilletes20 = 10, totalBilletes10 = 10, totalBilletes5 = 10, totalMonedas2e = 10,
                totalMonedas1e = 10, totalMonedas50cent = 10, totalMonedas20cent = 10, totalMonedas10cent = 10,
                totalMonedas5cent = 10, totalMonedas2cent = 10, totalMonedas1cent = 10;

        // Variables que contabilizán las cantidades de billetes o monedas a dar
        int billetes500, billetes200, billetes100, billetes50, billetes20, billetes10, billetes5,
                monedas2e, monedas1e, monedas50cent, monedas20cent, monedas10cent, monedas5cent, monedas2cent, monedas1cent;

        //Constantes y variables para el login
        final String NOMBRE_ADMIN = "hola";
        final String ClAVE_ADMIN = "hola";
        String user, pass;

        int reservasFinalizadas = 0;

        boolean salir = true;
        String op, opAdmin, tipoHabitacion;

        // Estado de las habitaciones: false = libre, true = ocupada (La habitación 9 y 10 son las individuales y las demás dobles)
        boolean hab1 = false, hab2 = false, hab3 = false, hab4 = false, hab5 = false, hab6 = false, hab7 = false, hab8 = false, hab9 = false, hab10 = false;
        String nombreHab1 = "", nombreHab2 = "", nombreHab3 = "", nombreHab4 = "", nombreHab5 = "", nombreHab6 = "",
                nombreHab7 = "", nombreHab8 = "", nombreHab9 = "", nombreHab10 = "";
        String numHab, nombreCliente = "", telefono;
        boolean factura = false;

        int numReserva = 2025;
        long numNoches = 0;
        int huespedes = 0;

        // Variables de fechas
        // System.out.println(fechaHab1.format(outputFormatter));
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter ouputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaHab1 = null, fechaHab2 = null, fechaHab3 = null, fechaHab4 = null, fechaHab5 = null,
                fechaHab6 = null, fechaHab7 = null, fechaHab8 = null, fechaHab9 = null, fechaHab10 = null,
                fechaSalida = null, fechaEntrada = null;
        String fecha;


        do {
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
            switch (op) {
                case "a": //Ver estado de ocupación
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
                    break;
                case "b": //Reservar las habitaciones
                    do {
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
                                
                                Introduzca una opción (1-3):\s""");
                        tipoHabitacion = s.nextLine();
                        if (!tipoHabitacion.equalsIgnoreCase("iii")) {
                            System.out.print("Introduzca un nombre para la reserva: ");
                            nombreCliente = s.nextLine().toLowerCase();
                        }
                        switch (tipoHabitacion) {
                            case "i":
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
                                break;

                            case "ii":
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
                                break;
                            case "iii":
                                System.out.println("volviendo al menu principal");
                                break;
                            default:
                                System.out.println("Opción introducida no válida");
                        }
                        System.out.print("Pulse una tecla para volver al menú");
                        s.nextLine();
                    } while (!tipoHabitacion.equalsIgnoreCase("iii"));
                    break;
                case "c": //Realizar checkouts
                    factura = false;
                    System.out.print("Introduzca el nombre del cliente: ");
                    nombreCliente = s.nextLine().toLowerCase();
                    do {
                        System.out.print("Introduzca el número de teléfono: ");
                        telefono = s.nextLine();
                    } while (telefono.length() != 9);
                    System.out.print("Introduzca el número de la habitación (1 al 10): ");
                    numHab = s.nextLine();
                    switch (numHab) {
                        case "1", "2", "3", "4", "5", "6", "7", "8":
                            if (numHab.equals("1") && nombreHab1.equals(nombreCliente)) {
                                fechaEntrada = fechaHab1;
                                factura = true;
                            }
                            if (numHab.equals("2") && nombreHab2.equals(nombreCliente)) {
                                fechaEntrada = fechaHab2;
                                factura = true;
                            }
                            if (numHab.equals("3") && nombreHab3.equals(nombreCliente)) {
                                fechaEntrada = fechaHab3;
                                factura = true;
                            }
                            if (numHab.equals("4") && nombreHab4.equals(nombreCliente)) {
                                fechaEntrada = fechaHab4;
                                factura = true;
                            }
                            if (numHab.equals("5") && nombreHab5.equals(nombreCliente)) {
                                fechaEntrada = fechaHab5;
                                factura = true;
                            }
                            if (numHab.equals("6") && nombreHab6.equals(nombreCliente)) {
                                fechaEntrada = fechaHab6;
                                factura = true;
                            }
                            if (numHab.equals("7") && nombreHab7.equals(nombreCliente)) {
                                fechaEntrada = fechaHab7;
                                factura = true;
                            }
                            if (numHab.equals("8") && nombreHab8.equals(nombreCliente)) {
                                fechaEntrada = fechaHab8;
                                factura = true;
                            }

                            System.out.print("Introduzca la fecha de salida (dd/MM/yyyy): ");
                            fecha = s.nextLine();
                            fechaSalida = LocalDate.parse(fecha, inputFormatter);
                            if (fechaEntrada != null) {
                                numNoches = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
                            }
                            huespedes = 2;
                            tarifaNoche = PRECIO_HABITACION_DOBLE;
                            totalSinIva = tarifaNoche * numNoches;
                            valorIVA = (totalSinIva * IVA) / 100;
                            totalConIVA = totalSinIva + valorIVA;

                            break;
                        default:
                            System.out.println("Habitación introducida no existente compruebe de nuevo");
                    }
                    if (factura) {

                        System.out.printf("""
                                        *******************************************************
                                        *                FACTURA DE ALOJAMIENTO               *
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
                                        Subtotal (Base Imponible):\t%.2f €
                                        IVA (21%%):\t\t%.2f €
                                        -------------------------------------------------------
                                        TOTAL A PAGAR (CON IVA):\t%.2f €
                                        *******************************************************
                                        """,

                                // AQUÍ DEBES PONER LAS VARIABLES REALES EN EL ORDEN ESPECIFICADO:
                                nombreCliente, // Descripción
                                numReserva,    // Confir
                                fechaEntrada.format(ouputFormatter), // Entrada (Ejemplo con un LocalDate)
                                fechaSalida.format(ouputFormatter),  // Salida (Ejemplo con un LocalDate)
                                huespedes,     // Pax (int)
                                numNoches,     // Noches (int)
                                tarifaNoche,   // Tarifa (double)
                                totalSinIva,    // Monto o Total (double)
                                subtotal,      // Subtotal (double)
                                valorIVA,      // IVA (double)
                                totalConIVA    // TOTAL (double)
                        );

                    }
                    break;
                case "d": //Mostrar el menú de administrador
                    System.out.print("Introduzca el usuario: ");
                    user = s.nextLine();
                    System.out.print("Introduzca la clave: "); // Este es el bug que te mencioné!
                    pass = s.nextLine();

                    if (!user.equals(NOMBRE_ADMIN) && !pass.equals(ClAVE_ADMIN)) {
                        System.out.print("Nombre o usuario incorrecto");
                        s.nextLine();
                    } else {
                        do {
                            System.out.print("""
                                    
                                    ╭────────────────────────────────────────────────────────────────────────────────────╮
                                    │                                 MENÚ ADMINISTRADOR                                 │
                                    ├────────────────────────────────────────────────────────────────────────────────────┤
                                    │ [i]   Consultar los ingresos totales y el número de reservas finalizadas.          │
                                    │ [ii]  Consultar las monedas restantes para el cambio.                              │
                                    │ [iii] Apagar el software                                                           │
                                    ╰────────────────────────────────────────────────────────────────────────────────────╯
                                    
                                    Elige una opción (i-iii):\s""");
                            opAdmin = s.nextLine().toLowerCase();
                            switch (opAdmin) {
                                case "i": //Consulta el ingreso y el número de reservas
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
                                    break;
                                case "ii": // Nos da información de la cantidad de monedas/billetes que nos quedan
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
                                    break;
                                case "iii": //apaga el programa
                                    salir = false;
                                    System.out.println("Apagando programa");
                                    break;
                                default:
                                    System.out.println("Opción introducida no valida");
                            }
                        } while (salir);
                    }
                    break;
                default:
                    System.out.print("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (salir);
    }


}