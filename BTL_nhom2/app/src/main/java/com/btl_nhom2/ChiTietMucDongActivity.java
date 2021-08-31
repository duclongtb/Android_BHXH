package com.btl_nhom2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ChiTietMucDongActivity extends AppCompatActivity {

    ImageButton imgBack, imgCalendar, imgCalendar2;
    TextView txtMaBHXH, txtHoTen, txtMucLuong, txtTinhTrang, txtTuThang, txtDenThang, txtTienBHXH;
    EditText editTextTuThang, editTextDenThang;
    RadioButton rdDaDong, rdChuaDong;
    Button btnThem, btnSua, btnLamMoi;
    ListView listView;
    DatePickerDialog.OnDateSetListener dateSetListener;
    DatePickerDialog.OnDateSetListener dateSetListener2;

    DBhelper db;
    ArrayList<users> usersArrayList = new ArrayList<>();
    ArrayList<user_detail> usersDetailArrayList = new ArrayList<user_detail>();
    ArrayList<user_detail> listTmp1 =new ArrayList<user_detail>();
    chitietmucdong_adapter adapter1;
//    user_detail user_selected = null;
//    ArrayList<user_detail> usersDetailArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_muc_dong);
        db =DBhelper.getInstance(this);
        getWidget();
        usersArrayList = db.getAllInfor();
//        usersDetailArrayList = db.getAllInforDetail();

        if(db.getTotalDetail()==0){
            db.insertInforDetail(new user_detail("01/2018","06/2018","Đã đóng",1600000, 123450));
            db.insertInforDetail(new user_detail("07/2018","12/2018","Đã đóng",1600000, 123450));
            db.insertInforDetail(new user_detail("01/2019","06/2019","Đã đóng",1600000, 123450));
            db.insertInforDetail(new user_detail("01/2018","06/2018","Đã đóng",1600000, 123451));
            db.insertInforDetail(new user_detail("07/2028","12/2018","Chưa đóng",1600000, 123451));
            db.insertInforDetail(new user_detail("01/2019","06/2019","Chưa đóng",1600000, 123451));
            db.insertInforDetail(new user_detail("01/2018","06/2018","Chưa đóng",1600000, 123452));
            db.insertInforDetail(new user_detail("07/2018","12/2018","Chưa đóng",1600000, 123452));
            db.insertInforDetail(new user_detail("01/2019","06/2019","Chưa đóng",1600000, 123452));
            db.insertInforDetail(new user_detail("01/2018","06/2018","Đã đóng",1600000, 123453));
            db.insertInforDetail(new user_detail("07/2018","12/2018","Đã đóng",1600000, 123453));
            db.insertInforDetail(new user_detail("01/2019","06/2019","Đã đóng",1600000, 123453));
        }
        if(db!=null){
            listTmp1 = db.getAllInforDetail();
            usersDetailArrayList.addAll(listTmp1);
            adapter1 = new chitietmucdong_adapter(
                    ChiTietMucDongActivity.this, R.layout.activity_chi_tiet_muc_dong_lvitem,
                    usersDetailArrayList);
            listView.setAdapter(adapter1);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                user_selected = listTmp1.get(i);
//                txtTuThang.setText(user_selected.getTuthang());
//                txtDenThang.setText(user_selected.getDenthang());
//                txtTinhTrang.setText(user_selected.getTinhtrangmucdong());
//                txtTienBHXH.setText(user_selected.getTienBHXH());
            }
        });


        //setText
        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("VITRI");
        int ViTri = bundle.getInt("ViTri");
        users u = usersArrayList.get(ViTri);
//        user_detail u1 = usersDetailArrayList.get(ViTri);
        txtHoTen.setText(u.getTenuser());
        txtMaBHXH.setText(u.getMaBHXH()+"");
//        editTextTuThang.setText("");
//        editTextDenThang.setText("");
        txtMucLuong.setText(u.getMucluong()+"");
//        Intent callerIntent1 = getIntent();
//        Bundle bundle1 = callerIntent1.getBundleExtra("VITRI1");
//        int Vitri1 = bundle1.getInt("ViTri1");
//        user_detail u1 = usersDetailArrayList.get(ViTri);
//        txtTuThang.setText(u1.getTuthang());
//        txtDenThang.setText(u1.getDenthang());
//        txtTinhTrang.setText(u1.getTinhtrangmucdong());
//        txtTienBHXH.setText(u1.getTienBHXH());

        //Xử lý sự kiện
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChiTietMucDongActivity.this.finish();
            }
        });

//        ArrayList<user_detail> listtmp = new ArrayList<>();
//        for(int i=0;i<user.size();i++){
//            if(user.get(i).getMaBHXH()==u.getMaBHXH()){
//                listtmp.add(user.get(i));
//            }
//        }

//        chitietmucdong_adapter adapter = new chitietmucdong_adapter(
//                ChiTietMucDongActivity.this,
//                R.layout.activity_chi_tiet_muc_dong_lvitem,
//                listtmp);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                user_detail u = user.get(i);
//                editTextTuThang.setText(u.getTuthang());
//                editTextDenThang.setText(u.getDenthang());
//                if(u.getTinhtrangmucdong()=="Đã đóng"){
//                    rdDaDong.setChecked(true);
//                } else{
//                    rdChuaDong.setChecked(true);
//                }
//            }
//        });

        imgCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ChiTietMucDongActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener,
                        year,month,0);
                 dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                 dialog.getDatePicker().setMaxDate(cal.getTimeInMillis());
                 dialog.getDatePicker().findViewById(Resources.getSystem().getIdentifier("day","id","android")).setVisibility(View.GONE);
                 dialog.show();
            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1+=1;
                String date = i1 + "/"+ i;
                editTextTuThang.setText(date);
            }
        };

        imgCalendar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ChiTietMucDongActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener2,
                        year,month,0);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getDatePicker().findViewById(Resources.getSystem().getIdentifier("day","id","android")).setVisibility(View.GONE);
                dialog.show();
            }
        });
        dateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1+=1;
                String date = i1 + "/"+ i;
                editTextDenThang.setText(date);
            }
        };


        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextTuThang.setText("");
                editTextDenThang.setText("");
            }
        });
    }

    public void getWidget(){
        imgBack = findViewById(R.id.imgBack);
        imgCalendar = findViewById(R.id.imgCalendar);
        imgCalendar2 = findViewById(R.id.imgCalendar2);

        txtMaBHXH = findViewById(R.id.txtMaBHXH);
        txtHoTen = findViewById(R.id.txtHoTen);
        txtMucLuong = findViewById(R.id.txtMucLuong);
        txtTinhTrang = findViewById(R.id.txtTinhTrang);
        editTextDenThang = findViewById(R.id.editTextDenThang);
        editTextTuThang = findViewById(R.id.editTextTuThang);
        editTextDenThang.setEnabled(false);
        editTextTuThang.setEnabled(false);

        rdDaDong = findViewById(R.id.rdDaDong);
        rdChuaDong = findViewById(R.id.rdChuaDong);

        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnLamMoi = findViewById(R.id.btnLamMoi);

        listView = findViewById(R.id.lvChiTienMucDong);
    }

}