package com.huawei.hwcloudmodel.model.userprofile;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

public class GetPrivacyRecordRsp extends CloudCommonReponse {
    private List<PrivacyRecord> privacyRecords;

    public List<PrivacyRecord> getPrivacyRecords() {
        return this.privacyRecords;
    }

    public void setPrivacyRecords(List<PrivacyRecord> list) {
        this.privacyRecords = list;
    }

    public String toString() {
        return "GetPrivacyRecordRsp{privacyRecords=" + this.privacyRecords + '}';
    }
}
