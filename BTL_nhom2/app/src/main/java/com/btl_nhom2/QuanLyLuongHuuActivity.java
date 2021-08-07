package com.btl_nhom2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_luong_huu);

        //fakeCSDL
        fakeCSDL fake = new fakeCSDL();

        imgBack = findViewById(R.id.imgBack);
        imgSearch = findViewById(R.id.imgSearch);
        editSearch = findViewById(R.id.editTxtSearch);
        listView = findViewById(R.id.lvLuongHuu);
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

        danhsachtaikhoandangky_adapter adap =
                new danhsachtaikhoandangky_adapter(QuanLyLuongHuuActivity.this,
                        R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
                        fake.fakeusers());
        listView.setAdapter(adap);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle ViTri = new Bundle();
                ViTri.putInt("ViTri", i);
                Intent intent = new Intent(QuanLyLuongHuuActivity.this, ChiTietLuongHuuActivity.class);
                intent.putExtra("VITRI",ViTri);
                startActivity(intent);
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuanLyLuongHuuActivity.this.finish();
            }
        });
    }
}