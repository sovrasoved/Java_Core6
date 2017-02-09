package module3;

import java.util.Date;

/**
 * Created by sovra on 08.02.2017.
 */
public class Course {
    Date startDate;
    String name;
    int hoursDuration;
    String teacherName;

    public void showCourse(){

        System.out.println("------------Course--------------------");
        System.out.println("Date :" +  getStartDate().toString());
        System.out.println("name :" + getName());
        System.out.println("hours :" + getHoursDuration());
        System.out.println("teacher :" + getTeacherName());
        System.out.println("-----------------------------------------");
    }

    public Course(Date startDate, String name) {
        this.startDate = startDate;
        this.name = name;
    }

    public Course(int hoursDuration, String name,  String teacherName) {
        this.name = name;
        this.hoursDuration = hoursDuration;
        this.teacherName = teacherName;
    }

    private Date getStartDate() {
        if (startDate==null) {
            Date dd = new Date();
            return dd;
        }
        else return startDate;
    }

    private String getName() {
        return name;
    }

    private int getHoursDuration() {
        return hoursDuration;
    }

    private String getTeacherName() {
        return teacherName;
    }

    private void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setHoursDuration(int hoursDuration) {
        this.hoursDuration = hoursDuration;
    }

    private void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
