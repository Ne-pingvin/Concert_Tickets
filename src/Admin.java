public class Admin extends User {
    public void checkTicket() {
        System.out.println("Admin: Checking ticket.");
    }

    @Override
    public void printRole() {
        System.out.println("Role: Admin");
    }
}