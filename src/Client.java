public class Client extends User {
    public void getTicket() {
        System.out.println("Client: Getting ticket.");
    }

    @Override
    public void printRole() {
        System.out.println("Role: Client");
    }
}