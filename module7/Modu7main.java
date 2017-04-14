package module7;

import sun.net.www.http.ChunkedOutputStream;

import java.util.*;

import static java.lang.Integer.compare;

/**
 * Created by sovra on 09.04.2017.
 */
public class Modu7main {
    final static int SIZE = 10;
    //    final static int SIZE_1_TEST = 2;
//    final static int SIZE_2_TEST = 5;
    final static int SIZE_1_TEST = 1000;
    final static int SIZE_2_TEST = 10000;

    static User[] createU() {
        User[] users = new User[SIZE];
        users[0] = new User(0, "Petro", "Sidorov", "Poltava", 2000);
        users[1] = new User(1, "Irina", "Sidorova", "Kiev", 4000);
        users[2] = new User(2, "Mikola", "Konstatinov", "Izum", 3500);
        users[3] = new User(3, "Serg", "Konstatinov", "Kharkov", 3500);
        users[4] = new User(4, "Valentina", "Konstatinova", "Izum", 7500);
        users[5] = new User(5, "Jra", "Izmailova", "Chutovo", 3500);
        users[6] = new User(6, "Ludmila", "Izmailova", "Dnepro", 9000);
        users[7] = new User(7, "Vladimir", "Petrov", "Balaklea", 5000);
        users[8] = new User(7, "Vlada", "Pavlova", "Lvjiv", 5000);
        users[9] = new User(9, "Kostij", "Konstatinov", "Tepnopol", 10000);
        return users;
    }

    static Order[] createO(User[] user_o) {
        Order[] orders = new Order[SIZE];
        orders[0] = new Order(0, 400, Currency.UAN, "brandy", "shop1", user_o[0]);
        orders[1] = new Order(1, 200, Currency.UAN, "cheese", "shop1", user_o[1]);
        orders[2] = new Order(2, 150, Currency.UAN, "strawberry", "shop1", user_o[2]);
        orders[3] = new Order(3, 30, Currency.UAN, "banana", "shop1", user_o[3]);
        orders[4] = new Order(4, 6, Currency.UAN, "carrot", "shop1", user_o[4]);
        orders[5] = new Order(5, 30, Currency.UAN, "orange", "shop1", user_o[5]);
        orders[6] = new Order(6, 30, Currency.UAN, "mandarine", "shop1", user_o[6]);
        orders[7] = new Order(7, 150, Currency.UAN, "meat", "shop1", user_o[7]);
        orders[8] = new Order(8, 100, Currency.UAN, "fish", "shop1", user_o[8]);
        orders[9] = new Order(9, 50, Currency.UAN, "garlic", "shop1", user_o[9]);
        return orders;
    }

    static List<Order> createUO(Order[] orders) {
        List<Order> lstmod7 = Arrays.asList(orders);
        return lstmod7;
    }

    private static TreeSet<Order> createTS(Order[] orders) {
        TreeSet<Order> treeset = new TreeSet<Order>(new ComparatorTreeSet());
        for (int i = 0; i < SIZE; i++)
            treeset.add(orders[i]);
        System.out.println(treeset.size());
        return treeset;
    }

    public static void main(String[] args) throws NoSuchFieldException {

        User[] users = createU();
        Order[] orders = createO(users);
        List<Order> lstmd = createUO(orders);

//        отсортируйте список за ценой заказа по убыванию
        lstmd.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if (o1.getPrice() > o2.getPrice()) return -1;
                else if (o1.getPrice() == o2.getPrice()) return 0;
                else
                    return 1;
            }
        });

//output to result
        for (Order var : lstmd)
            System.out.println("Price: " + var.getPrice());

//отсортируйте список за ценой заказа по возрастанию и за городом пользователя
        lstmd.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if (o1.getPrice() > o2.getPrice()) return 1;
                else if (o1.getPrice() < o2.getPrice()) return -1;
                String city = o1.user_o.getCity();
                return city.compareTo(o2.user_o.getCity());
            }
        });
//output to result
        for (Order var : lstmd)
            System.out.println("Price: " + var.getPrice() + " City: " + var.user_o.getCity());

//   отсортируйте список за наименованием и идентификатором заказа,
// и городом пользователя

        lstmd.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                String names = o1.getItemName();
                int zna0 = names.compareTo(o2.getItemName());

                if (zna0 != 0) return zna0;
                names = o1.getShopIdentificator();
                zna0 = names.compareTo(o2.getShopIdentificator());
                if (zna0 != 0) return zna0;

                names = o1.user_o.getCity();
                zna0 = names.compareTo(o2.user_o.getCity());
                return zna0;
            }
        });
        //output to result
        for (Order var : lstmd)
            System.out.println("ItemName: " + var.getItemName() + " Identificator: " + var.getShopIdentificator() + " City: " + var.user_o.getCity());


        //treeset  task 3

        TreeSet<Order> treeset = createTS(orders);
        System.out.println(lstmd);


