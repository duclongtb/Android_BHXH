package com.btl_nhom2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class XinChaoActivity extends AppCompatActivity {

    ImageButton imgBtnQuanLyTaiKhoan, imgQuanLyMucDong, imgQuanLyChiTra, imgQuanLyLuongHuu;
    TextView txtQuanLyTaiKhoan, txtQuanLyMucDong, txtQuanLyChiTra, txtQuanLyLuongHuu,txtXinChaoTenAdmin;
    ImageView menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xin_chao);

        menu = (ImageView) findViewById(R.id.menu);
        registerForContextMenu(menu);

        txtXinChaoTenAdmin = (TextView) findViewById(R.id.txtXinChaoTenAdmin);

        imgBtnQuanLyTaiKhoan =(ImageButton) findViewById(R.id.imgBtnQuanLyTaiKhoan);
        imgQuanLyMucDong = (ImageButton) findViewById(R.id.imgBtnQuanLyMucDong);
        imgQuanLyChiTra = (ImageButton) findViewById(R.id.imgBtnQuanLyChiTra);
        imgQuanLyLuongHuu = (ImageButton) findViewById(R.id.imgBtnTinhLuongHuu);

        txtQuanLyChiTra = (TextView) findViewById(R.id.txtQuanLyChiTra);
        txtQuanLyMucDong = (TextView) findViewById(R.id.txtQuanLyMucDong);
        txtQuanLyTaiKhoan = (TextView) findViewById(R.id.txtQuanLyTaiKhoan);
        txtQuanLyLuongHuu = (TextView) findViewById(R.id.txtQuanLyLuongHuu);

        imgBtnQuanLyTaiKhoan.setOnClickListener(new MyEnvent());
        imgQuanLyMucDong.setOnClickListener(new MyEnvent());
        imgQuanLyChiTra.setOnClickListener(new MyEnvent());
        imgQuanLyLuongHuu.setOnClickListener(new MyEnvent());

        txtQuanLyTaiKhoan.setOnClickListener(new MyEnvent());
        txtQuanLyMucDong.setOnClickListener(new MyEnvent());
        txtQuanLyChiTra.setOnClickListener(new MyEnvent());
        txtQuanLyLuongHuu.setOnClickListener(new MyEnvent());

        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("ADMIN");

        String txtAdmin = bundle.getString("admin");
        txtXinChaoTenAdmin.setText("Xin chào, " + txtAdmin);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(XinChaoActivity.this);
                builder.setMessage("Bạn muốn đăng xuất khỏi ứng dụng?");
                builder.setCancelable(true);
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
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

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(XinChaoActivity.this);
        builder.setMessage("Bạn muốn đăng xuất khỏi ứng dụng?");
        builder.setCancelable(true);
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}