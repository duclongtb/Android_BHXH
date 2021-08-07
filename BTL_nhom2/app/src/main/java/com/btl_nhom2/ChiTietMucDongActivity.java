package com.btl_nhom2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
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
    TextView txtMaBHXH, txtHoTen, txtMucLuong;
    EditText editTextTuThang, editTextDenThang;
    RadioButton rdDaDong, rdChuaDong;
    Button btnThem, btnSua, btnLamMoi;
    ListView listView;
    DatePickerDialog.OnDateSetListener dateSetListener;
    DatePickerDialog.OnDateSetListener dateSetListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_muc_dong);

        getWidget();

        //fakeCSDL
        fakeCSDL fake = new fakeCSDL();
        ArrayList <user_detail> user = fake.fakeuser_detail();
        ArrayList<users> usersArrayList = fake.fakeusers();

        //setText
        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("VITRI");
        int ViTri = bundle.getInt("ViTri");

        users u = usersArrayList.get(ViTri);

        txtHoTen.setText(u.getTenuser());
        txtMaBHXH.setText(u.getMaBHXH()+"");
        editTextTuThang.setText("");
        editTextDenThang.setText("");
        txtMucLuong.setText(u.getMucluong()+"");

        //Xử lý sự kiện
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChiTietMucDongActivity.this.finish();
            }
        });

        ArrayList<user_detail> listtmp = new ArrayList<>();
        for(int i=0;i<user.size();i++){
            if(user.get(i).getMaBHXH()==u.getMaBHXH()){
                listtmp.add(user.get(i));
            }
        }

        chitietmucdong_adapter adapter = new chitietmucdong_adapter(
                ChiTietMucDongActivity.this,
                R.layout.activity_chi_tiet_muc_dong_lvitem,
                listtmp);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                user_detail u = user.get(i);
                editTextTuThang.setText(u.getTuthang());
                editTextDenThang.setText(u.getDenthang());
                if(u.getTinhtrangmucdong()=="Đã đóng"){
                    rdDaDong.setChecked(true);
                } else{
                    rdChuaDong.setChecked(true);
                }
            }
        });

        imgCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);

                DatePickerDialog dialog = createDialogWithoutDateField();
                 dialog = new DatePickerDialog(
                        ChiTietMucDongActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener,
                        year,month,0);
                 dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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

                DatePickerDialog dialog = createDialogWithoutDateField();
                dialog = new DatePickerDialog(
                        ChiTietMucDongActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener2,
                        year,month,0);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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

    private DatePickerDialog createDialogWithoutDateField() {
        DatePickerDialog dpd = new DatePickerDialog(this, null, 2014, 1, 24);
        try {
            java.lang.reflect.Field[] datePickerDialogFields = dpd.getClass().getDeclaredFields();
            for (java.lang.reflect.Field datePickerDialogField : datePickerDialogFields) {
                if (datePickerDialogField.getName().equals("mDatePicker")) {
                    datePickerDialogField.setAccessible(true);
                    DatePicker datePicker = (DatePicker) datePickerDialogField.get(dpd);
                    java.lang.reflect.Field[] datePickerFields = datePickerDialogField.getType().getDeclaredFields();
                    for (java.lang.reflect.Field datePickerField : datePickerFields) {
                        Log.i("test", datePickerField.getName());
                        if ("mDaySpinner".equals(datePickerField.getName())) {
                            datePickerField.setAccessible(true);
                            Object dayPicker = datePickerField.get(datePicker);
                            ((View) dayPicker).setVisibility(View.GONE);
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
        }
        return dpd;
    }

    public void getWidget(){
        imgBack = findViewById(R.id.imgBack);
        imgCalendar = findViewById(R.id.imgCalendar);
        imgCalendar2 = findViewById(R.id.imgCalendar2);

        txtMaBHXH = findViewById(R.id.txtMaBHXH);
        txtHoTen = findViewById(R.id.txtHoTen);
        txtMucLuong = findViewById(R.id.txtMucLuong);

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