//        Создайте 8 уникальных и 2 дублированых заказа


        Order order1 = new Order(10, 15, Currency.EURO, "Stuffed eggplant", "restaurant",
                new User(100, "Name100", "Fam100", "City100", 250));
        Order order2 = new Order(11, 20, Currency.EURO, "Rolls with salmon", "restaurant",
                new User(101, "Name101", "Fam101", "City101", 300));
        Order order3 = new Order(12, 10, Currency.UAN, "Stews Thai", "restaurant",
                new User(102, "Name102", "Fam102", "City102", 350));
        Order order4 = new Order(13, 32, Currency.USD, "Stuffed with shrimp pineapple", "restaurant",
                new User(104, "Name104", "Fam104", "City104", 400));
        Order order5 = new Order(14, 12, Currency.USD, "Chinese spring rolls", "restaurant",
                new User(105, "Name105", "Fam105", "City105", 450));
        Order order6 = new Order(15, 33, Currency.EURO, "Salmon in the oven in a wine and soy sauce", "restaurant",
                new User(106, "Name106", "Fam106", "City106", 500));
        ;
        Order order7 = new Order(16, 15, Currency.EURO, "Linguine with prawns", "restaurant",
                new User(107, "Name107", "Fam107", "City107", 500));
        Order order8 = new Order(17, 20, Currency.USD, "Steamed mussels with spinach and cherry tomatoes", "restaurant",
                new User(108, "Name108", "Fam108", "City108", 600));

        Order order01 = new Order(11, 20, Currency.EURO, "Rolls with salmon", "restaurant",
                new User(101, "Name101", "Fam101", "City101", 300));
        Order order02 = new Order(16, 15, Currency.EURO, "Linguine with prawns", "restaurant",
                new User(107, "Name107", "Fam107", "City107", 500));


        //СМОГ ТОЛЬКО ОСУЩЕСТВИТЬ ПОИСК ИЛИ ЧЕРЕЗ СТРИМ  ИЛИ ЧЕРЕЗ ИТЕРАТОР
        //ЧЕРЗ contains  НЕ ЗНАЮ КАК

        System.out.print("seek Petrov: ");
        //через стрим
        System.out.println((treeset.stream().filter(p -> p.getUser_o().getLastName().equals("Petrov")).count() == 1) ? "Yes" : "No");

//        System.out.println((treeset.stream().filter(p -> p.getItemName().equals("carrot")).count() == 1) ? "Нашли" : "Не нашли");


        boolean fname = false;
        for (Order oorder : treeset) {
            if (oorder.getUser_o().getLastName().equals("Petrov")) {
                fname = true;
                break;
            }
        }
        System.out.print("famyli Petrov is ");
        if (fname) System.out.println("found");
        else
            System.out.println("not found");


//        выведите заказ с наибольшей ценой, исспользуя только один сет-метод - get

        Order orderMax = treeset.stream().max((p1, p2) -> compare(p1.getPrice(), p2.getPrice())).get();
        System.out.print("Max price:");
        System.out.println(orderMax);

//        удалите заказы, где валюта доллар, используя Iterator

        Iterator<Order> it1 = treeset.iterator();
        while (it1.hasNext()) {

            if (it1.next().getCurrency() == Currency.USD) {
                it1.remove();
            }
        }
        System.out.println(treeset);

