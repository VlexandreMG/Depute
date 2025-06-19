package affichage;

import politicien.Resultat;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MainFrame extends JFrame {

    public MainFrame(Vector<Resultat> donnees) {
        setTitle("Election Depute");
        setMinimumSize(new Dimension(1000,1000));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        FaritanyPanel faritanyPanel = new FaritanyPanel(donnees);
        add(faritanyPanel);

        setVisible(true);


    }
}
