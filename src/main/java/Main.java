import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Room room1 = new Room(1, 250, 2);
        Room room2 = new Room(2, 210, 2);
        Room room3 = new Room(3, 230, 2);
        Room room4 = new Room(4, 400, 4);
        Room room5 = new Room(5, 460, 4);
        Room room6 = new Room(6, 500, 4);

        List<Room> roomList = new ArrayList<>();

        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);
        roomList.add(room4);
        roomList.add(room5);
        roomList.add(room6);
        System.out.println(roomList);
        Hotel hotel = new Hotel("Royal");

        Admin admin = new Admin("Sonia Popa");
        admin.setHotel(hotel);

        Client client1 = new Client("Daniel Preda");

        Booking booking = new Booking();

        admin.addRoomToHotel(room1);
        admin.addRoomToHotel(room2);
        admin.addRoomToHotel(room3);
        admin.addRoomToHotel(room4);
        admin.addRoomToHotel(room5);
        admin.addRoomToHotel(room6);

        System.out.println("camere libere: " + client1.getAvailableRooms(hotel, LocalDate.of(2023, 12, 11), LocalDate.of(2023, 12, 23), 2));
        System.out.println("camere libere sortate dupa pret crescator: " + client1.sortAvailableRooms(hotel, LocalDate.of(2023, 12, 11), LocalDate.of(2023, 12, 23), 2));
        client1.bookingRoom(room1, LocalDate.of(2023, 12, 11), LocalDate.of(2023, 12, 23));



        try {
            admin.deleteRoomFromHotel(room6.getNumber());
            System.out.println("camera " + room6.getNumber() + " e eliminata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        admin.viewRooms();
        try {
            admin.updateRoomSPrice(5, 600);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        admin.printNumberOfAvailableRooms(LocalDate.of(2023,12,10),LocalDate.of(2023,12,26));
        System.out.println(admin.getTotalPriceFromAllBookingsBetween(LocalDate.of(2023,12,10),LocalDate.of(2023,12,26)));
        booking.setRoom(room1);
    }
}
