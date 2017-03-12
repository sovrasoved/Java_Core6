package module5;

import java.util.Arrays;
import java.util.Date;


public class BookingComAPI implements API {

    Room[] rooms = new Room[5];

    public BookingComAPI() {
        Date currentDate = new Date();
        rooms[0] = new Room(1, 100, 1, currentDate, "Book", "Kharkov");
        rooms[1] = new Room(2, 150, 1, currentDate, "Book", "Kharkov");
        rooms[2] = new Room(3, 350, 2, currentDate, "Peace", "Poltava");
        rooms[3] = new Room(4, 250, 2, currentDate, "Booking", "Kharkov");
        rooms[4] = new Room(5, 300, 3, currentDate, "Booking", "Kharkov");
    }

    @Override
    public Room[] getallRecords() {
        return rooms;
    }


    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] foundRoomsinArray = new Room[0];
        Date currentDate = new Date();
        Room tmp = new Room(0, 0, 0, currentDate, "", "");

        tmp.setPrice(price);
        tmp.setPersons(persons);
        tmp.setCityName(city);
        tmp.setHotelName(hotel);

        for (int iposition = 0; iposition < rooms.length; iposition++)
            if (rooms[iposition].equals(tmp)) {
                int count_foundRooms = foundRoomsinArray.length;

                foundRoomsinArray = Arrays.copyOf(foundRoomsinArray, count_foundRooms + 1);
                System.arraycopy(rooms, iposition, foundRoomsinArray, count_foundRooms, 1);
            }
        return foundRoomsinArray;
    }
}
