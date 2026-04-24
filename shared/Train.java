package shared;
public class Train {

    private String id;
    private String origin;
    private String destination;

    // Constructor
    public Train(String id, String origin, String destination) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    // Optional: Setter (kalau mau fleksibel) 
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    //To
