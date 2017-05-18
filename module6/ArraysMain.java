package module6;

/**
 * Created by sovra on 21.03.2017.
 */
public class ArraysMain {

    public static void main(String[] args) {

        int a[] = {1, 2, 3, 4, 5,7,-9,-11,-6,10,-58};

        System.out.println("max = " + ArraysUtils.max(a));
        System.out.println("min = " + ArraysUtils.min(a));
        System.out.println("sum = " + ArraysUtils.sum(a));
        System.out.println("max positive  = " + ArraysUtils.maxPositive(a));
        System.out.println("multiplication  = " + ArraysUtils.multiplication(a));
        System.out.println("secondLargest  = " + ArraysUtils.secondLargest(a));
        System.out.println("modules (first, lsat elements)");
        int[] b = ArraysUtils.modulus(a);
             for (int y : b)
                System.out.print(y + " ");

        System.out.println("\nreverse");
        a = ArraysUtils.reverse(a);
        for (int y : b)
            System.out.print(y + " ");

        System.out.println("\nfindEvenElements");
        int[] c = ArraysUtils.findEvenElements(a);
        for (int y : c)
            System.out.print(y + " ");



    }
}
