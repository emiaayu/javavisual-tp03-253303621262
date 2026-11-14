
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // Tiga karakter awal
        manager.addCharacter(
            new Character("Arjuna", CharacterType.WARRIOR, 5)
        );

        manager.addCharacter(
            new Character("Merlin", CharacterType.MAGE, 3)
        );

        manager.addCharacter(
            new Character("Athena", CharacterType.ARCHER, 4)
        );

        // Dua karakter tambahan TP8
        manager.addCharacter(
            new Character("Lyra", CharacterType.HEALER, 2)
        );

        manager.addCharacter(
            new Character("Kael", CharacterType.WARRIOR, 6)
        );

        manager.addCharacter(
            new Character("Zephyr", CharacterType.MAGE, 8));

        // Menjalankan GUI melalui Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            MainWindow window =
                new MainWindow(manager.getAllCharacters());

            window.setVisible(true);
        });
    }
}
