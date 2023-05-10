package Modelo;

import javax.swing.*;
import java.awt.*;

public class Puntaje extends JTextArea {
    private String marcador;

    /**
     * Estos son los labels que tienen los puntajes en la tabla
     * @param marcador
     */

    public Puntaje(String marcador) {
        this.marcador = marcador;
        this.setEditable(false);
        this.setFont( new Font("SansSerif",Font.BOLD, 25) );
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setText(marcador);

    }

    public String getMarcador() {
        return marcador;
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
        this.setText(marcador);
    }
}
