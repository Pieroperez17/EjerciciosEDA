
public class Principal {
    public static void main(String[] args) {
        ListaEnlazada listaentrada_1 = new ListaEnlazada();

        listaentrada_1.insertarFinal(1);
        listaentrada_1.insertarFinal(2);
        listaentrada_1.insertarFinal(3);

        System.out.println("Entrada");
        listaentrada_1.mostrar();

        System.out.println("Salida");
        Reordenar_Lista(listaentrada_1);
    }

    //Complejidad O(n)
    private static void Reordenar_Lista(ListaEnlazada ListaEnlazada1) {
        int size = ListaEnlazada1.obtenerTamanio();
        boolean val = false;
        for(int i=0; i < size; i++) {
            if(val) {
                Nodo last = ListaEnlazada1.getHead();
                for(int j=0; j < size-1; j++) {
                    last = last.siguiente;
                }
                int lastValue = last.clave;
                ListaEnlazada1.insertarEnPosicion(lastValue,(i+1));
                ListaEnlazada1.eliminarFinal();
            }
            val = !val;
        }
        ListaEnlazada1.mostrar();
    }
}
