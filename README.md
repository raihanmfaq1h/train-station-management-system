# 🚉 Train Station Management System

---

## 📌 Tentang Aplikasi

**Train Station Management System** adalah sistem manajemen stasiun kereta api berbasis konsol yang dibangun menggunakan Java. Aplikasi ini mensimulasikan pengelolaan operasional stasiun kereta secara nyata, mulai dari manajemen jadwal kereta, antrean penumpang saat boarding, pencatatan log perjalanan, hingga pemetaan rute antar stasiun.

Sistem ini dirancang untuk mendemonstrasikan penerapan berbagai **struktur data dan algoritma** pada konteks dunia nyata, sehingga setiap modul tidak hanya berfungsi secara teknis, tetapi juga bermakna secara domain.

### 🎯 Kegunaan Aplikasi

| Fitur | Deskripsi |
|---|---|
| **Manajemen Jadwal Kereta** | Menyimpan, mencari, menghapus, dan menampilkan daftar jadwal kereta menggunakan Dynamic Array |
| **Antrean Boarding** | Mengatur urutan penumpang yang akan naik kereta secara FIFO menggunakan Queue berbasis linked nodes |
| **Log Perjalanan** | Mencatat riwayat kereta yang telah berangkat dan mendukung operasi undo (hapus log terakhir) menggunakan Stack |
| **Peta Rute Kereta** | Memetakan kereta ke rute tertentu dan mendukung pencarian berdasarkan rute menggunakan HashMap |


---

## 👥 Anggota Kelompok

| No | NIM | Nama | Role (UTS) | Role (UAS) |
|:---:|---|---|---|---|
| S1 | **251552010051** | Raihan Muhammad Faqih | Dynamic Array — `TrainSchedule.java` | Sorting — `TrainSorter.java` |
| S2 | **251572010029** | Cantik Rahmi Shofiyanti | Queue — `BoardingQueue.java` | Priority Queue — `PriorityBoardingQueue.java` |
| S3 | **251572010040** | Alya Syahla | Stack — `JourneyLogStack.java` | BST — `ScheduleBST.java` |
| S4 | **251552010019** | Fachrel Fayaaz Hibatullah | HashMap — `RouteTrainMap.java` | Graph — `StationGraph.java` |

---
## 📦 Struktur Modul
```
group4-trainstation/
├── shared/
│   ├── Train.java
│   ├── Passenger.java
│   └── Ticket.java
├── student1/
│   ├── TrainSchedule.java        ← Dynamic Array
│   └── TrainScheduleDemo.java
├── student2/
│   ├── BoardingQueue.java        ← Queue (Linked Nodes)
│   └── BoardingQueueDemo.java
├── student3/
│   ├── JourneyLogStack.java      ← Stack (Linked Nodes)
│   └── JourneyLogStackDemo.java
└── student4/
    ├── RouteTrainMap.java        ← HashMap (Array + Chaining)
    └── RouteTrainMapDemo.java
```

---
## 🧩 Penjelasan Modul Per Individu


### 👤 S1 — Raihan Muhammad Faqih (`student1/`)

#### 📦 `TrainSchedule.java` — Dynamic Array 
Modul ini mengimplementasikan struktur data **Dynamic Array** dari nol menggunakan plain Java array (`Object[]`) dengan mekanisme resize manual. Digunakan untuk menyimpan dan mengelola seluruh jadwal kereta yang beroperasi di stasiun.

### 👤 S2 — Cantik Rahmi Shofiyanti (`student2/`)

#### 📦 `BoardingQueue.java` — Queue (Linked Nodes)
Modul ini mengimplementasikan struktur data **Queue** (antrean) menggunakan custom inner class `Node` dengan single-linked list. Digunakan untuk mengatur urutan penumpang yang akan boarding ke kereta secara **First In, First Out (FIFO)** — penumpang yang datang lebih awal, boarding lebih awal.

### 👤 S3 — Alya Syahla (`student3/`)

#### 📦 `JourneyLogStack.java` — Stack (Linked Nodes) 
Modul ini mengimplementasikan struktur data **Stack** (tumpukan) menggunakan custom inner class `Node` dengan single-linked list. Digunakan untuk mencatat riwayat kereta yang telah berangkat dari stasiun, dengan prinsip **Last In, First Out (LIFO)** — log perjalanan terakhir dapat di-undo (dihapus) terlebih dahulu.

### 👤 S4 — Fachrel Fayaaz Hibatullah (`student4/`)

#### 📦 `RouteTrainMap.java` — HashMap (Array + Chaining)
Modul ini mengimplementasikan **HashMap** dari nol menggunakan array of buckets dengan teknik **separate chaining** (setiap bucket adalah linked list of entries) untuk menangani collision. Digunakan untuk memetakan kode rute (misal: `"JKT-SBY"`) ke daftar kereta yang melayani rute tersebut.

---

## 📹 Video Deliverables

Setiap anggota wajib membuat **YouTube Playlist** pribadi yang berisi:

| Video | Judul | Durasi | Isi |
|---|---|---|---|
| Video 1 | Problem Decomposition | 5–8 menit | Penjelasan domain masalah dan peran modul dalam sistem |
| Video 2 | Application Design | 5–10 menit | Class diagram, fields, constructor, methods |
| Video 3a, 3b, … | Live Coding | Bebas | Mengetik seluruh modul dari file kosong, narasi saat coding |
| Video 4 | Git Workflow | 5–8 menit | Branch, commit log, pull request, resolusi merge conflict |

> **Penting:** Video 3 (Live Coding) harus menampilkan setiap keystroke secara nyata. Copy-paste tidak diperbolehkan. Error dan debugging harus dibiarkan terlihat apa adanya.

---
<div align="center">

**STMIK Tazkia · Kelompok 4 · Data Structures & Algorithms**  
*Good luck — and good commits!* 🚀

</div>

