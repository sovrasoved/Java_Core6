package module2;

public class hometask3 {
    public static void main(String[] args) {
        /**You need to write method which withdraw money of
         * particular account owner if he/she can.
         * Print name + NO of withdrawal fs not possible and name + sum of
         * withdrawal + balance after withdrawal in other case. Commision is 5% for all cases.
*/
         int[] iBalances = {1200, 250, 2000, 500, 3200};
         String[] sOwnerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};

// default data

         String stDefaultName = "Ann";
         double dWithDrawal = 50.0;
         int iindexOfArray = isName(stDefaultName, sOwnerNames);

         if (iindexOfArray==-1)
             System.out.println("Name "+stDefaultName+" not found in array");
         else{
             //-------------

             System.out.println("Output");
             System.out.println("-------");

             double dTmpPerevod = dWithDrawal * 1.05;

             System.out.print(sOwnerNames[iindexOfArray]+" ");
             double dresult = (double) iBalances[iindexOfArray] - dTmpPerevod;

             if (dresult>0)
                 System.out.println(dWithDrawal + " " + dresult);
             else
                 System.out.println("NO");

             //-------------
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
