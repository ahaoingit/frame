package com.brianyi.entity;

import java.io.Serializable;

/**
 * (Country)实体类
 *
 * @author makejava
 * @since 2020-10-03 16:31:19
 */
public class Country implements Serializable {
    private static final long serialVersionUID = -63121477082064313L;

    private Integer id;

    private String countryname;

    private String countrycode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryname='" + countryname + '\'' +
                ", countrycode='" + countrycode + '\'' +
                '}';
    }
}