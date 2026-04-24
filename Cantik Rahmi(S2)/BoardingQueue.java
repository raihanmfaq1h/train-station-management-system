package S2;

import shared.Train;

public class BoardingQueue {

    // Node class (Linked List)
    class Node {
        Train data;
        Node next;

        Node(Train data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    // Constructor
    public BoardingQueue() {
        front = rear = null;
        size = 0;
    }

    // Enqueue (tambah ke antrian)
    public void enqueue(Train train) {
        Node newNode = new Node(train);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
        System.out.println("Boarding ditambahkan: " +
                train.getId() + " (" +
                train.getOrigin() + " → " +
                train.getDestination() + ")");
    }

    // Dequeue (proses boarding)
    public Train dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian boarding kosong!");
            return null;
        }

        Train removed = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;
        System.out.println("Boarding diproses: " + removed.getId());
        return removed;
    }

    // Peek (lihat depan tanpa hapus)
    public Train peek() {
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }

    // Cek kosong
    public boolean isEmpty() {
        return front == null;
    }

    // Jumlah data
    public int size() {
        return size;
    }

    // Tampilkan antrian
    public void displayBoardingQueue() {
        if (isEmpty()) {
            System.out.println("Antrian boarding kosong!");
            return;
        }

        Node current = front;
        int i = 1;

        System.out.println("=== Antrian Boarding ===");
        while (current != null) {
            System.out.println(i + ". " +
                    current.data.getId() + " | " +
                    current.data.getOrigin() + " → " +
                    current.data.getDestination());
            current = current.next;
            i++;
        }
    }
}