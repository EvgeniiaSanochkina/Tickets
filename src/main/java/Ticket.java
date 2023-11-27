public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int travelTime;

    public Ticket(int id, int price, String departure, String arrival, int travelTime) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.travelTime = travelTime;
    }


    public int getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }


    public String getArrival() {
        return arrival;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
