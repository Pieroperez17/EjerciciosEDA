public class Nodo {
    int clave;
    Nodo siguiente;

    public Nodo(int clave) {
        this.clave = clave;
        this.siguiente = null;
    }

    public int GetClave() {
        return clave;
    }
}
