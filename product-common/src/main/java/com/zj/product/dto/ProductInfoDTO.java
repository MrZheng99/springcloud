package com.zj.product.dto;

import java.io.Serializable;

/**
 * 商品信息传输对象
 */
public class ProductInfoDTO implements Serializable {
    private Integer fid;
    private String fname;
    private String description;
    private String flowerLan;
    private String deliveryDesc;
    private Double price;
    private String intro;// 简述
    private Integer store;
    private String pack;// 包装

    private String sale;
    private Integer sid;
    private Integer tid;

    private String flowerImg;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlowerLan() {
        return flowerLan;
    }

    public void setFlowerLan(String flowerLan) {
        this.flowerLan = flowerLan;
    }

    public String getDeliveryDesc() {
        return deliveryDesc;
    }

    public void setDeliveryDesc(String deliveryDesc) {
        this.deliveryDesc = deliveryDesc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getFlowerImg() {
        return flowerImg;
    }

    public void setFlowerImg(String flowerImg) {
        this.flowerImg = flowerImg;
    }

    public ProductInfoDTO(String fname) {
        this.fname = fname;
    }
    public ProductInfoDTO() {

    }
}
