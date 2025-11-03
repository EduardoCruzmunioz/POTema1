import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        double precioProducto = 500, iva, precioConIva, pago = 0, cambio = 0;

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

        int reservasFinalizadas = 1782;

        boolean salir = true;
        String op, opAdmin, tipoHabitacion;

        // Estado de las habitaciones: false = libre, true = ocupada (La habitación 9 y 10 son las individuales y las demás dobles)
        boolean hab1 = false, hab2 = false, hab3 = false, hab4 = false, hab5 = false, hab6 = false, hab7 = false, hab8 = false, hab9 = false, hab10 = false;


        //o
        // System.out.println(fechaHab1.format(outputFormatter));
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter ouputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaHab1, fechaHab2, fechaHab3, fechaHab4, fechaHab5, fechaHab6, fechaHab7, fechaHab8, fechaHab9, fechaHab10;


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
                            │            HOTEL CIUDAD DE MARTOS          │
                            ├────────────────────────────────────────────┤
                            │          ESTADO DE LAS HABITACIONES        │
                            ├────────────┬────────────┬──────────────────┤
                            │ Habitación │ Tipo       │ Estado           │
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
                                
                                ╭─────────────────────────────╮
                                │     SELECCIONAR TIPO        │
                                ├─────────────────────────────┤
                                │ [1] Habitación Doble        │
                                │ [2] Habitación Individual   │
                                │                             │
                                ├─────────────────────────────┤
                                │ [3] Volver al menú anterior │
                                ╰─────────────────────────────╯
                                
                                Introduzca una opción (1-3):\s""");
                        tipoHabitacion = s.nextLine();
                        switch (tipoHabitacion) {
                            case "1":
                                if (!hab1) {
                                    fechaHab1 = LocalDate.now();
                                    hab1 = true;
                                    System.out.println("Habitación asignada número 1 con fecha asignada " + fechaHab1.format(inputFormatter));

                                } else if (!hab2) {
                                    fechaHab2 = LocalDate.now();
                                    hab2 = true;
                                    System.out.println("Habitación asignada número 2 con fecha asignada " + fechaHab2.format(inputFormatter));

                                } else if (!hab3) {
                                    fechaHab3 = LocalDate.now();
                                    hab3 = true;
                                    System.out.println("Habitación asignada número 3 con fecha asignada " + fechaHab3.format(inputFormatter));

                                } else if (!hab4) {
                                    fechaHab4 = LocalDate.now();
                                    hab4 = true;
                                    System.out.println("Habitación asignada número 4 con fecha asignada " + fechaHab4.format(inputFormatter));

                                } else if (!hab5) {
                                    fechaHab5 = LocalDate.now();
                                    hab5 = true;
                                    System.out.println("Habitación asignada número 5 con fecha asignada " + fechaHab5.format(inputFormatter));

                                } else if (!hab6) {
                                    fechaHab6 = LocalDate.now();
                                    hab6 = true;
                                    System.out.println("Habitación asignada número 6 con fecha asignada " + fechaHab6.format(inputFormatter));

                                } else if (!hab7) {
                                    fechaHab7 = LocalDate.now();
                                    hab7 = true;
                                    System.out.println("Habitación asignada número 7 con fecha asignada " + fechaHab7.format(inputFormatter));

                                } else if (!hab8) {
                                    fechaHab8 = LocalDate.now();
                                    hab8 = true;
                                    System.out.println("Habitación asignada número 8 con fecha asignada " + fechaHab8.format(inputFormatter));

                                } else System.out.println("Todas las habitaciones dobles están ocupadas");
                                break;

                            case "2":
                                if (!hab9) {
                                    fechaHab9 = LocalDate.now();
                                    hab9 = true;
                                    System.out.println("Habitación asignada número 9 con fecha asignada " + fechaHab9.format(inputFormatter));

                                } else if (!hab10) {
                                    fechaHab10 = LocalDate.now();
                                    hab10 = true;
                                    System.out.println("Habitación asignada número 10 con fecha asignada " + fechaHab10.format(inputFormatter));

                                } else System.out.println("Las habitaciones individuales están ocupadas");
                                break;
                            case "3":
                                System.out.println("volviendo al menu principal");
                                break;
                            default:
                                System.out.println("Opción introducida no válida");
                        }
                        System.out.print("Pulse una tecla para volver al menú");
                        s.nextLine();
                    } while (!tipoHabitacion.equalsIgnoreCase("3"));


                    break;
                case "c": //Realizar checkouts

                    break;
                case "d": //Mostrar el menú de administrador
                    System.out.print("Introduce el usuario: ");
                    user = s.nextLine();
                    System.out.print("Introduce el usuario: "); // Este es el bug que te mencioné!
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
                                                    │        DESGLOSE DE CAMBIO (CAJA)      │
                                                    ├───────────────────┬───────────────────┤
                                                    │     BILLETES      │      MONEDAS      │
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
                                    System.out.println("Opcion introducida no valida");
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