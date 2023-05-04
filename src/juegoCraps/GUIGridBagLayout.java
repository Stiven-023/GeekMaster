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
        this.setUndecorated(true);
        this.setBackground(new Color(255,255,255,0));
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

        imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpg"));
        dado1 = new JLabel(imageDado);
        dado2 = new JLabel(imageDado);

        panelDados = new JPanel();
        panelDados.setPreferredSize(new Dimension(300, 190)); //Establece las dimensiones del JPanel
        panelDados.setBorder(BorderFactory.createTitledBorder("Tus Dados"));
        panelDados.add(dado1);
        panelDados.add(dado2);
        // panelDados.add(lanzar);

        constrains.gridx = 0;
        constrains.gridy = 2;
        constrains.gridwidth = 1;
        constrains.fill = GridBagConstraints.BOTH;
        constrains.anchor = GridBagConstraints.CENTER;

        add(panelDados, constrains);

        resultadosDados = new JTextArea(4,31);
        resultadosDados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        resultadosDados.setText("Debes lanzar los dados");
        resultadosDados.setBackground(null);
        resultadosDados.setEditable(false);
        constrains.gridx = 1;
        constrains.gridy = 2;
        constrains.gridwidth = 1;
        constrains.fill = GridBagConstraints.BOTH;
        constrains.anchor = GridBagConstraints.CENTER;
        add(resultadosDados, constrains);

        lanzar = new JButton("Lanzar");
        lanzar.addActionListener(escucha);
        constrains.gridx = 0;
        constrains.gridy = 3;
        constrains.gridwidth = 2;
        //el none es para que me respete el tamaño que tiene el componente
        constrains.fill = GridBagConstraints.NONE;
        constrains.anchor = GridBagConstraints.CENTER;
        add(lanzar, constrains);

        mensajeDeSalida = new JTextArea(4,31);
        mensajeDeSalida.setText("Usa el boton (?) de ayuda para ver las reglas del juego");
        mensajeDeSalida.setBorder(BorderFactory.createTitledBorder("Mensajes "));
        mensajeDeSalida.setBackground(null);
        mensajeDeSalida.setEditable(false);
        //mensajeDeSalida.setBackground(new Color(255,255,255,0));
        constrains.gridx = 0;
        constrains.gridy = 4;
        constrains.gridwidth = 2;
        constrains.fill = GridBagConstraints.NONE;
        constrains.anchor = GridBagConstraints.CENTER;
        //lo adiciono a la ventana
        add(mensajeDeSalida, constrains);









    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }

    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==lanzar) {
                modelCraps.calcularTiro();
                int[] caras = modelCraps.getCaras();
                imageDado = new ImageIcon(getClass().getResource("/resources/dado_" + caras[0] + ".png"));
                dado1.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/resources/dado_" + caras[1] + ".png"));
                dado2.setIcon(imageDado);
                modelCraps.determinarJuego();
                //Todo lo que este en la primera posicion del arreglo se va poner en el area de texto
                resultadosDados.setText(modelCraps.getEstadoToString()[0]);
                //Se le establece una menor cantidad de filas
                mensajeDeSalida.setText(modelCraps.getEstadoToString()[1]);
            }else{
                if (e.getSource()==ayuda){
                    JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
                }else{
                    System.exit(0);
                }
            }



        }
    }


}
