package shared;


public class train{
    private String name;
    private String id;
    private String origin;
    private String destination;
    private String departureTime;

    public train(String name, String id, String origin, String destination, String departureTime){
        this.name = name;
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public String getName(){
        return this.name;
    }
    public String getId(){
        return this.id;
    }
    public String getOrigin(){
        return this.origin;
    }
    public String getDestination(){
        return this.destination;
    }
    public String getDepartureTime(){
        return this.departureTime;
    }

    
}
