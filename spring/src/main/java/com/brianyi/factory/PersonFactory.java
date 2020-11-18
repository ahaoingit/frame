package com.brianyi.factory;

import com.brianyi.entity.Person;

/**
 * TODO
 *
 * @author ahao 2020-11-02
 */
public class PersonFactory {
    public  Person getPerson() {
        Person person = new Person();
        person.setAge(12);
        person.setName("ahao by factory method");
        return person;
    }
}
