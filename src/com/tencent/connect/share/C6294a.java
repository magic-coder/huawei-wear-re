package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.C6245a;
import com.tencent.connect.p193b.C6284w;
import com.tencent.connect.p531a.C6244a;
import com.tencent.open.C6371a;
import com.tencent.open.p532d.C6295g;
import com.tencent.open.p532d.C6392d;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6406s;
import com.tencent.open.p532d.C6407t;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import com.tencent.open.p542b.C6375d;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;
import java.io.File;

/* compiled from: ProGuard */
public class C6294a extends C6245a {
    public String f21880a = "";

    /* compiled from: ProGuard */
    final class C62921 extends Handler {
        final /* synthetic */ C6295g f21878a;

        C62921(Looper looper, C6295g c6295g) {
            this.f21878a = c6295g;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 101:
                    this.f21878a.mo5300a(0, (String) message.obj);
                    return;
                case 102:
                    this.f21878a.mo5300a(message.arg1, null);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* compiled from: ProGuard */
    final class C62933 extends Handler {
        final /* synthetic */ C6295g f21879a;

        C62933(Looper looper, C6295g c6295g) {
            this.f21879a = c6295g;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 101:
                    this.f21879a.mo5301a(0, message.getData().getStringArrayList("images"));
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    public C6294a(Context context, C6284w c6284w) {
        super(c6284w);
    }

    public void m28886a(Activity activity, Bundle bundle, C6252b c6252b) {
        C6367n.m29110c("openSDK_LOG.QQShare", "shareToQQ() -- start.");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        String string4 = bundle.getString("targetUrl");
        String string5 = bundle.getString("imageLocalUrl");
        int i = bundle.getInt("req_type", 1);
        C6367n.m29110c("openSDK_LOG.QQShare", "shareToQQ -- type: " + i);
        switch (i) {
            case 1:
                this.f21880a = "1";
                break;
            case 2:
                this.f21880a = "3";
                break;
            case 5:
                this.f21880a = "2";
                break;
            case 6:
                this.f21880a = "4";
                break;
        }
        if (i == 6) {
            if (C6406s.m29225c(activity, "5.0.0") < 0) {
                c6252b.mo5287a(new C6494d(-15, "手Q版本过低，应用分享只支持手Q5.0及其以上版本", null));
                C6367n.m29112e("openSDK_LOG.QQShare", "shareToQQ, app share is not support below qq5.0.");
                C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, app share is not support below qq5.0.");
                return;
            }
            string4 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", new Object[]{this.c.m28849b(), "mqq"});
            bundle.putString("targetUrl", string4);
        }
        if (C6412y.m29253b() || C6406s.m29225c(activity, "4.5.0") >= 0) {
            if (i == 5) {
                if (C6406s.m29225c(activity, "4.3.0") < 0) {
                    c6252b.mo5287a(new C6494d(-6, "低版本手Q不支持该项功能!", null));
                    C6367n.m29112e("openSDK_LOG.QQShare", "shareToQQ, version below 4.3 is not support.");
                    C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, version below 4.3 is not support.");
                    return;
                } else if (!C6412y.m29267i(string5)) {
                    c6252b.mo5287a(new C6494d(-6, "非法的图片地址!", null));
                    C6367n.m29112e("openSDK_LOG.QQShare", "shareToQQ -- error: 非法的图片地址!");
                    C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "非法的图片地址!");
                    return;
                }
            }
            if (i != 5) {
                if (TextUtils.isEmpty(string4) || !(string4.startsWith("http://") || string4.startsWith("https://"))) {
                    c6252b.mo5287a(new C6494d(-6, "传入参数有误!", null));
                    C6367n.m29112e("openSDK_LOG.QQShare", "shareToQQ, targetUrl is empty or illegal..");
                    C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, targetUrl is empty or illegal..");
                    return;
                } else if (TextUtils.isEmpty(string2)) {
                    c6252b.mo5287a(new C6494d(-6, "title不能为空!", null));
                    C6367n.m29112e("openSDK_LOG.QQShare", "shareToQQ, title is empty.");
                    C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, title is empty.");
                    return;
                }
            }
            if (TextUtils.isEmpty(string) || string.startsWith("http://") || string.startsWith("https://") || new File(string).exists()) {
                if (!TextUtils.isEmpty(string2) && string2.length() > 45) {
                    bundle.putString("title", C6412y.m29242a(string2, 45, null, null));
                }
                if (!TextUtils.isEmpty(string3) && string3.length() > 60) {
                    bundle.putString("summary", C6412y.m29242a(string3, 60, null, null));
                }
                if (C6412y.m29248a((Context) activity)) {
                    m28882b(activity, bundle, c6252b);
                } else {
                    new C6371a(activity, "", m28705a(""), null, this.c).show();
                }
                C6367n.m29110c("openSDK_LOG.QQShare", "shareToQQ() -- end.");
                return;
            }
            c6252b.mo5287a(new C6494d(-6, "非法的图片地址!", null));
            C6367n.m29112e("openSDK_LOG.QQShare", " shareToQQ, image url is emprty or illegal.");
            C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, image url is emprty or illegal.");
            return;
        }
        c6252b.mo5287a(new C6494d(-6, "分享图片失败，检测不到SD卡!", null));
        C6367n.m29112e("openSDK_LOG.QQShare", "shareToQQ sdcard is null--end");
        C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ sdcard is null");
    }

    private void m28882b(Activity activity, Bundle bundle, C6252b c6252b) {
        C6367n.m29110c("openSDK_LOG", "shareToMobileQQ() -- start.");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        C6367n.m29107b("openSDK_LOG.QQShare", "shareToMobileQQ -- imageUrl: " + string);
        if (TextUtils.isEmpty(string)) {
            m28883c(activity, bundle, c6252b);
        } else if (!C6412y.m29265g(string)) {
            bundle.putString("imageUrl", null);
            if (C6406s.m29225c(activity, "4.3.0") < 0) {
                C6367n.m29107b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                m28883c(activity, bundle, c6252b);
            } else {
                C6367n.m29107b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0 ");
                C6300f.m28904a((Context) activity, string, new C6297c(this, bundle, string2, string3, c6252b, activity));
            }
        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            if (c6252b != null) {
                c6252b.mo5287a(new C6494d(-6, "分享图片失败，检测不到SD卡!", null));
                C6367n.m29112e("openSDK_LOG.QQShare", "分享图片失败，检测不到SD卡!");
            }
            C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享图片失败，检测不到SD卡!");
            return;
        } else if (C6406s.m29225c(activity, "4.3.0") >= 0) {
            m28883c(activity, bundle, c6252b);
        } else {
            new C6392d(activity).m29182a(string, new C6296b(this, bundle, string2, string3, c6252b, activity));
        }
        C6367n.m29110c("openSDK_LOG", "shareToMobileQQ() -- end");
    }

    private void m28883c(Activity activity, Bundle bundle, C6252b c6252b) {
        C6367n.m29110c("openSDK_LOG", "doShareToQQ() -- start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
        Object string = bundle.getString("imageUrl");
        Object string2 = bundle.getString("title");
        Object string3 = bundle.getString("summary");
        Object string4 = bundle.getString("targetUrl");
        Object string5 = bundle.getString("audio_url");
        int i = bundle.getInt("req_type", 1);
        int i2 = bundle.getInt("cflag", 0);
        Object string6 = bundle.getString("share_qq_ext_str");
        String b = C6412y.m29251b((Context) activity);
        if (b == null) {
            b = bundle.getString(QuickPayUtil.STR_SOURCE_PKG_PARAM);
        }
        Object string7 = bundle.getString("imageLocalUrl");
        Object b2 = this.c.m28849b();
        String d = this.c.m28852d();
        C6367n.m29104a("openSDK_LOG.QQShare", "doShareToQQ -- openid: " + d);
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&image_url=" + Base64.encodeToString(C6412y.m29269k(string), 2));
        }
        if (!TextUtils.isEmpty(string7)) {
            stringBuffer.append("&file_data=" + Base64.encodeToString(C6412y.m29269k(string7), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&title=" + Base64.encodeToString(C6412y.m29269k(string2), 2));
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&description=" + Base64.encodeToString(C6412y.m29269k(string3), 2));
        }
        if (!TextUtils.isEmpty(b2)) {
            stringBuffer.append("&share_id=" + b2);
        }
        if (!TextUtils.isEmpty(string4)) {
            stringBuffer.append("&url=" + Base64.encodeToString(C6412y.m29269k(string4), 2));
        }
        if (!TextUtils.isEmpty(b)) {
            if (b.length() > 20) {
                b = b.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(C6412y.m29269k(b), 2));
        }
        if (!TextUtils.isEmpty(d)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(C6412y.m29269k(d), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(C6412y.m29269k(string5), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(C6412y.m29269k(String.valueOf(i)), 2));
        if (!TextUtils.isEmpty(string6)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(C6412y.m29269k(string6), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(C6412y.m29269k(String.valueOf(i2)), 2));
        C6367n.m29104a("openSDK_LOG.QQShare", "doShareToQQ -- url: " + stringBuffer.toString());
        C6244a.m28698a(C6395h.m29184a(), this.c, "requireApi", "shareToNativeQQ");
        this.e = new Intent("android.intent.action.VIEW");
        this.e.setData(Uri.parse(stringBuffer.toString()));
        this.e.putExtra("pkg_name", activity.getPackageName());
        if (C6406s.m29225c(activity, "4.6.0") < 0) {
            C6367n.m29110c("openSDK_LOG.QQShare", "doShareToQQ, qqver below 4.6.");
            if (m28715e()) {
                m28709a(activity, c6252b);
            }
        } else {
            if (C6407t.m29227a("shareToQQ", c6252b) != null) {
                C6367n.m29110c("openSDK_LOG.QQShare", "doShareToQQ, last listener is not null, cancel it.");
            }
            if (m28715e()) {
                AssistActivity.f21862a = true;
                m28707a(activity, 10103);
            }
        }
        if (m28715e()) {
            C6375d.m29144a().m29148a(this.c.m28852d(), this.c.m28849b(), "ANDROIDQQ.SHARETOQQ.XX", WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD, "3", "0", this.f21880a, "0", "1", "0");
            C6375d.m29144a().m29145a(0, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            C6375d.m29144a().m29148a(this.c.m28852d(), this.c.m28849b(), "ANDROIDQQ.SHARETOQQ.XX", WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD, "3", "1", this.f21880a, "0", "1", "0");
            C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        C6367n.m29110c("openSDK_LOG", "doShareToQQ() --end");
    }

    public void mo5289a() {
        C6407t.m29228b("shareToQQ");
    }

    public void mo5290a(Activity activity, int i, int i2, Intent intent) {
    }
}
