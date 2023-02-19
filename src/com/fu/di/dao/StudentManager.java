/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fu.di.dao;

import com.fu.di.dto.Student;
import com.fu.di.util.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toan0
 */
//This class will manages Student in class Student
public class StudentManager {

    private List<Student> stuList = new ArrayList<>();

    //Create data (fake DB base) => block of code
    {
        // floating block of code => moi lan new class => chay 1 dung lan duy
        stuList.add(new Student("SE161748", "NGUYEN DUC TOAN", 2008, 8.0, "SE"));
        stuList.add(new Student("SE161749", "NGUYEN HOANG DUONG", 2000, 9.0, "SE"));
        stuList.add(new Student("SS161750", "LE TRUNG HUNG", 2000, 8.2, "SS"));
        stuList.add(new Student("IA161751", "HO VAN DUNG", 2004, 8.0, "IA"));
        stuList.add(new Student("IA1617452", "DUONG TAN THINH", 2002, 8.5, "IA"));
        stuList.add(new Student("SS161753", "HOANG VAN TUNG", 2001, 8.8, "SS"));
    }

    //1. SHOW ALL STUDENT => SELECT * FROM
    public List<Student> getAll() {

        return stuList;
    }

    //2. IN RA DANH SACH CAC SINH VIEN THUOC NGANH SE => WHERE major = 'SE'
    public List<Student> getSEStudent() {
        List<Student> result = new ArrayList<>();
        for (int i = 0; i < stuList.size(); i++) {
            if (stuList.get(i).getMajor().equalsIgnoreCase("SE")) {
                result.add(stuList.get(i));
            }
        }
        return result;
    }

    //3. IN RA DANH SACH CAC SINH VIEN SE CO GPA >8.0
    public List<Student> getSEStudent8() {
        List<Student> result = new ArrayList<>();

        for (int i = 0; i < stuList.size(); i++) {
            Student x = stuList.get(i);
            if (x.getMajor().equalsIgnoreCase("SE") && x.getGpa() > 8.0) {
                result.add(x);
            }
        }
        return result;
    }

    //4. GOP NHIEU CAC DIEU KIEN => M MUON GI THI NOI DI 
    public List<Student> getStudents(int filterType) {
        List<Student> result = new ArrayList<>();
        switch (filterType) {
            case 1:
                result = stuList; //get all
                break;
            case 2:
                for (Student x : stuList) {
                    if (x.getMajor().equalsIgnoreCase("IA")) {
                        result.add(x);
                    }
                }
                break;
            case 3:
                for (Student x : stuList) {
                    if (x.getMajor().equalsIgnoreCase("SS") && x.getGpa() > 8) {
                        result.add(x);
                    }
                }
                break;
            default:
                System.out.println("PLS choose filterType form 1...3");
        }
        return result;
    }
    
    //SỬ DỤNG DI 

    public List<Student> getStudents(Filter<Student> filter) {
        // Create WishList
        List<Student> result = new ArrayList();
        for (Student x : stuList) {
            if (filter.check(x)) {
                result.add(x);
            }
        }
        return result;
    }
}
