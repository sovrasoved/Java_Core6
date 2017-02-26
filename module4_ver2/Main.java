package module4_ver2;


public class Main {

    public static void main(String[] args) {

        USBank usbank1 = new USBank(1, "USA", Currency.USD, 100, 15000, 10, 55555000);
        USBank usbank2 = new USBank(2, "USA", Currency.USD, 150, 20000, 15, 60000000);

        ChinaBank chinabank1 = new ChinaBank(3, "China", Currency.USD, 500, 10000, 10, 1000000000);
        ChinaBank chinabank2 = new ChinaBank(4, "China", Currency.USD, 200, 15000, 15, 200000000);

        EUBank eubank1 = new EUBank(5, "Germany", Currency.EUR, 50, 75000, 20, 5000000);
        EUBank eubank2 = new EUBank(6, "France", Currency.EUR, 100, 70000, 20, 8000000);

        User user1 = new User(1,  "Sidorov", 500.0, 4, "RogaC", 1000, usbank1);
        User user2 = new User(2,  "Sidorova", 2500.0, 9, "Roga+C", 1500, usbank2);

        User user3 = new User(3,  "Ivanov", 0.0, 1, "StepC", 300, eubank1);
        User user4 = new User(4,  "Ivanova", 500.0, 6, "LStepC", 500, eubank2);

        User user5 = new User(5,  "Kazan", 2000, 12, "CWorld", 1000, chinabank1);
        User user6 = new User(6,  "Rostov", 1000, 2, "CLiga", 8000, chinabank2);

        System.out.println(user1);
        System.out.println(user2);

        BankSystemImpl bank1 = new BankSystemImpl();
        bank1.fundUser(user2, 100);
        System.out.println(user2);

        bank1.paySalary(user3);
        System.out.println(user3);

        System.out.println(user4);
        bank1.withdrawOfUser(user4,600);
        System.out.println(user4);
    }
}
