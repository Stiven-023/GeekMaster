package Modelo;

import javax.swing.*;
import java.awt.*;

public class Puntaje extends JTextArea {
    private String marcador;



    public Puntaje(String marcador) {
        this.marcador = marcador;
        this.setFont( new Font("SansSerif",Font.BOLD, 22) );
    }

}
