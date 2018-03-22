package com.huawei.cloudservice;

import com.huawei.hwid.core.helper.handler.ErrorStatus;

public interface LoginHandler {
    void onError(ErrorStatus errorStatus);

    void onFinish(CloudAccount[] cloudAccountArr);

    void onLogin(CloudAccount[] cloudAccountArr, int i);

    void onLogout(CloudAccount[] cloudAccountArr, int i);
}
