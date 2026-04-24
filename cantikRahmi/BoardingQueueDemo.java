package cantikRahmi;
import shared.Passenger;

public class BoardingQueueDemo {
    public static void main(String[] args) {
        BoardingQueue queue = new BoardingQueue();

        queue.enqueue(new Passenger("PX01", "Rina Kartika", "Eksekutif"));
        queue.enqueue(new Passenger("PX02", "Dodi Prasetyo", "Bisnis"));
        queue.enqueue(new Passenger("PX03", "Susi Susilawati", "Ekonomi"));

        // Tampilkan antrian
        queue.displayQueue();

        // lihat yang depan
        System.out.println("Berikutnya: " + queue.peek().getName());

        // proses boarding
        queue.dequeue();
        queue.dequeue();

        queue.displayQueue();

        queue.dequeue();
        queue.dequeue(); // harus muncul error
    }
}