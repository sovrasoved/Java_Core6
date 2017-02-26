package module4_ver2;

/**
 * Created by sovra on 26.02.2017.
 */
public class BankSystemImpl implements BankSystem {
    @Override
    public void withdrawOfUser(User user, int amount) {
            Bank bank = user.bank;
            double moneycommission = (double) (bank.getCommission(amount)*amount)/100;
            if ((moneycommission+amount) > user.balance || moneycommission> bank.getLimitOfWithdrawal()   )
                System.out.println("Error withdrawal");
            else
                user.balance -= (moneycommission+amount);
    }

    @Override
    public void fundUser(User user, int amount) {
        user.balance += + (double) amount;
    }

    @Override
    public void transferMoney(User fromUser, User toUs, int amount) {
        Bank bank = fromUser.bank;
        double moneycommission = (double) (bank.getCommission(amount)*amount)/100;
        if ((moneycommission+amount) > fromUser.balance || moneycommission> bank.getLimitOfWithdrawal()   )
            System.out.println("Error transferMoney");
        else
        {
            toUs.balance+=amount;
            withdrawOfUser(fromUser, amount);
        }
    }

    @Override
    public void paySalary(User user) {
        int salary = user.salary;
        user.balance+=salary;
        System.out.println("Pay Salary good");
    }
}
