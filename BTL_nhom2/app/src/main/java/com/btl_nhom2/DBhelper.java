package com.btl_nhom2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {
    private static final String TAG = "DBHelper";
    public static final String DBNAME = "quanlybhxh.db";
    private static final int DATABASE_VERSION = 1;
    protected static final String TABLE_USER = "tblUsers";
    private static final String MA_BHXH = "maBhxh";
    private static final String TEN_USER = "tenUser";
    private static final String NGAY_SINH = "ngaySinh";
    private static final String GIOI_TINH = "gioiTinh";
    private static final String SO_CMND = "soCmnd";
    private static final String DIA_CHI = "diaChi";
    private static final String SDT = "sdt";
    private static final String MUC_LUONG = "mucLuong";
    private static final String CREATE_USER_TABLE_SQL =
            "CREATE TABLE IF NOT EXISTS " + TABLE_USER + " (" +
                    MA_BHXH + " INTEGER NOT NULL PRIMARY KEY ," +
                    TEN_USER + " TEXT NOT NULL," +
                    NGAY_SINH + " TEXT NOT NULL," +
                    GIOI_TINH + " TEXT NOT NULL," +
                    SO_CMND + " INTEGER NOT NULL," +
                    DIA_CHI + " TEXT NOT NULL," +
                    SDT + " TEXT NOT NULL," +
                    MUC_LUONG + " INTEGER NOT NULL" +
                    ")" ;
    public DBhelper(Context context) {
        super(context, DBNAME, null, DATABASE_VERSION);
    }
    private static DBhelper sInstance;
    public static DBhelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DBhelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        Log.e(TAG, "onCreate: ");
        try {
            MyDB.execSQL("create Table TAIKHOAN(tentk TEXT primary key, matkhau TEXT)");
            MyDB.execSQL(CREATE_USER_TABLE_SQL);
            MyDB.execSQL("INSERT INTO " + TABLE_USER + "(MA_BHXH, TEN_USER, NGAY_SINH, GIOI_TINH, SO_CMND, DIA_CHI, SDT, MUC_LUONG) VALUES (123450, 'Nguyen Van Duc', '23/07/1950', 1, 1001001, '01241440', 'Hà nội', 8000000)");
            MyDB.execSQL("INSERT INTO " + TABLE_USER + "(MA_BHXH, TEN_USER, NGAY_SINH, GIOI_TINH, SO_CMND, DIA_CHI, SDT, MUC_LUONG) VALUES (123451, 'Nguyen Thanh Thao', '23/07/1980', 0, 1001002, '01241441', 'Hà nam', 8000000)");
            MyDB.execSQL("INSERT INTO " + TABLE_USER + "(MA_BHXH, TEN_USER, NGAY_SINH, GIOI_TINH, SO_CMND, DIA_CHI, SDT, MUC_LUONG) VALUES (123452, 'Nguyen Duc Nam', '23/07/1975', 1, 1001003, '01241442', 'Nam định', 8000000)");
            MyDB.execSQL("INSERT INTO " + TABLE_USER + "(MA_BHXH, TEN_USER, NGAY_SINH, GIOI_TINH, SO_CMND, DIA_CHI, SDT, MUC_LUONG) VALUES (123453, 'Nguyen Thao Tam', '23/07/1955', 0, 1001004, '01241443', 'Bắc Ninh', 8000000)");
        }
        catch (Exception e){
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        Log.e(TAG, "onUpgrade: ");
//        MyDB.execSQL("drop Table if exists TAIKHOAN");
        MyDB.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(MyDB);
    }

//    public long insertInfor(String table_name, ContentValues values) {
//        SQLiteDatabase db = getWritableDatabase();
//        ArrayList<defaultCSDL> lists = new ArrayList<defaultCSDL>();
//        ContentValues ct = new ContentValues();
//        ct.put("maBhxh", u0.maBhxh);
//        ct.put("tenUser", u0.tenuser);
//        ct.put("ngaySinh", u0.ngaysinh);
//        ct.put("gioiTinh", u0.gioitinh);
//        ct.put("soCmnd", u0.soCMND);
//        ct.put("SDT", u0.SDT);
//        ct.put("diaChi", u0.diachi);
//        ct.put("mucLuong", u0.mucluong);
//        db.insert(DBhelper.TABLE_USER, null, ct);
//        return lists;
//        long rowId = db.insert(table_name, null, values);
//        db.close();
//        return rowId;
//    }

    public boolean isTableExists(SQLiteDatabase MyDB,String tableName)
    {
        Cursor cursor = MyDB.rawQuery(
                "select DISTINCT tbl_name " +
                        "from sqlite_master " +
                        "where tbl_name = '"+tableName+"'", null);
        if(cursor!=null) {
            if(cursor.getCount()>0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }

    public ArrayList<users> getAllInfor(String TABLE_NAME) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<users> lists = new ArrayList<users>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                lists.add(new users(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getInt(7)));
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return lists;
    }

    public Boolean insertData(String tentk, String matkhau){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("tentk", tentk);
        contentValues.put("matkhau", matkhau);
        long result = MyDB.insert("TAIKHOAN", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

//    public ArrayList<users> initUser(String TABLE_USER){
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        ArrayList<users> lists = new ArrayList<users>();
//        users u0 = new users(123450, "Nguyen Van A", "23/07/1950", 1, 1001001, "01241440", "Ha noi", 8000000);
//        users u1 = new users(123450, "Nguyen Van B", "23/07/1955", 0, 1001002, "01241441", "Ha nam", 7000000);
//        ContentValues ct = new ContentValues();
//        ct.put("maBhxh", u0.maBHXH);
//        ct.put("tenUser", u0.tenuser);
//        ct.put("ngaySinh", u0.ngaysinh);
//        ct.put("gioiTinh", u0.gioitinh);
//        ct.put("soCmnd", u0.soCMND);
//        ct.put("SDT", u0.SDT);
//        ct.put("diaChi", u0.diachi);
//        ct.put("mucLuong", u0.mucluong);
//
//        ct.put("maBhxh", u1.maBHXH);
//        ct.put("tenUser", u1.tenuser);
//        ct.put("ngaySinh", u1.ngaysinh);
//        ct.put("gioiTinh", u1.gioitinh);
//        ct.put("soCmnd", u1.soCMND);
//        ct.put("SDT", u1.SDT);
//        ct.put("diaChi", u1.diachi);
//        ct.put("mucLuong", u1.mucluong);
//        MyDB.insert(DBhelper.TABLE_USER, null, ct);
//        return lists;
//    }

    public Boolean checktentk(String tentk) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from TAIKHOAN where tentk = ?", new String[]{tentk});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checktentkmatkhau(String tentk, String matkhau){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from TAIKHOAN where tentk = ? and matkhau = ?", new String[] {tentk,matkhau});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}