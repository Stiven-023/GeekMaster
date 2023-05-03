package juegoCraps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGridBagLayout extends JFrame {
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
    private JButton lanzar, ayuda, salir;
    private JPanel panelDados, panelResultados;
    private ImageIcon imageDado;
    private JTextArea resultadosDados, mensajeDeSalida;
    // componente grafico que me crea una linea separadora
    //private JSeparator separador;
    private Escucha escucha;
    private ModelCraps modelCraps; //objeto modelo

    public GUIGridBagLayout(){
        initGUI();

        this.setTitle("Juego Craps");
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constrains = new GridBagConstraints();
        //Create Listener Object or Control Object
        escucha = new Escucha();
        modelCraps = new ModelCraps();
        //Set up JComponents
        headerProject = new Header("Mesa De Juego Craps", Color.BLACK);
        constrains.gridx=0;
        constrains.gridy=0;
        constrains.gridwidth =2;
        //ancho que va tomar el componente
        constrains.fill= GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constrains);
        //this.add(headerProject,BorderLayout.NORTH);

        ayuda = new JButton(" ? ");
        ayuda.addActionListener(escucha);
        constrains.gridx =0;
        constrains.gridy =1;
        constrains.gridwidth=1;
        constrains.fill= GridBagConstraints.NONE;
        constrains.anchor= GridBagConstraints.LINE_START;
        this.add(ayuda, constrains);

        salir = new JButton("Salir");
        salir.addActionListener(escucha);
        constrains.gridx = 1;
        constrains.gridy = 1;
        constrains.fill=GridBagConstraints.NONE;
        constrains.anchor= GridBagConstraints.LINE_END;
        this.add(salir, constrains);


    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }

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
            //Todo lo que este en la primera posicion del arreglo se va poner en el area de texto
            resultadosDados.setText(modelCraps.getEstadoToString()[0]);
            //Se le establece una menor cantidad de filas
            mensajeDeSalida.setRows(4);
            mensajeDeSalida.setText(modelCraps.getEstadoToString()[1]);



        }
    }


}
