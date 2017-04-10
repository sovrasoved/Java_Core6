package module7;

import java.util.*;

/**
 * Created by sovra on 09.04.2017.
 */
public class Modu7main {
    final static int SIZE = 10;
    User m_user;
    Order m_order;


    public Modu7main(User m_user, Order m_order) {
        this.m_order = m_order;
        this.m_user = m_user;
    }

    static User[] createU() {
        User[] users = new User[SIZE];
        users[0] = new User(0, "Petro", "Sidorov", "Poltava", 2000);
        users[1] = new User(1, "Irina", "Sidorova", "Kiev", 4000);
        users[2] = new User(2, "Mikola", "Konstatinov", "Izum", 3500);
        users[3] = new User(3, "Serg", "Konstatinov", "Kharkov", 3500);
        users[4] = new User(4, "Valentina", "Konstatinova", "Izum", 7500);
        users[5] = new User(5, "Jra", "Izmailova", "Chutovo", 3500);
        users[6] = new User(6, "Ludmila", "Izmailova", "Dnepro", 9000);
        users[7] = new User(7, "Vladimir", "Pavlov", "Balaklea", 5000);
        users[8] = new User(7, "Vlada", "Pavlova", "Lvjiv", 5000);
        users[9] = new User(9, "Kostij", "Konstatinov", "Tepnopol", 10000);
        return users;
    }

    @Override
    public String toString() {
        return "Modu7main{" +
                "m_user=" + m_user +
                ", m_order=" + m_order +
                '}';
    }

    static Order[] createO() {
        Order[] orders = new Order[SIZE];
        orders[0] = new Order(0, 400, Currency.UAN, "brandy", "shop1");
        orders[1] = new Order(1, 200, Currency.UAN, "cheese", "shop1");
        orders[2] = new Order(2, 150, Currency.UAN, "strawberry", "shop1");
        orders[3] = new Order(3, 30, Currency.UAN, "banana", "shop1");
        orders[4] = new Order(4, 6, Currency.UAN, "carrot", "shop1");
        orders[5] = new Order(5, 30, Currency.UAN, "orange", "shop1");
        orders[6] = new Order(6, 30, Currency.UAN, "mandarine", "shop1");
        orders[7] = new Order(7, 150, Currency.UAN, "meat", "shop1");
        orders[8] = new Order(8, 100, Currency.UAN, "fish", "shop1");
        orders[9] = new Order(9, 50, Currency.UAN, "garlic", "shop1");
        return orders;
    }

    static List<Modu7main> createUO(User[] users, Order[] orders) {
        Modu7main[] mod7 = {
                new Modu7main(users[0], orders[0]),
                new Modu7main(users[1], orders[1]),
                new Modu7main(users[2], orders[2]),
                new Modu7main(users[3], orders[3]),
                new Modu7main(users[4], orders[4]),
                new Modu7main(users[5], orders[5]),
                new Modu7main(users[6], orders[6]),
                new Modu7main(users[7], orders[7]),
                new Modu7main(users[8], orders[8]),
                new Modu7main(users[9], orders[9]),
        };
        List<Modu7main> lstmod7 = Arrays.asList(mod7);
        return lstmod7;
    }

    private static TreeSet<Modu7main> createTS(User[] users, Order[] orders) {

        TreeSet<Modu7main> treeset = new TreeSet<Modu7main>(new ComparatorTreeSet());


        Modu7main[] mod7 = {
                new Modu7main(users[0], orders[0]),
                new Modu7main(users[1], orders[1]),
                new Modu7main(users[2], orders[2]),
                new Modu7main(users[3], orders[3]),
                new Modu7main(users[4], orders[4]),
                new Modu7main(users[5], orders[5]),
                new Modu7main(users[6], orders[6]),
                new Modu7main(users[7], orders[7]),
                new Modu7main(users[8], orders[8]),
                new Modu7main(users[9], orders[9]),
        };




        for (int i = 0; i < SIZE; i++)
            treeset.add(mod7[i]) ;


        System.out.println(treeset.size());
        return treeset;
    }

    public static void main(String[] args) {


        User[] users = createU();
        Order[] orders = createO();
        List<Modu7main> lstmd = createUO(users, orders);



//        отсортируйте список за ценой заказа по убыванию
        lstmd.sort(new Comparator<Modu7main>() {
            @Override
            public int compare(Modu7main o1, Modu7main o2) {
                if (o1.m_order.getPrice() > o2.m_order.getPrice()) return -1;
                else if (o1.m_order.getPrice() == o2.m_order.getPrice()) return 0;
                else
                    return 1;
            }
        });

        for (Modu7main var : lstmd)
            System.out.println("Price: " + var.m_order.getPrice());


        System.out.println(lstmd);

//        отсортируйте список за ценой заказа по возрастанию и за городом пользователя

        lstmd.sort(new Comparator<Modu7main>() {
            @Override
            public int compare(Modu7main o1, Modu7main o2) {
                if (o1.m_order.getPrice() > o2.m_order.getPrice()) return 1;
                else if (o1.m_order.getPrice() < o2.m_order.getPrice()) return -1;
                else {
                    String city = o1.m_user.getCity();
                    return city.compareTo(o2.m_user.getCity());
                }

            }
        });
        for (Modu7main var : lstmd)
            System.out.println("Price: " + var.m_order.getPrice() + " City: " + var.m_user.getCity());


        //   отсортируйте список за наименованием и идентификатором заказа,
        // и городом пользователя
        //

        lstmd.sort(new Comparator<Modu7main>() {
            @Override
            public int compare(Modu7main o1, Modu7main o2) {
                String names = o1.m_order.getItemName();
                int zna0 = names.compareTo(o2.m_order.getItemName());

                if (zna0 != 0) return zna0;
                names = o1.m_order.getShopIdentificator();
                zna0 = names.compareTo(o2.m_order.getShopIdentificator());
                if (zna0 != 0) return zna0;

                names = o1.m_user.getCity();
                zna0 = names.compareTo(o2.m_user.getCity());
                return zna0;
            }
        });
        for (Modu7main var : lstmd)
            System.out.println("ItemName: " + var.m_order.getItemName() + " Identificator: " + var.m_order.getShopIdentificator() + " City: " + var.m_user.getCity());





        TreeSet<Modu7main> treeset = createTS(users, orders);
        System.out.println(lstmd);

    }
}