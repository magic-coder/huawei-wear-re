package com.huawei.sim.multisim;

import android.os.Handler;
import android.os.Message;
import com.huawei.multisimsdk.multidevicemanager.common.f;
import com.huawei.p190v.C2538c;
import com.huawei.sim.i;

import java.lang.ref.WeakReference;

/* compiled from: MultiSimConfigActivity */
class C5965p extends Handler {
    WeakReference<MultiSimConfigActivity> f20545a;

    C5965p(MultiSimConfigActivity multiSimConfigActivity) {
        this.f20545a = new WeakReference(multiSimConfigActivity);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        MultiSimConfigActivity multiSimConfigActivity = (MultiSimConfigActivity) this.f20545a.get();
        if (multiSimConfigActivity != null) {
            C2538c.c("MultiSimConfigActivity", new Object[]{"handleMessage msg:", Integer.valueOf(message.what)});
            switch (message.what) {
                case 1:
                    C2538c.c("MultiSimConfigActivity", new Object[]{"msg MULTI_STATUS_CHANGE"});
                    multiSimConfigActivity.m27356y();
                    return;
                case 2:
                    C2538c.c("MultiSimConfigActivity", new Object[]{"msg MULTI_SIM_MSG_OPEN_SUCCESS msg:", message});
                    multiSimConfigActivity.m27288a((f) message.obj);
                    return;
                case 3:
                    C2538c.c("MultiSimConfigActivity", new Object[]{"msg MULTI_SIM_MSG_QUERY_RESULT msg:", message});
                    multiSimConfigActivity.m27309c((f) message.obj);
                    return;
                case 4:
                    C2538c.c("MultiSimConfigActivity", new Object[]{"msg MULTI_SIM_MSG_QUERY_UNBIND_RESULT msg:", message});
                    multiSimConfigActivity.m27318d((f) message.obj);
                    return;
                case 5:
                    C2538c.c("MultiSimConfigActivity", new Object[]{"msg MULTI_SIM_MSG_GET_AUTH_CODE_RESULT"});
                    multiSimConfigActivity.m27298b(message.arg1);
                    return;
                case 6:
                    C2538c.c("MultiSimConfigActivity", new Object[]{"msg MULTI_SIM_MSG_GET_AUTH_RESULT"});
                    multiSimConfigActivity.m27308c(message.arg1);
                    return;
                case 7:
                    C2538c.c("MultiSimConfigActivity", new Object[]{"msg MULTI_SIM_MSG_GET_SMS_COUNTER"});
                    multiSimConfigActivity.m27348q();
                    return;
                case 8:
                    multiSimConfigActivity.m27317d(8);
                    C2538c.c("MultiSimConfigActivity", new Object[]{"msg MULTI_SIM_MSG_REFRESH_CURRENT"});
                    multiSimConfigActivity.m27352u();
                    return;
                case 9:
                    multiSimConfigActivity.m27277K();
                    multiSimConfigActivity.m27304b(multiSimConfigActivity.m27285a(multiSimConfigActivity.f20488R), multiSimConfigActivity.getString(i.IDS_plugin_multi_sim_open_result_query_fail_notic));
                    return;
                case 10:
                    multiSimConfigActivity.m27277K();
                    multiSimConfigActivity.m27320d(null);
                    return;
                case 11:
                    C2538c.c("MultiSimConfigActivity", new Object[]{"msg MULTI_SIM_MSG_SMS_OPEN_AGREEN"});
                    multiSimConfigActivity.m27332h();
                    multiSimConfigActivity.m27313c(multiSimConfigActivity.getString(i.IDS_plugin_multi_sim_opening), multiSimConfigActivity.getString(i.IDS_plugin_multi_sim_opening_notic));
                    return;
                case 12:
                    C2538c.c("MultiSimConfigActivity", new Object[]{"msg MULTI_SIM_MSG_SMS_UNBIND_AGREEN"});
                    multiSimConfigActivity.m27332h();
                    multiSimConfigActivity.m27313c(multiSimConfigActivity.getString(i.IDS_plugin_multi_sim_unbinding), multiSimConfigActivity.getString(i.IDS_plugin_multi_sim_unbinding_notic));
                    return;
                default:
                    C2538c.d("MultiSimConfigActivity", new Object[]{"Unknow massage"});
                    return;
            }
        }
    }
}
