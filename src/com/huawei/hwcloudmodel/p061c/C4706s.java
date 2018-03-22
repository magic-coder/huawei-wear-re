package com.huawei.hwcloudmodel.p061c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
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
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: NSPClient */
public class C4706s extends C4686a {
    private static long f17153c = 0;
    private Context f17154d = null;
    private a f17155e = null;

    public static long m22518a() {
        return f17153c;
    }

    public static void m22520a(long j) {
        f17153c = j;
    }

    public C4706s(Context context) {
        this.f17154d = context.getApplicationContext();
        if (this.f17155e == null) {
            this.f17155e = a.a(this.f17154d);
        }
    }

    protected C4708u mo4559b(String str, Map<String, Object> map, int i, int i2, int i3) throws C6133g {
        C2538c.c("NSPClient", new Object[]{"enter callService"});
        Map hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            throw new C6133g(1, "Service name is empty.");
        }
        m22522a(hashMap);
        hashMap.put("siteId", String.valueOf(a.a(BaseApplication.b()).e()));
        C2538c.c("NSPClient", new Object[]{"callService getSiteId=" + a.a(BaseApplication.b()).e()});
        hashMap.put("deviceType", String.valueOf(d.g(this.f17154d)));
        hashMap.put("deviceId", d.h(this.f17154d));
        hashMap.put("sysVersion", VERSION.RELEASE);
        hashMap.put("iVersion", Integer.valueOf(w.a()));
        hashMap.put("language", PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH);
        for (Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getKey(), entry.getValue());
        }
        Gson gson = new Gson();
        String toJson = gson.toJson(hashMap);
        if (toJson.length() < 1024) {
            C2538c.b("NSPClient", new Object[]{"callService data : " + toJson});
        } else {
            C2538c.b("NSPClient", new Object[]{"callService data : " + toJson.substring(0, 1023)});
        }
        String c = a.a(BaseApplication.b()).c();
        c.b("NSPClient", new Object[]{"huid: " + c});
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i.b(1));
        stringBuffer.append(str);
        c.c("NSPClient", new Object[]{"callService apiURL=" + stringBuffer.toString()});
        C4708u a = m22440a(this.f17154d, r2, toJson, "", i, i2, i3);
        if (a == null) {
            c.c("NSPClient", new Object[]{"callService response=null"});
            throw new C6133g(1, "Server No Response");
        }
        c.c("NSPClient", new Object[]{"callService response=[status:" + a.m22531b() + ", code:" + a.m22532c() + "]"});
        m22521a(a, gson);
        return a;
    }

    private void m22522a(Map<String, Object> map) throws C6133g {
        map.put("ts", Long.valueOf(System.currentTimeMillis()));
        map.put(HwAccountConstants.TOKEN_TYPE, Integer.valueOf(1));
        if (this.f17155e == null) {
            throw new C6133g(1, "mLogin is null.");
        }
        CharSequence g = this.f17155e.g();
        if (TextUtils.isEmpty(g)) {
            C2538c.c("NSPClient", new Object[]{"callService severToken is null!"});
            throw new C6133g(1, "severToken is null.");
        } else if (w.b()) {
            C2538c.c("NSPClient", new Object[]{"callService isNoCloudVersion!"});
            throw new C6133g(1, "isNoCloudVersion");
        } else {
            map.put(SNBConstant.FIELD_TOKEN, g);
            String a = C5705a.m26330a(this.f17154d);
            if (a.equals("com.huawei.bone")) {
                map.put("source", Integer.valueOf(2));
            } else {
                map.put("source", Integer.valueOf(1));
            }
            map.put(AppOpenOrDownHelper.APP_ID_PARAM, a);
        }
    }

    private void m22521a(C4708u c4708u, Gson gson) {
        if (c4708u.m22530a() != null) {
            String a = w.a(c4708u.m22530a());
            if (a != null) {
                CloudCommonReponse cloudCommonReponse;
                if (a.length() < 1024) {
                    C2538c.b("NSPClient", new Object[]{"callService response content=" + a});
                } else {
                    C2538c.b("NSPClient", new Object[]{"callService response content=" + a.substring(0, 1023)});
                }
                try {
                    cloudCommonReponse = (CloudCommonReponse) gson.fromJson(a, CloudCommonReponse.class);
                } catch (IllegalStateException e) {
                    C2538c.c("NSPClient", new Object[]{"processResponseContent fromJson exception :" + e.getMessage()});
                    cloudCommonReponse = null;
                }
                if (cloudCommonReponse == null) {
                    return;
                }
                if (1002 == cloudCommonReponse.getResultCode() || 1004 == cloudCommonReponse.getResultCode()) {
                    C2538c.c("NSPClient", new Object[]{"auth failed, so need to logout!rsp.getResultCode() = " + cloudCommonReponse.getResultCode()});
                    if (this.f17155e != null) {
                        this.f17155e.a(new C4707t(this));
                    }
                }
            }
        }
    }

    private void m22526b() {
        if (!m22523a(this.f17154d)) {
            C2538c.b("NSPClient", new Object[]{"Enter not forward"});
        } else if ("com.huawei.bone.root.STTimeoutActivity".equals(m22525b(this.f17154d))) {
            C2538c.b("NSPClient", new Object[]{"Enter equal"});
        } else if (Math.abs(C4706s.m22518a() - System.currentTimeMillis()) > 5000) {
            C4706s.m22520a(System.currentTimeMillis());
            Intent intent = new Intent();
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setClassName(this.f17154d, "com.huawei.bone.root.STTimeoutActivity");
            this.f17154d.getApplicationContext().startActivity(intent);
        } else {
            C2538c.b("NSPClient", new Object[]{"Enter not time"});
        }
    }

    private boolean m22523a(Context context) {
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

    private String m22525b(Context context) {
        String str;
        String str2 = "";
        if (context == null) {
            str = "";
        } else {
            List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            str = (runningTasks == null || runningTasks.size() <= 0) ? str2 : ((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName();
        }
        C2538c.c("NSPClient", new Object[]{"Enter getTopActvityName res:" + str});
        return str;
    }
}
