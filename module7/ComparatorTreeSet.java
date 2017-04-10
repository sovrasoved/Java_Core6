package module7;

import java.util.Comparator;

/**
 * Created by sovra on 11.04.2017.
 */
public class ComparatorTreeSet implements Comparator<Modu7main> {
    @Override
    public int compare(Modu7main o1, Modu7main o2) {
        String stree = o1.m_user.getFirstName();
        return stree.compareTo(o2.m_user.getFirstName());
    }
}
