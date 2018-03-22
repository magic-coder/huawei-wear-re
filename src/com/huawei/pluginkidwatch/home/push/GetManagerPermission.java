package com.huawei.pluginkidwatch.home.push;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.home.HomeActivity;
import com.huawei.pluginkidwatch.home.push.bean.GetManagerPermissionBean;
import com.huawei.pluginkidwatch.plugin.menu.activity.NotificationHistoryActivity;

public class GetManagerPermission implements IPushProcess {
    private String TAG = "GetManagerPermission";
    private C1401q dbData;
    GetManagerPermissionBean getManagerPermissionBean = new GetManagerPermissionBean();
    private Gson gson = new Gson();

    public void processPushMsg(Context context, String str, boolean z) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.getManagerPermissionBean = (GetManagerPermissionBean) this.gson.fromJson(str, GetManagerPermissionBean.class);
                }
            } catch (JsonSyntaxException e) {
                C2538c.m12680e(this.TAG, "===JsonSyntaxException error====" + e.getMessage());
                return;
            }
        }
        C1395k a;
        String format;
        if (11 == C1492l.m6920d(this.getManagerPermissionBean.type)) {
            if (this.getManagerPermissionBean.deviceCode.equals(C1462f.m6746j())) {
                C1462f.m6736e(true);
                Intent intent = new Intent();
                intent.setAction("com.huawei.pluginkidwatch.plugin.menu.manager");
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
            a = C1392h.m6269a(context, C1462f.m6744i(), this.getManagerPermissionBean.deviceCode);
            if (a != null) {
                a.f3097q = C1462f.m6744i();
                C1392h.m6297b(context, a);
            }
            format = String.format(context.getResources().getString(C1680l.IDS_plugin_kidwatch_push_notification_history_become_manager), new Object[]{this.getManagerPermissionBean.name});
            saveDataInDB(context);
            if (z) {
                C1495o.m6930a(context, NotificationHistoryActivity.class, format, context.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 0, new int[0]);
                return;
            }
            return;
        }
        C2538c.m12674b(this.TAG, "getManagerPermissionBean.deviceCode：" + this.getManagerPermissionBean.deviceCode);
        C2538c.m12674b(this.TAG, "KWCache.getDeviceCode()：" + C1462f.m6746j());
        if (this.getManagerPermissionBean.deviceCode.equals(C1462f.m6746j())) {
            C2538c.m12674b(this.TAG, "======send broadcast to homeactivity======");
            intent = new Intent();
            intent.setAction("com.huawei.pluginkidwatch.homeactivity.no.privalage");
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
        a = new C1395k();
        a.f3082b = C1492l.m6920d(this.getManagerPermissionBean.deviceCode);
        a.f3081a = C1462f.m6744i();
        C1392h.m6283a(context, a);
        if (z) {
            format = String.format(context.getResources().getString(C1680l.f4392xf16e622a), new Object[]{this.getManagerPermissionBean.name});
            C1495o.m6930a(context, HomeActivity.class, format, context.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 9, new int[0]);
        }
    }

    private void saveDataInDB(Context context) {
        this.dbData = new C1401q();
        this.dbData.f3147c = String.valueOf(this.getManagerPermissionBean.deviceCode);
        this.dbData.f3149e = C1492l.m6920d(this.getManagerPermissionBean.type);
        this.dbData.f3148d = this.getManagerPermissionBean.name;
        this.dbData.f3150f = this.getManagerPermissionBean.time;
        this.dbData.f3145a = C1392h.m6288b(context, this.dbData);
        Intent intent = new Intent();
        intent.setAction("com.huawei.pluginkidwatch.plugin.menu.notification.history");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
