package module8.HomeTask8;

import java.util.List;

/**
 * Created by sovra on 19.04.2017.
 */
public class ManageSystem {


    public static void main(String[] args) {
        IManageSystemRealisation bd = new IManageSystemRealisation();
        Food fd = new Food("carrot", Country.GERMANY, 22);
            bd.save(fd, 200);
        fd = new Food("tomates", Country.POLAND, 13);
            bd.save(fd, 15);

        fd = new Food("paprika", Country.USA, 50);
            bd.save(fd, 10);
        fd = new Food("meat", Country.CANADA, 25);
            bd.save(fd, 17);
        fd = new Food("chicken", Country.Nederland, 20);
            bd.save(fd, 8);
        fd = new Food("mollusca", Country.USA, 15);
            bd.save(fd, 12  );

            Food fdX = fd;
        fd = new Food("oysters", Country.Nederland, 30);
            bd.save(fd, 22  );

        bd.databaseout();






        bd.delete(fd);
        System.out.println("oysters");
        bd.databaseout();
        //append oysters
        bd.save(fd, 22  );

        System.out.println("remove id=3");
        bd.deleteById(3);
        bd.databaseout();
        System.out.println("get food id=5");
        fd = bd.get(5);
        System.out.println(fd);
        System.out.println("get price fdX - mollusca");
        System.out.println("price mollusca: "+ bd.getPrice(fdX));

        List<Double> getpricesBD = bd.getPrices();
        System.out.println(getpricesBD);

        System.out.println("Sort name product");
        bd.printProductsSortedByName();
        System.out.println("Sort cast product");
        bd.printProductsSortedByPrice();

    }
}
