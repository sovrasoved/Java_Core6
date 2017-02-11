package module3.task3;


import java.util.Date;

/**
 * Created by sovra on 09.02.2017.
 */
public class Solution {

    public static void main(String[] args) {

        Date dDate1 = new Date();


        Course course1 = new Course(dDate1, "First object");
        Course course2 = new Course(2, "Second object", "TeacherName Second Object");
        Course course3 = new Course(dDate1, "Tree object");
        Course course4 = new Course(4, "Four object", "Teacher name Four object");
        Course course5 = new Course(5, "Five object", "Teacher name Five Object");


        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);
        System.out.println(course4);
        System.out.println(course5);

        Course[] courseArray = {course1, course2, course3, course4, course5};


        Student student1 = new Student("1Student_name01", "Student_name11", 6);
        System.out.println(student1);

        Student student2 = new Student("2Student21", courseArray);
        System.out.println(student2);


        CollegeStudent collegeStud1 = new CollegeStudent("col1", "col2", 3);
        System.out.println(collegeStud1);
        CollegeStudent collegeStud2 = new CollegeStudent("col11", courseArray);
        System.out.println(collegeStud2);
        CollegeStudent collegeStud3 = new CollegeStudent("col111", "col222", 333, "Col444", 555, 666);
        System.out.println(collegeStud3);

        SpecialStudent specialStudent1 = new SpecialStudent("1", "2", 3, "4", 5, 6);
        SpecialStudent specialStudent2 = new SpecialStudent("11", "22", 33);
        SpecialStudent specialStudent3 = new SpecialStudent( 999);
        System.out.println(specialStudent1);
        System.out.println(specialStudent2);
        System.out.println(specialStudent3);
    }
}
