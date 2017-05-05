package module10.first.hometask10;

public class MyIOException extends Exception {
  private String txt;

    public MyIOException()
    {
        System.out.println("Exception without parameters");
    }

    public MyIOException(String txt) {
        System.out.println("Exception with first parameters : " + txt);
        this.txt = txt;
    }

    public MyIOException(String message, String txt) {
        super(message);
        System.out.println("Exception with second parameters : ("+message+") (" + txt+ ")");
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }
}
