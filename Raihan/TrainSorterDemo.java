package Raihan;

import shared.Train;

public class TrainSorterDemo {
    public static void main(String[] args) {

        System.out.println("== Demo TrainSorter - Quick Sort & Radix Sort ===\n");

        Train[] trains = new Train [4];
        trains[0] = new Train("T001", "Argo Bromo", "Jakarta", "Surabaya", "07:00");
        trains[0].setPrice(350000);

        trains[1] = new Train("T002", "Gajayana", "Jakarta", "Malang", "08:30");
        trains[1].setPrice(280000);

        trains[2] = new Train("T003", "Taksaka", "Yogyarta", "Jakarta", "06:00");
        trains[2].setPrice(195000);

        trains[3] = new Train("T004", "Sembrani", "Jakarta", "Surabaya", "20:00");
        trains[3].setPrice(420000);
        
        TrainSorter sorter = new TrainSorter(trains);

        System.out.println();

        sorter.sortByDeparture();
        sorter.printList("Urut keberangkatan - Quick Sort");

        System.out.println();

        sorter.sortByPrice();
        sorter.printList("Urut Harga - Radix Sort (murah ke mahal");
    }
}