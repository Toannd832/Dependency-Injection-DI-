/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fu.di.dao;

import com.fu.di.dto.Student;
import com.fu.di.util.Filter;

/**
 *
 * @author toan0
 */
//Cách 1 : tạo 1 class rời => CONCRETE CLASS
public class FilterBySE implements Filter<Student> {

    @Override
    public boolean check(Student x) {

        return x.getMajor().equalsIgnoreCase("SE");
//        if(x.getMajor().equalsIgnoreCase("SE" == true)){
//            return true;
//        }
//        return false; 
    }

}
