import java.util.LinkedList;
import java.util.Queue;

public class BoardingQueue {
    private Queue<String> queue;

    // Constructor
    public BoardingQueue() {
        queue = new LinkedList<>();
    }

    // Tambah penumpang ke antrian
    public void enqueue(String passengerName) {
        queue.add(passengerName);
        System.out.println(passengerName + " masuk ke antrian boarding.");
    }

    // Proses boarding (Keluar dari antrian)
    public void dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong tidak ada penumpang");
        } else {
            String passennger = queue.poll();
            System.out.println(passennger + " sudah boarding.");
        }
    }

    // Lihat  penumpang paling depan
    public void peek() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Penumpang paling depan:" + queue.peek());
        }
    }

    // Tampilkan semua antrian
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong");
        } else {
            System.out.println("Daftar antrian boarding:");
            for (String passenger : queue) {
                System.out.println("- " + passenger);
            }
        }
    }



           // Cek kosong atau tidak
            public boolean isEmpty() {
                return queue.isEmpty();
                }
            }