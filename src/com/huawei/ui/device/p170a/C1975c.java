package com.huawei.ui.device.p170a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.c.a;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.k.a.d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: CompatibilityInteractor */
public class C1975c {
    private Gson f6902a = new Gson();

    private void m10370b(Handler handler, long j, long j2, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("CompatibilityInteractor", "getDeviceListSizeFromHealth time:" + j + " currentTime:" + j2);
        if (handler != null) {
            Message message = new Message();
            message.what = 100;
            message.obj = iBaseResponseCallback;
            handler.sendMessageDelayed(message, 500);
        }
        C1988p.m10381a(BaseApplication.m2632b()).m10393b(new C1976d(this, handler, iBaseResponseCallback, j2, j));
    }

    public void m10375a(a aVar, int i, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("CompatibilityInteractor", "isHuaweiWearBinded productId:" + i + " healthType:" + com.huawei.al.a.a(i));
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(new C1977e(this, aVar, iBaseResponseCallback, newSingleThreadExecutor));
    }

    public void m10372a(Context context, int i, a aVar, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("CompatibilityInteractor", "isSupportInHealth productType:" + i);
        Executors.newSingleThreadExecutor().execute(new C1979g(this, i, context, iBaseResponseCallback, aVar));
    }

    public void m10373a(Handler handler, long j, long j2, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("CompatibilityInteractor", "Enter unBindHealthDevice");
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(new C1981i(this, iBaseResponseCallback, handler, j2, j, newSingleThreadExecutor));
    }

    public static boolean m10369a(Context context) {
        boolean z;
        String a = C0996a.m3612a(context, String.valueOf(10000), "health_support_current_type_version");
        C2538c.m12677c("CompatibilityInteractor", "isHealthVersionSupport lowVersion:" + a);
        if (TextUtils.isEmpty(a)) {
            z = false;
        } else {
            C2538c.m12677c("CompatibilityInteractor", "isHealthVersionSupport versionCode1:" + new d(BaseApplication.m2632b()).a(WeChat.HEALTH_PACKAGE_NAME));
            C2538c.m12677c("CompatibilityInteractor", "isHealthVersionSupport versionCode2:" + C0977d.m3546c(BaseApplication.m2632b(), a));
            z = new d(BaseApplication.m2632b()).a(WeChat.HEALTH_PACKAGE_NAME) >= C0977d.m3546c(BaseApplication.m2632b(), a);
        }
        C2538c.m12680e("CompatibilityInteractor", "isHealthVersionSupport res:" + z);
        return z;
    }

