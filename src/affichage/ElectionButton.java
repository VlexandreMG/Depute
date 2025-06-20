package affichage;

import fonction.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ElectionButton extends JButton {
     MasterPanel masterPanel;
     FaritanyPanel faritanyPanel;
     RegionPanel regionPanel;
     DistrictPanel districtPanel;
     BureauVotePanel bureauVotePanel;
     SpitString spitString = new SpitString();

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
                try {
                    // Récupère les sélections des ComboBox
                    String faritany = faritanyPanel.getFaritanySelectionnee();
                    String region = regionPanel.getRegionSelectionnee();
                    String district = districtPanel.getDistrictSelectionne();
                    String bureau = bureauVotePanel.getBureauSelectionne();

                    // Appel à gagnant() avec les sélections
                    String[][] resultats = spitString.gagnant(faritany, region, district, bureau);

                    // Trouve les élus par district
                    String[][] elusParDistrict = spitString.trouverElusParDistrict(resultats);

                    // Affiche les résultats (à adapter selon votre besoin)
                    afficherResultats(elusParDistrict);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(masterPanel,
                            "Erreur de lecture des données",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void afficherResultats(String[][] resultats) {
        StringBuilder sb = new StringBuilder();
        for (String[] ligne : resultats) {
            sb.append("District: ").append(ligne[0])
                    .append(" | Elu: ").append(ligne[1])
                    .append(" | Voix: ").append(ligne[2])
                    .append("\n");
        }
        JOptionPane.showMessageDialog(masterPanel,
                sb.toString(),
                "Résultats des élections",
                JOptionPane.INFORMATION_MESSAGE);
    }


}
