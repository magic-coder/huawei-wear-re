package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.p040a.C0860a;
import java.util.Arrays;
import java.util.List;

public class ConnectResp implements IMessageEntity {
    @C0860a
    public List<Integer> protocolVersion = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2)});
    @C0860a
    public String sessionId;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("protocol version:");
        for (Integer append : this.protocolVersion) {
            stringBuilder.append(append);
            stringBuilder.append(',');
        }
        return stringBuilder.toString();
    }
}
