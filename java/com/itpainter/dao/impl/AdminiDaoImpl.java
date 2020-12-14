package com.itpainter.dao.impl;

import com.itpainter.dao.AdminiDao;
import com.itpainter.domain.Admini;
import com.itpainter.domain.User;
import com.itpainter.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminiDaoImpl implements AdminiDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findNameOrTel(User user) {
        User u = null;
        try {
            //1.定义sql
            String sql = "select * from admini where admini_name = ? or admini_telephone = ?";
            //2.执行sql
            u = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUser_name(), user.getUser_telephone());
        }catch (Exception e){
        }
        return u;
    }

    @Override
    public Integer regist(User user) {
        String sql = "insert into admini(admini_name, admini_password, admini_telephone, admini_window) values(?,?,?,?)";
        //2.执行sql

        int i =template.update(sql, user.getUser_name(),
                user.getUser_password(),
                user.getUser_telephone()
        );

        return i;
    }
    @Override
    public Admini login(Admini user) {
        Admini u = null;
        try {
            //1.定义sql
            String sql = "select * from admini where admini_telephone = ? and admini_password = ?";
            //2.执行sql
            u = template.queryForObject(sql, new BeanPropertyRowMapper<Admini>(Admini.class), user.getAdmini_telephone(), user.getAdmini_password());
        } catch (Exception e) {
        }
        return u;
    }
}