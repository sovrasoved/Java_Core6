package module8.HomeTask8;


import javax.swing.text.html.HTMLDocument;
import java.util.*;


/**
 * Created by sovra on 18.04.2017.
 */
public class IManageSystemRealisation<T extends Food & Comparable<T>> implements IManageSystem<T> {
    private Map<Food, Double> database = new HashMap<>();

    @Override
    public void printProductsSortedByName() {

        //convert to list
        List<Map.Entry<Food, Double>> lsttmp = new LinkedList<Map.Entry<Food, Double>>(database.entrySet());
        //sort
        Collections.sort(lsttmp, new Comparator<Map.Entry<Food, Double>>() {
            @Override
            public int compare(Map.Entry<Food, Double> o1, Map.Entry<Food, Double> o2) {
                 return o1.getKey().getName().compareTo(o2.getKey().getName());
            }
        });
//ПОДСКАЖИТЕ КАК ПО ДРУГОМУ С ПОМОЩЬЮ ИТЕРАТОРОВ
       Iterator<Map.Entry<Food, Double>> it1 = lsttmp.iterator();
        Iterator<Map.Entry<Food, Double>> it2 = lsttmp.iterator();
       while (it1.hasNext()){
           System.out.println(it1.next().getKey().getName()+"  "+it2.next().getValue());
       }

        for (Map.Entry<Food, Double>  itout: lsttmp ) {
            System.out.println(itout.getKey().getName() + " " + itout.getValue());
        }

    }

    @Override
    public void printProductsSortedByPrice() {

        //convert to list
        List<Map.Entry<Food, Double>> lsttmp = new LinkedList<Map.Entry<Food, Double>>(database.entrySet());
        //sort
        Collections.sort(lsttmp, new Comparator<Map.Entry<Food, Double>>() {
            @Override
            public int compare(Map.Entry<Food, Double> o1, Map.Entry<Food, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<Food, Double>  itout: lsttmp ) {
            System.out.println(itout.getKey().getName() + " " + itout.getValue());
        }

    }

    public void databaseout() {

        for (Food key : database.keySet()) {
            System.out.println(key + " cast: " + database.get(key));
        }
    }

    @Override
    public T save(T obj, double price) {
        int sizeobj = database.size();
        database.put(obj, price);
        if (sizeobj == database.size()) return null;
        return obj;
    }

    @Override
    public T save(T obj) {
        int sizeobj = database.size();
        database.put(obj, null);
        if (sizeobj == database.size()) return null;
        return obj;
    }

    @Override
    public void delete(T obj) {
        database.remove(obj);
    }

    @Override
    public void deleteById(int id) {

//А КАК СО СТРИМАМИ УДАЛИТЬ ИЛИ ПРЕДИКАТОМИ

        Set keys = database.keySet();

        Iterator<T> iterator = keys.iterator();
        while (iterator.hasNext()) {

            if (iterator.next().getId() == id) {
                iterator.remove();
                break;
            }

        }
    }

    @Override
    public T get(int id) {
        T obj;
        for (Map.Entry<Food, Double> entry : database.entrySet()) {
            if (entry.getKey().getId() == id) {
                obj = (T) entry.getKey();
                return obj;
            }

        }
        return null;

    }

    @Override
    public Double getPrice(T obj) {
        Double bdprice = database.get(obj);
        return bdprice;
    }

    @Override
    public Set<T> getProducts() {
        Set getprodu = database.keySet();
        return getprodu;
    }

    @Override
    public List<Double> getPrices() {
        Collection<Double> colvalues = database.values();
//        List<Double> lst = new ArrayList<Double>(colvalues);
return Collections.unmodifiableList(new ArrayList<Double>(colvalues));
       // System.out.println(lst);
//
//
//        return lst;
    }
}
