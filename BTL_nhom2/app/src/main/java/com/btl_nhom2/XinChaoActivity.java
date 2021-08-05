package com.btl_nhom2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class XinChaoActivity extends AppCompatActivity {

    ImageButton imgBtnQuanLyTaiKhoan, imgQuanLyMucDong, imgQuanLyChiTra, imgQuanLyLuongHuu;
    TextView txtQuanLyTaiKhoan, txtQuanLyMucDong, txtQuanLyChiTra, txtQuanLyLuongHuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xin_chao);

        imgBtnQuanLyTaiKhoan =(ImageButton) findViewById(R.id.imgBtnQuanLyTaiKhoan);
        imgQuanLyMucDong = (ImageButton) findViewById(R.id.imgBtnQuanLyMucDong);
        imgQuanLyChiTra = (ImageButton) findViewById(R.id.imgBtnQuanLyChiTra);
        imgQuanLyLuongHuu = (ImageButton) findViewById(R.id.imgBtnTinhLuongHuu);

        txtQuanLyChiTra = (TextView) findViewById(R.id.txtQuanLyChiTra);
        txtQuanLyMucDong = (TextView) findViewById(R.id.txtQuanLyMucDong);
        txtQuanLyTaiKhoan = (TextView) findViewById(R.id.txtQuanLyTaiKhoan);
        txtQuanLyLuongHuu = (TextView) findViewById(R.id.txtQuanLyLuongHuu);

        imgQuanLyMucDong.setOnClickListener(new MyEnvent());
        imgBtnQuanLyTaiKhoan.setOnClickListener(new MyEnvent());
        imgQuanLyChiTra.setOnClickListener(new MyEnvent());
        imgQuanLyLuongHuu.setOnClickListener(new MyEnvent());

        txtQuanLyTaiKhoan.setOnClickListener(new MyEnvent());
        txtQuanLyMucDong.setOnClickListener(new MyEnvent());
        txtQuanLyChiTra.setOnClickListener(new MyEnvent());
        txtQuanLyLuongHuu.setOnClickListener(new MyEnvent());
    }

    private class MyEnvent implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.imgBtnQuanLyTaiKhoan || view.getId()==R.id.txtQuanLyTaiKhoan){
                quanLyTaiKhoan();
            }else if(view.getId()==R.id.imgBtnQuanLyMucDong || view.getId()==R.id.txtQuanLyMucDong){
                quanLyMucDong();
            }else if(view.getId()==R.id.imgBtnQuanLyChiTra || view.getId()==R.id.txtQuanLyChiTra){
                quanLyChiTra();
            }else if(view.getId()==R.id.imgBtnTinhLuongHuu || view.getId()==R.id.txtQuanLyLuongHuu) {
                quanLyLuongHuu();
            }
        }
    }

    private void quanLyLuongHuu() {
        Intent intent = new Intent(XinChaoActivity.this, QuanLyLuongHuuActivity.class);
        startActivity(intent);
    }

    private void quanLyTaiKhoan() {
        Intent intent = new Intent(XinChaoActivity.this, QuanLyTaiKhoanActivity.class);
        startActivity(intent);
    }

    private void quanLyMucDong() {
        Intent intent = new Intent(XinChaoActivity.this, QuanLyMucDongActivity.class);
        startActivity(intent);
    }

    private void quanLyChiTra() {
        Intent intent = new Intent(XinChaoActivity.this, QuanLyChiTra1LanActivity.class);
        startActivity(intent);
    }
}