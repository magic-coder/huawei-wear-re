package com.huawei.pluginkidwatch.home.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.RemoteViews;
import com.google.gson.Gson;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.home.push.bean.ContactBean;
import com.huawei.pluginkidwatch.home.receiver.PushBtnReceiver;
import com.huawei.pluginkidwatch.plugin.menu.activity.NotificationHistoryActivity;

public class AddContact implements IPushProcess {
    private String TAG = "AddContact";
    ContactBean contactBean = new ContactBean();
    private C1401q dbData;
    private Gson gson = new Gson();

    public void processPushMsg(Context context, String str, boolean z) {
        C2538c.m12674b(this.TAG, "====== AddContact == process start=======");
        if (str == null || str.length() <= 0) {
            C2538c.m12674b(this.TAG, "======strMsg is null======");
            return;
        }
        this.contactBean = (ContactBean) this.gson.fromJson(str, ContactBean.class);
        C2538c.m12674b(this.TAG, "====== AddContact======" + this.contactBean.toString());
        saveDataInDB(context);
        if (z) {
            showContactDialog(context);
        }
    }

    private void showContactDialog(Context context) {
        String format = String.format(context.getResources().getString(C1680l.IDS_plugin_kidwatch_push_notification_history_add_contact), new Object[]{this.contactBean.name, this.contactBean.data.name});
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), h.notification_layout_btn);
        Intent intent = new Intent(context, PushBtnReceiver.class);
        intent.setAction("com.huawei.push.addContact");
        intent.putExtra("add_db_id", this.dbData.f3145a);
        intent.putExtra("add_process_result", 1);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        Intent intent2 = new Intent(context, PushBtnReceiver.class);
        intent2.setAction("com.huawei.push.addContact");
        intent2.putExtra("add_db_id", this.dbData.f3145a);
        intent2.putExtra("add_process_result", 2);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 1, intent2, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        remoteViews.setOnClickPendingIntent(g.notification_btn_allow, broadcast);
        remoteViews.setOnClickPendingIntent(g.notification_btn_reject, broadcast2);
        remoteViews.setTextViewText(g.notification_tv_showmsg, format);
        C1495o.m6929a(context, NotificationHistoryActivity.class, format, context.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 0, remoteViews, new int[0]);
    }

    private void saveDataInDB(Context context) {
        this.dbData = new C1401q();
        this.dbData.f3147c = this.contactBean.deviceCode;
        this.dbData.f3149e = C1492l.m6920d(this.contactBean.type);
        this.dbData.f3148d = this.contactBean.name;
        this.dbData.f3150f = this.contactBean.time;
        this.dbData.f3152h = this.contactBean.data.name;
        this.dbData.f3153i = String.valueOf(this.contactBean.data.contactId);
        this.dbData.f3145a = C1392h.m6288b(context, this.dbData);
        Intent intent = new Intent();
        intent.setAction("com.huawei.pluginkidwatch.plugin.menu.notification.history");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
