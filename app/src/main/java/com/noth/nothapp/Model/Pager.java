package com.noth.nothapp.Model;

public class Pager {
    //Đánh số trang
    private String resoucePager;

    public Pager(String resoucePager) {
        this.resoucePager = resoucePager;
    }

    public Pager() {
    }

    public String getResoucePager() {
        return resoucePager;
    }

    public void setResoucePager(String resoucePager) {
        this.resoucePager = resoucePager;
    }
}
