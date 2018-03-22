package com.amap.api.location;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.location.C3184a.C3183a;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.C3189a;
import com.aps.ac;
import com.aps.ap;
import com.aps.bf;
import com.aps.bg;
import com.huawei.hwid.core.constants.HwAccountConstants;

/* compiled from: IAPSManager */
public class C3188c implements Runnable {
    bg f10665a = null;
    volatile boolean f10666b = false;
    boolean f10667c = true;
    private volatile boolean f10668d = false;
    private Context f10669e;
    private long f10670f = 2000;
    private C3183a f10671g;
    private C3184a f10672h;
    private boolean f10673i = false;

    C3188c(Context context, C3183a c3183a, C3184a c3184a) {
        this.f10672h = c3184a;
        m14103b(false);
        this.f10669e = context;
        this.f10665a = new ac();
        this.f10671g = c3183a;
    }

    synchronized void m14098a(boolean z) {
        this.f10666b = z;
    }

    public synchronized boolean m14099a() {
        return this.f10666b;
    }

    synchronized void m14100b() {
        m14098a(true);
        if (!this.f10668d) {
            m14104c();
        }
        if (this.f10672h != null) {
            this.f10672h.m14078b();
        }
        this.f10673i = false;
    }

    synchronized void m14104c() {
        if (this.f10665a != null) {
            this.f10665a.mo4147b();
        }
        this.f10665a = null;
    }

