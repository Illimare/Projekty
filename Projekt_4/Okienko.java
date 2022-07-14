package Projekt_4;

import javax.swing.JFrame;

public class Okienko extends JFrame {

    public Okienko() {

        super();
        setSize(700, 700);
        setLocation(400, 400);
        setTitle("Okieneczko");

    }

    public static void main(String[] args) {

        Okienko o = new Okienko();
        o.setVisible(true);
        o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
