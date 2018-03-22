package com.tencent.open.p532d;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.sina.weibo.sdk.component.GameManager;
import com.tencent.open.p541a.C6367n;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class C6403p {
    private static HashMap<String, C6403p> f22240a = null;
    private static String f22241b = null;
    private Context f22242c = null;
    private String f22243d = null;
    private JSONObject f22244e = null;
    private long f22245f = 0;
    private int f22246g = 0;
    private boolean f22247h = true;

    public static C6403p m29203a(Context context, String str) {
        if (f22240a == null) {
            f22240a = new HashMap();
        }
        if (str != null) {
            f22241b = str;
        }
        if (str == null) {
            if (f22241b != null) {
                str = f22241b;
            } else {
                str = "0";
            }
        }
        C6403p c6403p = (C6403p) f22240a.get(str);
        if (c6403p != null) {
            return c6403p;
        }
        c6403p = new C6403p(context, str);
        f22240a.put(str, c6403p);
        return c6403p;
    }

    private C6403p(Context context, String str) {
        this.f22242c = context.getApplicationContext();
        this.f22243d = str;
        m29204a();
        m29208b();
    }

    private void m29204a() {
        try {
            this.f22244e = new JSONObject(m29209c("com.tencent.open.config.json"));
        } catch (JSONException e) {
            this.f22244e = new JSONObject();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m29209c(java.lang.String r6) {
        /*
        r5 = this;
        r1 = "";
        r0 = r5.f22243d;	 Catch:{ FileNotFoundException -> 0x0052 }
        if (r0 == 0) goto L_0x0050;
    L_0x0006:
        r0 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0052 }
        r0.<init>();	 Catch:{ FileNotFoundException -> 0x0052 }
        r0 = r0.append(r6);	 Catch:{ FileNotFoundException -> 0x0052 }
        r2 = ".";
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0052 }
        r2 = r5.f22243d;	 Catch:{ FileNotFoundException -> 0x0052 }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0052 }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x0052 }
    L_0x001f:
        r2 = r5.f22242c;	 Catch:{ FileNotFoundException -> 0x0052 }
        r0 = r2.openFileInput(r0);	 Catch:{ FileNotFoundException -> 0x0052 }
    L_0x0025:
        r3 = new java.io.BufferedReader;
        r2 = new java.io.InputStreamReader;
        r4 = "UTF-8";
        r4 = java.nio.charset.Charset.forName(r4);
        r2.<init>(r0, r4);
        r3.<init>(r2);
        r2 = new java.lang.StringBuffer;
        r2.<init>();
    L_0x003a:
        r4 = r3.readLine();	 Catch:{ IOException -> 0x0044 }
        if (r4 == 0) goto L_0x0064;
    L_0x0040:
        r2.append(r4);	 Catch:{ IOException -> 0x0044 }
        goto L_0x003a;
    L_0x0044:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x007c }
        r0.close();	 Catch:{ IOException -> 0x0076 }
        r3.close();	 Catch:{ IOException -> 0x0076 }
        r0 = r1;
    L_0x004f:
        return r0;
    L_0x0050:
        r0 = r6;
        goto L_0x001f;
    L_0x0052:
        r0 = move-exception;
        r0 = r5.f22242c;	 Catch:{ IOException -> 0x005e }
        r0 = r0.getAssets();	 Catch:{ IOException -> 0x005e }
        r0 = r0.open(r6);	 Catch:{ IOException -> 0x005e }
        goto L_0x0025;
    L_0x005e:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r1;
        goto L_0x004f;
    L_0x0064:
        r1 = r2.toString();	 Catch:{ IOException -> 0x0044 }
        r0.close();	 Catch:{ IOException -> 0x0070 }
        r3.close();	 Catch:{ IOException -> 0x0070 }
        r0 = r1;
        goto L_0x004f;
    L_0x0070:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r1;
        goto L_0x004f;
    L_0x0076:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r1;
        goto L_0x004f;
    L_0x007c:
        r1 = move-exception;
        r0.close();	 Catch:{ IOException -> 0x0084 }
        r3.close();	 Catch:{ IOException -> 0x0084 }
    L_0x0083:
        throw r1;
    L_0x0084:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0083;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.d.p.c(java.lang.String):java.lang.String");
    }

    private void m29206a(String str, String str2) {
        try {
            if (this.f22243d != null) {
                str = str + "." + this.f22243d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f22242c.openFileOutput(str, 0), Charset.forName(GameManager.DEFAULT_CHARSET));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void m29208b() {
        if (this.f22246g != 0) {
            m29211d("update thread is running, return");
            return;
        }
        this.f22246g = 1;
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f22243d);
        bundle.putString("appid_for_getting_config", this.f22243d);
        bundle.putString("status_os", VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", VERSION.SDK);
        bundle.putString("sdkv", "2.9.1");
        bundle.putString("sdkp", "a");
        new C6404q(this, bundle).start();
    }

    private void m29207a(JSONObject jSONObject) {
        m29211d("cgi back, do update");
        this.f22244e = jSONObject;
        m29206a("com.tencent.open.config.json", jSONObject.toString());
        this.f22245f = SystemClock.elapsedRealtime();
    }

    private void m29210c() {
        int optInt = this.f22244e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f22245f >= ((long) (optInt * 3600000))) {
            m29208b();
        }
    }

    public int m29212a(String str) {
        m29211d("get " + str);
        m29210c();
        return this.f22244e.optInt(str);
    }

    public boolean m29213b(String str) {
        m29211d("get " + str);
        m29210c();
        Object opt = this.f22244e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(Integer.valueOf(0));
        } else if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        } else {
            return false;
        }
    }

    private void m29211d(String str) {
        if (this.f22247h) {
            C6367n.m29107b("OpenConfig", str + "; appid: " + this.f22243d);
        }
    }
}
