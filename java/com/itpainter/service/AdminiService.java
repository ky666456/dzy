package com.itpainter.service;

import com.itpainter.domain.Admini;
import com.itpainter.domain.User;

public interface AdminiService {
    Admini login(Admini user);

    Integer regist(User user);
}
