package com.huawei.pluginkidwatch.home.push;

import android.content.Context;

public interface IPushProcess {
    void processPushMsg(Context context, String str, boolean z);
}
