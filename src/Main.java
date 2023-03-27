import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Menu nuevoMenu = new Menu();
        Scanner scannerInts = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        boolean isSalir = false;
        int opcion = 0;
        double precio = 0;
        String nombre = "";

        while (!isSalir) {
            System.out.println("Seleccione una opción: \n1. Generar nuevo menú \n2. Ver menú actual \n3. Ver histórico de menús \n4. Crear plato al gusto \n5. Salir");
            opcion = scannerInts.nextInt();

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
                    //implementación propia para crear un plato nuevo propio
                    System.out.println("¿Qué plato desea crear?: \n1.Entrante \n2.Primero \n3.Segundo \n4.Postre");
                    opcion = scannerInts.nextInt();
                    System.out.println("Elija un nombre para el plato: ");
                    nombre = scannerString.nextLine();
                    System.out.println("Establezca el precio: ");
                    precio = scannerInts.nextDouble();
                    //switch para crear el tipo de objeto seleccionado y añadirlo al fichero de platos que corresponda
                    switch (opcion) {
                        case 1:
                            Entrante nuevoEntrante = new Entrante(tipoPlato.ENTRANTE, nombre, precio);
                            System.out.println("Plato creado con éxito");
                            nuevoMenu.addNuevoPlato(nombre, "entrantes.txt");
                            break;
                        case 2:
                            Primero nuevoPrimero = new Primero(tipoPlato.PRIMERO, nombre, precio);
                            System.out.println("Plato creado con éxito");
                            nuevoMenu.addNuevoPlato(nombre, "primeros.txt");
                            break;
                        case 3:
                            Segundo nuevoSegundo = new Segundo(tipoPlato.SEGUNDO, nombre, precio);
                            System.out.println("Plato creado con éxito");
                            nuevoMenu.addNuevoPlato(nombre, "segundos.txt");
                            break;
                        case 4:
                            Postre nuevoPostre = new Postre(tipoPlato.POSTRE, nombre, precio);
                            System.out.println("Plato creado con éxito");
                            nuevoMenu.addNuevoPlato(nombre, "postres.txt");
                            break;
                        default:
                            System.out.println("Opción inválida. Intente de nuevo.");
                            break;
                    }

                    break;
                case 5:

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