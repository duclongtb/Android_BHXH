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
import android.widget.TextView;

import java.util.ArrayList;

public class QuanLyChiTra1LanActivity extends AppCompatActivity {

    ImageButton imgBack, imgSearch;
    EditText editSearch;
    ListView listView;
    Spinner spnQLChiTra;
    TextView txtDieuKienChiTra;
    String arr[]={"Tất cả",
            "Chưa trả",
            "Đã trả"};
    ArrayList<users> list = new ArrayList<users>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_chi_tra_1_lan);

        imgBack = findViewById(R.id.imgBack);
        imgSearch = findViewById(R.id.imgSearch);
        editSearch = findViewById(R.id.editTxtSearch);
        listView = findViewById(R.id.lvChiTra);
        spnQLChiTra = findViewById(R.id.spnQLChiTra);
        txtDieuKienChiTra = (TextView) findViewById(R.id.txtDieuKienNhanBHXH);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,arr);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnQLChiTra.setAdapter(adapter);

        spnQLChiTra.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        danhsachtaikhoandangky_adapter adapter1 = new danhsachtaikhoandangky_adapter(this,
//                R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
//                list);
//        listView.setAdapter(adapter1);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuanLyChiTra1LanActivity.this.finish();
            }
        });

        txtDieuKienChiTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuanLyChiTra1LanActivity.this, DieuKienTra1LanActivity.class);
                startActivity(intent);
            }
        });

        imgSearch.setOnClickListener(new View.OnClickListener() {
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