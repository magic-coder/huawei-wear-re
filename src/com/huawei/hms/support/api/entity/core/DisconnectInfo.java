package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.p040a.C0860a;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

public class DisconnectInfo implements IMessageEntity {
    @C0860a
    public List<String> apiNameList;
    @C0860a
    public List<Scope> scopeList;

    public DisconnectInfo(List<Scope> list, List<String> list2) {
        this.scopeList = list;
        this.apiNameList = list2;
    }

    public List<String> getApiNameList() {
        return this.apiNameList;
    }

    public List<Scope> getScopeList() {
        return this.scopeList;
    }
}
