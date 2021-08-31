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
    ArrayList<users> usersArrayList = new ArrayList<users>();
    ArrayList<users> listTmp =new ArrayList<users>();
    danhsachtaikhoandangky_adapter adapter1;

    DBhelper db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_luong_huu);
        db =DBhelper.getInstance(this);

        imgBack = findViewById(R.id.imgBack);
        imgSearch = findViewById(R.id.imgSearch);
        editSearch = findViewById(R.id.editTxtSearch);
        listView = findViewById(R.id.lvLuongHuu);
        spnQLLuongHuu = findViewById(R.id.spnLuongHuu);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                arr_);
        // hiển thị danh sách spn
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        // thiết lập adapter cho spn
        spnQLLuongHuu.setAdapter(adapter);
        String itemspn = spnQLLuongHuu.getSelectedItem().toString();
        // when click spn
        spnQLLuongHuu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String itemspn = spnQLLuongHuu.getSelectedItem().toString();
                if(itemspn == "Đã nghỉ hưu"){
                    usersArrayList.clear();
                    if(db!=null){
                        listTmp = db.getAllInforLuongHuu1();
                        usersArrayList.addAll(listTmp);
                        danhsachtaikhoandangky_adapter  adapter1= new danhsachtaikhoandangky_adapter(
                                QuanLyLuongHuuActivity.this,
                                R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
                                usersArrayList);
                        listView.setAdapter(adapter1);
                        adapter1.notifyDataSetChanged();
                    }
                }
                if(itemspn == "Chưa nghỉ hưu"){
                    usersArrayList.clear();
                    if(db!=null){
                        listTmp = db.getAllInforLuongHuu2();
                        usersArrayList.addAll(listTmp);
                        danhsachtaikhoandangky_adapter  adapter1= new danhsachtaikhoandangky_adapter(
                                QuanLyLuongHuuActivity.this,
                                R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
                                usersArrayList);
                        listView.setAdapter(adapter1);
                        adapter1.notifyDataSetChanged();
                    }
                }
                if(itemspn == "Tất cả"){
                    usersArrayList.clear();
                    if(db!=null){
                        listTmp = db.getAllInfor();
                        usersArrayList.addAll(listTmp);
                        danhsachtaikhoandangky_adapter  adapter1= new danhsachtaikhoandangky_adapter(
                                QuanLyLuongHuuActivity.this,
                                R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
                                usersArrayList);
                        listView.setAdapter(adapter1);
                        adapter1.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                usersArrayList.clear();
                if (db != null) {
                    listTmp = db.getAllInfor();
                    usersArrayList.addAll(listTmp);
                    danhsachtaikhoandangky_adapter adapter1 = new danhsachtaikhoandangky_adapter(
                            QuanLyLuongHuuActivity.this,
                            R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
                            usersArrayList);
                    listView.setAdapter(adapter1);
                    adapter1.notifyDataSetChanged();
                }
            }
        });

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