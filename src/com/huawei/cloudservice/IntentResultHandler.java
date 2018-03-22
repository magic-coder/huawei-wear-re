package com.huawei.cloudservice;

import android.content.Intent;
import com.huawei.hwid.core.helper.handler.ErrorStatus;

public interface IntentResultHandler {
    void onError(ErrorStatus errorStatus);

    void onFinish(Intent intent);
}
