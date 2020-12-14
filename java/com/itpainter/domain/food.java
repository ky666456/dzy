package com.itpainter.domain;

public class food {
    private String food_id;

    @Override
    public String toString() {
        return "food{" +
                "food_id='" + food_id + '\'' +
                ", food_name='" + food_name + '\'' +
                ", food_picture='" + food_picture + '\'' +
                ", food_price='" + food_price + '\'' +
                ", food_style='" + food_style + '\'' +
                '}';
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    private String food_name;
    private String food_picture;
    private String food_price;
    private String food_style;

    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public String getFood_picture() {
        return food_picture;
    }

    public void setFood_picture(String food_picture) {
        this.food_picture = food_picture;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

    public String getFood_style() {
        return food_style;
    }

    public void setFood_style(String food_style) {
        this.food_style = food_style;
    }

    public food() {
    }

    public food(String food_id, String food_name, String food_picture, String food_price, String food_style) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_picture = food_picture;
        this.food_price = food_price;
        this.food_style = food_style;
    }
}
