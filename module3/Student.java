package module3;

/**
 * Created by sovra on 08.02.2017.
 */
public class Student  {
    String firstName;
    String lastName;
    int group;
    Course[] coursesTaken;
    int age;

    public void showStudent(){
        System.out.println("------------Student----------------");
        System.out.println("first name : " + getFirstName());
        System.out.println("last name :" + getLastName());
        System.out.println("group :" +   getGroup() );
        System.out.println("age :" + getAge());

        for (Course co: coursesTaken   ) {
            co.showCourse();
        }
        System.out.println("-----------------------------------");
    }

    public Student(String firstName, String lastName, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
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
