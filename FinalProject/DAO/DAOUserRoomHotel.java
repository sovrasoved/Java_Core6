package FinalProject.DAO;

public class DAOUserRoomHotel {
    private long id; //идентификатор  - номер по порядку
    private long idPointer_idBDDAOhotel_rooms; //указатель на комнату в отеле БД DAO_hotel_rooms
    private long idPointer_idUsers; // указатель на пользователя
    private int idDays; //дата бронирования, вселения, выселения
    private int statusDAOUserRoomHotel;  //статус
                    // 0 бронирование
                    // 1 вселение
                    // 2 выселение
                    // 3 ремонт


    public DAOUserRoomHotel(long id, long idPointer_idBDDAOhotel_rooms, long idPointer_idUsers, int idDays, int statusDAOUserRoomHotel) {
        this.id = id;
        this.idPointer_idBDDAOhotel_rooms = idPointer_idBDDAOhotel_rooms;
        this.idPointer_idUsers = idPointer_idUsers;
        this.idDays = idDays;
        this.statusDAOUserRoomHotel = statusDAOUserRoomHotel;
    }

    public long getIdPointer_idUsers() {
        return idPointer_idUsers;
    }

    @Override
    public String toString() {
        return "DAOUserRoomHotel{" +
                "id=" + id +
                ", idPointer_idBDDAOhotel_rooms=" + idPointer_idBDDAOhotel_rooms +
                ", idPointer_idUsers=" + idPointer_idUsers +
                ", idDays=" + idDays +
                ", statusDAOUserRoomHotel=" + statusDAOUserRoomHotel +
                '}';
    }

    public void setIdPointer_idUsers(long idPointer_idUsers) {
        this.idPointer_idUsers = idPointer_idUsers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPointer_idBDDAOhotel_rooms() {
        return idPointer_idBDDAOhotel_rooms;
    }

    public void setIdPointer_idBDDAOhotel_rooms(long idPointer_idBDDAOhotel_rooms) {
        this.idPointer_idBDDAOhotel_rooms = idPointer_idBDDAOhotel_rooms;
    }

    public int getIdDays() {
        return idDays;
    }

    public void setIdDays(int idDays) {
        this.idDays = idDays;
    }

    public int getStatusDAOUserRoomHotel() {
        return statusDAOUserRoomHotel;
    }

    public void setStatusDAOUserRoomHotel(int statusDAOUserRoomHotel) {
        this.statusDAOUserRoomHotel = statusDAOUserRoomHotel;
    }
}
