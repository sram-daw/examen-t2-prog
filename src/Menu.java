import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Menu {

    private String[] entrantes;
    private String[] primeros;
    private String[] segundos;
    private String[] postres;

    private String[] menuCompleto;

    public Menu() {
        this.entrantes = leerFicheroGenerarArray("entrantes.txt");
        this.primeros = leerFicheroGenerarArray("primeros.txt");
        this.segundos = leerFicheroGenerarArray("segundos.txt");
        this.postres = leerFicheroGenerarArray("postres.txt");
        this.menuCompleto = leerFicheroGenerarArray("menu.txt");
    }

    public void generarMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] menu = new String[4];

        // Verifica si ya hay un menú guardado en archivo. Se crea un objeto de tipo File porque posee funciones como .exists que permite comprobar más fácilmente si existe un determinado fichero
        File menuFile = new File("menu.txt");
        if (menuFile.exists()) {
            System.out.print("Ya existe un menú guardado. ¿Desea sobreescribirlo? (S/N): ");
            String respuesta = scanner.nextLine().toUpperCase();
            if (!respuesta.equals("S")) {
                System.out.println("Menú no generado.");
                return;
            }
        }
        // Genera menú aleatorio
        Random aleatorio = new Random();
        menu[0] = entrantes[aleatorio.nextInt(entrantes.length)];
        menu[1] = primeros[aleatorio.nextInt(primeros.length)];
        menu[2] = segundos[aleatorio.nextInt(segundos.length)];
        menu[3] = postres[aleatorio.nextInt(postres.length)];

        // Muestra el menú generado y pregunta si se desea guardarlo
        System.out.println("\nMenú generado:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println("- " + menu[i]);
        }
        System.out.print("¿Desea guardar el menú? (S/N): ");
        String respuesta = scanner.nextLine().toUpperCase();
        if (respuesta.equals("S")) {
            guardarMenu(menu);
            System.out.println("Menú guardado en archivo.");
        } else {
            System.out.println("Menú no guardado.");
        }
    }

    public String[] leerFicheroGenerarArray(String nombreArchivo) {
        try {
            Scanner scanner = new Scanner(new File(nombreArchivo));
            int numLineas = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                numLineas++;
            }
            String[] contenido = new String[numLineas]; //se crea el array que va a almacenar los nombres de cada plato del menú
            scanner = new Scanner(new File(nombreArchivo)); //se crea un scanner que lee el archivo que se pasa por parámetros. Se escoge en este caso porque permite leer línea por línea más cómodamente con la función next.Line
            for (int i = 0; i < contenido.length; i++) {
                contenido[i] = scanner.nextLine(); //se lee cada linea individualmente

            }
            return contenido;
        } catch (IOException e) {
            System.err.println("Error al leer archivo " + nombreArchivo + ": " + e.getMessage());
            return new String[0];
        }
    }

    public void leerCaracteres(String fichero) {
        FileReader lectorCaracteres;
        int caracter = 0;
        char contenidoFichero = 0;
        ArrayList<Character> listaChars = new ArrayList<Character>();
        String textoCompleto = "";
        try {
            lectorCaracteres = new FileReader(fichero);
            caracter = lectorCaracteres.read();
            while (caracter != -1) {
                contenidoFichero = (char) caracter;
                listaChars.add((char)caracter); //añadimos a la lista el caracter
                System.out.print(contenidoFichero);
                caracter = lectorCaracteres.read();
            }
            System.out.println("");
            lectorCaracteres.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }
    }

    public void guardarMenu(String[] menu) throws IOException {
        try {
            //Se guarda el nuevo menú en en menu.txt
            FileWriter writer = new FileWriter("menu.txt");
            for (int i = 0; i < menu.length; i++) {
                writer.write(menu[i] + "\n");
            }
            writer.close();

            //Guardamos en menus_historico.txt también, como un nuevo elemento
            FileWriter writerHistorico = new FileWriter("menus_historico.txt", true);
            for (int i = 0; i < menu.length; i++) {
                writerHistorico.write(menu[i] + "\n");
            }
            writerHistorico.write("--------------------\n");
            writerHistorico.close();

        } catch (IOException e) {
            System.err.println("Error al guardar menú en archivo: " + e.getMessage());
        }
    }


    public void addNuevoPlato(String nombre, String fichero){
        try {
            FileWriter writer = new FileWriter(fichero, true);

            // Se escribe el nuevo plato en una nueva línea
            writer.write(System.lineSeparator()+nombre);

            writer.close();
        } catch (IOException e) {
            System.err.println("Error al añadir el nuevo plato: " + e.getMessage());
        }

    }

    public String[] getMenuCompleto() {
        return menuCompleto;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "menuCompleto=" + Arrays.toString(menuCompleto) +
                '}';
    }



}

