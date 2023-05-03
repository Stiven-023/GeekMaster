package modelo;

import controlador.Dado;

/**
 * ModelCraps aplica las reglas del juego
 * estado = 1 Ganador natural
 * estado = 2 perdio el juego
 * estado = 3 Establece el punto
 * estado = 4 Punto ganador
 * estado = 5 Punto perdedor
 */

public class ModelCraps {
    //Objetos que permiten ver la cara visible del dado
    private Dado dado1, dado2;
    //

    private int tiro, punto, estado, flag;
    //Sacar el mensaje correspondiente al estado que tenemos
    private String estadoToString;
    //para manejar el valor de cada dado;

    //Arreglo que contiene las dos caras del dado
    private int [] caras;

    //Creando el constructor o instancia de este objeto

    /**
     * Class Constru  crear instancias, crear los objetos de los atributos que defini que iba a usar
     * o indicar el numero de posiciones que va tener el vector en el que va recoger la informacion de las caras
     */
    public ModelCraps(){
        //Creando los dados;
        //ya que para poder usar objetos necesito crearlos
        dado1 = new Dado();
        dado2 = new Dado();
        //le di dos posiciones al arreglo
        caras= new int [2];
        /**
         *  Cuando se crea el objeto me aseguro que la bandera arranque en cero
         *  me indica que voy a validar el tiro de salida
         */
        flag = 0;


    }
    //utilizar objetos de tipo dado

    /**
     * Establece el valor del tiro de acuerdo a cada cara del dado
     */
    public void calcularTiro(){

        caras[0]=dado1.getCara();
        //de esta manera obtengo los dados
        caras[1]=dado2.getCara();
        /**
         * Para calcular el valor del tiro
         */
        tiro = caras [0] + caras[1];

    }

    /**
     * Determinar juego es el metodo que me dice, si se gano sacando natural
     * perdi sacando craps, estableci punto o si estando en punto gane o si estando en punto
     * perdi...
     * @autor Stiven Castro
     * Version V.10.0 fecha 30/04/2023
     */
    /**
     * EStablece el estado de juego de acuerdo a lo que este en la variable estado
     * estado = 1 Ganador natural
     * estado = 2 perdio el juego
     * estado = 3 Establece el punto
     * estado = 4 Punto ganador
     * estado = 5 Punto perdedor
     */

    public void determinarJuego(){
        if(flag==0){
            if (tiro == 7 || tiro ==11){
                estado = 1;
            }
            else {
                if (tiro == 3 || tiro==2 || tiro==12){
                    //entonces quiere decir que perdio
                    estado = 2;
                }
                else {
                    estado = 3;
                    punto = tiro;
                    flag =1;



                }
}

            }
        else {

            rondaPunto();
        }
        }

    /**
     * lo que hace este juego es explicar las reglas de juego
     * para la ronda punto
     */
    /**
     * Establece el estado de juego de acuerdo al estado del atributo
     * estado = 4 Punto ganador
     * estado = 5 Punto perdedor
     */
    private void rondaPunto() {
        //rondas de juego para la ronda punto
        if(tiro == punto){
            estado = 4;
            flag =1;

        }
        if(tiro == 7){
            //perdio estando en el punto
            estado=5;
            //iniciaria una nueva ronda de juego
            flag=0;

        }
    }

    public int getTiro() {
        return tiro;
    }

    public int getPunto() {
        return punto;
    }

    /**
     * establece el estado del juego del mensaje de acuerdo con el valor del atributo estado
     * @return mensaje para la clase de vista
     */
    public String getEstadoToString() {
        /**
         * usa el valor de estado que es un entero para poder personalizar el comentario
         */
        switch (estado){
            case 1: estadoToString= "Sacaste natural, has ganado!!";
                    break;
            case 2: estadoToString= "Sacaste craps, has perdido";
                    break;
            case 3: estadoToString= "Estableciste punto en"+ punto +
                                    " Debes seguir lanzando!!"+
                                    "\n pero si sacas 7 antes que "+ punto + "Perderas";
                    break;
            case 4: estadoToString= "Volviste a sacar"+ punto +", has ganado !!";
                    break;
            case 5: estadoToString= "Sacaste 7 antes que"+ punto + "has perdido !!";



        }

        return estadoToString;
    }

    public int[] getCaras() {
        return caras;
    }
}



