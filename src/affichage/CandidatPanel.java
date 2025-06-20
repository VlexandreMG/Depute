package affichage;

import fonction.FiltrageComposant;
import politicien.Resultat;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.util.Vector;

public class CandidatPanel extends JComboBox<String> {
    private final FiltrageComposant filtrageComposant = new FiltrageComposant();
    private final Vector<Resultat> donnees;

    public CandidatPanel(Vector<Resultat> donnees) {
        this.donnees = donnees;
        setRenderer(new BasicComboBoxRenderer());
        remplirComboCandidat();
    }

    private void remplirComboCandidat() {
        Vector<Resultat> vectorCandidats = filtrageComposant.VectorCandidats(donnees);
        Vector<String> candidatsUnique = new Vector<>();

        for (Resultat resultat : vectorCandidats) {
            String nom = resultat.getNomcandidat();
            if (!candidatsUnique.contains(nom)) {
                candidatsUnique.add(nom);
            }
        }

        setModel(new DefaultComboBoxModel<>(candidatsUnique));
    }

    public String getCandidatSelectionne() {
        return (String) getSelectedItem();
    }
}