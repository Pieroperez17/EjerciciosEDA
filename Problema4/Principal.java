
public class Principal {
    public static void main(String[] args) {
        ListaEnlazada listaentrada_1 = new ListaEnlazada();

        listaentrada_1.insertarFinal(1);
        listaentrada_1.insertarFinal(7);
        listaentrada_1.insertarFinal(5);
        listaentrada_1.insertarFinal(3);
        listaentrada_1.insertarFinal(9);
        listaentrada_1.insertarFinal(8);
        listaentrada_1.insertarFinal(10);
        listaentrada_1.insertarFinal(2);
        listaentrada_1.insertarFinal(2);
        listaentrada_1.insertarFinal(5);

        System.out.println("Entrada");
        listaentrada_1.mostrar();

        System.out.println("Salida");
        InvertirSubListaEnlazada(listaentrada_1,1,8);
    }

    
    private static void InvertirSubListaEnlazada(ListaEnlazada entrada,int inicio, int fin) {
        ListaEnlazada Input = entrada;
        ListaEnlazada Result = new ListaEnlazada();
        int size = entrada.obtenerTamanio();

        for(int i=1; i <= size; i++) {
            if (i >= inicio && i <= fin) {
                Result.insertarEnPosicion(Input.getHead().clave, inicio);
                Input.eliminarInicio();
            }else {
                Result.insertarFinal(Input.getHead().clave);
                Input.eliminarInicio();
            }
        }
        Result.mostrar();
    }
}
