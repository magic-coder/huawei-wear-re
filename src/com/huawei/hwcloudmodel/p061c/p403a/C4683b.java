package com.huawei.hwcloudmodel.p061c.p403a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.p061c.C4708u;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.login.ui.login.a;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.p111o.p479c.C5705a;
import com.huawei.p190v.C2538c;
import com.huawei.up.p520e.C6133g;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: HealthDataHiCloudClient */
public class C4683b extends C4682a {
    private static long f17093a = 0;
    private Context f17094b = null;
    private a f17095c = null;
    private ExecutorService f17096d = Executors.newFixedThreadPool(1);

    public static long m22427a() {
        return f17093a;
    }

    public static void m22430a(long j) {
        f17093a = j;
    }

    public C4683b(Context context) {
        this.f17094b = context.getApplicationContext();
        if (this.f17095c == null) {
            this.f17095c = a.a(this.f17094b);
        }
    }

    public void m22438a(String str, Map<String, Object> map, C3957a<Boolean> c3957a) {
        if (this.f17096d != null) {
            this.f17096d.submit(new C4684c(this, str, map, c3957a));
        }
    }

    protected C4708u mo4552a(String str, Map<String, Object> map, int i, int i2, int i3) throws C6133g {
        C2538c.c("HealthDataHiCloudClient", new Object[]{"matb enter callService"});
        Map hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            throw new C6133g(1, "HealthDataHiCloudClient Service name is empty.");
        }
        m22432a(hashMap);
        hashMap.put("siteId", String.valueOf(a.a(BaseApplication.b()).e()));
        C2538c.c("HealthDataHiCloudClient", new Object[]{"HealthDataHiCloudClient matb callService getSiteId=" + a.a(BaseApplication.b()).e()});
        C2538c.c("HealthDataHiCloudClient", new Object[]{"HealthDataHiCloudClient callService deviceType=" + d.g(this.f17094b)});
        hashMap.put("deviceType", String.valueOf(r0));
        C2538c.c("HealthDataHiCloudClient", new Object[]{"HealthDataHiCloudClient callService imei=" + d.h(this.f17094b)});
        hashMap.put("deviceId", r0);
        hashMap.put("sysVersion", VERSION.RELEASE);
        hashMap.put("iVersion", Integer.valueOf(w.a()));
        hashMap.put("language", PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH);
        for (Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getKey(), entry.getValue());
        }
        Gson gson = new Gson();
        String toJson = gson.toJson(hashMap);
        if (toJson.length() < 1024) {
            C2538c.c("HealthDataHiCloudClient", new Object[]{"HealthDataHiCloudClient matb callService 1111 data = " + toJson});
        } else {
            C2538c.c("HealthDataHiCloudClient", new Object[]{"HealthDataHiCloudClient matb callService 2222 data = " + toJson.substring(0, 1023)});
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i.b(5));
        stringBuffer.append(str);
        C2538c.c("HealthDataHiCloudClient", new Object[]{"matb callService apiURL=" + stringBuffer.toString()});
        C4708u a = m22423a(this.f17094b, r2, toJson, "", i, i2, i3);
        if (a == null) {
            C2538c.c("HealthDataHiCloudClient", new Object[]{"matb callService response=null"});
            throw new C6133g(1, "Server No Response");
        }
        C2538c.c("HealthDataHiCloudClient", new Object[]{"matb callService response=[status:" + a.m22531b() + ", code:" + a.m22532c() + "]"});
        m22431a(a, gson);
        return a;
    }

    private void m22432a(Map<String, Object> map) throws C6133g {
        map.put("ts", Long.valueOf(System.currentTimeMillis()));
        map.put(HwAccountConstants.TOKEN_TYPE, Integer.valueOf(1));
        if (this.f17095c == null) {
            throw new C6133g(1, "HealthDataHiCloudClient mLogin is null.");
        }
        Object g = this.f17095c.g();
        if (TextUtils.isEmpty(g)) {
            C2538c.c("HealthDataHiCloudClient", new Object[]{"matb callService severToken is null!"});
            throw new C6133g(1, "HealthDataHiCloudClient severToken is null.");
        } else if (w.b()) {
            C2538c.c("HealthDataHiCloudClient", new Object[]{"matb callService isNoCloudVersion!"});
            throw new C6133g(1, "HealthDataHiCloudClient isNoCloudVersion");
        } else {
            C2538c.c("HealthDataHiCloudClient", new Object[]{"HealthDataHiCloudClient matb callService severToken = " + g});
            map.put(SNBConstant.FIELD_TOKEN, g);
            String a = C5705a.m26330a(this.f17094b);
            C2538c.c("HealthDataHiCloudClient", new Object[]{"HealthDataHiCloudClient matb callService appid=" + a});
            if (a.equals("com.huawei.bone")) {
                map.put("source", Integer.valueOf(2));
            } else {
                map.put("source", Integer.valueOf(1));
            }
            map.put(AppOpenOrDownHelper.APP_ID_PARAM, a);
        }
    }

    private void m22431a(C4708u c4708u, Gson gson) {
        if (c4708u.m22530a() != null) {
            String a = w.a(c4708u.m22530a());
            if (a != null) {
                if (a.length() < 1024) {
                    C2538c.c("HealthDataHiCloudClient", new Object[]{"matb callService response content=" + a});
                } else {
                    C2538c.c("HealthDataHiCloudClient", new Object[]{"matb callService response content=" + a.substring(0, 1023)});
                }
                CloudCommonReponse cloudCommonReponse = (CloudCommonReponse) gson.fromJson(a, CloudCommonReponse.class);
                if (cloudCommonReponse == null) {
                    return;
                }
                if (1002 == cloudCommonReponse.getResultCode() || 1004 == cloudCommonReponse.getResultCode()) {
                    C2538c.c("HealthDataHiCloudClient", new Object[]{"matb auth failed, so need to logout!"});
                    if (this.f17095c != null) {
                        this.f17095c.a(new C4685d(this));
                    }
                }
            }
        }
    }

    private String m22429a(Context context) {
        String str;
        String str2 = "";
        if (context == null) {
            str = "";
        } else {
            List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            str = (runningTasks == null || runningTasks.size() <= 0) ? str2 : ((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName();
        }
        C2538c.c("HealthDataHiCloudClient", new Object[]{"Enter getTopActvityName resName:" + str});
        return str;
    }

    private boolean m22436b(Context context) {
        if (context == null) {
            return false;
        }
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks == null || runningTasks.size() <= 0) {
            return false;
        }
        Object packageName = ((RunningTaskInfo) runningTasks.get(0)).topActivity.getPackageName();
        if (TextUtils.isEmpty(packageName) || !packageName.equals("com.huawei.bone")) {
            return false;
        }
        return true;
    }

    private void m22434b() {
        if (!m22436b(this.f17094b)) {
            C2538c.b("HealthDataHiCloudClient", new Object[]{"showReLoginActivity Enter not forward"});
        } else if ("com.huawei.bone.root.STTimeoutActivity".equals(m22429a(this.f17094b))) {
            C2538c.b("HealthDataHiCloudClient", new Object[]{"showReLoginActivity Enter equal"});
        } else if (5000 < Math.abs(C4683b.m22427a() - System.currentTimeMillis())) {
            C4683b.m22430a(System.currentTimeMillis());
            Intent intent = new Intent();
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setClassName(this.f17094b, "com.huawei.bone.root.STTimeoutActivity");
            this.f17094b.getApplicationContext().startActivity(intent);
        } else {
            C2538c.b("HealthDataHiCloudClient", new Object[]{"showReLoginActivity Enter not time"});
        }
    }
}
