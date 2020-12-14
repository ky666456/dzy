package com.itpainter.dao;

import com.itpainter.domain.User;
import com.itpainter.domain.food;

import java.util.List;

public interface VisitorDao {
    /**
     * 判断用户名和手机号是否注册
     * @param user
     * @return
     */
    User findNameOrTel(User user);

    Integer regist(User user);

    User login(User user);

    List<food> menu(String window_id);

    String findWName(String window_id);
}
