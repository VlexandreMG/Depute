package affichage;

import fonction.*;
import politicien.Resultat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class InsertPanel extends JPanel {
    private final FaritanyPanel faritanyPanel;
    private final RegionPanel regionPanel;
    private final DistrictPanel districtPanel;
    private final BureauVotePanel bureauPanel;
    private final CandidatPanel candidatPanel;
    private final JTextField textField;
    private final JButton button;
    private final Vector<Resultat> donnees;
    private final FiltrageComposant filtre = new FiltrageComposant();

    public InsertPanel(Vector<Resultat> donnees) {
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

        // 5. Candidat
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Candidat:"), gbc);

        gbc.gridx = 1;
        candidatPanel = new CandidatPanel(donnees);
        add(candidatPanel, gbc);

        // 5. JTextField
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Nombre de voix:"), gbc);

        gbc.gridx = 1;
        textField = new JTextField(20);
        add(textField, gbc);

        // 6. Bouton
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2; // Prend 2 colonnes
        gbc.fill = GridBagConstraints.CENTER;
        button = new JButton("Valider");
        add(button,gbc);
        // Dans le constructeur de InsertPanel, modifiez l'actionListener du bouton :
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Récupérer les valeurs sélectionnées
                    String faritany = faritanyPanel.getFaritanySelectionnee();
                    String region = regionPanel.getRegionSelectionnee();
                    String district = districtPanel.getDistrictSelectionne();
                    String bureau = bureauPanel.getBureauSelectionne();
                    String candidat = candidatPanel.getCandidatSelectionne();
                    String nbVoix = textField.getText();

                    // Vérifier que tous les champs sont remplis
                    if (faritany == null || region == null || district == null ||
                            bureau == null || candidat == null || nbVoix.isEmpty()) {
                        JOptionPane.showMessageDialog(InsertPanel.this,
                                "Veuillez remplir tous les champs",
                                "Erreur",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Enregistrer le vote
                    ListennerSave listener = new ListennerSave();
                    listener.register(faritany, region, district, bureau, candidat, nbVoix);

                    JOptionPane.showMessageDialog(InsertPanel.this,
                            "Vote enregistré avec succès!",
                            "Succès",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Effacer le champ des voix après enregistrement
                    textField.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(InsertPanel.this,
                            "Nombre de voix invalide",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(InsertPanel.this,
                            "Erreur lors de l'enregistrement",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
    }

    // Getters pour accéder aux composants depuis l'extérieur
    public JTextField getTextField() {
        return textField;
    }

    public JButton getButton() {
        return button;
    }

    public CandidatPanel getCandidatPanel() {
        return candidatPanel;
    }
}