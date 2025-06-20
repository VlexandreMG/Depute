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
            String nomRegion = resultat.getRegionVote();
            if (nomRegion != null && !regionsUniques.contains(nomRegion)) {
                regionsUniques.add(nomRegion);
            }
        }
        setModel(new DefaultComboBoxModel<>(regionsUniques));
    }

    public String getRegionSelectionnee() {
        return (String) getSelectedItem();
    }
}
