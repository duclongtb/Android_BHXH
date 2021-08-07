package com.btl_nhom2;

import java.io.Serializable;

public class user_detail  implements Serializable {

    private int maBHXH;
    private String tuthang;
    private String denthang;
    private String tinhtrangmucdong;
    private String tinhtrangchitra;
    private String tinhtrangnghihuu;

    public user_detail() {}

    public user_detail(int maBHXH, String tuthang, String denthang, String tinhtrangmucdong, String tinhtrangchitra, String tinhtrangnghihuu) {
        this.maBHXH = maBHXH;
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
