package com.itpainter.domain;

public class Admini {
    private String admini_name;
    private String admini_password;
    private String admini_telephone;
    private String admini_canteen;
    private String admini_tier;
    private String admini_num;

    public Admini() {
    }

    public Admini(String admini_name, String admini_password, String admini_telephone, String admini_canteen, String admini_tier, String admini_num) {
        this.admini_name = admini_name;
        this.admini_password = admini_password;
        this.admini_telephone = admini_telephone;
        this.admini_canteen = admini_canteen;
        this.admini_tier = admini_tier;
        this.admini_num = admini_num;
    }

    @Override
    public String toString() {
        return "Admini{" +
                "admini_name='" + admini_name + '\'' +
                ", admini_password='" + admini_password + '\'' +
                ", admini_telephone='" + admini_telephone + '\'' +
                ", admini_canteen='" + admini_canteen + '\'' +
                ", admini_tier='" + admini_tier + '\'' +
                ", admini_num='" + admini_num + '\'' +
                '}';
    }

    public String getAdmini_name() {
        return admini_name;
    }

    public void setAdmini_name(String admini_name) {
        this.admini_name = admini_name;
    }

    public String getAdmini_password() {
        return admini_password;
    }

    public void setAdmini_password(String admini_password) {
        this.admini_password = admini_password;
    }

    public String getAdmini_telephone() {
        return admini_telephone;
    }

    public void setAdmini_telephone(String admini_telephone) {
        this.admini_telephone = admini_telephone;
    }

    public String getAdmini_canteen() {
        return admini_canteen;
    }

    public void setAdmini_canteen(String admini_canteen) {
        this.admini_canteen = admini_canteen;
    }

    public String getAdmini_tier() {
        return admini_tier;
    }

    public void setAdmini_tier(String admini_tier) {
        this.admini_tier = admini_tier;
    }

    public String getAdmini_num() {
        return admini_num;
    }

    public void setAdmini_num(String admini_num) {
        this.admini_num = admini_num;
    }
}
