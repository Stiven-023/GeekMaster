
package Modelo;


import java.util.Random;

/**
 * Clase dado genera un valor random entre 1 y 6
 * @Author Stiven Castro
 *
 */
public class Dado {
    //cara es un atrinuto que devuelte el entero que representa la cara visible del dado
    private int cara;

    //metodo que devuelve el valor que esta en el atributo cara

    /**
     * MEtodo que genera el aleatorio para la cara
     * @return numeros entre(1,6)
     */
    public int getCara() {
        Random aleatorio = new Random();
        // es un metodo que devuelve un aleatorio comprendido entre 0 y el valor que nos -1
        cara = aleatorio.nextInt  (6)+1;
        //This is a comment
        return cara;

    }
}
