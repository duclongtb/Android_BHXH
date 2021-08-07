package com.btl_nhom2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    ArrayList<user_detail> user_ = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_muc_dong);

        //fakeCSDL
        fakeCSDL fake = new fakeCSDL();
        user_ = fake.fakeuser_detail();
        
        imgBtnBack = findViewById(R.id.imgBack);
        imgBtnSearch = findViewById(R.id.imgSearch);
        editTxtSearch = findViewById(R.id.editTxtSearch);
        txtXemChiTiet = findViewById(R.id.txtXemChiTiet);
        listView = findViewById(R.id.lvTaiKhoan);
        
        danhsachtaikhoandangky_adapter adapter = new danhsachtaikhoandangky_adapter(this,
                R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
                fake.fakeusers());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle ViTri = new Bundle();
                ViTri.putInt("ViTri", i);
                Intent intent = new Intent(QuanLyMucDongActivity.this, ChiTietMucDongActivity.class);
                intent.putExtra("VITRI",ViTri);
                startActivity(intent);
            }
        });
        
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