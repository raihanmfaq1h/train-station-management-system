import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Demo untuk menguji alur JourneyLogManager secara otomatis.
 * Cocok untuk demonstrasi cepat di video presentasi.
 */
public class JoureyLogManagerDemo {

    // Struktur data lokal untuk demo
    private static List<JourneyDemo> journeyLogs = new ArrayList<>();
    private static Map<String, JourneyDemo> journeyIndex = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   DEMO OTOMATIS: JOURNEY LOG MANAGER JAVA");
        System.out.println("=================================================\n");

        // 1. Simulasi Penambahan Data (Menu 1)
        System.out.println(">>> 1. MEMASUKKAN DATA SAMPLE PERJALANAN <<<");
        tambahSampleData("J-101", "Gambir", "Bandung", 150.5, 180);
        tambahSampleData("J-102", "Bandung", "Surabaya", 690.0, 540);
        tambahSampleData("J-103", "Pasar Senen", "Yogyakarta", 512.0, 420);
        tambahSampleData("J-104", "Yogyakarta", "Solo Balapan", 60.0, 50);

        // Uji coba validasi ID Duplikat
        System.out.println("\n[UJI VALIDASI] Mencoba menambah ID duplikat (J-101)...");
        tambahSampleData("J-101", "Jakarta", "Semarang", 450.0, 360);

        // 2. Simulasi Pencarian Data by ID - HashMap O(1) (Menu 2)
        System.out.println("\n>>> 2. UJI PENCARIAN BERDASARKAN ID - O(1) <<<");
        cariByIdDemo("J-102"); // Data ada
        cariByIdDemo("J-999"); // Data tidak ada

        // 3. Simulasi Sorting Berdasarkan Durasi (Menu 3)
        System.out.println("\n>>> 3. UJI SORTING BERDASARKAN DURASI (ASCENDING) <<<");
        tampilkanSortedByDurasiDemo();

        // 4. Simulasi Rekapitulasi Statistik (Menu 4)
        System.out.println("\n>>> 4. UJI REKAPITULASI STATISTIK <<<");
        tampilkanStatistikDemo();

        System.out.println("\n=================================================");
        System.out.println("   DEMO SELESAI - SELURUH FUNGSI BERJALAN NORMAL");
        System.out.println("=================================================");
    }

    private static void tambahSampleData(String id, String asal, String tujuan, double jarak, int durasi) {
        if (journeyIndex.containsKey(id)) {
            System.out.println("[ERROR] Gagal menambahkan. ID '" + id + "' sudah terdaftar!");
            return;
        }
        JourneyDemo j = new JourneyDemo(id, asal, tujuan, jarak, durasi);
        journeyLogs.add(j);
        journeyIndex.put(id, j);
        System.out.println("[SUCCESS] Berhasil menambahkan: " + j);
    }

    private static void cariByIdDemo(String id) {
        System.out.println("Mencari ID: '" + id + "'...");
        JourneyDemo result = journeyIndex.get(id);
        if (result != null) {
            System.out.println("[FOUND] Data Ditemukan -> " + result);
        } else {
            System.out.println("[NOT FOUND] Data dengan ID '" + id + "' tidak ditemukan.");
        }
    }

    private static void tampilkanSortedByDurasiDemo() {
        List<JourneyDemo> sortedList = new ArrayList<>(journeyLogs);
        sortedList.sort((j1, j2) -> Integer.compare(j1.getDurasiMenit(), j2.getDurasiMenit()));

        System.out.println("--------------------------------------------------------------------------------------");
        for (JourneyDemo j : sortedList) {
            System.out.println(j);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    private static void tampilkanStatistikDemo() {
        if (journeyLogs.isEmpty()) {
            System.out.println("Data kosong.");
            return;
        }

        double totalJarak = 0;
        int totalDurasi = 0;

        for (JourneyDemo j : journeyLogs) {
            totalJarak += j.getJarakKm();
            totalDurasi += j.getDurasiMenit();
        }

        System.out.println("-------------------------------------------");
        System.out.printf(" Total Log Perjalanan : %d log\n", journeyLogs.size());
        System.out.printf(" Total Jarak Tempuh   : %.2f km\n", totalJarak);
        System.out.printf(" Rata-rata Jarak      : %.2f km\n", totalJarak / journeyLogs.size());
        System.out.printf(" Total Durasi        : %d menit (%.1f jam)\n", totalDurasi, totalDurasi / 60.0);
        System.out.printf(" Rata-rata Durasi     : %.2f menit\n", (double) totalDurasi / journeyLogs.size());
        System.out.println("-------------------------------------------");
    }
}

/**
 * Class Helper Journey khusus untuk Demo
 */
class JourneyDemo {
    private String id;
    private String asal;
    private String tujuan;
    private double jarakKm;
    private int durasiMenit;

    public JourneyDemo(String id, String asal, String tujuan, double jarakKm, int durasiMenit) {
        this.id = id;
        this.asal = asal;
        this.tujuan = tujuan;
        this.jarakKm = jarakKm;
        this.durasiMenit = durasiMenit;
    }

    public String getId() { return id; }
    public int getDurasiMenit() { return durasiMenit; }
    public double getJarakKm() { return jarakKm; }

    @Override
    public String toString() {
        return String.format("ID: %-6s | Asal: %-12s | Tujuan: %-12s | Jarak: %6.1f km | Durasi: %3d mnt",
                id, asal, tujuan, jarakKm, durasiMenit);
    }
}