package module7;

import java.util.Arrays;

/**
 * Created by sovra on 09.04.2017.
 */
public class User {
    long id;
    String firstName;
    String lastName;
    String city;
    int balance;


    public User(long id, String firstName, String lastName, String city, int balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", balance=" + balance +
                '}';
    }
}
