import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Menu nuevoMenu = new Menu();
        Scanner scanner = new Scanner(System.in);
        boolean isSalir = false;

        while (!isSalir) {
            System.out.println("Seleccione una opción: \n1. Generar nuevo menú \n2. Ver menú actual \n3. Ver histórico de menús \n4. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Generando nuevo menú...");
                    nuevoMenu.generarMenu();
                    break;
                case 2:
                    System.out.println("Menú actual:");
                    System.out.println(nuevoMenu.toString());
                    break;
                case 3:
                    nuevoMenu.leerCaracteres("menus_historico.txt");
                    break;
                case 4:
                    System.out.println("¡Hasta pronto!");
                    isSalir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }

    }
}