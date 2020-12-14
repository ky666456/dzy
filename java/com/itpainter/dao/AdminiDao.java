package com.itpainter.dao;

import com.itpainter.domain.Admini;
import com.itpainter.domain.User;

public interface AdminiDao {
    Admini login(Admini user);

    User findNameOrTel(User user);

    Integer regist(User user);
}
