import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TicketService {
    public static void main(String[] args) {
TicketService ticketService = new TicketService();
ticketService.ShowTickets();
System.out.println();
Task1();

    }
    public static void Task1(){
        Ticket empty = new Ticket();
        empty.displayInfo();

        Ticket full = new Ticket("1234", "Hall1", 123, 1729851247L, true, StadiumSector.A, 33.3, 100.0);
        full.displayInfo();

        Ticket limited = new Ticket("Hall2", 124, 1729851247L);
        limited.displayInfo();
    }
    private List<Ticket> tickets;
    public void ShowTickets(){
       for (Ticket ticket : tickets) {
           ticket.displayInfo();
       }
    }
    public TicketService() {
        tickets = new ArrayList<>(10);
        initializeTickets();
    }
    private void initializeTickets(){
        tickets.add(new Ticket("1123", "Hall1", 101, 1729851247L, true, StadiumSector.A, 5.5, 75.0));
        tickets.add(new Ticket("1124", "Hall1", 101, 1729851247L, true, StadiumSector.A, 5.5, 75.0));
        tickets.add(new Ticket("1125", "Hall2", 102, 1729851247L, false, StadiumSector.B, 5.5, 90.0));
        tickets.add(new Ticket("1126", "Hall2", 102, 1729851247L, true, StadiumSector.B, 5.5, 75.0));
        tickets.add(new Ticket("1127", "Hall2", 102, 1729851247L, true, StadiumSector.C, 5.5, 75.0));
        tickets.add(new Ticket("1128", "Hall3", 103, 1729851247L, false, StadiumSector.A, 5.5, 90.0));
        tickets.add(new Ticket("1129", "Hall3", 103, 1729851247L, false, StadiumSector.C, 5.5, 90.0));
        tickets.add(new Ticket("2121", "Hall3", 103, 1729851247L, true, StadiumSector.C, 5.5, 75.0));
        tickets.add(new Ticket("2122", "Hall4", 104, 1729851247L, false, StadiumSector.A, 5.5, 90.0));
        tickets.add(new Ticket("2123", "Hall4", 104, 1729851247L, true, StadiumSector.B, 5.5, 75.0));
    }

}
enum StadiumSector{
    A,
    B,
    C
}

class Ticket{
     private String id;
     private String consertHall;
     private int eventCode;
     private long time;
     private boolean isPromo;
     private StadiumSector stadiumSector;
     private double maxWeight;
     private Instant creationTime;
     private double price;
     void displayInfo (){
         System.out.println("ID: " + id + ", Hall: " + consertHall + ", Event code: " + eventCode + ", Time: " + time + ", Promo: " + isPromo +", Stadium sector: " + stadiumSector +", Max weight: " + maxWeight + ", Creation time: " + creationTime + ", Price: " + price);
     }

 public Ticket(String id, String concertHall, int eventCode, long time, boolean isPromo, StadiumSector stadiumSector, double maxWeight, double price)
 {
    setId(id);
    setConsertHall(concertHall);
    setEventCode(eventCode);
    this.time = time;
    this.isPromo = isPromo;
    this.stadiumSector = stadiumSector;
    this.maxWeight = maxWeight;
    this.price = price;
    this.creationTime = Instant.now();
 }
    public Ticket(String concertHall, int eventCode, long time)
    {
        setConsertHall(concertHall);
        setEventCode(eventCode);
        this.time = time;
     this.creationTime = Instant.now();
    }
    public Ticket(){}

    public void setId(String id) {
        if (id.length() <= 4) {
            this.id = id;
        }
    }

    public void setConsertHall(String consertHall) {
        if (consertHall.length() <= 10)
         this.consertHall = consertHall;
    }

    public void setEventCode(int eventCode) {
        if (Integer.toString(eventCode).length() <= 3)
         this.eventCode = eventCode;
    }
}