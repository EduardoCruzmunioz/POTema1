import java.util.Scanner;
public class Main {
     static void main(String[] args) {
        final int PRECIO_HABITACION_INDIVIDUAL = 45;
        final int PRECIO_HABITACION_DOBLE = 60;
        final String NOMBRE_ADMIN= "C4rL0S";
        final String ClAVE_ADMIN= "Gu4p0";
        boolean salir = true;
        var s = new Scanner(System.in);
        String op = "", opAdmin = "";


        do {
            // Nos muestra el menú
            System.out.println("""
            +--------------------------------------------+
            |          HOTEL CIUDAD DE MARTOS            |
            +--------------------------------------------+
            | a. Ver estado de ocupación                 |
            | b. Reservar una habitación                 |
            | c. Realizar checkout                       |
            | d. Menú de administrador                   |
            +--------------------------------------------+\n
            Elige una opción:
            """);
            // Escribe la opción que quieres
            op = s.nextLine().toLowerCase();
            switch (op) {
                case "a": //Estado de ocupación
                    break;
                case "b": //Reservar las habitaciones
                    break;
                case "c": //Realizar checkouts

                    break;
                case "d": //Mostrar el menú de administrador

                    break;
                default:
                    System.out.print("Opción no válida. Inténtelo de nuevo.");
                    break;
            }


        }while (salir);
    }
}
