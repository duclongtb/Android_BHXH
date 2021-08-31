package com.btl_nhom2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ChiTietLuongHuuActivity extends AppCompatActivity {

    TextView txtHoTen, txtMaBHXH, txtNgaySinh, txtGioiTinh, txtDiaChi, txtTinhTrang, txtThoiGianNghiHuu;
    ImageButton imgback;
    DBhelper db;
    ArrayList<users> usersArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_luong_huu);
        db =DBhelper.getInstance(this);
        usersArrayList = db.getAllInfor();
        getWidget();

        //fakeCSDL
//        fakeCSDL fake = new fakeCSDL();
//        ArrayList<users> user = fake.fakeusers();
//        ArrayList<users> usersArrayList = fake.fakeusers();

        //setText
        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("VITRI");
        int ViTri = bundle.getInt("ViTri");

        users u = usersArrayList.get(ViTri);
//        users u_d = user.get(ViTri);

        txtHoTen.setText(u.getTenuser());
        txtMaBHXH.setText(u.getMaBHXH()+"");
        txtNgaySinh.setText(u.getNgaysinh());
        if(u.getGioitinh()==1){
            txtGioiTinh.setText("Nam");
        }else {
            txtGioiTinh.setText("Nữ");
        }
        txtDiaChi.setText(u.getDiachi());
        txtTinhTrang.setText(u.tinhtrangnghihuu);
        if(u.getTinhtrangnghihuu()=="Đã nghỉ hưu"){
            txtThoiGianNghiHuu.setText("---Đã nghỉ hưu---");
        }else {
            txtThoiGianNghiHuu.setText("---Chưa nghỉ hưu---");
        }

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChiTietLuongHuuActivity.this.finish();
            }
        });
    }

    public void getWidget(){
        imgback = findViewById(R.id.imgBack);
        txtHoTen = findViewById(R.id.txtHoTen);
        txtMaBHXH = findViewById(R.id.txtMaBHXH);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        txtGioiTinh = findViewById(R.id.txtGioiTinh);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        txtTinhTrang = findViewById(R.id.txtTinhTrang);
        txtThoiGianNghiHuu = findViewById(R.id.txtThoiGianNghiHuu);
    }
}