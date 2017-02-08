package module3;

/**
 * Created by sovra on 08.02.2017.
 */
public class Adder extends Arithmetic {
    public boolean check(Integer a, Integer b){
        System.out.print("Class Adder check: ");
        return a>=b ? true:false;
    }


    public static void main(String[] args) {

        Arithmetic arith1 = new Arithmetic();
        System.out.println(arith1.add(10,5));
        Adder addre1 = new Adder();
        System.out.println(addre1.add(10, 5));
        System.out.println(addre1.check(10,5));

    }
}
