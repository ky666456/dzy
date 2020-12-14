package com.itpainter.service.impl;

import com.itpainter.dao.VisitorDao;
import com.itpainter.dao.impl.VisitorDaoImpl;
import com.itpainter.domain.User;
import com.itpainter.domain.food;
import com.itpainter.service.VisitorService;

import java.util.List;

public class VisitorServiceImpl implements VisitorService {

    VisitorDao dao = new VisitorDaoImpl();

    @Override
    public Integer regist(User user) {
        User u = dao.findNameOrTel(user);

        if (u!=null){
            //存在该用户了
            return null;
        }
        return dao.regist(user);
    }

    @Override
    public User login(User user) {
        return dao.login(user);
    }

    @Override
    public List<food> menu(String window_id) {
        return dao.menu(window_id);
    }

    @Override
    public String findWName(String window_id) {
        return dao.findWName(window_id);
    }
}
