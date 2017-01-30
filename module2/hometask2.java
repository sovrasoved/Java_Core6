package module2;

public class hometask2 {
    public static void main(String[] args) {

        /**Continue with BANK example
        *2.1 Write method which withdraws money from account and takes commision
        * 5% of the transaction. Print OK + commision + balance after withdrawal.
        * Print NO is withdrawal is not possible.*/


        double dBalance = 520.9;
        double dWithDrawal = 200;


        double dTmpPerevod = dWithDrawal * 1.05;
        System.out.println("Output");
        System.out.println("-------");

        if ((dBalance - dTmpPerevod)>0) {
            //yes
            System.out.println("OK " + (dWithDrawal*0.05) + " " + (dBalance - dTmpPerevod));
        }
        else
        {
            //no
            System.out.println("NO");
        }
    }

}
