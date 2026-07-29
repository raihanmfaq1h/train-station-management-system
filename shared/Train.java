package shared;

public class Train{
    private String id;
    private String name;
    private String origin;
    private String destination;
    private String departureTime;
    private int price; // BARU: ditambahkan untuk kebutuhan sortByPrice (Radix Sort)

    public Train(String id, String name, String origin, String destination, String departureTime) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.price = 0;
    }

    public String getId() {
        return this.id;
    }

    public String getNameString() {
        return this.name;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    // BARU: dibutuhkan untuk sortByPrice (Radix Sort) di TrainSorter
    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // BARU: mengubah "07:00" jadi 700, "20:00" jadi 2000
    // dipakai TrainSorter untuk sortByDeparture (Quick Sort)
    public int getDepartureAsInt() {
        String[] parts = departureTime.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 100 + minute;
    }

    // BARU: supaya println(train) otomatis nampilin teks yang rapi,
    // bukan alamat memori object
    @Override
    public String toString() {
        return "[" + id + "] " + name + " | " + origin + " -> " + destination
                + " | Berangkat: " + departureTime;
    }
}