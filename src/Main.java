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
        String op, opAdmin;


        do {
            // Nos muestra el menú
            System.out.print("""
                    +--------------------------------------------+
                    |          HOTEL CIUDAD DE MARTOS            |
                    +--------------------------------------------+
                    | A. Ver estado de ocupación                 |
                    | B. Reservar una habitación                 |
                    | C. Realizar checkout                       |
                    | D. Menú de administrador                   |
                    +--------------------------------------------+
                    
                    Elige una opción:\s""");
            // Escribe la opción que quieres
            op = s.nextLine();
            switch (op) {
                case "a": //Estado de ocupación

                    break;
                case "b": //Reservar las habitaciones

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
                        opAdmin = s.nextLine();
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
