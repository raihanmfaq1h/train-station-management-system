import java.util.Scanner;

public class BoardingQueueDemo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BoardingQueue queue = new BoardingQueue();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah");
            System.out.println("2. Boarding");
            System.out.println("3. Lihat Depan");
            System.out.println("4. Tampilkan");
            System.out.println("0. Keluar");
            System.out.println("Pilih: ");

            int pilih = input.nextInt();
            input.nextLine(); // WAJIB baie gak error

            if (pilih ==1) {
                System.out.print("Nama:hami");
                String nama = input.nextLine();
                queue.enqueue(nama);

            } else if (pilih ==2) {
                queue.dequeue();

            } else if (pilih ==3) {
                queue.peek();

            } else if (pilih ==4) {
                queue.display();

            } else if (pilih ==0) {
                System.out.println("Keluar program");
                break;

            } else {
                System.out.println("Pilihan salah!");
            }
        }

        input.close();
    }
}