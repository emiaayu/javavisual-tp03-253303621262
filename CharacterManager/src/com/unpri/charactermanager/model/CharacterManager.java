package com.unpri.charactermanager.model;

import java.util.ArrayList;

/**
 * Mengelola koleksi Character: tambah, cari, hapus, dan statistik dasar.
 * Menerapkan Composition: CharacterManager "has-a" ArrayList<Character>.
 */
public class CharacterManager {

    private ArrayList<Character> characterList;

    public CharacterManager() {
        this.characterList = new ArrayList<>();   // list kosong saat manager pertama dibuat
    }

    /**
     * Menambahkan karakter baru ke dalam list.
     * Menolak jika sudah ada karakter dengan nama yang sama.
     * @return true jika berhasil ditambahkan, false jika ditolak karena duplikat
     */
    public boolean addCharacter(Character character) {
        if (findByName(character.getName()) != null) {
            System.out.println("❌ Gagal: karakter dengan nama '" + character.getName() + "' sudah ada!");
            return false;
        }
        characterList.add(character);
        System.out.println("✅ Karakter '" + character.getName() + "' berhasil ditambahkan.");
        return true;
    }

    /**
     * Mencari karakter berdasarkan nama.
     * @return objek Character jika ditemukan, null jika tidak ada
     */
    public Character findByName(String name) {
        for (Character c : characterList) {
            if (c.getName().equals(name)) {         // bandingkan ISI nama, bukan ==
                return c;
            }
        }
        return null;
    }

    /**
     * Menghapus karakter dari list berdasarkan nama.
     * @return true jika berhasil dihapus, false jika tidak ditemukan
     */
    public boolean removeCharacter(String name) {
        Character target = findByName(name);
        if (target == null) {
            System.out.println("❌ Gagal hapus: karakter '" + name + "' tidak ditemukan.");
            return false;
        }
        characterList.remove(target);
        System.out.println("🗑️ Karakter '" + name + "' berhasil dihapus.");
        return true;
    }

    public int getTotalCharacters() {
        return characterList.size();
    }

    /**
     * Mengembalikan SALINAN list, bukan referensi asli,
     * agar pemanggil tidak bisa mengubah data internal manager secara langsung.
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);      // defensive copy
    }

    // ===== BAGIAN B: MINI-CHALLENGE =====

    /**
     * Menghitung rata-rata level seluruh karakter.
     * @return rata-rata level, atau 0 jika list kosong (menghindari pembagian nol)
     */
    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (Character c : characterList) {
            sum += c.getLevel();
        }
        return (double) sum / characterList.size();   // cast agar bukan pembagian integer
    }

    /**
     * Mencari semua karakter dengan tipe tertentu.
     * @return ArrayList baru berisi karakter bertipe tersebut (kosong jika tidak ada)
     */
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> hasil = new ArrayList<>();
        for (Character c : characterList) {
            if (c.getType() == type) {                // enum dibandingkan dengan ==
                hasil.add(c);
            }
        }
        return hasil;
    }

    // ===== BAGIAN C: FITUR RANCANGAN SENDIRI =====

    /**
     * Mengganti nama karakter dengan validasi bentrok nama.
     * Ditolak jika nama baru kosong, karakter lama tidak ada,
     * atau nama baru sudah dipakai karakter lain.
     * Perubahan nama dilakukan lewat manager agar aturan "nama unik"
     * tetap terjaga tanpa mengekspos ArrayList internal.
     *
     * @return true jika berhasil diganti, false jika ditolak
     */
    public boolean renameCharacter(String oldName, String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            System.out.println("❌ Gagal rename: nama baru tidak boleh kosong.");
            return false;
        }

        Character target = findByName(oldName);
        if (target == null) {
            System.out.println("❌ Gagal rename: karakter '" + oldName + "' tidak ditemukan.");
            return false;
        }

        Character bentrok = findByName(newName);
        if (bentrok != null && bentrok != target) {   // objek BERBEDA yang memakai nama itu
            System.out.println("❌ Gagal rename: nama '" + newName + "' sudah dipakai karakter lain.");
            return false;
        }

        target.setName(newName);
        System.out.println("✏️ '" + oldName + "' berhasil diganti menjadi '" + newName + "'.");
        return true;
    }
}