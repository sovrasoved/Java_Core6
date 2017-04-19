package module8.HomeTask8;


import java.util.*;

/**
 * Created by sovra on 18.04.2017.
 */
public class IdGenerator {

    private static Set<Integer> setid = new HashSet<>();
    private static int RANGE = 10;
    private static int RANGE0 = 0;


    public static int generationId() {
        Integer valuehash;
        int value1;
          while (true) {
            value1 = (int) (Math.random() * RANGE + RANGE0);
              valuehash = value1;
              valuehash = valuehash.hashCode();
            if (setid.add(valuehash)) //success add
            {
                break;   //while
            }
        }
        //проверка на наличие совпадений
        if (setid.size() == (RANGE - 1))
        {
            RANGE0=RANGE;  //нижняя граница
            RANGE*=2;       //предел случайных чисел
        }
        int value = value1;
        return value;
    }
}
