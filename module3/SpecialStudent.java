package module3;

/**
 * Created by sovra on 09.02.2017.
 */
public class SpecialStudent extends CollegeStudent {
    long secretKey;
    String email;

    public void showSpecialStudent() {
        System.out.println("------------SpecialStudent -----------");
        System.out.println("secretkey :" + getSecretKey());
        System.out.println("email" + getEmail());
        this.showCollegeStudent();
        System.out.println("--------------------------------------");
    }

    public SpecialStudent(String firstName, String lastName, int group, String collegeName, int rating, long id) {
        super(firstName, lastName, group, collegeName, rating, id);
    }

    public SpecialStudent(String firstName, String lastName, int group) {
        super(firstName, lastName, group);
    }

    public SpecialStudent(String firstName, String lastName, int group, String collegeName, int rating, long id, long secretKey) {
        super(firstName, lastName, group, collegeName, rating, id);
        this.secretKey = secretKey;
    }

    private long getSecretKey() {
        return secretKey;
    }

    private void setSecretKey(long secretKey) {
        this.secretKey = secretKey;
    }

    private String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }
}
