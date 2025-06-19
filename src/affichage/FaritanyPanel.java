package affichage;

import fonction.FiltrageComposant;
import politicien.Resultat;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class FaritanyPanel extends JPanel {
    FiltrageComposant filtrageComposant = new FiltrageComposant();
    JComboBox<String> comboFaritany = new JComboBox<>();
    Vector<Resultat> donnees;

    public FaritanyPanel(Vector<Resultat> donnees) {

        setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel jlabel = new JLabel("Faritany");
        add(jlabel);

        remplirComboFaritany();
        getFaritanyselectionnee();
        getComboFaritany();

    }

    private void remplirComboFaritany() {
        Vector<Resultat> vectorFaritany = filtrageComposant.VectorFaritany(donnees);
        Vector<String> faritanyUnique = new Vector<>();

        for (Resultat resultat : vectorFaritany) {
            String nom = resultat.getFaritanyVote();
                if (!faritanyUnique.contains(nom)) {
                    faritanyUnique.add(nom);
                }
        }

        comboFaritany.setModel(new DefaultComboBoxModel<>(faritanyUnique));
    }

    public String getFaritanyselectionnee() {
        return (String) comboFaritany.getSelectedItem();
    }

    public JComboBox<String> getComboFaritany() {
        return comboFaritany;
    }


}
