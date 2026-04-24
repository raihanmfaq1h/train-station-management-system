import java.util.LinkedList;
import java.util.Queue;

public class BoardingQueue {
    private Queue<String> queue = new LinkedList<>();

    // Tambah penumpang
    public void enqueueI(String name) {
        queue.add(name);
        System.out.println(name + " masuk ke antrian.");
    }

    // Proses boarding
    public void dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("Depan: " + queue.peek());
        }
    }

    // Lihat depan
    public void peek() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong");
        } else {
            System.out.println("Depan:" + queue.peek());
        }
    }

    // Tampilkan semua
    public void display() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("Isi antrian;");
            for (String p : queue) {
                System.out.println("- " + p);
            }
        }
    }
}