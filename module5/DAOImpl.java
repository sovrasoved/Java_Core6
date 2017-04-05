package module5;

import java.util.Date;

/**
 * Created by sovra on 09.03.2017.
 */
public class DAOImpl implements DAO {
    public final int SIZEDAO = 10;

    Room[] roomBD = new Room[SIZEDAO]; //

    private int getRoomsCount(Room[] roomDB) {
        int count = 0;
        for (Room room : roomDB) {
            if (room != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Room save(Room room) {
        System.out.println("Operation: save room");
        System.out.println(room);
        int count = getRoomsCount(roomBD);
        if (count < SIZEDAO) {  //по условию задачи
            roomBD[count] = room;
            return room;
        } else
            return null;
    }

    @Override
    public boolean delete(Room room) {
        System.out.println("Operation: delete room");
        System.out.println(room);
        int iFound = -1;
        for (int i = 0; i < roomBD.length; i++) {
            Room roomIns = roomBD[i];
            if (roomIns.equals(room)) {
                iFound = i;
                System.arraycopy(roomBD, i + 1, roomBD, i, roomBD.length - 1 - i);
                roomBD[roomBD.length - 1] = null;
                i--;  //после удаления массив сдвинулся влево, индекс уменшили на 1 ед
            }
        }


        if (iFound == -1) return false;
        else return true;
    }

    @Override
    public Room update(Room room) {
        System.out.println("Operation: update room");
        System.out.println(room);
        if (room == null) return null;
        for (int i = 0; i < roomBD.length; i++) {
            if (roomBD[i].getId() == room.getId()) {
                roomBD[i] = room;
                break;
            }
        }

        return room;
    }

    @Override
    public Room findById(long id) {
        System.out.println("Operation: findById room");

        for (Room rooms : roomBD) {
            if ((rooms != null) && (rooms.getId() == id)){
                System.out.println(rooms);
                return rooms;}
        }
        System.out.println("Not found");
        return null;
    }

    public void buildingDAOarray(){
        Date currentDate = new Date();
        for (int i=0; i<SIZEDAO; i++) {
            int newprice = 100 + (50 * i);
            if (save(new Room(i + 1, newprice, 1, currentDate, "Book", "Kharkov")) == null) {
                System.out.println("Error ADD");
                break;
            }
        }

    }
}
