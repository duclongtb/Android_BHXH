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
    ArrayList<users> listTmp =new ArrayList<users>();
    danhsachtaikhoandangky_adapter adapter;

    DBhelper db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tai_khoan);
        db =DBhelper.getInstance(this);
        //fakeCSDL
        if(db.getTotal()==0){
            db.insertInfor(new users(123450, "Nguyen Van Duc", "23/07/1950", 1, 1001001, "01241440", "Hà nội", 8000000,"Đã trả","Đã nghỉ hưu"));
            db.insertInfor(new users(123451, "Nguyen Thanh Thao", "23/07/1980", 0, 1001002, "01241441", "Hà nam", 7000000,"Chưa trả","Chưa nghỉ hưu"));
            db.insertInfor(new users(123452, "Nguyen Duc Nam", "23/07/1975", 1, 1001003, "01241442", "Nam định", 8000000,"Chưa trả","Chưa nghỉ hưu"));
            db.insertInfor(new users(123453, "Nguyen Thao Tam", "23/07/1955", 0, 1001004, "01241443", "Bắc Ninh", 9000000,"Chưa trả","Đã nghỉ hưu"));
        }
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
        if(db!=null){
            listTmp = db.getAllInfor();
            usersArrayList.addAll(listTmp);
            adapter = new danhsachtaikhoandangky_adapter(
                    QuanLyTaiKhoanActivity.this,
                    R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
                    usersArrayList);
            listView.setAdapter(adapter);
        }

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
    private void timTheoTen() {
//        if(db!=null){
//            String tenuser = editTxtSearch.getText() + "";
//            listTmp = db.getInforByID("tblUsers", "tenUser", tenuser);
////            usersArrayList.get(listTmp);
//            adapter = new danhsachtaikhoandangky_adapter(
//                    QuanLyTaiKhoanActivity.this,
//                    R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
//                    listTmp);
//            listView.setAdapter(adapter);
//        }
    }
}