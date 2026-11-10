package com.unpri.charactermanager.model;

import java.util.Objects;

/**
 * Merepresentasikan satu karakter dalam aplikasi Character Manager.
 * Menerapkan prinsip Encapsulation dengan atribut private.
 */
public class Character {

    // ===== ATRIBUT STATIC (milik CLASS, dipakai bersama semua object) =====
    private static int totalCharacterCreated = 0;

    // ===== ATRIBUT INSTANCE =====
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // ===== CONSTRUCTOR 1: MEMBUAT KARAKTER BARU =====
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        setLevel(level);                    // sekaligus menghitung HP & attack
        totalCharacterCreated++;
    }

    // ===== CONSTRUCTOR 2: MEMUAT KARAKTER DARI DATABASE =====
    public Character(int id, String name, CharacterType type,
                     int level, int hitPoints, int attackPower) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        totalCharacterCreated++;
    }

    // ===== CONSTRUCTOR 3: COPY CONSTRUCTOR (object baru, data disalin) =====
    public Character(Character other) {
        this.id = other.id;
        this.name = other.name;
        this.type = other.type;
        this.level = other.level;
        this.hitPoints = other.hitPoints;
        this.attackPower = other.attackPower;
        this.mana = other.mana;
        totalCharacterCreated++;
    }

    // ===== HELPER METHOD =====
    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    // ===== GETTER =====
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // ===== SETTER =====
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1");
        }

        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif");
        }
        this.mana = mana;
    }

    // ===== METHOD BARU =====
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // ===== TOSTRING =====
    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hp=" + hitPoints +
                ", atk=" + attackPower +
                ", mana=" + mana +
                '}';
    }

    // ===== EQUALS (membandingkan ISI nama, bukan alamat memori) =====
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Character)) return false;

        Character other = (Character) obj;
        return Objects.equals(this.name, other.name);
    }

    // ===== HASHCODE (wajib dibuat bersama equals) =====
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}