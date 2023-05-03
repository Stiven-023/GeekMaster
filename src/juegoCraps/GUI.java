package juegoCraps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {
    private static final String MENSAJE_INICIO = "Bienvenido a Craps \n"
            + "Oprime el boton lanzar para inicar el juego"
            + "\nSi tu tiro de salida es 7 u 11 ganas el juego"
            + "\nSi tu tiro de salida es 2, 3 u 12 pierdes con Craps"
            + "\nSi sacas cualquier otro valor estableceras el Punto"
            + "\nEstado en punto podras seguir lanzando los dados"
            + "\nEspero ahora ganaras si sacas nuevamente el valor del Punto "
            + "\nsin que previamente hayas sacado 7";
    private Header headerProject;
    private JLabel dado1, dado2;
    private JButton lanzar;
    private JPanel panelDados, panelResultados;
    private ImageIcon imageDado;
    private JTextArea resultadosDados, mensajeDeSalida;
    // componente grafico que me crea una linea separadora
    private JSeparator separador;
    private Escucha escucha;
    private ModelCraps modelCraps; //objeto modelo

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Juego Craps");
        //this.setSize(200,100);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object or Control Object
        escucha = new Escucha();
        modelCraps = new ModelCraps();
        //Set up JComponents
        headerProject = new Header("Mesa De Juego Craps", Color.BLACK);

        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpg"));
        dado1 = new JLabel(imageDado);
        dado2 = new JLabel(imageDado);

        lanzar = new JButton("Lanzar");
        lanzar.addActionListener(escucha);

        panelDados = new JPanel();
        panelDados.setPreferredSize(new Dimension(300, 190)); //Establece las dimensiones del JPanel
        panelDados.setBorder(BorderFactory.createTitledBorder("Tus Dados"));
        panelDados.add(dado1);
        panelDados.add(dado2);
        panelDados.add(lanzar);

        this.add(panelDados, BorderLayout.CENTER);

        mensajeDeSalida = new JTextArea(7,31);
        mensajeDeSalida.setText(MENSAJE_INICIO);
        //mensajeDeSalida.setBorder(BorderFactory.createTitledBorder("Que debes hacer"));
        JScrollPane scroll = new JScrollPane(mensajeDeSalida);
        //this.add(mensajeDeSalida, BorderLayout.EAST);

        panelResultados =  new JPanel();
        panelResultados.setBorder(BorderFactory.createTitledBorder("Que debes hacer"));
        panelResultados.add(scroll);
        panelResultados.setPreferredSize(new Dimension(370, 180));

        this.add(panelResultados, BorderLayout.EAST);

        resultadosDados = new JTextArea(4,31);
        separador = new JSeparator();
        separador. setPreferredSize(new Dimension(320, 7));
        separador.setBackground(Color.BLUE);


    }

    /** re
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            modelCraps.calcularTiro();
            int[] caras = modelCraps.getCaras();
            imageDado = new ImageIcon(getClass().getResource("/resources/dado_"+caras[0]+".png"));
            dado1.setIcon(imageDado);
            imageDado = new ImageIcon(getClass().getResource("/resources/dado_"+caras[1]+".png"));
            dado2.setIcon(imageDado);

            modelCraps.determinarJuego();
            mensajeDeSalida.setText(modelCraps.getEstadoToString());
        }
    }
}
