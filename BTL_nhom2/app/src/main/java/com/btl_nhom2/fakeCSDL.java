package com.btl_nhom2;

import java.util.ArrayList;

public class fakeCSDL {
    ArrayList<users> usersArrayList = new ArrayList<>();
    ArrayList<user_detail> user_detailArrayList = new ArrayList<>();

    // fakeCSDL();
    public ArrayList fakeusers(){
        users u = new users(1,"Nguyễn Văn A","20/10/2000",true,123123123,"01241442","Hà Nội",8000000);
        users u1 = new users(2,"Nguyễn Văn B","20/10/2000",true,123123123,"01241442","Hà Nội",8000000);
        users u2 = new users(3,"Nguyễn Văn C","20/10/2000",false,123123123,"01241442","Hà Nội",8000000);
        users u3 = new users(4,"Nguyễn Văn D","20/10/1966",true,123123123,"01241442","Hà Nội",8000000);

        usersArrayList.add(u);
        usersArrayList.add(u1);
        usersArrayList.add(u2);
        usersArrayList.add(u3);
        return  usersArrayList;
    }

    public ArrayList fakeuser_detail() {
        user_detail u = new user_detail(1,"01/2020","06/2020","Đã đóng","Chưa trả","Chưa nghỉ hưu");
        user_detail u1 = new user_detail(1,"06/2020","12/2020","Đã đóng","Chưa trả","Chưa nghỉ hưu");
        user_detail u2 = new user_detail(1,"01/2021","06/2020","Chưa đóng","Chưa trả","Chưa nghỉ hưu");
        user_detail u3 = new user_detail(2,"01/2020","06/2020","Đã đóng","Chưa trả","Chưa nghỉ hưu");
        user_detail u4 = new user_detail(2,"06/2020","12/2020","Đã đóng","Chưa trả","Chưa nghỉ hưu");
        user_detail u5 = new user_detail(3,"02/2020","08/2020","Đã đóng","Chưa trả","Chưa nghỉ hưu");
        user_detail u6 = new user_detail(3,"08/2021","02/2021","Đã đóng","Chưa trả","Chưa nghỉ hưu");
        user_detail u7 = new user_detail(4,"02/2019","08/2019","Đã đóng","Chưa trả","Chưa nghỉ hưu");
        user_detail u8 = new user_detail(4,"08/2020","02/2020","Đã đóng","Chưa trả","Chưa nghỉ hưu");
        user_detail u9 = new user_detail(4,"02/2021","08/2021","Đã đóng","Chưa trả","Đã nghỉ hưu");

        user_detailArrayList.add(u);
        user_detailArrayList.add(u1);
        user_detailArrayList.add(u2);
        user_detailArrayList.add(u3);
        user_detailArrayList.add(u4);
        user_detailArrayList.add(u5);
        user_detailArrayList.add(u6);
        user_detailArrayList.add(u7);
        user_detailArrayList.add(u8);
        user_detailArrayList.add(u9);

        return  user_detailArrayList;
    }
}
