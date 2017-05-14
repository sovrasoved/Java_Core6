package FinalProject.DAO;

// БД  - отель и номера комнат из БД Room

public class DAOhotel_rooms {
    private long idBDDAOhotel_rooms; //идентификатор
    private long idHotel; //идентификатор отеля
    private long idRoom; //идентификатор комнаты
    private int status;  //0-нормальный
                        //-1 удален

    public DAOhotel_rooms(long idBDDAOhotel_rooms, long idHotel, long idRoom, int status) {
        this.idBDDAOhotel_rooms = idBDDAOhotel_rooms;
        this.idHotel = idHotel;
        this.idRoom = idRoom;
        this.status = status;
    }

    public long getIdBDDAOhotel_rooms() {
        return idBDDAOhotel_rooms;
    }

    public void setIdBDDAOhotel_rooms(long idBDDAOhotel_rooms) {
        this.idBDDAOhotel_rooms = idBDDAOhotel_rooms;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(long idHotel) {
        this.idHotel = idHotel;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    @Override
    public String toString() {
        return "DAOhotel_rooms{" +
                "idBDDAOhotel_rooms=" + idBDDAOhotel_rooms +
                ", idHotel=" + idHotel +
                ", idRoom=" + idRoom +
                ", status=" + status +
                '}';
    }
}
