package com.brianyi.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author ahao 2020-11-03
 */
@Repository
@Scope(value = "singleton")
public interface UserDao {
    void print(String name);
}
