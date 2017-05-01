package module9;

import javafx.util.Pair;
import module7.Currency;
import module7.Modu7main;
import module7.Order;
import module7.User;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Created by sovra on 23.04.2017.
 */
public class HomeTask9 {


    public static void main(String[] args) {
        User[] users = Modu7main.createU();
        Order[] orders = Modu7main.createO(users);
        List<Order> lstmd = Modu7main.createUO(orders);

// 1.       отсортируйте список за ценой заказа по убыванию
        task1SortByPriceDown(lstmd);

// 2.       отсортируйте список за ценой заказа по возрастанию и за городом пользователя
        task2SortByPriceCityUp(lstmd);
// 3. отсортируйте список за наименованием товара, идентификатором заказа, и городом пользователя
        task3SortByNameIdentiTown(lstmd);

// 4.       удалите дублированные данные со списка
//ПО ВСЕМ ПОКАЗАТЕЛЯМ ДОЛЖНЫ УДАЛЯТЬСМЯ ДУБЛИРУРУЮЩИЕ ЗАПИСИ, ОДНАКО НЕ УДАЛЯЮТСЯ

        List<Order> lstNoDuplicate = task4RemoveDuplicate(lstmd);
        System.out.println("\nlist after remove");
        lstNoDuplicate.forEach(System.out::println);

//5.        удалите объекты, где цена меньше 1500    - у нас в примерах мах 400, поэтому удалим тольок меньше 150
        List<Order> lstRemove1500 = task5Remove1500(lstmd);

//6.        разделите список на 2 списка - заказы в долларах и в гривнах
        task6SplitPriceVality(lstmd);

//        7. разделите список на столько списков, сколько уникальных городов в User
        task7SplitCity(lstmd);

//8.        проверьте, содержит ли сет заказ, где фамилия пользователя - “Petrov”
        task8findLastName(lstmd, "Petrov");


//9.        удалите заказы в USD

        List<Order> lstNoUsd = task9removeUSD(lstmd);
    }

    private static List<Order> task9removeUSD(List<Order> lstmd1) {
        System.out.println("9. удалите заказы в USD");
        System.out.println("List before remove USD");
        lstmd1.forEach(System.out::println);
        List<Order> lstnew = new ArrayList<>(lstmd1);

        lstnew.removeIf(
                p -> {
                    return p.getCurrency() == Currency.USD;
                }
        );
        System.out.println("List after remove USD");
        lstnew.forEach(System.out::println);

        return lstnew;
    }

    private static void task8findLastName(List<Order> lstmd1, String lname) {
        System.out.println("8. проверьте, содержит ли сет заказ, где фамилия пользователя - 'Petrov'");

        if (lstmd1.stream().filter(p -> p.getUser_o().getLastName().equals(lname)).count() > 0) {
            System.out.println("Фамилия: " + lname);
            lstmd1.stream().filter(p -> p.getUser_o().getLastName().equals(lname)).collect(Collectors.toList()).forEach(System.out::println);

        } else {
            System.out.println("Not found family: " + lname);
        }


    }

    private static void task7SplitCity(List<Order> lstmd1) {
        System.out.println("7. разделите список на столько списков, " +
                "сколько уникальных городов в User");

        System.out.println(lstmd1.stream().collect(Collectors.groupingBy((Order p) ->
                p.getUser_o().getCity())));

        System.out.println(lstmd1.stream().collect(Collectors.groupingBy((Order p) ->
                p.getUser_o().getCity(), Collectors.counting())));


//        System.out.println(lstmd1.stream().collect(Collectors.partitioningBy((Order p) -> p.getUser_o().getCity().equals("Kharkov"), Collectors.mapping(p -> p.getUser_o().getCity(), Collectors.toList()))));


//        Map<Integer, List<Order>> groupCity =
//                lstmd1.stream().filter(l -> l.getPrice() == 30)
//                        .collect(Collectors.groupingBy(p -> p.getPrice()));
//        System.out.println(groupCity);

    }

