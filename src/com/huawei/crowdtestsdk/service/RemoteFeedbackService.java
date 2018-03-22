package com.huawei.crowdtestsdk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import com.huawei.crowdtestsdk.bases.BugInfo;
import com.huawei.crowdtestsdk.bases.DBItemSet;
import com.huawei.crowdtestsdk.bases.SendType.SEND_TYPE;
import com.huawei.crowdtestsdk.common.IssueMaker;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

public class RemoteFeedbackService extends FeedbackService {
    private IssueMaker issueMaker;
    private String logPath;
    private LogCollectResultBroadcastReceiver mLogCollectResultBroadcastReceiver = new LogCollectResultBroadcastReceiver();

    class LogCollectResultBroadcastReceiver extends BroadcastReceiver {
        LogCollectResultBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            C2511g.m12481b("BETACLUB_SDK", "[LogCollectResultBroadcastReceiver.onReceive]BroadcastReceiver is called!");
            if (intent != null) {
                C2511g.m12481b("BETACLUB_SDK", "[LogCollectResultBroadcastReceiver.onReceive]BroadcastReceiver intent != null");
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogCollectResultBroadcastReceiver.onReceive]bundle == null");
                    return;
                }
                Integer valueOf = Integer.valueOf(extras.getInt(SdkConstants.LOG_COLLECT_STATUS));
                if (valueOf.equals(Integer.valueOf(200))) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogCollectResultBroadcastReceiver.onReceive]LOG_COLLECT_SUCCESS");
                    RemoteFeedbackService.this.logPath = extras.getString(SdkConstants.LOG_COLLECT_PATH);
                    if (RemoteFeedbackService.this.logPath != null) {
                        C2511g.m12481b("BETACLUB_SDK", "[LogCollectResultBroadcastReceiver.onReceive]logPath——>" + RemoteFeedbackService.this.logPath);
                    }
                    if (RemoteFeedbackService.this.issueMaker != null) {
                        RemoteFeedbackService.this.issueMaker.setCollectLogCompleted(new AtomicBoolean(true));
                        RemoteFeedbackService.this.issueMaker.setLogPath(RemoteFeedbackService.this.logPath);
                    }
                    if (RemoteFeedbackService.this.logPath != null) {
                        return;
                    }
                    return;
                } else if (valueOf.equals(Integer.valueOf(201))) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogCollectResultBroadcastReceiver.onReceive]LOG_COLLECT_FAILED");
                    if (RemoteFeedbackService.this.issueMaker != null) {
                        RemoteFeedbackService.this.issueMaker.setCollectLogCompleted(new AtomicBoolean(true));
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            C2511g.m12481b("BETACLUB_SDK", "[LogCollectResultBroadcastReceiver.onReceive]BroadcastReceiver intent == null");
        }
    }

    public class RemoteFeedbackBinder extends Binder {
        public RemoteFeedbackService getService() {
            return RemoteFeedbackService.this;
        }
    }

    public String getLogPath() {
        return this.logPath;
    }

    protected IBinder getBinder() {
        return new RemoteFeedbackBinder();
    }

    public void finish() {
    }

    public void onCreate() {
        super.onCreate();
        registerReceiver(this.mLogCollectResultBroadcastReceiver, new IntentFilter(SdkConstants.ACTION_LOG_COLLECT_COMPLETED), SdkConstants.USE_CROWDTESTSDK_PERMISSION, null);
        C2511g.m12483c("BETACLUB_SDK", "[RemoteFeedbackService.onCreate]registerReceiver mLogCollectResultBroadcastReceiver is success!");
    }

    public void onDestroy() {
        try {
            unregisterReceiver(this.mLogCollectResultBroadcastReceiver);
        } catch (Exception e) {
            C2511g.m12483c("BETACLUB_SDK", "[RemoteFeedbackService.onDestroy]UnregisterReceiver Error" + e.toString());
        }
        C2511g.m12481b("BETACLUB_SDK", "[RemoteFeedbackService.onDestroy]RemoteFeedbackService is destroy!");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null && action.equals(SdkConstants.ACTION_BIND_FEEDBACK_SERVICE)) {
                C2511g.m12481b("BETACLUB_SDK", "[RemoteFeedbackService.onStartCommand]ACTION_BIND_FEEDBACK_SERVICE is called!");
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void resumeIssueMaker() {
    }

    public boolean startPackageBug(IssueMaker issueMaker, Uri uri, DBItemSet dBItemSet, BugInfo bugInfo, Collection<String> collection, SEND_TYPE send_type, boolean z) {
        this.issueMaker = issueMaker;
        C2511g.m12477a("BETACLUB_SDK", "[RemoteFeedbackService.startPackageBug]Start");
        if (issueMaker == null) {
            C2511g.m12481b("BETACLUB_SDK", "[RemoteFeedbackService.startPackageBug]issueMaker is null");
            return false;
        } else if (bugInfo == null) {
            C2511g.m12481b("BETACLUB_SDK", "[RemoteFeedbackService.startPackageBug]bugInfo is null");
            return false;
        } else {
            C2511g.m12477a("BETACLUB_SDK", "[RemoteFeedbackService.startPackageBug]issueMakerId : " + issueMaker.getId());
            if (bugInfo.getContext() == null) {
                bugInfo.setContext(this);
            }
            issueMaker.startPackageBug(uri, dBItemSet, bugInfo, collection, send_type, z);
            C2511g.m12477a("BETACLUB_SDK", "[RemoteFeedbackService.startPackageBug]End");
            return true;
        }
    }
}
