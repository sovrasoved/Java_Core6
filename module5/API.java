package module5;

public interface API {
    //    Создайте API интерфейс
    Room[] findRooms(int price, int persons, String city, String hotel);

    Room[] getallRecords();

}
