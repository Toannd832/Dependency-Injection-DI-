/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package didemo;

import com.fu.di.dao.FilterBySE;
import com.fu.di.dao.StudentManager;
import com.fu.di.dto.Student;
import com.fu.di.util.Filter;
import java.util.List;

/**
 *
 * @author toan0
 */
public class DIDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StudentManager sm = new StudentManager();
        System.out.println("The list of avalable students");
        for (Student x : sm.getAll()) {
            x.showProfile();
        }
        System.out.println("The list of avalable students(3)");
        for (Student x : sm.getSEStudent()) {
            x.showProfile();
        }
        System.out.println("The list of avalable student SE have GPA > 8(1)");
        for (Student x : sm.getSEStudent8()) {
            x.showProfile();
        }
        testStudentManagerUsingSimpleFilter();

        testGetStudentByUsingDIAndConcreateClass();

        testGetStudentByUsingDIAndAnnonymousClass();

        testGetStudentByUsingDIAndLamdaExpression();
        
        testGetStudentByUsingDIAndLamdaExpressionV2();
    }

    public static void testStudentManagerUsingSimpleFilter() {
        StudentManager sm = new StudentManager();
        System.out.println("The list of avalable students");
        for (Student x : sm.getStudents(1)) {
            x.showProfile();
        }
        System.out.println("The list of avalable IAstudents(2)");
        for (Student x : sm.getStudents(2)) {
            x.showProfile();
        }
        System.out.println("The list of avalable student SS have GPA > 8(2)");
        for (Student x : sm.getStudents(3)) {
            x.showProfile();
        }

    }

    public static void testGetStudentByUsingDIAndConcreateClass() {
        //KHAI CHA NEW CON 
        //KHAI CON NEW CON 
        //KHAI CHA NEW CHA => ANNONYMUOS CLASS 
        StudentManager sm = new StudentManager();
        Filter<Student> filterBySE = new FilterBySE();
        List<Student> result = sm.getStudents(filterBySE); //DI ĐÃ DC ĐƯA VÀO THÀNH CÔNG

        System.out.println("DANH SÁCH SINH VIÊN SE");
        for (Student x : result) {
            x.showProfile();
        }
    }

    public static void testGetStudentByUsingDIAndAnnonymousClass() {
        //THAY VÌ CHÚ Ý VÀO TÊN CLASS CHỨA HÀM => TẬP TRUNG VÀO VIỆC LÀM HÀM CHỨA CODE
        //KO THÈM ĐẶT TÊN CLASS NHƯ TRUYỀN THỐNG
        //TRÁNH DC VIỆC TẠO RA THÊM 1 CLASS
        Filter<Student> filterBySEGt8 = (Student x) -> x.getMajor().equalsIgnoreCase("SS") && x.getGpa() >= 8;
        StudentManager sm = new StudentManager();
        List<Student> result = sm.getStudents(filterBySEGt8);
        System.out.println("The list of students SS having GPA >=8");
        for (Student x : result) {
            x.showProfile();
        }
    }

    public static void testGetStudentByUsingDIAndLamdaExpression() {

//         Filter<Student> filterByIA = (Student x) -> {return true;}; // Lamda 
//         Filter<Student> fileterByIA = x -> {return x.getMajor().equalsIgnoreCase("IA");}; 
        Filter<Student> fileterByIA = x -> x.getMajor().equalsIgnoreCase("IA");

        StudentManager sm = new StudentManager();
        List<Student> result = sm.getStudents(fileterByIA);
        System.out.println("The list of students IA");
        for (Student x : result) {
            x.showProfile();
        }
    }

    public static void testGetStudentByUsingDIAndLamdaExpressionV2() {

        Filter<Student> fileterByIA = x -> x.getMajor().equalsIgnoreCase("IA");

        StudentManager sm = new StudentManager();
        //TRUYEN TRUC TIEP KO THONG QUA OBJECT
//        List<Student> result = sm.getStudents(x -> {
//            return x.getMajor().equalsIgnoreCase("IA") && x.getGpa() < 8.5;
//        });
        List<Student> result = sm.getStudents(x -> x.getMajor().equalsIgnoreCase("IA") && x.getGpa() < 8.5);
        System.out.println("The list of students IA AND GPA<8,5");
        for (Student x : result) {
            x.showProfile();
        }
    }
}
