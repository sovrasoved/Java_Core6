package module3.task3;

/**
 * Created by sovra on 08.02.2017.
 */
public class Student {
    String firstName;
    String lastName;
    int group;
    Course[] coursesTaken;
    int age;

    @Override
    public String toString() {
        String strOut = "------------Student----------------";
        if (getFirstName() != null) strOut += "\nfirst name : " + getFirstName();
        if (getLastName() != null) strOut += "\nlast name :" + getLastName();
        strOut += "\ngroup :" + getGroup();
        strOut += "\nage :" + getAge();

        if (getCoursesTaken() != null) {
            for (Course co : coursesTaken) {
                strOut += "\n" + co.toString();
            }
        }
        strOut += "\n-----------------------------------\n";
        return strOut;
    }

    public Student(String firstName, String lastName, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public Student getStudent() {
        return this;
    }

    public Student(String lastName, Course[] coursesTaken) {
        this.lastName = lastName;
        this.coursesTaken = coursesTaken;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setGroup(int group) {
        this.group = group;
    }

    private void setCoursesTaken(Course[] coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGroup() {
        return group;
    }

    public Course[] getCoursesTaken() {
        return coursesTaken;
    }

    public int getAge() {
        return age;
    }
}
