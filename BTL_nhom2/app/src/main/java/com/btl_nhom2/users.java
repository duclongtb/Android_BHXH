package com.btl_nhom2;

import java.io.Serializable;

public class users implements Serializable {
    private int maBHXH;
    private String tenuser;
    private String ngaysinh;
    private Boolean gioitinh;
    private int soCMND;
    private String SDT;
    private String diachi;
    private int mucluong;

    public users(){}

    public users(int maBHXH, String tenuser, String ngaysinh, Boolean gioitinh, int soCMND, String SDT, String diachi, int mucluong) {
        this.maBHXH = maBHXH;
        this.tenuser = tenuser;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.soCMND = soCMND;
        this.SDT = SDT;
        this.diachi = diachi;
        this.mucluong = mucluong;
    }

    public int getMaBHXH() {
        return maBHXH;
    }

    public void setMaBHXH(int maBHXH) {
        this.maBHXH = maBHXH;
    }

    public String getTenuser() {
        return tenuser;
    }

    public void setTenuser(String tenuser) {
        this.tenuser = tenuser;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(int soCMND) {
        this.soCMND = soCMND;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getMucluong() {
        return mucluong;
    }

    public void setMucluong(int mucluong) {
        this.mucluong = mucluong;
    }

}
