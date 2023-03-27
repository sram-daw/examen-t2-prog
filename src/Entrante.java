public class Entrante extends Plato {


    public Entrante(tipoPlato PLATO, String nombre, double precio) {
        super(PLATO, nombre, precio);
        this.PLATO= tipoPlato.ENTRANTE;
    }



    @Override
    public String[] crearLista() {
        String[] nombresEntrantes = {"Ensalada", "Sopa", "Carpaccio", "Tostadas", "Gazpacho", "Empanadas"};
        return nombresEntrantes;
    }
}
