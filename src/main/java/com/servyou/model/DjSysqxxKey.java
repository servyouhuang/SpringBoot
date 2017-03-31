package com.servyou.model;

public class DjSysqxxKey {
    private Integer qyid;

    private String sewbz;

    public Integer getQyid() {
        return qyid;
    }

    public void setQyid(Integer qyid) {
        this.qyid = qyid;
    }

    public String getSewbz() {
        return sewbz;
    }

    public void setSewbz(String sewbz) {
        this.sewbz = sewbz == null ? null : sewbz.trim();
    }
}