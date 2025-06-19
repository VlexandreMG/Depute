package affichage;

import fonction.FiltrageComposant;
import politicien.Resultat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ElectionButton extends JButton {
     MasterPanel masterPanel;
     FiltrageComposant filtre = new FiltrageComposant();

    public ElectionButton(MasterPanel masterPanel) {
        super("Trouver le(s) gagnant(s)");
        this.masterPanel = masterPanel;
        setPreferredSize(new Dimension(200, 30));
        setupListener();
    }

    private void setupListener() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<Resultat> resultatsFiltres = filtrerResultats();
                Vector<String> gagnants = filtre.trouverCandidatsGagnants(resultatsFiltres);

                if (gagnants.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Aucun résultat trouvé !", "Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Candidat(s) élu(s) : " + String.join(", ", gagnants),
                            "Résultats",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private Vector<Resultat> filtrerResultats() {
        Vector<Resultat> resultats = masterPanel.getDonnees();

        // Filtrage en cascade
        if (masterPanel.getFaritanyCombo().getSelectedItem() != null) {
            resultats = filtre.VectorFaritany(resultats);
        }
        if (masterPanel.getRegionCombo().getSelectedItem() != null) {
            resultats = filtre.VectorRegion(resultats);
        }
        if (masterPanel.getDistrictCombo().getSelectedItem() != null) {
            resultats = filtre.VectorDistrict(resultats);
        }
        if (masterPanel.getBureauCombo().getSelectedItem() != null) {
            resultats = filtre.VectorBureau(resultats);
        }
        return resultats;
    }

}
