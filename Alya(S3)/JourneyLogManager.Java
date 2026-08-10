import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Class yang merepresentasikan Objek Perjalanan (Journey)
 */
class Journey {
    private String id;
    private String stasiunAsal;
    private String stasiunTujuan;
    private double jarakKm;
    private int durasiMenit;

    public Journey(String id, String stasiunAsal, String stasiunTujuan, double jarakKm, int durasiMenit) {
        this.id = id;
        this.stasiunAsal = stasiunAsal;
        this.stasiunTujuan = stasiunTujuan;
        this.jarakKm = jarakKm;
        this.durasiMenit = durasiMenit;
    }

    public String getId() {
        return id;
    }

    public String getStasiunAsal() {
        return stasiunAsal;
    }

    public String getStasiunTujuan() {
        return stasiunTujuan;
    }

    public double getJarakKm() {
        return jarakKm;
    }

    public int getDurasiMenit() {
        return durasiMenit;
    }

    @Override
    public String toString() {
        return String.format("ID: %-8s | Asal: %-12s | Tujuan: %-12s | Jarak: %6.1f km | Durasi: %4d menit",
                id, stasiunAsal, stasiunTujuan, jarakKm, durasiMenit);
    }
}

/**
 * Main Class: JourneyLogManagerJava
 * Mengelola interaksi CLI, pencatatan data, pencarian HashMap O(1), dan rekapitulasi statistik.
 */
public class JourneyLogManagerJava {

    // Struktur Data: ArrayList untuk menyimpan list, HashMap untuk pencarian cepat O(1)
    private static List<Journey> journeyLogs = new ArrayList<>();
    private static Map<String, Journey> journeyIndex = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=================================================");
        System.out.println("   WELCOME TO JOURNEY LOG MANAGER JAVA (Aplikasi)");
        System.out.println("=================================================");

        // Loop Utama Program (Sesuai Flowchart: While Running)
        while (running) {
            tampilkanMenu();
            System.out.print("Pilih menu (1-5): ");
            
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input tidak valid! Harap masukkan angka 1-5.\n");
                continue;
            }

            // Percabangan Decision Node (Switch-Case)
            switch (pilihan) {
                case 1:
                    tambahJourney(scanner);
                    break;
                case 2:
                    cariJourneyById(scanner);
                    break;
                case 3:
                    tampilkanDanSortByDurasi();
                    break;
                case 4:
                    tampilkanRekapStatistik();
                    break;
                case 5:
                    running = false;
                    System.out.println("\n[INFO] Terima kasih telah menggunakan JourneyLogManagerJava. Program Selesai!");
                    break;
                default:
                    System.out.println("[ERROR] Pilihan menu tidak tersedia. Masukkan angka 1-5.\n");
            }
        }

        scanner.close();
    }

    /**
     * Menampilkan Tampilan Menu Utama
     */
    private static void tampilkanMenu() {
        System.out.println("\n---------------- MAIN MENU ----------------");
        System.out.println("1. Tambah Data Log Perjalanan (Journey)");
        System.out.println("2. Cari Perjalanan Berdasarkan ID");
        System.out.println("3. Tampilkan Semua Log (Urut Berdasarkan Durasi)");
        System.out.println("4. Lihat Rekapitulasi Statistik");
        System.out.println("5. Keluar Program");
        System.out.println("-------------------------------------------");
    }     * Menu 1: Tambah Journey Baru (Flowchart Process: Input & Store)


    /**
     */
    private static void tambahJourney(Scanner scanner) {
        System.out.println("\n>>> MENU 1: TAMBAH LOG PERJALANAN <<<");
        
        System.out.print("Masukkan ID Perjalanan (contoh: J-101): ");
        String id = scanner.nextLine().trim();

        if (journeyIndex.containsKey(id)) {
            System.out.println("[ERROR] ID '" + id + "' sudah terdaftar! Gunakan ID lain.");
            return;
        }

        System.out.print("Masukkan Stasiun Asal   : ");
        String asal = scanner.nextLine().trim();

        System.out.print("Masukkan Stasiun Tujuan : ");
        String tujuan = scanner.nextLine().trim();

        double jarak = 0;
        int durasi = 0;

        try {
            System.out.print("Masukkan Jarak (km)     : ");
            jarak = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Masukkan Durasi (menit) : ");
            durasi = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Input jarak/durasi harus berupa angka yang valid! Transaksi dibatalkan.");
            return;
        }

        // Pembuatan Objek & Penyiapan di Memori
        Journey journey = new Journey(id, asal, tujuan, jarak, durasi);
        journeyLogs.add(journey);
        journeyIndex.put(id, journey);

        System.out.println("[SUCCESS] Log Perjalanan " + id + " berhasil disimpan!");
    }

    /**
     * Menu 2: Cari Journey By ID menggunakan HashMap - O(1)
     */
    private static void cariJourneyById(Scanner scanner) {
        System.out.println("\n>>> MENU 2: CARI LOG BY ID <<<");
        System.out.print("Masukkan ID Perjalanan yang dicari: ");
        String id = scanner.nextLine().trim();

        // Pencarian Cepat O(1)
        Journey journey = journeyIndex.get(id);

        if (journey != null) {
            System.out.println("[FOUND] Data Perjalanan Ditemukan:");
            System.out.println(journey);
        } else {
            System.out.println("[NOT FOUND] Data perjalanan dengan ID '" + id + "' tidak ditemukan.");
        }
    }

    /**
     * Menu 3: Tampilkan dan Sort Log berdasarkan Durasi Terpendek ke Terpanjang
     */
    private static void tampilkanDanSortByDurasi() {
        System.out.println("\n>>> MENU 3: DAFTAR LOG PERJALANAN (SORT BY DURASI) <<<");

        if (journeyLogs.isEmpty()) {
            System.out.println("[INFO] Belum ada data perjalanan yang tersimpan.");
            return;
        }

        // Copy list agar data asli tidak teracak
        List<Journey> sortedList = new ArrayList<>(journeyLogs);
        
        // Sorting berdasarkan durasi (Ascending)
        sortedList.sort((j1, j2) -> Integer.compare(j1.getDurasiMenit(), j2.getDurasiMenit()));

        System.out.println("--------------------------------------------------------------------------------------");
        for (Journey j : sortedList) {
            System.out.println(j);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    /**
     * Menu 4: Rekapitulasi Statistik
     */
    private static void tampilkanRekapStatistik() {
        System.out.println("\n>>> MENU 4: REKAPITULASI STATISTIK <<<");

        if (journeyLogs.isEmpty()) {
            System.out.println("[INFO] Belum ada data untuk dihitung.");
            return;
        }

        double totalJarak = 0;
        int totalDurasi = 0;

        for (Journey j : journeyLogs) {
            totalJarak += j.getJarakKm();
            totalDurasi += j.getDurasiMenit();
        }

        double rataJarak = totalJarak / journeyLogs.size();
        double rataDurasi = (double) totalDurasi / journeyLogs.size();

        System.out.println("-------------------------------------------");
        System.out.printf(" Total Log Perjalanan : %d log\n", journeyLogs.size());
        System.out.printf(" Total Jarak Tempuh   : %.2f km\n", totalJarak);
        System.out.printf(" Rata-rata Jarak      : %.2f km\n", rataJarak);
        System.out.printf(" Total Durasi Perjalanan: %d menit (%.1f jam)\n", totalDurasi, totalDurasi / 60.0);
        System.out.printf(" Rata-rata Durasi     : %.2f menit\n", rataDurasi);
        System.out.println("-------------------------------------------");
    }
}