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
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.home.push.bean.OtherManagerBindBean;
import com.huawei.pluginkidwatch.plugin.menu.activity.NotificationHistoryActivity;

public class OtherManagerBindPush implements IPushProcess {
    private String TAG = "GetManagerPermission";
    private C1401q dbData;
    private Gson gson = new Gson();
    OtherManagerBindBean otherManagerBindBean = new OtherManagerBindBean();

    public void processPushMsg(Context context, String str, boolean z) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.otherManagerBindBean = (OtherManagerBindBean) this.gson.fromJson(str, OtherManagerBindBean.class);
                }
            } catch (JsonSyntaxException e) {
                C2538c.m12680e(this.TAG, "===JsonSyntaxException error====" + e.getMessage());
                return;
            }
        }
        String str2 = this.otherManagerBindBean.data;
        if (23 == C1492l.m6920d(this.otherManagerBindBean.type)) {
            saveDataInDB(context);
            if (z) {
                C1495o.m6930a(context, NotificationHistoryActivity.class, str2, context.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), str2, 0, new int[0]);
            }
        }
    }

    private void saveDataInDB(Context context) {
        this.dbData = new C1401q();
        this.dbData.f3147c = String.valueOf(this.otherManagerBindBean.deviceCode);
        this.dbData.f3149e = C1492l.m6920d(this.otherManagerBindBean.type);
        this.dbData.f3148d = this.otherManagerBindBean.name;
        this.dbData.f3150f = this.otherManagerBindBean.time;
        this.dbData.f3152h = this.otherManagerBindBean.data;
        this.dbData.f3145a = C1392h.m6288b(context, this.dbData);
        Intent intent = new Intent();
        intent.setAction("com.huawei.pluginkidwatch.plugin.menu.notification.history");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
