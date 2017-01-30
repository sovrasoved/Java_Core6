package module2;


public class hometask1 {


    public static void main(String[] args) {
        int[] iNewMas = new int[10];
        int[] iMas = {-1, 3, 5, 7, 9, 0, -2, -4, -8, 10};
        double[] dNewMas = new double[10];
        double[]dMas = {-10.4, -13.4, -45, 45, 12.3, 34.67, 51, -789.0, 34.6, 1.2};




        System.out.println("Summa of elements array_int = " + sum(iMas));
        System.out.println("Summa of elements array_double = " + sum(dMas));
        System.out.println("Min element of array_int = " + min(iMas));
        System.out.println("Min element of array_double = " + min(dMas));
        System.out.println("Max element of array_int = " + max(iMas));
        System.out.println("Max element of array_double = " + max(dMas));
        System.out.println("Max SecondLagest element of array_int = " + secondLargest(iMas));
        System.out.println("Max SecondLagest element of array_double = " + secondLargest(dMas));
        int iMaxPos = maxPositive(iMas);
        if (iMaxPos >= 0)
            System.out.println("Max positive element of array_int = " + iMaxPos);
        else
            System.out.println("Max positive is not found of array_int");

        double dMaxPos = maxPositive(dMas);
        if (dMaxPos >= 0)
            System.out.println("Max positive element of array_double = " + dMaxPos);
        else
            System.out.println("Max positive is not found of array_double");


        System.out.println("Mutliplication of array_int = " + multiplication(iMas));
        System.out.println("Mutliplication of array_double = " + multiplication(dMas));
        OutputArray(iMas);
        iNewMas = modulus(iMas);
        OutputArray(iNewMas);
        OutputArray(dMas);
        dNewMas = modulus(dMas);
        OutputArray(dNewMas);
    }


    private static void OutputArray(int array[]){
        int iSize = array.length-1;
        for (int i = 0; i < iSize ; i++) {
            System.out.print(array[i]+"  ");
        }
        System.out.println(array[array.length-1]);
    }
    private static void OutputArray(double array[]){
        int iSize = array.length-1;
        for (int i = 0; i < iSize ; i++) {
            System.out.print(array[i]+"  ");
        }
        System.out.println(array[array.length-1]);
    }
    public static int sum(int array[]) {
        int iSize = array.length;
        int isum = 0;
        for (int i = 0; i < iSize; i++) {
            isum += array[i];
        }
        return isum;
    }
    public static double sum(double array[]) {
        int iSize = array.length;
        double dsum = 0;
        for (int i = 0; i < iSize; i++) {
            dsum += array[i];
        }
        return dsum;
    }
    public static int min(int array[]) {
        int iSize = array.length;
        int imin = array[0];
        for (int i = 1; i < iSize; i++) {
            if (imin > array[i]) imin = array[i];
        }
        return imin;
    }
    public static double min(double array[]) {
        int iSize = array.length;
        double dmin = array[0];
        for (int i = 1; i < iSize; i++) {
            if (dmin > array[i]) dmin = array[i];
        }
        return dmin;
    }
    public static int max(int array[]) {
        int iSize = array.length;
        int imax = array[0];
        for (int i = 1; i < iSize; i++) {
            if (imax < array[i]) imax = array[i];
        }
        return imax;
    }
    public static double max(double array[]) {
        int iSize = array.length;
        double dmax = array[0];
        for (int i = 1; i < iSize; i++) {
            if (dmax < array[i]) dmax = array[i];
        }
        return dmax;
    }
    public static int maxPositive(int array[]) {
        int imax = -1;
        int iSize = array.length;
        for (int i = 0; i < iSize; i++) {
            if (array[i] > 0 && imax < array[i]) imax = array[i];
        }
        return imax;
    }
    public static double maxPositive(double array[]) {
        double dmax = -1;
        int iSize = array.length;
        for (int i = 0; i < iSize; i++) {
            if (array[i] > 0 && dmax < array[i]) dmax = array[i];
        }
        return dmax;
    }
    public static int multiplication(int array[]) {
        int iSize = array.length;
        int imul = array[0];
        for (int i = 1; i < iSize; i++) {
            imul *= array[i];
        }
        return imul;
    }
    public static double multiplication(double array[]) {
        int iSize = array.length;
        double dmul = array[0];
        for (int i = 1; i < iSize; i++) {
            dmul *= array[i];
        }
        return dmul;
    }
    public static int[] modulus(int array[]) {
        int iSize = array.length-1;
        array[0] = Math.abs(array[0]);
        array[iSize] = Math.abs(array[iSize]);
        return array;
    }
    public static double[] modulus(double array[]) {
        int iSize = array.length-1;
        array[0] = Math.abs(array[0]);
        array[iSize] = Math.abs(array[iSize]);
        return array;
    }
    public static int secondLargest(int array[]) {
        int iSize = array.length;
        int iMax = max(array);
        int iMaxLater = min(array);
           for (int i = 0; i < iSize; i++) {
            if (iMax != array[i] & iMaxLater < array[i] ) iMaxLater = array[i];
        }
        return iMaxLater;
    }
    public static double secondLargest(double array[]) {
        int iSize = array.length;
        double dMax = max(array);
        double dMaxLater = min(array);
               for (int i = 0; i < iSize; i++) {
            if (dMax != array[i] & dMaxLater < array[i] ) dMaxLater = array[i];
        }
        return dMaxLater;
    }

}

