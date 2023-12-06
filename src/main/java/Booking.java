import java.time.LocalDate;

public class Booking {
    //O rezervare poate fi facuta pentru o camera, de catre un client, intre doua date (check in si check out).

    private Room room;
    private Client client;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Booking() {
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", client=" + client +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
    public int getNumberOfNights(){
        return checkOut.getDayOfMonth()-checkIn.getDayOfMonth();
    }
}
