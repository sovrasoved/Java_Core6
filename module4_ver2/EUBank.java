package module4_ver2;


public class EUBank extends Bank {
    private static final int limit_of_withdrawal_USD = 2000;
    private static final int limit_of_withdrawal_EUR = 2200;
    private static final int limit_of_funding_EUR = 20000;
    private static final int limit_of_funding__USD = 10000;
    private static final int monthly_rate_USD = 0;
    private static final int monthly_rate_EUR = 1;
    private static final int commission_USD_1000 = 5;
    private static final int commission_USD_after_1000 = 7;
    private static final int commission_EUR_1000 = 2;
    private static final int commission_EUR_after_1000 = 4;

    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    int getLimitOfWithdrawal() {
        if (this.getCurrency() == Currency.EUR)
            return limit_of_withdrawal_EUR;
        else
            return limit_of_withdrawal_USD;
    }

    @Override
    int getLimitOfFunding() {
        if (this.getCurrency() == Currency.EUR)
            return limit_of_funding_EUR;
        else
            return limit_of_funding__USD;

    }

    @Override
    int getMonthlyRate() {
        if (this.getCurrency() == Currency.EUR)
            return monthly_rate_EUR;
        else
            return monthly_rate_USD;
    }

    @Override
    int getCommission(int summ) {
        if (this.getCurrency() == Currency.EUR) {
            if (summ <= commission_EUR_1000)
                return   commission_EUR_1000;
            else
                return summ*commission_EUR_after_1000;
        }
        else {   //USD
            if (summ <= commission_USD_1000)
                return commission_USD_1000;
            else
                return commission_USD_after_1000;
        }

    }
}

