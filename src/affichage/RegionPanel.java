package affichage;

import fonction.FiltrageComposant;
import politicien.Resultat;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.util.Vector;

public class RegionPanel extends JComboBox<String> {
    private FiltrageComposant filtrageComposant = new FiltrageComposant();
    private Vector<Resultat> donnees;

    public RegionPanel(Vector<Resultat> donnees) {
        this.donnees = donnees;
        setRenderer(new BasicComboBoxRenderer());
        remplirComboRegion();
    }

    private void remplirComboRegion() {
        Vector<String> regionsUniques = new Vector<>();
        for (Resultat resultat : donnees) {
            String nom = resultat.getRegionVote();
            if (!regionsUniques.contains(nom)) {
                regionsUniques.add(nom);
            }
        }
        setModel(new DefaultComboBoxModel<>(regionsUniques));
    }

    public String getRegionSelectionnee() {
        return (String) getSelectedItem();
    }
}
