import java.time.LocalDate;
import java.util.List;

public class Admin extends User {
    //Un utilizator are o lista de rezervari, nume, prenume.
    private Hotel hotel;


    public Admin(String name) {
        super(name);
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    //Adaugare camera:
    public List<Room> addRoomToHotel(Room room) {
        hotel.getRooms().add(room);
        return hotel.getRooms();
    }


    //Stergere camera:
    public void deleteRoomFromHotel(Integer roomNumber) throws Exception {
        Room roomToBeDeleted = hotel.findRoomByNumber(roomNumber);
        hotel.getRooms().remove(roomToBeDeleted);
    }

    //Vizualizare camere:
    public void viewRooms() {
        System.out.println(hotel.getRooms());
    }

    //Editare pret camera:
    public Room updateRoomSPrice(Integer roomNumber, Integer newPrice) throws Exception {
        Room room = hotel.findRoomByNumber(roomNumber);
        room.setPrice(newPrice);
        return room;
    }

    //cate camere sunt libere/ocupate pentru o anumita perioada
    public void printNumberOfAvailableRooms(LocalDate startDate, LocalDate endDate) {
        int numberOfAvailableRooms = 0;
        int numberOfOccupiedRooms = 0;
        for (Room room : hotel.getRooms()) {
            if (room.getBookings().isEmpty()) {
                numberOfAvailableRooms++;
            } else if (!room.isRoomBookedBetween(startDate, endDate)) {
                numberOfAvailableRooms++;
            } else {
                numberOfOccupiedRooms++;
            }
        }
        System.out.println("numarul de camere libere: " + numberOfAvailableRooms + " si numarul de camere ocupate: " + numberOfOccupiedRooms);
    }

    //varianta folosind stream care returneaza numarul de camere libere:
    public long getNumberOfAvailableRooms(LocalDate checkin, LocalDate checkout) {
        return hotel.getRooms().stream()
                .filter(room -> !room.isRoomBookedBetween(checkin, checkout))
                .count();
    }

    //pretul obtinut din toate rezervarile dintr-o anumita perioada:
    public long getTotalPriceFromAllBookingsBetween(LocalDate startDate, LocalDate endDate) {
        long totalPrice = 0;
        List<Room> rooms = hotel.getRooms();
        //parcurg lista de camere a hotelului
            //pentru fiecare camera
        for (Room room : rooms) {
            //adun pretul total al rezervarilor pe acea camera la pretul total al tuturor rezervarilor
            totalPrice += room.getTotalPricePerRoomBetween(startDate, endDate);
        }
        return totalPrice;
    }
}
