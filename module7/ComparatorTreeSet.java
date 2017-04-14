package module7;

import java.util.Comparator;

/**
 * Created by sovra on 11.04.2017.
 */
public class ComparatorTreeSet implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {

        if (o1.getId()>o2.getId()) return 1;
        else if (o1.getId()<o2.getId()) return -1;

        if (o1.getPrice()>o2.getPrice()) return 1;
        else if (o1.getPrice()<o2.getPrice()) return -1;

        if (o1.getCurrency().ordinal() > o2.getCurrency().ordinal()) return 1;
        else if (o1.getCurrency().ordinal() < o2.getCurrency().ordinal()) return -1;

        return 0;

    }
}
