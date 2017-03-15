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
    public Room[] addRooms(Room[] room_arr, Room xroom) {
        int count_foundRooms = room_arr.length;
        Room[] rooms = new Room[count_foundRooms + 1];
        System.arraycopy(room_arr, 0, rooms, 0, count_foundRooms);
        rooms[count_foundRooms] = xroom;
        return rooms;
    }

    @Override
    public Room[] getallRecords() {
        return rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] foundRoomsinArray = new Room[0];
        Date currentDate = new Date();
        Room tmp = new Room(0, price, persons, currentDate, hotel, city);

        for (int iposition = 0; iposition < rooms.length; iposition++) {
            if (rooms[iposition].equals(tmp)) {
                foundRoomsinArray = addRooms(foundRoomsinArray, rooms[iposition]);
            }
        }
        return foundRoomsinArray;
    }


}

