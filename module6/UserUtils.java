package module6;

import java.util.Arrays;

/**
 * Created by sovra on 21.03.2017.
 */
public class UserUtils {

    User[] kill(User[] users, int ibegin) {
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
        if (users.length <= 1) return users;   //ничего не надо проверять

        for (int j = 0; j < users.length; j++)
            for (int i = j + 1; i < users.length; i++) {
                if (users[j].equals(users[i])) {
                    users = kill(users, i);
                    i--;
                }
            }
        return users;
    }

    //users are equal when all their field are equal
    User[] usersWithContitionalBalance(User[] users, int balance) {
        for (int i = 0; i < users.length; i++)
            if (users[i].balance != balance) {
                users = kill(users, i);
                i--;
            }
        if (users.length == 0) return null;
        else
            return users;
    }

    //user’s balance == balance
    final User[] paySalaryToUsers(User[] users) {
        for (User use : users)
            use.balance += use.salary;

        return users;
    }

    final long[] getUsersId(User[] users) {
        long[] tmplong = new long[users.length];
        int i = 0;
        for (User use : users)
            tmplong[i++] = use.id;

        return tmplong;
    }

    User[] deleteEmptyUsers(User[] users) {
        for (int i = 0; i < users.length; i++)
            if (users[i] == null) {
                users = kill(users, i);
                i--;
            }
        if (users.length == 0) return null;
        else
            return users;

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
