package module3.task3;

/**
 * Created by sovra on 08.02.2017.
 */
public class CollegeStudent extends Student {
    //fields
    String collegeName;
    int rating;
    long id;

    @Override
    public String toString() {
        String strOut = "-----------CollegeStudent--------------";
        if (getCollegeName() != null) strOut += "\ncollegename :" + getCollegeName();
        strOut += "\nrating :" + getRating();
        strOut += "\nid :" + getId();
        strOut += "\n" + super.toString();
        strOut += "\n----------------------------------------";
        return strOut;
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
