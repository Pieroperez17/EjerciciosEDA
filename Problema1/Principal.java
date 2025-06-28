
public class Principal {
    public static void main(String[] args) {
        ListaEnlazada listaentrada = new ListaEnlazada();

        listaentrada.insertarFinal(1);
        listaentrada.insertarFinal(2);
        listaentrada.insertarFinal(3);
        listaentrada.insertarFinal(4);
        listaentrada.insertarFinal(5);

        System.out.println("Entrada");
        listaentrada.mostrar();

        System.out.println("Salida");
        doble_vuelta(listaentrada, 3);
    }

    
    private static void doble_vuelta(ListaEnlazada input,int k) {
        if (input.estaVacia() || k <= 0 || k > input.obtenerTamanio()) {
            System.out.println("Lista vacía o valor de k inválido");
            return;
        }

        ListaEnlazada ListaImput = input;
        ListaEnlazada temp1 = new ListaEnlazada();
        ListaEnlazada temp2 = new ListaEnlazada();
        int size = input.obtenerTamanio();


        for(int i=0; i<size;i++){
            if (i < k) {
                temp1.insertarFinal(ListaImput.getHead().clave);
                ListaImput.eliminarInicio();
            } else {
                temp2.insertarFinal(ListaImput.getHead().clave);
                ListaImput.eliminarInicio();
            }
        }
        temp1.revertir();
        temp2.revertir();
        
        for (int index = 0; index < size; index++) {
            if (index < k) {
                System.out.print(temp1.getHead().clave);
                temp1.eliminarInicio();
            } else {
                System.out.print(temp2.getHead().clave);
                temp2.eliminarInicio();
            }
            System.out.print(" --> ");
        }
        System.out.print("null");
    }

}
