package FinalProject.WorkDAO;

import FinalProject.DAO.DAOUserRoomHotel;
import FinalProject.DAO.DAOhotel_rooms;
import FinalProject.DataA.City;
import FinalProject.DataA.Hotel;
import FinalProject.DataA.Room;
import FinalProject.DataA.User;
import FinalProject.Menu.Mainmenu;
import FinalProject.MyExceptionErrorStructureBD;
import javafx.util.Pair;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Menu.
 */


public class MenuHRU {
    //основное меню
    public static void menuM() throws MyExceptionErrorStructureBD, IOException {
        downloadBD();


        boolean flNoexit = true;

        while (flNoexit) {
            int zna = indexmenu("Основное меню", "Подготовительное заполнение БД",
                    "Заполнение базы данных Отель-Комнаты", "Бронирование по отелю", "Бронирование на конкретный день", "Виды поиска");
            switch (zna) {
                case 1: //populate the database - заполнение базы данных
                    menuPopulateDatabase();
                    break;
                case 2: //prepare BD
                    preparemenuBD();
                    break;
                case 3: // booking system - бронирование
                    menuBookingSystemByHotel();
                    break;
                case 4: // booking system - бронирование на определенный день
                    menuBookingSystemByDay();
                    break;
                case 5: // поиск
                    menuSeek();
                    break;
                default: //пользователи
                    flNoexit = false;
            }
        }
    }

    private static void menuSeek() {
        boolean fl_Noexit = true;
        while (fl_Noexit) {
            int zna = indexmenu("Введите вид поиска", "Поиск отеля по имени", "Поиск отеля по городу", "Поиск комнаты по отелю");

            switch (zna) {
                case 1: //Поиск отеля по имени
                    sub_menuSeek_SeekHotelbyName();
                    break;
                case 2: //Поиск отеля по городу
                    sub_menuSeek_SeekHotelbyCity();
                    break;
                case 3: //Поиск комнаты по отелю
                    sub_menuSeek_SeekRoombyHotel();
                    break;
                default:
                    fl_Noexit = false;

            }

        }


    }

    private static void sub_menuSeek_SeekRoombyHotel() {
        //список отелей
        String[] arh = prepareMnuHotel(Mainmenu.lstBDHotel);
        int zna = indexmenu("Выберити отель из списка", arh);
        if (zna == arh.length + 1) return;
        long idHotel = Mainmenu.lstBDHotel.get(zna - 1).getIdH();

        List<Long> lst = Mainmenu.lstDAOhr.stream().
                filter(e -> e.getIdHotel() == idHotel).map(e -> e.getIdRoom()).collect(Collectors.toList());
        for (Long lon : lst) {
            System.out.println(IODAO.findRoomId(Mainmenu.lstBDRoom, lon));
        }

    }

    private static void sub_menuSeek_SeekHotelbyCity() {
        //загружаем список городов

        String[] cities = prepareMnuCity();
        int zna = indexmenu("Введите код города ", cities);
        if (zna == cities.length + 1) return;
        System.out.println(City.valueOf(cities[zna - 1]));
        List<Hotel> lst = IODAO.findCitybyHotel(Mainmenu.lstBDHotel, City.valueOf(cities[zna - 1]));

        if (lst.size() == 0) System.out.println("Not found in Hotel -> " + cities[zna - 1]);
        else
            for (Hotel hotel : lst) {
                System.out.println(hotel);
            }


    }

    private static void sub_menuSeek_SeekHotelbyName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название отеля для поиска --> ");
        String nameHotel = in.nextLine();