    public boolean m10376a() {
        boolean z;
        C2538c.m12677c("CompatibilityInteractor", "isSupportForce:" + C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(10000), "health_support_force_migrate_"));
        if ("true".equalsIgnoreCase(C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(10000), "health_support_force_migrate_")) && C1975c.m10369a(BaseApplication.m2632b())) {
            z = true;
        } else {
            z = false;
        }
        C2538c.m12677c("CompatibilityInteractor", "isForceMigrateGoToHealth:" + z);
        return z;
    }

    public boolean m10378b() {
        boolean z;
        C2538c.m12677c("CompatibilityInteractor", "isSupport:" + C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(10000), "health_support_note_migrate_"));
        if ("true".equalsIgnoreCase(C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(10000), "health_support_note_migrate_")) && C1975c.m10369a(BaseApplication.m2632b())) {
            z = true;
        } else {
            z = false;
        }
        C2538c.m12677c("CompatibilityInteractor", "isGoToHealth:" + z);
        return z;
    }

    public void m10374a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("CompatibilityInteractor", "Enter getCommonData commonType:");
        Handler handler = new Handler();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(new C1983k(this, handler, iBaseResponseCallback, newSingleThreadExecutor));
        handler.postDelayed(new C1985m(this, iBaseResponseCallback), 2000);
    }

    public void m10371a(int i, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("CompatibilityInteractor", "Enter isSupport");
        m10374a(new C1986n(this, i, iBaseResponseCallback));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m10377a(int r8) {
        /*
        r7 = this;
        r6 = 1;
        r1 = 0;
        r0 = com.huawei.hwcommonmodel.application.BaseApplication.m2632b();
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r2 = java.lang.String.valueOf(r2);
        r3 = "UNION_HEALTH_SUPPORT_LIST";
        r0 = com.huawei.hwdataaccessmodel.sharedpreference.C0996a.m3612a(r0, r2, r3);
        r2 = "CompatibilityInteractor";
        r3 = new java.lang.Object[r6];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Enter isHealthSupport deviceType:";
        r4 = r4.append(r5);
        r4 = r4.append(r8);
        r5 = " json:";
        r4 = r4.append(r5);
        r4 = r4.append(r0);
        r4 = r4.toString();
        r3[r1] = r4;
        com.huawei.p190v.C2538c.m12677c(r2, r3);
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ JsonSyntaxException -> 0x0087 }
        if (r2 == 0) goto L_0x0075;
    L_0x003e:
        r0 = new com.huawei.datatype.HealthSupportModel;	 Catch:{ JsonSyntaxException -> 0x0087 }
        r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0087 }
    L_0x0043:
        if (r0 != 0) goto L_0x004a;
    L_0x0045:
        r0 = new com.huawei.datatype.HealthSupportModel;	 Catch:{ JsonSyntaxException -> 0x0087 }
        r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0087 }
    L_0x004a:
        switch(r8) {
            case 7: goto L_0x00c8;
            case 8: goto L_0x00af;
            case 9: goto L_0x004d;
            case 10: goto L_0x00aa;
            case 11: goto L_0x00cd;
            case 12: goto L_0x00b4;
            case 13: goto L_0x00b9;
            case 14: goto L_0x00be;
            case 15: goto L_0x00c3;
            default: goto L_0x004d;
        };
    L_0x004d:
        r0 = r1;
    L_0x004e:
        r2 = "CompatibilityInteractor";
        r3 = new java.lang.Object[r6];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "isHealthSupport deviceType:";
        r4 = r4.append(r5);
        r4 = r4.append(r8);
        r5 = "res:";
        r4 = r4.append(r5);
        r4 = r4.append(r0);
        r4 = r4.toString();
        r3[r1] = r4;
        com.huawei.p190v.C2538c.m12677c(r2, r3);
        return r0;
    L_0x0075:
        r2 = r7.f6902a;	 Catch:{ JsonSyntaxException -> 0x0080 }
        r3 = com.huawei.datatype.HealthSupportModel.class;
        r0 = r2.fromJson(r0, r3);	 Catch:{ JsonSyntaxException -> 0x0080 }
        r0 = (com.huawei.datatype.HealthSupportModel) r0;	 Catch:{ JsonSyntaxException -> 0x0080 }
        goto L_0x0043;
    L_0x0080:
        r0 = move-exception;
        r0 = new com.huawei.datatype.HealthSupportModel;	 Catch:{ JsonSyntaxException -> 0x0087 }
        r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0087 }
        goto L_0x0043;
    L_0x0087:
        r0 = move-exception;
        r2 = "CompatibilityInteractor";
        r3 = new java.lang.Object[r6];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "JsonSyntaxException:";
        r4 = r4.append(r5);
        r0 = r0.toString();
        r0 = r4.append(r0);
        r0 = r0.toString();
        r3[r1] = r0;
        com.huawei.p190v.C2538c.m12677c(r2, r3);
        r0 = r1;
        goto L_0x004e;
    L_0x00aa:
        r0 = r0.isSupportLeo();	 Catch:{ JsonSyntaxException -> 0x0087 }
        goto L_0x004e;
    L_0x00af:
        r0 = r0.isSupportMetis();	 Catch:{ JsonSyntaxException -> 0x0087 }
        goto L_0x004e;
    L_0x00b4:
        r0 = r0.isSupportA2();	 Catch:{ JsonSyntaxException -> 0x0087 }
        goto L_0x004e;
    L_0x00b9:
        r0 = r0.isSupportNyx();	 Catch:{ JsonSyntaxException -> 0x0087 }
        goto L_0x004e;
    L_0x00be:
        r0 = r0.isSupportB3Lite();	 Catch:{ JsonSyntaxException -> 0x0087 }
        goto L_0x004e;
    L_0x00c3:
        r0 = r0.isSupportEris();	 Catch:{ JsonSyntaxException -> 0x0087 }
        goto L_0x004e;
    L_0x00c8:
        r0 = r0.isSupportB3();	 Catch:{ JsonSyntaxException -> 0x0087 }
        goto L_0x004e;
    L_0x00cd:
        r0 = r0.isSupportR1();	 Catch:{ JsonSyntaxException -> 0x0087 }
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.ui.device.a.c.a(int):boolean");
    }
}
