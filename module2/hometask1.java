package module2;


public class hometask1 {
    public static void main(String[] args) {
        int[] iNewMas = new int[10];
        int[] iMas = {-1, 3, 5, 7, 9, 0, -2, -4, -8, 10};


        System.out.println("Summa of elements array = " + sum(iMas));
        System.out.println("Min element of array = " + min(iMas));
        System.out.println("Max element of array = " + max(iMas));
        System.out.println("Max SecondLagest element of array = " + secondLargest(iMas));
        System.out.println("Max positive element of array = " + maxPositive(iMas));
        System.out.println("Mutliplication of array = " + multiplication(iMas));
        OutputArray(iMas);
        iNewMas = modulus(iMas);
        OutputArray(iNewMas);
    }
    private static void OutputArray(int array[]){
        for (int i = 0; i < 8 ; i++) {
            System.out.print(array[i]+"  ");

        }
        System.out.println(array[array.length-1]);
    }
    public static int sum(int array[]) {
        int isum = 0;
        for (int i = 0; i < 10; i++) {
            isum += array[i];
        }
        return isum;
    }
    public static int min(int array[]) {
        int imin = array[0];
        for (int i = 1; i < 10; i++) {
            if (imin > array[i]) imin = array[i];
        }
        return imin;
    }
    public static int max(int array[]) {
        int imax = array[0];
        for (int i = 1; i < 10; i++) {
            if (imax < array[i]) imax = array[i];
        }
        return imax;
    }
    public static int maxPositive(int array[]) {
        int imax = 0;
        for (int i = 0; i < 10; i++) {
            if (array[i] > 0 && imax < array[i]) imax = array[i];
        }
        return imax;
    }
    public static int multiplication(int array[]) {
        int imul = array[0];
        for (int i = 1; i < 10; i++) {
            imul *= array[i];
        }
        return imul;
    }
    public static int[] modulus(int array[]) {
        array[0] = Math.abs(array[0]);
        array[9] = Math.abs(array[9]);

        return array;
    }

    public static int secondLargest(int array[]) {

        int iMax = max(array);
        int iMaxLater = min(array);
        System.out.println("Max="+iMax+" min="+iMaxLater);
        for (int i = 0; i < 10; i++) {


            if (iMax != array[i] & iMaxLater < array[i] ) iMaxLater = array[i];

        }
        return iMaxLater;
    }

}

