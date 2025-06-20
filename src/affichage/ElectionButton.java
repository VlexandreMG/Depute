package affichage;

import fonction.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ElectionButton extends JButton {
    private final MasterPanel masterPanel;
    private final SpitString spitString = new SpitString();

    public ElectionButton(MasterPanel masterPanel) {
        super("Trouver le(s) gagnant(s)");
        this.masterPanel = masterPanel;
        setPreferredSize(new Dimension(200, 30));
        setupListener();
    }

    private void setupListener() {
        this.addActionListener(e -> {
            try {
                // Récupère les sélections via MasterPanel
                String faritany = masterPanel.getFaritanySelectionnee();
                String region = masterPanel.getRegionSelectionnee();
                String district = masterPanel.getDistrictSelectionne();
                String bureau = masterPanel.getBureauSelectionne();

                String[][] resultats = spitString.gagnant(faritany, region, district, bureau);
                String[][] elusParDistrict = spitString.trouverElusParDistrict(resultats);
                afficherResultats(elusParDistrict);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(masterPanel,
                        "Erreur de lecture des données",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
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