import java.time.Instant;

public class TicketServise {
    public static void main(String[] args) {
        Ticket empty = new Ticket();
        empty.displayInfo();

        Ticket full = new Ticket("1234", "Hall1", 123, 1729851247L, true, 'A', 33.3, 100.0);
        full.displayInfo();

        Ticket limited = new Ticket("Hall2", 124, 1729851247L);
        limited.displayInfo();

    }
}

class Ticket{
     private String id;
     private String consertHall;
     private int eventCode;
     private long time;
     private boolean isPromo;
     private char stadiumSector;
     private double maxWeight;
     private Instant creationTime;
     private double price;
     void displayInfo (){
         System.out.println("ID: " + id + ", Hall: " + consertHall + ", Event code: " + eventCode + ", Time: " + time + ", Promo: " + isPromo +", Stadium sector: " + stadiumSector +", Max weight: " + maxWeight + ", Creation time: " + creationTime + ", Price: " + price);
     }

 public Ticket(String id, String concertHall, int eventCode, long time, boolean isPromo, char stadiumSector, double maxWeight, double price)
 {
    this.id = id;
    this.consertHall = concertHall;
    this.eventCode = eventCode;
    this.time = time;
    this.isPromo = isPromo;
    this.stadiumSector = stadiumSector;
    this.maxWeight = maxWeight;
    this.price = price;
    this.creationTime = Instant.now();
 }
    public Ticket(String concertHall, int eventCode, long time)
    {
     this.id = concertHall;
     this.eventCode = eventCode;
     this.time = time;
     this.creationTime = Instant.now();
    }
    public Ticket(){}
 }