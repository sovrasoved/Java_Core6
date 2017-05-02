package module10.first.hometask10;

/**
 * Created by sovra on 02.05.2017.
 */
public class Task2Exception {
    public static void main(String[] args) {
        try {
            System.out.println("Task2.  Throw MyIOException");
            throw new MyIOException("Task2 class MyIOException");
        }
        catch (MyIOException a){
            System.out.println("catch.  " + a.getTxt());

            a.printStackTrace();
        }
    }
}
