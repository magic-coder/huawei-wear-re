package com.huawei.hwcloudmodel.model.userprofile;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

public class GetUserMergeInfoRsp extends CloudCommonReponse {
    private List<UserMergeInfo> userMergeInfo;

    public List<UserMergeInfo> getUserMergeInfos() {
        return this.userMergeInfo;
    }

    public void setUserMergeInfos(List<UserMergeInfo> list) {
        this.userMergeInfo = list;
    }

    public String toString() {
        return "GetUserMergeInfoRsp{userMergeInfos=" + this.userMergeInfo + '}';
    }
}
