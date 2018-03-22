package com.huawei.pluginkidwatch.home.push;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.google.gson.Gson;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.home.push.bean.LocationDataBean;
import com.huawei.pluginkidwatch.plugin.menu.activity.NotificationHistoryActivity;

public class InformationToSee implements IPushProcess {
    private static final long ONE_HOUR = 3600000;
    private String TAG = "InformationToSee";
    private C1401q dbData;
    private Gson gson = new Gson();
    LocationDataBean locationDataBean = new LocationDataBean();

    public void processPushMsg(Context context, String str, boolean z) {
        C2538c.m12674b(this.TAG, "====== InformationToSee == process start=======");
        if (str == null || str.length() <= 0) {
            C2538c.m12674b(this.TAG, "======strMsg is null======");
            return;
        }
        this.locationDataBean = (LocationDataBean) this.gson.fromJson(str, LocationDataBean.class);
        long currentTimeMillis = System.currentTimeMillis() - C1492l.m6922f(getTime());
        C2538c.m12674b(this.TAG, "====== InformationToSee======" + this.locationDataBean.toString());
        saveDataInDB(context);
        if (z && currentTimeMillis <= ONE_HOUR) {
            showInformationDialog(context);
        }
    }

    private void showInformationDialog(Context context) {
        String str = "";
        String str2 = this.locationDataBean.name;
        String str3 = this.locationDataBean.data.name;
        String watchTime = getWatchTime(context);
        int d = C1492l.m6920d(this.locationDataBean.type);
        if (1 == d) {
            str = String.format(context.getResources().getString(C1680l.IDS_plugin_kidwatch_push_notification_history_fence_out_notice), new Object[]{str2, str3, watchTime});
        } else if (2 == d) {
            str = String.format(context.getResources().getString(C1680l.f4393x4b0f42e7), new Object[]{str2, str3, watchTime});
        } else if (3 == d) {
            str = String.format(context.getResources().getString(C1680l.f4394xa7ea5db9), new Object[]{str2, watchTime});
        } else if (14 == d) {
            str = String.format(context.getResources().getString(C1680l.IDS_plugin_kidwatch_push_notification_history_watch_power_notice), new Object[]{str2, watchTime});
        } else if (15 == d) {
            str = String.format(context.getResources().getString(C1680l.IDS_plugin_kidwatch_push_notification_history_no_charge_notice), new Object[]{str2, "5%", watchTime, Integer.valueOf(3), Integer.valueOf(5)});
        } else if (4 == d) {
            str = String.format(context.getResources().getString(C1680l.IDS_plugin_kidwatch_push_notification_history_low_battery_notice), new Object[]{str2, "25%", watchTime, Integer.valueOf(3), Integer.valueOf(5)});
        } else if (17 == d) {
            str = String.format(context.getResources().getString(C1680l.f4395x5a871f53), new Object[]{str2, watchTime});
        }
        C1495o.m6930a(context, NotificationHistoryActivity.class, str, context.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), str, 0, new int[0]);
    }

    private String getWatchTime(Context context) {
        String string = context.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_notification_history_am);
        String str = "";
        str = C1485e.m6847a(C1492l.m6922f(getTime()));
        if (C1485e.m6854a(context)) {
            return C1485e.m6863c(str);
        }
        if (string.equals(C1485e.m6848a(context, str))) {
            return String.format(context.getResources().getString(C1680l.IDS_plugin_kidwatch_push_notification_history_notice_time12am), new Object[]{C1485e.m6857b(str)});
        }
        return String.format(context.getResources().getString(C1680l.IDS_plugin_kidwatch_push_notification_history_notice_time12pm), new Object[]{C1485e.m6857b(str)});
    }

    private String getTime() {
        String str = "";
        if (this.locationDataBean.data.time == null || "".equals(this.locationDataBean.data.time)) {
            return this.locationDataBean.time;
        }
        return this.locationDataBean.data.time;
    }

    private void saveDataInDB(Context context) {
        this.dbData = new C1401q();
        this.dbData.f3147c = this.locationDataBean.deviceCode;
        this.dbData.f3149e = C1492l.m6920d(this.locationDataBean.type);
        this.dbData.f3148d = this.locationDataBean.name;
        this.dbData.f3150f = getTime();
        this.dbData.f3152h = this.locationDataBean.data.name;
        this.dbData.f3145a = C1392h.m6288b(context, this.dbData);
        Intent intent = new Intent();
        intent.setAction("com.huawei.pluginkidwatch.plugin.menu.notification.history");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        if (15 == this.dbData.f3149e || 4 == this.dbData.f3149e || 3 == this.dbData.f3149e || 17 == this.dbData.f3149e) {
            C2538c.m12674b(this.TAG, "======dbData.DeviceCode:" + this.dbData.f3147c);
            C2538c.m12674b(this.TAG, "======KWCache.getDeviceCode():" + C1462f.m6746j());
            if (this.dbData.f3147c.equals(C1462f.m6746j())) {
                C2538c.m12674b(this.TAG, "======send broadcast to homeactivity======");
                intent = new Intent();
                intent.setAction("com.huawei.kone.broadcast.get.watch.status");
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                return;
            }
            C2538c.m12674b(this.TAG, "======not equals, no send broadcast");
        }
    }
}
