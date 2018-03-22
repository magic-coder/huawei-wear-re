package com.huawei.android.pushselfshow.p336a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.p337b.C4149a;
import com.huawei.android.pushselfshow.utils.C4203a;
import com.huawei.android.pushselfshow.utils.p345a.C4199a;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import net.sqlcipher.database.SQLiteDatabase;
import org.apache.log4j.spi.LocationInfo;

public class C4147a {
    private static final String[] f15557a = new String[]{"phone", "url", "email", "app", "cosa", "rp"};
    private Context f15558b;
    private C4149a f15559c;

    public C4147a(Context context, C4149a c4149a) {
        this.f15558b = context;
        this.f15559c = c4149a;
    }

    public static boolean m20247a(String str) {
        for (String equals : f15557a) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void m20248b() {
        e.a("PushSelfShowLog", "enter launchUrl");
        try {
            if (!(this.f15559c.f15566G == 0 || this.f15559c.f15567H == null || this.f15559c.f15567H.length() <= 0)) {
                if (this.f15559c.f15561B.indexOf(LocationInfo.NA) != -1) {
                    this.f15559c.f15561B += SNBConstant.FILTER + this.f15559c.f15567H + "=" + C4203a.m20421a(C4203a.m20428b(this.f15558b));
                } else {
                    this.f15559c.f15561B += LocationInfo.NA + this.f15559c.f15567H + "=" + C4203a.m20421a(C4203a.m20428b(this.f15558b));
                }
            }
            e.a("PushSelfShowLog", "url =" + this.f15559c.f15561B);
            if (this.f15559c.f15565F == 0) {
                String str = this.f15559c.f15561B;
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW").setFlags(SQLiteDatabase.CREATE_IF_NECESSARY).setData(Uri.parse(str));
                this.f15558b.startActivity(intent);
                return;
            }
            this.f15559c.f15562C = this.f15559c.f15561B;
            this.f15559c.f15564E = "text/html";
            this.f15559c.f15563D = "html";
            m20253g();
        } catch (Throwable e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    private void m20249c() {
        e.a("PushSelfShowLog", "enter launchCall");
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.DIAL").setData(Uri.parse("tel:" + this.f15559c.f15600v)).setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.f15558b.startActivity(intent);
        } catch (Throwable e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    private void m20250d() {
        e.a("PushSelfShowLog", "enter launchMail");
        try {
            if (this.f15559c.f15601w != null) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SENDTO").setFlags(SQLiteDatabase.CREATE_IF_NECESSARY).setData(Uri.fromParts("mailto", this.f15559c.f15601w, null)).putExtra("android.intent.extra.SUBJECT", this.f15559c.f15602x).putExtra("android.intent.extra.TEXT", this.f15559c.f15603y).setPackage("com.android.email");
                this.f15558b.startActivity(intent);
            }
        } catch (Throwable e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    private void m20251e() {
        try {
            e.a("PushSelfShowLog", "enter launchApp, appPackageName =" + this.f15559c.f15604z);
            if (C4203a.m20432b(this.f15558b, this.f15559c.f15604z)) {
                m20252f();
                return;
            }
            try {
                e.e("PushSelfShowLog", "insert into db message.getMsgId() is " + this.f15559c.m20260a() + ",message.appPackageName is " + this.f15559c.f15604z);
                C4199a.m20395a(this.f15558b, this.f15559c.m20260a(), this.f15559c.f15604z);
            } catch (Throwable e) {
                e.d("PushSelfShowLog", "launchApp not exist ,insertAppinfo error", e);
            }
            Intent intent = null;
            if (C4203a.m20418a(this.f15558b, "com.huawei.appmarket", new Intent("com.huawei.appmarket.intent.action.AppDetail")).booleanValue()) {
                e.a("PushSelfShowLog", "app not exist && appmarkt exist ,so open appmarket");
                intent = new Intent("com.huawei.appmarket.intent.action.AppDetail");
                intent.putExtra("APP_PACKAGENAME", this.f15559c.f15604z);
                intent.setPackage("com.huawei.appmarket");
                intent.setFlags(402653184);
                e.a("PushSelfShowLog", "hwAppmarket only support com.huawei.appmarket.intent.action.AppDetail!");
                C4203a.m20424a(this.f15558b, "7", this.f15559c);
            }
            if (intent != null) {
                e.a("PushSelfShowLog", "intent is not null " + intent.toURI());
                this.f15558b.startActivity(intent);
                return;
            }
            e.a("PushSelfShowLog", "intent is null ");
        } catch (Exception e2) {
            e.d("PushSelfShowLog", "launchApp error:" + e2.toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m20252f() {
        /*
        r5 = this;
        r0 = "PushSelfShowLog";
        r1 = "run into launchCosaApp ";
        com.huawei.android.pushagent.c.a.e.e(r0, r1);
        r0 = "PushSelfShowLog";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b2 }
        r1.<init>();	 Catch:{ Exception -> 0x00b2 }
        r2 = "enter launchExistApp cosa, appPackageName =";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00b2 }
        r2 = r5.f15559c;	 Catch:{ Exception -> 0x00b2 }
        r2 = r2.f15604z;	 Catch:{ Exception -> 0x00b2 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00b2 }
        r2 = ",and msg.intentUri is ";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00b2 }
        r2 = r5.f15559c;	 Catch:{ Exception -> 0x00b2 }
        r2 = r2.f15584f;	 Catch:{ Exception -> 0x00b2 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00b2 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00b2 }
        com.huawei.android.pushagent.c.a.e.a(r0, r1);	 Catch:{ Exception -> 0x00b2 }
        r0 = r5.f15558b;	 Catch:{ Exception -> 0x00b2 }
        r1 = r5.f15559c;	 Catch:{ Exception -> 0x00b2 }
        r1 = r1.f15604z;	 Catch:{ Exception -> 0x00b2 }
        r1 = com.huawei.android.pushselfshow.utils.C4203a.m20417a(r0, r1);	 Catch:{ Exception -> 0x00b2 }
        r0 = r5.f15559c;	 Catch:{ Exception -> 0x00b2 }
        r0 = r0.f15584f;	 Catch:{ Exception -> 0x00b2 }
        if (r0 == 0) goto L_0x008b;
    L_0x0042:
        r0 = r5.f15559c;	 Catch:{ Exception -> 0x0081 }
        r0 = r0.f15584f;	 Catch:{ Exception -> 0x0081 }
        r2 = 0;
        r0 = android.content.Intent.parseUri(r0, r2);	 Catch:{ Exception -> 0x0081 }
        r2 = "PushSelfShowLog";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0081 }
        r3.<init>();	 Catch:{ Exception -> 0x0081 }
        r4 = "Intent.parseUri(msg.intentUri, 0)，";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0081 }
        r4 = r0.toURI();	 Catch:{ Exception -> 0x0081 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0081 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0081 }
        com.huawei.android.pushagent.c.a.e.a(r2, r3);	 Catch:{ Exception -> 0x0081 }
        r2 = r5.f15558b;	 Catch:{ Exception -> 0x0081 }
        r3 = r5.f15559c;	 Catch:{ Exception -> 0x0081 }
        r3 = r3.f15604z;	 Catch:{ Exception -> 0x0081 }
        r2 = com.huawei.android.pushselfshow.utils.C4203a.m20418a(r2, r3, r0);	 Catch:{ Exception -> 0x0081 }
        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x0081 }
        if (r2 == 0) goto L_0x00e7;
    L_0x0077:
        if (r0 != 0) goto L_0x00bd;
    L_0x0079:
        r0 = "PushSelfShowLog";
        r1 = "launchCosaApp,intent == null";
        com.huawei.android.pushagent.c.a.e.a(r0, r1);	 Catch:{ Exception -> 0x00b2 }
    L_0x0080:
        return;
    L_0x0081:
        r0 = move-exception;
        r2 = "PushSelfShowLog";
        r3 = "intentUri error ";
        com.huawei.android.pushagent.c.a.e.a(r2, r3, r0);	 Catch:{ Exception -> 0x00b2 }
        r0 = r1;
        goto L_0x0077;
    L_0x008b:
        r0 = r5.f15559c;	 Catch:{ Exception -> 0x00b2 }
        r0 = r0.f15560A;	 Catch:{ Exception -> 0x00b2 }
        if (r0 == 0) goto L_0x00e5;
    L_0x0091:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x00b2 }
        r2 = r5.f15559c;	 Catch:{ Exception -> 0x00b2 }
        r2 = r2.f15560A;	 Catch:{ Exception -> 0x00b2 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x00b2 }
        r2 = r5.f15558b;	 Catch:{ Exception -> 0x00b2 }
        r3 = r5.f15559c;	 Catch:{ Exception -> 0x00b2 }
        r3 = r3.f15604z;	 Catch:{ Exception -> 0x00b2 }
        r2 = com.huawei.android.pushselfshow.utils.C4203a.m20418a(r2, r3, r0);	 Catch:{ Exception -> 0x00b2 }
        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x00b2 }
        if (r2 == 0) goto L_0x00e5;
    L_0x00aa:
        r1 = r5.f15559c;	 Catch:{ Exception -> 0x00b2 }
        r1 = r1.f15604z;	 Catch:{ Exception -> 0x00b2 }
        r0.setPackage(r1);	 Catch:{ Exception -> 0x00b2 }
        goto L_0x0077;
    L_0x00b2:
        r0 = move-exception;
        r1 = "PushSelfShowLog";
        r2 = r0.toString();
        com.huawei.android.pushagent.c.a.e.c(r1, r2, r0);
        goto L_0x0080;
    L_0x00bd:
        r1 = 805437440; // 0x30020000 float:4.7293724E-10 double:3.97938969E-315;
        r0.setFlags(r1);	 Catch:{ Exception -> 0x00b2 }
        r1 = "PushSelfShowLog";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b2 }
        r2.<init>();	 Catch:{ Exception -> 0x00b2 }
        r3 = "start ";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00b2 }
        r3 = r0.toURI();	 Catch:{ Exception -> 0x00b2 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00b2 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00b2 }
        com.huawei.android.pushagent.c.a.e.a(r1, r2);	 Catch:{ Exception -> 0x00b2 }
        r1 = r5.f15558b;	 Catch:{ Exception -> 0x00b2 }
        r1.startActivity(r0);	 Catch:{ Exception -> 0x00b2 }
        goto L_0x0080;
    L_0x00e5:
        r0 = r1;
        goto L_0x00aa;
    L_0x00e7:
        r0 = r1;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.a.a.f():void");
    }

    private void m20253g() {
        try {
            e.e("PushSelfShowLog", "run into launchRichPush ");
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(this.f15559c.f15591m, "com.huawei.android.pushselfshow.richpush.RichPushActivity"));
            intent.putExtra("type", this.f15559c.f15563D);
            intent.putExtra("selfshow_info", this.f15559c.m20262c());
            intent.putExtra("selfshow_token", this.f15559c.m20263d());
            intent.setFlags(268468240);
            intent.setPackage(this.f15559c.f15591m);
            this.f15558b.startActivity(intent);
        } catch (Throwable e) {
            e.c("PushSelfShowLog", "launchRichPush failed", e);
        }
    }

    public void m20254a() {
        e.a("PushSelfShowLog", "enter launchNotify()");
        if (this.f15558b == null || this.f15559c == null) {
            e.a("PushSelfShowLog", "launchNotify  context or msg is null");
        } else if ("app".equals(this.f15559c.f15593o)) {
            m20251e();
        } else if ("cosa".equals(this.f15559c.f15593o)) {
            m20252f();
        } else if ("email".equals(this.f15559c.f15593o)) {
            m20250d();
        } else if ("phone".equals(this.f15559c.f15593o)) {
            m20249c();
        } else if ("rp".equals(this.f15559c.f15593o)) {
            m20253g();
        } else if ("url".equals(this.f15559c.f15593o)) {
            m20248b();
        } else {
            e.a("PushSelfShowLog", this.f15559c.f15593o + " is not exist in hShowType");
        }
    }
}
