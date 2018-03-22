package com.huawei.hwversionmgr.utils.p084b;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.huawei.hwversionmgr.p079a.C5375d;
import com.huawei.hwversionmgr.utils.e;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ConvertJsonToStreamUtil */
public class C5388k {
    public static OutputStream m25921a(Context context, String str) {
        C2538c.c("ConvertJsonToStreamUtil", new Object[]{"convertVersionFilterJsonToStream JSON begin"});
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C5375d a = C5387j.m25909a(context, str);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("FingerPrint", a.f19122a);
            jSONObject2.put("DeviceName", a.f19123b);
            jSONObject2.put("FirmWare", a.f19124c);
            jSONObject2.put("IMEI", a.f19125d);
            jSONObject2.put("IMSI", a.f19126e);
            jSONObject2.put("Language", a.f19127f);
            jSONObject2.put("OS", a.f19128g);
            jSONObject2.put("C_version", a.f19129h);
            jSONObject2.put("D_version", a.f19130i);
            if (com.huawei.hwversionmgr.utils.c.a(context)) {
                jSONObject2.put("HotaVersion", a.f19135n);
            }
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("PackageName", a.f19131j);
            jSONObject3.put("PackageVersionCode", a.f19132k);
            jSONObject3.put("PackageVersionName", a.f19133l);
            jSONObject3.put("sign", a.f19134m);
            jSONArray.put(jSONObject3);
            jSONObject.put("components", jSONArray);
            jSONObject.putOpt("rules", jSONObject2);
            try {
                byteArrayOutputStream.write(jSONObject.toString().getBytes(GameManager.DEFAULT_CHARSET));
                byteArrayOutputStream.flush();
            } catch (IOException e) {
                C2538c.e("ConvertJsonToStreamUtil", new Object[]{"convertVersionFilterJsonToStream, IOException" + e.getMessage()});
            }
        } catch (JSONException e2) {
            C2538c.e("ConvertJsonToStreamUtil", new Object[]{"convertVersionFilterJsonToStream, JSONException" + e2.getMessage()});
        } catch (Exception e3) {
            C2538c.e("ConvertJsonToStreamUtil", new Object[]{"convertVersionFilterJsonToStream, Exception" + e3.getMessage()});
        }
        return byteArrayOutputStream;
    }

    public static OutputStream m25920a(Context context, PackageInfo packageInfo, String str) {
        C2538c.c("ConvertJsonToStreamUtil", new Object[]{"convertVersionFilterJsonToStream(bone) begin"});
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C5375d a = C5387j.m25909a(context, packageInfo.packageName);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("FingerPrint", a.f19122a);
            jSONObject2.put("DeviceName", a.f19123b);
            jSONObject2.put("FirmWare", a.f19124c);
            jSONObject2.put("IMEI", str);
            jSONObject2.put("Language", a.f19127f);
            jSONObject2.put("OS", a.f19128g);
            jSONObject2.put("C_version", a.f19129h);
            jSONObject2.put("D_version", a.f19130i);
            if (com.huawei.hwversionmgr.utils.c.a(context)) {
                jSONObject2.put("HotaVersion", a.f19135n);
            }
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            C2538c.c("ConvertJsonToStreamUtil", new Object[]{"convertVersionFilterJsonToStream(PackageInfo) pi.packageName = " + packageInfo.packageName});
            if (WeChat.HEALTH_PACKAGE_NAME.equals(packageInfo.packageName)) {
                jSONObject3.put("PackageName", a.f19131j);
                jSONObject3.put("PackageVersionCode", String.valueOf(a.f19132k));
                jSONObject3.put("PackageVersionName", String.valueOf(a.f19133l));
            } else {
                jSONObject3.put("PackageName", packageInfo.packageName);
                jSONObject3.put("PackageVersionCode", String.valueOf(packageInfo.versionCode));
                jSONObject3.put("PackageVersionName", packageInfo.versionName);
            }
            if (!(packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null)) {
                jSONObject3.put("sign", e.b(packageInfo.signatures[0].toCharsString()));
            }
            jSONArray.put(jSONObject3);
            jSONObject.put("components", jSONArray);
            jSONObject.putOpt("rules", jSONObject2);
            try {
                byteArrayOutputStream.write(jSONObject.toString().getBytes(GameManager.DEFAULT_CHARSET));
                byteArrayOutputStream.flush();
            } catch (IOException e) {
                C2538c.c("ConvertJsonToStreamUtil", new Object[]{"convertVersionFilterJsonToStream(bone) IOException=" + e.getMessage()});
            }
        } catch (JSONException e2) {
            C2538c.c("ConvertJsonToStreamUtil", new Object[]{"convertVersionFilterJsonToStream(bone), JSONException=" + e2.getMessage()});
        } catch (Exception e3) {
            C2538c.c("ConvertJsonToStreamUtil", new Object[]{"convertVersionFilterJsonToStream(bone), Exception=" + e3.getMessage()});
        }
        C2538c.c("ConvertJsonToStreamUtil", new Object[]{"convertVersionFilterJsonToStream(bone) leave"});
        return byteArrayOutputStream;
    }
}
