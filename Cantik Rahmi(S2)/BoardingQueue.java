public class BoardingQueue {

    // Node class (linked list)
    private class Node {
        Passenger data;
        Node next;

        Node(Passenger data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public BoardingQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // enqueue (tambah ke belakang)
    public void enqueue(Passenger p) {
        Node newNode = new Node(p);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // dequeue (ambil dari depan)
    public Passenger dequeue() {
        if (isEmpty()) {
            System.out.println("Error: Antrian boarding sudah kosong.");
            return null;
        }

        Passenger removed = front.data;
        System.out.println("Boarding: " + removed.getName());

        front = front.next; // pindah ke node berikutnya
        size--;

        if (front == null) {
            rear = null;
        }

        return removed;
    }

    // lihat depan
    public Passenger peek() {
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }

    // cek kosong
    public boolean isEmpty() {
        return front == null;
    }

    // size
    public int size() {
        return size;
    }

    // tampilkan queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("=== Antrian Boarding kosong ===");
            return;
        }

        System.out.println("=== Antrian Boarding (" + size + " penumpang) ===");

        Node current = front;
        int i = 1;

        while (current != null) {
            Passenger p = current.data;
            System.out.println(i + ". [" + p.getId() + "] "
                    + p.getName() + " - " + p.getTicketClass());
            current = current.next;
            i++;
        }
    }
}