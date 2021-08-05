package com.btl_nhom2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class QuanLyLuongHuuActivity extends AppCompatActivity {

    ImageButton imgBack, imgSearch;
    EditText editSearch;
    ListView listView;
    Spinner spnQLLuongHuu;
    String arr_[]={"Tất cả",
            "Đã nghỉ hưu",
            "Chưa nghỉ hưu"};
    ArrayList<users> list = new ArrayList<users>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_luong_huu);

        imgBack = findViewById(R.id.imgBack);
        imgSearch = findViewById(R.id.imgSearch);
        editSearch = findViewById(R.id.editTxtSearch);
        listView = findViewById(R.id.lvChiTra);
        spnQLLuongHuu = findViewById(R.id.spnLuongHuu);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                arr_);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnQLLuongHuu.setAdapter(adapter);

        spnQLLuongHuu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        danhsachtaikhoandangky_adapter userArrayList =
//                new danhsachtaikhoandangky_adapter(QuanLyLuongHuuActivity.this,
//                        R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
//                        list);
//        listView.setAdapter(userArrayList);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuanLyLuongHuuActivity.this.finish();
            }
        });
    }
}