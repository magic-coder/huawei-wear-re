package com.huawei.hwcloudmodel.model.userprofile;

import com.huawei.hwcloudmodel.model.ThirdUserToken;

public class SetAuthorizeReq {
    private ThirdUserToken thirdUserToken;

    public ThirdUserToken getThirdUserToken() {
        return this.thirdUserToken;
    }

    public void setThirdUserToken(ThirdUserToken thirdUserToken) {
        this.thirdUserToken = thirdUserToken;
    }

    public String toString() {
        return "SetAuthorizeReq{thirdUserToken=" + this.thirdUserToken + '}';
    }
}
