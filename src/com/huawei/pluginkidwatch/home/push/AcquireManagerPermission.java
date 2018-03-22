package com.huawei.pluginkidwatch.home.push;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.home.HomeActivity;
import com.huawei.pluginkidwatch.home.push.bean.AcquirePermissionBean;

public class AcquireManagerPermission implements IPushProcess {
    private String TAG = "AcquireManagerPermission";
    private Gson gson = new Gson();

    public void processPushMsg(Context context, String str, boolean z) {
        try {
            String format;
            AcquirePermissionBean acquirePermissionBean = new AcquirePermissionBean();
            if (str != null && str.length() > 0) {
                acquirePermissionBean = (AcquirePermissionBean) this.gson.fromJson(str, AcquirePermissionBean.class);
            }
            if (1 == C1492l.m6920d(acquirePermissionBean.data)) {
                C2538c.m12674b(this.TAG, "======send broadcast to homeactivity getbinddevice======");
                Intent intent = new Intent();
                intent.setAction("com.huawei.kone.broadcast.get.bind.device");
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                format = String.format(context.getResources().getString(C1680l.IDS_plugin_kidwatch_push_acquire_manager_success_msg), new Object[]{acquirePermissionBean.name});
            } else {
                format = context.getResources().getString(C1680l.IDS_plugin_kidwatch_push_acquire_manager_reject_msg);
            }
            if (z) {
                C1495o.m6930a(context, HomeActivity.class, format, context.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 9, new int[0]);
            }
        } catch (JsonSyntaxException e) {
            C2538c.m12680e(this.TAG, "===error====" + e.getMessage());
        }
    }
}
