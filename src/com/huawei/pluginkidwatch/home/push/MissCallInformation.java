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
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.home.push.bean.MissCallDataBean;
import com.huawei.pluginkidwatch.home.push.bean.MissCallDataBean.MissCallData;
import com.huawei.pluginkidwatch.plugin.menu.activity.NotificationHistoryActivity;
import com.unionpay.tsmservice.data.Constant;

public class MissCallInformation implements IPushProcess {
    private String TAG = "MissCallInformation";
    MissCallDataBean callDataBean = new MissCallDataBean();
    private String dataPhoneNum = "";
    private String dataTime = "";
    private C1401q dbData;
    private Gson gson = new Gson();

    public void processPushMsg(Context context, String str, boolean z) {
        C2538c.m12674b(this.TAG, "====== MissCallInformation == process start======= strMsg = " + str);
        if (str == null || str.length() <= 0) {
            C2538c.m12674b(this.TAG, "======strMsg is null======");
            return;
        }
        try {
            this.callDataBean = (MissCallDataBean) this.gson.fromJson(str, MissCallDataBean.class);
        } catch (JsonSyntaxException e) {
            C2538c.m12674b(this.TAG, "======ERROR!!! JsonSyntaxException e !!!");
        }
        if (this.callDataBean != null) {
            C2538c.m12674b(this.TAG, "====== MissCallInformation======" + this.callDataBean.toString());
        }
        if (!(this.callDataBean == null || this.callDataBean.data == null || this.callDataBean.data.size() <= 0)) {
            this.dataTime = ((MissCallData) this.callDataBean.data.get(0)).time;
            this.dataPhoneNum = ((MissCallData) this.callDataBean.data.get(0)).phoneNum;
        }
        showInformationNotify(context);
        saveDataInDB(context);
    }

    private void showInformationNotify(Context context) {
        String str = "";
        String str2 = this.dataPhoneNum;
        str = "";
        if ("".equals(str2) || str2 == null) {
            str = context.getResources().getString(C1680l.IDS_plugin_kidwatch_miss_call_no_phonenum_notify);
            if (this.callDataBean != null) {
                str2 = this.callDataBean.name;
            }
        } else {
            str = context.getResources().getString(C1680l.IDS_plugin_kidwatch_miss_call_notify);
        }
        String format = String.format(str, new Object[]{str2});
        C2538c.m12677c(this.TAG, "showInformationNotify msg = " + format);
        C1495o.m6930a(context, NotificationHistoryActivity.class, format, context.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 0, new int[0]);
    }

    private String getTime() {
        String str = "";
        if (this.dataTime != null && !"".equals(this.dataTime)) {
            return this.dataTime + Constant.DEFAULT_CVN2;
        }
        if (this.callDataBean != null) {
            return this.callDataBean.time;
        }
        return str;
    }

    private void saveDataInDB(Context context) {
        if (this.callDataBean != null) {
            this.dbData = new C1401q();
            this.dbData.f3147c = this.callDataBean.deviceCode;
            this.dbData.f3149e = C1492l.m6920d(this.callDataBean.type);
            this.dbData.f3148d = this.callDataBean.name;
            this.dbData.f3150f = getTime();
            this.dbData.f3152h = this.dataPhoneNum;
            this.dbData.f3145a = C1392h.m6288b(context, this.dbData);
            Intent intent = new Intent();
            intent.setAction("com.huawei.pluginkidwatch.plugin.menu.notification.history");
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            if (15 == this.dbData.f3149e || 4 == this.dbData.f3149e || 3 == this.dbData.f3149e || 17 == this.dbData.f3149e || 26 == this.dbData.f3149e) {
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
}
