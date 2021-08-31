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
    ArrayList<users> usersArrayList = new ArrayList<users>();
    ArrayList<users> listTmp =new ArrayList<users>();
    danhsachtaikhoandangky_adapter adapter;

    ArrayList<user_detail> usersDetailArrayList = new ArrayList<user_detail>();
    ArrayList<user_detail> listTmp1 =new ArrayList<user_detail>();
    chitietmucdong_adapter adapter1;
    DBhelper db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_muc_dong);
        db =DBhelper.getInstance(this);

        imgBtnBack = findViewById(R.id.imgBack);
        imgBtnSearch = findViewById(R.id.imgSearch);
        editTxtSearch = findViewById(R.id.editTxtSearch);
        txtXemChiTiet = findViewById(R.id.txtXemChiTiet);
        listView = findViewById(R.id.lvTaiKhoan);

        if(db!=null){
            listTmp = db.getAllInfor();
            usersArrayList.addAll(listTmp);
            adapter = new danhsachtaikhoandangky_adapter(
                    QuanLyMucDongActivity.this,
                    R.layout.activity_danh_sach_tai_khoan_dang_ky_lvitem,
                    usersArrayList);
            listView.setAdapter(adapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if(db.getTotalDetail()==0){
//            db.insertInforDetail(new user_detail("01/2018","06/2018","Đã đóng",1600000, 123450));
//            db.insertInforDetail(new user_detail("07/2018","12/2018","Đã đóng",1600000, 123450));
//            db.insertInforDetail(new user_detail("01/2019","06/2019","Đã đóng",1600000, 123450));
//            db.insertInforDetail(new user_detail("01/2018","06/2018","Đã đóng",1600000, 123451));
//            db.insertInforDetail(new user_detail("07/2028","12/2018","Chưa đóng",1600000, 123451));
//            db.insertInforDetail(new user_detail("01/2019","06/2019","Chưa đóng",1600000, 123451));
//            db.insertInforDetail(new user_detail("01/2018","06/2018","Chưa đóng",1600000, 123452));
//            db.insertInforDetail(new user_detail("07/2018","12/2018","Chưa đóng",1600000, 123452));
//            db.insertInforDetail(new user_detail("01/2019","06/2019","Chưa đóng",1600000, 123452));
//            db.insertInforDetail(new user_detail("01/2018","06/2018","Đã đóng",1600000, 123453));
//            db.insertInforDetail(new user_detail("07/2018","12/2018","Đã đóng",1600000, 123453));
//            db.insertInforDetail(new user_detail("01/2019","06/2019","Đã đóng",1600000, 123453));
//        }
//                if(db!=null){
//                    listTmp1 = db.getAllInforDetail();
//                    usersDetailArrayList.addAll(listTmp1);
//                    adapter1 = new chitietmucdong_adapter(
//                            QuanLyMucDongActivity.this, R.layout.activity_chi_tiet_muc_dong_lvitem,
//                            usersDetailArrayList);
//                    listView.setAdapter(adapter1);
//                }
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