package com.btl_nhom2;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuanLyTaiKhoanActivity extends AppCompatActivity {

    ImageButton imgBtnBack, imgBtnSearch;
    EditText editTxtSearch;
    TextView txtXemChiTiet;
    ListView listView;

    ArrayList<users> userArrayList = new ArrayList<users>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tai_khoan);

        imgBtnBack = findViewById(R.id.imgBack);
        imgBtnSearch = findViewById(R.id.imgSearch);
        editTxtSearch = findViewById(R.id.editTxtSearch);
        txtXemChiTiet = findViewById(R.id.txtXemChiTiet);
        listView = findViewById(R.id.lvTaiKhoan);

       // fakeCSDL();
        users u = new users(1,"Nguyễn Văn A","20/10/2000",true,123123123,"01241442","Hà Nội",8000000,"02/2020","08/2020","Đã đóng","Chưa trả","Chưa nghỉ hưu");
        users u1 = new users(2,"Nguyễn Văn B","20/10/2000",true,123123123,"01241442","Hà Nội",8000000,"02/2020","08/2020","Đã đóng","Chưa trả","Chưa nghỉ hưu");
        users u2 = new users(3,"Nguyễn Văn C","20/10/2000",false,123123123,"01241442","Hà Nội",8000000,"02/2020","08/2020","Đã đóng","Chưa trả","Chưa nghỉ hưu");
        users u3 = new users(4,"Nguyễn Văn D","20/10/2000",true,123123123,"01241442","Hà Nội",8000000,"02/2020","08/2020","Đã đóng","Chưa trả","Chưa nghỉ hưu");

        userArrayList.add(u);
        userArrayList.add(u1);
        userArrayList.add(u2);
        userArrayList.add(u3);

        danhsachtaikhoandangky_adapter adapter =
                new danhsachtaikhoandangky_adapter(QuanLyTaiKhoanActivity.this,
                        R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
                        userArrayList);
        listView.setAdapter(adapter);


        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuanLyTaiKhoanActivity.this.finish();
            }
        });

        imgBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timTheoTen();
            }
        });

//      Lỗi
//        txtXemChiTiet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }


    private void timTheoTen() {
    }
}