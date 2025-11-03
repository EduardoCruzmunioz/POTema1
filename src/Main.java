import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Constantes y variables de valores economicos
        final int PRECIO_HABITACION_INDIVIDUAL = 45;
        final int PRECIO_HABITACION_DOBLE = 60;
        double ingresosTotales = 0.00;

        //Constantes y variables para el login
        final String NOMBRE_ADMIN = "hola";
        final String ClAVE_ADMIN = "hola";
        String user, pass;

        int reservasFinalizadas = 1782;

        boolean salir = true;
        String op, opAdmin, tipoHabitacion;

        // Estado de las habitaciones: false = libre, true = ocupada (La habitación 9 y 10 son las individuales y las demás dobles)
        boolean hab1 = false, hab2 = false, hab3 = false, hab4 = false, hab5 = false, hab6 = false,
                hab7 = false, hab8 = false, hab9 = false, hab10 = false;


        //o
        // System.out.println(fechaHab1.format(outputFormatter));
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter ouputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaHab1, fechaHab2, fechaHab3, fechaHab4, fechaHab5, fechaHab6, fechaHab7, fechaHab8, fechaHab9, fechaHab10;


        do {
            // Nos muestra el menú
            System.out.print("""
                    +--------------------------------------------+
                    |          HOTEL CIUDAD DE MARTOS            |
                    +--------------------------------------------+
                    | a. Ver estado de ocupación                 |
                    | b. Reservar una habitación                 |
                    | c. Realizar checkout                       |
                    | d. Menú de administrador                   |
                    +--------------------------------------------+
                    
                    Elige una opción:\s""");
            // Escribe la opción que quieres
            op = s.nextLine().toLowerCase();
            switch (op) {
                case "a": //Ver estado de ocupación
                    System.out.printf("""
                        +--------------------------------------------+
                        |          HOTEL CIUDAD DE MARTOS            |
                        +--------------------------------------------+
                        |          ESTADO DE LAS HABITACIONES        |
                        +--------------------------------------------+
                        | Habitación | Tipo       | Estado           |
                        +--------------------------------------------+
                        | 1          | Doble      | %-17s|
                        | 2          | Doble      | %-17s|
                        | 3          | Doble      | %-17s|
                        | 4          | Doble      | %-17s|
                        | 5          | Doble      | %-17s|
                        | 6          | Doble      | %-17s|
                        | 7          | Doble      | %-17s|
                        | 8          | Doble      | %-17s|
                        | 9          | Individual | %-17s|
                        | 10         | Individual | %-17s|
                        +--------------------------------------------+
                        """, (hab1 ? "Ocupada" : "Libre"), (hab2 ? "Ocupada" : "Libre"), (hab3 ? "Ocupada" : "Libre"),
                            (hab4 ? "Ocupada" : "Libre"),  (hab5 ? "Ocupada" : "Libre"), (hab6 ? "Ocupada" : "Libre"),
                            (hab7 ? "Ocupada" : "Libre"),  (hab8 ? "Ocupada" : "Libre"),  (hab9 ? "Ocupada" : "Libre"),
                            (hab10 ? "Ocupada" : "Libre")
                    );

                    System.out.print("Pulse una tecla para volver al menú");
                    s.nextLine();
                    break;
                case "b": //Reservar las habitaciones
                    System.out.print("""
                            1. Individual
                            2. Doble
                            
                            Introduzca una opción:\s""");
                    tipoHabitacion = s.nextLine();
                    switch (tipoHabitacion){
                        case "1":
                            if (!hab9){
                                fechaHab9 = LocalDate.now();
                                hab9 = true;
                                System.out.println("Habitación asignada número 9 con fecha asignada " + fechaHab9.format(inputFormatter));

                            } else if (!hab10){
                                fechaHab10 = LocalDate.now();
                                hab10 = true;
                                System.out.println("Habitación asignada número 10 con fecha asignada " + fechaHab10.format(inputFormatter));

                            } else System.out.println("Las habitaciones individuales están ocupadas");
                            break;

                        case "2":

                            break;


                        default:


                    }
                    System.out.print("Pulse una tecla para volver al menú");
                    s.nextLine();



                    break;
                case "c": //Realizar checkouts

                    break;
                case "d": //Mostrar el menú de administrador
                    System.out.print("Introduce el usuario: ");
                    user = s.nextLine();
                    System.out.print("Introduce el usuario: ");
                    pass = s.nextLine();

                    if (!user.equals(NOMBRE_ADMIN) && !pass.equals(ClAVE_ADMIN)) {
                        System.out.print("Nombre o usuario incorrecto");
                        s.nextLine();
                    } else {
                        do {

                        System.out.print("""
                                +------------------------------------------------------------------------------------+
                                |                                   MENÚ ADMINISTRADOR                               |
                                +------------------------------------------------------------------------------------+
                                | i.   Consultar los ingresos totales y el número de reservas finalizadas.           |
                                | ii.  Consultar las monedas restantes para el cambio.                               |
                                | iii. Apagar el software                                                            |
                                +------------------------------------------------------------------------------------+
                                \n
                                Elige una opción:\s""");
                        opAdmin = s.nextLine().toLowerCase();
                        switch (opAdmin) {
                            case "i": //Consulta el ingreso y el número de reservas
                                System.out.printf("""
                                                ╔═══════════════════════════════════════════════╗
                                                ║   ** ESTADÍSTICAS HOTEL CIUDAD DE MARTOS **   ║
                                                ╠═══════════════════════════════╤═══════════════╣
                                                ║ Ingresos Totales (EUR)        │  %12.2f ║
                                                ║ Reservas Finalizadas (Uds.)   │  %12d ║
                                                ╚═══════════════════════════════╧═══════════════╝
                                                """,ingresosTotales, reservasFinalizadas
                                );
                                break;
                            case "ii": // Nos da información de la cantidad de monedas/billetes que nos quedan

                                break;
                            case "iii": //apaga el programa
                                salir = false;
                                System.out.println("Apagando programa");
                                break;
                            default:
                                System.out.println("Opción introducida no valida");
                        }
                        }while(salir);
                    }
                    break;
                default:
                    System.out.print("Opción no válida. Inténtelo de nuevo.");
                    break;
            }


        } while (salir);
    }
}
