import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== CHARACTER MANAGER v0.4 ===");

        // 1. Membuat CharacterManager
        CharacterManager manager = new CharacterManager();

        // 2. Menambahkan karakter
        System.out.println("\n--- TAMBAH KARAKTER ---");

        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5));

        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3));

        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4));

        manager.addCharacter(
                new Character("Gatotkaca", CharacterType.WARRIOR, 7));

        manager.addCharacter(
                new Character("Morgana", CharacterType.MAGE, 1));

        // 3. Menguji duplikasi
        System.out.println("\n--- UJI DUPLIKAT ---");

        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 2));

        // 4. Menampilkan seluruh karakter
        System.out.println("\n--- DAFTAR KARAKTER ---");

        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        // 5. Menghitung total karakter
        System.out.println("\nTotal karakter: "
                + manager.getTotalCharacters());

        // 6. Mencari karakter
        System.out.println("\n--- PENCARIAN KARAKTER ---");

        Character hasil = manager.findByName("Merlin");

        System.out.println("Hasil pencarian: " + hasil);

        Character tidakAda = manager.findByName("Zeus");

        System.out.println("Pencarian Zeus: " + tidakAda);

        // 7. Menghapus karakter
        System.out.println("\n--- HAPUS KARAKTER ---");

        manager.removeCharacter("Athena");

        System.out.println("Total setelah penghapusan: "
                + manager.getTotalCharacters());

        // 8. Analisis rata-rata level
        System.out.println("\n--- ANALISIS LEVEL ---");

        System.out.println("Rata-rata level: "
                + manager.getAverageLevel());

        System.out.println("Rata-rata manager kosong: "
                + new CharacterManager().getAverageLevel());

        // 9. Mencari berdasarkan tipe
        System.out.println("\n--- FIND BY TYPE ---");

        ArrayList<Character> warriors =
                manager.findByType(CharacterType.WARRIOR);

        System.out.println("Jumlah WARRIOR: " + warriors.size());

        for (Character c : warriors) {
            System.out.println(c);
        }

        // 10. Mengganti nama karakter
        System.out.println("\n--- RENAME CHARACTER ---");

        manager.renameCharacter("Merlin", "Merlin Baru");

        System.out.println("Hasil rename: "
                + manager.findByName("Merlin Baru"));

        // 11. Eksperimen Object Reference
        System.out.println("\n--- OBJECT REFERENCE ---");

        Character asli = manager.findByName("Arjuna");

        if (asli != null) {

            Character referensi = asli;

            System.out.println("Level sebelum diubah: "
                    + asli.getLevel());

            referensi.setLevel(99);

            System.out.println("Level setelah diubah: "
                    + asli.getLevel());

            System.out.println("asli == referensi: "
                    + (asli == referensi));

            // Menggunakan copy constructor
            Character salinan = new Character(asli);

            salinan.setLevel(1);

            System.out.println("Level asli: "
                    + asli.getLevel());

            System.out.println("Level salinan: "
                    + salinan.getLevel());

            System.out.println("asli == salinan: "
                    + (asli == salinan));

            System.out.println("asli.equals(salinan): "
                    + asli.equals(salinan));
        }

        // 12. Eksperimen salinan ArrayList
        System.out.println("\n--- SALINAN ARRAYLIST ---");

        ArrayList<Character> salinanList =
                manager.getAllCharacters();

        salinanList.add(
                new Character("Hantu", CharacterType.MAGE, 1));

        System.out.println("Total manager asli: "
                + manager.getTotalCharacters());

        System.out.println("Total salinan list: "
                + salinanList.size());

        // 13. Menghitung total objek Character
        System.out.println("\n--- TOTAL OBJECT CREATED ---");

        System.out.println("Total objek Character dibuat: "
                + Character.getTotalCharacterCreated());

        // 14. Menampilkan GUI
        System.out.println("\n--- MEMBUKA GUI ---");

        SwingUtilities.invokeLater(() -> {

            try {

                MainWindow window =
                        new MainWindow(manager.getAllCharacters());

                window.setVisible(true);

            } catch (Exception e) {

                System.err.println("Gagal membuka GUI!");

                e.printStackTrace();
            }
        });
    }
}