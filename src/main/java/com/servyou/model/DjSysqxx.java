package com.servyou.model;

import java.util.Date;

public class DjSysqxx extends DjSysqxxKey {
    private String qymc;

    private String nsrsbh;

    private String dqdm;

    private String xm;

    private String lxdh;

    private Date djsj;

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

    public String getDqdm() {
        return dqdm;
    }

    public void setDqdm(String dqdm) {
        this.dqdm = dqdm == null ? null : dqdm.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh == null ? null : lxdh.trim();
    }

    public Date getDjsj() {
        return djsj;
    }

    public void setDjsj(Date djsj) {
        this.djsj = djsj;
    }
    @Override
    public String toString() {
    	return "该企业为:"+qymc;
    }
}