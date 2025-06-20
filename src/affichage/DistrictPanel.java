package affichage;

import fonction.FiltrageComposant;
import politicien.Resultat;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.util.Vector;

public class DistrictPanel extends JComboBox<String> {
    private FiltrageComposant filtrageComposant = new FiltrageComposant();
    private Vector<Resultat> donnees;

    public DistrictPanel(Vector<Resultat> donnees) {
        this.donnees = donnees;
        setRenderer(new BasicComboBoxRenderer());
        remplirComboDistrict();
    }

    private void remplirComboDistrict() {
        Vector<String> districtsUniques = new Vector<>();
        for (Resultat resultat : donnees) {
            String nomDistrict = resultat.getDistrictVote();
            if (nomDistrict != null && !districtsUniques.contains(nomDistrict)) {
                districtsUniques.add(nomDistrict);
            }
        }
        setModel(new DefaultComboBoxModel<>(districtsUniques));
    }

    public String getDistrictSelectionne() {
        return (String) getSelectedItem();
    }
}
