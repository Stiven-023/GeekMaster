package vista;

import Modelo.ModelCraps;
import Modelo.Puntaje;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class GUIGridBagLayout extends JFrame {
    private static final String MENSAJE_INICIO = "Bienvenido a Craps \n"
            + "De los 10 dados que trae el juego se toman 3 y se colocan en el sector de \"Dados\n" +
            "Inactivos\". Los otros 7 dados se tiran y pasan a ser los \"Dados Activos\".\n"
            + "\n" +
            "Se van eligiendo los dados a utilizar según las habilidades de sus caras y se pasan al sector\n" +
            "de \"Dados Utilizados"
            + "\nSi como último dado activo queda un Dragón, se perderán todos los puntos acumulados."+
            "\n"
            + "\nEste juego lo jugará un único jugador y ganará si logra sumar 30 puntos o más en 5 rondas\n" +
            "consecutivas de juego";


    private Header headerProject;
    private JLabel image, dado1, dado2, dado3,dado4,dado5,dado6,dado7,dado8,dado9,dado10;
    //private JLabel[] dados;
    private JButton lanzar, ayuda, salir;
    private JPanel gridPuntaje,todo, gridPanel, panelBoton, panelDados, panelTarjetaPunto, dadosUtilizados, dadosInactivos;
    private ImageIcon imageDado;
    private Container containerPp;
    private ArrayList<Puntaje> arrPuntaje;
    private JTextArea resultadosDados, mensajeDeSalida;
    // componente grafico que me crea una linea separadora
    //private JSeparator separador;
    private Escucha escucha;
    private ModelCraps modelCraps; //objeto modelo
    private Dado dadoView;

    public GUIGridBagLayout(){

        initGUI();

        this.setTitle("Juego Craps");
        this.pack();
        this.setSize(900,500);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);


    }

    private void initGUI() {

        /**
         * Con el GRIDPANEL hago las distribuciones que necesito dentro de un panel
         */
        gridPanel = new JPanel(new GridLayout(2,2));

        todo = new JPanel(new BorderLayout());

        // Panel botones
        panelBoton = new JPanel();




        /**
         * Panel donde van a ir los dados utilizados
         */
        dadosUtilizados = new JPanel();
        dadosUtilizados.setBorder(BorderFactory.createTitledBorder("Dados Utilizados"));

        /**
         * Panel donde va la puntuacion
         */
        panelTarjetaPunto = new JPanel();
        panelTarjetaPunto.setBorder(BorderFactory.createTitledBorder("Tarjeta Puntuacion"));
        gridPuntaje = new JPanel(new GridLayout(3,4));

        /**
         * Arreglo donde almaceno los puntajes y despues los recorro con un for y se van agregando al
         * marcador
         */
        arrPuntaje = new ArrayList<Puntaje>();
        String[] num = {"Puntaje", "1", "3", "6", "10","15", "21", "28", "36", "45","55", };

        for (int i = 0; i < 11; i++) {
            final Puntaje marcador = new Puntaje(num[i]);
            arrPuntaje.add(marcador);
        }
        /**
         * Agrega todos los elementos de marcador a gridPuntaje
         */
        for (Puntaje marcador: arrPuntaje) {
            gridPuntaje.add(marcador);
        }
        /**
         * Para el espacio de cada jlabel
         */
        gridPuntaje.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        panelTarjetaPunto.add(gridPuntaje);

        /**
         * Instancia de la escucha
         */
        escucha = new Escucha();
        modelCraps = new ModelCraps();
        headerProject = new Header("Mesa De Juego Craps", Color.BLACK);

        /**
         * Instancia de los dados
         */
        dado1 = new JLabel(imageDado);

        dado2 = new JLabel(imageDado);
        dado3 = new JLabel(imageDado);
        dado4 = new JLabel(imageDado);
        dado5 = new JLabel(imageDado);
        dado6 = new JLabel(imageDado);
        dado7 = new JLabel(imageDado);




        //Instancia del panel donde van a ir los dados activos
        panelDados = new JPanel();
        /**
         * Agrego dados al panel
         */

        panelDados.setPreferredSize(new Dimension(300, 190)); //Establece las dimensiones del JPanel
        panelDados.setBorder(BorderFactory.createTitledBorder("Tus Dados"));
        panelDados.add(dado1);
        panelDados.add(dado2);
        panelDados.add(dado3);
        panelDados.add(dado4);
        panelDados.add(dado5);
        panelDados.add(dado6);
        panelDados.add(dado7);


        /**
         * Genera un numero aleatorio del 1 al 7
         */
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            dadoView = new Dado(rand.nextInt(6)+1);
            panelDados.add(dadoView);
        }


        dadosInactivos = new JPanel();
        dadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos"));
        imageDado = new ImageIcon("src/resources/mepple.png", MENSAJE_INICIO);

        /**
         * Genera un numero alaetorio del 1 al 3
         */
        for (int i = 0; i < 3; i++)

        {
            dadoView = new Dado(rand.nextInt(6) + 1);
            dadosInactivos.add(dadoView);
        }


        dadosInactivos.setOpaque(false);

        /**
         * Agrego los paneles a la distribucion de gridPanel
         */

        gridPanel.add(panelDados);
        gridPanel.add(dadosUtilizados);
        gridPanel.add(panelTarjetaPunto);
        gridPanel.add(dadosInactivos);

        todo.add(panelBoton, BorderLayout.SOUTH);
        /**
         * Boton que nos indicia las reglas del juego
         */
        ayuda = new JButton(" Ayuda ");
        panelBoton.add(ayuda);

        /**
         * Boton para salir del juego
         */
        salir = new JButton("Salir");
        salir.addActionListener(escucha);
        panelBoton.add(salir);

        /**
         *
         */
        ayuda.addActionListener(escucha);


        todo.add(gridPanel, BorderLayout.CENTER);

        this.add(todo);


        //containerPp.add(panelResultados, BorderLayout.WEST);
        //containerPp.add(panelDados, BorderLayout.EAST);
    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }

    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


                if (e.getSource()==ayuda){
                    JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
                }else{
                    System.exit(0);
                }




        }
    }


}
