import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {

    //O camera are numar, pret pe noapte, numar de persoane care pot fi cazate si o lista de rezervari
    private Integer number;
    private Integer price;
    private Integer numberOfPlaces;
    private List<Booking> bookings;

    public Room(Integer number, Integer price, Integer numberOfPlaces) {
        this.number = number;
        this.price = price;
        this.numberOfPlaces = numberOfPlaces;
        this.bookings = new ArrayList<>();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(Integer numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", price=" + price +
                ", numberOfPlaces=" + numberOfPlaces +
                ", bookings=" + bookings +
                '}';
    }

    // adăugare rezervare
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    //verificare disponibilitate într-o perioadă dată:
    public boolean isRoomBookedBetween(LocalDate startDate, LocalDate endDate) {
        return bookings.stream().anyMatch(booking -> booking.getCheckOut().isAfter(startDate) && booking.getCheckIn().isBefore(endDate));
    }

    //calculare preț total pentru rezervări într-o perioadă dată
    public long getTotalPricePerRoomBetween(LocalDate startDate, LocalDate endDate) {
        long totalPricePerRoom = 0;
        int numberOfTotalNightsBookedPerRoom = 0;
        for (Booking booking : bookings) {
            if (isRoomBookedBetween(startDate, endDate)) {
                numberOfTotalNightsBookedPerRoom += booking.getNumberOfNights();
                totalPricePerRoom = (long) price * numberOfTotalNightsBookedPerRoom;
            } else {
                return 0;
            }
        }
        return totalPricePerRoom;
    }

}