    private static void task6SplitPriceVality(List<Order> lstmd1) {

        System.out.println("6. разделите список на 2 списка - заказы в долларах и в гривнах");

        System.out.println(lstmd1.stream().filter(
                p -> {
                    if (p.getCurrency() == Currency.UAN || p.getCurrency() == Currency.USD)
                        return true;
                    else return false;
                }
        ).collect(Collectors.
                groupingBy(Order::getCurrency)));


        System.out.println(lstmd1.stream().collect(Collectors.groupingBy(Order::getCurrency, Collectors.counting())));
//
//        List<Order> lstUSD = lstmd.stream().filter(e -> e.getCurrency() == Currency.USD).collect(Collectors.toList());
//        List<Order> lstUA = lstmd.stream().filter(e -> e.getCurrency() == Currency.UAN).collect(Collectors.toList());
//        System.out.println("Список 1 - USD");
//        lstUSD.forEach(System.out::println);
//        System.out.println("Список 2 - UAN");
//        lstUA.forEach(System.out::println);

    }

    private static List<Order> task5Remove1500(List<Order> lstmd1) {
        System.out.println("5. удалите объекты, где цена меньше 150");

        List<Order> tt = new ArrayList<>(lstmd1); //копия
        tt.forEach(System.out::println);

        tt.removeIf(p -> {
            return p.getPrice() < 150;
        });
        System.out.println("after");
        tt.forEach(System.out::println);

//2-вариант
//        Predicate<Order> preremove = p->p.getPrice()<1500;
//        tt.removeIf(preremove);
        return tt;
    }

    private static List<Order> task4RemoveDuplicate(List<Order> lstmd1) {

        System.out.println("4. удалите дублированные данные со списка");

        System.out.println("\nlist before");
        lstmd1.forEach(System.out::println);
        System.out.println("Size elements = " + lstmd1.size());


        //Set<Order> lst2 = new HashSet<>(lstmd1);
        //снова не срабатывает - добавляются дубли

        List<Order> lstNew = lstmd1.stream().distinct().collect(Collectors.toList());
        //вообщето почемуто не срабатывает
        return lstNew;

    }

    private static void task3SortByNameIdentiTown(List<Order> lstmd1) {
        System.out.println("3. сортировка список за наименованием товара, идентификатором заказа, и городом пользователя");
        Comparator<Order> compar31 = (e1, e2) -> (e1.getItemName().compareTo(e2.getItemName()));
        Comparator<Order> compar32 = (e1, e2) -> (e1.getShopIdentificator().compareTo(e2.getShopIdentificator()));
        Comparator<Order> compar33 = (e1, e2) -> (e1.getUser_o().getCity().compareTo(e2.getUser_o().getCity()));
        lstmd1.stream().sorted(compar31.thenComparing(compar32.thenComparing(compar33)))
                .map(p -> new Pair(p.getItemName(), new Pair(p.getShopIdentificator(), p.getUser_o().getCity())))
                .forEach(System.out::println);

    }

    private static void task2SortByPriceCityUp(List<Order> lstmd1) {
        System.out.println("2. отсортируйте список за ценой заказа по возрастанию и за городом пользователя");
        Comparator<Order> compar1 = (e1, e2) -> (e1.getPrice() - e2.getPrice());
        Comparator<Order> compar2 = (e1, e2) -> e1.getUser_o().getCity().compareTo(e2.getUser_o().getCity());

        lstmd1.stream().sorted(compar1.thenComparing(compar2))
                .map(e -> new Pair(e.getUser_o().getCity(), e.getPrice()))
                .forEach(System.out::println);

    }

    private static void task1SortByPriceDown(List<Order> lstmd1) {
        System.out.println("1. отсортируйте список за ценой заказа по убыванию ver");
        lstmd1.stream().sorted((e1, e2) -> -(e1.getPrice() - e2.getPrice()))
                .map(e -> new Pair(e.getItemName(), e.getPrice())).forEach(System.out::println);

    }

}
