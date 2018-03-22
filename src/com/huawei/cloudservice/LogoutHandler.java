package com.huawei.cloudservice;

import com.huawei.hwid.core.helper.handler.ErrorStatus;

public interface LogoutHandler {
    void onFail(ErrorStatus errorStatus);

    void onSuccess();
}
