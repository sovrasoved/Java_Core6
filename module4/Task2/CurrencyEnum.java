package module4.Task2;

/**
 * Created by sovra on 24.02.2017.
 * Currency is an Enum with two values: USD, EUR
 */
public class CurrencyEnum {
    enum Currency {
        USD, EUR
    }

    public static void main(String[] args) {
//        output
        for (Currency curr : Currency.values()) {
            System.out.println(curr);
        }
    }
}
