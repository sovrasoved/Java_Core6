package module3;

/**
 * Created by sovra on 08.02.2017.
 */
public class CollegeStudent extends Student {
    //fields
    String collegeName;
    int rating;
    long id;

    public void showCollegeStudent() {
        System.out.println("-----------CollegeStudent--------------");
        System.out.println("collegename :" + getCollegeName());
        System.out.println("rating :" + getRating());
        System.out.println("id :" + getId());
        System.out.println("Student");
        this.showStudent();
        System.out.println("----------------------------------------");
    }


    public CollegeStudent(String firstName, String lastName, int group) {
        super(firstName, lastName, group);
    }

    public CollegeStudent(String lastName, Course[] coursesTaken) {
        super(lastName, coursesTaken);
    }

    public CollegeStudent(String firstName, String lastName, int group, String collegeName, int rating, long id) {
        super(firstName, lastName, group);
        this.collegeName = collegeName;
        this.rating = rating;
        this.id = id;
    }

    private String getCollegeName() {
        return collegeName;
    }

    private int getRating() {
        return rating;
    }

    private long getId() {
        return id;
    }

    private void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    private void setRating(int rating) {
        this.rating = rating;
    }

    private void setId(long id) {
        this.id = id;
    }
}
