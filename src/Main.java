import java.util.Scanner;
public class Main {
     static void main(String[] args) {
        final int PRECIO_HABITACION_INDIVIDUAL = 45;
        final int PRECIO_HABITACION_DOBLE = 60;
        final String NOMBRE_ADMIN= "C4rL0S";
        final String ClAVE_ADMIN= "Gu4p0";
        boolean salir = true;
        var s = new Scanner(System.in);
        int op = 0;


        do {
            // Nos muestra el menú
            System.out.println("""
            +--------------------------------------------+
            |          HOTEL CIUDAD DE MARTOS            |
            +--------------------------------------------+
            | 1. Ver estado de ocupación                 |
            | 2. Reservar una habitación                 |
            | 3. Realizar checkout                       |
            | 4. Menú de administrador                   |
            +--------------------------------------------+
                    
            Elige una opción:
            """);
            // Escribe la opción que quieres
            opcion = Integer.parseInt(s.nextLine());
            switch (opcion) {
                case 1: //Estado de ocupación

                    break;
                case 2: //Reservar las habitaciones

                    break;
                case 3: //Realizar checkouts

                    break;
                case 4: //Mostrar el menú de administrador

                    break;
                default:
                    System.out.print("Opción no válida. Inténtelo de nuevo.");
                    break;:
            }


        }while (salir);
    }
}
