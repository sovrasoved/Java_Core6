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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (balance != user.balance) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        return city != null ? city.equals(user.city) : user.city == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public String getLastName() {
        return lastName;
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
