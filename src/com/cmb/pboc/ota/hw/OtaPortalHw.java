package com.cmb.pboc.ota.hw;

import com.cmb.pboc.logger.PbocLog;
import com.cmb.pboc.okhttp.OkHttpUtils;
import com.cmb.pboc.okhttp.https.Certificates;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okio.Buffer;

public class OtaPortalHw {
    private static final String f13459a = OtaPortalHw.class.getSimpleName();
    private static volatile OtaPortalHw f13460b;
    private OkHttpUtils f13461c = OkHttpUtils.m17743a();
    private long f13462d;
    private Callback f13463e = new C35421(this);

    class C35421 implements Callback {
        final /* synthetic */ OtaPortalHw f13458a;

        C35421(OtaPortalHw otaPortalHw) {
            this.f13458a = otaPortalHw;
        }

        public void onFailure(Call call, IOException iOException) {
            PbocLog.m17741d(OtaPortalHw.f13459a, "Http call on failure. " + iOException.getMessage());
            String str = "result=0001&opcode=SHOWMSG&data=网络通信失败，请稍后重试&exception=" + iOException.getMessage();
            PbocLog.m17741d(OtaPortalHw.f13459a, str);
            if (!call.isCanceled()) {
                PbocLog.m17738a(OtaPortalHw.f13459a, "Http request canceled.");
                call.cancel();
            }
            OtaValueHw.f13467d = str;
            PbocLog.m17738a(OtaPortalHw.f13459a, "Connection takes " + (System.currentTimeMillis() - this.f13458a.f13462d) + " ms.");
        }

        public void onResponse(Call call, Response response) {
            String string;
            PbocLog.m17738a(OtaPortalHw.f13459a, "Http call on response.");
            if (response.isSuccessful()) {
                PbocLog.m17738a(OtaPortalHw.f13459a, "Http Code: " + response.code());
                string = response.body().string();
                PbocLog.m17738a(OtaPortalHw.f13459a, "Http Response: " + string);
            } else {
                PbocLog.m17741d(OtaPortalHw.f13459a, "Unexpected Http Code: " + response.code());
                string = "result=0001&opcode=SHOWMSG&data=网络通信失败，请稍后重试";
                PbocLog.m17741d(OtaPortalHw.f13459a, response.body().string());
                PbocLog.m17741d(OtaPortalHw.f13459a, string);
            }
            OtaValueHw.f13467d = string;
            PbocLog.m17738a(OtaPortalHw.f13459a, "Connection takes " + (System.currentTimeMillis() - this.f13458a.f13462d) + " ms.");
        }
    }

    private OtaPortalHw() {
        if (this.f13461c == null) {
            PbocLog.m17741d(f13459a, "OkHttpUtils instance is null.");
            return;
        }
        this.f13461c.m17751a(new Buffer().writeUtf8(Certificates.f13449b).inputStream());
    }

    public static OtaPortalHw m17759a() {
        if (f13460b == null) {
            synchronized (OtaPortalHw.class) {
                if (f13460b == null) {
                    PbocLog.m17738a(f13459a, "Build OtaPortal.");
                    f13460b = new OtaPortalHw();
                }
            }
        }
        return f13460b;
    }

    public final void m17761a(int i, HashMap hashMap) {
        try {
            Map a = ParameterHw.m17764a(i, hashMap);
            this.f13462d = System.currentTimeMillis();
            String str = OtaValueHw.f13469f ? OtaValueHw.f13464a + ";token=" + OtaValueHw.f13468e : OtaValueHw.f13464a;
            PbocLog.m17738a(f13459a, str);
            this.f13461c.m17750a(str, a, this.f13463e);
        } catch (Exception e) {
            PbocLog.m17741d(f13459a, "Exception in post, Type " + i + " Error Message: " + e.getMessage());
            OtaValueHw.f13467d = "result=0001&opcode=SHOWMSG&data=网络通信失败，请稍后重试&exception=" + e.getMessage();
        }
    }
}
