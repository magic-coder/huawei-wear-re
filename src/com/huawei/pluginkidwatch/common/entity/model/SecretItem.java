package com.huawei.pluginkidwatch.common.entity.model;

public class SecretItem {
    public String nspTs;
    public String secret;

    public SecretItem() {
        this.nspTs = "";
        this.secret = "";
        this.nspTs = "";
    }

    public String toString() {
        return "SecretItem{nspTs='" + this.nspTs + '\'' + ", secret='" + this.secret + '\'' + '}';
    }
}
