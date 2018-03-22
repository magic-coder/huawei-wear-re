package com.huawei.crowdtestsdk.common;

import android.app.Application;
import android.content.Context;

public final class AppContext {
    private static AppContext instance = new AppContext();
    private Application application = null;
    private Context applicationContext;

    public static AppContext getInstance() {
        return instance;
    }

    public void setApplicationContext(Context context) {
        this.applicationContext = context;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    private AppContext() {
    }

    public void setApplication(Application application) {
        if (application != null) {
            this.application = application;
        }
    }

    public Application getApplication() {
        return this.application;
    }
}
