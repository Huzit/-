package com.example.recyclerexample;

public class MainData {

    private int img_profile;
    private String tv_name;
    private String tv_content;

    public MainData(int img_profile, String tv_name, String tv_content) {
        this.img_profile = img_profile;
        this.tv_name = tv_name;
        this.tv_content = tv_content;
    }

    public int getImg_profile() {
        return img_profile;
    }

    public void setImg_profile(int img_profile) {
        this.img_profile = img_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_content() {
        return tv_content;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }
}
