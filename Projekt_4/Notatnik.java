package Projekt_4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class Notatnik extends JFrame implements ActionListener {

    private JTextArea textArea;
    static ImageIcon ikona = new ImageIcon("ikona.jpg");
    private String Styl = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    public Notatnik() {

        super();

        setTitle("Notatnik");

        Toolkit zestaw = Toolkit.getDefaultToolkit();
        Dimension rozmiarEkranu = zestaw.getScreenSize();
        int szerEkranu = rozmiarEkranu.width;
        int wysEkranu = rozmiarEkranu.height;
        System.out.println(szerEkranu);
        System.out.println(wysEkranu);
        setBounds(szerEkranu / 4, wysEkranu / 4, szerEkranu / 2, wysEkranu / 2);

        setResizable(false);

        JMenuBar pasekMenu = new JMenuBar();

        JMenu mPlik = new JMenu("Plik");
        mPlik.setMnemonic('P');

        JMenuItem otworz = new JMenuItem("Otworz");

        otworz.addActionListener(this);
        otworz.setActionCommand("11");

        otworz.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));

        JMenuItem zapisz = new JMenuItem("Zapisz");

        zapisz.addActionListener(this);
        zapisz.setActionCommand("12");

        zapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        JMenuItem zakoncz = new JMenuItem("Zakoncz");
        zakoncz.addActionListener(this);
        zakoncz.setActionCommand("13");

        zakoncz.setAccelerator(KeyStroke.getKeyStroke("ctrl K"));

        mPlik.add(otworz);
        mPlik.add(zapisz);
        mPlik.addSeparator();
        mPlik.add(zakoncz);

        JMenu mEdycja = new JMenu("Edycja");

        JRadioButtonMenuItem pomniejszC = new JRadioButtonMenuItem("Pomniejsz czcionkę");
        JRadioButtonMenuItem normalC = new JRadioButtonMenuItem("Normalna czcionka", true);
        JRadioButtonMenuItem powiekszC = new JRadioButtonMenuItem("Powiększ czcionkę");

        JMenuItem wyczysc = new JMenuItem("Wyczyść");

        mEdycja.add(pomniejszC);
        mEdycja.add(normalC);
        mEdycja.add(powiekszC);
        mEdycja.addSeparator();
        mEdycja.add(wyczysc);

        ButtonGroup bg = new ButtonGroup();
        bg.add(pomniejszC);
        bg.add(normalC);
        bg.add(powiekszC);

        pomniejszC.addActionListener(this);
        pomniejszC.setActionCommand("21");

        normalC.addActionListener(this);
        normalC.setActionCommand("22");

        powiekszC.addActionListener(this);
        powiekszC.setActionCommand("23");

        wyczysc.addActionListener(this);
        wyczysc.setActionCommand("24");

        wyczysc.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));

        JMenu mPomoc = new JMenu("Pomoc");
        JMenuItem autor = new JMenuItem("O Autorze");
        mPomoc.setMnemonic('O');
        mPomoc.add(autor);
        autor.addActionListener(this);
        autor.setActionCommand("31");

        pasekMenu.add(mPlik);
        pasekMenu.add(mEdycja);
        pasekMenu.add(mPomoc);

        setJMenuBar(pasekMenu);

        textArea = new JTextArea();

        JScrollPane sp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);

        Border obramowanieA = BorderFactory.createEtchedBorder();
        Border tytulObramowaniaA = BorderFactory.createTitledBorder(obramowanieA, "Pisanie");
        sp.setBorder(tytulObramowaniaA);

        JPanel panelLewy = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelPrawy = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelCentrum = new JPanel(new FlowLayout(FlowLayout.CENTER));

        Border obramowanieB = BorderFactory.createEtchedBorder();
        Border tytulObramowaniaB = BorderFactory.createTitledBorder(obramowanieB, "Wstawki");
        panelLewy.setBorder(tytulObramowaniaB);

        Border obramowanieC = BorderFactory.createEtchedBorder();
        Border tytulObramowaniaC = BorderFactory.createTitledBorder(obramowanieC, "Kolory tła");
        panelPrawy.setBorder(tytulObramowaniaC);

        Border obramowanieD = BorderFactory.createLineBorder(Color.black);
        Border tytulObramowaniaD = BorderFactory.createTitledBorder(obramowanieD, "Kolory czcionki");
        panelCentrum.setBorder(tytulObramowaniaD);

        JPanel panelPrzyciski = new JPanel(new GridLayout(1, 3));

        panelPrzyciski.add(panelLewy);
        panelPrzyciski.add(panelCentrum);
        panelPrzyciski.add(panelPrawy);

        add(panelPrzyciski, BorderLayout.SOUTH);

        JButton tytul = new JButton("Tytuł");
        panelLewy.add(tytul);

        tytul.addActionListener(this);
        tytul.setActionCommand("41");

        JButton podpis = new JButton("Podpis");
        panelLewy.add(podpis);

        podpis.addActionListener(this);
        podpis.setActionCommand("42");

        JRadioButton bi = new JRadioButton("biały", true);
        JRadioButton zo = new JRadioButton("żółty");
        JRadioButton zi = new JRadioButton("zielony");

        bi.addActionListener(this);
        zo.addActionListener(this);
        zi.addActionListener(this);

        ButtonGroup bg1 = new ButtonGroup();

        bg1.add(bi);
        bg1.add(zo);
        bg1.add(zi);

        panelPrawy.add(bi);
        panelPrawy.add(zo);
        panelPrawy.add(zi);

        bi.setActionCommand("51");
        zo.setActionCommand("52");
        zi.setActionCommand("53");

        String[] czKolory = {"czerwona", "zielona", "niebieska", "czarna", "biala"};
        JLabel etyKolory = new JLabel("Kolory:  ");
        panelCentrum.add(etyKolory);
        JComboBox kolorList = new JComboBox(czKolory);
        kolorList.setSelectedIndex(3);
        kolorList.addActionListener(this);
        panelCentrum.add(kolorList);
        kolorList.setActionCommand("6");
        
        JPopupMenu menuPopUP = new JPopupMenu();
        JMenuItem metal = new JMenuItem("metal look-and-feel");
        JMenuItem windows = new JMenuItem("windows look-and-feel");
        JMenuItem motif = new JMenuItem("motif look-and-feel");
        JMenuItem nimbus = new JMenuItem("nimbus look-and-feel");
        
        menuPopUP.add(metal);
        menuPopUP.add(windows);
        menuPopUP.add(motif);
        menuPopUP.add(nimbus);
        
        textArea.setComponentPopupMenu(menuPopUP);
        
        metal.addActionListener(this);
        metal.setActionCommand("71");
        
        windows.addActionListener(this);
        windows.setActionCommand("72");
        
        motif.addActionListener(this);
        motif.setActionCommand("73");
        
        nimbus.addActionListener(this);
        nimbus.setActionCommand("74"); 
    }

    
    public void Style() throws Exception {
        UIManager.setLookAndFeel(Styl);
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        Notatnik nt = new Notatnik();
        nt.setIconImage(ikona.getImage());
        nt.setVisible(true);
        nt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (Integer.parseInt(ae.getActionCommand())) {
            case 11: {
                JFileChooser pliki = new JFileChooser(".");
                if (JFileChooser.APPROVE_OPTION == pliki.showOpenDialog(this)) {
                    try {
                        File f = pliki.getSelectedFile();
                        setTitle(f.getAbsolutePath() + " Notatnik");
                        BufferedReader br = new BufferedReader(new FileReader(f));
                        String temp = "";
                        while (br.ready()) {
                            temp += br.readLine() + "\n";
                        }
                        textArea.setText(temp);
                    } catch (IOException ex) {
                        System.out.println("Brak pliku");
                    }
                }
                break;
            }
            case 12: {
                JFileChooser pliki = new JFileChooser(".");
                if (JFileChooser.APPROVE_OPTION == pliki.showSaveDialog(this)) {
                    try {
                        File f = pliki.getSelectedFile();
                        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                        bw.write(textArea.getText());
                        bw.flush();
                        bw.close();
                    } catch (IOException ee) {
                        System.out.println("Problemy z zapisem");
                    }
                }
                break;
            }
            case 13: {
                System.exit(0);
                break;
            }
            case 21: {
                Font f = new Font("Arial", Font.PLAIN, 8);
                textArea.setFont(f);
                break;
            }
            case 22: {
                Font f = new Font("Arial", Font.PLAIN, 12);
                textArea.setFont(f);
                break;
            }
            case 23: {
                Font f = new Font("Arial", Font.PLAIN, 18);
                textArea.setFont(f);
                break;
            }
            case 24: {
                textArea.setText("");
                break;
            }
            case 31: {
                JOptionPane.showMessageDialog(this, "Autor: Wiktoria Pachulska");
                break;
            }
            case 41: {
                textArea.setText("Szanowna/y Pani/e \n\n" + textArea.getText());
                break;
            }
            case 42: {
                textArea.setText(textArea.getText() + "\n\n Z poważaniem");
                break;
            }
            case 51: {
                textArea.setBackground(Color.WHITE);
                break;
            }
            case 52: {
                textArea.setBackground(Color.YELLOW);
                break;
            }
            case 53: {
                textArea.setBackground(Color.GREEN);
                break;
            }
            case 6: {
                JComboBox komboBox = (JComboBox) ae.getSource();
                switch (komboBox.getSelectedIndex()) {
                    case 0: {
                        textArea.setForeground(Color.RED);
                        break;
                    }
                    case 1: {
                        textArea.setForeground(Color.GREEN);
                        break;
                    }
                    case 2: {
                        textArea.setForeground(Color.BLUE);
                        break;
                    }
                    case 3: {
                        textArea.setForeground(Color.BLACK);
                        break;
                    }
                    case 4: {
                        textArea.setForeground(Color.WHITE);
                        break;
                    }
                    default: {
                        System.out.println("błąd koloru");
                    }
                }
                break;
            }
            case 71:{
                Styl = "javax.swing.plaf.metal.MetalLookAndFeel";
            try {
                Style();
            } catch (Exception ex) {
                Logger.getLogger(Notatnik.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case 72:{
                Styl="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            try {
                Style();
            } catch (Exception ex) {
                Logger.getLogger(Notatnik.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case 73:{
                Styl ="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		try {
                Style();
            } catch (Exception ex) {
                Logger.getLogger(Notatnik.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case 74:{
                Styl = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
		try {
                Style();
            } catch (Exception ex) {
                Logger.getLogger(Notatnik.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            default: {
                System.out.println("nieznany przycisk");
            }

        }
    }
}
