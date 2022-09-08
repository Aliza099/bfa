package com.example.bfa;

import android.media.Image;

public class PojoBookshop {

    private String address;
    private String name;
    private Integer phone_no;
    private Integer user;
    private Image logo;

    public PojoBookshop(String address, String name, Integer phone_no, Integer user, Image logo) {
        this.address = address;
        this.name = name;
        this.phone_no = phone_no;
        this.user = user;
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(Integer phone_no) {
        this.phone_no = phone_no;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }
}
