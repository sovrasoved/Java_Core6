package module2;

public class hometask4 {

    public static void main(String[] args) {
        /**
         * You need to write method which will fund (пополнение)
         * balance of particular user. Print name + balance after funding
         */

        int[] balances = {1200, 250, 2000, 500, 3200};
        String[] ownerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};

        // default data

        String ownerName  = "Jack";
        double withdrawal  = 100;
        int iindexOfArray = isName(ownerName, ownerNames);

        if (iindexOfArray==-1)
            System.out.println("Name "+ownerName+" not found in array");
        else
        {
            System.out.println("Output");
            System.out.println("--------");
            balances[iindexOfArray]+=(int) withdrawal;
            System.out.println(ownerNames[iindexOfArray] + "  " + balances[iindexOfArray]);

        }


    }



        public static int isName(String _sName, String []array){
            //found name in array
            int iSize = array.length;
            int iIndex=-1;
            for (int i = 0; i < iSize; i++) {
                if (array[i] == _sName)
                {
                    iIndex = i;
                    break;
                }
            }
            // -1   - not found name
            //  index of array
            return iIndex;
        }

}
