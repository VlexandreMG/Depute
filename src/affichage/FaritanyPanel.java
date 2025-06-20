package affichage;

import fonction.FiltrageComposant;
import politicien.Resultat;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.util.Vector;

public class FaritanyPanel extends JComboBox<String> {
    private final FiltrageComposant filtrageComposant = new FiltrageComposant();
    private final Vector<Resultat> donnees;

    public FaritanyPanel(Vector<Resultat> donnees) {
        this.donnees = donnees;
        setRenderer(new BasicComboBoxRenderer());
        remplirComboFaritany();
    }

    private void remplirComboFaritany() {
        // 1. On récupère toutes les faritany uniques
        Vector<String> faritanyUnique = new Vector<>();

        // 2. Parcours de tous les résultats
        for (Resultat resultat : donnees) {
            String nomFaritany = resultat.getFaritanyVote();
            if (nomFaritany != null && !faritanyUnique.contains(nomFaritany)) {
                faritanyUnique.add(nomFaritany);
            }
        }

        // 3. On set le modèle
        setModel(new DefaultComboBoxModel<>(faritanyUnique));
    }

    public String getFaritanySelectionnee() {
        return (String) getSelectedItem();
    }
}