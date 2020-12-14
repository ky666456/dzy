package com.itpainter.service;

import com.itpainter.domain.User;
import com.itpainter.domain.food;

import java.util.List;

public interface VisitorService {

    Integer regist(User user);

    User login(User user);

    List<food> menu(String window_id);

    String findWName(String window_id);
}
