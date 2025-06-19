package affichage;

import fonction.FiltrageComposant;
import politicien.Resultat;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.util.Vector;

public class BureauVotePanel extends JComboBox<String> {
    private FiltrageComposant filtrageComposant = new FiltrageComposant();
    private Vector<Resultat> donnees;

    public BureauVotePanel(Vector<Resultat> donnees) {
        this.donnees = donnees;
        setRenderer(new BasicComboBoxRenderer());
        remplirComboBureau();
    }

    private void remplirComboBureau() {
        Vector<String> bureauxUniques = new Vector<>();
        for (Resultat resultat : donnees) {
            String nom = resultat.getBureauVote();
            if (!bureauxUniques.contains(nom)) {
                bureauxUniques.add(nom);
            }
        }
        setModel(new DefaultComboBoxModel<>(bureauxUniques));
    }

    public String getBureauSelectionne() {
        return (String) getSelectedItem();
    }
}
