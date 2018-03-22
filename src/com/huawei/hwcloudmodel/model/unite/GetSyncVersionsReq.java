package com.huawei.hwcloudmodel.model.unite;

import java.util.List;

public class GetSyncVersionsReq {
    private List<SyncKey> syncKeys;

    public List<SyncKey> getSyncKeys() {
        return this.syncKeys;
    }

    public void setSyncKeys(List<SyncKey> list) {
        this.syncKeys = list;
    }

    public String toString() {
        return "GetSyncVersionsReq{syncKeys=" + this.syncKeys + '}';
    }
}
