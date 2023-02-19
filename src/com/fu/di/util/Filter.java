/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fu.di.util;

import com.fu.di.dto.Student;

/**
 *
 * @author toan0
 */

//Dùng kĩ thuật GENERIC
// Biến datatype thành tham số => KO DÙNG KIEU DU LIEU LAM GIA TRI TRUYEN VAO
@FunctionalInterface //DÍNH DÁNG ĐẾN LAMDA EXPRESSION
                     // KÍ HIỆU INTERFACE NÀY CHỈ CÓ 1 HÀM
                     // ĐƯA HÀM VÀO TRONG HÀM KHÁC
/* 
TRUYỀN THAM TRỊ => PASS BY VALUE
void f(int x) => x ĐẠI DIỆN CHO 1 GIÁ TRỊ
*/

/* 
TRUYỀN THAM CHIẾU => PASS BY REFERENCE
void f(OBJECT x) => x ĐẠI DIỆN CHO 1 OBJECT => TRỎ ĐÉN ĐỊA CHỈ
*/

/* 
TRUYỀN DATATYPE => LINH HOẠT TRONG CÁCH TRUYỀN 
    => BIẾN TẤU ĐỂ TRUYỀN 2 THỨ TRÊN
void f(??? x) => x ỨNG VỚI DATATYPE ẤY
=> GENERIC
*/

/* 
TRUYỀN HÀM VÀO THAM SỐ => PASS BY FUNCTION
void f(??? x) => LAMDA EXPRESSION
*/
public interface Filter<T> {
    
    public boolean check(T x); //PROCEDURE PROGRAMMING
}
