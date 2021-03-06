package module6;

import java.util.Arrays;

/**
 * Created by sovra on 21.03.2017.
 */
public class UserUtils {


    User[] u_remove(User[] users, int ibegin) {
        System.out.println("Kill users id = " + ibegin);
        User[] x = new User[users.length - 1]; //tmp array
        if (ibegin == users.length - 1)
            System.arraycopy(users, 0, x, 0, users.length - 1);
        else if (ibegin == 0)
            System.arraycopy(users, 1, x, 0, users.length - 1);
        else {
            System.arraycopy(users, 0, x, 0, ibegin);
            int size = users.length - ibegin - 1;
            System.arraycopy(users, ibegin + 1, x, ibegin, size);
        }
        return x;
    }


    User[] uniqueUsers(User[] users) {
        System.out.println("Unique Users ");
        if (users.length <= 1) return users;   //ничего не надо проверять


        //Я УДАЛЯЮ ИЗ СУЩЕСТВУЮЩЕГО МАССИВА
        //А ЗАЧЕМ СОЗДАВАТЬ НОВЫЙ И ДОБАВЛЯТЬ ТУДА, А ПОТОМ УДАЛЯТЬ ПУСТЫЕ??????
        for (int j = 0; j < users.length; j++)
            for (int i = j + 1; i < users.length; i++) {
                if (users[j].equals(users[i])) {
                    users = u_remove(users, i);
                    i--;
                }
            }
        return users;
    }

    //users are equal when all their field are equal
    User[] usersWithContitionalBalance(User[] users, int balance) {
        System.out.println("usersWithContitionalBalance");
        for (int i = 0; i < users.length; i++)
            if (users[i].getBalance() != balance) {
                users = u_remove(users, i);
                i--;
            }
        if (users.length == 0) return null;
        else
            return users;
    }

    //user’s balance == balance
    final User[] paySalaryToUsers(User[] users) {
        System.out.println("paySalaryToUser");

        User[] newuser = new User[users.length];

        for (int i = 0; i < users.length; i++) {
            newuser[i] = new User(users[i].getId(),
                    users[i].getFirstName(),
                    users[i].getLastName(),
                    users[i].getSalary(),
                    users[i].getBalance()+users[i].getSalary());
        }

        return newuser;
    }

    final long[] getUsersId(User[] users) {
        System.out.println("getUsersId");
        long[] tmplong = new long[users.length];
        int i = 0;
        for (User use : users)
            tmplong[i++] = use.getId();

        return tmplong;
    }

    User[] deleteEmptyUsers(User[] users) {
        System.out.println("deleteEmptyUsers");
        for (int i = 0; i < users.length; i++)
            if (users[i] == null) {
                users = u_remove(users, i);
                i--;
            }
        if (users.length == 0) return null;
        else
            return users;

    }

    void out(User[] users){

        if (users == null) return;
        for ( User user1 : users ) {
            System.out.println(user1);
        }

    }
//    User[] deleteEmptyUsers(User[] users) {
//  two variant
//
//        for (int i = 0; i < users.length; i++)
//            if (users[i].balance == 0 &&
//                    users[i].salary == 0 &&
//                    users[i].firstName.length() == 0 &&
//                    users[i].lastName.length() == 0) {
//                users = kill(users, i);
//                i--;
//            }
//        if (users.length == 0) return null;
//        else
//            return users;
//
//    }
}
