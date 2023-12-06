import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String hotelName;
    private List<Room> rooms;

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        this.rooms = new ArrayList<>();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room findRoomByNumber(Integer roomNumber) throws Exception {
       return  rooms.stream().filter(r ->r.getNumber().equals(roomNumber)).findFirst().orElseThrow(()->new Exception("room not found"));
    }
}
