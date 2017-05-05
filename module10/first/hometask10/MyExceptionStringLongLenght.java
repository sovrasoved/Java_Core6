package module10.first.hometask10;

/**
 * Created by sovra on 05.05.2017.
 */
public class MyExceptionStringLongLenght extends Exception {
    public MyExceptionStringLongLenght(String message) {
        super(message);
        System.out.println("Second Exception: " + message);
    }
}
