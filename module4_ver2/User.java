package module4_ver2;

public class User {
    long id;
    String name;
    double balance;
    int monthsOfEmployment;
    String companyName;
    int salary;
    Bank bank;

    public User(long id, String name, double balance, int monthsOfEmployment, String companyName, int salary, Bank bank) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.monthsOfEmployment = monthsOfEmployment;
        this.companyName = companyName;
        this.salary = salary;
        this.bank = bank;
    }

    @Override
    public String toString() {
        String strtmp = "------------User--------------------";
        strtmp += "\nId : " + id;
        if (name != null && !name.isEmpty()) strtmp += "\nName : " + name;
        strtmp += "\nBalance : " + balance;
        strtmp += "\nMonthsOfEmployment : " + monthsOfEmployment;
        if (companyName != null && !companyName.isEmpty()) strtmp += "\nCompanyName : " + companyName;
        strtmp += "\nSalary : " + salary;

//        String strbank = "Bank: ";
//        if (bank.getBankCountry() != null && !bank.getBankCountry().isEmpty())
//            strbank += "\nBankCountry: " + bank.getBankCountry();
//        if (bank.getCurrency() != null) strbank += "\nCurrency :" + bank.getCurrency();
//        strbank += "\nNumberOfEmployees: " + bank.getNumberOfEmployees();
//        strbank += "AvrSalaryOfEmployee: " + bank.getAvrSalaryOfEmployee();
//        strbank += "\nRating: " + bank.getRating();
//        strbank += "\nTotalCapital: " + bank.getTotalCapital();
//
//        strtmp += strbank;

        return strtmp;
    }
}
