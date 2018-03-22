package com.huawei.hwappdfxmgr.upload;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.hwappdfxmgr.p055e.C0954a;
import com.huawei.hwappdfxmgr.p056f.C0955a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.login.ui.login.C1093a;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.p190v.C2538c;

public class EventLogUploadService extends Service {
    private static final String TAG = "EventLogUploadService";

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            C2538c.m12677c(TAG, "intent is null");
        } else {
            EventInfo eventInfo = new EventInfo();
            eventInfo.setAppId(intent.getStringExtra(AppOpenOrDownHelper.APP_ID_PARAM));
            eventInfo.setDeviceId(intent.getStringExtra("deviceId"));
            eventInfo.setIversion(intent.getIntExtra("iversion", 1));
            eventInfo.setSiteId(intent.getIntExtra("siteId", 1));
            eventInfo.setSource(intent.getIntExtra("source", 2));
            eventInfo.setToken(C1093a.m4739a(BaseApplication.m2632b()).m4754g());
            eventInfo.setTokenType(intent.getIntExtra(HwAccountConstants.TOKEN_TYPE, 1));
            eventInfo.setTs(intent.getLongExtra("ts", 0));
            EvenLogUpload evenLogUpload = new EvenLogUpload();
            evenLogUpload.setHuid(intent.getStringExtra("x-huid"));
            evenLogUpload.setVersion(intent.getStringExtra("x-version"));
            evenLogUpload.setPath(intent.getStringExtra("filePath"));
            evenLogUpload.setInfo(eventInfo);
            C2538c.m12680e(TAG, "evenLogUpload " + evenLogUpload.toString());
            C0954a.m3337a().m3338a(new EventLogUploadTask(evenLogUpload));
        }
        return 2;
    }

    public void onCreate() {
        C2538c.m12674b(TAG, "onCreate()");
        super.onCreate();
        C0955a.m3339a().m3340a(getApplication());
    }
}
