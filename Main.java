package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // 1. Membuat data karakter (Model)
        CharacterManager manager = new CharacterManager();

        manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
        manager.addCharacter(new Character("Athena", CharacterType.ARCHER, 4));

        // 2. Menjalankan GUI melalui Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            ArrayList<Character> characters = manager.getAllCharacters();

            MainWindow window = new MainWindow(characters);

            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);

        });
    }
}