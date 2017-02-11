package module3.Task1;

/**
 * Created by sovra on 11.02.2017.
 */
public class Bird {

        private void sing(String sWhot){
            System.out.println("I am " + sWhot);
        }
        public static void main(String[] args) {
           Bird  bBird1 = new Bird();
            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case 0:
                        bBird1.sing("walking");
                        break;
                    case 1:
                        bBird1.sing("flying");
                        break;
                    case 2:
                        bBird1.sing("singing");
                        break;
                    default:
                        bBird1.sing("Bird");
                }

            }

        }
    }



