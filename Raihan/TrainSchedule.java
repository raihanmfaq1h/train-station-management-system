package Raihan;
import shared.Train;


public class TrainSchedule {

    private Train[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 2;

    public TrainSchedule() {
        data = new Train[INITIAL_CAPACITY];
        size = 0;
    }

    private void resize() {
        int newCapacity = data.length * 2;

        System.out.println("[INFO] Array penuh (kapasitas " + data.length + "). " + "Resize ke kapasitas " + newCapacity + "...");
        Train[] newData = new Train[newCapacity];
        
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    public void addTrain(Train t) {
        if(size == data.length) {
            resize();
        }
        data[size] = t;

        size++;
        System.out.println("kereta " + t.getId() + " berhasil ditambahkan.");   
    }
    public void removeTrain(String id) {
        for (int i = 0; i < size; i++) {
            if (data[i].getId().equals(id)) {
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }
                data[size - 1] = null;
                size--;
                System.out.println("kereta " + id + " berhasil dihapus dari jadwal.");
                return;
            }
        }
        System.out.println("Error: kereta dengan ID  " + id + " tidak ditemukan.");
    }
    public void findById(String id) {
        for (int i = 0; i < size; i++) {
            if (data[i].getId().equals(id)) {
                System.out.println("Ditemukan: " + data[i]);
                return;
            }
        } 

        System.out.println("Tidak ditemukan kereta demgam ID: " + id);
    }
    public void findByRoute(String origin, String destination) {
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (data[i].getOrigin().equals(origin) && data[i].getDestination().equals(destination)) {
                System.out.println("Ditemukan: " + data[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ada kereta dengan rute " + origin + " -> " + destination);
        }
    }

    public void listAll() {
        if (isEmpty()) {
            System.out.println("jadwal kosong, belum ada kereta terdaftar.");
        }

        System.out.println("=== jadwal kereta (" + size + "kereta ) ===");

        for (int i = 0; i < size ; i++) {

            System.out.println((i + 1) + ". " + data[i]);
        }
    }

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        TrainSchedule schedule = new TrainSchedule();

        System.out.println("=== DeMO TrainSchedule - Dynamic Array ===\n");

        schedule.addTrain(new Train("T001", "Argo Bromo", "Jakarta", "Surabaya", "07:00"));
        schedule.addTrain(new Train("T002", "Gajayana", "jakarta", "Malang", "08:30"));
        schedule.addTrain(new Train("T003", "Takasaka", "Yogyakarta", "jakarta", "06:00"));

        System.out.println();

        System.out.println("Total kereta terdaftar " + schedule.size());

        System.out.println();

        schedule.findById("T002");
        schedule.findById("T099");

        System.out.println();

        schedule.findByRoute("Jakarta", "Surabaya");
        schedule.findByRoute("Bandung", "Surabaya");

        System.out.println();

        schedule.removeTrain("T003");
        schedule.removeTrain("T099");

        System.out.println();

        schedule.listAll();

        System.out.println();

        System.out.println("Jadwal kosong? " + schedule.isEmpty());
    }
}
