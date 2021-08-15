package com.btl_nhom2;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
    ArrayList<users> usersArrayList = new ArrayList<users>();
    DBhelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tai_khoan);
        showUsers();
        //fakeCSDL
//        fakeCSDL fake = new fakeCSDL();
//        DBhelper MyDB = new DBhelper(getApplicationContext());
        imgBtnBack = findViewById(R.id.imgBack);
        imgBtnSearch = findViewById(R.id.imgSearch);
        editTxtSearch = findViewById(R.id.editTxtSearch);
        listView = findViewById(R.id.lvTaiKhoan);

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

    private void showUsers() {
        ArrayList<users> listTmp=new ArrayList<users>();
        DB =DBhelper.getInstance(this);
        listTmp=DB.getAllInfor("tblUsers");
        usersArrayList.addAll(listTmp);
        danhsachtaikhoandangky_adapter adapter =
                new danhsachtaikhoandangky_adapter(QuanLyTaiKhoanActivity.this,
                        R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
                        usersArrayList);
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
    }

    protected void initUser(){
        DBhelper MyDB = new DBhelper(getApplicationContext());
        final SQLiteDatabase sqlDB = MyDB.getWritableDatabase();
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
        sqlDB.insert(DBhelper.TABLE_USER, null, ct);
    }
    private void timTheoTen() {
    }
}