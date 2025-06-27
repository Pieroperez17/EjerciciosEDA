
public class Principal {
    public static void main(String[] args) {
        ListaEnlazada listaentrada_1 = new ListaEnlazada();
        ListaEnlazada listaentrada_2 = new ListaEnlazada();

        listaentrada_1.insertarFinal(6);
        listaentrada_1.insertarFinal(5);
        listaentrada_1.insertarFinal(2);

        listaentrada_2.insertarFinal(3);
        //listaentrada_2.insertarFinal(6);
        //listaentrada_2.insertarFinal(0);

        System.out.println("Entrada");
        listaentrada_1.mostrar();
        listaentrada_2.mostrar();

        System.out.println("Salida");
        Resta_Lista_Enlazada(listaentrada_1, listaentrada_2);
    }

    
    private static void Resta_Lista_Enlazada(ListaEnlazada ListaEnlazada1,ListaEnlazada ListaEnlazada2) {
        //Datos de las 2 listas y sus tamaños
        ListaEnlazada imput1 = ListaEnlazada1;
        int tamaño1 = imput1.obtenerTamanio();
        ListaEnlazada imput2 = ListaEnlazada2;
        int tamaño2 = imput2.obtenerTamanio();
        //Variables para almacenar los valores de las listas
        int primerValor=0;
        int segundoValor=0;
        //Revertir las listas para obtener el valor correcto primero unidades y luego decenas y asi continuamos
        imput1.revertir();
        imput2.revertir();

        //Obtener el valor de las listas
        //Se obtiene el valor de las listas multiplicando cada elemento por su respectiva potencia de 10
        //Ejemplo: 123 = 1*100 + 2*10 + 3*1
        int ite=1;
        for(int i = 0; i < tamaño1; i++) {
            primerValor = primerValor + (imput1.getHead().clave)*ite;
            imput1.eliminarInicio();
            ite= ite * 10;
        }
        ite=1;
        for(int i = 0; i < tamaño2; i++) {
            segundoValor = segundoValor + (imput2.getHead().clave)*ite;
            imput2.eliminarInicio();
            ite= ite * 10;
        }
        //Realizar la resta
        int resultado = primerValor - segundoValor;
        // valor absoluto de la diferencia
        if (resultado < 0) {resultado = resultado * -1;}
        //Convertir el resultado a una lista enlazada
        ListaEnlazada resultadoLista = new ListaEnlazada();
        for (char c : String.valueOf(resultado).toCharArray()) {
            resultadoLista.insertarFinal(Character.getNumericValue(c));
        }
        //Mostrar el resultado
        resultadoLista.mostrar();
    }
}
