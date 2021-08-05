package com.btl_nhom2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class QuanLyMucDongActivity extends AppCompatActivity {

    ImageButton imgBtnBack, imgBtnSearch;
    EditText editTxtSearch;
    TextView txtXemChiTiet;
    ListView listView;
    ArrayList<users> list = new ArrayList<users>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_muc_dong);
        
        imgBtnBack = findViewById(R.id.imgBack);
        imgBtnSearch = findViewById(R.id.imgSearch);
        editTxtSearch = findViewById(R.id.editTxtSearch);
        txtXemChiTiet = findViewById(R.id.txtXemChiTiet);
        listView = findViewById(R.id.lvTaiKhoan);
        
//        danhsachtaikhoandangky_adapter adapter = new danhsachtaikhoandangky_adapter(this,
//                R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
//                list);
//        listView.setAdapter(adapter);
        
        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuanLyMucDongActivity.this.finish();
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