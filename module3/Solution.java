package module3;


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

        course1.showCourse();
        course2.showCourse();
        course3.showCourse();
        course4.showCourse();
        course5.showCourse();
        Course[] courseArray = {course1, course2, course3, course4, course5};


        Student student1 = new Student("1Student_name01", "Student_name11", 6);
        student1.showStudent();
        Student student2 = new Student("2Student21", courseArray);
        student2.showStudent();

        CollegeStudent collegeStud1 = new CollegeStudent("col1", "col2", 3);
        collegeStud1.showCollegeStudent();
        CollegeStudent collegeStud2 = new CollegeStudent("col11", courseArray);
        collegeStud2.showCollegeStudent();
        CollegeStudent collegeStud3 = new CollegeStudent("col111", "col222", 333, "Col444", 555, 666);
        collegeStud3.showCollegeStudent();

        SpecialStudent specialStudent1 = new SpecialStudent("1", "2", 3, "4", 5, 6);
        SpecialStudent specialStudent2 = new SpecialStudent("11", "22", 33);
        SpecialStudent specialStudent3 = new SpecialStudent("111", "222", 333, "444", 555, 666, 999);
specialStudent1.showCollegeStudent();
specialStudent2.showCollegeStudent();
specialStudent3.showCollegeStudent();
    }
}
