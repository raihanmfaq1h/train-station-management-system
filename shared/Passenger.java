public class Passenger {
    private String id;
    private String name;
    private String ticketClass;

    public Passenger(String id, String name, String ticketClass) {
        this.id = id;
        this.name = name;
        this.ticketClass = ticketClass;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getTicketClass() {
        return ticketClass;
    }
}