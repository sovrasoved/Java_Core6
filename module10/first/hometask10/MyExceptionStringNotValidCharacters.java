package module10.first.hometask10;

/**
 * Created by sovra on 05.05.2017.
 */
public class MyExceptionStringNotValidCharacters extends Exception {
    public MyExceptionStringNotValidCharacters(String message) {
        super(message);
        System.out.println("Third exception: "+message);
    }
}
