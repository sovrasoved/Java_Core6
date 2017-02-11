package module3.Task1;

/**
 * Created by sovra on 11.02.2017.
 */
public class Bird {

    private void sing(String sWhot) {
        System.out.println("I am " + sWhot);
    }

    public static void main(String[] args) {
        Bird bBird1 = new Bird();
        bBird1.sing("walking");
        bBird1.sing("flying");
        bBird1.sing("singing");
        bBird1.sing("Bird");
    }
}



