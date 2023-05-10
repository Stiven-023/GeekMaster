package vista;

import javax.swing.ImageIcon;

public class Dado extends javax.swing.JPanel {

    public Dado (int numImg){

        switch (numImg){
            case 1:
                ImageIcon mupel = new ImageIcon(("src/resources/mepple.png"));
                this.add(new javax.swing.JLabel(mupel));
                break;
            case 2:
                ImageIcon cohete = new ImageIcon(("src/resources/cohete.png"));
                this.add(new javax.swing.JLabel(cohete));
                break;
            case 3:
                ImageIcon superHeroe = new ImageIcon(("src/resources/superHeroe.png"));
                this.add(new javax.swing.JLabel(superHeroe));
                break;
            case 4:
                ImageIcon drake = new ImageIcon(("src/resources/dragon.png"));
                this.add(new javax.swing.JLabel(drake));
                break;
            case 5:
                ImageIcon heart = new ImageIcon(("src/resources/corazon.png"));
                this.add(new javax.swing.JLabel(heart));
                break;
            case 6:
                ImageIcon forty = new ImageIcon(("src/resources/forty.png"));
                this.add(new javax.swing.JLabel(forty));
                break;
            default:
                ImageIcon def = new ImageIcon(("src/resources/forty.png"));
                this.add(new javax.swing.JLabel(def));
                break;

        }



    }
    //public Dado (int numImg2);

}

