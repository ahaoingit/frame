package com.brianyi.service;

import com.brianyi.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author ahao 2020-11-03
 */
@Service
public class UserService {
    @Autowired
    UserDao userDaoImpl;

    //如果以set方法进行注入 当有多个相同类型时 是根据参数名称去容器中进行查找的
//    @Autowired
//    public void setUserDao(UserDao userDaoImpl2) {
//
//        this.userDao = userDaoImpl2;
//    }

    public void runDao() {
        userDaoImpl.print("yyy");
    }
}
