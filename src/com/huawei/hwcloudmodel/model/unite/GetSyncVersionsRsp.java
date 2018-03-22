package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

public class GetSyncVersionsRsp extends CloudCommonReponse {
    private List<SyncKey> versions;

    public List<SyncKey> getVersions() {
        return this.versions;
    }

    public void setVersions(List<SyncKey> list) {
        this.versions = list;
    }

    public String toString() {
        return "GetSyncVersionsRsp{versions=" + this.versions + '}';
    }
}
