package com.huawei.hwcloudmodel.model.userprofile;

public class GetAuthorizeReq {
    private Integer thirdAccountType;

    public Integer getThirdAccountType() {
        return this.thirdAccountType;
    }

    public void setThirdAccountType(Integer num) {
        this.thirdAccountType = num;
    }

    public String toString() {
        return "GetAuthorizeReq{thirdAccountType=" + this.thirdAccountType + '}';
    }
}
