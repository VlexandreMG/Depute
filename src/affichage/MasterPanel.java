package affichage;

import fonction.FiltrageComposant;
import geographie.BureauVote;
import politicien.Resultat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        faritanyPanel.addActionListener(e -> {
            String selectedFaritany = faritanyPanel.getFaritanySelectionnee();
            if (selectedFaritany != null) {
                // Utilisez directement vos Resultat existants
                Vector<String> regions = filtre.getRegionsFromFaritany(donnees, selectedFaritany);
                regionPanel.setModel(new DefaultComboBoxModel<>(regions));

                // Réinitialisation des niveaux inférieurs
                districtPanel.setModel(new DefaultComboBoxModel<>());
                bureauPanel.setModel(new DefaultComboBoxModel<>());
            }
        });

        // Région -> Met à jour District
        regionPanel.addActionListener(e -> {
            String selectedRegion = regionPanel.getRegionSelectionnee();
            if (selectedRegion != null) {
                Vector<String> district = filtre.getDistrictFromRegion(donnees, selectedRegion);
                districtPanel.setModel(new DefaultComboBoxModel<>(district));

                bureauPanel.setModel(new DefaultComboBoxModel<>());

            }
        });

        // District -> Met à jour Bureau
        districtPanel.addActionListener(e -> {
            String selectedDistrict = districtPanel.getDistrictSelectionne();
            if (selectedDistrict != null) {
                Vector<String> bureau = filtre.getBureauFromDistrict(donnees, selectedDistrict);
                bureauPanel.setModel(new DefaultComboBoxModel<>(bureau));
            }
        });
    }
}