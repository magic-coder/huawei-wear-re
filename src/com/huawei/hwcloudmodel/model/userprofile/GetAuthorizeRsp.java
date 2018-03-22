package com.huawei.hwcloudmodel.model.userprofile;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.model.ThirdUserToken;

public class GetAuthorizeRsp extends CloudCommonReponse {
    private ThirdUserToken thirdUserToken;

    public void setThirdUserToken(ThirdUserToken thirdUserToken) {
        this.thirdUserToken = thirdUserToken;
    }

    public ThirdUserToken getThirdUserToken() {
        return this.thirdUserToken;
    }

    public String toString() {
        return "GetAuthorizeRsp{thirdUserToken=" + this.thirdUserToken + '}';
    }
}
