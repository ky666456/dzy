package com.itpainter.dao.impl;

import com.itpainter.dao.VisitorDao;
import com.itpainter.domain.OneString;
import com.itpainter.domain.User;
import com.itpainter.domain.Windows;
import com.itpainter.domain.food;
import com.itpainter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class VisitorDaoImpl implements VisitorDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findNameOrTel(User user) {
        User u = null;
        try {
            //1.定义sql
            String sql = "select * from user where user_name = ? or user_telephone = ?";
            //2.执行sql
            u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUser_name(), user.getUser_telephone());
        }catch (Exception e){
        }
        return u;
    }

    @Override
    public Integer regist(User user) {
        String sql = "insert into user(user_name,user_password,user_telephone) values(?,?,?)";
        //2.执行sql

        int i =template.update(sql, user.getUser_name(),
                user.getUser_password(),
                user.getUser_telephone()
        );

        return i;
    }

    @Override
    public User login(User user) {
        User u = null;
        try {
            //1.定义sql
            String sql = "select * from user where user_password = ? and user_telephone = ?";
            //2.执行sql
            u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),user.getUser_password(), user.getUser_telephone());
        }catch (Exception e){
        }
        return u;
    }

    @Override
    public List<food> menu(String window_id) {
        List<food> res = new ArrayList<>();
        String sql = "select menu.food_id,foods.food_name,menu.food_picture,menu.food_price,menu.food_style from menu,foods where menu.window_id = ? and menu.food_id = foods.food_id order by foods.food_type";
        try {
            res = template.query(sql,new BeanPropertyRowMapper<food>(food.class),window_id);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {

        }
        return res;
    }

    @Override
    public String findWName(String window_id) {
        OneString strs =null;
        String name =null;
        try {
            //1.定义sql
            String sql = "select window_name as str from windows where window_id = ?";
            //2.执行sql
            strs = template.queryForObject(sql,new BeanPropertyRowMapper<OneString>(OneString.class),window_id);
            name = strs.getStr();
        }catch (Exception e){
        }
        return name;
    }
}
