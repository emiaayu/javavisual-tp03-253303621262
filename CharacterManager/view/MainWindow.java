package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.util.ArrayList;
import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;

    public MainWindow(ArrayList<Character> characterList) {
        super("Character Manager v0.3");

        this.characterList = characterList;

        initComponents();

        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("=== Daftar Karakter ===");
        mainPanel.add(titleLabel);

        // Menampilkan data karakter
        for (Character character : characterList) {
            JLabel characterLabel = new JLabel(
                character.getName()
            );

            mainPanel.add(characterLabel);
        }

        add(mainPanel);
    }
}