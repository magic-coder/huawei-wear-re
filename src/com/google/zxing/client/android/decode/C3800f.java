package com.google.zxing.client.android.decode;

import android.os.AsyncTask;
import android.util.Log;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

/* compiled from: InactivityTimer */
final class C3800f extends AsyncTask<Object, Object, Object> {
    final /* synthetic */ C3799e f14782a;

    private C3800f(C3799e c3799e) {
        this.f14782a = c3799e;
    }

    protected Object doInBackground(Object... objArr) {
        try {
            Thread.sleep(LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
            Log.i(C3799e.f14777a, "Finishing activity due to inactivity");
            this.f14782a.f14778b.finish();
        } catch (InterruptedException e) {
        }
        return null;
    }
}
