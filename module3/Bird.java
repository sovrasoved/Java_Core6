package module3;

/**
 * Created by sovra on 08.02.2017.
 */
public class Bird {
    private String sTypeBird;   //    type bird: flies, runs

    Bird() {   //constructure default
        sTypeBird = "";
    }

    public String getsTypeBird() {
        return sTypeBird;
    }


    public void setsTypeBird(String sTypeBird) {
        this.sTypeBird = sTypeBird;
    }

    public void showBird() {
        System.out.println("I am " + getsTypeBird());
    }

    public void sing(String sWhot) {
        setsTypeBird(sWhot);

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
            bBird1.showBird();
        }

    }
}
