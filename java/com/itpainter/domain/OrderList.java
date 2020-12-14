package com.itpainter.domain;

import java.sql.Timestamp;

//订单表
public class OrderList {
    private Integer order_id;  //订单id
    private Integer user_id;   //用户id
    private Integer window_id; //窗口id
    private Double price;   //价格
    private Enum style;    //是否完成交易
    private Timestamp create_time; //创建时间
    private Timestamp finish_time; //完成时间
    private String about; //备注

    public OrderList() {
    }

    public OrderList(Integer order_id, Integer user_id, Integer window_id, Double price, Enum style, Timestamp create_time, Timestamp finish_time, String about) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.window_id = window_id;
        this.price = price;
        this.style = style;
        this.create_time = create_time;
        this.finish_time = finish_time;
        this.about = about;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getWindow_id() {
        return window_id;
    }

    public void setWindow_id(Integer window_id) {
        this.window_id = window_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Enum getStyle() {
        return style;
    }

    public void setStyle(Enum style) {
        this.style = style;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Timestamp finish_time) {
        this.finish_time = finish_time;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", window_id=" + window_id +
                ", price=" + price +
                ", style=" + style +
                ", create_time=" + create_time +
                ", finish_time=" + finish_time +
                ", about='" + about + '\'' +
                '}';
    }
}