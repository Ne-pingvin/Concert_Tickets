import java.time.Instant;

public class TicketServise {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
class Ticket{
 private String id;
 private String consertHall;
 private int eventCode;
 private long time = Instant.now().getEpochSecond();
 private boolean isPromo;
 private char stadiumSector;
 private double maxWeight;
 private Instant creationTime;
 private double price;

 public Ticket(String id, String concertHall, int eventCode, long time, boolean isPromo, char stadiumSector, double maxWeight, double price){
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
 }