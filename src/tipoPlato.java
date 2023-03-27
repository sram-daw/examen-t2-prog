public enum tipoPlato {
    ENTRANTE(0),
    PRIMERO(1),
    SEGUNDO(2),
    POSTRE(3);

    private final int orden;

    tipoPlato(int orden) {
        this.orden = orden;
    }

    public int getOrden() {
        return orden;
    }
}
