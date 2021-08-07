package com.btl_nhom2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChiTietTaiKhoanActivity extends AppCompatActivity {

    ImageButton imgBack, imgChiTietLuongHuu, imgChiTietChiTra, imgChiTietMucDong;
    TextView txtHoTen, txtMaBHXH, txtNgaySinh, txtCMND, txtSDT, txtDiaChi, txtChiTietLuongHuu, txtChiTietChiTra, txtChiTietMucDong;
    ImageView imgGioiTinh;

    ArrayList<users> usersArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_tai_khoan);

        //fakeCSDL
        fakeCSDL fake = new fakeCSDL();
        usersArrayList= fake.fakeusers();

        getWidget();

        //setText
        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("GIOITINH");
        int ViTri = bundle.getInt("GioiTinh");
        users u = usersArrayList.get(ViTri);

        if(u.getGioitinh()){
            imgGioiTinh.setImageResource(R.drawable.boyicon);
        }else {
            imgGioiTinh.setImageResource(R.drawable.wonmanicon);
        }

        txtHoTen.setText(u.getTenuser());
        txtMaBHXH.setText(u.getMaBHXH()+"");
        txtNgaySinh.setText(u.getNgaysinh());
        txtCMND.setText(u.getSoCMND()+"");
        txtSDT.setText(u.getSDT());
        txtDiaChi.setText(u.getDiachi());



        txtChiTietMucDong.setOnClickListener(new MyEnvent());
        txtChiTietChiTra.setOnClickListener(new MyEnvent());
        txtChiTietLuongHuu.setOnClickListener(new MyEnvent());

        imgChiTietMucDong.setOnClickListener(new MyEnvent());
        imgChiTietLuongHuu.setOnClickListener(new MyEnvent());
        imgChiTietChiTra.setOnClickListener(new MyEnvent());

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChiTietTaiKhoanActivity.this.finish();
            }
        });
    }

    public void getWidget(){
        imgBack = findViewById(R.id.imgBack);
        imgChiTietChiTra = findViewById(R.id.imgBtnChiTietChiTra);
        imgChiTietLuongHuu = findViewById(R.id.imgBtnChiTietLuongHuu);
        imgChiTietMucDong = findViewById(R.id.imgBtnChiTietMucDong);
        imgGioiTinh = findViewById(R.id.imgGioiTinh);
        txtHoTen = findViewById(R.id.txtHoTen);
        txtMaBHXH = findViewById(R.id.txtMaBHXH);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        txtCMND = findViewById(R.id.txtCMND);
        txtSDT = findViewById(R.id.txtSDT);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        txtChiTietLuongHuu = findViewById(R.id.txtChiTietLuongHuu);
        txtChiTietChiTra = findViewById(R.id.txtChiTietChiTra);
        txtChiTietMucDong = findViewById(R.id.txtChiTietMucDong);
    }

    private class MyEnvent implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.imgBtnChiTietChiTra || view.getId()==R.id.txtChiTietChiTra){
                chiTietChiTra();
            }else if(view.getId()==R.id.imgBtnChiTietLuongHuu || view.getId()==R.id.txtChiTietLuongHuu){
                chiTietLuongHuu();
            }else if(view.getId()==R.id.imgBtnChiTietMucDong || view.getId()==R.id.txtChiTietMucDong){
                chiTietMucDong();
            }
        }
    }

    private void chiTietChiTra() {
        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("GIOITINH");
        int ViTri = bundle.getInt("GioiTinh");

        Bundle bundle1 = new Bundle();
        bundle1.putInt("ViTri", ViTri);
        Intent intent = new Intent(ChiTietTaiKhoanActivity.this, ChiTietChiTraActivity.class);
        intent.putExtra("VITRI",bundle1);
        startActivity(intent);
    }

    private void chiTietLuongHuu() {
        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("GIOITINH");
        int ViTri = bundle.getInt("GioiTinh");

        Bundle bundle1 = new Bundle();
        bundle1.putInt("ViTri", ViTri);
        Intent intent = new Intent(ChiTietTaiKhoanActivity.this, ChiTietLuongHuuActivity.class);
        intent.putExtra("VITRI",bundle1);
        startActivity(intent);
    }

    private void chiTietMucDong() {
        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("GIOITINH");
        int ViTri = bundle.getInt("GioiTinh");

        Bundle bundle1 = new Bundle();
        bundle1.putInt("ViTri", ViTri);
        Intent intent = new Intent(ChiTietTaiKhoanActivity.this, ChiTietMucDongActivity.class);
        intent.putExtra("VITRI",bundle1);
        startActivity(intent);
    }
}