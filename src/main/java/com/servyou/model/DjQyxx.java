package com.servyou.model;

import java.util.Date;

public class DjQyxx {
    private Integer qyid;

    private String qymc;

    private String nsrsbh;

    private Date lrsj;

    private String yhid;

    private String yhm;

    private String dlm;

    private String sjhm;

    private String hydm;

    private String hymc;

    private String dqdm;

    private String dqmc;

    private String yxbz;
    
    private String qylx;//企业类型:0:未授权;1:已授权
    
    private String  secretkey;
    
    private String szjgdm;

    private String szjgmc;

    private String sewYxbz;

    public Integer getQyid() {
        return qyid;
    }

    public void setQyid(Integer qyid) {
        this.qyid = qyid;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc == null ? null : qymc.trim();
    }

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh == null ? null : nsrsbh.trim();
    }

    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }

    public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid;
    }

    public String getYhm() {
        return yhm;
    }

    public void setYhm(String yhm) {
        this.yhm = yhm == null ? null : yhm.trim();
    }

    public String getDlm() {
        return dlm;
    }

    public void setDlm(String dlm) {
        this.dlm = dlm == null ? null : dlm.trim();
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm == null ? null : sjhm.trim();
    }

    public String getHydm() {
        return hydm;
    }

    public void setHydm(String hydm) {
        this.hydm = hydm == null ? null : hydm.trim();
    }

    public String getHymc() {
        return hymc;
    }

    public void setHymc(String hymc) {
        this.hymc = hymc == null ? null : hymc.trim();
    }

    public String getDqdm() {
        return dqdm;
    }

    public void setDqdm(String dqdm) {
        this.dqdm = dqdm == null ? null : dqdm.trim();
    }

    public String getDqmc() {
        return dqmc;
    }

    public void setDqmc(String dqmc) {
        this.dqmc = dqmc == null ? null : dqmc.trim();
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz == null ? null : yxbz.trim();
    }

    public String getQylx() {
        return qylx;
    }

    public void setQylx(String qylx) {
        this.qylx = qylx;
    }

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }
    
    public String getSzjgdm() {
        return szjgdm;
    }

    public void setSzjgdm(String szjgdm) {
        this.szjgdm = szjgdm == null ? null : szjgdm.trim();
    }

    public String getSzjgmc() {
        return szjgmc;
    }

    public void setSzjgmc(String szjgmc) {
        this.szjgmc = szjgmc == null ? null : szjgmc.trim();
    }

    public String getSewYxbz() {
        return sewYxbz;
    }

    public void setSewYxbz(String sewYxbz) {
        this.sewYxbz = sewYxbz == null ? null : sewYxbz.trim();
    }
}