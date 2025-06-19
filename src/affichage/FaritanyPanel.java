package affichage;

import fonction.FiltrageComposant;
import politicien.Resultat;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.util.Vector;

public class FaritanyPanel extends JComboBox<String> {
    FiltrageComposant filtrageComposant = new FiltrageComposant();
    Vector<Resultat> donnees;

    public FaritanyPanel(Vector<Resultat> donnees) {
        this.donnees = donnees;
        setRenderer(new BasicComboBoxRenderer());
        remplirComboFaritany();
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

        setModel(new DefaultComboBoxModel<>(faritanyUnique));
    }

    public String getFaritanySelectionnee() {
        return (String) getSelectedItem();
    }

}
