package com.zj.product.dto;

import java.io.Serializable;
import java.util.Objects;

public class CartInfoDTO implements Serializable {
    private static final long serialVersionUID = 1709093802011874949L;
    private Integer fid;
    private Integer uid;// 用户id
    private Integer num;// 当前购买量

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Cart [fid=" + fid + ", uid=" + uid + ", num=" + num + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartInfoDTO that = (CartInfoDTO) o;
        return Objects.equals(fid, that.fid) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(num, that.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fid, uid, num);
    }
}
