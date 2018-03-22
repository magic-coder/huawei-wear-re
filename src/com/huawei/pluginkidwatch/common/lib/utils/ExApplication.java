package com.huawei.pluginkidwatch.common.lib.utils;

import android.app.Application;
import android.os.Handler;
import java.util.ArrayList;

public class ExApplication extends Application {
    private static ExApplication f3453b;
    protected ArrayList<Handler> f3454a = null;

    public void onCreate() {
        super.onCreate();
        m6809a();
    }

    private void m6809a() {
        f3453b = this;
    }
}
