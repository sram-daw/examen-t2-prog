public class Segundo extends Plato {
    public Segundo(tipoPlato PLATO, String nombre, double precio) {
        super(PLATO, nombre, precio);
        this.PLATO = tipoPlato.SEGUNDO;
    }

    @Override
    public String[] crearLista() {
        String[] nombresSegundos = {"Lomo saltado", "Pollo al horno", "Asado de tira", "Churrasco", "Pescado a la plancha", "Chuletas de cerdo"};
        return nombresSegundos;
    }
}
