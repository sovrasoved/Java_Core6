package module5;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by sovra on 06.03.2017.
 */
public class GoogleAPI implements API {
    Room[] rooms = new Room[5];

    public GoogleAPI() {
        Date currentDate = new Date();
        rooms[0] = new Room(1, 100, 1, currentDate, "Book", "Kharkov");
        rooms[1] = new Room(2, 150, 1, currentDate, "Book", "Kharkov");
        rooms[2] = new Room(3, 250, 2, currentDate, "Google", "Poltava");
        rooms[3] = new Room(4, 300, 2, currentDate, "Google", "Poltava");
        rooms[4] = new Room(5, 350, 3, currentDate, "Peace", "Kiev");
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
        tmp.setHotelName(hotel);
        tmp.setCityName(city);
        for (int iposition = 0; iposition < rooms.length; iposition++) {
            if (rooms[iposition].equals(tmp)) {
                int count_foundRooms = foundRoomsinArray.length;

                foundRoomsinArray = Arrays.copyOf(foundRoomsinArray, count_foundRooms + 1);
                System.arraycopy(rooms, iposition, foundRoomsinArray, count_foundRooms, 1);

            }
        }
        return foundRoomsinArray;
    }


}

