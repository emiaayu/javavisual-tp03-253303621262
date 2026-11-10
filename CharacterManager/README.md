https://docs.google.com/document/d/16PCkPcTxSfOxBlYaVo9suxzY1EHc4cbCJoV754ADM9U/edit?usp=sharing
# Character Manager — TP3 (Java Visual SIH-6406)

Character Manager adalah aplikasi Java berbasis console yang menjadi fondasi
model class untuk GUI di sprint berikutnya. Aplikasi ini memodelkan karakter
game (Warrior, Mage, Archer, Healer) lengkap dengan level, HP, attack, dan mana.
Perhitungan stat otomatis dan validasi data dijaga di dalam class dengan
prinsip Encapsulation.

## Screenshot Output

![Output terminal](screenshot.png)

## Struktur Folder

```
CharacterManager/
├── README.md
├── screenshot.png
└── src/
    ├── Main.java
    └── com/
        └── unpri/
            └── charactermanager/
                └── model/
                    ├── Character.java
                    └── CharacterType.java
```

## Identitas

- Nama: Emia Ayu C Girsang
- NIM: 253303621262
- Analisis Desain (Bagian D): https://docs.google.com/document/d/16PCkPcTxSfOxBlYaVo9suxzY1EHc4cbCJoV754ADM9U/edit?usp=sharing



## TP5 — Reference, Encapsulation, dan Analitik Character Manager

### Fitur Baru
- `getAverageLevel()` — rata-rata level, mengembalikan 0 jika list kosong
- `findByType(CharacterType)` — semua karakter dengan tipe tertentu
- `renameCharacter(old, new)` — ganti nama dengan validasi (Bagian C)
- Copy constructor `Character(Character other)` — membuat salinan independen

### Cara Menjalankan
Jalankan `Main.java`. Program menguji CRUD, penolakan duplikat,
ketiga method baru, dan eksperimen reference.

### Screenshot Output
![Output CRUD](screenshots/crud.png)
![Eksperimen Reference](screenshots/reference.png)

### Fitur Bagian C: renameCharacter()
**Apa yang dilakukan:** mengganti nama karakter dan menolak jika
nama baru kosong, karakter lama tidak ada, atau nama baru sudah
dipakai karakter lain.

**Rasional desain:** [tulis dengan kata-katamu sendiri]

### Analisis Bagian D
[https://docs.google.com/document/d/1WEv2pWnXOIAnm9wilN2QZBbQpcX0yIRj8k7Zv037cLw/edit?usp=sharing]