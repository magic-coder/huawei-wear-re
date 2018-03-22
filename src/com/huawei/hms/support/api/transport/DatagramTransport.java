package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

public interface DatagramTransport {

    public interface C0875a {
        void mo2254a(int i, IMessageEntity iMessageEntity);
    }

    void mo2231a(ApiClient apiClient, C0875a c0875a);

    void mo2232b(ApiClient apiClient, C0875a c0875a);
}
