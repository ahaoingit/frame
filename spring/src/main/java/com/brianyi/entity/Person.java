package com.brianyi.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author ahao 2020-11-02
 */
@Data
public class Person {
    private String name;
    private Integer age;
    private List<String> names;
    private Map<String,String> infos;
    private Address address;
}