    synchronized void m14103b(boolean z) {
        this.f10668d = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m14091d() {
        /*
        r5 = this;
        r0 = r5.f10669e;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        com.amap.api.location.core.C3191c.m14119a(r0);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = r5.f10665a;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r5.f10665a;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1 = r5.f10669e;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0.mo4142a(r1);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
    L_0x0010:
        r0 = r5.f10665a;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        if (r0 == 0) goto L_0x0040;
    L_0x0014:
        r0 = r5.f10665a;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1.<init>();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2 = "api_serverSDK_130905##S128DF1572465B890OE3F7A13167KLEI##";
        r1 = r1.append(r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2 = r5.f10669e;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2 = com.amap.api.location.core.C3191c.m14123b(r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1 = r1.append(r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2 = ",";
        r1 = r1.append(r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2 = com.amap.api.location.core.C3191c.m14122b();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1 = r1.append(r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0.mo4145a(r1);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
    L_0x0040:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1.<init>();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = "key";
        r2 = r5.f10669e;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2 = com.amap.api.location.core.C3191c.m14123b(r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r1.put(r0, r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = "X-INFO";
        r2 = r5.f10669e;	 Catch:{ Throwable -> 0x0098, JSONException -> 0x009d }
        r2 = com.amap.api.location.core.C3191c.m14119a(r2);	 Catch:{ Throwable -> 0x0098, JSONException -> 0x009d }
        r3 = "loc";
        r2 = r2.m14134a(r3);	 Catch:{ Throwable -> 0x0098, JSONException -> 0x009d }
        r1.put(r0, r2);	 Catch:{ Throwable -> 0x0098, JSONException -> 0x009d }
    L_0x0061:
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r2.<init>();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = r5.f10669e;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = com.amap.api.location.core.C3191c.m14119a(r0);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = r0.m14136c();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r3 = "ex";
        r4 = "UTF-8";
        r0 = r0.getBytes(r4);	 Catch:{ UnsupportedEncodingException -> 0x00a2 }
        r0 = com.amap.api.location.core.C3190b.m14117a(r0);	 Catch:{ UnsupportedEncodingException -> 0x00a2 }
        r2.put(r3, r0);	 Catch:{ UnsupportedEncodingException -> 0x00a2 }
    L_0x007f:
        r0 = "X-BIZ";
        r1.put(r0, r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = "User-Agent";
        r2 = "AMAP Location SDK Android 1.3.3";
        r1.put(r0, r2);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0 = r5.f10665a;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        if (r0 == 0) goto L_0x0094;
    L_0x008f:
        r0 = r5.f10665a;	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        r0.mo4146a(r1);	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
    L_0x0094:
        r0 = 1;
        r5.f10673i = r0;
        return;
    L_0x0098:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        goto L_0x0061;
    L_0x009d:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0094;
    L_0x00a2:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ JSONException -> 0x009d, Throwable -> 0x00a7 }
        goto L_0x007f;
    L_0x00a7:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0094;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.c.d():void");
    }

    public void run() {
        Message message;
        Throwable th;
        AMapLocation aMapLocation;
        Looper.prepare();
        if (m14099a()) {
            m14104c();
            return;
        }
        if (!this.f10673i && this.f10668d) {
            m14091d();
        }
        while (this.f10668d && !Thread.currentThread().isInterrupted() && !m14099a()) {
            Object obj = null;
            try {
                if ((this.f10672h.f10638d && !m14094g()) || !this.f10672h.f10640f) {
                    try {
                        this.f10667c = true;
                        Thread.sleep(this.f10670f);
                        if (null != null) {
                            if (this.f10672h.f10640f && (!this.f10672h.f10638d || m14094g())) {
                                message = new Message();
                                message.obj = null;
                                message.what = 100;
                                this.f10671g.sendMessage(message);
                            }
                        }
                        if (C3189a.m14106a() == -1) {
                            C3189a.m14108a(this.f10669e);
                            C3189a.m14111b(this.f10669e);
                        }
                        if (this.f10667c) {
                            Thread.sleep(this.f10670f);
                        } else {
                            Thread.sleep(StatisticConfig.MIN_UPLOAD_INTERVAL);
                        }
                    } catch (Throwable th2) {
                        if (null != null) {
                            if (this.f10672h.f10640f && (!this.f10672h.f10638d || m14094g())) {
                                message = new Message();
                                message.obj = null;
                                message.what = 100;
                                this.f10671g.sendMessage(message);
                            }
                        }
                        if (C3189a.m14106a() == -1) {
                            C3189a.m14108a(this.f10669e);
                            C3189a.m14111b(this.f10669e);
                        }
                        if (this.f10667c) {
                            Thread.sleep(this.f10670f);
                        } else {
                            Thread.sleep(StatisticConfig.MIN_UPLOAD_INTERVAL);
                        }
                    }
                } else if (this.f10672h == null || this.f10672h.f10635a.size() >= 0) {
                    ap e = m14092e();
                    if (e != null) {
                        obj = m14090a(e);
                    }
                    if (obj != null) {
                        try {
                            if (this.f10672h.f10640f && (!this.f10672h.f10638d || m14094g())) {
                                message = new Message();
                                message.obj = obj;
                                message.what = 100;
                                this.f10671g.sendMessage(message);
                            }
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    if (C3189a.m14106a() == -1) {
                        C3189a.m14108a(this.f10669e);
                        C3189a.m14111b(this.f10669e);
                    }
                    if (this.f10667c) {
                        Thread.sleep(this.f10670f);
                    } else {
                        Thread.sleep(StatisticConfig.MIN_UPLOAD_INTERVAL);
                    }
                } else {
                    if (null != null) {
                        if (this.f10672h.f10640f && (!this.f10672h.f10638d || m14094g())) {
                            message = new Message();
                            message.obj = null;
                            message.what = 100;
                            this.f10671g.sendMessage(message);
                        }
                    }
                    if (C3189a.m14106a() == -1) {
                        C3189a.m14108a(this.f10669e);
                        C3189a.m14111b(this.f10669e);
                    }
                    if (this.f10667c) {
                        Thread.sleep(this.f10670f);
                    } else {
                        Thread.sleep(StatisticConfig.MIN_UPLOAD_INTERVAL);
                    }
                }
            } catch (Throwable th4) {
            }
        }
        if (m14099a()) {
            m14104c();
            return;
        }
        return;
        if (obj != null) {
            if (this.f10672h.f10640f && (!this.f10672h.f10638d || m14094g())) {
                Message message2 = new Message();
                message2.obj = obj;
                message2.what = 100;
                this.f10671g.sendMessage(message2);
            }
        }
        if (C3189a.m14106a() == -1) {
            C3189a.m14108a(this.f10669e);
            C3189a.m14111b(this.f10669e);
        }
        if (this.f10667c) {
            Thread.sleep(this.f10670f);
        } else {
            Thread.sleep(StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
        throw th3;
    }

    void m14095a(long j) {
        if (j > this.f10670f) {
            this.f10670f = j;
        }
    }

    private ap m14092e() throws Exception {
        ap f = m14093f();
        if (f != null) {
            return f;
        }
        f = new ap();
        f.m17288a(new AMapLocException("未知的错误"));
        this.f10667c = false;
        return f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.aps.ap m14093f() {
        /*
        r4 = this;
        r2 = 0;
        r1 = 0;
        r0 = r4.f10665a;	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x0023 }
        if (r0 == 0) goto L_0x002f;
    L_0x0006:
        r0 = r4.f10665a;	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x0023 }
        r0 = r0.mo4140a();	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x0023 }
    L_0x000c:
        if (r0 != 0) goto L_0x0012;
    L_0x000e:
        r1 = 0;
        r4.f10667c = r1;	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x002d }
    L_0x0011:
        return r0;
    L_0x0012:
        r1 = 1;
        r4.f10667c = r1;	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x002d }
        goto L_0x0011;
    L_0x0016:
        r0 = move-exception;
        r1 = r0;
        r0 = new com.aps.ap;
        r0.<init>();
        r0.m17288a(r1);
        r4.f10667c = r2;
        goto L_0x0011;
    L_0x0023:
        r0 = move-exception;
        r3 = r0;
        r0 = r1;
        r1 = r3;
    L_0x0027:
        r4.f10667c = r2;
        r1.printStackTrace();
        goto L_0x0011;
    L_0x002d:
        r1 = move-exception;
        goto L_0x0027;
    L_0x002f:
        r0 = r1;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.c.f():com.aps.ap");
    }

    private boolean m14094g() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.f10672h.f10643i <= 10000 || elapsedRealtime - this.f10672h.f10639e <= 10000) {
            return false;
        }
        this.f10672h.f10638d = false;
        return true;
    }

    private AMapLocation m14090a(ap apVar) {
        AMapLocation aMapLocation = new AMapLocation("");
        aMapLocation.setProvider(LocationProviderProxy.AMapNetwork);
        aMapLocation.setLatitude(apVar.m17301f());
        aMapLocation.setLongitude(apVar.m17299e());
        aMapLocation.setAccuracy(apVar.m17303g());
        aMapLocation.setTime(apVar.m17305h());
        aMapLocation.setPoiId(apVar.m17291b());
        aMapLocation.setFloor(apVar.m17295c());
        aMapLocation.setCountry(apVar.m17317n());
        aMapLocation.setRoad(apVar.m17323q());
        aMapLocation.setPoiName(apVar.m17326s());
        aMapLocation.setAMapException(apVar.m17284a());
        Bundle bundle = new Bundle();
        bundle.putString("citycode", apVar.m17311k());
        bundle.putString("desc", apVar.m17313l());
        bundle.putString("adcode", apVar.m17315m());
        aMapLocation.setExtras(bundle);
        String k = apVar.m17311k();
        String l = apVar.m17313l();
        String m = apVar.m17315m();
        aMapLocation.setCityCode(k);
        aMapLocation.setAdCode(m);
        if (m == null || m.trim().length() <= 0) {
            aMapLocation.setAddress(l);
        } else {
            aMapLocation.setAddress(l.replace(HwAccountConstants.BLANK, ""));
        }
        aMapLocation.setCity(apVar.m17321p());
        aMapLocation.setDistrict(apVar.m17297d());
        aMapLocation.m14057a(apVar.m17325r());
        aMapLocation.setProvince(apVar.m17319o());
        return aMapLocation;
    }

    void m14097a(bf bfVar, PendingIntent pendingIntent) {
        this.f10665a.mo4144a(bfVar, pendingIntent);
    }

    void m14102b(bf bfVar, PendingIntent pendingIntent) {
        this.f10665a.mo4149b(bfVar, pendingIntent);
    }

    void m14096a(PendingIntent pendingIntent) {
        this.f10665a.mo4141a(pendingIntent);
    }

    void m14101b(PendingIntent pendingIntent) {
        this.f10665a.mo4148b(pendingIntent);
    }
}
