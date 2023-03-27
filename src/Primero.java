public class Primero extends Plato {
    public Primero(tipoPlato PLATO, String nombre, double precio) {
        super(PLATO, nombre, precio);
        this.PLATO = tipoPlato.PRIMERO;
    }

    @Override
    public String[] crearLista() {
        String[] nombresPrimeros = {"Arroz con pollo", "Lasaña", "Gazpacho", "Espagueti a la carbonara", "Filetes de pollo", "Pimientos rellenos"};
        return nombresPrimeros;
    }
}
