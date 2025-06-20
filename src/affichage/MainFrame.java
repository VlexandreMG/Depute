package affichage;

import politicien.Resultat;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MainFrame extends JFrame {

    public MainFrame(Vector<Resultat> donnees) {
        setTitle("Election Depute");
        setMinimumSize(new Dimension(500,500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        MasterPanel masterPanel = new MasterPanel(donnees);
        add(masterPanel);

        InsertPanel insertPanel = new InsertPanel(donnees);
        add(insertPanel);

        JTabbedPane onglets = new JTabbedPane();
        onglets.add("Resultat",masterPanel);
        onglets.add("Insertion",insertPanel);

        add(onglets);
        setVisible(true);

    }
}
