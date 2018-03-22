package com.huawei.pluginmessagecenter.service;

import com.huawei.pluginmessagecenter.provider.data.MessageChangeEvent;

public interface MessageObserver {
    public static final int RET_AUTH_ERROR = 10005;
    public static final int RET_CHECK_PARAM_ERROR = 10008;
    public static final int RET_CLOUD_UNKNOWN_ERROR = 10001;
    public static final int RET_HTTP_ERROR = -2;
    public static final int RET_INVALID_PARAM_ERROR = 10007;
    public static final int RET_OK = 0;
    public static final int RET_UNKNOWN_ERROR = -1;

    void onChange(int i, MessageChangeEvent messageChangeEvent);
}
