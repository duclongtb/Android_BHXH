package com.btl_nhom2;

import java.io.Serializable;
import java.util.Date;

public class users implements Serializable {
    private int maBHXH;
    private String tenuser;
    private String ngaysinh;
    private Boolean gioitinh;
    private int soCMND;
    private String SDT;
    private String diachi;
    private int mucluong;
    private String tuthang;
    private String denthang;
    private String tinhtrangmucdong;
    private String tinhtrangchitra;
    private String tinhtrangnghihuu;

    public users(){}
    public users(int maBHXH, String tenuser, String ngaysinh, Boolean gioitinh, int soCMND, String SDT, String diachi, int mucluong, String tuthang, String denthang, String tinhtrangmucdong, String tinhtrangchitra, String tinhtrangnghihuu) {
        this.maBHXH = maBHXH;
        this.tenuser = tenuser;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.soCMND = soCMND;
        this.SDT = SDT;
        this.diachi = diachi;
        this.mucluong = mucluong;
        this.tuthang = tuthang;
        this.denthang = denthang;
        this.tinhtrangmucdong = tinhtrangmucdong;
        this.tinhtrangchitra = tinhtrangchitra;
        this.tinhtrangnghihuu = tinhtrangnghihuu;
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

    public String getTuthang() {
        return tuthang;
    }

    public void setTuthang(String tuthang) {
        this.tuthang = tuthang;
    }

    public String getDenthang() {
        return denthang;
    }

    public void setDenthang(String denthang) {
        this.denthang = denthang;
    }

    public String getTinhtrangmucdong() {
        return tinhtrangmucdong;
    }

    public void setTinhtrangmucdong(String tinhtrangmucdong) {
        this.tinhtrangmucdong = tinhtrangmucdong;
    }

    public String getTinhtrangchitra() {
        return tinhtrangchitra;
    }

    public void setTinhtrangchitra(String tinhtrangchitra) {
        this.tinhtrangchitra = tinhtrangchitra;
    }

    public String getTinhtrangnghihuu() {
        return tinhtrangnghihuu;
    }

    public void setTinhtrangnghihuu(String tinhtrangnghihuu) {
        this.tinhtrangnghihuu = tinhtrangnghihuu;
    }
}
