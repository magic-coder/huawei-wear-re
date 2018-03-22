package com.huawei.pluginkidwatch.home.push;

import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.RemoteViews;
import com.google.gson.Gson;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.p148c.C1466a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.home.push.bean.BindMessageBean;
import com.huawei.pluginkidwatch.home.receiver.PushBtnReceiver;
import com.huawei.pluginkidwatch.plugin.menu.activity.NotificationHistoryActivity;

public class ConfirmBind implements IPushProcess {
    private String TAG = "ConfirmBind";
    BindMessageBean bindMessageBean = new BindMessageBean();
    private C1401q dbData;
    private Gson gson = new Gson();
    private Context mCx;
    private String strPhoneNumName = "";

    public void processPushMsg(Context context, String str, boolean z) {
        C2538c.m12674b(this.TAG, "====== ConfirmBind == process start=======");
        this.mCx = context;
        if (str != null && str.length() > 0) {
            this.bindMessageBean = (BindMessageBean) this.gson.fromJson(str, BindMessageBean.class);
        }
        C2538c.m12674b(this.TAG, "====== ConfirmBind======" + this.bindMessageBean.toString());
        if (!"".equals(this.bindMessageBean.data.phoneNum) && C1492l.m6913a(this.mCx, C1466a.m6777a())) {
            getPhoneNameForPhoneNum();
        }
        SaveDataInDB();
        if (z) {
            ShowConfirmDialog();
        }
    }

    private void getPhoneNameForPhoneNum() {
        ContentResolver contentResolver = this.mCx.getContentResolver();
        Cursor query = contentResolver.query(Phone.CONTENT_URI, null, "data1 like '%" + this.bindMessageBean.data.phoneNum + "%'", null, null);
        this.strPhoneNumName = "";
        if (query != null) {
            if (query.moveToNext()) {
                this.strPhoneNumName = query.getString(query.getColumnIndex("display_name"));
            }
            query.close();
        }
        C2538c.m12674b(this.TAG, "====== ConfirmBind======" + this.strPhoneNumName);
        if ("".equals(this.strPhoneNumName)) {
            try {
                Cursor query2 = contentResolver.query(Uri.parse("content://icc/adn"), null, "number like '%" + this.bindMessageBean.data.phoneNum + "%'", null, null);
                if (query2 != null) {
                    if (query2.moveToNext()) {
                        String string = query2.getString(query2.getColumnIndex("name"));
                        if (this.bindMessageBean.data.phoneNum.equals(query2.getString(query2.getColumnIndex("number")))) {
                            this.strPhoneNumName = string;
                        }
                    }
                    query2.close();
                }
            } catch (Exception e) {
                this.strPhoneNumName = "";
            }
        }
        C2538c.m12674b(this.TAG, "====== ConfirmBind======" + this.strPhoneNumName);
    }

    private void ShowConfirmDialog() {
        String string;
        if ("".equals(this.strPhoneNumName)) {
            string = this.mCx.getResources().getString(C1680l.IDS_plugin_kidwatch_push_confirm_bind_nothing_finded);
        } else {
            string = this.mCx.getResources().getString(C1680l.IDS_plugin_kidwatch_push_confirm_bind_name_finded);
        }
        String format = String.format(string, new Object[]{this.bindMessageBean.data.phoneNum, this.bindMessageBean.data.nickname, this.bindMessageBean.name, this.strPhoneNumName});
        RemoteViews remoteViews = new RemoteViews(this.mCx.getPackageName(), h.notification_layout_btn);
        Intent intent = new Intent(this.mCx, PushBtnReceiver.class);
        intent.setAction("com.huawei.push.confirmBind");
        intent.putExtra("bind_db_id", this.dbData.f3145a);
        intent.putExtra("bind_process_result", 1);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mCx, 0, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        Intent intent2 = new Intent(this.mCx, PushBtnReceiver.class);
        intent2.setAction("com.huawei.push.confirmBind");
        intent2.putExtra("bind_db_id", this.dbData.f3145a);
        intent2.putExtra("bind_process_result", 2);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(this.mCx, 1, intent2, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        remoteViews.setOnClickPendingIntent(g.notification_btn_allow, broadcast);
        remoteViews.setOnClickPendingIntent(g.notification_btn_reject, broadcast2);
        remoteViews.setTextViewText(g.notification_tv_showmsg, format);
        C1495o.m6929a(this.mCx, NotificationHistoryActivity.class, format, this.mCx.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 0, remoteViews, new int[0]);
    }

    private void SaveDataInDB() {
        this.dbData = new C1401q();
        this.dbData.f3147c = this.bindMessageBean.deviceCode;
        this.dbData.f3149e = C1492l.m6920d(this.bindMessageBean.type);
        this.dbData.f3148d = this.bindMessageBean.name;
        this.dbData.f3150f = this.bindMessageBean.time;
        this.dbData.f3152h = this.bindMessageBean.data.recordId;
        this.dbData.f3153i = this.bindMessageBean.data.phoneNum;
        this.dbData.f3154j = this.bindMessageBean.data.nickname;
        this.dbData.f3155k = this.strPhoneNumName;
        this.dbData.f3145a = C1392h.m6288b(this.mCx, this.dbData);
        Intent intent = new Intent();
        intent.setAction("com.huawei.pluginkidwatch.plugin.menu.notification.history");
        LocalBroadcastManager.getInstance(this.mCx).sendBroadcast(intent);
    }
}
