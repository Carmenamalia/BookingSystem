import java.util.ArrayList;
import java.util.List;

public class User {

    //Un utilizator are o lista de rezervari, nume, prenume.
    private String name;
    private List<Booking> bookings;

    public User(String name) {
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
