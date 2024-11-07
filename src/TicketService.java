import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TicketService {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        ticketService.ShowTickets();
        System.out.println();
        Task1();

        Ticket ticket = ticketService.findTicketById(1123);
        if (ticket != null) {
            System.out.print("Ticket found: ");
            ticket.displayInfo();

        } else {
            System.out.println("Ticket not found.");
        }

        User client = new Client();
        User admin = new Admin();

        System.out.println("Roles:");
        client.printRole();
        admin.printRole();

        System.out.println("Client Actions: ");
        ((Client) client).getTicket();

        System.out.println("Admin Actions: ");
        ((Admin) admin).checkTicket();

        ticket.shared("123-456-7890");
        ticket.shared("123-456-7890", "example@example.com");

        ticket.print();

    }
    public static void Task1(){
        Ticket empty = new Ticket();
        empty.displayInfo();

        Ticket full = new Ticket(1234, "Hall1", 123, 1729851247L, true, StadiumSector.A, 33.3, 100.0);
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
        tickets.add(new Ticket(1123, "Hall1", 101, 1729851247L, true, StadiumSector.A, 5.5, 75.0));
        tickets.add(new Ticket(1124, "Hall1", 101, 1729851247L, true, StadiumSector.A, 5.5, 75.0));
        tickets.add(new Ticket(1125, "Hall2", 102, 1729851247L, false, StadiumSector.B, 5.5, 90.0));
        tickets.add(new Ticket(1126, "Hall2", 102, 1729851247L, true, StadiumSector.B, 5.5, 75.0));
        tickets.add(new Ticket(1127, "Hall2", 102, 1729851247L, true, StadiumSector.C, 5.5, 75.0));
        tickets.add(new Ticket(1128, "Hall3", 103, 1729851247L, false, StadiumSector.A, 5.5, 90.0));
        tickets.add(new Ticket(1129, "Hall3", 103, 1729851247L, false, StadiumSector.C, 5.5, 90.0));
        tickets.add(new Ticket(2121, "Hall3", 103, 1729851247L, true, StadiumSector.C, 5.5, 75.0));
        tickets.add(new Ticket(2122, "Hall4", 104, 1729851247L, false, StadiumSector.A, 5.5, 90.0));
        tickets.add(new Ticket(2123, "Hall4", 104, 1729851247L, true, StadiumSector.B, 5.5, 75.0));
    }

    public Ticket findTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }
}
enum StadiumSector{
    A,
    B,
    C
}

class Ticket extends BasicId implements PossibilityToPrint
{
    private String concertHall;
    private int eventCode;
    private long time;
    private boolean isPromo;
    private StadiumSector stadiumSector;
    private double maxWeight;
    private Instant creationTime;
    private double price;
    void displayInfo (){
        System.out.println("ID: " + getId() + ", Hall: " + concertHall + ", Event code: " + eventCode + ", Time: " + time + ", Promo: " + isPromo +", Stadium sector: " + stadiumSector +", Max weight: " + maxWeight + ", Creation time: " + creationTime + ", Price: " + price);
    }

    public Ticket(int id, String concertHall, int eventCode, long time, boolean isPromo, StadiumSector stadiumSector, double maxWeight, double price)
    {
        if (Integer.toString(id).length() <= 4)
        {
            super.setId(id);
        }
        setConcertHall(concertHall);
        setEventCode(eventCode);
        setTime(time);
        this.isPromo = isPromo;
        setStadiumSector(stadiumSector);
        this.maxWeight = maxWeight;
        this.price = price;
        this.creationTime = Instant.now();
    }
    public Ticket(String concertHall, int eventCode, long time)
    {
        setConcertHall(concertHall);
        setEventCode(eventCode);
        this.time = time;
        this.creationTime = Instant.now();
    }
    public Ticket(){}

    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported");
    }

    public String getConcertHall() {
        return concertHall;
    }


    private void setConcertHall(String concertHall) {
        if (concertHall.length() <= 10)
            this.concertHall = concertHall;
    }

    public int getEventCode() {
        return eventCode;
    }

    private void setEventCode(int eventCode) {
        if (Integer.toString(eventCode).length() <= 3)
            this.eventCode = eventCode;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public StadiumSector getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public double getPrice() {
        return price;
    }
    public void shared(String phone) {
        System.out.println("Ticket shared via phone: " + phone);
    }

    public void shared(String phone, String email) {
        System.out.println("Ticket shared via phone: " + phone + " and email: " + email);
    }

@Override
    public void print() {
        System.out.println("Ticket details: " + this);
    }
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Ticket other = (Ticket) obj;
        return getId() == other.getId() &&
                eventCode == other.eventCode &&
                time == other.time &&
                isPromo == other.isPromo &&
                Double.compare(other.maxWeight, maxWeight) == 0 &&
                Double.compare(other.price, price) == 0 &&
                Objects.equals(concertHall, other.concertHall) &&
                stadiumSector == other.stadiumSector &&
                Objects.equals(creationTime, other.creationTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), concertHall, eventCode, time, isPromo, stadiumSector, maxWeight, creationTime, price);
    }

    @Override
    public String toString() {

        return "Ticket: " +
                "id=" + getId() +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode=" + eventCode +
                ", time=" + time +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxWeight=" + maxWeight +
                ", creationTime=" + creationTime +
                ", price=" + price;
    }

}