package affichage;

import fonction.FiltrageComposant;
import politicien.Resultat;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MasterPanel extends JPanel {
    private final FaritanyPanel faritanyPanel;
    private final RegionPanel regionPanel;
    private final DistrictPanel districtPanel;
    private final BureauVotePanel bureauPanel;
    private final ElectionButton electionButton;
    private final Vector<Resultat> donnees;
    private final FiltrageComposant filtre = new FiltrageComposant();

    public MasterPanel(Vector<Resultat> donnees) {
        this.donnees = donnees;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 1. Faritany
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Faritany:"), gbc);

        gbc.gridx = 1;
        faritanyPanel = new FaritanyPanel(donnees);
        add(faritanyPanel, gbc);

        // 2. Région
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Région:"), gbc);

        gbc.gridx = 1;
        regionPanel = new RegionPanel(donnees);
        add(regionPanel, gbc);

        // 3. District
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("District:"), gbc);

        gbc.gridx = 1;
        districtPanel = new DistrictPanel(donnees);
        add(districtPanel, gbc);

        // 4. Bureau
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Bureau:"), gbc);

        gbc.gridx = 1;
        bureauPanel = new BureauVotePanel(donnees);
        add(bureauPanel, gbc);

        // 5. Bouton d'élection
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        electionButton = new ElectionButton(this);
        add(electionButton, gbc);

        setupListeners();
    }

    private void setupListeners() {
        // Faritany -> Met à jour Région
        faritanyPanel.addActionListener(e -> {
            if (faritanyPanel.getSelectedItem() != null) {
                Vector<Resultat> filtres = filtre.VectorFaritany(donnees);
                regionPanel.setModel(new DefaultComboBoxModel<>(getUniqueValues(filtres, true, false, false)));
                districtPanel.setModel(new DefaultComboBoxModel<>());
                bureauPanel.setModel(new DefaultComboBoxModel<>());
            }
        });

        // Région -> Met à jour District
        regionPanel.addActionListener(e -> {
            if (regionPanel.getSelectedItem() != null) {
                Vector<Resultat> filtres = filtre.VectorRegion(donnees);
                districtPanel.setModel(new DefaultComboBoxModel<>(getUniqueValues(filtres, false, true, false)));
                bureauPanel.setModel(new DefaultComboBoxModel<>());
            }
        });

        // District -> Met à jour Bureau
        districtPanel.addActionListener(e -> {
            if (districtPanel.getSelectedItem() != null) {
                Vector<Resultat> filtres = filtre.VectorDistrict(donnees);
                bureauPanel.setModel(new DefaultComboBoxModel<>(getUniqueValues(filtres, false, false, true)));
            }
        });
    }

    private Vector<String> getUniqueValues(Vector<Resultat> resultats, boolean isRegion, boolean isDistrict, boolean isBureau) {
        Vector<String> values = new Vector<>();
        for (Resultat r : resultats) {
            String nom = isRegion ? r.getRegionVote() :
                    isDistrict ? r.getDistrictVote() :
                            r.getBureauVote();
            if (!values.contains(nom)) {
                values.add(nom);
            }
        }
        return values;
    }

    // Getters modifiés
    public Vector<Resultat> getDonnees() { return donnees; }
    public JComboBox<String> getFaritanyCombo() { return faritanyPanel; }
    public JComboBox<String> getRegionCombo() { return regionPanel; }
    public JComboBox<String> getDistrictCombo() { return districtPanel; }
    public JComboBox<String> getBureauCombo() { return bureauPanel; }
}