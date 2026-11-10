import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.3 — CRUD & Analitik Test ===\n");

        CharacterManager manager = new CharacterManager();

        // 1. Tambah karakter
        manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
        manager.addCharacter(new Character("Athena", CharacterType.ARCHER, 4));

        // 2. Duplikat harus ditolak
        System.out.println();
        manager.addCharacter(new Character("Arjuna", CharacterType.HEALER, 1));

        // 3. Total
        System.out.println("\nTotal karakter saat ini: " + manager.getTotalCharacters());

        // 4. Pencarian
        System.out.println("\n--- Pencarian ---");
        Character hasil = manager.findByName("Merlin");
        System.out.println(hasil != null ? "Ditemukan: " + hasil : "Tidak ditemukan");

        Character tidakAda = manager.findByName("Zeus");
        System.out.println(tidakAda != null ? "Ditemukan: " + tidakAda : "Zeus tidak ditemukan (sesuai harapan)");

        // 5. Penghapusan
        System.out.println("\n--- Penghapusan ---");
        manager.removeCharacter("Athena");
        System.out.println("Total setelah hapus: " + manager.getTotalCharacters());

        // 6. Daftar tersisa
        System.out.println("\n--- Daftar Karakter Tersisa ---");
        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        // ===== BAGIAN B: MINI-CHALLENGE =====
        System.out.println("\n--- Uji getAverageLevel() ---");
        System.out.println("Rata-rata level (Arjuna 5, Merlin 3): " + manager.getAverageLevel());
        System.out.println("Rata-rata level manager KOSONG      : " + new CharacterManager().getAverageLevel());

        System.out.println("\n--- Uji findByType() ---");
        ArrayList<Character> warriors = manager.findByType(CharacterType.WARRIOR);
        System.out.println("Jumlah WARRIOR: " + warriors.size());
        for (Character c : warriors) {
            System.out.println("  " + c);
        }
        System.out.println("Jumlah ARCHER (sudah dihapus): " + manager.findByType(CharacterType.ARCHER).size());

        // ===== BAGIAN C: renameCharacter =====
        System.out.println("\n--- Uji renameCharacter() ---");
        manager.renameCharacter("Merlin", "Arjuna");      // bentrok -> ditolak
        manager.renameCharacter("Zeus", "Poseidon");      // tidak ada -> ditolak
        manager.renameCharacter("Merlin", "   ");         // kosong -> ditolak
        manager.renameCharacter("Merlin", "Morgana");     // valid -> berhasil
        System.out.println("Cari 'Merlin' : " + manager.findByName("Merlin"));
        System.out.println("Cari 'Morgana': " + manager.findByName("Morgana"));

        // ===== EKSPERIMEN: Object Reference =====
        System.out.println("\n--- Eksperimen Reference ---");

        Character asli = manager.findByName("Arjuna");
        Character duplikatReferensi = asli;             // menyalin REFERENSI, bukan object

        System.out.println("Level Arjuna sebelum: " + asli.getLevel());
        duplikatReferensi.setLevel(99);
        System.out.println("Level Arjuna sesudah (lewat 'asli'): " + asli.getLevel());
        System.out.println("asli == duplikatReferensi? " + (asli == duplikatReferensi));

        // Salinan independen lewat copy constructor
        Character salinanIndependen = new Character(asli);
        salinanIndependen.setLevel(1);
        System.out.println("Level asli setelah salinan diubah: " + asli.getLevel());
        System.out.println("asli == salinanIndependen? " + (asli == salinanIndependen));
        System.out.println("asli.equals(salinanIndependen)? " + asli.equals(salinanIndependen));

        // Salinan LIST
        ArrayList<Character> salinanList = manager.getAllCharacters();
        salinanList.add(new Character("Hantu", CharacterType.MAGE, 1));

        System.out.println("Total di manager asli: " + manager.getTotalCharacters());
        System.out.println("Total di salinan list : " + salinanList.size());
    }
}