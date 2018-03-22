package com.huawei.hms.support.api.p042a;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.C0871a;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.ConnectResp;

/* compiled from: ConnectService */
final class C0874b extends C0871a<ResolveResult<ConnectResp>, ConnectResp> {
    C0874b(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        super(apiClient, str, iMessageEntity);
    }

    public /* synthetic */ Result onComplete(IMessageEntity iMessageEntity) {
        return m3068a((ConnectResp) iMessageEntity);
    }

    public ResolveResult<ConnectResp> m3068a(ConnectResp connectResp) {
        ResolveResult<ConnectResp> resolveResult = new ResolveResult(connectResp);
        resolveResult.setStatus(Status.SUCCESS);
        return resolveResult;
    }

    protected boolean checkApiClient(ApiClient apiClient) {
        return apiClient != null;
    }
}
