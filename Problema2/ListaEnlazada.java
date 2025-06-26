public class ListaEnlazada {
    private Nodo head;
    private int size;

    public ListaEnlazada() {
        this.head = null;
        this.size = 0;
    }

    public Nodo getHead() {
        return head;
    }

    public boolean estaVacia() {
        return head == null;
    }

    public int obtenerTamanio() {
        return size;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        Nodo actual = head;
        while (actual != null) {
            System.out.print(actual.clave + " -->");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = head;
        head = nuevo;
        size++;
    }

    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (estaVacia()) {
            head = nuevo;
        } else {
            Nodo actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        size++;
    }

    public void insertarEnPosicion(int valor, int posicion) {
        if (posicion < 1 || posicion > size + 1) {
            System.out.println("Posición inválida para inserción");
            return;
        }
        if (posicion == 1) {
            insertarInicio(valor);
        } else if (posicion == size + 1) {
            insertarFinal(valor);
        } else {
            Nodo nuevo = new Nodo(valor);
            Nodo actual = head;
            for (int i = 1; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
            size++;
        }
    }

    public void actualizarValor(int valor, int posicion) {
        if (posicion < 1 || posicion > size) {
            System.out.println("Posición inválida para actualización");
            return;
        }
        Nodo actual = head;
        for (int i = 1; i < posicion; i++) {
            actual = actual.siguiente;
        }
        actual.clave = valor;
    }

    public void eliminarInicio() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        head = head.siguiente;
        size--;
    }

    public void eliminarFinal() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        if (head.siguiente == null) {
            head = null;
        } else {
            Nodo actual = head;
            while (actual.siguiente.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = null;
        }
        size--;
    }

    public void eliminarEnPosicion(int posicion) {
        if (posicion < 1 || posicion > size) {
            System.out.println("Posición inválida para eliminación");
            return;
        }
        if (posicion == 1) {
            eliminarInicio();
        } else {
            Nodo actual = head;
            for (int i = 1; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
            size--;
        }
    }

    public void revertir() {
        Nodo anterior = null;
        Nodo actual = head;
        Nodo siguiente;
        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }
}
