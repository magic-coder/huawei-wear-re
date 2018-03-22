package com.huawei.bone.wxapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.hwcommonmodel.d.a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private Context f22917a;
    private IWXAPI f22918b;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Binder.getCallingUid() != Process.myUid()) {
            C2538c.c("WXEntryActivity", new Object[]{"onCreate Process Uid error"});
            finish();
            return;
        }
        C2538c.c("WXEntryActivity", new Object[]{"onCreate onCreate()"});
        this.f22917a = this;
        this.f22918b = WXAPIFactory.createWXAPI(this.f22917a.getApplicationContext(), WeChat.WEAR_APP_ID, false);
        this.f22918b.registerApp(WeChat.WEAR_APP_ID);
        try {
            this.f22918b.handleIntent(getIntent(), this);
        } catch (Exception e) {
            C2538c.e("WXEntryActivity", new Object[]{"onCreate", e.getMessage()});
            finish();
        }
    }

    protected void onStart() {
        super.onStart();
        C2538c.c("WXEntryActivity", new Object[]{" onStart()"});
    }

    protected void onResume() {
        super.onResume();
        C2538c.c("WXEntryActivity", new Object[]{" onResume()"});
    }

    protected void onPause() {
        super.onPause();
        C2538c.c("WXEntryActivity", new Object[]{" onPause()"});
    }

    protected void onStop() {
        super.onStop();
        C2538c.c("WXEntryActivity", new Object[]{" onStop()"});
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.c("WXEntryActivity", new Object[]{" onDestroy()"});
    }

    public void onReq(BaseReq baseReq) {
        C2538c.b("WXEntryActivity", new Object[]{"onResp(BaseResp req) req=" + baseReq});
        switch (baseReq.getType()) {
            case 3:
                C2538c.b("WXEntryActivity", new Object[]{" ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX"});
                break;
            case 4:
                C2538c.b("WXEntryActivity", new Object[]{" ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX"});
                break;
        }
        finish();
    }

    public void onResp(BaseResp baseResp) {
        C2538c.b("WXEntryActivity", new Object[]{" onResp(BaseResp resp) resp=", baseResp});
        if (1 == baseResp.getType()) {
            C2538c.b("WXEntryActivity", new Object[]{" onResp() ConstantsAPI.COMMAND_SENDAUTH == resp.getType()"});
            Object obj = ((Resp) baseResp).code;
            C2538c.b("WXEntryActivity", new Object[]{" onResp() code=", obj});
            if (TextUtils.isEmpty(obj) || this.f22917a == null) {
                C2538c.c("WXEntryActivity", new Object[]{" onResp() call finsh()"});
                a.a(getApplicationContext(), new Intent(WeChat.ACTION));
                finish();
                return;
            }
            String str = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx3d91f74f61accef0&secret=b675d4596c044a702435d7d721bd2716&code=" + obj + "&grant_type=authorization_code";
            C2538c.b("WXEntryActivity", new Object[]{"request==", str});
            new C6694b().execute(new String[]{str});
        } else if (2 == baseResp.getType()) {
            C2538c.b("WXEntryActivity", new Object[]{" onResp() resp = ", Integer.valueOf(baseResp.errCode)});
            switch (baseResp.errCode) {
            }
            C2538c.b("WXEntryActivity", new Object[]{" onResp() result = ", Integer.valueOf(0)});
            Toast.makeText(this, 0, 1).show();
            C2538c.c("WXEntryActivity", new Object[]{" onResp() will be finish().."});
            finish();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m30018a(java.lang.String r14) {
        /*
        r13 = this;
        r3 = 0;
        r11 = 1;
        r10 = 0;
        if (r14 == 0) goto L_0x000d;
    L_0x0005:
        r0 = "";
        r0 = r14.equals(r0);
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        r0 = "urlStr = null";
    L_0x000f:
        return r0;
    L_0x0010:
        r5 = "";
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r0.<init>(r14);	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r1 = "WXEntryActivity";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r4 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r6.<init>();	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r7 = "doGet===";
        r6 = r6.append(r7);	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r7 = r0.toString();	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r6 = r6.append(r7);	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r6 = r6.toString();	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r2[r4] = r6;	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        com.huawei.v.c.b(r1, r2);	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r0 = r0.openConnection();	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r1 = org.apache.http.conn.ssl.SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r0.setHostnameVerifier(r1);	 Catch:{ MalformedURLException -> 0x03a8, UnsupportedEncodingException -> 0x0181, ProtocolException -> 0x01fd, IOException -> 0x0279, all -> 0x02f5 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setReadTimeout(r1);	 Catch:{ MalformedURLException -> 0x03ad, UnsupportedEncodingException -> 0x0390, ProtocolException -> 0x0378, IOException -> 0x0360, all -> 0x034c }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectTimeout(r1);	 Catch:{ MalformedURLException -> 0x03ad, UnsupportedEncodingException -> 0x0390, ProtocolException -> 0x0378, IOException -> 0x0360, all -> 0x034c }
        r1 = "GET";
        r0.setRequestMethod(r1);	 Catch:{ MalformedURLException -> 0x03ad, UnsupportedEncodingException -> 0x0390, ProtocolException -> 0x0378, IOException -> 0x0360, all -> 0x034c }
        r1 = "accept";
        r2 = "*/*";
        r0.setRequestProperty(r1, r2);	 Catch:{ MalformedURLException -> 0x03ad, UnsupportedEncodingException -> 0x0390, ProtocolException -> 0x0378, IOException -> 0x0360, all -> 0x034c }
        r1 = "connection";
        r2 = "Keep-Alive";
        r0.setRequestProperty(r1, r2);	 Catch:{ MalformedURLException -> 0x03ad, UnsupportedEncodingException -> 0x0390, ProtocolException -> 0x0378, IOException -> 0x0360, all -> 0x034c }
        r1 = r0.getResponseCode();	 Catch:{ MalformedURLException -> 0x03ad, UnsupportedEncodingException -> 0x0390, ProtocolException -> 0x0378, IOException -> 0x0360, all -> 0x034c }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r2) goto L_0x03bd;
    L_0x0069:
        r4 = r0.getInputStream();	 Catch:{ MalformedURLException -> 0x03ad, UnsupportedEncodingException -> 0x0390, ProtocolException -> 0x0378, IOException -> 0x0360, all -> 0x034c }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ MalformedURLException -> 0x03b3, UnsupportedEncodingException -> 0x0396, ProtocolException -> 0x037e, IOException -> 0x0366, all -> 0x0351 }
        r2.<init>();	 Catch:{ MalformedURLException -> 0x03b3, UnsupportedEncodingException -> 0x0396, ProtocolException -> 0x037e, IOException -> 0x0366, all -> 0x0351 }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x039b, ProtocolException -> 0x0383, IOException -> 0x036b, all -> 0x0355 }
    L_0x0076:
        r3 = r4.read(r1);	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x039b, ProtocolException -> 0x0383, IOException -> 0x036b, all -> 0x0355 }
        r6 = -1;
        if (r3 == r6) goto L_0x00bd;
    L_0x007d:
        r6 = 0;
        r2.write(r1, r6, r3);	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x039b, ProtocolException -> 0x0383, IOException -> 0x036b, all -> 0x0355 }
        goto L_0x0076;
    L_0x0082:
        r1 = move-exception;
        r3 = r4;
        r12 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r12;
    L_0x0088:
        r4 = "WXEntryActivity";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x035a }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x035a }
        r7.<init>();	 Catch:{ all -> 0x035a }
        r8 = "doGet=======";
        r7 = r7.append(r8);	 Catch:{ all -> 0x035a }
        r0 = r0.getMessage();	 Catch:{ all -> 0x035a }
        r0 = r7.append(r0);	 Catch:{ all -> 0x035a }
        r0 = r0.toString();	 Catch:{ all -> 0x035a }
        r5[r6] = r0;	 Catch:{ all -> 0x035a }
        C2538c.c(r4, r5);	 Catch:{ all -> 0x035a }
        r0 = "MalformedURLException";
        if (r3 == 0) goto L_0x00b1;
    L_0x00ae:
        r3.close();	 Catch:{ IOException -> 0x013b }
    L_0x00b1:
        if (r1 == 0) goto L_0x00b6;
    L_0x00b3:
        r1.close();	 Catch:{ IOException -> 0x015e }
    L_0x00b6:
        if (r2 == 0) goto L_0x000f;
    L_0x00b8:
        r2.disconnect();
        goto L_0x000f;
    L_0x00bd:
        r2.flush();	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x039b, ProtocolException -> 0x0383, IOException -> 0x036b, all -> 0x0355 }
        r1 = "UTF-8";
        r3 = r2.toString(r1);	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x039b, ProtocolException -> 0x0383, IOException -> 0x036b, all -> 0x0355 }
        r1 = "WXEntryActivity";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x03a1, ProtocolException -> 0x0389, IOException -> 0x0371, all -> 0x0355 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x03a1, ProtocolException -> 0x0389, IOException -> 0x0371, all -> 0x0355 }
        r7.<init>();	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x03a1, ProtocolException -> 0x0389, IOException -> 0x0371, all -> 0x0355 }
        r8 = "response == ";
        r7 = r7.append(r8);	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x03a1, ProtocolException -> 0x0389, IOException -> 0x0371, all -> 0x0355 }
        r7 = r7.append(r3);	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x03a1, ProtocolException -> 0x0389, IOException -> 0x0371, all -> 0x0355 }
        r7 = r7.toString();	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x03a1, ProtocolException -> 0x0389, IOException -> 0x0371, all -> 0x0355 }
        r5[r6] = r7;	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x03a1, ProtocolException -> 0x0389, IOException -> 0x0371, all -> 0x0355 }
        C2538c.b(r1, r5);	 Catch:{ MalformedURLException -> 0x0082, UnsupportedEncodingException -> 0x03a1, ProtocolException -> 0x0389, IOException -> 0x0371, all -> 0x0355 }
        r1 = r3;
    L_0x00e5:
        if (r4 == 0) goto L_0x00ea;
    L_0x00e7:
        r4.close();	 Catch:{ IOException -> 0x00f7 }
    L_0x00ea:
        if (r2 == 0) goto L_0x00ef;
    L_0x00ec:
        r2.close();	 Catch:{ IOException -> 0x0119 }
    L_0x00ef:
        if (r0 == 0) goto L_0x03ba;
    L_0x00f1:
        r0.disconnect();
        r0 = r1;
        goto L_0x000f;
    L_0x00f7:
        r3 = move-exception;
        r4 = "WXEntryActivity";
        r5 = new java.lang.Object[r11];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "doGet=======";
        r6 = r6.append(r7);
        r3 = r3.getMessage();
        r3 = r6.append(r3);
        r3 = r3.toString();
        r5[r10] = r3;
        C2538c.c(r4, r5);
        goto L_0x00ea;
    L_0x0119:
        r2 = move-exception;
        r3 = "WXEntryActivity";
        r4 = new java.lang.Object[r11];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "doGet=======";
        r5 = r5.append(r6);
        r2 = r2.getMessage();
        r2 = r5.append(r2);
        r2 = r2.toString();
        r4[r10] = r2;
        C2538c.c(r3, r4);
        goto L_0x00ef;
    L_0x013b:
        r3 = move-exception;
        r4 = "WXEntryActivity";
        r5 = new java.lang.Object[r11];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "doGet=======";
        r6 = r6.append(r7);
        r3 = r3.getMessage();
        r3 = r6.append(r3);
        r3 = r3.toString();
        r5[r10] = r3;
        C2538c.c(r4, r5);
        goto L_0x00b1;
    L_0x015e:
        r1 = move-exception;
        r3 = "WXEntryActivity";
        r4 = new java.lang.Object[r11];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "doGet=======";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r1 = r1.toString();
        r4[r10] = r1;
        C2538c.c(r3, r4);
        goto L_0x00b6;
    L_0x0181:
        r0 = move-exception;
        r1 = r0;
        r4 = r3;
        r2 = r3;
        r0 = r5;
    L_0x0186:
        r5 = "WXEntryActivity";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x035e }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x035e }
        r8.<init>();	 Catch:{ all -> 0x035e }
        r9 = "doGet=======";
        r8 = r8.append(r9);	 Catch:{ all -> 0x035e }
        r1 = r1.getMessage();	 Catch:{ all -> 0x035e }
        r1 = r8.append(r1);	 Catch:{ all -> 0x035e }
        r1 = r1.toString();	 Catch:{ all -> 0x035e }
        r6[r7] = r1;	 Catch:{ all -> 0x035e }
        C2538c.c(r5, r6);	 Catch:{ all -> 0x035e }
        if (r4 == 0) goto L_0x01ad;
    L_0x01aa:
        r4.close();	 Catch:{ IOException -> 0x01b9 }
    L_0x01ad:
        if (r3 == 0) goto L_0x01b2;
    L_0x01af:
        r3.close();	 Catch:{ IOException -> 0x01db }
    L_0x01b2:
        if (r2 == 0) goto L_0x000f;
    L_0x01b4:
        r2.disconnect();
        goto L_0x000f;
    L_0x01b9:
        r1 = move-exception;
        r4 = "WXEntryActivity";
        r5 = new java.lang.Object[r11];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "doGet=======";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r5[r10] = r1;
        C2538c.c(r4, r5);
        goto L_0x01ad;
    L_0x01db:
        r1 = move-exception;
        r3 = "WXEntryActivity";
        r4 = new java.lang.Object[r11];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "doGet=======";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r1 = r1.toString();
        r4[r10] = r1;
        C2538c.c(r3, r4);
        goto L_0x01b2;
    L_0x01fd:
        r0 = move-exception;
        r1 = r0;
        r4 = r3;
        r2 = r3;
        r0 = r5;
    L_0x0202:
        r5 = "WXEntryActivity";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x035e }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x035e }
        r8.<init>();	 Catch:{ all -> 0x035e }
        r9 = "doGet=======";
        r8 = r8.append(r9);	 Catch:{ all -> 0x035e }
        r1 = r1.getMessage();	 Catch:{ all -> 0x035e }
        r1 = r8.append(r1);	 Catch:{ all -> 0x035e }
        r1 = r1.toString();	 Catch:{ all -> 0x035e }
        r6[r7] = r1;	 Catch:{ all -> 0x035e }
        C2538c.c(r5, r6);	 Catch:{ all -> 0x035e }
        if (r4 == 0) goto L_0x0229;
    L_0x0226:
        r4.close();	 Catch:{ IOException -> 0x0235 }
    L_0x0229:
        if (r3 == 0) goto L_0x022e;
    L_0x022b:
        r3.close();	 Catch:{ IOException -> 0x0257 }
    L_0x022e:
        if (r2 == 0) goto L_0x000f;
    L_0x0230:
        r2.disconnect();
        goto L_0x000f;
    L_0x0235:
        r1 = move-exception;
        r4 = "WXEntryActivity";
        r5 = new java.lang.Object[r11];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "doGet=======";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r5[r10] = r1;
        C2538c.c(r4, r5);
        goto L_0x0229;
    L_0x0257:
        r1 = move-exception;
        r3 = "WXEntryActivity";
        r4 = new java.lang.Object[r11];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "doGet=======";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r1 = r1.toString();
        r4[r10] = r1;
        C2538c.c(r3, r4);
        goto L_0x022e;
    L_0x0279:
        r0 = move-exception;
        r1 = r0;
        r4 = r3;
        r2 = r3;
        r0 = r5;
    L_0x027e:
        r5 = "WXEntryActivity";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x035e }
        r7 = 0;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x035e }
        r8.<init>();	 Catch:{ all -> 0x035e }
        r9 = "doGet=======";
        r8 = r8.append(r9);	 Catch:{ all -> 0x035e }
        r1 = r1.getMessage();	 Catch:{ all -> 0x035e }
        r1 = r8.append(r1);	 Catch:{ all -> 0x035e }
        r1 = r1.toString();	 Catch:{ all -> 0x035e }
        r6[r7] = r1;	 Catch:{ all -> 0x035e }
        C2538c.c(r5, r6);	 Catch:{ all -> 0x035e }
        if (r4 == 0) goto L_0x02a5;
    L_0x02a2:
        r4.close();	 Catch:{ IOException -> 0x02b1 }
    L_0x02a5:
        if (r3 == 0) goto L_0x02aa;
    L_0x02a7:
        r3.close();	 Catch:{ IOException -> 0x02d3 }
    L_0x02aa:
        if (r2 == 0) goto L_0x000f;
    L_0x02ac:
        r2.disconnect();
        goto L_0x000f;
    L_0x02b1:
        r1 = move-exception;
        r4 = "WXEntryActivity";
        r5 = new java.lang.Object[r11];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "doGet=======";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r5[r10] = r1;
        C2538c.c(r4, r5);
        goto L_0x02a5;
    L_0x02d3:
        r1 = move-exception;
        r3 = "WXEntryActivity";
        r4 = new java.lang.Object[r11];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "doGet=======";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r1 = r1.toString();
        r4[r10] = r1;
        C2538c.c(r3, r4);
        goto L_0x02aa;
    L_0x02f5:
        r0 = move-exception;
        r4 = r3;
        r2 = r3;
    L_0x02f8:
        if (r4 == 0) goto L_0x02fd;
    L_0x02fa:
        r4.close();	 Catch:{ IOException -> 0x0308 }
    L_0x02fd:
        if (r3 == 0) goto L_0x0302;
    L_0x02ff:
        r3.close();	 Catch:{ IOException -> 0x032a }
    L_0x0302:
        if (r2 == 0) goto L_0x0307;
    L_0x0304:
        r2.disconnect();
    L_0x0307:
        throw r0;
    L_0x0308:
        r1 = move-exception;
        r4 = "WXEntryActivity";
        r5 = new java.lang.Object[r11];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "doGet=======";
        r6 = r6.append(r7);
        r1 = r1.getMessage();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r5[r10] = r1;
        C2538c.c(r4, r5);
        goto L_0x02fd;
    L_0x032a:
        r1 = move-exception;
        r3 = "WXEntryActivity";
        r4 = new java.lang.Object[r11];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "doGet=======";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r1 = r1.toString();
        r4[r10] = r1;
        C2538c.c(r3, r4);
        goto L_0x0302;
    L_0x034c:
        r1 = move-exception;
        r4 = r3;
        r2 = r0;
        r0 = r1;
        goto L_0x02f8;
    L_0x0351:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x02f8;
    L_0x0355:
        r1 = move-exception;
        r3 = r2;
        r2 = r0;
        r0 = r1;
        goto L_0x02f8;
    L_0x035a:
        r0 = move-exception;
        r4 = r3;
        r3 = r1;
        goto L_0x02f8;
    L_0x035e:
        r0 = move-exception;
        goto L_0x02f8;
    L_0x0360:
        r1 = move-exception;
        r4 = r3;
        r2 = r0;
        r0 = r5;
        goto L_0x027e;
    L_0x0366:
        r1 = move-exception;
        r2 = r0;
        r0 = r5;
        goto L_0x027e;
    L_0x036b:
        r1 = move-exception;
        r3 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x027e;
    L_0x0371:
        r1 = move-exception;
        r12 = r2;
        r2 = r0;
        r0 = r3;
        r3 = r12;
        goto L_0x027e;
    L_0x0378:
        r1 = move-exception;
        r4 = r3;
        r2 = r0;
        r0 = r5;
        goto L_0x0202;
    L_0x037e:
        r1 = move-exception;
        r2 = r0;
        r0 = r5;
        goto L_0x0202;
    L_0x0383:
        r1 = move-exception;
        r3 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x0202;
    L_0x0389:
        r1 = move-exception;
        r12 = r2;
        r2 = r0;
        r0 = r3;
        r3 = r12;
        goto L_0x0202;
    L_0x0390:
        r1 = move-exception;
        r4 = r3;
        r2 = r0;
        r0 = r5;
        goto L_0x0186;
    L_0x0396:
        r1 = move-exception;
        r2 = r0;
        r0 = r5;
        goto L_0x0186;
    L_0x039b:
        r1 = move-exception;
        r3 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x0186;
    L_0x03a1:
        r1 = move-exception;
        r12 = r2;
        r2 = r0;
        r0 = r3;
        r3 = r12;
        goto L_0x0186;
    L_0x03a8:
        r0 = move-exception;
        r1 = r3;
        r2 = r3;
        goto L_0x0088;
    L_0x03ad:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r3;
        goto L_0x0088;
    L_0x03b3:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r3;
        r3 = r4;
        goto L_0x0088;
    L_0x03ba:
        r0 = r1;
        goto L_0x000f;
    L_0x03bd:
        r2 = r3;
        r4 = r3;
        r1 = r5;
        goto L_0x00e5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.bone.wxapi.WXEntryActivity.a(java.lang.String):java.lang.String");
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C2538c.b("WXEntryActivity", new Object[]{" onNewIntent() intent=", intent});
        setIntent(intent);
        if (this.f22918b != null) {
            this.f22918b.handleIntent(intent, this);
        }
    }
}
