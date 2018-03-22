package com.snowballtech.business.bean;

import java.io.Serializable;

public class ServiceProvider implements Serializable {
    private String sp_id;

    public String getSp_id() {
        return this.sp_id;
    }

    public void setSp_id(String str) {
        this.sp_id = str;
    }
}