//task 4

        Long[] duration = whotTime();
        System.out.println("Test Integer:   ArrayList    LinkedList");
        System.out.println("1000   add\t\t" + duration[0] + "\t\t\t" + duration[8]);
        System.out.println("       set\t\t" + duration[1] + "\t\t\t" + duration[9]);
        System.out.println("       get\t\t" + duration[2] + "\t\t\t" + duration[10]);
        System.out.println("    remove\t\t" + duration[3] + "\t\t\t" + duration[11]);
        System.out.println("Test String:   ArrayList    LinkedList");
        System.out.println("1000   add\t\t" + duration[16] + "\t\t\t" + duration[24]);
        System.out.println("       set\t\t" + duration[17] + "\t\t\t" + duration[25]);
        System.out.println("       get\t\t" + duration[18] + "\t\t\t" + duration[26]);
        System.out.println("    remove\t\t" + duration[19] + "\t\t\t" + duration[27]);

        System.out.println("\nTest Integer:   ArrayList    LinkedList");
        System.out.println("10000  add\t\t" + duration[4] + "\t\t\t" + duration[12]);
        System.out.println("       set\t\t" + duration[5] + "\t\t\t" + duration[13]);
        System.out.println("       get\t\t" + duration[6] + "\t\t\t" + duration[14]);
        System.out.println("    remove\t\t" + duration[7] + "\t\t\t" + duration[15]);
        System.out.println("\nTest String:   ArrayList    LinkedList");
        System.out.println("10000  add\t\t" + duration[20] + "\t\t\t" + duration[28]);
        System.out.println("       set\t\t" + duration[21] + "\t\t\t" + duration[29]);
        System.out.println("       get\t\t" + duration[22] + "\t\t\t" + duration[30]);
        System.out.println("    remove\t\t" + duration[23] + "\t\t\t" + duration[31]);


    }

    private static Long[] whotTime() {
        Long[] durationAll = new Long[32];
        Long[] duration = new Long[16];
        duration = testList(0);
        System.arraycopy(duration, 0, durationAll, 0, 16);
        duration = testList("String");
        System.arraycopy(duration, 0, durationAll, 16, 16);
        return durationAll;
    }

    private static Long[] testList(String t) {
        ArrayList<String> arStrTest = new ArrayList<>();
        LinkedList<String> lslStrText = new LinkedList<>();

        Long[] durati = new Long[16];
        int choice = 0;
        for (int j = 0; j < 2; j++) {
            // j=0   ArrayList
            // j=1 LinkedList

            for (int size = 0; size < 2; size++) {
                int size1Test = (size == 0) ? SIZE_1_TEST : SIZE_2_TEST;

                for (int operation = 0; operation < 4; operation++) {
                    long startTime = System.nanoTime();
                    switch (operation) {
                        case 0: //add
                            if (j == 0) {
                                for (int i = 0; i < size1Test; i++)
                                    arStrTest.add(String.valueOf(i));
                            } else {
                                for (int i = 0; i < size1Test; i++)
                                    lslStrText.add(String.valueOf(i));
                            }
                            break;
                        case 1: //set
                            if (j == 0) {
                                for (int i = 0; i < size1Test; i++)
                                    arStrTest.set(i, String.valueOf(i));
                            } else {
                                for (int i = 0; i < size1Test; i++)
                                    lslStrText.set(i, String.valueOf(i));
                            }

                            break;
                        case 2: //get
                            if (j == 0) {
                                for (int i = 0; i < size1Test; i++)
                                    t = arStrTest.get(i);
                            } else {
                                for (int i = 0; i < size1Test; i++)
                                    t = lslStrText.get(i);
                            }

                            break;
                        default: //remove
                            if (j == 0) {
                                for (int i = size1Test - 1; i >= 0; i--)
                                    arStrTest.remove(i);
                            } else {
                                for (int i = size1Test - 1; i >= 0; i--)
                                    lslStrText.remove(i);
                            }

                    }

                    durati[choice] = System.nanoTime() - startTime;
                    choice++;
                }


            }
        }

        return durati;
    }

    private static Long[] testList(Integer t) {
        ArrayList<Integer> arStrTest = new ArrayList<>();
        LinkedList<Integer> lslStrText = new LinkedList<>();

        Long[] durati = new Long[16];
        int choice = 0;
        for (int j = 0; j < 2; j++) {
            // j=0   ArrayList
            // j=1 LinkedList

            for (int size = 0; size < 2; size++) {
                int size1Test = (size == 0) ? SIZE_1_TEST : SIZE_2_TEST;

                for (int operation = 0; operation < 4; operation++) {
                    long startTime = System.nanoTime();
                    switch (operation) {
                        case 0: //add
                            if (j == 0) {
                                for (int i = 0; i < size1Test; i++)
                                    arStrTest.add(i);
                            } else {
                                for (int i = 0; i < size1Test; i++)
                                    lslStrText.add(i);
                            }
                            break;
                        case 1: //set
                            if (j == 0) {
                                for (int i = 0; i < size1Test; i++)
                                    arStrTest.set(i, i);
                            } else {
                                for (int i = 0; i < size1Test; i++)
                                    lslStrText.set(i, i);
                            }

                            break;
                        case 2: //get
                            if (j == 0) {
                                for (int i = 0; i < size1Test; i++)
                                    t = arStrTest.get(i);
                            } else {
                                for (int i = 0; i < size1Test; i++)
                                    t = lslStrText.get(i);
                            }

                            break;
                        default: //remove
                            if (j == 0) {
                                for (int i = size1Test - 1; i >= 0; i--)
                                    arStrTest.remove(i);
                            } else {
                                for (int i = size1Test - 1; i >= 0; i--)
                                    lslStrText.remove(i);
                            }

                    }

                    durati[choice] = System.nanoTime() - startTime;
                    choice++;
                }
            }
        }
        return durati;
    }
}