public class Postre extends Plato{
    public Postre(tipoPlato PLATO, String nombre, double precio) {
        super(PLATO, nombre, precio);
        this.PLATO= tipoPlato.POSTRE;
    }

    @Override
    public String[] crearLista() {
        String[] nombresPostres = {"Tiramisú", "Flan de vainilla", "Pastel de chocolate", "Helado de fresa", "Arroz con leche", "Mousse de limón"};
        return nombresPostres;
    }
}
