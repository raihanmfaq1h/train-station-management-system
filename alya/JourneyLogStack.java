class JourneyLogStack {

    // Node class(linked list)
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }  

    private Node top;
    private int size;

    // Constructor
    public JourneyLogStack() {
        top = null;
        size = 0;
    }

    // PUSH tambah data
    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;

        System.out.println("Data ditambahkan: " + data);
    }

    // POP hapus data teratas
    public void pop () {
        if (isEmpty()) {
            System.out.println("Eror: Riwayat kosong");
            return;
        }

        System.out.println("Hapus riwayat: " + top.data);
        top = top.next;
        size--;
    }

    // PEEK lihat data teratas
    public String peek() {
        if (isEmpty()) {
            return "kosong";
        }
        return top.data;
    }

    // CEK KOSONG
    public boolean isEmpty() {
        return top == null;
    }

    // SIZE
    public int size() {
        return size;
    }

    // DISPLAY
    public void displayHistory() {
        if (isEmpty()) {
            System.out.println("Riwayat kosong.");
            return;
        }

        System.out.println("\n=== Riwayat Transaksi (Terbaru di Atas) ===");

        Node current = top;
        int nomor = size;
        while (current != null) {
            System.out.println(nomor + "." + current.data);
            current = current.next;
            nomor--;
        }
    }
}