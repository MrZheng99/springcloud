package com.zj.product.dto;

import java.io.Serializable;

public class ProductTypeDTO implements Serializable {
    private Integer tid;
    private String tname;
    private String description;
    private String typeImg;// 种类图片url
    private String status;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTypeImg() {
        return typeImg;
    }

    public void setTypeImg(String typeImg) {
        this.typeImg = typeImg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "FlowerType [tid=" + tid + ", tname=" + tname + ", description=" + description + ", typeImg=" + typeImg
                + ", status=" + status + "]";
    }

}
