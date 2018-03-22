package com.huawei.crowdtestsdk.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;
import com.huawei.crowdtestsdk.bases.BugInfo;
import com.huawei.crowdtestsdk.bases.DBItemSet;
import com.huawei.crowdtestsdk.bases.SendType.SEND_TYPE;
import com.huawei.crowdtestsdk.common.IssueMaker;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2515k;
import java.util.Collection;

public abstract class FeedbackService extends Service {
    public IBinder mBinder = getBinder();
    private BroadcastReceiver receiver = new C07931();

    class C07931 extends BroadcastReceiver {
        C07931() {
        }

        public void onReceive(Context context, Intent intent) {
            if (SdkConstants.ACTION_STOP_FEEDBACK_SERVICE.equals(intent.getAction())) {
                FeedbackService.this.finish();
            }
            C2511g.m12477a("BETACLUB_SDK", "[FeedbackService.receiver.onReceive]End");
        }
    }

    public abstract void finish();

    protected abstract IBinder getBinder();

    public abstract void resumeIssueMaker();

    public abstract boolean startPackageBug(IssueMaker issueMaker, Uri uri, DBItemSet dBItemSet, BugInfo bugInfo, Collection<String> collection, SEND_TYPE send_type, boolean z);

    public IBinder onBind(Intent intent) {
        C2511g.m12477a("BETACLUB_SDK", "[FeedbackService.onBind]Start");
        return this.mBinder;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackService.onStartCommand]FeedbackService is running!");
        if (!(intent == null || intent.getBooleanExtra("ShowNotification", true))) {
            resumeIssueMaker();
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void onCreate() {
        C2511g.m12477a("BETACLUB_SDK", "[FeedbackService.onCreate]Start");
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SdkConstants.ACTION_STOP_FEEDBACK_SERVICE);
        registerReceiver(this.receiver, intentFilter, SdkConstants.USE_CROWDTESTSDK_PERMISSION, null);
        C2515k.m12545a(true);
        C2511g.m12477a("BETACLUB_SDK", "[FeedbackService.onCreate]End");
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.receiver);
        C2515k.m12545a(false);
    }
}
