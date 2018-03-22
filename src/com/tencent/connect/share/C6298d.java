package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetail;
import com.tencent.connect.common.C6245a;
import com.tencent.connect.p193b.C6284w;
import com.tencent.connect.p531a.C6244a;
import com.tencent.open.C6371a;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6406s;
import com.tencent.open.p532d.C6407t;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import com.tencent.open.p542b.C6375d;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;
import java.net.URLEncoder;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class C6298d extends C6245a {
    public String f21893a = "";
    private boolean f21894l = true;
    private boolean f21895m = false;
    private boolean f21896n = false;
    private boolean f21897o = false;

    public C6298d(Context context, C6284w c6284w) {
        super(c6284w);
    }

    public void m28897a(Activity activity, Bundle bundle, C6252b c6252b) {
        C6367n.m29110c("openSDK_LOG", "shareToQzone() -- start");
        if (bundle == null) {
            c6252b.mo5287a(new C6494d(-6, "传入参数不可以为空", null));
            C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "传入参数不可以为空");
            return;
        }
        String string = bundle.getString("title");
        String string2 = bundle.getString("summary");
        String string3 = bundle.getString("targetUrl");
        ArrayList stringArrayList = bundle.getStringArrayList("imageUrl");
        Object b = C6412y.m29251b((Context) activity);
        if (b == null) {
            b = bundle.getString(QuickPayUtil.STR_SOURCE_PKG_PARAM);
        } else if (b.length() > 20) {
            b = b.substring(0, 20) + "...";
        }
        int i = bundle.getInt("req_type");
        switch (i) {
            case 1:
                this.f21893a = "1";
                break;
            case 5:
                this.f21893a = "2";
                break;
            case 6:
                this.f21893a = "4";
                break;
            default:
                this.f21893a = "1";
                break;
        }
        String str;
        switch (i) {
            case 1:
                this.f21894l = true;
                this.f21895m = false;
                this.f21896n = true;
                this.f21897o = false;
                str = string3;
                string3 = string;
                string = str;
                break;
            case 5:
                c6252b.mo5287a(new C6494d(-5, "暂不支持纯图片分享到空间，建议使用图文分享", null));
                C6367n.m29112e("openSDK_LOG", "shareToQzone() error--end暂不支持纯图片分享到空间，建议使用图文分享");
                C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 暂不支持纯图片分享到空间，建议使用图文分享");
                return;
            case 6:
                if (C6406s.m29225c(activity, "5.0.0") >= 0) {
                    string3 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", new Object[]{this.c.m28849b(), "mqq"});
                    bundle.putString("targetUrl", string3);
                    str = string3;
                    string3 = string;
                    string = str;
                    break;
                }
                c6252b.mo5287a(new C6494d(-15, "手Q版本过低，应用分享只支持手Q5.0及其以上版本", null));
                C6367n.m29107b("openSDK_LOG", "-->shareToQzone, app share is not support below qq5.0.");
                C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone, app share is not support below qq5.0.");
                return;
            default:
                if (!C6412y.m29263e(string) || !C6412y.m29263e(string2)) {
                    this.f21894l = true;
                } else if (stringArrayList == null || stringArrayList.size() == 0) {
                    string = "来自" + b + "的分享";
                    this.f21894l = true;
                } else {
                    this.f21894l = false;
                }
                this.f21895m = false;
                this.f21896n = true;
                this.f21897o = false;
                str = string3;
                string3 = string;
                Object obj = str;
                break;
        }
        if (C6412y.m29253b() || C6406s.m29225c(activity, "4.5.0") >= 0) {
            String str2;
            if (this.f21894l) {
                if (TextUtils.isEmpty(obj)) {
                    c6252b.mo5287a(new C6494d(-5, "targetUrl为必填项，请补充后分享", null));
                    C6367n.m29112e("openSDK_LOG", "shareToQzone() targetUrl null error--end");
                    C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "targetUrl为必填项，请补充后分享");
                    return;
                } else if (!C6412y.m29265g(obj)) {
                    c6252b.mo5287a(new C6494d(-5, "targetUrl有误", null));
                    C6367n.m29112e("openSDK_LOG", "shareToQzone() targetUrl error--end");
                    C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "targetUrl有误");
                    return;
                }
            }
            if (this.f21895m) {
                bundle.putString("title", "");
                bundle.putString("summary", "");
            } else if (this.f21896n && C6412y.m29263e(string3)) {
                c6252b.mo5287a(new C6494d(-6, "title不能为空!", null));
                C6367n.m29112e("openSDK_LOG", "shareToQzone() title is null--end");
                C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
                return;
            } else {
                if (!C6412y.m29263e(string3) && string3.length() > 200) {
                    bundle.putString("title", C6412y.m29242a(string3, 200, null, null));
                }
                if (!C6412y.m29263e(string2) && string2.length() > HeartRateDetail.HEART_RATE_TYPE_SPORT) {
                    bundle.putString("summary", C6412y.m29242a(string2, (int) HeartRateDetail.HEART_RATE_TYPE_SPORT, null, null));
                }
            }
            if (!TextUtils.isEmpty(b)) {
                bundle.putString(QuickPayUtil.STR_SOURCE_PKG_PARAM, b);
            }
            if (stringArrayList != null && (stringArrayList == null || stringArrayList.size() != 0)) {
                for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                    str2 = (String) stringArrayList.get(i2);
                    if (!(C6412y.m29265g(str2) || C6412y.m29266h(str2))) {
                        stringArrayList.remove(i2);
                    }
                }
                if (stringArrayList.size() == 0) {
                    c6252b.mo5287a(new C6494d(-6, "非法的图片地址!", null));
                    C6367n.m29112e("openSDK_LOG", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                    C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
                    return;
                }
                bundle.putStringArrayList("imageUrl", stringArrayList);
            } else if (this.f21897o) {
                c6252b.mo5287a(new C6494d(-6, "纯图分享，imageUrl 不能为空", null));
                C6367n.m29112e("openSDK_LOG", "shareToQzone() imageUrl is null -- end");
                C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                return;
            }
            if (C6406s.m29225c(activity, "4.6.0") >= 0) {
                C6300f.m28905a((Context) activity, stringArrayList, new C6299e(this, bundle, activity, c6252b));
            } else if (C6406s.m29225c(activity, "4.2.0") < 0 || C6406s.m29225c(activity, "4.6.0") >= 0) {
                new C6371a(activity, "", m28705a(""), null, this.c).show();
            } else {
                C6294a c6294a = new C6294a(activity, this.c);
                if (stringArrayList != null && stringArrayList.size() > 0) {
                    str2 = (String) stringArrayList.get(0);
                    if (i != 5 || C6412y.m29267i(str2)) {
                        bundle.putString("imageLocalUrl", str2);
                    } else {
                        c6252b.mo5287a(new C6494d(-6, "手Q版本过低，纯图分享不支持网路图片", null));
                        C6367n.m29112e("openSDK_LOG", "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                        C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                        return;
                    }
                }
                if (C6406s.m29225c(activity, "4.5.0") >= 0) {
                    bundle.putInt("cflag", 1);
                }
                c6294a.m28886a(activity, bundle, c6252b);
            }
            C6367n.m29110c("openSDK_LOG", "shareToQzone() --end");
            return;
        }
        c6252b.mo5287a(new C6494d(-6, "分享图片失败，检测不到SD卡!", null));
        C6367n.m29112e("openSDK_LOG", "shareToQzone() sdcard is null--end");
        C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享图片失败，检测不到SD卡!");
    }

    private void m28894b(Activity activity, Bundle bundle, C6252b c6252b) {
        C6367n.m29110c("openSDK_LOG", "doshareToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        ArrayList stringArrayList = bundle.getStringArrayList("imageUrl");
        Object string = bundle.getString("title");
        Object string2 = bundle.getString("summary");
        Object string3 = bundle.getString("targetUrl");
        String string4 = bundle.getString("audio_url");
        int i = bundle.getInt("req_type", 1);
        Object string5 = bundle.getString(QuickPayUtil.STR_SOURCE_PKG_PARAM);
        int i2 = bundle.getInt("cflag", 0);
        String string6 = bundle.getString("share_qq_ext_str");
        CharSequence b = this.c.m28849b();
        String d = this.c.m28852d();
        C6367n.m29107b("doshareToQzone", "openId:" + d);
        if (stringArrayList != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int size = stringArrayList.size() > 9 ? 9 : stringArrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                stringBuffer2.append(URLEncoder.encode((String) stringArrayList.get(i3)));
                if (i3 != size - 1) {
                    stringBuffer2.append(";");
                }
            }
            stringBuffer.append("&image_url=" + Base64.encodeToString(C6412y.m29269k(stringBuffer2.toString()), 2));
        }
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&title=" + Base64.encodeToString(C6412y.m29269k(string), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&description=" + Base64.encodeToString(C6412y.m29269k(string2), 2));
        }
        if (!TextUtils.isEmpty(b)) {
            stringBuffer.append("&share_id=" + b);
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&url=" + Base64.encodeToString(C6412y.m29269k(string3), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&app_name=" + Base64.encodeToString(C6412y.m29269k(string5), 2));
        }
        if (!C6412y.m29263e(d)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(C6412y.m29269k(d), 2));
        }
        if (!C6412y.m29263e(string4)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(C6412y.m29269k(string4), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(C6412y.m29269k(String.valueOf(i)), 2));
        if (!C6412y.m29263e(string6)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(C6412y.m29269k(string6), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(C6412y.m29269k(String.valueOf(i2)), 2));
        C6367n.m29107b("doshareToQzone, url: ", stringBuffer.toString());
        C6244a.m28698a(C6395h.m29184a(), this.c, "requireApi", "shareToNativeQQ");
        this.e = new Intent("android.intent.action.VIEW");
        this.e.setData(Uri.parse(stringBuffer.toString()));
        this.e.putExtra("pkg_name", activity.getPackageName());
        if (C6406s.m29225c(activity, "4.6.0") < 0) {
            if (m28715e()) {
                m28709a(activity, c6252b);
            }
            C6367n.m29110c("openSDK_LOG", "doShareToQzone() -- QQ Version is < 4.6.0");
        } else {
            C6367n.m29110c("openSDK_LOG", "doShareToQzone() -- QQ Version is > 4.6.0");
            if (C6407t.m29227a("shareToQzone", c6252b) != null) {
                C6367n.m29110c("openSDK_LOG", "doShareToQzone() -- do listener onCancel()");
            }
            if (m28715e()) {
                m28707a(activity, 10104);
            }
        }
        if (m28715e()) {
            C6375d.m29144a().m29148a(this.c.m28852d(), this.c.m28849b(), "ANDROIDQQ.SHARETOQZ.XX", "11", "3", "0", this.f21893a, "0", "1", "0");
            C6375d.m29144a().m29145a(0, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            C6375d.m29144a().m29148a(this.c.m28852d(), this.c.m28849b(), "ANDROIDQQ.SHARETOQZ.XX", "11", "3", "1", this.f21893a, "0", "1", "0");
            C6375d.m29144a().m29145a(1, "SHARE_CHECK_SDK", "1000", this.c.m28849b(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        C6367n.m29110c("openSDK_LOG", "doShareToQzone() --end");
    }

    public void mo5289a() {
        C6407t.m29228b("shareToQzone");
    }

    public void mo5290a(Activity activity, int i, int i2, Intent intent) {
    }
}
