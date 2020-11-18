package com.brianyi.dao;

import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author ahao 2020-11-03
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void print(String name) {
        System.out.println(name);
    }
}
