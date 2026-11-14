
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

        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        mainPanel = new JPanel();

        mainPanel.setLayout(
            new BoxLayout(mainPanel, BoxLayout.Y_AXIS)
        );

        // Judul dan jumlah karakter
        JLabel titleLabel = new JLabel(
            "=== Daftar Karakter (" +
            characterList.size() + ") ==="
        );

        mainPanel.add(titleLabel);

        // Menampilkan data karakter secara dinamis
        for (Character c : characterList) {

            String info =
                c.getName() + " | " +
                c.getType() +
                " | Lv." + c.getLevel() +
                " | HP:" + c.getHitPoints() +
                " | ATK:" + c.getAttackPower();

            JLabel characterLabel = new JLabel(info);

            mainPanel.add(characterLabel);
        }

        // Menghitung rata-rata level
        double averageLevel = 0;

        if (!characterList.isEmpty()) {

            int totalLevel = 0;

            for (Character c : characterList) {
                totalLevel += c.getLevel();
            }

            averageLevel =
                (double) totalLevel / characterList.size();
        }

        // Menampilkan statistik di bawah daftar
        JLabel statisticsLabel = new JLabel(
            "Rata-rata Level: " +
            String.format("%.2f", averageLevel)
        );

        mainPanel.add(statisticsLabel);

        add(mainPanel);
    }
}
