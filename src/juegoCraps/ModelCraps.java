package juegoCraps;

public class ModelCraps {
    private Dado dado1, dado2;

    private int tiro, punto, estado, flag;

    private String estadoToString;
    //para manejar el valor de cada dado;

    //Arreglo que contiene las dos caras del dado
    private int [] caras;

    //Creando el constructor o instancia de este objeto
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

    public String getEstadoToString() {
        /**
         * usa el valor de estado que es un entero para poder personalizar el comentario
         */
        switch (estado){
            case 1: estadoToString= "Sacaste natural, has ganado!!";
            case 2:
        }

        return estadoToString;
    }

    public int[] getCaras() {
        return caras;
    }
}



