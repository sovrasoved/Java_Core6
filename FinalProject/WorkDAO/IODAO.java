package FinalProject.WorkDAO;
//
//ЧТЕНИЕ И ЗАПИСЬ ДАННЫХ В ФАЙЛЫ
// ИМЕНА ФАЙЛОВ ИЗ Setting
//

import FinalProject.DAO.DAOUserRoomHotel;
import FinalProject.DAO.DAOhotel_rooms;
import FinalProject.DataA.City;
import FinalProject.DataA.Hotel;
import FinalProject.DataA.Room;
import FinalProject.DataA.User;
import FinalProject.Menu.Mainmenu;
import FinalProject.MyExceptionErrorStructureBD;
import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class IODAO {
    //запись в файл список отелей
    static public void writeHotel(List<Hotel> bdHotels) {
//        protected long idH; //идентификатор  - номер по порядку
//        private String nameH; //название отеля
//        private long edrpouH; //код ЕДРОПУ отеля
//        private City cityH;//город - вообще-то есть адрес, но это по заданию
//        private String addressH; //юридический адрес
//        private String noticeH; //примечание - какая-то другая информация, как доехать, т.д.
//        private short statusH; //статус отеля
//        //-1   удален  (физически ничего не удаляем)
        //0    активен (по умолчанию)
        //1    ремонт ......
        File file = new File(Setting.NAME_OF_FILEHOTEL);

        try {
//проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

//PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {

                //сначала сортируем
                Collections.sort(bdHotels, (o1, o2) -> (int) (o1.getIdH() - o2.getIdH()));

//Записываем текст у файл
                for (Hotel ht : bdHotels) {
                    out.println(ht.getIdH());
                    out.println(ht.getNameH());
                    out.println(ht.getEdrpouH());
                    out.println(ht.getCityH());
                    out.println(ht.getAddressH());
                    out.println(ht.getNoticeH());
                    out.println(ht.getStatusH());
                }
            } finally {
//После чего мы должны закрыть файл
//Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //запись в файл список комнат
    static public void writeRoom(List<Room> bdRooms) {
//        private long idR;            //идентификатор  - номер по порядку
//        private int numberR;         //номер комнаты  или по порядку или
//        //по шаблону   FN - F-номер этажа N-номер комнаты на этаже
//        private String noticeR; //описание комнаты, типа примечание
//        //кол-во комнат, окна на море, есть ли ванна и т.д.
//        private short statusR;       //статус комнаты
//        //-1   удален  (физически ничего не удаляем)
//        //0    номер пустой (по умолчанию)
//        //1    номер забронирован
//        //2    номер заселен
//        //3    ремонт в номере
//

        File file = new File(Setting.NAME_OF_FILEROOM);

        try {
//проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

//PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {

                //сначала сортируем
                Collections.sort(bdRooms, (o1, o2) -> (int) (o1.getIdR() - o2.getIdR()));
//Записываем текст у файл
                for (Room ht : bdRooms) {
                    out.println(ht.getIdR());
                    out.println(ht.getNumberR());
                    out.println(ht.getNoticeR());
                    out.println(ht.getStatusR());

                }
            } finally {
//После чего мы должны закрыть файл
//Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //запись в файл список пользователей
    static public void writeUser(List<User> bdUsers) {
//        protected long idU;        //идентификатор  - номер по порядку
//        private String nameU;      //наименование пользователя
//        private String documentsU; //документы удостоверяющие личность
//        //паспорт или загран паспорт
//        private short statusU; //статус пользователя
//        //-1   удален  (физически ничего не удаляем)
//        //0    активен (по умолчанию)
//        //1    проблемный

        File file = new File(Setting.NAME_OF_FILEUSERS);

        try {
//проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

//PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {

                //сначала сортируем
                Collections.sort(bdUsers, (o1, o2) -> (int) (o1.getIdU() - o2.getIdU()));
//Записываем текст у файл
                for (User ut : bdUsers) {
                    out.println(ut.getIdU());    //идентификатор  - номер по порядку
                    out.println(ut.getNameU());    //наименование пользователя
                    out.println(ut.getDocumentsU());//документы удостоверяющие личность
                    out.println(ut.getNoticeU()); // //иная информация о пользователе
                    out.println(ut.getStatusU()); //статус пользователя

                }
            } finally {
//После чего мы должны закрыть файл
//Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //запись в файл список отель -> комнаты
    static public void writeDAOhotel_rooms(List<DAOhotel_rooms> lstDHR) {
        File file = new File(Setting.NAME_OF_FILE_HOTELROOMS);

        try {
//проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

//PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {

                //сначала сортируем - по убыванию - статус
                // по возрастанию код отеля и код команты
                Comparator<DAOhotel_rooms> comparator1 = (e1, e2) -> (e2.getStatus() - e1.getStatus());
                Comparator<DAOhotel_rooms> comparator2 = (e1, e2) -> (int) (e1.getIdHotel() - e2.getIdHotel());
                Comparator<DAOhotel_rooms> comparator3 = (e1, e2) -> (int) (e1.getIdRoom() - e2.getIdRoom());

                lstDHR.stream().sorted(comparator1.thenComparing(comparator2.thenComparing(comparator3)));
//Записываем текст у файл
                for (DAOhotel_rooms ut : lstDHR) {
                    out.println(ut.getIdBDDAOhotel_rooms()); //идентификатор БД
                    out.println(ut.getIdHotel());    //идентификатор  - отеля
                    out.println(ut.getIdRoom());    //идентификатор комнаты
                    out.println(ut.getStatus());    //статус комнаты в отеле

                }
            } finally {
//После чего мы должны закрыть файл
//Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //
    static public void writeDAOUserRoomHotel(List<DAOUserRoomHotel> lstDURH) {
        File file = new File(Setting.NAME_OF_FILE_RESERVATION);

        try {
//проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

//PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {


                // //сортировка дате резервирования

                lstDURH.sort((e1, e2) -> (e1.getIdDays() - e2.getIdDays()));

//Записываем текст у файл
                for (DAOUserRoomHotel ut : lstDURH) {
                    out.println(ut.getId()); //идентификатор БД
                    out.println(ut.getIdPointer_idBDDAOhotel_rooms());//указатель на комнату в отеле
                    out.println(ut.getIdPointer_idUsers());// указатель на пользователя
                    out.println(ut.getIdDays());  //дата бронирования, вселения, выселения
                    out.println(ut.getStatusDAOUserRoomHotel());    //статус
                }
            } finally {
//После чего мы должны закрыть файл
//Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //визуализация свободных комнат в данном отеле за 15(по умолчанию) дней
    static public List<Long> viewRoom_Days(List<Hotel> lstHotel, List<DAOhotel_rooms> lstDHR, List<DAOUserRoomHotel> lstDURH, List<Room> lstroom, long idHotels) {


        List<Long> outPair_idRoom = new ArrayList<>(); //указатели на комнату, которую вывели

        // Find idHotel
        if (!findIdbyHotel(lstHotel, idHotels)) {
            System.out.println("Not found Hotel by id=" + idHotels);
            return outPair_idRoom;
        }
        //Find idhotel+idrooms
        if (!findIdHotelbyHotel_rooms(lstDHR, idHotels, (byte) 0)) {
            System.out.println("Not found Rooms by Hotel id=" + idHotels);
            return outPair_idRoom;
        }


        List<DAOhotel_rooms> lstDAO1 =
                lstDHR.stream().filter((DAOhotel_rooms e) ->
                        (e.getIdHotel() == idHotels && e.getStatus() == 0)).collect(Collectors.toList());


        System.out.print("день\\ком.  !");
        int numRoom = 0;
        for (int i = 0; i < Setting.SIZEDISPLAYOUTPUTDATA; i++)
            System.out.printf("%2s!", String.valueOf(i + 1));
        System.out.println("");


        for (DAOhotel_rooms dao : lstDAO1) {
            numRoom++;
            Long idRoomsHotel = dao.getIdBDDAOhotel_rooms();  //id список комнат для вывода

            outPair_idRoom.add(idRoomsHotel); //добавили в список

            List<DAOUserRoomHotel> lstDURH1 =
                    lstDURH.stream().filter(e -> e.getIdPointer_idBDDAOhotel_rooms() == idRoomsHotel).
                            collect(Collectors.toList());
            //список где есть бронирование
            String sroom = Integer.toString(numRoom);
            System.out.printf("%2s.комната\n", sroom);
            String romm = String.valueOf(findNumberRoom(lstroom, idRoomsHotel));
            System.out.printf("%10s !", romm);
            int iStepUserforRooms = 0;

            if (lstDURH1.size() == 0) {
                for (int istep = 0; istep < Setting.SIZEDISPLAYOUTPUTDATA; istep++) {
                    String ouScreen = "  !";
                    System.out.print(ouScreen);
                }
            } else {
                for (int istep = 0; istep < Setting.SIZEDISPLAYOUTPUTDATA; istep++) {
                    String ouScreen = "  !";
                    if (lstDURH1.get(iStepUserforRooms).getIdDays() == (istep + 1)) {
                        ouScreen = "RR!";
                        if (lstDURH1.size() > (iStepUserforRooms + 1)) iStepUserforRooms++;
                    }

                    System.out.print(ouScreen);
                }
            }
            System.out.println("");


        }

        return outPair_idRoom; //список комнат, которые вывели на экран
    }

    //визуализация свободных комнат в определенный день
    static public List<Pair<Long, Long>> viewRoom_Hotels(List<Hotel> lstHotel, List<DAOhotel_rooms> lstDHR, List<DAOUserRoomHotel> lstDURH, List<Room> lstroom, int Days) {

        List<Pair<Long, Long>> out_Hotel_room = new ArrayList<>(); //список
        // id -отеля
        // id -комнаты

//создаем список идентификаторов отелей из БД DAOhotel_rooms
        List<Long> listHotels = lstDHR.stream().filter(e -> e.getStatus() == 0).
                map(e -> e.getIdHotel()).distinct().collect(Collectors.toList());
        //получили список отелей (идннтификаторы отелей), где есть комнаты

        int choice = 0;
        System.out.println("комната\\отель     ! " + "Бронирование день : " + Days);
        for (Long idH : listHotels) {
            //идем по идентификаторам отелей

            Hotel hot = IODAO.findHotelId(Mainmenu.lstBDHotel, idH);
            String nameHotelOut = hot.getNameH() + " город." + hot.getCityH() + " код." + hot.getEdrpouH();

            List<DAOhotel_rooms> listRooms = lstDHR.stream().filter(e -> (e.getIdHotel() == idH &&
                    e.getStatus() == 0)).collect(Collectors.toList());

            // выводим название отеля
            System.out.println("                  !" + nameHotelOut);

            for (DAOhotel_rooms idRDAO : listRooms) {
                choice++;
                Long idR = idRDAO.getIdBDDAOhotel_rooms();
                //.getIdRoom();
                Room room = IODAO.findRoomId(Mainmenu.lstBDRoom, idR);
                String nameRoomOut = Integer.toString(choice) + ". комната №" + room.getNumberR();
                System.out.printf("%16s", nameRoomOut);


                Pair<Long, Long> tmpout = new Pair<Long, Long>(idH, idR);
                out_Hotel_room.add(tmpout); //добавили в список пару
                //id - отеля
                //id - комнаты

                //смотрим, кто то уже забронировал номер?
                List<DAOUserRoomHotel> lstDURH1 =
                        lstDURH.stream().filter(e -> (
                                e.getIdDays() == Days &&
                                        e.getStatusDAOUserRoomHotel() == 0 &&
                                        e.getIdPointer_idBDDAOhotel_rooms() == idRDAO.getIdBDDAOhotel_rooms()
                        )).
                                collect(Collectors.toList());
                if (lstDURH1.size() == 0) System.out.println("");
                else
                    System.out.println("! XXX");
            }
            System.out.println("-----------------!---------------------------------");
        }
        return out_Hotel_room;
    }

    //получение из файла списка отелей
    static public List<Hotel> readHotel() throws MyExceptionErrorStructureBD, IOException {
        List<Hotel> hotels = new ArrayList<>();
        File file = new File(Setting.NAME_OF_FILEHOTEL);
        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
        ) {

// читаем построчно

            String line;
            while ((line = br.readLine()) != null) {

                Long idh = Long.valueOf(line);
                line = br.readLine();
                String nameh = line;
                line = br.readLine();
                long edrpouH = Long.valueOf(line); //код ЕДРОПУ отеля
                line = br.readLine();

                String cityH1 = line;//город - вообще-то есть адрес, но это по заданию
                line = br.readLine();
                String addressH = line; //юридический адрес
                line = br.readLine();
                String noticeH = line; //примечание - какая-то другая информация, как доехать, т.д.
                line = br.readLine();
                int statusH = Integer.valueOf(line); //статус отеля

                if (idh < 1 || (idh - 10) > hotels.size())
                    throw new MyExceptionErrorStructureBD("BD hotel");


                if (LogicalDAO.isName(nameh) && LogicalDAO.isNotice(noticeH)) {
                    Hotel tmpH = new Hotel(idh, nameh, edrpouH, City.valueOf(cityH1), addressH, noticeH, statusH);
                    hotels.add(tmpH);
                } else
                    System.out.println("Error: not allowed characters\nThe record is not added");

            }
            br.close();
            fr.close();
        } catch (MyExceptionErrorStructureBD e0) {
            e0.printStackTrace();
        }

//сортировка - на всякий случай по возрастанию
        Collections.sort(hotels, (o1, o2) -> (int) (o1.getIdH() - o2.getIdH()));
        return hotels;
    }

    //получение из файла списка комнат
    static public List<Room> readRoom() throws MyExceptionErrorStructureBD, IOException {
        List<Room> rooms = new ArrayList<>();

        File file = new File(Setting.NAME_OF_FILEROOM);
        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
        ) {

// читаем построчно

            String line;
            while ((line = br.readLine()) != null) {

                Long idR = Long.valueOf(line); //идентификатор  - номер по порядку
                line = br.readLine();
                int numberR = Integer.valueOf(line);//номер комнаты  или по порядку или
                line = br.readLine();
                String noticeR = line;//описание комнаты, типа примечание
                line = br.readLine();
                int statusR = Integer.valueOf(line); //статус комнаты

                if (idR < 1 || (idR - 10) > rooms.size() || numberR < 0 || numberR > 10000)
                    throw new MyExceptionErrorStructureBD("BD room");

                if (LogicalDAO.isNotice(noticeR)) {
                    Room tmpR = new
                            Room(idR, numberR, noticeR, statusR);
                    rooms.add(tmpR);
                } else
                    System.out.println("Error: not allowed characters\nThe record is not added");

            }
            br.close();
            fr.close();
        } catch (MyExceptionErrorStructureBD e0) {
            e0.printStackTrace();
        }

//сортировка - на всякий случай по возрастанию
        Collections.sort(rooms, (o1, o2) -> (int) (o1.getIdR() - o2.getIdR()));

        return rooms;
    }

    //получение из файла списка пользователей
    static public List<User> readUsers() throws MyExceptionErrorStructureBD, IOException {
        List<User> users = new ArrayList<>();

        File file = new File(Setting.NAME_OF_FILEUSERS);
        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
        ) {

// читаем построчно

            String line;
            while ((line = br.readLine()) != null) {

                Long idU = Long.valueOf(line); //идентификатор  - номер по порядку
                line = br.readLine();
                String nameU = line;//наименование пользователя
                line = br.readLine();
                String documentsU = line; //документы удостоверяющие личность
                line = br.readLine();
                String noticeU = line;   //иная информация о пользователе
                line = br.readLine();
                int statusR = Integer.valueOf(line);  //статус пользователя

                if (idU < 1 || (idU - 10) > users.size())
                    throw new MyExceptionErrorStructureBD("BD user");

                if (LogicalDAO.isName(nameU) && LogicalDAO.isNotice(documentsU) && LogicalDAO.isNotice(noticeU)) {
                    User tmpU = new
                            User(idU, nameU, documentsU, noticeU, statusR);
                    users.add(tmpU);
                } else
                    System.out.println("Error: not allowed characters\nThe record is not added");


            }
            br.close();
            fr.close();
        } catch (MyExceptionErrorStructureBD e0) {
            e0.printStackTrace();
        }

//сортировка - на всякий случай по возрастанию
        Collections.sort(users, (o1, o2) -> (int) (o1.getIdU() - o2.getIdU()));

        return users;
    }

    //получение из файла списка отель->комнаты
    static public List<DAOhotel_rooms> readHotelRooms() throws MyExceptionErrorStructureBD, IOException {
        List<DAOhotel_rooms> lstDHR = new ArrayList<>();

        File file = new File(Setting.NAME_OF_FILE_HOTELROOMS);
        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
        ) {

// читаем построчно

            String line;
            while ((line = br.readLine()) != null) {
                Long id = Long.valueOf(line); //идентификатор
                line = br.readLine();
                Long idH = Long.valueOf(line); //идентификатор отеля
                line = br.readLine();
                Long idR = Long.valueOf(line); //идентификатор комнаты
                line = br.readLine();
                int statusR = Integer.valueOf(line);  //статус комнаты

                if (id < 0 || idH < 1 || idR < 1 || statusR < -1 || statusR > 0)
                    throw new MyExceptionErrorStructureBD("BD связь комнаты в отеле ");

                DAOhotel_rooms tmpU = new DAOhotel_rooms(id, idH, idR, statusR);
                lstDHR.add(tmpU);
            }
            br.close();
            fr.close();
        } catch (MyExceptionErrorStructureBD e0) {
            e0.printStackTrace();
        }

        //сначала сортируем - по убыванию - статус
        // по возрастанию код отеля и код команты
        Comparator<DAOhotel_rooms> comparator1 = (e1, e2) -> (e2.getStatus() - e1.getStatus());
        Comparator<DAOhotel_rooms> comparator2 = (e1, e2) -> (int) (e1.getIdHotel() - e2.getIdHotel());
        Comparator<DAOhotel_rooms> comparator3 = (e1, e2) -> (int) (e1.getIdRoom() - e2.getIdRoom());

        lstDHR.stream().sorted(comparator1.thenComparing(comparator2.thenComparing(comparator3)));

        return lstDHR;
    }

    //получение из файла списка забронированных комнат
    static public List<DAOUserRoomHotel> readUserRoomHotel() throws MyExceptionErrorStructureBD, IOException {
        List<DAOUserRoomHotel> lstURH = new ArrayList<>();

        File file = new File(Setting.NAME_OF_FILE_RESERVATION);
        if (!file.exists()) return lstURH;
        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
        ) {

// читаем построчно

            String line;
            while ((line = br.readLine()) != null) {
                Long id = Long.valueOf(line); //идентификатор
                line = br.readLine();
                Long idPointer1 = Long.valueOf(line); //указатель на комнату в отеле
                line = br.readLine();
                Long idPointer_idUsers = Long.valueOf(line);
                ; // указатель на пользователя
                line = br.readLine();
                int idDays = Integer.valueOf(line); //дата бронирования, вселения, выселения
                line = br.readLine();
                int statusR = Integer.valueOf(line);  //статус комнаты

                if (id < 0 || idDays < 1 || idDays > Setting.SIZEDISPLAYOUTPUTDATA || statusR < 0)
                    throw new MyExceptionErrorStructureBD("BD бронирования пользователем комнаты в отеле");

                DAOUserRoomHotel tmpU = new DAOUserRoomHotel(id, idPointer1, idPointer_idUsers, idDays, statusR);
                lstURH.add(tmpU);
            }
            br.close();
            fr.close();
        } catch (MyExceptionErrorStructureBD e0) {
            e0.printStackTrace();
        }

        lstURH.sort((e1, e2) -> (e1.getIdDays() - e2.getIdDays()));

        return lstURH;
    }

    //поиск по индентификатору, если ли такой отель
    static public boolean findIdbyHotel(List<Hotel> lstHotel, long idHotel) {
        // Find idHotel
        Optional<Hotel> anyidHotel = lstHotel.stream().filter((Hotel e) -> e.getIdH() == idHotel).findAny();
        if (anyidHotel.isPresent())
            return true;
        else
            return false;

    }

    //поиск по названию отеля, если ли такой отель
    static public List<Hotel> findNamebyHotel(List<Hotel> lstHotel, String isHotel) {
        String sques = "(.*)" + isHotel + "(.*)";


        List<Hotel> lstFound =

                lstHotel.stream().filter(e -> e.getNameH().matches(sques)).collect(Collectors.toList());
        return lstFound;
    }

    //поиск по городу отеля
    static public List<Hotel> findCitybyHotel(List<Hotel> lstHotel, City isCity) {

        List<Hotel> lstFound =
                lstHotel.stream().filter(e -> e.getCityH().equals(isCity)).collect(Collectors.toList());
        return lstFound;
    }

    //вываод отеля по индентификатору
    static public Hotel findHotelId(List<Hotel> lstHotel, long idHotel) {
        if (!findIdbyHotel(lstHotel, idHotel)) return null;
        List<Hotel> tmp0 = lstHotel.stream().filter(e -> e.getIdH() == idHotel).collect(Collectors.toList());
        Hotel tmp = tmp0.get(0);
        return tmp;
    }

    //поиск по индентификатору, если ли такая комната
    static public boolean findIdbyRoom(List<Room> lstRoom, long idRoom) {
        // Find Hotel
        Optional<Room> anyidRoom = lstRoom.stream().filter((Room e) -> e.getIdR() == idRoom).findAny();
        if (anyidRoom.isPresent())
            return true;
        else
            return false;

    }

    //вывод комнаты по индентификатору
    static public Room findRoomId(List<Room> lstRoom, long idRoom) {
        if (!findIdbyRoom(lstRoom, idRoom)) return null;
        List<Room> tmp0 = lstRoom.stream().filter(e -> e.getIdR() == idRoom).collect(Collectors.toList());
        Room tmp = tmp0.get(0);
        return tmp;
    }

    //вывод назания отеля по индентификатору
    static public String findnamebyHotel(List<Hotel> lstHotel, long idHotel) {
        // Find idHotel
        Optional<Hotel> anyidHotel = lstHotel.stream().filter((Hotel e) -> e.getIdH() == idHotel).findAny();
        if (anyidHotel.isPresent())
            return anyidHotel.get().getNameH();
        else
            return "-";

    }

    //поиск, если ли в отеле комнаты
    static public boolean findIdHotelbyHotel_rooms(List<DAOhotel_rooms> lstDHR, long idHotel, byte status) {
        //status = 0   - поиск всех неудаленных
        //       = 1   - поиск в том числе  удаленных
        //       = 2   - поиск только удаленных
        // Find idHotel
        boolean isfound = false;
        Optional<DAOhotel_rooms> anyidHotel;
        switch (status) {
            case 0:
                anyidHotel = lstDHR.stream().filter((DAOhotel_rooms e) ->
                        (e.getIdHotel() == idHotel && e.getStatus() == 0)).findAny();
                break;
            case 1:
                anyidHotel = lstDHR.stream().filter((DAOhotel_rooms e) -> e.getIdHotel() == idHotel).findAny();
                break;
            default:
                anyidHotel = lstDHR.stream().filter((DAOhotel_rooms e) ->
                        (e.getIdHotel() == idHotel && e.getStatus() == 2)).findAny();
        }


        isfound = anyidHotel.isPresent();
        return isfound;
    }

    //вывод номера комнаты по индентификатору
    static public int findNumberRoom(List<Room> lstr, long idr) {

        Optional<Room> anyidRoom = lstr.stream().filter(e -> e.getIdR() == idr).findFirst();

        if (anyidRoom.isPresent()) return anyidRoom.get().getNumberR();
        else
            return -1;

    }

    //вывод названия комнаты
    static public String findnameRoom(List<Room> lstr, long idr) {

        Optional<Room> anyidRoom = lstr.stream().filter(e -> e.getIdR() == idr).findFirst();

        if (anyidRoom.isPresent()) return anyidRoom.get().getNoticeR();
        else
            return "-";

    }

    //следующий номер
    static public long nextIdBD(List<?> bd) {
        return bd.size() + 1;
    }

    //поиск по индентификатору, если ли такая user
    static public boolean findIdbyUser(List<User> lstUser, long idUser) {
        // Find User
        Optional<User> anyidUser = lstUser.stream().filter((User e) -> e.getIdU() == idUser).findAny();
        if (anyidUser.isPresent())
            return true;
        else
            return false;

    }

    //вывод пользователя по индентификатору
    static public User findUserId(List<User> lstUser, long idUser) {
        if (!findIdbyUser(lstUser, idUser)) return null;
        List<User> tmp0 = lstUser.stream().filter(e -> e.getIdU() == idUser).collect(Collectors.toList());
        User tmp = tmp0.get(0);
        return tmp;
    }

}
