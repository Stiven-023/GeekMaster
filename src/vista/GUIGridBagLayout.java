package vista;

import Modelo.ModelCraps;
import Modelo.Puntaje;

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
    private JLabel dado1, dado2, dado3,dado4,dado5,dado6,dado7,dado8,dado9,dado10;
    private JButton lanzar, ayuda, salir;
    private JPanel gridPuntaje,todo, gridPanel, panelBoton, panelDados, panelTarjetaPunto, dadosUtilizados, dadosInactivos;
    private ImageIcon imageDado;
    private Container containerPp;
    private Puntaje marcador;
    private JTextArea resultadosDados, mensajeDeSalida;
    // componente grafico que me crea una linea separadora
    //private JSeparator separador;
    private Escucha escucha;
    private ModelCraps modelCraps; //objeto modelo

    public GUIGridBagLayout(){

        initGUI();

        this.setTitle("Juego Craps");
        //this.setUndecorated(true);
        //this.setBackground(new Color(255,255,255,0));
        this.pack();
        this.setSize(900,500);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    private void initGUI() {
        gridPanel = new JPanel(new GridLayout(2,2));

        todo = new JPanel(new BorderLayout());

        // Panel botones
        panelBoton = new JPanel();

        lanzar = new JButton("Lanzar");
        lanzar.addActionListener(escucha);
        panelBoton.add(lanzar);

        dadosUtilizados = new JPanel();
        dadosUtilizados.setBorder(BorderFactory.createTitledBorder("Dados Utilizados"));


        panelTarjetaPunto = new JPanel();

        panelTarjetaPunto.setBorder(BorderFactory.createTitledBorder("Tarjeta Puntuacion"));


        marcador = new Puntaje("1");
        marcador = new Puntaje("3");
        gridPuntaje = new JPanel(new GridLayout(3,3));
        gridPuntaje.setFocusable(true);
        gridPuntaje.requestFocusInWindow();

        gridPuntaje.add(marcador);
        panelTarjetaPunto.add(gridPuntaje);



        //Set up JFrame Container's Layout
        // this.getContentPane().setLayout(new GridBagLayout());
        // GridBagConstraints constrains = new GridBagConstraints();
        //Create Listener Object or Control Object
        escucha = new Escucha();
        modelCraps = new ModelCraps();
        //Set up JComponents
        headerProject = new Header("Mesa De Juego Craps", Color.BLACK);
        //constrains.gridx=0;
        //constrains.gridy=0;
        //constrains.gridwidth =2;
        //ancho que va tomar el componente
        //constrains.fill= GridBagConstraints.HORIZONTAL;
        //this.add(headerProject, constrains);
        //this.add(head |erProject,BorderLayout.NORTH);

        /**
        ayuda = new JButton(" ? ");
        ayuda.addActionListener(escucha);
        constrains.gridx =0;
        constrains.gridy =1;
        constrains.gridwidth=1;
        constrains.fill= GridBagConstraints.NONE;
        constrains.anchor= GridBagConstraints.LINE_START;
         */
        // this.add(ayuda, constrains);

        salir = new JButton("Salir");
        salir.addActionListener(escucha);
        //constrains.gridx = 1;
        //constrains.gridy = 1;
        //constrains.fill=GridBagConstraints.NONE;
        //constrains.anchor= GridBagConstraints.LINE_END;
        //this.add(salir, constrains);

        imageDado = new ImageIcon(getClass().getResource("/resources/dado.jpg"));
        dado1 = new JLabel(imageDado);
        dado2 = new JLabel(imageDado);
        dado3 = new JLabel(imageDado);
        dado4 = new JLabel(imageDado);
        dado5 = new JLabel(imageDado);
        dado6 = new JLabel(imageDado);
        dado7 = new JLabel(imageDado);




        panelDados = new JPanel();
        panelDados.setPreferredSize(new Dimension(300, 190)); //Establece las dimensiones del JPanel
        panelDados.setBorder(BorderFactory.createTitledBorder("Tus Dados"));
        panelDados.add(dado1);
        panelDados.add(dado2);
        panelDados.add(dado3);
        panelDados.add(dado4);
        panelDados.add(dado5);
        panelDados.add(dado6);
        panelDados.add(dado7);

        dadosInactivos = new JPanel();
        dadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos"));
        dado8 = new JLabel(imageDado);
        dado9 = new JLabel(imageDado);
        dado10 = new JLabel(imageDado);




        dadosInactivos.add(dado8);
        dadosInactivos.add(dado9);
        dadosInactivos.add(dado10);



        /**
        resultadosDados = new JTextArea(4,31);
        resultadosDados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        resultadosDados.setText("Debes lanzar los dados");
        resultadosDados.setBackground(null);
        resultadosDados.setEditable(false);
         */

        //panelDados.add(resultadosDados);
        // panelDados.add(lanzar);

        //constrains.gridx = 0;
        //constrains.gridy = 2;
        //constrains.gridwidth = 1;
        //constrains.fill = GridBagConstraints.BOTH;
        //constrains.anchor = GridBagConstraints.CENTER;

        //add(panelDados, constrains);

        gridPanel.add(panelDados);
        gridPanel.add(dadosUtilizados);
        gridPanel.add(panelTarjetaPunto);
        gridPanel.add(dadosInactivos);

        todo.add(panelBoton, BorderLayout.SOUTH);
        todo.add(gridPanel, BorderLayout.CENTER);




        /**

        constrains.gridx = 1;
        constrains.gridy = 2;
        constrains.gridwidth = 1;
        constrains.fill = GridBagConstraints.BOTH;
        constrains.anchor = GridBagConstraints.CENTER;
        add(resultadosDados, constrains);


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
        constrains.anchor = GridBagConstraints.LAST_LINE_START;
        //lo adiciono a la ventana
        add(mensajeDeSalida, constrains);

         */
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
