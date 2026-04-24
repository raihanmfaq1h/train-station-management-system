import java.util.LinkedList;
import java.util.Queue;

public class BoardingQueue {

    private Queue<String> queue;

    // Constructor
    public BoardingQueue() {
        queue = new LinkedList<>();
    }

    // Tambah penumpang
    public void enqueue(String name) {
        queue.offer(name);
        System.out.println(name + " masuk ke antrian.");
    }

    // Proses boarding
    public void dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            String keluar = queue.poll();
            System.out.println(keluar + " sudah boarding.");
        }
    }

    // Lihat depan
    public void peek() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("Depan: " + queue.peek());
        }
    }

    // Tampilkan semua
    public void display() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("Isi antrian:");
            for (String p : queue) {
                System.out.println("- " + p);
            }
        }
    }
}