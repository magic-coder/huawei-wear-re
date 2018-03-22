package com.huawei.pluginkidwatch.common.entity.model;

public class VerifyBindCodeModel extends BaseEntityModel {
    private static final long serialVersionUID = -8429246251287724528L;
    public String deviceCode;
    public String securityCode;

    public String toString() {
        return "VerifyBindCodeModel{deviceCode='" + this.deviceCode + '\'' + ", securityCode='" + this.securityCode + '\'' + '}';
    }
}
