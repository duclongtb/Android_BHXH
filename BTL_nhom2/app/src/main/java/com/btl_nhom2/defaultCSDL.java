package com.btl_nhom2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class defaultCSDL {
    ArrayList<users> usersArrayList = new ArrayList<>();
    ArrayList<user_detail> user_detailArrayList = new ArrayList<>();

    public ArrayList defaultUsers(){
        users u0 = new users(123450, "Nguyen Van A", "23/07/1950", 1, 1001001, "01241440", "Ha noi", 8000000);
        users u1 = new users(123450, "Nguyen Van B", "23/07/1955", 0, 1001002, "01241441", "Ha nam", 7000000);
        ContentValues ct = new ContentValues();
        ct.put("maBhxh", u0.maBHXH);
        ct.put("tenUser", u0.tenuser);
        ct.put("ngaySinh", u0.ngaysinh);
        ct.put("gioiTinh", u0.gioitinh);
        ct.put("soCmnd", u0.soCMND);
        ct.put("SDT", u0.SDT);
        ct.put("diaChi", u0.diachi);
        ct.put("mucLuong", u0.mucluong);

        ct.put("maBhxh", u1.maBHXH);
        ct.put("tenUser", u1.tenuser);
        ct.put("ngaySinh", u1.ngaysinh);
        ct.put("gioiTinh", u1.gioitinh);
        ct.put("soCmnd", u1.soCMND);
        ct.put("SDT", u1.SDT);
        ct.put("diaChi", u1.diachi);
        ct.put("mucLuong", u1.mucluong);
        return defaultUsers();
    }
}
