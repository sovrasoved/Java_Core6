package module8.HomeTask8;

import java.util.UUID;

/**
 * Created by sovra on 18.04.2017.
 */
public class Food {
    private int id; //product id
    String name;//name product
    Country country; //country product
    int expiration; //period of validity

    public Food(String name, Country country, int expiration) {
        this.name = name;
        this.country = country;
        this.expiration = expiration;
        this.id = IdGenerator.generationId();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;

        Food food = (Food) o;

        return id == food.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", expiration=" + expiration +
                '}';
    }

    //    public static void main(String[] args) {
//
//
////        for (int i = 0; i < 100; i++) {
////            int zna = IdGenerator.generationId();
////            System.out.println(zna);
////        }
//
//        for (int i = 0; i < 1000; i++) {
//            int zna = IdGenerator.generationId();
//            System.out.println(zna);
//        }
//    }
}
