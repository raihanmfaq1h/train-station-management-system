public class Ticket {
    private String passengerId;
    private String trainId;
    private String seat;
    private int price;

    public Ticket(String passengerId, String trainId, String seat, int price) {
        this.passengerId = passengerId;
        this.trainId = trainId;
        this.seat = seat;
        this.price = price;
    }

    public String getPassengerId() {return passengerId;}
    public String getTrainId() {return trainId;}
    public String getSeat() {return seat;}
    public int getPrice() {return price;}


    public void setPrice(int price) { this.price = price; }


    @Override
    public String toString() {
        return "[Tiket] penumoang:  " + passengerId + 
        " | kereta: " + trainId + 
        " | kursi " + seat + 
        " | Harga: Rp" + String.format("%,d", price); 
}
}

