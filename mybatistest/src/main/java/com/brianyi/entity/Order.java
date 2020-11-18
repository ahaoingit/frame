package com.brianyi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2020-11-03 16:02:48
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 567952718429749447L;

    private String oid;
    /**
     * 发单人
     */
    private String issuer;
    /**
     * 收单人
     */
    private String receiver;
    /**
     * 订单状态
     */
    private Integer oStatus;
    /**
     * 订单金额
     */
    private Double money;
    /**
     * 订单信息
     */
    private String description;
    /**
     * 发单时间
     */
    private Date billingTime;
    /**
     * 接单时间
     */
    private Date orderTime;
    /**
     * 区域
     */
    private String region;
    /**
     * 楼层
     */
    private String floor;
    /**
     * 门牌
     */
    private String door;
    /**
     * 订单类型
     */
    private String type;
    /**
     * 时间限制
     */
    private Integer limitTime;
    /**
     * 订单详细信息
     */
    private String info;


    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Integer getOStatus() {
        return oStatus;
    }

    public void setOStatus(Integer oStatus) {
        this.oStatus = oStatus;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBillingTime() {
        return billingTime;
    }

    public void setBillingTime(Date billingTime) {
        this.billingTime = billingTime;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Integer limitTime) {
        this.limitTime = limitTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}