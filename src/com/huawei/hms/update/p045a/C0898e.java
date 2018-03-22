package com.huawei.hms.update.p045a;

import android.content.Context;
import com.huawei.hms.p039c.C0852a;
import com.huawei.hms.p039c.C0854c;
import com.huawei.hms.support.log.C0887a;
import com.huawei.hms.update.p045a.p046a.C0890a;
import com.huawei.hms.update.p045a.p046a.C0891b;
import com.huawei.hms.update.p045a.p046a.C0892c;
import com.huawei.hms.update.p047b.C0909a;
import com.huawei.hms.update.p047b.C0910d;
import com.huawei.hms.update.p047b.C0911b;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* compiled from: OtaUpdateCheck */
public class C0898e implements C0890a {
    private final Context f1468a;
    private final C0910d f1469b = new C0911b();
    private C0891b f1470c;
    private String f1471d;
    private C0892c f1472e;

    public C0898e(Context context) {
        this.f1468a = context.getApplicationContext();
    }

    private synchronized void m3143b(C0891b c0891b) {
        this.f1470c = c0891b;
    }

    private synchronized void m3142a(int i) {
        if (this.f1470c != null) {
            this.f1470c.mo2270a(i, this.f1472e);
        }
    }

    public Context mo2264a() {
        return this.f1468a;
    }

    public void mo2267b() {
        C0887a.m3094b("OtaUpdateCheck", "Enter cancel.");
        m3143b(null);
        this.f1469b.mo2275b();
    }

    public void mo2265a(C0891b c0891b) {
        C0852a.m3001a(c0891b, "callback must not be null.");
        C0887a.m3094b("OtaUpdateCheck", "Enter checkUpdate.");
        m3143b(c0891b);
        this.f1472e = new C0892c();
        this.f1472e.m3119a(this.f1468a);
        if (!this.f1472e.m3120a() || this.f1472e.f1435a < 20502300) {
            try {
                m3144c();
                return;
            } catch (C0909a e) {
                C0887a.m3096c("OtaUpdateCheck", "In checkUpdate, Canceled to download the update file.");
                m3142a((int) IssueTrafficCardCallback.RETURN_FAILED_CARD_CNT_REACH_LIMIT);
                return;
            }
        }
        m3142a(1000);
    }

    public void mo2266a(C0891b c0891b, C0892c c0892c) {
        throw new IllegalStateException("Not supported.");
    }

    private void m3144c() throws C0909a {
        C0887a.m3094b("OtaUpdateCheck", "Enter checkUpdate.");
        try {
            int d = m3145d();
            if (d != 200) {
                C0887a.m3098d("OtaUpdateCheck", "In CheckUpdateHelper.checkUpdate, Check whether has a new version, HTTP code: " + d);
                m3142a(1201);
            } else if (this.f1471d == null) {
                m3142a(1202);
            } else {
                d = m3146e();
                if (d != 200) {
                    C0887a.m3098d("OtaUpdateCheck", "In CheckUpdateHelper.checkUpdate, Request the update-info of the new version, HTTP code: " + d);
                    m3142a(1201);
                } else if (this.f1472e == null || this.f1472e.f1435a < 20502300) {
                    m3142a(1203);
                } else {
                    this.f1472e.m3121b(this.f1468a);
                    m3142a(1000);
                }
            }
        } catch (IOException e) {
            C0887a.m3098d("OtaUpdateCheck", "In CheckUpdateHelper.checkUpdate, Failed to check update." + e.getMessage());
            m3142a(1201);
        }
    }

    private int m3145d() throws IOException, C0909a {
        OutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream = null;
        C0894a c0894a = new C0894a(this.f1468a);
        if (C0887a.m3093a()) {
            C0887a.m3092a("OtaUpdateCheck", "In doCheckUpdate, Check update params: " + c0894a.toString());
        }
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(c0894a.m3124a().toString().getBytes(Charset.defaultCharset()));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                inputStream = byteArrayInputStream;
                C0854c.m3010a(byteArrayOutputStream);
                C0854c.m3009a(inputStream);
                this.f1469b.mo2274a();
                throw th;
            }
            try {
                int a = this.f1469b.mo2271a("https://query.hicloud.com/hwid/v2/CheckEx.action", byteArrayInputStream, byteArrayOutputStream);
                if (a != 200) {
                    C0854c.m3010a(byteArrayOutputStream);
                    C0854c.m3009a(byteArrayInputStream);
                    this.f1469b.mo2274a();
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), GameManager.DEFAULT_CHARSET);
                    if (C0887a.m3093a()) {
                        C0887a.m3092a("OtaUpdateCheck", "In CheckUpdateHelper.doCheckUpdate, Check update response: " + str);
                    }
                    this.f1471d = C0895b.m3125a(str).m3127a();
                    C0854c.m3010a(byteArrayOutputStream);
                    C0854c.m3009a(byteArrayInputStream);
                    this.f1469b.mo2274a();
                }
                return a;
            } catch (Throwable th3) {
                th = th3;
                inputStream = byteArrayInputStream;
                C0854c.m3010a(byteArrayOutputStream);
                C0854c.m3009a(inputStream);
                this.f1469b.mo2274a();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            C0854c.m3010a(byteArrayOutputStream);
            C0854c.m3009a(inputStream);
            this.f1469b.mo2274a();
            throw th;
        }
    }

    private int m3146e() throws IOException, C0909a {
        Throwable th;
        OutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                int a = this.f1469b.mo2272a(this.f1471d + "full/filelist.xml", byteArrayOutputStream);
                if (a != 200) {
                    C0854c.m3010a(byteArrayOutputStream);
                    this.f1469b.mo2274a();
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), GameManager.DEFAULT_CHARSET);
                    if (C0887a.m3093a()) {
                        C0887a.m3092a("OtaUpdateCheck", "In doGetFilelist, Check update response: " + str);
                    }
                    C0897d a2 = C0897d.m3135a(str);
                    this.f1472e = new C0892c(a2.m3141d(), this.f1471d + "full" + "/" + a2.m3138a(), a2.m3139b(), a2.m3140c());
                    C0854c.m3010a(byteArrayOutputStream);
                    this.f1469b.mo2274a();
                }
                return a;
            } catch (Throwable th2) {
                th = th2;
                C0854c.m3010a(byteArrayOutputStream);
                this.f1469b.mo2274a();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            C0854c.m3010a(byteArrayOutputStream);
            this.f1469b.mo2274a();
            throw th;
        }
    }
}
