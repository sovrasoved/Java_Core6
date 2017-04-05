package module6;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sovra on 21.03.2017.
 */
 public class ArraysUtils {

     private ArraysUtils() {
        //constructor default
    }

    public static int sum(int array[]) {
        int isum = 0;
        for (int i = 0; i < array.length; i++)
            isum += array[i];
        return isum;
    }

    public static int min(int array[]) {

        int imin = array[0];
        for (int i = 1; i < array.length; i++)
            if (imin > array[i]) imin = array[i];

        return imin;
    }

    public static int max(int array[]) {

        int imax = array[0];
        for (int i = 1; i < array.length; i++)
            if (imax < array[i]) imax = array[i];

        return imax;
    }

    public static int maxPositive(int array[]) {
        int imax = -1;

        for (int i = 0; i < array.length; i++)
            if (array[i] > 0 && imax < array[i]) imax = array[i];

        return imax;
    }

    public static int multiplication(int array[]) {

        int imul = array[0];
        for (int i = 1; i < array.length; i++)
            imul *= array[i];

        return imul;
    }

    public static int[] modulus(int array[]) {
        array[0] = Math.abs(array[0]);
        array[array.length - 1] = Math.abs(array[array.length - 1]);
        return array;
    }

    public static int secondLargest(int array[]) {

        int iMax = max(array);
        int iMaxLater = min(array);
        for (int i = 0; i < array.length; i++)
            if (iMax != array[i] & iMaxLater < array[i]) iMaxLater = array[i];

        return iMaxLater;
    }

    static int[] reverse(int[] array) {
        if (array.length <= 1 || array == null) return array;
        int ilenght = array.length / 2;
        for (int i = 0; i < ilenght; i++) {
            int zna = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = zna;
        }
        return array;
    }

    static int[] findEvenElements(int[] array) {
        int[] arrayx = new int[0];
        for (int i = 0; i < array.length; i++)
            if (array[i] % 2 == 0) arrayx = addarray(arrayx, array[i]);
        return arrayx;
    }

   static int[] addarray(int[] arrayx, int i) {
        int oldlenght = arrayx.length;
        int[] arr = new int[arrayx.length + 1];
        System.arraycopy(arrayx, 0, arr, 0, oldlenght);
        arr[oldlenght ] = i;
        return arr;
    }
}

