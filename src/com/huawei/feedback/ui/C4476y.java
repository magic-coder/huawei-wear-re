package com.huawei.feedback.ui;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.huawei.feedback.FeedbackApi;
import com.huawei.feedback.logic.C4416g;
import com.huawei.lcagent.client.LogCollectManager;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.phoneserviceuni.common.d.c;
import java.util.List;

/* compiled from: FeedbackRecordActivity */
class C4476y extends Handler {
    final /* synthetic */ FeedbackRecordActivity f16608a;

    C4476y(FeedbackRecordActivity feedbackRecordActivity) {
        this.f16608a = feedbackRecordActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NOAID /*2005*/:
                c.b("FeedbackRecordActivity", "MSG_TYPE_FEEDBACKRESPONSE_SUCCESS");
                List list = (List) message.obj;
                if (list != null) {
                    this.f16608a.m21417a(list);
                    return;
                }
                return;
            case IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION /*2007*/:
                c.b("FeedbackRecordActivity", "MSG_TYPE_SAVE_FEEDBACKBATCH_ANSWER");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.example.logupload.progress");
                intentFilter.addAction("com.example.logupload.progressSmall");
                this.f16608a.registerReceiver(this.f16608a.f16543i, intentFilter);
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.example.logupload.progress.start");
                this.f16608a.registerReceiver(this.f16608a.f16544j, intentFilter);
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.example.logupload.progress.pause");
                this.f16608a.registerReceiver(this.f16608a.f16546l, intentFilter);
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.example.logupload.progress.cancel");
                intentFilter.addAction("com.example.logupload.exception");
                this.f16608a.registerReceiver(this.f16608a.f16545k, intentFilter);
                this.f16608a.f16551q = true;
                this.f16608a.m21427e();
                this.f16608a.m21431g();
                this.f16608a.m21429f();
                C4416g.m21258b();
                try {
                    this.f16608a.f16535a = FeedbackApi.getLogCollectManager();
                    if (this.f16608a.f16535a == null) {
                        this.f16608a.f16535a = new LogCollectManager(this.f16608a.getApplicationContext());
                    }
                } catch (Exception e) {
                    c.d("NetworkMonitorReceiver", "The init of the object logCollectManager is exception!");
                }
                this.f16608a.f16552r.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
