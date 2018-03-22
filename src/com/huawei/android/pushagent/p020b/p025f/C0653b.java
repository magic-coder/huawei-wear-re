package com.huawei.android.pushagent.p020b.p025f;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.p018c.C0660a;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.android.pushagent.p020b.C0647a;
import com.huawei.android.pushagent.p020b.p021a.C0646a;

public class C0653b extends C0647a {
    public C0653b(Context context) {
    }

    public void mo2116a(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.huawei.android.push.intent.HEARTBEAT_RANGE_CHANGE".equals(action) || "com.huawei.android.push.intent.HEARTBEAT_VALID_ARRIVED".equals(action)) {
            C0657e.m2512a("PushLogAC2712", "when receive the heart beat range change or valid arrived,the file  HeartBeatCfg.xml need del");
            for (String action2 : C0646a.m2431a(context).m2438a()) {
                C0660a.m2580e(context, action2);
            }
        }
    }
}
