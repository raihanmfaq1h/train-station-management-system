public class BoardingQueueDemo {
    public static void main(String[] args) {

        BoardingQueue queue = new BoardingQueue();

        queue.enqueue(new Passenger("PX01", "Rina Kartika", "Eksekutif"));
        queue.enqueue(new Passenger("PX02","Dodi Prasetyo", "Bisnis"));
        queue.enqueue(new Passenger("PX03","susi susilawati", "Ekonomi"));

    }
    queue.displayQueue();

    System.out.printIn(Berikutnya: " + queue.peek().getName());

    queue.dequeue();
    queue.dequeue();

    queue.displayQueue();

    queue.dequeue();
    queue.dequeue(); // harus error
}
    
}