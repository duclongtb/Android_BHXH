package com.btl_nhom2;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tai_khoan);

        //fakeCSDL
        fakeCSDL fake = new fakeCSDL();

        imgBtnBack = findViewById(R.id.imgBack);
        imgBtnSearch = findViewById(R.id.imgSearch);
        editTxtSearch = findViewById(R.id.editTxtSearch);
        listView = findViewById(R.id.lvTaiKhoan);

        danhsachtaikhoandangky_adapter adapter =
                new danhsachtaikhoandangky_adapter(QuanLyTaiKhoanActivity.this,
                        R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
                        fake.fakeusers());
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle ViTri = new Bundle();
                ViTri.putInt("GioiTinh", i);
                Intent intent = new Intent(QuanLyTaiKhoanActivity.this, ChiTietTaiKhoanActivity.class);
                intent.putExtra("GIOITINH",ViTri);
                startActivity(intent);
            }
        });

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
    }


    private void timTheoTen() {
    }
}