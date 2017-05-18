package module6;


public class UserMain {
    public static void main(String[] args) {
        User[] users = new User[4]; //4 - for example
        users[0] = new User(1, "frDmitry", "lsSergievich", 1000, 25);
        users[1] = new User(2, "frIgor", "lsIvanovich", 1500, 100);
        users[2] = new User(3, "frOlga", "lsAntonovna", 2000, 1000);
        users[3] = new User(4, "frOlga", "lsAntonovna", 2000, 1000);

        UserUtils user1 = new UserUtils();
        user1.out(users);

        User[] users2 = user1.u_remove(users, 1);
        user1.out(users2);

        User[] users3 = user1.uniqueUsers(users);
        user1.out(users3);

        User[] users4 = user1.usersWithContitionalBalance(users, 99);
        user1.out(users4);
        users4 = user1.usersWithContitionalBalance(users, 100);
        user1.out(users4);

        User[] users5 = user1.paySalaryToUsers(users);
        user1.out(users5);

       long[] loondid = user1.getUsersId(users);
        for (long lng: loondid  )
            System.out.println(lng);

        User[] users6 = user1.deleteEmptyUsers(users);
        user1.out(users6);


    }
}
