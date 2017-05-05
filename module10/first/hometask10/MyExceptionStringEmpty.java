package module10.first.hometask10;

/**
 * Created by sovra on 04.05.2017.
 */
public class MyExceptionStringEmpty extends Exception {
    public MyExceptionStringEmpty(String message) {
                super(message);
        System.out.println("First Exception: " + message);
    }
}
