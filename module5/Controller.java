package module5;

import java.util.Arrays;
import java.util.Date;

public class Controller {
    final static int COUNT_APIS = 3;
    API apis[] = new API[COUNT_APIS];

    {  // блок вместо конструктора
        apis[0] = new BookingComAPI();
        apis[1] = new GoogleAPI();
        apis[2] = new TripAdvisorAPI();
    }


    public Room[] requstRooms(int price, int persons, String city, String hotel) {
        Room[] roomapi = new Room[0];

        for (API apitmp : apis) {
            Room[] roomstmp = apitmp.findRooms(price, persons, city, hotel);
            if (roomstmp.length > 0) {
                roomapi = addRooms(roomapi, roomstmp);
//                int count_foundRooms = roomapi.length;
//                roomapi = Arrays.copyOf(roomapi, count_foundRooms + 1);
//                System.arraycopy(roomstmp, 0, roomapi, count_foundRooms, roomstmp.length);
            }
        }

        if (roomapi.length > 0)
            return roomapi;
        else {
            System.out.println("Not found...");
            return null;
        }
    }

    public Room[] check(API api1, API api2) {
        if (api1 == api2) {
            System.out.println("Одинаковы API, сравнивать нечего");
            return api1.getallRecords();
        }

        if (api1.getallRecords().length == 0 || api2.getallRecords().length == 0) {
            System.out.println("одна из баз пуста, сравнивать нечего");
            return null;
        }

        Room[] foundRecord = new Room[0];

        for (Room room1 : api1.getallRecords()) {
            for (Room room2 : api2.getallRecords()) {
                if (room1.equals(room2)) {
                    //save
                    int icountrec = foundRecord.length;
                    foundRecord = Arrays.copyOf(foundRecord, icountrec + 1);
                    foundRecord[icountrec] = room1;

                }
            }
        }

        if (foundRecord.length == 0) {
            System.out.println("Совпадающих не нашли");
            return null;
        }
        return foundRecord;

    }

    private Room[] addRooms(Room[] room_arr, Room[] xroom) {
        int count1_arr = room_arr.length;
        int count2_arr = xroom.length;
        Room[] rooms = new Room[count1_arr+ count2_arr]; //new range
        System.arraycopy(room_arr, 0, rooms, 0,count1_arr);
        System.arraycopy(xroom,0,rooms,count1_arr,count2_arr);
        return rooms;
    }


}
