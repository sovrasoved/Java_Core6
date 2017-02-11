package module3.task4;

/**
 * Created by sovra on 09.02.2017.
 */
public class User {

    String name;
    int balance;
    int monthsOfEmployment;
    String companyName;
    int salary;
    String currency;

    public User(String name, int balance, int monthsOfEmployment, String companyName, int salary, String currency) {
        this.name = name;
        this.balance = balance;
        this.monthsOfEmployment = monthsOfEmployment;
        this.companyName = companyName;
        this.salary = salary;
        this.currency = currency;
    }
    public void show(){
        System.out.println("--Task 4 for example--");
        System.out.println("name of fields: " + getName());
        System.out.println("balance of fields: " + String.valueOf(getBalance()));
        System.out.println("monthsofEmp of fileds: " + String.valueOf(getMonthsOfEmployment()));
        System.out.println("companyName of fileds: " + getCompanyName());
        System.out.println("salary of fields: " + String.valueOf(getSalary()));
        System.out.println("currency of fileds: "+getCurrency());
        System.out.println("------------------------------------");

}


    public void paySalary(){
//         that add salary to the balance of the user
        balance+=salary;
    }

    public int companyNameLenght(){
//         вычисляет длину имя компании
        return this.companyName.length();
    }

    public void withdraw(int summ){
//   снимает деньги с баланса с комиссией 5%, если сумма < 1000 и комиссией 10% в других случаях
        int itmpBalance = getBalance();

        double Commission;
        if (summ < 1000)  Commission=0.05;
        else Commission=0.1;
        Commission++;

        itmpBalance-=( (double)summ*Commission);

        if (itmpBalance<0)
            System.out.println("Error withdraw");
        else
            setBalance(itmpBalance);   //change balance

    }

    public void monthIncreaser(int addMonth){
//     увеличивает monthsOfEmployment на addMonth
        this.monthsOfEmployment+= addMonth;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMonthsOfEmployment() {
        return monthsOfEmployment;
    }

    public void setMonthsOfEmployment(int monthsOfEmployment) {
        this.monthsOfEmployment = monthsOfEmployment;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public static void main(String[] args) {
        User user1 = new User("name1", 80000, 2, "Luxor", 0, "not found");

        System.out.println("Default User");
        user1.show();
        System.out.print("Length of Company name :");
        System.out.println(String.valueOf(user1.companyNameLenght()));

        System.out.println("addMouthof + 10");
        user1.monthIncreaser(10);
        user1.show();

        System.out.println("add 8000");
        user1.setSalary(8000);  //add salary
        user1.show();
        user1.paySalary();
        user1.show();

        System.out.println("widthdraw 1000 + 5 commission");
        user1.withdraw(1000);  //widthdraw 1000  + 5 commission
        user1.show();

        System.out.println("widthdraw 5000 + 10 commission");
        user1.withdraw(5000);  //widthdraw 5000 + 10 commission
        user1.show();

    }

}
