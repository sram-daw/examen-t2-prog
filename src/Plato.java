//Clase abstracta que van a heredar todas las clases de platos (entrante, primero, segundo y postre)
public abstract class Plato {
    tipoPlato PLATO;

    public String nombre;
    public double precio;


    public Plato(tipoPlato PLATO, String nombre, double precio) {
        this.PLATO = PLATO;
        this.nombre = nombre;
        this.precio = precio;
    }


    public abstract String[] crearLista();

}
