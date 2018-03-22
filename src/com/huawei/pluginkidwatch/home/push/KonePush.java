package com.huawei.pluginkidwatch.home.push;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.SynchronizePushIOEntityModel;
import com.huawei.pluginkidwatch.home.p156b.C1644x;
import com.huawei.pluginkidwatch.home.push.bean.KOnePushBeanBase;

public class KonePush {
    private static String TAG = "KonePush";

    public void processPushMsg(Context context, String str) {
        C2538c.m12674b(TAG, "====Enter processPushMsg");
        processReceive(context, str);
    }

    public void processReceive(final Context context, String str) {
        if (str == null || "".equals(str) || str.length() < 1) {
            C2538c.m12680e(TAG, "=========push processReceive  Error PushMsg is Empty===");
            return;
        }
        try {
            C1462f.m6719a(C1093a.m4739a(context).m4753f());
            C1462f.m6729c(C1093a.m4739a(context).m4750c());
            final KOnePushBeanBase kOnePushBeanBase = (KOnePushBeanBase) new Gson().fromJson(str, KOnePushBeanBase.class);
            if (kOnePushBeanBase == null) {
                C2538c.m12680e(TAG, "===================null==bean return===");
                return;
            }
            new Thread() {
                public void run() {
                    C2538c.m12674b(KonePush.TAG, "=========push processReceive  content pushId:===" + kOnePushBeanBase.pushId);
                    SynchronizePushIOEntityModel synchronizePushIOEntityModel = new SynchronizePushIOEntityModel();
                    synchronizePushIOEntityModel.id = kOnePushBeanBase.pushId;
                    new C1644x().m7783a(synchronizePushIOEntityModel, synchronizePushIOEntityModel.id, context);
                }
            }.start();
        } catch (JsonSyntaxException e) {
            C2538c.m12680e(TAG, "====processReceive  Error ===" + e.getMessage());
        }
    }
}
