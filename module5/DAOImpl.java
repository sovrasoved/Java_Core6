package module5;

/**
 * Created by sovra on 09.03.2017.
 */
public class DAOImpl implements DAO {
    Room[] roomBD = new Room[5]; // 5 - условие задачи

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
        int count = getRoomsCount(roomBD);
        if (count < 6) {  //по условию задачи
            roomBD[count] = room;
            return room;
        } else
            return null;
    }

    @Override
    public boolean delete(Room room) {
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

        for (Room rooms : roomBD) {
            if ((rooms != null) && (rooms.getId() == id))
                return rooms;
        }
        return null;
    }
}