        if (nameHotel.length() == 0) {
            System.out.println("Error seek");
            return;
        }
        List<Hotel> lst = IODAO.findNamebyHotel(Mainmenu.lstBDHotel, nameHotel);
        if (lst.size() == 0) System.out.println("Not found in Hotel -> " + nameHotel);
        else
            for (Hotel hotel : lst) {
                System.out.println(hotel);
            }

    }


    //бронирование по отелю
    private static void menuBookingSystemByHotel() {
        //1 -шаг - выбор отеля
        String[] arrH = prepareMnuHotel(Mainmenu.lstBDHotel);
        int zna = indexmenu("Введите номер отеля", arrH);
        if (zna == arrH.length + 1) return;

        Mainmenu.idHotelForChoice = Mainmenu.lstBDHotel.get(zna - 1).getIdH(); //id - Hotel

        List<Long> out_Rooms_from_Display =
                IODAO.viewRoom_Days(Mainmenu.lstBDHotel, Mainmenu.lstDAOhr, Mainmenu.lstDAOURH, Mainmenu.lstBDRoom, Mainmenu.idHotelForChoice);


        if (out_Rooms_from_Display.size() == 0) {
            System.out.println("Нет списка комнат для отеля");
            return;
        }

        //выбрать Room
        int numRoom = outNumberChoiceSize("Введите номер комнаты по порядку ", 1,
                out_Rooms_from_Display.size());
        if (numRoom == -1) return;

        //идентификатор комнаты
        long idRoom = out_Rooms_from_Display.get(numRoom - 1);

        //выбрать Day
        int numDays = outNumberChoiceSize("Введите день ", 1,
                Setting.SIZEDISPLAYOUTPUTDATA);
        if (numDays == -1) return;

        //выбрать User3

        int numUser = indexmenu("Выберите пользователя", prepareMnuUser(Mainmenu.lstBDUser));
        if (numUser == Mainmenu.lstBDUser.size() + 1) return;

        long idUser = Mainmenu.lstBDUser.get(numUser - 1).getIdU();
        //выбрать Что делать с номером
        int numValue = indexmenu("Выберите дейстие", "Бронирование", "Вселение", "Выселение", "Ремонт");
        if (numValue == 5) return;


        List<DAOUserRoomHotel> lstDURH1 =
                Mainmenu.lstDAOURH.stream().filter(e -> (e.getIdPointer_idBDDAOhotel_rooms() == idRoom &&
                        e.getIdDays() == numDays)).
                        collect(Collectors.toList());



        numValue--;
        if (lstDURH1.size() == 0) {
            if (numValue == 2) {
                System.out.println("Error action");
                return;
            }
            DAOUserRoomHotel d13 = new DAOUserRoomHotel(0, idRoom, idUser, numDays, numValue);
            long sizeid = IODAO.nextIdBD(Mainmenu.lstDAOhr);
            int sizetmp = Mainmenu.lstDAOURH.size() + 1;
            d13.setId((long) sizetmp);
            Mainmenu.lstDAOURH.add(d13);
            // 0 бронирование +
            // 1 вселение +
            // 2 выселение -
            // 3 ремонт    +
            //бронирование, вселение, ремонт
        } else {
            //выселение
            if (numValue != 2) {
                System.out.println("Error action");
                return;
            }
            //проверяем совпадение индентификаторов User
            if (idUser != lstDURH1.get(0).getIdPointer_idUsers()) {
                System.out.println("Error action - несовпадание пользователе");
                return;
            }
            long idFromRemove = lstDURH1.get(0).getId();
            //remove
            Mainmenu.lstDAOURH.removeIf(e -> e.getId() == idFromRemove); //удалили

        }

        int choice = indexmenu("Сохранить изменения в БД", "Да");
        if (choice == 1) IODAO.writeDAOUserRoomHotel(Mainmenu.lstDAOURH);
    }

    //бронирование по введенному дню*****************************************
    private static void menuBookingSystemByDay() {

        //1- шаг выбрать Day
        int numDays = outNumberChoiceSize("Введите день ", 1,
                Setting.SIZEDISPLAYOUTPUTDATA);
        if (numDays == -1) return;

        List<Pair<Long, Long>> out_idHotel_idRoom = new ArrayList<>();
        out_idHotel_idRoom =
                IODAO.viewRoom_Hotels(Mainmenu.lstBDHotel, Mainmenu.lstDAOhr, Mainmenu.lstDAOURH, Mainmenu.lstBDRoom, numDays);


        if (out_idHotel_idRoom.size() == 0) {
            System.out.println("Нет списка комнат для отеля");
            return;
        }
        //выбрать Room
        int numRoom = outNumberChoiceSize("Введите номер комнаты по порядку ", 1,
                out_idHotel_idRoom.size());
        if (numRoom == -1) return;
//идентификатор комнаты

        long idRoom = out_idHotel_idRoom.get(numRoom - 1).getValue();

        //идентификатор отеля
        long idHotel = out_idHotel_idRoom.get(numRoom - 1).getKey();

//                listHR.get(numRoom - 1).getIdRoom();
//выбрать User3
        int numUser = indexmenu("Выберите пользователя", prepareMnuUser(Mainmenu.lstBDUser));
        if (numUser == Mainmenu.lstBDUser.size() + 1) return;

        long idUser = Mainmenu.lstBDUser.get(numUser - 1).getIdU();
//выбрать Что делать с номером
        int numValue = indexmenu("Выберите дейстие", "Бронирование", "Вселение", "Выселение", "Ремонт");
        if (numValue == 5) return;


        List<DAOUserRoomHotel> lstDURH1 =
                Mainmenu.lstDAOURH.stream().filter(e -> (e.getIdPointer_idBDDAOhotel_rooms() == idRoom &&
                        e.getIdDays() == numDays &&
                        e.getStatusDAOUserRoomHotel() == 0)).
                        collect(Collectors.toList());
        numValue--;
        if (lstDURH1.size() == 0) {
            if (numValue == 2) {
                System.out.println("Error action");
                return;
            }
            DAOUserRoomHotel d13 = new DAOUserRoomHotel(0, idRoom, idUser, numDays, numValue);
            long  sizetmp = IODAO.nextIdBD(Mainmenu.lstDAOURH);
            d13.setId(sizetmp);
            Mainmenu.lstDAOURH.add(d13);
//            // 0 бронирование +
//            // 1 вселение +
//            // 2 выселение -
//            // 3 ремонт    +
//            //бронирование, вселение, ремонт
        } else {
            //выселение
            if (numValue != 2) {
                System.out.println("Error action");
                return;
            }
            //проверяем совпадение индентификаторов User
            if (idUser != lstDURH1.get(0).getIdPointer_idUsers()) {
                System.out.println("Error action - несовпадание пользователе");
                return;
            }
            long idFromRemove = lstDURH1.get(0).getId();
            //remove
            Mainmenu.lstDAOURH.removeIf(e -> e.getId() == idFromRemove); //удалили

        }

        int choice = indexmenu("Сохранить изменения в БД", "Да");
        if (choice == 1) IODAO.writeDAOUserRoomHotel(Mainmenu.lstDAOURH);
    }
    //основная загрузка БД

    private static void downloadBD() throws MyExceptionErrorStructureBD, IOException {
        Mainmenu.lstBDHotel = IODAO.readHotel();
        Mainmenu.lstBDRoom = IODAO.readRoom();
        Mainmenu.lstBDUser = IODAO.readUsers();
        Mainmenu.lstDAOhr = IODAO.readHotelRooms();
        Mainmenu.lstDAOURH = IODAO.readUserRoomHotel();

    }

    //Заполнение базы данных Отель-Комнаты
    public static void preparemenuBD() {
        boolean flNoexit = true;

        while (flNoexit) {
            int zna = indexmenu("Заполнение базы данных Отель-Комнаты", "Заполнение",
                    "Удаление комнат из отеля", "Вывод данных", "Сохранение в БД");
            switch (zna) {
                case 1: //выбор отеля из списка
                    menuChoiceHoteltoaddRoom();
                    break;
                case 2: //remove Hotel-> Rooms
                    menuRemoveRoomsfromHotel();
                    break;
                case 3: //prepare BD
                    menuoutputHoteltoRooms();
                    break;
                case 4: //save
                    write_DAOhoel_rooms();
                    break;
                default: //пользователи
                    flNoexit = false;
            }
        }
    }

    //удаление из отеля комнат
    private static void menuRemoveRoomsfromHotel() {
        String[] arrH = prepareMnuHotel(Mainmenu.lstBDHotel);
        int zna = indexmenu("Введите номер отеля", arrH);
        if (zna != arrH.length + 1) {
            Mainmenu.idHotelForChoice = Mainmenu.lstBDHotel.get(zna - 1).getIdH();
            menuRemoveListRoomsfromHotel(Mainmenu.idHotelForChoice);
        }

    }

    private static void menuRemoveListRoomsfromHotel(Long idHotelForChoice) {

        boolean flNoexit = true;
        Hotel tmp = IODAO.findHotelId(Mainmenu.lstBDHotel, idHotelForChoice);
        System.out.println("Hotel:");
        System.out.println(tmp);
        System.out.println("");

        List<Room> lstRoom = new ArrayList<>();
        List<Long> listidroom =
                Mainmenu.lstDAOhr.stream().filter(e -> e.getIdHotel() == idHotelForChoice).
                        map(DAOhotel_rooms::getIdRoom).collect(Collectors.toList());
        Iterator<Long> it = listidroom.iterator();
        while (it.hasNext()) {
            lstRoom.add(IODAO.findRoomId(Mainmenu.lstBDRoom, it.next()));
        }

        //int sizeRoom = lstRoom.size();
        String[] arrH = prepareMnuRoom(lstRoom);

        while (flNoexit) {
            int zna = indexmenu("Выберите номер комнаты для удаления с Отеля", arrH);
            if (zna == arrH.length + 1) //выход
                flNoexit = false;
            else {
                long idromm = lstRoom.get(zna - 1).getIdR(); //идентификатор комнаты

                System.out.println(Mainmenu.lstDAOhr);
                Mainmenu.lstDAOhr.removeIf((DAOhotel_rooms d) -> (d.getIdHotel() == idHotelForChoice
                        && d.getIdRoom() == idromm));
                flNoexit = false;
                System.out.println(Mainmenu.lstDAOhr);

            }
        }


    }

    //сохранение БД - Отель->комнаты
    private static void write_DAOhoel_rooms() {
        IODAO.writeDAOhotel_rooms(Mainmenu.lstDAOhr);
        System.out.println("Saves data success");
        System.out.println("\nInput 0 - Enter");
        Scanner scan = new Scanner(System.in);
        String number = scan.next();
    }

    //вывод на экран список - Отель - комнаты
    private static void menuoutputHoteltoRooms() {
        System.out.println("Список Отель с комнатами");
        for (Hotel hotel : Mainmenu.lstBDHotel) {
            if (hotel.getStatusH() == -1) continue;  //удаленные не выводим
            System.out.println(hotel);
            long idh = hotel.getIdH();
            //обращается к списку Отель-комнаты

            List<Long> listidroom =
                    Mainmenu.lstDAOhr.stream().filter(e -> e.getIdHotel() == idh).
                            map(DAOhotel_rooms::getIdRoom).collect(Collectors.toList());
            Iterator<Long> it = listidroom.iterator();
            while (it.hasNext()) {
                System.out.println(IODAO.findRoomId(Mainmenu.lstBDRoom, it.next()));
            }
        }
    }

    //выбор отеля из списка и выбор комнат в отель
    private static void menuChoiceHoteltoaddRoom() {
        String[] arrH = prepareMnuHotel(Mainmenu.lstBDHotel);
        int zna = indexmenu("Введите номер отеля", arrH);
        if (zna != arrH.length + 1) {
            Mainmenu.idHotelForChoice = Mainmenu.lstBDHotel.get(zna - 1).getIdH();
            menuChoiceRoomToAddHotel(Mainmenu.idHotelForChoice);
        }
    }

    //добавление комнат в отель
    private static void menuChoiceRoomToAddHotel(long idHotelForChoice) {
        boolean flNoexit = true;
        Hotel tmp = IODAO.findHotelId(Mainmenu.lstBDHotel, idHotelForChoice);
        System.out.println("Hotel:");
        System.out.println(tmp);
        System.out.println("");


        while (flNoexit) {
            //1 - output data BD
            List<Long> idRoomsFoundintoHotel = outputRoomsToHotel(idHotelForChoice);
//2 - remove idRoom from lsrBDRoom
            List<Room> listidRooms = prepareListRoomForBuilding(idRoomsFoundintoHotel);
            String[] arrH = prepareMnuRoom(listidRooms);
//            System.out.println();
            int zna = indexmenu("Добавление комнаты в отель", arrH);
            if (zna == arrH.length + 1) //выход
                flNoexit = false;
            else {
                long idromm = listidRooms.get(zna - 1).getIdR(); //идентификатор комнаты
                DAOhotel_rooms hrtmp = new DAOhotel_rooms
                        (0, idHotelForChoice, idromm, 0);
                saveDAOHotel_rooms(hrtmp);
                listidRooms.add(IODAO.findRoomId(Mainmenu.lstBDRoom, idromm));

                listidRooms.clear();
                listidRooms = prepareListRoomForBuilding(idRoomsFoundintoHotel);

                arrH = prepareMnuRoom(listidRooms);


            }
        }
    }

    //сохранение  в базе данных Отель - > комнаты
    private static void saveDAOHotel_rooms(DAOhotel_rooms hrtmp) {
        int size = Mainmenu.lstDAOhr.size();
        hrtmp.setIdBDDAOhotel_rooms(size + 1);
        Mainmenu.lstDAOhr.add(hrtmp);
    }

    //подготовка списка свободных комнат из БД Room для добавления в отель
    private static List<Room> prepareListRoomForBuilding(List<Long> idRoomsFoundintoHotel) {

        List<Room> lstidR = new ArrayList<>();
        Iterator<Room> it = Mainmenu.lstBDRoom.iterator();

        //System.out.println(idRoomsFoundintoHotel);

        while (it.hasNext()) {
            Room tmp = it.next();

            long idroom = tmp.getIdR();

            if (idRoomsFoundintoHotel.size() == 0 || !idRoomsFoundintoHotel.contains(idroom)) //не нашли
                lstidR.add(tmp);
        }
        return lstidR;
    }

    //Подготовка для вывода на экран ранее выбранных комнат в отеле и создание списка указателей этих комнат
    private static List<Long> outputRoomsToHotel(long idHotelForChoice) {

        List<Long> lstlongid = Mainmenu.lstDAOhr.stream().
                filter(e -> e.getIdHotel() == idHotelForChoice).map(DAOhotel_rooms::getIdRoom).collect(Collectors.toList());
        System.out.println(lstlongid);


        return lstlongid;
    }

    //подготовительная работа с базами данных - вывод, добавление, редактирование, удаления
    public static void menuPopulateDatabase() throws MyExceptionErrorStructureBD, IOException {


        boolean flNoexit = true;
        while (flNoexit) {
            int zna = indexmenu("Подготовительное заполнение базы данных",
                    "Добавить отель", "Удалить отель по номеру", "Редактировать отель по номеру",
                    "Вывести информацию об отелях", "Сохранить БД отелей",
                    "Добавить комнату", "Удалить комнату по индексу", "Редактировать комнату",
                    "Вывести информацию о комнатах", "Сохранить БД комнат",
                    "Зарегистрировать пользователя/заказчика",
                    "Удалить пользователя/заказчика", "Редактировать пользователя/заказчика",
                    "Вывести информация о пользователях", "Сохранить БД пользователей");
            switch (zna) {
                case 1:
                    addHotel(0, null);
                    break;
                case 2:
                    removeHotel();
                    break;
                case 3:
                    editHotel();
                    break;
                case 4:
                    outputHotel();
                    break;
                case 5:
                    saveBDHotel();
                    break;
                case 6:
                    addRoom(0, null);
                    break;
                case 7:
                    removeRoom();
                    break;
                case 8:
                    editRoom();
                    break;
                case 9:
                    outputRoom();
                    break;
                case 10:
                    saveBDRoom();
                    break;
                case 11:
                    addUser(0, null);
                    break;
                case 12:
                    removeUser();
                    break;
                case 13:
                    editUser();
                    break;
                case 14:
                    outputUser();
                    break;
                case 15:
                    saveBDUser();
                    break;
                default:
                    flNoexit = false;
            }
        }


    }

    //сохранение в текстовый файл списка пользователй
    private static void saveBDUser() {
        IODAO.writeUser(Mainmenu.lstBDUser);
        System.out.println("Saves data success");
        System.out.println("\nInput 0 - Enter");
        Scanner scan = new Scanner(System.in);
        String number = scan.next();
    }

    //редактирование пользователя
    private static void editUser() {

        String[] arrH = prepareMnuUser(Mainmenu.lstBDUser);
        int zna = indexmenu("Введите номер пользователя", arrH);
        if (zna > (Mainmenu.lstBDUser.size())) return;
        Mainmenu.lstBDUser.get(zna - 1).setNameU(
                Mainmenu.lstBDUser.get(zna - 1).getNameU() + "11");


        if (zna == arrH.length + 1) return;
        User tmp = IODAO.findUserId(Mainmenu.lstBDUser,  Mainmenu.lstBDUser.get(zna-1).getIdU());
        addUser(1, tmp);
    }

    //удаление пользователя
    private static void removeUser() {
        String[] arrH = prepareMnuUser(Mainmenu.lstBDUser);
        int zna = indexmenu("Введите номер пользователя", arrH);
        if (zna > (Mainmenu.lstBDUser.size())) return;
        Mainmenu.lstBDUser.get(zna - 1).setStatusU(-1);

    }

    //добавления пользователй
    private static void addUser(int whot, User tmp ) {

        //whot = 0 - ввод новых реквизитов отеля
        //      =1 редактирование
        System.out.println("Введите данные пользователя");
        Scanner in = new Scanner(System.in);

        mnuoutPoint("Наименование пользователя", (whot == 0) ? "" : tmp.getNameU());
        String nameU1 = in.nextLine();
        mnuoutPoint("Документы удостоверяющие личность", (whot == 0) ? "" : tmp.getDocumentsU());
        String documentsU = in.nextLine();
        mnuoutPoint("Иная информация о полдьзователе", (whot == 0) ? "" : tmp.getNoticeU());
        String noticeU = in.nextLine();


        int choice = indexmenu("Сохранить ?",  "Да");
        if (choice !=1) return;

        if (LogicalDAO.isName(nameU1) && LogicalDAO.isNotice(noticeU)) {
            User tmpu = new User(0, nameU1, documentsU, noticeU,0);
            long size =  IODAO.nextIdBD(Mainmenu.lstBDUser);
            if (whot==1){
                size = tmp.getIdU();
                int idint = (int) size;
                //удаляем запись с номером size
                Mainmenu.lstBDUser.removeIf(e->e.getIdU()==idint &&
                        e.getStatusU()==0);
            }
             tmpu.setIdU(size);

            Mainmenu.lstBDUser.add(tmpu);
        }
        else
        {
            System.out.println("Логический контроль не пройден");
        }

    }

    //сохранение в текстовый файл списка комнат
    private static void saveBDRoom() {
        IODAO.writeRoom(Mainmenu.lstBDRoom);
        System.out.println("Saves data success");
        System.out.println("\nInput 0 - Enter");
        Scanner scan = new Scanner(System.in);
        String number = scan.next();
    }

    //редактирование комнаты
    private static void editRoom() {
        String[] arrH = prepareMnuRoom(Mainmenu.lstBDRoom);
        int zna = indexmenu("Введите номер комнаты", arrH);
        if (zna == arrH.length + 1) return;
        Room tmp = IODAO.findRoomId(Mainmenu.lstBDRoom,  Mainmenu.lstBDRoom.get(zna-1).getIdR());
        addRoom(1, tmp);
    }

    //удаление комнаты
    private static void removeRoom() {
        String[] arrH = prepareMnuRoom(Mainmenu.lstBDRoom);

        int zna = indexmenu("Введите номер комнаты", arrH);
        if (zna > (Mainmenu.lstBDRoom.size())) return;
        Mainmenu.lstBDRoom.get(zna - 1).setStatusR(-1);

    }

    //добавления комнаты
    private static void addRoom(int whot , Room tmp) {
        //whot = 0 - ввод новых реквизитов комнаты
        //      =1 редактирование
        System.out.println("Введите реквизиты комнаты");

        Scanner in = new Scanner(System.in);

        mnuoutPoint("Номер комнаты  или по порядку ", (whot == 0) ? "" : String.valueOf(tmp.getNumberR()));
        String numberRS = in.nextLine();

        mnuoutPoint("Примечание", (whot == 0) ? "" : tmp.getNoticeR());
        String noticeR = in.nextLine();

        int choice = indexmenu("Сохранить ?",  "Да");
        if (choice !=1) return;

        if (LogicalDAO.isNotice(noticeR) && LogicalDAO.isEdrpou(numberRS)) {
            Room rom1 = new Room(0, Integer.valueOf(numberRS), noticeR,  0);
            long size =  IODAO.nextIdBD(Mainmenu.lstBDRoom);
            if (whot==1){
                size = tmp.getIdR();
                int idint = (int) size;
                //удаляем запись с номером size
                Mainmenu.lstBDRoom.removeIf(e->e.getIdR()==idint &&
                        e.getStatusR()==0);
            }
            rom1.setIdR(size);

            Mainmenu.lstBDRoom.add(rom1);
        }
        else
        {
            System.out.println("Логический контроль не пройден");
        }
    }

    //сохранение в текстовый файл списка отелей
    private static void saveBDHotel() {
        IODAO.writeHotel(Mainmenu.lstBDHotel);
        System.out.println("Saves data success");
        System.out.println("\nInput 0 - Enter");
        Scanner scan = new Scanner(System.in);
        String number = scan.next();
    }

    //удаления отеля
    private static void removeHotel() {

        String[] arrH = prepareMnuHotel(Mainmenu.lstBDHotel);

        int zna = indexmenu("Введите номер отеля", arrH);
        if (zna > (Mainmenu.lstBDHotel.size())) return;
        Mainmenu.lstBDHotel.get(zna - 1).setStatusH(-1);

    }

    //редактивароние овыбранного отеля
    private static void editHotel() {

        String[] arrH = prepareMnuHotel(Mainmenu.lstBDHotel);

        int zna = indexmenu("Введите номер отеля", arrH);
        if (zna == arrH.length + 1) return;
               Hotel ttmp0 = IODAO.findHotelId(Mainmenu.lstBDHotel, Mainmenu.lstBDHotel.get(zna-1).getIdH  ());
               addHotel(1, ttmp0);

    }

    private static Hotel characteristicHotel(String nameH, long edrpouH, City cityH,
                                             String addressH, String noticeH,
                                             int statusH) {
        Hotel tmp = new Hotel(0, nameH, edrpouH, cityH, addressH, noticeH, statusH);
        return tmp;
    }


    private static void mnuoutPoint(String st1, String st2) {
        if (st2.length() == 0)
            System.out.print(st1 + " -> ");
        else
            System.out.print(st1 + " (" + st2 + ")\n -> ");
    }

    //добавления - редатирования отеля
    private static void addHotel(int whot, Hotel tmp) {
        //whot = 0 - ввод новых реквизитов отеля
        //      =1 редактирование
        System.out.println("Введите реквизиты отеля");
        Scanner in = new Scanner(System.in);

        mnuoutPoint("Название отеля", (whot == 0) ? "" : tmp.getNameH());
        String nameH1 = in.nextLine();
        mnuoutPoint("Кoд ЕДРОПУ отеля", (whot == 0) ? "" : String.valueOf(tmp.getEdrpouH()));
        String edrpouHS = in.nextLine();

        String[] arh = prepareMnuCity();
        int zna = indexmenu("Выберите город", arh);
        if (zna== arh.length+1) return;

        mnuoutPoint("Юридический адрес", (whot == 0) ? "" : tmp.getAddressH());
        String addressH = in.nextLine();
        mnuoutPoint("Примечание", (whot == 0) ? "" : tmp.getNoticeH());
        String noticeH = in.nextLine();

        int choice = indexmenu("Сохранить ?",  "Да");
        if (choice !=1) return;


        if (LogicalDAO.isName(nameH1) && LogicalDAO.isNotice(noticeH) && LogicalDAO.isEdrpou(edrpouHS)) {
   Hotel htmp = new Hotel( 0, nameH1 , Long.valueOf(edrpouHS), City.valueOf(arh[zna - 1]),
                addressH, noticeH, 0);

                   long size =  IODAO.nextIdBD(Mainmenu.lstBDHotel);
                   if (whot==1){
                       size = tmp.getIdH();
                       int idint = (int) size;
                       //удаляем запись с номером size
                       Mainmenu.lstBDHotel.removeIf(e->e.getIdH()==idint &&
                       e.getStatusH()==0);
                   }
                    htmp.setIdH(size);

        Mainmenu.lstBDHotel.add(htmp);
        }
        else
        {
            System.out.println("Логический контроль не пройден");
        }

    }

    //вывод списка  пользователй
    private static void outputUser() {
        System.out.println("User");
        boolean fl = false;
        for (User user : Mainmenu.lstBDUser) {
            if (user.getStatusU()==-1){
                fl = true;
                continue;
            }
            System.out.println(user);
        }

        if (fl){
            System.out.println("Выводим удаленные");
            for (User user : Mainmenu.lstBDUser) {
                if (user.getStatusU()==-1)
                System.out.println(user);
            }
        }
        System.out.println("\nInput 0 Enter");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

    }

    //вывод списка комнат
    private static void outputRoom() {
        System.out.println("Room");
        boolean fl = false;
        for (Room room : Mainmenu.lstBDRoom) {
            if (room.getStatusR()==-1){
                fl = true;
                continue;
            }
            System.out.println(room);
        }
        if (fl){
            System.out.println("Выводим удаленные");
            for (Room room : Mainmenu.lstBDRoom) {
                if (room.getStatusR()==-1)   System.out.println(room);
            }

        }


        System.out.println("\nInput 1 - Enter ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

    }

    //вывод списка отелей
    private static void outputHotel() {
        System.out.println("Hotel");
        boolean fl = false;
        for (Hotel hotel : Mainmenu.lstBDHotel) {
            if (hotel.getStatusH()==-1){fl=true; continue;}
            System.out.println(hotel);
        }
        if(fl){
            System.out.println("Выводим удаленные");
            for (Hotel hotel : Mainmenu.lstBDHotel) {
                if (hotel.getStatusH()!=0) {
                    System.out.println(hotel);
                }
            }
        }

        System.out.println("\nInput 0 - Enter");
        Scanner scan = new Scanner(System.in);
        String number = scan.next();


    }

    //менюориентированный вывод списка
    public static int indexmenu(String s, String... sm) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        int imenu;
        boolean fl = true;
        while (fl) {
            imenu = 1;
            System.out.println(s);
            for (String subm : sm) {
                System.out.println(imenu++ + ". " + subm);
            }
            System.out.println(imenu + ". Выход");
            System.out.print("--->");
            choice = in.nextInt();
            if (choice >= 1 && choice <= imenu) break;
        }
        return choice;
    }

    //Вывод сообщения для ввода чисел в интервале...
    //-1 сброс
    public static int outNumberChoiceSize(String str, int first, int second) {
        int iExit = second + 1;
        int choice = 0;
        Scanner in = new Scanner(System.in);
        while (true) {
            String st1 = "(" + first + ".." + second + "   ";
            String st2 = Integer.toString(iExit) + "- выход) -> ";
            System.out.print(str + st1 + st2);
            choice = in.nextInt();
            if (choice >= first && choice <= iExit) break;
        }
        if (choice == iExit) return -1;
        return choice;
    }

    //подготовка для создание меню - списка комнат Room
    private static String[] prepareMnuRoom(List<Room> lr) {
        int sizeRoom = lr.size();
        String[] arrH = new String[sizeRoom];
        int index = 0;
        for (Room room : lr) {
            arrH[index] = "ind." + String.valueOf(room.getIdR()) + " №" + room.getNumberR() + " описание:" +
                    room.getNoticeR();
            index++;
        }
        return arrH;
    }

    //подготовка для создание меню - списка отелей Hotel
    private static String[] prepareMnuHotel(List<Hotel> lh) {
        int sizeHotel = lh.size();
        String[] arrH = new String[sizeHotel];
        int index = 0;
        for (Hotel hotel : lh) {
            if (hotel.getStatusH()!=0) continue;
            arrH[index] = "ind." + String.valueOf(hotel.getIdH()) + " назв. " +
                    hotel.getNameH() + " код." + String.valueOf(hotel.getEdrpouH() + " город " +
                    hotel.getCityH());
            index++;
        }
        return arrH;
    }
//подготовка вывода назания городов
    private static String[] prepareMnuCity(){
        //загружаем список городов
        String[] cities = new String[City.values().length];
        int i = 0;
        for (City city : City.values()) {
            cities[i] = city.name();
            i++;
        }
        return cities;
    }

    //подготовка для создание меню - списка пользователей User
    private static String[] prepareMnuUser(List<User> lu) {
        int sizeUser = lu.size();
        String[] arrH = new String[sizeUser];
        int index = 0;
        for (User user : lu) {
            arrH[index] = "ind." + String.valueOf(user.getIdU()) + " имя:" + user.getNameU() + " документ." +
                    user.getDocumentsU();
            index++;
        }
        return arrH;
    }


}
