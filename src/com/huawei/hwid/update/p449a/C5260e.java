package com.huawei.hwid.update.p449a;

import android.content.Context;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.d.a;
import com.huawei.hwid.p075d.C5207c;
import com.huawei.hwid.p075d.C5209d;
import com.huawei.hwid.update.p449a.p450a.C5252a;
import com.huawei.hwid.update.p449a.p450a.C5253b;
import com.huawei.hwid.update.p449a.p450a.C5254c;
import com.huawei.hwid.update.p451b.C5271a;
import com.huawei.hwid.update.p451b.C5272d;
import com.huawei.hwid.update.p451b.C5273b;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* compiled from: OtaUpdateCheck */
public class C5260e implements C5252a {
    private final Context f18922a;
    private final C5272d f18923b = new C5273b();
    private C5253b f18924c;
    private String f18925d;
    private C5254c f18926e;

    public C5260e(Context context) {
        this.f18922a = context.getApplicationContext();
    }

    private synchronized void m25497b(C5253b c5253b) {
        this.f18924c = c5253b;
    }

    private synchronized void m25496a(int i) {
        if (this.f18924c != null) {
            this.f18924c.mo4657a(i, this.f18926e);
        }
    }

    public Context mo4651a() {
        return this.f18922a;
    }

    public void mo4654b() {
        C5165e.m24906b("OtaUpdateCheck", "Enter cancel.");
        m25497b(null);
        this.f18923b.mo4662b();
    }

    public void mo4652a(C5253b c5253b) {
        a.a(c5253b, "callback must not be null.");
        C5165e.m24906b("OtaUpdateCheck", "Enter checkUpdate.");
        m25497b(c5253b);
        this.f18926e = new C5254c();
        this.f18926e.m25473a(this.f18922a);
        int b = new C5209d(this.f18922a).m25339b("com.huawei.hwid");
        if (this.f18926e.m25474a() && this.f18926e.f18889a <= b) {
            C5165e.m24906b("OtaUpdateCheck", "has the newest version");
            m25496a(2205);
        } else if (!this.f18926e.m25474a() || this.f18926e.f18889a < 20300000) {
            try {
                m25498c();
            } catch (C5271a e) {
                C5165e.m24908c("OtaUpdateCheck", "In checkUpdate, Canceled to download the update file.");
                m25496a((int) IssueTrafficCardCallback.RETURN_FAILED_CARD_CNT_REACH_LIMIT);
            }
        } else {
            C5165e.m24906b("OtaUpdateCheck", "has checked version ok");
            m25496a(1000);
        }
    }

    public void mo4653a(C5253b c5253b, C5254c c5254c) {
        throw new IllegalStateException("Not supported.");
    }

    private void m25498c() throws C5271a {
        C5165e.m24906b("OtaUpdateCheck", "Enter checkUpdate.");
        try {
            int d = m25499d();
            if (d != 200) {
                C5165e.m24910d("OtaUpdateCheck", "In CheckUpdateHelper.checkUpdate, Check whether has a new version, HTTP code: " + d);
                m25496a(1201);
            } else if (this.f18925d == null) {
                C5165e.m24906b("OtaUpdateCheck", "has no new version");
                m25496a(1202);
            } else {
                d = m25500e();
                if (d != 200) {
                    C5165e.m24910d("OtaUpdateCheck", "In CheckUpdateHelper.checkUpdate, Request the update-info of the new version, HTTP code: " + d);
                    m25496a(1201);
                } else if (this.f18926e == null || this.f18926e.f18889a < 20300000) {
                    C5165e.m24906b("OtaUpdateCheck", "check_no_supported");
                    m25496a(1203);
                } else {
                    if (this.f18926e.f18889a <= new C5209d(this.f18922a).m25339b("com.huawei.hwid")) {
                        C5165e.m24906b("OtaUpdateCheck", "ota_check_already_newest_version");
                        m25496a(2205);
                        return;
                    }
                    this.f18926e.m25475b(this.f18922a);
                    m25496a(1000);
                }
            }
        } catch (IOException e) {
            C5165e.m24910d("OtaUpdateCheck", "In CheckUpdateHelper.checkUpdate, Failed to check update." + e.getMessage());
            m25496a(1201);
        }
    }

    private int m25499d() throws IOException, C5271a {
        Throwable th;
        InputStream inputStream = null;
        OutputStream byteArrayOutputStream;
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(new C5256a(this.f18922a).m25478a().toString().getBytes(Charset.defaultCharset()));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    int a = this.f18923b.mo4658a("https://query.hicloud.com/hwid/v2/CheckEx.action", byteArrayInputStream, byteArrayOutputStream);
                    if (a != 200) {
                        C5207c.m25334a(byteArrayOutputStream);
                        C5207c.m25333a(byteArrayInputStream);
                        this.f18923b.mo4661a();
                    } else {
                        this.f18925d = C5257b.m25479a(new String(byteArrayOutputStream.toByteArray(), GameManager.DEFAULT_CHARSET)).m25481a();
                        C5207c.m25334a(byteArrayOutputStream);
                        C5207c.m25333a(byteArrayInputStream);
                        this.f18923b.mo4661a();
                    }
                    return a;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = byteArrayInputStream;
                    C5207c.m25334a(byteArrayOutputStream);
                    C5207c.m25333a(inputStream);
                    this.f18923b.mo4661a();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                inputStream = byteArrayInputStream;
                C5207c.m25334a(byteArrayOutputStream);
                C5207c.m25333a(inputStream);
                this.f18923b.mo4661a();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            C5207c.m25334a(byteArrayOutputStream);
            C5207c.m25333a(inputStream);
            this.f18923b.mo4661a();
            throw th;
        }
    }

    private int m25500e() throws IOException, C5271a {
        Throwable th;
        OutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                int a = this.f18923b.mo4659a(this.f18925d + "full/filelist.xml", byteArrayOutputStream);
                if (a != 200) {
                    C5207c.m25334a(byteArrayOutputStream);
                    this.f18923b.mo4661a();
                } else {
                    C5259d a2 = C5259d.m25489a(new String(byteArrayOutputStream.toByteArray(), GameManager.DEFAULT_CHARSET));
                    this.f18926e = new C5254c(a2.m25495d(), this.f18925d + "full" + "/" + a2.m25492a(), a2.m25493b(), a2.m25494c());
                    C5207c.m25334a(byteArrayOutputStream);
                    this.f18923b.mo4661a();
                }
                return a;
            } catch (Throwable th2) {
                th = th2;
                C5207c.m25334a(byteArrayOutputStream);
                this.f18923b.mo4661a();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            C5207c.m25334a(byteArrayOutputStream);
            this.f18923b.mo4661a();
            throw th;
        }
    }
}
