package FinalProject.Menu;

import FinalProject.DAO.DAOUserRoomHotel;
import FinalProject.DAO.DAOhotel_rooms;
import FinalProject.DataA.Hotel;
import FinalProject.DataA.Room;
import FinalProject.DataA.User;
import FinalProject.MyExceptionErrorStructureBD;
import FinalProject.WorkDAO.MenuHRU;

import java.io.IOException;
import java.util.List;

public class Mainmenu {
    public static List<Hotel> lstBDHotel;
    public static List<Room> lstBDRoom;
    public static List<User> lstBDUser;
    public static List<DAOhotel_rooms> lstDAOhr;
    public static List<DAOUserRoomHotel> lstDAOURH;
    public static Long idHotelForChoice;

    //базы данных в текстовых файлах
    //datahotel.txt   -- список отелей со свойствами
    //dataroom.txt   -- список комнат со свойствами
    //datauser.txt   -- список пользователй со свойствами
    //datahotelrooms.txt -- список связи к конкретному отелю (номеру) - номера комнат из dataroom
    //datareservation.txt  -- список бронирования


    public static void main(String[] args) throws MyExceptionErrorStructureBD, IOException {
        idHotelForChoice = null;
        MenuHRU.menuM();
    }
}

