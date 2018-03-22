package com.huawei.hwcloudmodel.model.userprofile;

public class DelAuthorizeReq {
    private Integer thirdAccountType;

    public Integer getDelThirdAccountType() {
        return this.thirdAccountType;
    }

    public void setDelThirdAccountType(Integer num) {
        this.thirdAccountType = num;
    }

    public String toString() {
        return "DelAuthorizeReq{thirdAccountType=" + this.thirdAccountType + '}';
    }
}
