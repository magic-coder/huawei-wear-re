package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwdatamigrate.common.a.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.SynchronizePushIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.home.push.bean.KOnePushBeanBase;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PushUtil */
class C1645y implements C1378e {
    final /* synthetic */ String f4261a;
    final /* synthetic */ Context f4262b;
    final /* synthetic */ C1644x f4263c;

    C1645y(C1644x c1644x, String str, Context context) {
        this.f4263c = c1644x;
        this.f4261a = str;
        this.f4262b = context;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        Exception e;
        int i;
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12674b("PushUtil", "=========get message error");
            return;
        }
        List arrayList = new ArrayList();
        SynchronizePushIOEntityModel synchronizePushIOEntityModel = (SynchronizePushIOEntityModel) baseEntityModel;
        int length;
        JSONObject jSONObject;
        KOnePushBeanBase kOnePushBeanBase;
        if (synchronizePushIOEntityModel.data != null && !"".equals(synchronizePushIOEntityModel.data)) {
            String str;
            try {
                str = new String(a.a(synchronizePushIOEntityModel.data), GameManager.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e2) {
                C2538c.m12680e("PushUtil", "e = " + e2.getMessage());
                str = null;
            }
            C2538c.m12674b("PushUtil", "==========push processReceive  synchronizePushInfo  onResponse:" + str);
            if (str != null && !"".equals(str)) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    C2538c.m12674b("PushUtil", "==========push synchronizePushInfo onResponse push size :" + jSONArray.length());
                    length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        KOnePushBeanBase kOnePushBeanBase2 = (KOnePushBeanBase) C1644x.f4259a.fromJson(jSONObject2.toString(), KOnePushBeanBase.class);
                        C2538c.m12674b("PushUtil", "=========onResponse---->pushId:" + kOnePushBeanBase2.pushId);
                        if (18 == C1492l.m6920d(kOnePushBeanBase2.type)) {
                            arrayList.add(jSONObject2);
                        } else if (this.f4261a.equals(kOnePushBeanBase2.pushId.trim())) {
                            this.f4263c.m7781a(this.f4262b, kOnePushBeanBase2, jSONObject2.toString(), true);
                        } else {
                            this.f4263c.m7781a(this.f4262b, kOnePushBeanBase2, jSONObject2.toString(), false);
                        }
                        synchronized (this) {
                            wait(500);
                        }
                    }
                } catch (InterruptedException e3) {
                    e = e3;
                } catch (JSONException e4) {
                    e = e4;
                }
                try {
                    if (arrayList.size() <= 0) {
                        C2538c.m12680e("PushUtil", "==========voiceList.size:" + arrayList.size());
                        length = arrayList.size();
                        for (i = 0; i < length; i++) {
                            jSONObject = (JSONObject) arrayList.get((length - i) - 1);
                            kOnePushBeanBase = (KOnePushBeanBase) C1644x.f4259a.fromJson(jSONObject.toString(), KOnePushBeanBase.class);
                            if (i != 0) {
                                this.f4263c.m7781a(this.f4262b, kOnePushBeanBase, jSONObject.toString(), true);
                            } else {
                                this.f4263c.m7781a(this.f4262b, kOnePushBeanBase, jSONObject.toString(), false);
                            }
                        }
                    }
                    C2538c.m12674b("PushUtil", "==========no voice");
                    return;
                } catch (JsonSyntaxException e5) {
                    C2538c.m12680e("PushUtil", "==========prase voice push error!!!");
                    return;
                }
            }
            return;
        }
        return;
        C2538c.m12680e("PushUtil", "==========prase push error!!!");
        C2538c.m12680e("PushUtil", e.getMessage());
        if (arrayList.size() <= 0) {
            C2538c.m12674b("PushUtil", "==========no voice");
            return;
        }
        C2538c.m12680e("PushUtil", "==========voiceList.size:" + arrayList.size());
        length = arrayList.size();
        for (i = 0; i < length; i++) {
            jSONObject = (JSONObject) arrayList.get((length - i) - 1);
            kOnePushBeanBase = (KOnePushBeanBase) C1644x.f4259a.fromJson(jSONObject.toString(), KOnePushBeanBase.class);
            if (i != 0) {
                this.f4263c.m7781a(this.f4262b, kOnePushBeanBase, jSONObject.toString(), false);
            } else {
                this.f4263c.m7781a(this.f4262b, kOnePushBeanBase, jSONObject.toString(), true);
            }
        }
    }
}
