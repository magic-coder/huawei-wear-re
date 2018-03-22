package com.huawei.hms.support.api.p042a;

import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;

/* compiled from: ConnectService */
public final class C0873a {
    public static PendingResult<ResolveResult<ConnectResp>> m3067a(ApiClient apiClient, ConnectInfo connectInfo) {
        return new C0874b(apiClient, CoreNaming.CONNECT, connectInfo);
    }

    public static ResolvePendingResult<DisconnectResp> m3066a(ApiClient apiClient, DisconnectInfo disconnectInfo) {
        return ResolvePendingResult.build(apiClient, CoreNaming.DISCONNECT, disconnectInfo, DisconnectResp.class);
    }
}
