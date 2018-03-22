package com.huawei.ui.main.stories.nps.interactors.p184b;

import android.os.AsyncTask;
import android.os.Build.VERSION;

/* compiled from: TaskUtils */
public class C2444b {
    public static <Params, Progress, Result> void m12275a(AsyncTask<Params, Params, Result> asyncTask, Params... paramsArr) {
        if (VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
    }
}
