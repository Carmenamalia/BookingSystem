import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Client extends User {
    //Un utilizator are o lista de rezervari, nume, prenume.
    public Client(String name) {
        super(name);
    }


//Clinetii vor putea sa:
//
//Vada disponibilitatile (camerele libere) pentru o anumita perioada si un anumit numar de locuri
//Adica sa vada care camere sunt disponibile intr-o anumita perioada
//Sorteze disponibilitatile (camerele libere) dupa pret pentru o anumita perioada si un anumit numar de locuri
//Faca o rezervare pentru o anumita camera

    //vizualizare disponibilitate
    public List<Room> getAvailableRooms(Hotel hotel, LocalDate startDate, LocalDate endDate, Integer nrOfPlaces) {
        List<Room> availableRooms = hotel.getRooms().stream()
                .filter(room -> !room.isRoomBookedBetween(startDate, endDate))
                .filter(room -> room.getNumberOfPlaces().equals(nrOfPlaces))
                .collect(Collectors.toList());
        return availableRooms;
    }

    //sortare disponibilități după preț
    public List<Room> sortAvailableRooms(Hotel hotel, LocalDate startDate, LocalDate endDate, Integer nrOfPlaces) {
        return getAvailableRooms(hotel, startDate, endDate, nrOfPlaces).stream()
                .sorted(Comparator.comparingLong(Room::getPrice))
                .toList();
    }

    //rezervare cameră
    public void bookingRoom(Room room, LocalDate startDate, LocalDate endDate) {
        List<Booking> bookings = getBookings();
        for (Booking booking : bookings) {
            if (!booking.getRoom().isRoomBookedBetween(startDate, endDate)) {
                booking.setRoom(room);
                bookings.add(booking);
                room.addBooking(booking);
            } else {
                System.out.println("camera nu e disponibila");
            }
        }
        System.out.println("rezervare efectuata");
    }

}
