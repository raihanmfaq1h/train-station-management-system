package Raihan;

import shared.Train;

public class TrainSorter {
    private Train[] trains;

    public TrainSorter(Train[] trains) {
        this.trains = trains;
    }

    public void sortByDeparture() {
        if (trains.length == 0) {
            System.out.println("ERROR: tidak ada kereta untuk diurutkan");
            return;
        }
        quickSort(0, trains.length - 1);

    }
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivotValue = trains[high].getDepartureAsInt();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (trains[j].getDepartureAsInt() < pivotValue) {
                i++;
                swap(i, j);
            }
        }

        swap(i +1, high);
        return i + 1;
    }

    private void swap(int a, int b) {
        Train temp = trains[a];
        trains[a] = trains[b];
        trains[b] = temp;
    }

    public void sortByPrice() {
        if (trains.length == 0) {
            System.out.println("ERROR: tidak ada kereta untuk diurutkan");
            return;
        }

        int maxPrice = getMaxPrice();
        for (int exp = 1; maxPrice / exp > 0; exp *= 10) {
            countingSortByDigit(exp);
        }
    }

    private int getMaxPrice() {
        int max = trains[0].getPrice();
        for (int i = 1 ; i < trains.length; i++) {
            if (trains[i].getPrice() > max) {
                max = trains[i].getPrice();
            }
        }
        return max;
    }

    private void countingSortByDigit(int exp) {
        int n = trains.length;
        Train[] output = new Train[n];
        int[] count = new int[10];

        for (int i =  0; i < n; i++) {
            int digit = (trains[i].getPrice() / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (trains[i].getPrice() / exp) % 10;
            output[count[digit] - 1 ] = trains[i];
            count[digit]--;
        }

        for (int i = 0; i <  n; i++) {
            trains[i] = output[i];
        }
    }

    public void printList(String title) {
        if (trains.length == 0) {
            System.out.println("jadwal kosong, tidak ada kereta yang harus ditampilkan");
            return;
        }

        System.out.println("=== " + title + " === ");
        for (int i = 0; i < trains.length; i++) {
            Train t = trains[i];
            System.out.println((i + 1 ) + ". " + t.getNameString() + " "
            + t.getDepartureTime() + " Rp"
            + formatRupiah(t.getPrice()));
        }
    }

    private String formatRupiah(int amount) {
        String s = String.valueOf(amount);
        StringBuilder result = new StringBuilder();
        int count = 0;
        for ( int i = s.length() - 1; i >= 0; i--) {
            result.insert(0, s.charAt(i));
            count++;
            if (count % 3 == 0 && i != 0 ) {
                result.insert(0, ".") ;
            }
        }
        return result.toString();
    }
}